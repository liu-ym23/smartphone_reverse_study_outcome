package r12;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f¨\u0006!"}, d2 = {"Lr12/f;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "giftId", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setGiftId", "(Ljava/lang/Integer;)V", BuildConfig.FLAVOR, "toUserId", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setToUserId", "(Ljava/lang/String;)V", "giftCount", "b", "setGiftCount", "giftSource", "e", "setGiftSource", "giftBuffLevel", "a", "setGiftBuffLevel", "giftPrice", "d", "setGiftPrice", "trackJsonString", "g", "setTrackJsonString", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("giftBuffLevel")
    private Integer giftBuffLevel;

    @SerializedName("giftCount")
    private Integer giftCount;

    @SerializedName("giftId")
    private Integer giftId;

    @SerializedName("giftPrice")
    private Integer giftPrice;

    @SerializedName("giftSource")
    private String giftSource;

    @SerializedName("toUserId")
    private String toUserId;

    @SerializedName("trackJsonString")
    private String trackJsonString;

    public f() {
    }

    public final Integer a() {
        return this.giftBuffLevel;
    }

    public final Integer b() {
        return this.giftCount;
    }

    public final Integer c() {
        return this.giftId;
    }

    public final Integer d() {
        return this.giftPrice;
    }

    public final String e() {
        return this.giftSource;
    }

    public final String f() {
        return this.toUserId;
    }

    public final String g() {
        return this.trackJsonString;
    }
}
