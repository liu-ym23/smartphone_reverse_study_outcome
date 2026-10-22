package com.lynx.jsbridge;

import com.lynx.tasm.behavior.t;
import com.lynx.tasm.behavior.w;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends pm.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxIntersectionObserverModule f9924c;

    public m(LynxIntersectionObserverModule r5, com.lynx.tasm.behavior.f r10, int r11) {
        this.f9924c = r5;
        this.f9923b = r11;
        super(r10);
    }

    @Override // pm.g
    public final void a() {
        t r5 = this.f9924c.mLynxContext.i().i(this.f9923b);
        if (r5 == null) goto L6;
        r5.f10372m.clear();
        w r10 = (w) r5.f10365b.get();
        r10.getClass();
        com.lynx.tasm.utils.j.f(new com.bytedance.android.anniex.container.i(r5.f10364a, 4, r10));
        return;
    }
}
