package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001f"}, d2 = {"Lw20/of;", "", "", "giftId", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "setGiftId", "(Ljava/lang/Long;)V", "toUserId", "e", "setToUserId", "", "secToUserId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setSecToUserId", "(Ljava/lang/String;)V", "", "count", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setCount", "(Ljava/lang/Integer;)V", "diamondCount", "b", "setDiamondCount", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class of {

    @SerializedName("count")
    private Integer count;

    @SerializedName("diamondCount")
    private Integer diamondCount;

    @SerializedName("giftId")
    private Long giftId;

    @SerializedName("secToUserId")
    private String secToUserId;

    @SerializedName("toUserId")
    private Long toUserId;

    public of() {
    }

    public final Integer a() {
        return this.count;
    }

    public final Integer b() {
        return this.diamondCount;
    }

    public final Long c() {
        return this.giftId;
    }

    public final String d() {
        return this.secToUserId;
    }

    public final Long e() {
        return this.toUserId;
    }
}
