package job;

import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.keyboard.base.n;
import cya.f;
import cya.g;
import cya.h;
import cya.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements g<com.ss.android.lark.keyboard.inputstate.a> {
    public final com.ss.android.lark.keyboard.inputstate.a a;
    public f b;

    public c(com.ss.android.lark.keyboard.inputstate.a r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.a = r2;
    }

    public final void a(h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        i r0 = (i) r3.a.a(i.h);
        if (r0 != null) goto L5;
        r0 = i.a.a();
    L5:
        this.a.u(r0);
        this.a.l(r3.a);
        this.a.e();
    }

    public final void b(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a.v();
        g(r2, false);
    }

    public final void c(h r6) {
        Intrinsics.checkNotNullParameter(r6, "state");
        n r0 = this.a.y();
        n.a r1 = cya.a.c;
        cya.a r2 = (cya.a) r0.a(r1);
        n r3 = this.a.y();
        n.a r4 = QueryStatusInfo.Companion;
        QueryStatusInfo r5 = (QueryStatusInfo) r3.a(r4);
        r6.a.b(r1, r2);
        r6.a.b(r4, r5);
    }

    public final void e(f r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void f(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a.v();
        g(r2, false);
    }

    public final void d(h r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        if (r3 != 61441) goto L6;
        g(r2, true);
        return;
    }

    public final void g(h r3, boolean r4) {
        r3.a.b(h.d, Boolean.valueOf(r4));
        f r5 = this.b;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r5 = null;
    L6:
        r5.b(r3);
    }
}
