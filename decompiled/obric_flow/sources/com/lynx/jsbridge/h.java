package com.lynx.jsbridge;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.ui.y;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends pm.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxExposureModule f9913b;

    public h(LynxExposureModule r5, com.lynx.tasm.behavior.f r10) {
        this.f9913b = r5;
        super(r10);
    }

    @Override // pm.g
    public final void a() {
        y r5 = this.f9913b.mLynxContext.f10155x;
        if (r5 == null) goto L6;
        LynxLog.b(2, "Lynx.UIExposure", "resumeExposure");
        r5.f10783z = false;
        r5.c();
        return;
    }
}
