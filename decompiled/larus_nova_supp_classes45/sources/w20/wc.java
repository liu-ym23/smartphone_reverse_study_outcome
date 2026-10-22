package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006 "}, d2 = {"Lw20/wc;", "", "", "promoteGameId", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setPromoteGameId", "(Ljava/lang/String;)V", "gameName", "e", "setGameName", "roomId", "g", "setRoomId", "anchorId", "c", "setAnchorId", "clientKey", "d", "setClientKey", "agreementText", "a", "setAgreementText", "agreementUrl", "b", "setAgreementUrl", "playType", "getPlayType", "setPlayType", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class wc {

    @SerializedName("agreementText")
    private String agreementText;

    @SerializedName("agreementUrl")
    private String agreementUrl;

    @SerializedName("anchorId")
    private String anchorId;

    @SerializedName("clientKey")
    private String clientKey;

    @SerializedName("gameName")
    private String gameName;

    @SerializedName("playType")
    private String playType;

    @SerializedName("promoteGameId")
    private String promoteGameId;

    @SerializedName("roomId")
    private String roomId;

    public wc() {
    }

    public final String a() {
        return this.agreementText;
    }

    public final String b() {
        return this.agreementUrl;
    }

    public final String c() {
        return this.anchorId;
    }

    public final String d() {
        return this.clientKey;
    }

    public final String e() {
        return this.gameName;
    }

    public final String f() {
        return this.promoteGameId;
    }

    public final String g() {
        return this.roomId;
    }
}
