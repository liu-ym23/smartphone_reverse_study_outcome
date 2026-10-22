package xs1;

import com.bytedance.android.livesdkapi.depend.model.live.LiveRoomMode;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0019"}, d2 = {"Lxs1/d;", "", "", "backSdkKey", "Ljava/lang/String;", "getBackSdkKey", "()Ljava/lang/String;", "setBackSdkKey", "(Ljava/lang/String;)V", "", "delayInterval", "J", "getDelayInterval", "()J", "setDelayInterval", "(J)V", "", "miniEnable", "Z", "getMiniEnable", "()Z", "liveModes", "getLiveModes", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("back_sdk_key")
    private String backSdkKey;

    @SerializedName("delay_interval")
    private long delayInterval;

    @SerializedName("live_modes")
    private final String liveModes;

    @SerializedName("enable_mini")
    private final boolean miniEnable;

    public d() {
        this.backSdkKey = "default";
        this.delayInterval = 30;
        this.miniEnable = true;
        StringBuilder r0 = new StringBuilder();
        r0.append(LiveRoomMode.Normal.getValue());
        r0.append(',');
        r0.append(LiveRoomMode.ThirdParty.getValue());
        this.liveModes = r0.toString();
    }
}
