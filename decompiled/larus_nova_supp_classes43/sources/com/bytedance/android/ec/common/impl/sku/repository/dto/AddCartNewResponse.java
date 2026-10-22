package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.bytedance.android.ec.model.sku.AddCartData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/AddCartNewResponse;", "Ljava/io/Serializable;", "()V", "data", "Lcom/bytedance/android/ec/model/sku/AddCartData;", "getData", "()Lcom/bytedance/android/ec/model/sku/AddCartData;", "setData", "(Lcom/bytedance/android/ec/model/sku/AddCartData;)V", "logPb", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "getLogPb", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "st", "", "getSt", "()I", "setSt", "(I)V", a.KEY_STATUS_CODE, "getStatusCode", "setStatusCode", a.KEY_STATUS_MSG, "", "getStatusMsg", "()Ljava/lang/String;", "setStatusMsg", "(Ljava/lang/String;)V", "asJsonDescription", "Lorg/json/JSONObject;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AddCartNewResponse implements Serializable {

    @SerializedName("data")
    private AddCartData data;

    @SerializedName(a.KEY_LOG_PB)
    private final PromotionLogPbData logPb;

    @SerializedName("st")
    private int st;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName(MessageIndication.MESSAGE_TYPE_MSG)
    private String statusMsg;

    public AddCartNewResponse() {
    }

    public final JSONObject asJsonDescription() {
        JSONObject r0 = new JSONObject();
        r0.put("st", this.st);
        r0.put("status_msg", this.statusMsg);
        AddCartData r1 = this.data;
        JSONObject r10 = null;
        if (r1 == null) goto L5;
        JSONObject r11 = r1.asJSONDescription();
    L6:
        r0.put("data", r11);
        PromotionLogPbData r12 = this.logPb;
        if (r12 == null) goto L9;
        r10 = r12.asJSONDescription();
    L9:
        r0.put(a.KEY_LOG_PB, r10);
        r0.put("status_code", this.statusCode);
        return r0;
    L5:
        r11 = null;
        goto L6
    }

    public final AddCartData getData() {
        return this.data;
    }

    public final PromotionLogPbData getLogPb() {
        return this.logPb;
    }

    public final int getSt() {
        return this.st;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public final void setData(AddCartData r1) {
        this.data = r1;
    }

    public final void setSt(int r1) {
        this.st = r1;
    }

    public final void setStatusCode(int r1) {
        this.statusCode = r1;
    }

    public final void setStatusMsg(String r1) {
        this.statusMsg = r1;
    }
}
