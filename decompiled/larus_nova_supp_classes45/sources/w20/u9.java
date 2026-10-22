package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lw20/u9;", "", "", "userId", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "secUserId", "f", "setSecUserId", "", "isActive", "Ljava/lang/Boolean;", "h", "()Ljava/lang/Boolean;", "setActive", "(Ljava/lang/Boolean;)V", "isSubscriber", "i", "setSubscriber", "inRoom", "d", "setInRoom", "messageBoardId", "e", "setMessageBoardId", "content", "a", "setContent", "giftId", "b", "setGiftId", "", "giftMoney", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setGiftMoney", "(Ljava/lang/Integer;)V", "<init>", "()V", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u9 {

    @SerializedName("content")
    private String content;

    @SerializedName("giftId")
    private String giftId;

    @SerializedName("giftMoney")
    private Integer giftMoney;

    @SerializedName("inRoom")
    private Boolean inRoom;

    @SerializedName("isActive")
    private Boolean isActive;

    @SerializedName("isSubscriber")
    private Boolean isSubscriber;

    @SerializedName("messageBoardId")
    private String messageBoardId;

    @SerializedName("secUserId")
    private String secUserId;

    @SerializedName("userId")
    private String userId;

    public u9() {
    }

    public final String a() {
        return this.content;
    }

    public final String b() {
        return this.giftId;
    }

    public final Integer c() {
        return this.giftMoney;
    }

    public final Boolean d() {
        return this.inRoom;
    }

    public final String e() {
        return this.messageBoardId;
    }

    public final String f() {
        return this.secUserId;
    }

    public final String g() {
        return this.userId;
    }

    public final Boolean h() {
        return this.isActive;
    }

    public final Boolean i() {
        return this.isSubscriber;
    }
}
