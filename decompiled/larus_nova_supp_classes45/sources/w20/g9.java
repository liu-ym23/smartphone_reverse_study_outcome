package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lw20/g9;", "", "", "loadType", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setLoadType", "(Ljava/lang/String;)V", "", "time", "Ljava/lang/Integer;", "getTime", "()Ljava/lang/Integer;", "setTime", "(Ljava/lang/Integer;)V", "trackID", "c", "setTrackID", "", "isCustom", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "setCustom", "(Ljava/lang/Boolean;)V", "name", "b", "setName", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g9 {

    @SerializedName("isCustom")
    private Boolean isCustom;

    @SerializedName("loadType")
    private String loadType;

    @SerializedName("name")
    private String name;

    @SerializedName("time")
    private Integer time;

    @SerializedName("trackID")
    private String trackID;

    public g9() {
    }

    public final String a() {
        return this.loadType;
    }

    public final String b() {
        return this.name;
    }

    public final String c() {
        return this.trackID;
    }

    public final Boolean d() {
        return this.isCustom;
    }
}
