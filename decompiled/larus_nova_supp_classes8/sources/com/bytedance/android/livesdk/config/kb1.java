package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\"\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\"\u0010,\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0011\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/config/kb1;", "", "", "renderWidgetReuse", "Z", "i", "()Z", "setRenderWidgetReuse", "(Z)V", "renderWidgetFeedReuse", "e", "setRenderWidgetFeedReuse", "logicWidgetFeedReuse", "a", "setLogicWidgetFeedReuse", "", "renderWidgetPoolSize", "I", "f", "()I", "setRenderWidgetPoolSize", "(I)V", "renderWidgetReleaseTime", "h", "setRenderWidgetReleaseTime", "rootWidgetReuse", "k", "setRootWidgetReuse", "renderWidgetCacheSize", "d", "setRenderWidgetCacheSize", "mainWidgetCacheSize", "b", "setMainWidgetCacheSize", "", "mainWidgetPreloadDelay", "J", "c", "()J", "setMainWidgetPreloadDelay", "(J)V", "renderWidgetPreloadDelay", "g", "setRenderWidgetPreloadDelay", "rootWidgetReleaseTime", "j", "setRootWidgetReleaseTime", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class kb1 {

    @SerializedName("live_logic_widget_reuse_feed")
    private boolean logicWidgetFeedReuse;

    @SerializedName("live_main_widget_cache_size")
    private int mainWidgetCacheSize;

    @SerializedName("live_main_widget_preload_delay")
    private long mainWidgetPreloadDelay;

    @SerializedName("live_render_widget_cache_size")
    private int renderWidgetCacheSize;

    @SerializedName("live_render_widget_reuse_feed")
    private boolean renderWidgetFeedReuse;

    @SerializedName("live_render_widget_pool_size")
    private int renderWidgetPoolSize;

    @SerializedName("live_render_widget_preload_delay")
    private long renderWidgetPreloadDelay;

    @SerializedName("live_render_widget_release_time")
    private int renderWidgetReleaseTime;

    @SerializedName("live_render_widget_reuse")
    private boolean renderWidgetReuse;

    @SerializedName("live_root_widget_release_time")
    private int rootWidgetReleaseTime;

    @SerializedName("live_main_widget_reuse")
    private boolean rootWidgetReuse;

    public kb1() {
        this.renderWidgetReuse = true;
        this.renderWidgetFeedReuse = true;
        this.renderWidgetPoolSize = 10;
        this.renderWidgetReleaseTime = 900;
        this.rootWidgetReuse = true;
        this.renderWidgetCacheSize = 2;
        this.mainWidgetCacheSize = 1;
        this.mainWidgetPreloadDelay = 3;
        this.renderWidgetPreloadDelay = 5;
        this.rootWidgetReleaseTime = 900;
    }

    public final boolean a() {
        return this.logicWidgetFeedReuse;
    }

    public final int b() {
        return this.mainWidgetCacheSize;
    }

    public final long c() {
        return this.mainWidgetPreloadDelay;
    }

    public final int d() {
        return this.renderWidgetCacheSize;
    }

    public final boolean e() {
        return this.renderWidgetFeedReuse;
    }

    public final int f() {
        return this.renderWidgetPoolSize;
    }

    public final long g() {
        return this.renderWidgetPreloadDelay;
    }

    public final int h() {
        return this.renderWidgetReleaseTime;
    }

    public final boolean i() {
        return this.renderWidgetReuse;
    }

    public final int j() {
        return this.rootWidgetReleaseTime;
    }

    public final boolean k() {
        return this.rootWidgetReuse;
    }
}
