package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tR$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/CommonSkusUpdateResponse;", "Ljava/io/Serializable;", a.KEY_STATUS_CODE, "", a.KEY_STATUS_MSG, "", "skusUpdateInfo", "", "Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateSkuVO;", "(ILjava/lang/String;Ljava/util/Map;)V", "getSkusUpdateInfo", "()Ljava/util/Map;", "getStatusCode", "()I", "getStatusMsg", "()Ljava/lang/String;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonSkusUpdateResponse implements Serializable {

    @SerializedName("skus_update_info")
    private final Map<String, UpdateSkuVO> skusUpdateInfo;

    @SerializedName("status_code")
    private final int statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    public CommonSkusUpdateResponse() {
        this(0, null, null, 7, null);
    }

    public final Map<String, UpdateSkuVO> getSkusUpdateInfo() {
        return this.skusUpdateInfo;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public CommonSkusUpdateResponse(int r1, String r10, Map<String, UpdateSkuVO> r11) {
        this.statusCode = r1;
        this.statusMsg = r10;
        this.skusUpdateInfo = r11;
    }

    public /* synthetic */ CommonSkusUpdateResponse(int r10, String r11, Map r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
