package com.bytedance.ai.bridge.method.payment.bean;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/bean/GetOrderPaymentRequest;", "", BdpAwemeConstant.KEY_APP_ID, "", "orderId", "platformSignedPtCode", "awemeBindStatus", "", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getOrderId", "getPlatformSignedPtCode", "getAwemeBindStatus", "()Z", "getMessageId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetOrderPaymentRequest {

    @SerializedName("app_key")
    private final String appId;

    @SerializedName("aweme_bind_status")
    private final boolean awemeBindStatus;

    @SerializedName("message_id")
    private final String messageId;

    @SerializedName(a.KEY_ORDER_ID)
    private final String orderId;

    @SerializedName("platform_signed_pt_code")
    private final String platformSignedPtCode;

    public GetOrderPaymentRequest() {
        this(null, null, null, false, null, 31, null);
    }

    public static /* synthetic */ GetOrderPaymentRequest copy$default(GetOrderPaymentRequest r10, String r11, String r12, String r13, boolean r14, String r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.appId;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.orderId;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.platformSignedPtCode;
    L11:
        String r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.awemeBindStatus;
    L14:
        boolean r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.messageId;
    L17:
        String r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.orderId;
    }

    public final String component3() {
        return this.platformSignedPtCode;
    }

    public final boolean component4() {
        return this.awemeBindStatus;
    }

    public final String component5() {
        return this.messageId;
    }

    public final GetOrderPaymentRequest copy(String r10, String r11, String r12, boolean r13, String r14) {
        return new GetOrderPaymentRequest(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GetOrderPaymentRequest) == true) goto L8;
        return false;
    L8:
        GetOrderPaymentRequest r11 = (GetOrderPaymentRequest) r10;
        if (Intrinsics.areEqual(this.appId, r11.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.orderId, r11.orderId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.platformSignedPtCode, r11.platformSignedPtCode) == true) goto L18;
        return false;
    L18:
        if (this.awemeBindStatus == r11.awemeBindStatus) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messageId, r11.messageId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.appId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.orderId;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.platformSignedPtCode;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        if (this.awemeBindStatus == false) goto L17;
        int r18 = 1231;
    L18:
        int r19 = (r17 + r18) * 31;
        String r20 = this.messageId;
        if (r20 == null) goto L23;
        r1 = r20.hashCode();
    L23:
        return r19 + r1;
    L17:
        r18 = 1237;
        goto L18
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "GetOrderPaymentRequest(appId=" + this.appId + ", orderId=" + this.orderId + ", platformSignedPtCode=" + this.platformSignedPtCode + ", awemeBindStatus=" + this.awemeBindStatus + ", messageId=" + this.messageId + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final boolean getAwemeBindStatus() {
        return this.awemeBindStatus;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPlatformSignedPtCode() {
        return this.platformSignedPtCode;
    }

    public GetOrderPaymentRequest(String r1, String r10, String r11, boolean r12, String r13) {
        this.appId = r1;
        this.orderId = r10;
        this.platformSignedPtCode = r11;
        this.awemeBindStatus = r12;
        this.messageId = r13;
    }

    public /* synthetic */ GetOrderPaymentRequest(String r10, String r11, String r12, boolean r13, String r14, int r15, DefaultConstructorMarker r16) {
        String r0 = "";
        if ((r15 & 1) == 0) goto L5;
        String r17 = "";
    L7:
        if ((r15 & 2) != 0) goto L11;
        r0 = r11;
    L11:
        if ((r15 & 4) == 0) goto L13;
        String r1 = null;
    L15:
        if ((r15 & 8) == 0) goto L17;
        boolean r18 = false;
    L19:
        if ((r15 & 16) == 0) goto L21;
        String r19 = null;
    L22:
        this(r17, r0, r1, r18, r19);
        return;
    L21:
        r19 = r14;
        goto L22
    L17:
        r18 = r13;
        goto L19
    L13:
        r1 = r12;
        goto L15
    L5:
        r17 = r10;
        goto L7
    }
}
