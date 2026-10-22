package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAppointmentResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "appointToast", "", "getAppointToast", "()Ljava/lang/String;", "setAppointToast", "(Ljava/lang/String;)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuAppointmentResponse extends CommerceBaseResponse {

    @SerializedName("appoint_toast")
    private String appointToast;

    public SkuAppointmentResponse() {
        this.appointToast = "";
    }

    public final String getAppointToast() {
        return this.appointToast;
    }

    public final void setAppointToast(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.appointToast = r10;
    }
}
