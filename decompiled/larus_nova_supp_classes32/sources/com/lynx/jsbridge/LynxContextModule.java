package com.lynx.jsbridge;

import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxContextModule extends LynxModule {
    protected LynxContext mLynxContext;

    @Override // com.lynx.jsbridge.LynxModule
    public void destroy() {
        super.destroy();
    }

    public LynxContextModule(LynxContext r1) {
        super(r1);
        this.mLynxContext = r1;
    }

    public LynxContextModule(LynxContext r1, Object r2) {
        super(r1, r2);
        this.mLynxContext = r1;
    }
}
