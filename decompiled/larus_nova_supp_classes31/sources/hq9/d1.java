package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/larus/platform/model/FirstFeedOptConfig;", "", "enableBannerOpt", "", "enableFirstFeedShowOptV2", "messagePreloadSize", "", "<init>", "(ZZI)V", "getEnableBannerOpt", "()Z", "getEnableFirstFeedShowOptV2", "getMessagePreloadSize", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class d1 {

    @SerializedName("enable_banner_opt")
    private final boolean enableBannerOpt;

    @SerializedName("enable_first_feed_show_opt_v2")
    private final boolean enableFirstFeedShowOptV2;

    @SerializedName("message_preload_size")
    private final int messagePreloadSize;

    public d1() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d1) == true) goto L8;
        return false;
    L8:
        d1 r6 = (d1) r5;
        if (this.enableBannerOpt == r6.enableBannerOpt) goto L12;
        return false;
    L12:
        if (this.enableFirstFeedShowOptV2 == r6.enableFirstFeedShowOptV2) goto L15;
        return false;
    L15:
        if (this.messagePreloadSize == r6.messagePreloadSize) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enableBannerOpt == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableFirstFeedShowOptV2 == true) goto L11;
        r1 = 1237;
    L11:
        return ((r2 + r1) * 31) + this.messagePreloadSize;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "FirstFeedOptConfig(enableBannerOpt=" + this.enableBannerOpt + ", enableFirstFeedShowOptV2=" + this.enableFirstFeedShowOptV2 + ", messagePreloadSize=" + this.messagePreloadSize + ')';
    }

    public final boolean a() {
        return this.enableBannerOpt;
    }

    public final boolean b() {
        return this.enableFirstFeedShowOptV2;
    }

    public final int c() {
        return this.messagePreloadSize;
    }

    public /* synthetic */ d1(int r3) {
        this(false, true, 16);
    }

    public d1(boolean r1, boolean r2, int r3) {
        this.enableBannerOpt = r1;
        this.enableFirstFeedShowOptV2 = r2;
        this.messagePreloadSize = r3;
    }
}
