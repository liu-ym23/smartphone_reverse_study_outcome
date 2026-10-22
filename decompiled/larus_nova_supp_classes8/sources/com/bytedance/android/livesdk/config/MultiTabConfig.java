package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/MultiTabConfig;", "", "", "preLoadEnableSetting", "Z", "", "preLoadMinScore", "F", "preLoadMaxScore", "annieCacheEnableSetting", "annieCacheMinScore", "annieCacheMaxScore", "<init>", "()V", "a", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiTabConfig {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;

    @SerializedName("annie_cache_enable")
    private boolean annieCacheEnableSetting;

    @SerializedName("annie_cache_max_score")
    private float annieCacheMaxScore;

    @SerializedName("annie_cache_min_score")
    private float annieCacheMinScore;

    @SerializedName("pre_load_enable")
    private boolean preLoadEnableSetting;

    @SerializedName("pre_load_max_score")
    private float preLoadMaxScore;

    @SerializedName("pre_load_min_score")
    private float preLoadMinScore;

    public static final class a {
        public static final float a() {
            Lazy r0 = MultiTabConfig.a;
            return ((Number) MultiTabConfig.b.getValue()).floatValue();
        }

        public static final MultiTabConfig b() {
            Lazy r0 = MultiTabConfig.a;
            return (MultiTabConfig) MultiTabConfig.a.getValue();
        }

        public static boolean c() {
            return ((Boolean) MultiTabConfig.e.getValue()).booleanValue();
        }

        public static boolean d() {
            return ((Boolean) MultiTabConfig.g.getValue()).booleanValue();
        }

        public a() {
        }
    }

    static {
        new a();
        a = LazyKt.lazy(MultiTabConfig$Companion$multiTabPerformanceScoreConfig$2.INSTANCE);
        b = LazyKt.lazy(MultiTabConfig$Companion$deviceScore$2.INSTANCE);
        c = LazyKt.lazy(MultiTabConfig$Companion$deviceValidPreLoadScore$2.INSTANCE);
        d = LazyKt.lazy(MultiTabConfig$Companion$deviceValidAnnieCacheScore$2.INSTANCE);
        e = LazyKt.lazy(MultiTabConfig$Companion$preLoadEnable$2.INSTANCE);
        f = LazyKt.lazy(MultiTabConfig$Companion$annieCacheEnable$2.INSTANCE);
        g = LazyKt.lazy(MultiTabConfig$Companion$isLowMemoryPerformanceEnable$2.INSTANCE);
    }

    public MultiTabConfig() {
        this.preLoadEnableSetting = true;
        this.preLoadMinScore = 6.0f;
        this.preLoadMaxScore = 100.0f;
        this.annieCacheEnableSetting = true;
        this.annieCacheMaxScore = 100.0f;
    }

    public static final /* synthetic */ boolean a(MultiTabConfig r0) {
        return r0.annieCacheEnableSetting;
    }

    public static final /* synthetic */ float b(MultiTabConfig r0) {
        return r0.annieCacheMaxScore;
    }

    public static final /* synthetic */ float c(MultiTabConfig r0) {
        return r0.annieCacheMinScore;
    }

    public static final /* synthetic */ boolean d(MultiTabConfig r0) {
        return r0.preLoadEnableSetting;
    }

    public static final /* synthetic */ float e(MultiTabConfig r0) {
        return r0.preLoadMaxScore;
    }

    public static final /* synthetic */ float f(MultiTabConfig r0) {
        return r0.preLoadMinScore;
    }
}
