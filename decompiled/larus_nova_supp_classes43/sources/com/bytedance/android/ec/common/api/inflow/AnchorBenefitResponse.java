package com.bytedance.android.ec.common.api.inflow;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/common/api/inflow/AnchorBenefitResponse;", "Ljava/io/Serializable;", "()V", "banner", "Lcom/bytedance/android/ec/common/api/inflow/AnchorBenefitBanner;", "getBanner", "()Lcom/bytedance/android/ec/common/api/inflow/AnchorBenefitBanner;", a.VALUE_SHOW_TOAST, "Lcom/bytedance/android/ec/common/api/inflow/AnchorBenefitToast;", "getToast", "()Lcom/bytedance/android/ec/common/api/inflow/AnchorBenefitToast;", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class AnchorBenefitResponse implements Serializable {

    @SerializedName("banner")
    private final AnchorBenefitBanner banner;

    @SerializedName(a.VALUE_SHOW_TOAST)
    private final AnchorBenefitToast toast;

    public AnchorBenefitResponse() {
    }

    public final AnchorBenefitBanner getBanner() {
        return this.banner;
    }

    public final AnchorBenefitToast getToast() {
        return this.toast;
    }
}
