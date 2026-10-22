package com.bytedance.android.livesdk.interactivity.service.uplink;

import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R#\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/uplink/FrontierTransformConfig;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "configMap", "Ljava/util/Map;", "getConfigMap", "()Ljava/util/Map;", "defaultValue", "I", "getDefaultValue", "()I", "BOE_DOUYIN_DOULITE", "BOE_HOTSOON", "BOE_OTHER", "ONLINE_DOUYIN_DOULITE", "ONLINE_HOTSOON", "ONLINE_OTHER", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FrontierTransformConfig extends Enum<FrontierTransformConfig> {
    public static final FrontierTransformConfig BOE_DOUYIN_DOULITE = null;
    public static final FrontierTransformConfig BOE_HOTSOON = null;
    public static final FrontierTransformConfig BOE_OTHER = null;
    public static final FrontierTransformConfig ONLINE_DOUYIN_DOULITE = null;
    public static final FrontierTransformConfig ONLINE_HOTSOON = null;
    public static final FrontierTransformConfig ONLINE_OTHER = null;
    public static final /* synthetic */ FrontierTransformConfig[] a = null;
    private final Map<Integer, Integer> configMap;
    private final int defaultValue;

    static {
        FrontierTransformConfig r1 = new FrontierTransformConfig("BOE_DOUYIN_DOULITE", 0, MapsKt.mapOf(TuplesKt.to(10009, 16778054)), 20115);
        BOE_DOUYIN_DOULITE = r1;
        FrontierTransformConfig r2 = new FrontierTransformConfig("BOE_HOTSOON", 1, MapsKt.mapOf(TuplesKt.to(10009, 16778054)), 20282);
        BOE_HOTSOON = r2;
        FrontierTransformConfig r3 = new FrontierTransformConfig("BOE_OTHER", 2, MapsKt.emptyMap(), 20113);
        BOE_OTHER = r3;
        FrontierTransformConfig r4 = new FrontierTransformConfig("ONLINE_DOUYIN_DOULITE", 3, MapsKt.mapOf(TuplesKt.to(10009, 33554540)), 20142);
        ONLINE_DOUYIN_DOULITE = r4;
        FrontierTransformConfig r5 = new FrontierTransformConfig("ONLINE_HOTSOON", 4, MapsKt.mapOf(TuplesKt.to(10009, 33554540)), 20307);
        ONLINE_HOTSOON = r5;
        FrontierTransformConfig r6 = new FrontierTransformConfig("ONLINE_OTHER", 5, MapsKt.emptyMap(), 20146);
        ONLINE_OTHER = r6;
        a = new FrontierTransformConfig[]{r1, r2, r3, r4, r5, r6};
    }

    public static FrontierTransformConfig valueOf(String r1) {
        return (FrontierTransformConfig) a.a(FrontierTransformConfig.class, r1);
    }

    public static FrontierTransformConfig[] values() {
        return (FrontierTransformConfig[]) a.clone();
    }

    public final Map<Integer, Integer> getConfigMap() {
        return this.configMap;
    }

    public final int getDefaultValue() {
        return this.defaultValue;
    }

    public FrontierTransformConfig(String r1, int r2, Map r3, int r4) {
        super(r1, r2);
        this.configMap = r3;
        this.defaultValue = r4;
    }
}
