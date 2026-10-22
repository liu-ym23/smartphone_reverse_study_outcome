package ra1;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lra1/h;", "", "", "Lra1/g;", "sugList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setSugList", "(Ljava/util/List;)V", "", "requestId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "<init>", "()V", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {
    public String a;

    @SerializedName("rid")
    private String requestId;

    @SerializedName("sug_list")
    private List<g> sugList;

    public h() {
        this.requestId = "";
        this.a = "";
    }

    public final String a() {
        return this.requestId;
    }

    public final List<g> b() {
        return this.sugList;
    }
}
