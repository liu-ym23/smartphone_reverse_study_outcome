package com.lynx.jsbridge;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes2.dex */
public class LynxExposureModule extends LynxContextModule {
    public static final String NAME = "LynxExposureModule";

    public LynxExposureModule(LynxContext r5) {
        super(r5);
    }

    @n
    public void resumeExposure() {
        h r5 = new h(this, this.mLynxContext);
        com.lynx.tasm.utils.j.a().post(r5);
    }

    @n
    public void setObserverFrameRate(ReadableMap r5) {
        g r10 = new g(this, this.mLynxContext, r5, 1);
        com.lynx.tasm.utils.j.a().post(r10);
    }

    @n
    public void stopExposure(ReadableMap r5) {
        g r10 = new g(this, this.mLynxContext, r5, 0);
        com.lynx.tasm.utils.j.a().post(r10);
    }
}
