package kv8;

import android.os.SystemClock;
import com.larus.platform.service.o;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final String a;
    public final String b;
    public final long c;
    public C0115a d;
    public boolean e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: kv8.a$a, reason: collision with other inner class name */
    public static final class C0115a {
        public final int a;
        public final long b;
        public String c;
        public boolean d;
        public Long e;
        public String f;
        public c g;

        public final void setResult(String r1) {
            this.c = r1;
        }

        public C0115a(int r1, long r2) {
            this.a = r1;
            this.b = r2;
            this.f = "transport";
        }
    }

    public static final class b {
    }

    public static final class c {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Failure(stage=" + this.a + ", code=" + this.b + ')';
        }

        public c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "stage");
            Intrinsics.checkNotNullParameter(r3, "code");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final void c() {
        if (this.e == false) goto L5;
        return;
    L5:
        d("cancel");
        this.e = true;
        JSONObject r0 = new JSONObject();
        String r1 = this.f;
        if (r1 != null) goto L8;
        r1 = "user_close";
    L8:
        JSONObject r5 = r0.put("reason", r1);
        String r2 = this.g;
        if (r2 == null) goto L12;
        r5.put("complete_result", r2);
    L12:
        if (Intrinsics.areEqual(this.f, "disconnected") == false) goto L18;
        C0115a r3 = this.d;
        if (r3 == null) goto L18;
        c r4 = r3.g;
        if (r4 == null) goto L18;
        r5.put("failed_stage", r4.a).put("error_code", r4.b);
    L18:
        Intrinsics.checkNotNull(r5);
        long r6 = this.c;
        b(this, "browser_takeover_end", r5, Long.valueOf(RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r6, 0)), null, 8);
    }

    public final void f() {
        C0115a r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        Long r1 = r0.e;
        if (r1 == null) goto L16;
        long r2 = r1.longValue();
        if (this.e == false) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r0.c, "success") == true) goto L12;
        return;
    L12:
        if (r0.d == true) goto L19;
        r0.d = true;
        b(this, "browser_takeover_first_frame", null, Long.valueOf(RangesKt.coerceAtLeast(r2 - r0.b, 0)), Integer.valueOf(r0.a), 2);
        return;
    L19:
        return;
    }

    public a(hv8.a r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        this.a = r3.h;
        if ((r3.g instanceof hv8.c.a) == false) goto L5;
        String r4 = "cloud";
    L6:
        this.b = r4;
        this.c = SystemClock.elapsedRealtime();
        this.g = "not_requested";
        return;
    L5:
        r4 = "local_pc";
        goto L6
    }

    public final void d(String r7) {
        C0115a r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.e == false) goto L8;
        return;
    L8:
        if (r0.c != null) goto L18;
        r0.setResult(r7);
        JSONObject r1 = new JSONObject().put("status", r7);
        if (Intrinsics.areEqual(r7, "fail") == false) goto L15;
        c r8 = r0.g;
        if (r8 == null) goto L15;
        r1.put("failed_stage", r8.a).put("error_code", r8.b);
    L15:
        Intrinsics.checkNotNull(r1);
        long r2 = r0.b;
        a("browser_takeover_connect", r1, Long.valueOf(RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r2, 0)), Integer.valueOf(r0.a));
        return;
    }

    public final void g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "stage");
        if (this.e == true) goto L8;
        C0115a r0 = this.d;
        if (r0 == null) goto L9;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.f = r3;
        return;
    L9:
        return;
    }

    public final void e(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "stage");
        Intrinsics.checkNotNullParameter(r4, "code");
        if (this.e == false) goto L5;
        return;
    L5:
        C0115a r0 = this.d;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.g != null) goto L12;
        r0.g = new c(r3, r4);
        return;
    }

    public final void a(String r3, JSONObject r4, Long r5, Integer r6) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        r4.put("target", this.b);     // Catch: Throwable -> L9
        r4.put("takeover_id", this.a);     // Catch: Throwable -> L9
        if (r5 == null) goto L5;
        r4.put("duration_ms", r5.longValue());     // Catch: Throwable -> L9
    L5:
        if (r6 == null) goto L7;
        r4.put("attempt_seq", r6.intValue());     // Catch: Throwable -> L9
    L7:
        o.a.reportEvent(r3, r4);     // Catch: Throwable -> L9
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static /* synthetic */ void b(a r2, String r3, JSONObject r4, Long r5, Integer r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = new JSONObject();
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = null;
    L11:
        r2.a(r3, r4, r5, r6);
    }
}
