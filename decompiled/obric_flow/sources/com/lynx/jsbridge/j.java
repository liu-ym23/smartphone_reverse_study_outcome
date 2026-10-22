package com.lynx.jsbridge;

import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.n0;
import com.lynx.tasm.behavior.t;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.w;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends pm.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9916c;
    public final /* synthetic */ String d;
    public final /* synthetic */ ReadableMap e;
    public final /* synthetic */ LynxIntersectionObserverModule f;

    public /* synthetic */ j(LynxIntersectionObserverModule r5, com.lynx.tasm.behavior.f r10, int r11, String r12, ReadableMap r13, int r14) {
        this.f9915b = r14;
        this.f = r5;
        this.f9916c = r11;
        this.d = r12;
        this.e = r13;
        super(r10);
    }

    @Override // pm.g
    public final void a() {
        switch(this.f9915b) {
            case 0: goto L24;
            default: goto L4;
        };
    L4:
        t r5 = this.f.mLynxContext.i().i(this.f9916c);
        if (r5 == null) goto L32;
        String r10 = this.d;
        if (r10.startsWith("#") == false) goto L33;
        LynxBaseUI r11 = null;
        if (r5.c() != null) goto L12;
        LynxLog.b(4, "LynxIntersectionObserver", "relativeTo failed because context is null");
        r5.e = null;
    L17:
        if (r5.e != null) goto L22;
        LynxLog.b(3, "LynxIntersectionObserver", "Can't find element, finding in element");
        if (r5.e() != null) goto L21;
        LynxLog.b(4, "LynxIntersectionObserver", "relativeTo failed because UIOwner is null");
        goto L22
    L21:
        r5.e = r5.e().E(r10.substring(1));
    L22:
        r5.a(this.e);
        return;
    L12:
        LynxContext r12 = r5.c();
        String r13 = r10.substring(1);
        if (((n0) r12.f10147o.get()) == null) goto L15;
        r11 = n0.d(r13, r5.d);
    L15:
        r5.e = r11;
        goto L17
    L33:
        return;
    L32:
        return;
    L24:
        w r14 = this.f.mLynxContext.i();
        int r15 = this.f9916c;
        if (r14.i(r15) != null) goto L34;
        String r16 = this.d;
        if (r16.isEmpty() == false) goto L30;
        r16 = "-1";
    L30:
        t r17 = new t(r14, r15, r16, this.e);
        com.lynx.tasm.utils.j.f(new ab.b(27, r14, false, r17));
        return;
    }
}
