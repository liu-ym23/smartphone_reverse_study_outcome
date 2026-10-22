package w20;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lw20/mc;", "", "", "", "sharePosterList", "Ljava/util/List;", "d", "()Ljava/util/List;", "setSharePosterList", "(Ljava/util/List;)V", "", "addRoomInfo", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "setAddRoomInfo", "(Ljava/lang/Boolean;)V", "logExtra", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setLogExtra", "(Ljava/lang/String;)V", "logReflowExtra", "c", "setLogReflowExtra", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class mc {

    @SerializedName("addRoomInfo")
    private Boolean addRoomInfo;

    @SerializedName("logExtra")
    private String logExtra;

    @SerializedName("logReflowExtra")
    private String logReflowExtra;

    @SerializedName("sharePosterList")
    private List<String> sharePosterList;

    public mc() {
    }

    public final Boolean a() {
        return this.addRoomInfo;
    }

    public final String b() {
        return this.logExtra;
    }

    public final String c() {
        return this.logReflowExtra;
    }

    public final List<String> d() {
        return this.sharePosterList;
    }
}
