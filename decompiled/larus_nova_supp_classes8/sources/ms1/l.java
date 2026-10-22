package ms1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lms1/l;", "", "", "alertTilte", "Ljava/lang/String;", "getAlertTilte", "()Ljava/lang/String;", "setAlertTilte", "(Ljava/lang/String;)V", "alertDescription", "getAlertDescription", "setAlertDescription", "alertDescriptionPK", "getAlertDescriptionPK", "setAlertDescriptionPK", "alertDescriptionLink", "getAlertDescriptionLink", "setAlertDescriptionLink", "alertDescriptionMic", "getAlertDescriptionMic", "setAlertDescriptionMic", "alertAction", "getAlertAction", "setAlertAction", "guildBubble", "a", "setGuildBubble", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("alert_action")
    private String alertAction;

    @SerializedName("alert_description")
    private String alertDescription;

    @SerializedName("alert_description_link")
    private String alertDescriptionLink;

    @SerializedName("alert_description_mic")
    private String alertDescriptionMic;

    @SerializedName("alert_description_pk")
    private String alertDescriptionPK;

    @SerializedName("alert_title")
    private String alertTilte;

    @SerializedName("guide_bubble")
    private String guildBubble;

    public l() {
        this.alertTilte = "确定要重启直播吗?";
        this.alertDescription = "重启时观众会看到你暂时离开，恢复后将继续累计本场直播数据";
        this.alertDescriptionPK = "当前正在PK，重启后本场PK自动结束，确认重启吗？";
        this.alertDescriptionLink = "重启时观众会看到你暂时离开，恢复后将继续本场连线";
        this.alertDescriptionMic = "重启时观众会看到你暂时离开，恢复后将继续本场连麦";
        this.alertAction = "重启直播";
        this.guildBubble = "卡顿严重时可尝试重启直播";
    }

    public final String a() {
        return this.guildBubble;
    }
}
