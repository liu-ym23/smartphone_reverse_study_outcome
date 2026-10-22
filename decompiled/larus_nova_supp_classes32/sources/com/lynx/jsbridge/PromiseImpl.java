package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PromiseImpl implements Promise {
    private static final String DEFAULT_ERROR = "EUNSPECIFIED";
    private Callback mReject;
    private Callback mResolve;

    @Override // com.lynx.jsbridge.Promise
    public void reject(String r2) {
        reject(DEFAULT_ERROR, r2);
    }

    @Override // com.lynx.jsbridge.Promise
    public void resolve(Object r4) {
        Callback r0 = this.mResolve;
        if (r0 == null) goto L6;
        r0.invoke(new Object[]{r4});
        return;
    }

    public PromiseImpl(Callback r1, Callback r2) {
        this.mResolve = r1;
        this.mReject = r2;
    }

    @Override // com.lynx.jsbridge.Promise
    public void reject(String r3, String r4) {
        if (this.mReject == null) goto L8;
        if (r3 != null) goto L6;
        r3 = DEFAULT_ERROR;
    L6:
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.putString(LynxResourceModule.CODE_KEY, r3);
        r0.putString("message", r4);
        this.mReject.invoke(new Object[]{r0});
        return;
    }
}
