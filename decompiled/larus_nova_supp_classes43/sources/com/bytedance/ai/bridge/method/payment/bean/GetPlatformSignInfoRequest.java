package com.bytedance.ai.bridge.method.payment.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/bean/GetPlatformSignInfoRequest;", "", "amount", "", "appKey", "", "messageId", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getAmount", "()J", "getAppKey", "()Ljava/lang/String;", "getMessageId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetPlatformSignInfoRequest {

    @SerializedName("amount")
    private final long amount;

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("message_id")
    private final String messageId;

    public GetPlatformSignInfoRequest() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ GetPlatformSignInfoRequest copy$default(GetPlatformSignInfoRequest r0, long r1, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.amount;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.appKey;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.messageId;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final long component1() {
        return this.amount;
    }

    public final String component2() {
        return this.appKey;
    }

    public final String component3() {
        return this.messageId;
    }

    public final GetPlatformSignInfoRequest copy(long r10, String r11, String r12) {
        return new GetPlatformSignInfoRequest(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GetPlatformSignInfoRequest) == true) goto L8;
        return false;
    L8:
        GetPlatformSignInfoRequest r11 = (GetPlatformSignInfoRequest) r10;
        if (this.amount == r11.amount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageId, r11.messageId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r0 = this.amount;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r10 = this.appKey;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r1 + r12) * 31;
        String r14 = this.messageId;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "GetPlatformSignInfoRequest(amount=" + this.amount + ", appKey=" + this.appKey + ", messageId=" + this.messageId + ')';
    }

    public final long getAmount() {
        return this.amount;
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public GetPlatformSignInfoRequest(long r1, String r10, String r11) {
        this.amount = r1;
        this.appKey = r10;
        this.messageId = r11;
    }

    public /* synthetic */ GetPlatformSignInfoRequest(long r1, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = "";
    L9:
        if ((r12 & 4) == 0) goto L11;
        r11 = null;
    L11:
        this(r1, r10, r11);
    }
}
