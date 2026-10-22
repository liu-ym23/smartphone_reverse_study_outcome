package job;

import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.keyboard.base.n;
import cya.f;
import cya.g;
import cya.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements g<com.ss.android.lark.keyboard.inputstate.a> {
    public final com.ss.android.lark.keyboard.inputstate.a a;
    public f b;

    public a(com.ss.android.lark.keyboard.inputstate.a r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.a = r2;
    }

    public final void a(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a.l(r2.a);
        this.a.e();
    }

    public final void b(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        f r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r0 = null;
    L6:
        r0.b(r2);
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
        f r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stateRepo");
        r0 = null;
    L6:
        r0.b(r2);
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
