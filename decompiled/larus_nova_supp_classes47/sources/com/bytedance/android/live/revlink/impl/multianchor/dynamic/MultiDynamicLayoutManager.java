package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiDynamicLayoutManager {
    public final CompositeDisposable a;
    public i b;
    public final MultiDynamicLayoutManager$windowStatusObserver$1 c;
    public final x51.a d;
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d e;
    public final Function0<Unit> f;

    public static final class a {
    }

    static {
    }

    public final void a(com.bytedance.android.live.revlink.impl.lynxcontainer.b r13, zy0.b r14) {
        Intrinsics.checkNotNullParameter(r13, "lynxViewParams");
        i r0 = this.b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r13.q() <= 0) goto L8;
        int r1 = com.bytedance.android.live.revenue.common.i.b(r13.q());
    L9:
        int r3 = r1;
        if (r13.a() <= 0) goto L12;
        int r2 = com.bytedance.android.live.revenue.common.i.b(r13.a());
    L13:
        int r4 = r2;
        if (r13.h() <= 0) goto L16;
        int r5 = com.bytedance.android.live.revenue.common.i.b(r13.h());
    L18:
        if (r13.l() <= 0) goto L20;
        int r6 = com.bytedance.android.live.revenue.common.i.b(r13.l());
    L22:
        if (r13.j() <= 0) goto L24;
        int r7 = com.bytedance.android.live.revenue.common.i.b(r13.j());
    L26:
        if (r13.f() <= 0) goto L28;
        int r8 = com.bytedance.android.live.revenue.common.i.b(r13.f());
    L29:
        int r9 = r0.c;
        int r10 = r0.a + r9;
        int r12 = r13.c();
        if (r12 == 2) goto L34;
        if (r12 == 3) goto L33;
        int r15 = r9 + r5;
    L35:
        int r16 = r15;
    L36:
        int r17 = r0.d;
        int r18 = r0.b + r17;
        int r19 = r13.p();
        if (r19 == 2) goto L41;
        if (r19 == 3) goto L40;
        int r20 = r17 + r6;
    L42:
        int r22 = r20;
    L43:
        i r23 = new i(r3, r4, r16, r22, r13.s());
        jy0.b.d("MultiDynamicLayoutManager", "updateLynxViewLayout lynxViewParams " + r13);
        jy0.b.d("MultiDynamicLayoutManager", "updateLynxViewLayout " + r23 + ", anchorLayout: " + r0);
        this.d.b(r23, r14, r13.o());
        return;
    L40:
        r22 = (r18 - r8) - r4;
        goto L43
    L41:
        r20 = r17 + (((r18 - r17) - r4) / 2);
        goto L42
    L33:
        r16 = (r10 - r7) - r3;
        goto L36
    L34:
        r15 = r9 + (((r10 - r9) - r3) / 2);
        goto L35
    L28:
        r8 = (int) (r13.g() * r0.b);
        goto L29
    L24:
        r7 = (int) (r13.k() * r0.a);
        goto L26
    L20:
        r6 = (int) (r13.m() * r0.b);
        goto L22
    L16:
        r5 = (int) (r13.i() * r0.a);
        goto L18
    L12:
        r2 = (int) (r13.b() * r0.b);
        goto L13
    L8:
        r1 = (int) (r13.r() * r0.a);
        goto L9
    }

    public MultiDynamicLayoutManager(x51.a r2, com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "linkLynxCentralService");
        Intrinsics.checkNotNullParameter(r4, "notifyLayoutUpdate");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = new CompositeDisposable();
        this.c = new MultiDynamicLayoutManager$windowStatusObserver$1(this);
    }
}
