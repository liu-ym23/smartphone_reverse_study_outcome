package com.ss.android.lark.image.impl.preload;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/image/impl/preload/ImagePreloadConfig;", "", "preloadEnable", "", "networkLimit", "cpuLimit", "preloadCacheCount", "strategy", "", "Lcom/ss/android/lark/image/impl/preload/PreloadStrategy;", "<init>", "(IIII[Lcom/ss/android/lark/image/impl/preload/PreloadStrategy;)V", "getPreloadEnable", "()I", "setPreloadEnable", "(I)V", "getNetworkLimit", "setNetworkLimit", "getCpuLimit", "setCpuLimit", "getPreloadCacheCount", "setPreloadCacheCount", "getStrategy", "()[Lcom/ss/android/lark/image/impl/preload/PreloadStrategy;", "setStrategy", "([Lcom/ss/android/lark/image/impl/preload/PreloadStrategy;)V", "[Lcom/ss/android/lark/image/impl/preload/PreloadStrategy;", "Companion", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImagePreloadConfig {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int DEFAULT_CHAT_PRELOAD_MAX_COUNT = 20;
    public static final int DEFAULT_CPU_LIMIT = 80;
    public static final int DEFAULT_FEED_PRELOAD_MAX_COUNT = 5;
    public static final int DEFAULT_PRELOAD_CACHE_COUNT = 200;

    @SerializedName("cpu_limit")
    private int cpuLimit;

    @SerializedName("network_limit")
    private int networkLimit;

    @SerializedName("preload_cache_count")
    private int preloadCacheCount;

    @SerializedName("preload_enable")
    private int preloadEnable;

    @SerializedName("preload_strategy")
    private PreloadStrategy[] strategy;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/image/impl/preload/ImagePreloadConfig$Companion;", "", "<init>", "()V", "DEFAULT_CPU_LIMIT", "", "DEFAULT_PRELOAD_CACHE_COUNT", "DEFAULT_FEED_PRELOAD_MAX_COUNT", "DEFAULT_CHAT_PRELOAD_MAX_COUNT", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public ImagePreloadConfig() {
        this(0, 0, 0, 0, null, 31, null);
    }

    public final int getCpuLimit() {
        return this.cpuLimit;
    }

    public final int getNetworkLimit() {
        return this.networkLimit;
    }

    public final int getPreloadCacheCount() {
        return this.preloadCacheCount;
    }

    public final int getPreloadEnable() {
        return this.preloadEnable;
    }

    public final PreloadStrategy[] getStrategy() {
        return this.strategy;
    }

    public final void setCpuLimit(int r1) {
        this.cpuLimit = r1;
    }

    public final void setNetworkLimit(int r1) {
        this.networkLimit = r1;
    }

    public final void setPreloadCacheCount(int r1) {
        this.preloadCacheCount = r1;
    }

    public final void setPreloadEnable(int r1) {
        this.preloadEnable = r1;
    }

    public final void setStrategy(PreloadStrategy[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.strategy = r2;
    }

    public ImagePreloadConfig(int r2, int r3, int r4, int r5, PreloadStrategy[] r6) {
        Intrinsics.checkNotNullParameter(r6, "strategy");
        this.preloadEnable = r2;
        this.networkLimit = r3;
        this.cpuLimit = r4;
        this.preloadCacheCount = r5;
        this.strategy = r6;
    }

    public /* synthetic */ ImagePreloadConfig(int r5, int r6, int r7, int r8, PreloadStrategy[] r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        int r12 = 1;
    L7:
        if ((r10 & 2) == 0) goto L9;
        int r1 = 1;
    L11:
        if ((r10 & 4) == 0) goto L13;
        int r2 = 80;
    L15:
        if ((r10 & 8) == 0) goto L17;
        int r3 = DEFAULT_PRELOAD_CACHE_COUNT;
    L19:
        if ((r10 & 16) == 0) goto L21;
        r9 = new PreloadStrategy[]{new PreloadStrategy("feed", 1, 5), new PreloadStrategy("chat", 1, 20)};
    L21:
        this(r12, r1, r2, r3, r9);
        return;
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
