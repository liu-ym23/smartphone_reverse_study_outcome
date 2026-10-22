package z68;

import android.os.SystemClock;
import com.larus.audio.call.f;
import com.larus.flow.capture.model.QualityPreference;
import com.larus.flow.capture.model.StopReason;
import da9.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import q68.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static final c a = null;
    public static final Object b = null;
    public static b c;
    public static z68.a d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[StopReason.values().length];
            r0[StopReason.PERMISSION_REVOKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[StopReason.SOURCE_INTERRUPTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L33:
            r0[StopReason.RUNTIME_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L25:
            r0[StopReason.RTC_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[StopReason.USER_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L9:
            a = r0;
            int[] r1 = new int[QualityPreference.values().length];
            r1[QualityPreference.CLEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L21:
            r1[QualityPreference.FLUENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L12:
            b = r1;
        }
    }

    public c() {
    }

    static {
        a = new c();
        b = new Object();
    }

    public static void b() {
        Object r0 = b;
        monitor-enter(r0);
        c = null;     // Catch: Throwable -> L8
        d = null;     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void c(z68.a r12) {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = r12.i;
        if (r2 != 0) goto L6;
        r12.i = r0;
        return;
    L6:
        long r3 = r0 - r2;
        if (r3 >= 1000) goto L9;
        return;
    L9:
        double r8 = r3;
        g("flow_screen_share_capture_fps", MapsKt.mapOf(new Pair[]{TuplesKt.to("sample_interval_ms", Integer.valueOf((int) r3)), TuplesKt.to("capture_fps", Double.valueOf((((double) r12.j) * 1000.0d) / r8)), TuplesKt.to("output_fps", Double.valueOf((((double) r12.k) * 1000.0d) / r8)), TuplesKt.to("profile", e(r12.e, r12.f, r12.g)), TuplesKt.to("resolution", k(r12.e, r12.f))}));
        r12.i = r0;
        r12.j = 0;
        r12.k = 0;
    }

    public static void i(String r6) {
        Intrinsics.checkNotNullParameter(r6, "startSource");
        e r0 = new e(0);
        Intrinsics.checkNotNullParameter(r6, "startSource");
        Intrinsics.checkNotNullParameter(r0, "policy");
        long r2 = SystemClock.elapsedRealtime();
        Object r4 = b;
        monitor-enter(r4);
        c = new b(r2, r6, r0);     // Catch: Throwable -> L15
        d = null;     // Catch: Throwable -> L15
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r4);
        Pair[] r5 = new Pair[4];
        r5[0] = TuplesKt.to("start_source", r6);
        QualityPreference r1 = r0.a;
        int r7 = a.b[r1.ordinal()];
        if (r7 == 1) goto L12;
        if (r7 != 2) goto L11;
        String r8 = "smoothness";
    L13:
        r5[1] = TuplesKt.to("policy_quality", r8);
        r5[2] = TuplesKt.to("policy_min_fps", Integer.valueOf(r0.b));
        r5[3] = TuplesKt.to("policy_max_fps", Integer.valueOf(r0.c));
        g("flow_screen_share_start", MapsKt.mapOf(r5));
        return;
    L11:
        throw new NoWhenBranchMatchedException();
    L12:
        r8 = "clarity";
    L15:
        th = move-exception;
        throw th;
    }

    public static void g(String r1, Map r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        f.c().h().a(r1, d.c(r2));     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static String k(int r3, int r4) {
        int r5 = Math.min(r3, r4);
        boolean r6 = false;
        if (1080 <= r5) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        return "1080p";
    L11:
        if (720 > r5) goto L14;
        if (r5 >= 1080) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == false) goto L18;
        return "720p";
    L18:
        if (540 > r5) goto L21;
        if (r5 >= 720) goto L21;
        r6 = true;
    L21:
        if (r6 == false) goto L23;
        return "540p";
    L23:
        return "360p";
    L14:
        r1 = false;
        goto L15
    L5:
        if (r5 > Integer.MAX_VALUE) goto L7;
        r2 = true;
        goto L8
    }

    public static String e(int r3, int r4, int r5) {
        if (Intrinsics.areEqual(k(r3, r4), "1080p") == false) goto L7;
        if (r5 < 15) goto L7;
        return "L0";
    L7:
        if (Intrinsics.areEqual(k(r3, r4), "720p") == false) goto L11;
        if (r5 < 15) goto L11;
        return "L1";
    L11:
        if (Intrinsics.areEqual(k(r3, r4), "720p") == false) goto L14;
        return "L2";
    L14:
        if (Intrinsics.areEqual(k(r3, r4), "540p") == false) goto L16;
        return "L3";
    L16:
        return "L4";
    }

    public static void f(String r3, String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "exceptionType");
        Intrinsics.checkNotNullParameter(r4, "reason");
        Intrinsics.checkNotNullParameter(r5, "errorCode");
        Object r0 = b;
        monitor-enter(r0);
        z68.a r1 = d;     // Catch: Throwable -> L13
        monitor-exit(r0);
        LinkedHashMap r7 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("exception_type", r3), TuplesKt.to("reason", r4), TuplesKt.to("error_code", r5), TuplesKt.to("is_fatal", Boolean.valueOf(r6))});
        if (r1 == null) goto L9;
        c r8 = a;
        int r2 = r1.e;
        int r9 = r1.f;
        int r10 = r1.g;
        r8.getClass();
        r7.put("profile", e(r2, r9, r10));
    L9:
        g("flow_screen_share_capture_exception", r7);
        if (r6 == false) goto L18;
        b();
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static void h(String r8, int r9, int r10, int r11) {
        Object r0 = b;
        monitor-enter(r0);
        z68.a r1 = d;     // Catch: Throwable -> L16
        if (r1 != null) goto L9;
        monitor-exit(r0);
        return;
    L9:
        if (r1.h == false) goto L12;
        monitor-exit(r0);
        return;
    L12:
        r1.a = r8;     // Catch: Throwable -> L16
        r1.e = r9;     // Catch: Throwable -> L16
        r1.f = r10;     // Catch: Throwable -> L16
        r1.g = r11;     // Catch: Throwable -> L16
        r1.h = true;     // Catch: Throwable -> L16
        monitor-exit(r0);
        g("flow_screen_share_first_frame", MapsKt.mapOf(new Pair[]{TuplesKt.to("cost_ms", Integer.valueOf((int) (SystemClock.elapsedRealtime() - r1.b))), TuplesKt.to("profile", e(r9, r10, r11)), TuplesKt.to("resolution", k(r9, r10)), TuplesKt.to("target_fps", Integer.valueOf(r11))}));
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static void a(String r12, int r13, int r14, int r15, e r16) {
        Intrinsics.checkNotNullParameter(r16, "policy");
        Object r10 = b;
        monitor-enter(r10);
        b r1 = c;     // Catch: Throwable -> L15
        if (r1 != null) goto L7;
        r1 = new b(SystemClock.elapsedRealtime(), "user_click", r16);     // Catch: Throwable -> L15
    L7:
        monitor-exit(r10);
        monitor-enter(r10);
        d = new z68.a(r12, r1.a, r1.b, r16, r13, r14, r15);     // Catch: Throwable -> L12
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r10);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    public static void d(String r2, int r3, int r4, int r5, boolean r6) {
        Object r0 = b;
        monitor-enter(r0);
        z68.a r1 = d;     // Catch: Throwable -> L14
        if (r1 != null) goto L8;
        monitor-exit(r0);
        return;
    L8:
        r1.a = r2;     // Catch: Throwable -> L14
        r1.e = r3;     // Catch: Throwable -> L14
        r1.f = r4;     // Catch: Throwable -> L14
        r1.g = r5;     // Catch: Throwable -> L14
        if (r6 == true) goto L11;
        r1.k++;     // Catch: Throwable -> L14
    L11:
        a.getClass();     // Catch: Throwable -> L14
        c(r1);     // Catch: Throwable -> L14
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static void j(boolean r14, int r15, int r16, int r17, e r19, String r110, String r20) {
        Intrinsics.checkNotNullParameter(r19, "policy");
        long r10 = SystemClock.elapsedRealtime();
        Object r12 = b;
        monitor-enter(r12);
        b r1 = c;     // Catch: Throwable -> L40
        if (r1 != null) goto L7;
        r1 = new b(r10, "user_click", r19);     // Catch: Throwable -> L40
    L7:
        z68.a r2 = d;     // Catch: Throwable -> L40
        if (r2 != null) goto L11;
        r2 = new z68.a(null, r1.a, r1.b, r19, r15, r16, r17);     // Catch: Throwable -> L40
    L11:
        r2.e = r15;     // Catch: Throwable -> L40
        r2.f = r16;     // Catch: Throwable -> L40
        r2.g = r17;     // Catch: Throwable -> L40
        d = r2;     // Catch: Throwable -> L40
        monitor-exit(r12);
        Pair[] r4 = new Pair[5];
        if (r14 == false) goto L16;
        String r6 = "success";
    L17:
        r4[0] = TuplesKt.to("result", r6);
        r4[1] = TuplesKt.to("start_cost_ms", Integer.valueOf((int) (r10 - r2.b)));
        r4[2] = TuplesKt.to("profile", e(r15, r16, r17));
        r4[3] = TuplesKt.to("resolution", k(r15, r16));
        r4[4] = TuplesKt.to("target_fps", Integer.valueOf(r17));
        LinkedHashMap r0 = MapsKt.linkedMapOf(r4);
        if (r14 == false) goto L20;
    L28:
        g("flow_screen_share_start_result", r0);
        monitor-enter(r12);
        c = null;     // Catch: Throwable -> L37
        if (r14 == true) goto L34;
        d = null;     // Catch: Throwable -> L37
    L34:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r12);
        return;
    L37:
        th = move-exception;
        throw th;
    L20:
        if (r110 != null) goto L22;
        String r5 = "unknown";
    L23:
        r0.put("reason", r5);
        if (r20 != null) goto L26;
        String r7 = "unknown";
    L27:
        r0.put("error_code", r7);
        goto L28
    L26:
        r7 = r20;
        goto L27
    L22:
        r5 = r110;
        goto L23
    L16:
        r6 = "fail";
    L40:
        th = move-exception;
        throw th;
    }
}
