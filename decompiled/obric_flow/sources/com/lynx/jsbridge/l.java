package com.lynx.jsbridge;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.n0;
import com.lynx.tasm.behavior.t;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends pm.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f9922c;
    public final /* synthetic */ int d;
    public final /* synthetic */ LynxIntersectionObserverModule e;

    public l(LynxIntersectionObserverModule r5, com.lynx.tasm.behavior.f r10, int r11, String r12, int r13) {
        this.e = r5;
        this.f9921b = r11;
        this.f9922c = r12;
        this.d = r13;
        super(r10);
    }

    @Override // pm.g
    public final void a() {
        t r5 = this.e.mLynxContext.i().i(this.f9921b);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.c() != null) goto L7;
        LynxLog.b(4, "LynxIntersectionObserver", "observe failed because context is null");
        return;
    L7:
        String r10 = this.f9922c;
        LynxBaseUI r11 = null;
        if (r10.startsWith("#") == false) goto L31;
        LynxContext r12 = r5.c();
        String r13 = r10.substring(1);
        if (((n0) r12.f10147o.get()) == null) goto L12;
        r11 = n0.d(r13, r5.d);
    L12:
        if (r11 != null) goto L20;
        LynxLog.b(3, "LynxIntersectionObserver", "Can't find element, finding in element");
        if (r5.e() != null) goto L16;
        LynxLog.b(4, "LynxIntersectionObserver", "observe failed because UIOwner is null");
        goto L20
    L16:
        r11 = r5.e().E(r10.substring(1));
    L20:
        if (r11 == null) goto L37;
        int r14 = 0;
    L22:
        ArrayList r15 = r5.f10372m;
        if (r14 >= r15.size()) goto L28;
        if (((com.lynx.tasm.behavior.s) r15.get(r14)).f10327a == r11) goto L39;
        r14 = r14 + 1;
        goto L22
    L39:
        return;
    L28:
        com.lynx.tasm.behavior.s r16 = new com.lynx.tasm.behavior.s();
        r16.f10327a = r11;
        r16.f10328b = this.d;
        r15.add(r16);
        r5.b(r16, r5.d(), true);
        return;
    L37:
        return;
    L31:
        int r17 = Integer.parseInt(r10);     // Catch: NumberFormatException -> L29
        n0 r18 = (n0) r5.c().f10147o.get();     // Catch: NumberFormatException -> L29
        if (r18 == null) goto L20;
        r11 = r18.v(r17);     // Catch: NumberFormatException -> L29
    L29:
        LynxLog.b(4, "LynxIntersectionObserver", "observe failed because uid is invalid");
    }
}
