package fc2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class a {

    @SerializedName("enable")
    public Boolean controlEnable;

    @SerializedName("danmaku_pending_list_threshold")
    public int danmakuPendingListThreshold;

    @SerializedName("danmaku_shooter_threshold")
    public int danmakuShooterThreshold;

    @SerializedName("egg_pending_list_threshold")
    public int eggPendingListThreshold;

    @SerializedName("egg_shooter_threshold")
    public int eggShooterThreshold;

    @SerializedName("message_list_size_threshold")
    public int messageListSizeThreshold;

    public a() {
        this.controlEnable = Boolean.TRUE;
        this.danmakuShooterThreshold = 30;
        this.eggShooterThreshold = 10;
        this.messageListSizeThreshold = 200;
        this.eggPendingListThreshold = 20;
        this.danmakuPendingListThreshold = 100;
    }
}
