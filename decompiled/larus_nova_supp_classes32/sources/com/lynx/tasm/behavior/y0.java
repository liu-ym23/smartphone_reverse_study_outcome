package com.lynx.tasm.behavior;

import com.lynx.devtoolwrapper.CDPResultCallback;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y0 implements CDPResultCallback {
    public y0() {
    }

    @Override // com.lynx.devtoolwrapper.CDPResultCallback
    public final void onResult(String r3) {
        LLog.i("LynxTouchEventDispatcher", "DOM.setAttributesAsText:" + r3);
    }
}
