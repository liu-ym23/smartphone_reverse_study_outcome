package com.lynx.jsbridge;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class PromiseImpl implements Promise {
    private static final String DEFAULT_ERROR = "EUNSPECIFIED";

    @Nullable
    private Callback mReject;

    @Nullable
    private Callback mResolve;

    @Keep
    public PromiseImpl(@Nullable Callback r5, @Nullable Callback r10) {
        this.mResolve = r5;
        this.mReject = r10;
    }

    @Override // com.lynx.jsbridge.Promise
    @Keep
    @Deprecated
    public void reject(String r5) {
        reject(DEFAULT_ERROR, r5);
    }

    @Override // com.lynx.jsbridge.Promise
    @Keep
    public void resolve(Object r5) {
        Callback r10 = this.mResolve;
        if (r10 == null) goto L6;
        r10.invoke(new Object[]{r5});
        return;
    }

    @Override // com.lynx.jsbridge.Promise
    @Keep
    public void reject(String r5, String r10) {
        if (this.mReject == null) goto L8;
        if (r5 != null) goto L6;
        r5 = DEFAULT_ERROR;
    L6:
        JavaOnlyMap r11 = new JavaOnlyMap();
        r11.putString("code", r5);
        r11.putString("message", r10);
        this.mReject.invoke(new Object[]{r11});
        return;
    }
}
