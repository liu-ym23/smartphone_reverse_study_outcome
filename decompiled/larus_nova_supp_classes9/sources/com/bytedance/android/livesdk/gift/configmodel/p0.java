package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/p0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "cacheOnce", "Z", "a", "()Z", "localRefreshEnable", "getLocalRefreshEnable", BuildConfig.FLAVOR, "loadLocalScene", "I", "c", "()I", "loadType", "d", "vsLoadLocal", "e", "vsLoadLocalOpt", "f", "loadDataScene", "b", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p0 {

    @SerializedName("cache_once")
    private final boolean cacheOnce;

    @SerializedName("load_data_scene")
    private final int loadDataScene;

    @SerializedName("load_local_scene")
    private final int loadLocalScene;

    @SerializedName("load_type")
    private final int loadType;

    @SerializedName("local_refresh")
    private final boolean localRefreshEnable;

    @SerializedName("vs_load_local")
    private final boolean vsLoadLocal;

    @SerializedName("vs_load_local_opt")
    private final boolean vsLoadLocalOpt;

    public static final class a {
    }

    static {
    }

    public p0() {
        this.cacheOnce = true;
        this.localRefreshEnable = true;
        this.loadLocalScene = 1;
        this.loadType = 2;
        this.vsLoadLocal = true;
        this.loadDataScene = 1;
    }

    public final boolean a() {
        return this.cacheOnce;
    }

    public final int b() {
        return this.loadDataScene;
    }

    public final int c() {
        return this.loadLocalScene;
    }

    public final int d() {
        return this.loadType;
    }

    public final boolean e() {
        return this.vsLoadLocal;
    }

    public final boolean f() {
        return this.vsLoadLocalOpt;
    }
}
