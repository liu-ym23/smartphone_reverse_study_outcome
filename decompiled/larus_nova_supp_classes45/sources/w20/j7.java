package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lw20/j7;", "", "", "song", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setSong", "(Ljava/lang/String;)V", "fromRequestType", "b", "setFromRequestType", "requestType", "e", "setRequestType", "queryUserId", "c", "setQueryUserId", "enterFrom", "a", "setEnterFrom", "", "requestMode", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "setRequestMode", "(Ljava/lang/Integer;)V", "<init>", "()V", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j7 {

    @SerializedName("enterFrom")
    private String enterFrom;

    @SerializedName("fromRequestType")
    private String fromRequestType;

    @SerializedName("queryUserId")
    private String queryUserId;

    @SerializedName("requestMode")
    private Integer requestMode;

    @SerializedName("requestType")
    private String requestType;

    @SerializedName("song")
    private String song;

    public j7() {
    }

    public final String a() {
        return this.enterFrom;
    }

    public final String b() {
        return this.fromRequestType;
    }

    public final String c() {
        return this.queryUserId;
    }

    public final Integer d() {
        return this.requestMode;
    }

    public final String e() {
        return this.requestType;
    }

    public final String f() {
        return this.song;
    }
}
