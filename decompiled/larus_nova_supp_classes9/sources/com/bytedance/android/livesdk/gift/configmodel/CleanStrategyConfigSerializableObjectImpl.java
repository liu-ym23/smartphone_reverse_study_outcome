package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b*\u0010+R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019R \u0010$\u001a\b\u0012\u0004\u0012\u00020\b0#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/CleanStrategyConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/m;", BuildConfig.FLAVOR, "enable", "Z", "getEnable", "()Z", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/configmodel/g;", "poolConfig", "Ljava/util/Map;", "K8", "()Ljava/util/Map;", "Lcom/bytedance/android/livesdk/gift/configmodel/k;", "downloadBlackConfig", "Lcom/bytedance/android/livesdk/gift/configmodel/k;", "G6", "()Lcom/bytedance/android/livesdk/gift/configmodel/k;", "cleanWhiteConfig", "E7", BuildConfig.FLAVOR, "assetExpireDuration", "J", "d3", "()J", "diffCleanEnable", "k9", "Lcom/bytedance/android/livesdk/gift/configmodel/q;", "effectApiAddParam", "Lcom/bytedance/android/livesdk/gift/configmodel/q;", "V1", "()Lcom/bytedance/android/livesdk/gift/configmodel/q;", "relatedPoolCheckInterval", "u1", BuildConfig.FLAVOR, "assetPoolNotAddBlackList", "Ljava/util/List;", "c3", "()Ljava/util/List;", "roomCleanEnable", "g0", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CleanStrategyConfigSerializableObjectImpl implements m {

    @SerializedName("asset_expire_duration")
    private final long assetExpireDuration;

    @SerializedName("live_asset_pool_not_add_black_list")
    private final List<String> assetPoolNotAddBlackList;

    @SerializedName("clean_white_list_config")
    private final k cleanWhiteConfig;

    @SerializedName("diff_clean_enable")
    private final boolean diffCleanEnable;

    @SerializedName("download_black_list_config")
    private final k downloadBlackConfig;

    @SerializedName("live_effect_api_add_user_portrait_param")
    private final q effectApiAddParam;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("pool_config")
    private final Map<String, g> poolConfig;

    @SerializedName("download_asset_trigger_related_pool_clean_interval")
    private final long relatedPoolCheckInterval;

    @SerializedName("clean_in_room_enable")
    private final boolean roomCleanEnable;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/CleanStrategyConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(CleanStrategyConfigSerializableObjectImpl.class);
        }
    }

    public CleanStrategyConfigSerializableObjectImpl() {
        this.enable = false;
        this.poolConfig = MapsKt.emptyMap();
        Class r1 = k.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r2 = vh7.b.a;
        Object r3 = r2.get(r1);
        if (r3 != null) goto L12;
        r3 = r1.getConstructor(new Class[0]);
        if (r3 == null) goto L11;
        Object r4 = r2.putIfAbsent(r1, r3);
        if (r4 == null) goto L12;
        r3 = r4;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r5 = ((SerializableObjectJsonAdapterBase) ((Constructor) r3).newInstance(new Object[0])).createInstance();
        if (r5 == null) goto L45;
        this.downloadBlackConfig = (k) r5;
        Class r6 = k.class.getAnnotation(JsonAdapter.class).value();
        Object r7 = r2.get(r6);
        if (r7 != null) goto L24;
        r7 = r6.getConstructor(new Class[0]);
        if (r7 == null) goto L23;
        Object r8 = r2.putIfAbsent(r6, r7);
        if (r8 == null) goto L24;
        r7 = r8;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r9 = ((SerializableObjectJsonAdapterBase) ((Constructor) r7).newInstance(new Object[0])).createInstance();
        if (r9 == null) goto L43;
        this.cleanWhiteConfig = (k) r9;
        long r10 = 60;
        this.assetExpireDuration = r10;
        this.diffCleanEnable = true;
        Class r11 = q.class.getAnnotation(JsonAdapter.class).value();
        Object r13 = r2.get(r11);
        if (r13 != null) goto L36;
        r13 = r11.getConstructor(new Class[0]);
        if (r13 == null) goto L35;
        Object r14 = r2.putIfAbsent(r11, r13);
        if (r14 == null) goto L36;
        r13 = r14;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r15 = ((SerializableObjectJsonAdapterBase) ((Constructor) r13).newInstance(new Object[0])).createInstance();
        if (r15 == null) goto L41;
        this.effectApiAddParam = (q) r15;
        this.relatedPoolCheckInterval = r10;
        this.assetPoolNotAddBlackList = com.bytedance.revenue.platform.api.core.c.a(new String[0]);
        this.roomCleanEnable = true;
        return;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.DeviceStorageSetting");
    L43:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.BlackAndWhiteListConfig");
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.BlackAndWhiteListConfig");
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final k E7() {
        return this.cleanWhiteConfig;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final k G6() {
        return this.downloadBlackConfig;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final Map<String, g> K8() {
        return this.poolConfig;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final q V1() {
        return this.effectApiAddParam;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final List<String> c3() {
        return this.assetPoolNotAddBlackList;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final long d3() {
        return this.assetExpireDuration;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final boolean g0() {
        return this.roomCleanEnable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final boolean k9() {
        return this.diffCleanEnable;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.m
    public final long u1() {
        return this.relatedPoolCheckInterval;
    }
}
