package com.bytedance.vmsdk.worker;

import com.bytedance.vmsdk.jsbridge.utils.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public interface IWorkerExceptionDelegate {
    @CalledByNative
    void onError(int r5, String r10);
}
