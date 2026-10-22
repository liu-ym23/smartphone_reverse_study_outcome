package com.obric.aiagent.product.feature;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.feature.bean.FeatureConfigWrap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/aiagent/product/feature/FeatureListConfig;", "", "version", "", "featureConfigs", "", "", "Lcom/obric/aiagent/product/feature/FeatureConfig;", "featureConfigWraps", "Lcom/obric/aiagent/product/feature/bean/FeatureConfigWrap;", "<init>", "(ILjava/util/Map;Ljava/util/Map;)V", "getVersion", "()I", "getFeatureConfigs", "()Ljava/util/Map;", "getFeatureConfigWraps", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FeatureListConfig {

    @SerializedName("feature_config_warps")
    private final Map<String, FeatureConfigWrap> featureConfigWraps;

    @SerializedName("feature_configs")
    private final Map<String, FeatureConfig> featureConfigs;

    @SerializedName("version")
    private final int version;

    public FeatureListConfig() {
        this(0, null, null, 7, null);
    }

    public FeatureListConfig(int r3, Map<String, FeatureConfig> r4, Map<String, FeatureConfigWrap> r5) {
        Map<String, FeatureConfig> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map<String, FeatureConfigWrap> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "featureConfigs");
        Intrinsics.checkNotNullParameter(r7, "featureConfigWraps");
        this.version = r3;
        this.featureConfigs = r6;
        this.featureConfigWraps = r7;
    }

    public /* synthetic */ FeatureListConfig(int r2, Map r3, Map r4, int r5, DefaultConstructorMarker r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = MapsKt.emptyMap();
    L9:
        if ((r5 & 4) == 0) goto L11;
        r8 = MapsKt.emptyMap();
    L11:
        this(r2, r7, r8);
    }

    public static /* synthetic */ FeatureListConfig copy$default(FeatureListConfig r1, int r2, Map r3, Map r4, int r5, Object r6) {
        Map<String, FeatureConfig> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map<String, FeatureConfigWrap> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.version;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = r1.featureConfigs;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r8 = r1.featureConfigWraps;
    L12:
        return r1.copy(r2, r7, r8);
    }

    public final int component1() {
        return this.version;
    }

    public final Map<String, FeatureConfig> component2() {
        return this.featureConfigs;
    }

    public final Map<String, FeatureConfigWrap> component3() {
        return this.featureConfigWraps;
    }

    public final FeatureListConfig copy(int r2, Map<String, FeatureConfig> r3, Map<String, FeatureConfigWrap> r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "featureConfigs");
        Intrinsics.checkNotNullParameter(r5, "featureConfigWraps");
        return new FeatureListConfig(r2, r1, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FeatureListConfig.class) == true) goto L8;
        return false;
    L8:
        FeatureListConfig r6 = (FeatureListConfig) ZeusTransformUtils.preCheckCast(r5, FeatureListConfig.class, "com.obric.memorydata.plugin");
        if (this.version == r6.version) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.featureConfigs, r6.featureConfigs) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.featureConfigWraps, r6.featureConfigWraps) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final Map<String, FeatureConfigWrap> getFeatureConfigWraps() {
        return this.featureConfigWraps;
    }

    public final Map<String, FeatureConfig> getFeatureConfigs() {
        return this.featureConfigs;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.version) * 31) + this.featureConfigs.hashCode()) * 31) + this.featureConfigWraps.hashCode();
    }

    public String toString() {
        return "FeatureListConfig(version=" + this.version + ", featureConfigs=" + this.featureConfigs + ", featureConfigWraps=" + this.featureConfigWraps + ')';
    }
}
