package com.bytedance.android.ec.core.vmsdk.exception;

import com.bytedance.ai.event.MessageIndication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/core/vmsdk/exception/InitJsContextException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", MessageIndication.MESSAGE_TYPE_MSG, "", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InitJsContextException extends RuntimeException {
    private final String msg;

    public final String getMsg() {
        return this.msg;
    }

    public InitJsContextException(String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        super("初始化js上下文环境失败\n" + r10);
        this.msg = r10;
    }
}
