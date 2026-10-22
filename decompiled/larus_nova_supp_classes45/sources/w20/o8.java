package w20;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b*\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R$\u0010#\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR$\u0010,\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R$\u0010/\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0015\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019¨\u00064"}, d2 = {"Lw20/o8;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "", "", "senderAvatars", "Ljava/util/List;", "h", "()Ljava/util/List;", "setSenderAvatars", "(Ljava/util/List;)V", "giftID", "e", "setGiftID", "title", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "describe", "c", "setDescribe", "comboCount", "b", "setComboCount", "backgroundImage", "a", "setBackgroundImage", "iconImage", "g", "setIconImage", "duration", "d", "setDuration", "giftPrice", "f", "setGiftPrice", "userID", "j", "setUserID", "secUserID", "getSecUserID", "setSecUserID", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o8 {

    @SerializedName("backgroundImage")
    private String backgroundImage;

    @SerializedName("comboCount")
    private Integer comboCount;

    @SerializedName("describe")
    private String describe;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("giftID")
    private Integer giftID;

    @SerializedName("giftPrice")
    private Integer giftPrice;

    @SerializedName("iconImage")
    private String iconImage;

    @SerializedName("secUserID")
    private String secUserID;

    @SerializedName("senderAvatars")
    private List<String> senderAvatars;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private Integer type;

    @SerializedName("userID")
    private String userID;

    public o8() {
    }

    public final String a() {
        return this.backgroundImage;
    }

    public final Integer b() {
        return this.comboCount;
    }

    public final String c() {
        return this.describe;
    }

    public final Integer d() {
        return this.duration;
    }

    public final Integer e() {
        return this.giftID;
    }

    public final Integer f() {
        return this.giftPrice;
    }

    public final String g() {
        return this.iconImage;
    }

    public final Integer getType() {
        return this.type;
    }

    public final List<String> h() {
        return this.senderAvatars;
    }

    public final String i() {
        return this.title;
    }

    public final String j() {
        return this.userID;
    }
}
