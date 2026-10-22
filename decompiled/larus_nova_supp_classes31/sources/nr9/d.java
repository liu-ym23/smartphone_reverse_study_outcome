package nr9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003Jm\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/larus/platform/model/video/PrefetchVideoConfigMainbot;", "", "prefetchVideoCacheDuration", "", "prefetchVideoInnerSecondSize", "prefetchVideoInnerFirstSize", "prefetchVideoSessionPageThreshold", "prefetchVideoRepeatedCount", "prefetchVideoInnerUnconsumedSize", "prefetchVideoOuterFallbackSize", "prefetchVideoLastMessageRange", "prefetchVideoCacheMaxCount", "enablePreloadMergeOptimize", "", "<init>", "(IIIIIIIIIZ)V", "getPrefetchVideoCacheDuration", "()I", "getPrefetchVideoInnerSecondSize", "getPrefetchVideoInnerFirstSize", "getPrefetchVideoSessionPageThreshold", "getPrefetchVideoRepeatedCount", "getPrefetchVideoInnerUnconsumedSize", "getPrefetchVideoOuterFallbackSize", "getPrefetchVideoLastMessageRange", "getPrefetchVideoCacheMaxCount", "getEnablePreloadMergeOptimize", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class d {

    @SerializedName("enable_preload_merge_optimize")
    private final boolean enablePreloadMergeOptimize;

    @SerializedName("prefetch_video_cache_duration")
    private final int prefetchVideoCacheDuration;

    @SerializedName("prefetch_video_cache_max_count")
    private final int prefetchVideoCacheMaxCount;

    @SerializedName("prefetch_video_inner_first_size")
    private final int prefetchVideoInnerFirstSize;

    @SerializedName("prefetch_video_inner_second_size")
    private final int prefetchVideoInnerSecondSize;

    @SerializedName("prefetch_video_inner_unconsumed_size")
    private final int prefetchVideoInnerUnconsumedSize;

    @SerializedName("prefetch_video_last_message_range")
    private final int prefetchVideoLastMessageRange;

    @SerializedName("prefetch_video_outer_fallback_size")
    private final int prefetchVideoOuterFallbackSize;

    @SerializedName("prefetch_video_repeated_count")
    private final int prefetchVideoRepeatedCount;

    @SerializedName("prefetch_video_session_page_threshold")
    private final int prefetchVideoSessionPageThreshold;

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.prefetchVideoCacheDuration == r6.prefetchVideoCacheDuration) goto L12;
        return false;
    L12:
        if (this.prefetchVideoInnerSecondSize == r6.prefetchVideoInnerSecondSize) goto L15;
        return false;
    L15:
        if (this.prefetchVideoInnerFirstSize == r6.prefetchVideoInnerFirstSize) goto L18;
        return false;
    L18:
        if (this.prefetchVideoSessionPageThreshold == r6.prefetchVideoSessionPageThreshold) goto L21;
        return false;
    L21:
        if (this.prefetchVideoRepeatedCount == r6.prefetchVideoRepeatedCount) goto L24;
        return false;
    L24:
        if (this.prefetchVideoInnerUnconsumedSize == r6.prefetchVideoInnerUnconsumedSize) goto L27;
        return false;
    L27:
        if (this.prefetchVideoOuterFallbackSize == r6.prefetchVideoOuterFallbackSize) goto L30;
        return false;
    L30:
        if (this.prefetchVideoLastMessageRange == r6.prefetchVideoLastMessageRange) goto L33;
        return false;
    L33:
        if (this.prefetchVideoCacheMaxCount == r6.prefetchVideoCacheMaxCount) goto L36;
        return false;
    L36:
        if (this.enablePreloadMergeOptimize == r6.enablePreloadMergeOptimize) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((((this.prefetchVideoCacheDuration * 31) + this.prefetchVideoInnerSecondSize) * 31) + this.prefetchVideoInnerFirstSize) * 31) + this.prefetchVideoSessionPageThreshold) * 31) + this.prefetchVideoRepeatedCount) * 31) + this.prefetchVideoInnerUnconsumedSize) * 31) + this.prefetchVideoOuterFallbackSize) * 31) + this.prefetchVideoLastMessageRange) * 31) + this.prefetchVideoCacheMaxCount) * 31;
        if (this.enablePreloadMergeOptimize == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "PrefetchVideoConfigMainbot(prefetchVideoCacheDuration=" + this.prefetchVideoCacheDuration + ", prefetchVideoInnerSecondSize=" + this.prefetchVideoInnerSecondSize + ", prefetchVideoInnerFirstSize=" + this.prefetchVideoInnerFirstSize + ", prefetchVideoSessionPageThreshold=" + this.prefetchVideoSessionPageThreshold + ", prefetchVideoRepeatedCount=" + this.prefetchVideoRepeatedCount + ", prefetchVideoInnerUnconsumedSize=" + this.prefetchVideoInnerUnconsumedSize + ", prefetchVideoOuterFallbackSize=" + this.prefetchVideoOuterFallbackSize + ", prefetchVideoLastMessageRange=" + this.prefetchVideoLastMessageRange + ", prefetchVideoCacheMaxCount=" + this.prefetchVideoCacheMaxCount + ", enablePreloadMergeOptimize=" + this.enablePreloadMergeOptimize + ')';
    }

    public final boolean a() {
        return this.enablePreloadMergeOptimize;
    }

    public final int b() {
        return this.prefetchVideoCacheDuration;
    }

    public final int c() {
        return this.prefetchVideoCacheMaxCount;
    }

    public final int d() {
        return this.prefetchVideoInnerFirstSize;
    }

    public final int e() {
        return this.prefetchVideoInnerSecondSize;
    }

    public final int f() {
        return this.prefetchVideoInnerUnconsumedSize;
    }

    public final int g() {
        return this.prefetchVideoLastMessageRange;
    }

    public final int h() {
        return this.prefetchVideoOuterFallbackSize;
    }

    public final int i() {
        return this.prefetchVideoRepeatedCount;
    }

    public final int j() {
        return this.prefetchVideoSessionPageThreshold;
    }

    public d(int r2) {
        this.prefetchVideoCacheDuration = 60;
        this.prefetchVideoInnerSecondSize = 0;
        this.prefetchVideoInnerFirstSize = 8;
        this.prefetchVideoSessionPageThreshold = 4;
        this.prefetchVideoRepeatedCount = 10;
        this.prefetchVideoInnerUnconsumedSize = 2;
        this.prefetchVideoOuterFallbackSize = 1;
        this.prefetchVideoLastMessageRange = 5;
        this.prefetchVideoCacheMaxCount = 100;
        this.enablePreloadMergeOptimize = false;
    }
}
