package com.bytedance.sdk.xbridge.cn.registry.core.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/exception/XBridgeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public abstract class XBridgeException extends Exception {
    public XBridgeException(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        super(r5);
    }
}
