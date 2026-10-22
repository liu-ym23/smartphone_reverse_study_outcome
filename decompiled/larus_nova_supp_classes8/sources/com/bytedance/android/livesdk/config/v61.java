package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/v61;", "", "", "optMorePanel", "Z", "b", "()Z", "setOptMorePanel", "(Z)V", "Lcom/bytedance/android/livesdk/config/v61$a;", "longPressPanel", "Lcom/bytedance/android/livesdk/config/v61$a;", "a", "()Lcom/bytedance/android/livesdk/config/v61$a;", "setLongPressPanel", "(Lcom/bytedance/android/livesdk/config/v61$a;)V", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v61 {

    @SerializedName("long_press_panel")
    private a longPressPanel;

    @SerializedName("opt_more_panel")
    private boolean optMorePanel;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/v61$a;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "preloadRandomTime", "J", "d", "()J", "setPreloadRandomTime", "(J)V", "enableRecycle", "c", "setEnableRecycle", "isRecycleLifeInFeed", "e", "setRecycleLifeInFeed", "enablePreload", "b", "setEnablePreload", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("enable")
        private boolean enable;

        @SerializedName("enable_preload")
        private boolean enablePreload;

        @SerializedName("enable_recycle")
        private boolean enableRecycle;

        @SerializedName("is_recycle_life_in_feed")
        private boolean isRecycleLifeInFeed;

        @SerializedName("preload_random_time")
        private long preloadRandomTime;

        public a() {
            this.preloadRandomTime = 10;
        }

        public final boolean a() {
            return this.enable;
        }

        public final boolean b() {
            return this.enablePreload;
        }

        public final boolean c() {
            return this.enableRecycle;
        }

        public final long d() {
            return this.preloadRandomTime;
        }

        public final boolean e() {
            return this.isRecycleLifeInFeed;
        }
    }

    public v61() {
        this.longPressPanel = new a();
    }

    public final a a() {
        return this.longPressPanel;
    }

    public final boolean b() {
        return this.optMorePanel;
    }
}
