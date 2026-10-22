package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lw20/mf;", "", "", "panel", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setPanel", "(Ljava/lang/String;)V", "effectId", "a", "setEffectId", "", "isApplied", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "setApplied", "(Ljava/lang/Boolean;)V", "extra", "b", "setExtra", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class mf {

    @SerializedName("effectId")
    private String effectId;

    @SerializedName("extra")
    private String extra;

    @SerializedName("isApplied")
    private Boolean isApplied;

    @SerializedName("panel")
    private String panel;

    public mf() {
    }

    public final String a() {
        return this.effectId;
    }

    public final String b() {
        return this.extra;
    }

    public final String c() {
        return this.panel;
    }

    public final Boolean d() {
        return this.isApplied;
    }
}
