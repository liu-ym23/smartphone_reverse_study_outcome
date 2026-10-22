package com.bytedance.ai.bridge.method.payment.bean;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/bean/GetOrderPaymentWithSignRequest;", "", "orderId", "", "signData", "signDbAuthorization", "appKey", "awemeBindStatus", "", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getOrderId", "()Ljava/lang/String;", "getSignData", "getSignDbAuthorization", "getAppKey", "getAwemeBindStatus", "()Z", "getMessageId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetOrderPaymentWithSignRequest {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("aweme_bind_status")
    private final boolean awemeBindStatus;

    @SerializedName("message_id")
    private final String messageId;

    @SerializedName(a.KEY_ORDER_ID)
    private final String orderId;

    @SerializedName("sign_data")
    private final String signData;

    @SerializedName("sign_db_authorization")
    private final String signDbAuthorization;

    public GetOrderPaymentWithSignRequest() {
        this(null, null, null, null, false, null, 63, null);
    }

    public static /* synthetic */ GetOrderPaymentWithSignRequest copy$default(GetOrderPaymentWithSignRequest r10, String r11, String r12, String r13, String r14, boolean r15, String r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.orderId;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.signData;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.signDbAuthorization;
    L11:
        String r0 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.appKey;
    L14:
        String r1 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.awemeBindStatus;
    L17:
        boolean r20 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.messageId;
    L20:
        String r21 = r11;
        return r10.copy(r21, r19, r0, r1, r20, r16);
    }

    public final String component1() {
        return this.orderId;
    }

    public final String component2() {
        return this.signData;
    }

    public final String component3() {
        return this.signDbAuthorization;
    }

    public final String component4() {
        return this.appKey;
    }

    public final boolean component5() {
        return this.awemeBindStatus;
    }

    public final String component6() {
        return this.messageId;
    }

    public final GetOrderPaymentWithSignRequest copy(String r10, String r11, String r12, String r13, boolean r14, String r15) {
        return new GetOrderPaymentWithSignRequest(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GetOrderPaymentWithSignRequest) == true) goto L8;
        return false;
    L8:
        GetOrderPaymentWithSignRequest r11 = (GetOrderPaymentWithSignRequest) r10;
        if (Intrinsics.areEqual(this.orderId, r11.orderId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.signData, r11.signData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.signDbAuthorization, r11.signDbAuthorization) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L21;
        return false;
    L21:
        if (this.awemeBindStatus == r11.awemeBindStatus) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageId, r11.messageId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.orderId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.signData;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.signDbAuthorization;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.appKey;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        if (this.awemeBindStatus == false) goto L21;
        int r21 = 1231;
    L22:
        int r22 = (r20 + r21) * 31;
        String r23 = this.messageId;
        if (r23 == null) goto L27;
        r1 = r23.hashCode();
    L27:
        return r22 + r1;
    L21:
        r21 = 1237;
        goto L22
    L17:
        r19 = r18.hashCode();
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
        return "GetOrderPaymentWithSignRequest(orderId=" + this.orderId + ", signData=" + this.signData + ", signDbAuthorization=" + this.signDbAuthorization + ", appKey=" + this.appKey + ", awemeBindStatus=" + this.awemeBindStatus + ", messageId=" + this.messageId + ')';
    }

    public final String getAppKey() {
        return this.appKey;
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

    public final String getSignData() {
        return this.signData;
    }

    public final String getSignDbAuthorization() {
        return this.signDbAuthorization;
    }

    public GetOrderPaymentWithSignRequest(String r1, String r10, String r11, String r12, boolean r13, String r14) {
        this.orderId = r1;
        this.signData = r10;
        this.signDbAuthorization = r11;
        this.appKey = r12;
        this.awemeBindStatus = r13;
        this.messageId = r14;
    }

    public /* synthetic */ GetOrderPaymentWithSignRequest(String r10, String r11, String r12, String r13, boolean r14, String r15, int r16, DefaultConstructorMarker r17) {
        String r0 = "";
        if ((r16 & 1) == 0) goto L5;
        String r18 = "";
    L7:
        if ((r16 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r16 & 4) == 0) goto L13;
        String r19 = "";
    L15:
        if ((r16 & 8) != 0) goto L19;
        r0 = r13;
    L19:
        if ((r16 & 16) == 0) goto L21;
        boolean r20 = false;
    L23:
        if ((r16 & 32) == 0) goto L25;
        r15 = null;
    L25:
        String r110 = r15;
        this(r18, r1, r19, r0, r20, r110);
        return;
    L21:
        r20 = r14;
        goto L23
    L13:
        r19 = r12;
        goto L15
    L9:
        r1 = r11;
        goto L11
    L5:
        r18 = r10;
        goto L7
    }
}
