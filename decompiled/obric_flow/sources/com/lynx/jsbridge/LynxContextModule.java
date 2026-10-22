package com.lynx.jsbridge;

import androidx.annotation.Keep;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes2.dex */
public class LynxContextModule extends LynxModule {
    protected LynxContext mLynxContext;

    public LynxContextModule(LynxContext r5) {
        super(r5);
        this.mLynxContext = r5;
    }

    @Override // com.lynx.jsbridge.LynxModule
    @Keep
    public void destroy() {
        super.destroy();
    }

    public LynxContextModule(LynxContext r5, Object r10) {
        super(r5, r10);
        this.mLynxContext = r5;
    }
}
