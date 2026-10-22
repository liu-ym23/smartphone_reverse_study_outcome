package ss0;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class e {

    @SerializedName("lottery_open_auth")
    public boolean lotteryOpenAuth;

    @SerializedName("lottery_toast")
    public String lotteryToast;

    @SerializedName("lucky_box_toast")
    public String luckyBoxToast;

    @SerializedName("lucky_box_open_auth")
    public boolean luckyOpenAuth;

    @SerializedName("userpreview_toast")
    public String userpreviewToast;

    public e() {
        this.luckyOpenAuth = true;
        this.luckyBoxToast = "本直播在抖音和火山分发红包记录火山可见";
        this.lotteryOpenAuth = true;
        this.lotteryToast = "本直播在抖音和火山分发福袋记录火山可见";
        this.userpreviewToast = "可前往抖音查看";
    }
}
