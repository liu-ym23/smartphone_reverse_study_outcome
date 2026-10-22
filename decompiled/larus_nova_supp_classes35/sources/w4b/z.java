package w4b;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class z extends c0c.b implements c.o {
    public final /* synthetic */ c.o b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<c.o> d;

    public static final class a {
    }

    static {
    }

    @Override // w4b.c.o
    public final String Fc() {
        return this.b.Fc();
    }

    @Override // w4b.c.o
    public final String fe() {
        return this.b.fe();
    }

    @Override // w4b.c.o
    public final String userId() {
        return this.b.userId();
    }

    public z(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<c.o> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), c.o.class), c.o.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (c.o) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        Log.i("PassportDependencyProxy", "preparing PassportDependency");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        c.o r6 = (c.o) e0c.k.b(r4.c(r5), c.o.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
