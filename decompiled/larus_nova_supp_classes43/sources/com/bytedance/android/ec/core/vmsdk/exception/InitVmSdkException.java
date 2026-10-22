package com.bytedance.android.ec.core.vmsdk.exception;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/vmsdk/exception/InitVmSdkException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InitVmSdkException extends RuntimeException {
    public InitVmSdkException() {
        super("初始化VmSdk失败");
    }
}
