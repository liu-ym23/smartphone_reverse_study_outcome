package com.lynx.devtool;

import com.lynx.devtoolwrapper.CDPResultCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CDPResultCallbackWrapper {
    private CDPResultCallback callback;

    public CDPResultCallbackWrapper(CDPResultCallback r1) {
        this.callback = r1;
    }

    public void onResult(String r2) {
        this.callback.onResult(r2);
    }
}
