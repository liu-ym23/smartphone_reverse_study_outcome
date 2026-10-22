package job;

import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.base.n;
import com.ss.android.lark.log.Log;
import cya.f;
import cya.g;
import cya.h;
import cya.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements g<com.ss.android.lark.keyboard.inputstate.a> {
    public final com.ss.android.lark.keyboard.inputstate.a a;
    public f b;

    public static final class a {
    }

    static {
    }

    public final void g() {
        h.b r0 = new h.b();
        n r1 = ((h) r0).a;
        r1.b(ReEditInfo.Companion, new ReEditInfo("", 0, false, 6, null));
        r1.b(h.d, Boolean.TRUE);
        f r2 = this.b;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r2 = null;
    L6:
        r2.b(r0);
    }

    public b(com.ss.android.lark.keyboard.inputstate.a r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.a = r2;
    }

    public final void a(h r9) {
        Intrinsics.checkNotNullParameter(r9, "state");
        g();
        this.a.l(r9.a);
        ReEditInfo r0 = (ReEditInfo) r9.a.a(ReEditInfo.Companion);
        if (r0 != null) goto L5;
        r0 = new ReEditInfo("", 0, false, 6, null);
    L5:
        this.a.g(r0, (i) r9.a.a(i.h));
        this.a.e();
    }

    public final void b(h r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        if (Intrinsics.areEqual(r4.a.a(com.ss.android.lark.keyboard.inputstate.b.h), Boolean.TRUE) == false) goto L5;
        Log.i("ReEditStateConsumer", "consumePop: finish reedit mode is true , remove reedit draft");
        g();
    L10:
        this.a.z();
        return;
    L5:
        r4.a.b(h.d, Boolean.FALSE);
        f r0 = this.b;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r0 = null;
    L9:
        r0.b(r4);
        goto L10
    }

    public final void c(h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        n r0 = this.a.y();
        n.a r1 = cya.a.c;
        cya.a r2 = (cya.a) r0.a(r1);
        r3.a.b(r1, r2);
    }

    public final void e(f r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void f(h r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        r4.a.b(h.d, Boolean.FALSE);
        f r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r0 = null;
    L6:
        r0.b(r4);
        this.a.z();
    }

    public final void d(h r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if (r4 != 61441) goto L10;
        r3.a.b(h.d, Boolean.TRUE);
        f r5 = this.b;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r5 = null;
    L8:
        r5.b(r3);
        return;
    }
}
