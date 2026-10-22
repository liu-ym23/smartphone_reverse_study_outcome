package com.bytedance.ai.bridge.method.payment.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/bean/GetSignPageDataRequest;", "", "authOrderId", "", "appKey", "awemeBindStatus", "", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAuthOrderId", "()Ljava/lang/String;", "getAppKey", "getAwemeBindStatus", "()Z", "getMessageId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetSignPageDataRequest {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("auth_order_id")
    private final String authOrderId;

    @SerializedName("aweme_bind_status")
    private final boolean awemeBindStatus;

    @SerializedName("message_id")
    private final String messageId;

    public GetSignPageDataRequest() {
        this(null, null, false, null, 15, null);
    }

    public static /* synthetic */ GetSignPageDataRequest copy$default(GetSignPageDataRequest r0, String r1, String r10, boolean r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r1 = r0.authOrderId;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = r0.appKey;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = r0.awemeBindStatus;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r12 = r0.messageId;
    L15:
        return r0.copy(r1, r10, r11, r12);
    }

    public final String component1() {
        return this.authOrderId;
    }

    public final String component2() {
        return this.appKey;
    }

    public final boolean component3() {
        return this.awemeBindStatus;
    }

    public final String component4() {
        return this.messageId;
    }

    public final GetSignPageDataRequest copy(String r10, String r11, boolean r12, String r13) {
        return new GetSignPageDataRequest(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GetSignPageDataRequest) == true) goto L8;
        return false;
    L8:
        GetSignPageDataRequest r11 = (GetSignPageDataRequest) r10;
        if (Intrinsics.areEqual(this.authOrderId, r11.authOrderId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L15;
        return false;
    L15:
        if (this.awemeBindStatus == r11.awemeBindStatus) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.messageId, r11.messageId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.authOrderId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.appKey;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        if (this.awemeBindStatus == false) goto L13;
        int r15 = 1231;
    L14:
        int r16 = (r14 + r15) * 31;
        String r17 = this.messageId;
        if (r17 == null) goto L19;
        r1 = r17.hashCode();
    L19:
        return r16 + r1;
    L13:
        r15 = 1237;
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "GetSignPageDataRequest(authOrderId=" + this.authOrderId + ", appKey=" + this.appKey + ", awemeBindStatus=" + this.awemeBindStatus + ", messageId=" + this.messageId + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getAuthOrderId() {
        return this.authOrderId;
    }

    public final boolean getAwemeBindStatus() {
        return this.awemeBindStatus;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public GetSignPageDataRequest(String r1, String r10, boolean r11, String r12) {
        this.authOrderId = r1;
        this.appKey = r10;
        this.awemeBindStatus = r11;
        this.messageId = r12;
    }

    public /* synthetic */ GetSignPageDataRequest(String r10, String r11, boolean r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = "";
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = false;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
