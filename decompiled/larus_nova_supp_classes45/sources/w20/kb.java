package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lw20/kb;", "", "", "status", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "gameType", "b", "setGameType", "", "gameId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class kb {

    @SerializedName("gameId")
    private String gameId;

    @SerializedName("gameType")
    private Integer gameType;

    @SerializedName("status")
    private Integer status;

    public kb() {
    }

    public final String a() {
        return this.gameId;
    }

    public final Integer b() {
        return this.gameType;
    }

    public final Integer c() {
        return this.status;
    }
}
