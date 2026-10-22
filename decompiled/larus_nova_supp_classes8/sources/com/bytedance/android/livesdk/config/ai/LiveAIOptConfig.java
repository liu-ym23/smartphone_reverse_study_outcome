package com.bytedance.android.livesdk.config.ai;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR2\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/ai/LiveAIOptConfig;", "", "()V", "businessToFeaturesMap", "", "", "", "getBusinessToFeaturesMap", "()Ljava/util/Map;", "setBusinessToFeaturesMap", "(Ljava/util/Map;)V", "businessToPortraitsMap", "getBusinessToPortraitsMap", "setBusinessToPortraitsMap", "insertFeatureMapEnable", "", "getInsertFeatureMapEnable", "()Z", "setInsertFeatureMapEnable", "(Z)V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAIOptConfig {

    @SerializedName("business_to_features_map")
    private Map<String, ? extends List<String>> businessToFeaturesMap;

    @SerializedName("business_to_portraits_map")
    private Map<String, ? extends List<String>> businessToPortraitsMap;

    @SerializedName("insert_feature_map_enable")
    private boolean insertFeatureMapEnable;

    public LiveAIOptConfig() {
    }

    public final Map<String, List<String>> getBusinessToFeaturesMap() {
        return this.businessToFeaturesMap;
    }

    public final Map<String, List<String>> getBusinessToPortraitsMap() {
        return this.businessToPortraitsMap;
    }

    public final boolean getInsertFeatureMapEnable() {
        return this.insertFeatureMapEnable;
    }

    public final void setBusinessToFeaturesMap(Map<String, ? extends List<String>> r1) {
        this.businessToFeaturesMap = r1;
    }

    public final void setBusinessToPortraitsMap(Map<String, ? extends List<String>> r1) {
        this.businessToPortraitsMap = r1;
    }

    public final void setInsertFeatureMapEnable(boolean r1) {
        this.insertFeatureMapEnable = r1;
    }
}
