package com.bytedance.android.live.profit.lottery;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.Pair;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LotteryLoaderService implements com.bytedance.android.scope.o, yz0.m {
    public n3 a;
    public Disposable b;
    public final cy0.f c;
    public final yz0.k d;
    public final n01.a e;

    @Override // yz0.m
    public final void i() {
    }

    public final void onStart() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    public final void onStop() {
        com.bytedance.android.scope.j r0 = this.a;
        if (r0 != null) goto L5;
    L10:
        this.a = null;
        this.b.dispose();
        return;
    L5:
        if (com.bytedance.android.scope.l.b(r0) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        com.bytedance.android.scope.l.c(r0);
        goto L10
    }

    @Override // yz0.m
    public final void onViewReady() {
        if (this.d.getRoom().isMediaRoom() == false) goto L6;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L15;
        return;
    L15:
        if (this.a != null) goto L33;
        Pair r0 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        LotteryContext r2 = (LotteryContext) r0.component1();
        Disposable r3 = (Disposable) r0.component2();
        n3 r4 = new n3(this.c);
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r2, "value");
        r4.e = r2;
        Object r5 = e33.k.a;
        if (r2 != r5) goto L20;
        String r6 = "lotteryContext";
    L29:
        if (r6 != null) goto L32;
        this.b = r3;
        com.bytedance.android.scope.l.a(r4);
        Unit r7 = Unit.INSTANCE;
        this.a = r4;
        return;
    L32:
        throw new UninitializedPropertyAccessException(r6);
    L20:
        if (r4.f != r5) goto L23;
        r6 = "revenueInstance";
        goto L29
    L23:
        if (r4.g != r5) goto L26;
        r6 = "revenueInstanceExt";
        goto L29
    L26:
        if (r4.h != r5) goto L28;
        r6 = "roomInstance";
        goto L29
    L28:
        r6 = null;
        goto L29
    L33:
        return;
    L6:
        if (this.e.Fm() == true) goto L11;
        r1 = true;
        if (w2.e().enabled != 1) goto L11;
        goto L11
    }

    public LotteryLoaderService(cy0.f r2, yz0.k r3, n01.a r4) {
        Intrinsics.checkNotNullParameter(r2, "instanceScope");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "vsService");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.b = Disposables.disposed();
    }
}
