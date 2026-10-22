package ss0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010)\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010\u0012¨\u0006."}, d2 = {"Lss0/d;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "enableGiftAnimOpt", "getEnableGiftAnimOpt", "setEnableGiftAnimOpt", "", "delayTime", "J", "a", "()J", "setDelayTime", "(J)V", "", "sampling", "I", "h", "()I", "setSampling", "(I)V", "recycleData", "g", "setRecycleData", "predictPreRequest", "f", "setPredictPreRequest", "predictDelayTime", "e", "setPredictDelayTime", "multiAnchor", "c", "setMultiAnchor", "multiCache", "getMultiCache", "setMultiCache", "otherAnchorInitDelay", "d", "setOtherAnchorInitDelay", "<init>", "()V", "live-profile-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("delay_time")
    private long delayTime;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_gift_anim_opt")
    private boolean enableGiftAnimOpt;

    @SerializedName("multi_anchor")
    private boolean multiAnchor;

    @SerializedName("multi_cache")
    private boolean multiCache;

    @SerializedName("other_anchor_init_delay")
    private long otherAnchorInitDelay;

    @SerializedName("predict_delay_time")
    private long predictDelayTime;

    @SerializedName("predict_pre_request")
    private boolean predictPreRequest;

    @SerializedName("recycle_data")
    private boolean recycleData;

    @SerializedName("sampling")
    private int sampling;

    public d() {
        this.enableGiftAnimOpt = true;
        this.delayTime = -1;
        this.recycleData = true;
        this.predictDelayTime = -1;
        this.otherAnchorInitDelay = 3500;
    }

    public final long a() {
        return this.delayTime;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.multiAnchor;
    }

    public final long d() {
        return this.otherAnchorInitDelay;
    }

    public final long e() {
        return this.predictDelayTime;
    }

    public final boolean f() {
        return this.predictPreRequest;
    }

    public final boolean g() {
        return this.recycleData;
    }

    public final int h() {
        return this.sampling;
    }
}
