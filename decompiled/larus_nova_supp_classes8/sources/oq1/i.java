package oq1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.CacheConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016¨\u0006\""}, d2 = {"Loq1/i;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "", "preloadSize", "J", "a", "()J", "setPreloadSize", "(J)V", "", "adFeedsLiveConfig", "I", "getAdFeedsLiveConfig", "()I", "setAdFeedsLiveConfig", "(I)V", "topViewConfig", "getTopViewConfig", "setTopViewConfig", "douyinOpenConfig", "getDouyinOpenConfig", "setDouyinOpenConfig", "feedDecorationConfig", "getFeedDecorationConfig", "setFeedDecorationConfig", "<init>", "()V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("adfeedslive_config")
    private int adFeedsLiveConfig;

    @SerializedName("douyinopen_config")
    private int douyinOpenConfig;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("feeddecoration_config")
    private int feedDecorationConfig;

    @SerializedName("preload_size")
    private long preloadSize;

    @SerializedName("topview_config")
    private int topViewConfig;

    public static final class a {
    }

    static {
    }

    public i() {
        this.preloadSize = 512000;
        CacheConfig r0 = CacheConfig.CACHE_API_AND_VIDEO;
        this.adFeedsLiveConfig = r0.getValue();
        this.topViewConfig = r0.getValue();
        this.douyinOpenConfig = r0.getValue();
        this.feedDecorationConfig = r0.getValue();
    }

    public final long a() {
        return this.preloadSize;
    }
}
