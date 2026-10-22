package vsb;

import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends c0c.b implements rsb.b {
    public final /* synthetic */ rsb.b b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<rsb.b> d;

    @Override // rsb.b
    public final void P4() {
        this.b.P4();
    }

    @Override // rsb.b, rsb.a.InterfaceC0324a
    public final void k0(int r2, List<String> r3) {
        this.b.k0(Target.SIZE_ORIGINAL, null);
    }

    public d(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<rsb.b> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), rsb.b.class), rsb.b.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (rsb.b) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void pf(g r1, f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "toState");
        v r3 = this.c;
        g r4 = r2.a();
        if (r4 == null) goto L6;
        UserSession r5 = r4.b;
        if (r5 == null) goto L6;
    L7:
        rsb.b r6 = (rsb.b) k.b(r3.c(r5), rsb.b.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
