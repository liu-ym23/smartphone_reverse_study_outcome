package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.bytedance.android.ec.model.sku.ButtonTipComponent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateSkuVO;", "Ljava/io/Serializable;", "buttonTip", "Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "promiseType", "", "(Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/lang/String;)V", "getButtonTip", "()Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "getPromiseType", "()Ljava/lang/String;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdateSkuVO implements Serializable {

    @SerializedName("button_tip")
    private final ButtonTipComponent buttonTip;

    @SerializedName("promise_type")
    private final String promiseType;

    public UpdateSkuVO() {
        ButtonTipComponent r0 = null;
        this(r0, r0, 3, r0);
    }

    public final ButtonTipComponent getButtonTip() {
        return this.buttonTip;
    }

    public final String getPromiseType() {
        return this.promiseType;
    }

    public UpdateSkuVO(ButtonTipComponent r1, String r10) {
        this.buttonTip = r1;
        this.promiseType = r10;
    }

    public /* synthetic */ UpdateSkuVO(ButtonTipComponent r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
