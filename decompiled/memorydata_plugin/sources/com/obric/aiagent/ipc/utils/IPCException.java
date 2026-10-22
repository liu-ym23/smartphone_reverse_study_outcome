package com.obric.aiagent.ipc.utils;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/ipc/utils/IPCException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "t", "", "<init>", "(Ljava/lang/Throwable;)V", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IPCException extends IllegalStateException {
    public IPCException(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
        super(ExceptionsKt.stackTraceToString(r2));
    }
}
