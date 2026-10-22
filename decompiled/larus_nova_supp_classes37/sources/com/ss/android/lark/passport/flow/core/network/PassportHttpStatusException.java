package com.ss.android.lark.passport.flow.core.network;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/passport/flow/core/network/PassportHttpStatusException;", "Ljava/io/IOException;", "statusCode", "", "requestId", "", "logId", "responseBody", "serverCode", "bizCode", "serverMessage", "nextStep", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getStatusCode", "()I", "getRequestId", "()Ljava/lang/String;", "getLogId", "getResponseBody", "getServerCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBizCode", "getServerMessage", "getNextStep", "flow-passport-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PassportHttpStatusException extends IOException {
    private final Integer bizCode;
    private final String logId;
    private final String nextStep;
    private final String requestId;
    private final String responseBody;
    private final Integer serverCode;
    private final String serverMessage;
    private final int statusCode;

    public final Integer getBizCode() {
        return this.bizCode;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getNextStep() {
        return this.nextStep;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getResponseBody() {
        return this.responseBody;
    }

    public final Integer getServerCode() {
        return this.serverCode;
    }

    public final String getServerMessage() {
        return this.serverMessage;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public PassportHttpStatusException(int r3, String r4, String r5, String r6, Integer r7, Integer r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r4, "requestId");
        if (r9 != null) goto L5;
        String r0 = "Passport HTTP request failed, statusCode=" + r3 + ", requestId=" + r4;
    L6:
        super(r0);
        this.statusCode = r3;
        this.requestId = r4;
        this.logId = r5;
        this.responseBody = r6;
        this.serverCode = r7;
        this.bizCode = r8;
        this.serverMessage = r9;
        this.nextStep = r10;
        return;
    L5:
        r0 = r9;
        goto L6
    }

    public /* synthetic */ PassportHttpStatusException(int r13, String r14, String r15, String r16, Integer r17, Integer r18, String r19, String r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r21 & 16) == 0) goto L9;
        Integer r8 = null;
    L11:
        if ((r21 & 32) == 0) goto L13;
        Integer r9 = null;
    L15:
        if ((r21 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r21 & 128) == 0) goto L21;
        String r11 = null;
    L22:
        this(r13, r14, r15, r7, r8, r9, r10, r11);
        return;
    L21:
        r11 = r20;
        goto L22
    L17:
        r10 = r19;
        goto L19
    L13:
        r9 = r18;
        goto L15
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }
}
