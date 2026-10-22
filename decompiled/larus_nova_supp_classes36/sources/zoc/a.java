package zoc;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;
import yoc.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends c0c.b implements h {
    public final /* synthetic */ h b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<h> d;

    /* JADX INFO: renamed from: zoc.a$a, reason: collision with other inner class name */
    public static final class C0356a {
    }

    static {
    }

    @Override // yoc.h
    public final void G6() {
        this.b.G6();
    }

    @Override // yoc.h
    public final int c8() {
        return this.b.c8();
    }

    @Override // yoc.h
    public final void ra(yoc.c r2) {
        Intrinsics.checkNotNullParameter(r2, "card");
        this.b.ra(r2);
    }

    @Override // yoc.h
    public final void y2(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        this.b.y2(r2, r3);
    }

    public a(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<h> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), h.class), h.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (h) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r2, g r3) {
        Log.i("FloatingPanelGlobalProxy", "preparing IFloatingPanel");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        h r6 = (h) k.b(r4.c(r5), h.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
