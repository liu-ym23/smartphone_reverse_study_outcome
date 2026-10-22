package oeb;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends c0c.b implements d {
    public final /* synthetic */ d b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<d> d;

    @Override // oeb.d
    public final boolean get() {
        return this.b.get();
    }

    @Override // oeb.d
    public void update(boolean r2) {
        this.b.update(r2);
    }

    public c(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<d> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), d.class), d.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (d) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r1, g r2) {
        v r3 = this.c;
        if (r2 == null) goto L6;
        UserSession r4 = r2.b;
        if (r4 == null) goto L6;
    L7:
        d r5 = (d) k.b(r3.c(r4), d.class);
        this.d.e(r5);
        return;
    L6:
        r4 = ContainerConstsKt.a();
        goto L7
    }
}
