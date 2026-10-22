package com.bytedance.ai.bridge.method.payment.bean;

import ai.j0;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import k5.d;
import kk.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/bean/RequestOrderResponse;", "", "orderId", "", "logId", "errCode", "", "errMsg", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "getLogId", "setLogId", "getErrCode", "()I", "setErrCode", "(I)V", "getErrMsg", "setErrMsg", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RequestOrderResponse {

    @SerializedName("err_code")
    private int errCode;

    @SerializedName("err_msg")
    private String errMsg;

    @SerializedName("log_id")
    private String logId;

    @SerializedName("order_id")
    private String orderId;

    public RequestOrderResponse(String r5, String r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "logId");
        Intrinsics.checkNotNullParameter(r12, "errMsg");
        this.orderId = r5;
        this.logId = r10;
        this.errCode = r11;
        this.errMsg = r12;
    }

    public static /* synthetic */ RequestOrderResponse copy$default(RequestOrderResponse r5, String r10, String r11, int r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.orderId;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.logId;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.errCode;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.errMsg;
    L15:
        return r5.copy(r10, r11, r12, r13);
    }

    public final String component1() {
        return this.orderId;
    }

    public final String component2() {
        return this.logId;
    }

    public final int component3() {
        return this.errCode;
    }

    public final String component4() {
        return this.errMsg;
    }

    public final RequestOrderResponse copy(String r5, String r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "logId");
        Intrinsics.checkNotNullParameter(r12, "errMsg");
        return new RequestOrderResponse(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RequestOrderResponse) == true) goto L8;
        return false;
    L8:
        RequestOrderResponse r10 = (RequestOrderResponse) r5;
        if (Intrinsics.areEqual(this.orderId, r10.orderId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logId, r10.logId) == true) goto L15;
        return false;
    L15:
        if (this.errCode == r10.errCode) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.errMsg, r10.errMsg) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public int hashCode() {
        String r5 = this.orderId;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        String r11 = this.logId;
        int r12 = a.b(r11, r10 * 31, 31);
        int r13 = d.a(this.errCode, r12);
        return this.errMsg.hashCode() + r13;
    L5:
        r10 = r5.hashCode();
        goto L6
    }

    public final void setErrCode(int r5) {
        this.errCode = r5;
    }

    public final void setErrMsg(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.errMsg = r5;
    }

    public final void setLogId(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.logId = r5;
    }

    public final void setOrderId(String r5) {
        this.orderId = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("RequestOrderResponse(orderId=");
        r5.append(this.orderId);
        r5.append(", logId=");
        r5.append(this.logId);
        r5.append(", errCode=");
        r5.append(this.errCode);
        r5.append(", errMsg=");
        return j0.p(r5, this.errMsg, ')');
    }

    public /* synthetic */ RequestOrderResponse(String r5, String r10, int r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r10 = "";
    L6:
        if ((r13 & 4) == 0) goto L9;
        r11 = 0;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r12 = "";
    L11:
        this(r5, r10, r11, r12);
    }
}
