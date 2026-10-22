package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lw20/hb;", "", "", "tabId", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "setTabId", "(Ljava/lang/Integer;)V", "", "openUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setOpenUrl", "(Ljava/lang/String;)V", "openPanelHeightPercent", "b", "setOpenPanelHeightPercent", "", "adhereToStream", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "setAdhereToStream", "(Ljava/lang/Boolean;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class hb {

    @SerializedName("adhereToStream")
    private Boolean adhereToStream;

    @SerializedName("openPanelHeightPercent")
    private Integer openPanelHeightPercent;

    @SerializedName("openUrl")
    private String openUrl;

    @SerializedName("tabId")
    private Integer tabId;

    public hb() {
    }

    public final Boolean a() {
        return this.adhereToStream;
    }

    public final Integer b() {
        return this.openPanelHeightPercent;
    }

    public final String c() {
        return this.openUrl;
    }

    public final Integer d() {
        return this.tabId;
    }
}
