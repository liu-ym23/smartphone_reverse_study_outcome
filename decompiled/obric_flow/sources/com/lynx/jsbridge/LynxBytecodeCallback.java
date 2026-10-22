package com.lynx.jsbridge;

import androidx.annotation.Keep;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface LynxBytecodeCallback {
    @CalledByNative
    void onResponse(String r5, JavaOnlyMap r10);
}
