package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lw20/af;", "", "", "openType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setOpenType", "(Ljava/lang/Integer;)V", "duration", "a", "setDuration", "loserNum", "b", "setLoserNum", "scoreType", "d", "setScoreType", "isAnchorInvolved", "f", "setAnchorInvolved", "uiType", "e", "setUiType", "<init>", "()V", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class af {

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("isAnchorInvolved")
    private Integer isAnchorInvolved;

    @SerializedName("loserNum")
    private Integer loserNum;

    @SerializedName("openType")
    private Integer openType;

    @SerializedName("scoreType")
    private Integer scoreType;

    @SerializedName("uiType")
    private Integer uiType;

    public af() {
    }

    public final Integer a() {
        return this.duration;
    }

    public final Integer b() {
        return this.loserNum;
    }

    public final Integer c() {
        return this.openType;
    }

    public final Integer d() {
        return this.scoreType;
    }

    public final Integer e() {
        return this.uiType;
    }

    public final Integer f() {
        return this.isAnchorInvolved;
    }
}
