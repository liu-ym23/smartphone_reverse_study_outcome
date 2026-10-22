package com.bytedance.android.live.core.feature;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/core/feature/DynamicDataResp;", "", "()V", "anchorInfos", "", "", "Lcom/bytedance/android/live/core/feature/DynamicDataRespItem;", "getAnchorInfos", "()Ljava/util/Map;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicDataResp {

    @SerializedName("anchor")
    private final Map<String, DynamicDataRespItem> anchorInfos;

    public DynamicDataResp() {
    }

    public final Map<String, DynamicDataRespItem> getAnchorInfos() {
        return this.anchorInfos;
    }
}
