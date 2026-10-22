package com.lynx.jsbridge;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.t;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends pm.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9920c;
    public final /* synthetic */ ReadableMap d;
    public final /* synthetic */ LynxIntersectionObserverModule e;

    public /* synthetic */ k(LynxIntersectionObserverModule r5, com.lynx.tasm.behavior.f r10, int r11, ReadableMap r12, int r13) {
        this.f9919b = r13;
        this.e = r5;
        this.f9920c = r11;
        this.d = r12;
        super(r10);
    }

    @Override // pm.g
    public final void a() {
        switch(this.f9919b) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        t r5 = this.e.mLynxContext.i().i(this.f9920c);
        if (r5 == null) goto L12;
        r5.e = null;
        r5.f10371l = true;
        r5.a(this.d);
        return;
    L12:
        return;
    L8:
        t r10 = this.e.mLynxContext.i().i(this.f9920c);
        if (r10 == null) goto L13;
        r10.e = null;
        r10.a(this.d);
        return;
    }
}
