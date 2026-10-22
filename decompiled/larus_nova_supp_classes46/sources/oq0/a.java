package oq0;

import android.content.Context;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.ies.utility.SharedPrefHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final SharedPrefHelper a;

    /* JADX INFO: renamed from: oq0.a$a, reason: collision with other inner class name */
    public static final class C0250a {
    }

    static {
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = SharedPrefHelper.c(r2, "openplatform_audience_high_intention_sp");
    }

    public final b a(String r5) {
        b r6 = (b) GsonHelper.get().fromJson(this.a.j(r5, ""), b.class);     // Catch: Exception -> L7
        if (r6 != null) goto L11;
        return new b(null);
    L11:
        return r6;
    L8:
        return new b(null);
    }

    public final c b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "recordKey");
        Intrinsics.checkNotNullParameter(r3, "recordId");
        return a(r2).a().get(r3);
    }

    public final void c(String r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r3, "recordKey");
        Intrinsics.checkNotNullParameter(r6, "recordId");
        c r0 = b(r3, r6);
        if (r0 == null) goto L5;
        long r1 = r0.a();
    L6:
        d(r3, r6, r4 + r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void d(String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "recordKey");
        Intrinsics.checkNotNullParameter(r5, "recordId");
        b r0 = a(r4);
        c r1 = r0.a().get(r5);
        if (r1 != null) goto L5;
        r1 = new c(0);
    L5:
        r1.c(r6);
        r1.d(System.currentTimeMillis());
        r0.a().put(r5, r1);
        String r7 = GsonHelper.get().toJson(r0);     // Catch: Exception -> L8
    L9:
        this.a.m(r4, r7);
        return;
    L8:
        r7 = "";
        goto L9
    }
}
