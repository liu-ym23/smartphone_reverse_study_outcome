package com.bytedance.crash.nativecrash;

import com.bytedance.crash.jni.NativeBridge;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class NativeImpl {
    public NativeImpl() {
    }

    public static void doStartReRegisterNative() {
        NativeBridge.doSignalRecover();
    }
}
