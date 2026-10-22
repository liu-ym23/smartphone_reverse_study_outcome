package com.bytedance.ai.bridge.method.payment.bean;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/bean/GetSignPageDataResponse;", "", "data", "", "logId", "errCode", "", "errMsg", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "getLogId", "setLogId", "getErrCode", "()I", "setErrCode", "(I)V", "getErrMsg", "setErrMsg", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetSignPageDataResponse {

    @SerializedName("data")
    private String data;

    @SerializedName("err_code")
    private int errCode;

    @SerializedName("err_msg")
    private String errMsg;

    @SerializedName(a.KEY_LOG_ID)
    private String logId;

    public GetSignPageDataResponse() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ GetSignPageDataResponse copy$default(GetSignPageDataResponse r0, String r1, String r10, int r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r1 = r0.data;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = r0.logId;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = r0.errCode;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r12 = r0.errMsg;
    L15:
        return r0.copy(r1, r10, r11, r12);
    }

    public final String component1() {
        return this.data;
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

    public final GetSignPageDataResponse copy(String r10, String r11, int r12, String r13) {
        return new GetSignPageDataResponse(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GetSignPageDataResponse) == true) goto L8;
        return false;
    L8:
        GetSignPageDataResponse r11 = (GetSignPageDataResponse) r10;
        if (Intrinsics.areEqual(this.data, r11.data) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logId, r11.logId) == true) goto L15;
        return false;
    L15:
        if (this.errCode == r11.errCode) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.errMsg, r11.errMsg) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.data;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.logId;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (((r11 + r13) * 31) + this.errCode) * 31;
        String r15 = this.errMsg;
        if (r15 == null) goto L15;
        r1 = r15.hashCode();
    L15:
        return r14 + r1;
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "GetSignPageDataResponse(data=" + this.data + ", logId=" + this.logId + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ')';
    }

    public final String getData() {
        return this.data;
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

    public final void setData(String r1) {
        this.data = r1;
    }

    public final void setErrCode(int r1) {
        this.errCode = r1;
    }

    public final void setErrMsg(String r1) {
        this.errMsg = r1;
    }

    public final void setLogId(String r1) {
        this.logId = r1;
    }

    public GetSignPageDataResponse(String r1, String r10, int r11, String r12) {
        this.data = r1;
        this.logId = r10;
        this.errCode = r11;
        this.errMsg = r12;
    }

    public /* synthetic */ GetSignPageDataResponse(String r10, String r11, int r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = "";
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = 0;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = "";
    L14:
        this(r10, r11, r12, r13);
    }
}
