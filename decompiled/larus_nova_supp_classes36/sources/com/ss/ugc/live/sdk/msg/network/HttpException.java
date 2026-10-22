package com.ss.ugc.live.sdk.msg.network;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/ugc/live/sdk/msg/network/HttpException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "logId", "", "(ILjava/lang/String;)V", "getCode", "()I", "getLogId", "()Ljava/lang/String;", "message_release"}, k = 1, mv = {1, 4, 0})
public final class HttpException extends Exception {
    private final int code;
    private final String logId;

    public final int getCode() {
        return this.code;
    }

    public final String getLogId() {
        return this.logId;
    }

    public HttpException(int r3, String r4) {
        super("Http response is not success, code: " + r3 + ", logId: " + r4);
        this.code = r3;
        this.logId = r4;
    }

    public /* synthetic */ HttpException(int r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
