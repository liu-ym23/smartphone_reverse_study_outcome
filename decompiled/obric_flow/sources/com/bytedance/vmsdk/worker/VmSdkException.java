package com.bytedance.vmsdk.worker;

import com.bytedance.vmsdk.jsbridge.utils.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class VmSdkException extends Exception {
    public VmSdkException(String r5) {
        super(r5);
    }

    @CalledByNative
    public static void throwVmSdkException(int r5, String r10) {
        throw new VmSdkException(r10);
    }
}
