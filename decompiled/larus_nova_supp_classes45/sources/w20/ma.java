package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lw20/ma;", "", "", "reqSource", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setReqSource", "(Ljava/lang/String;)V", "", "isNeedLeaveChannel", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setNeedLeaveChannel", "(Ljava/lang/Boolean;)V", "<init>", "()V", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ma {

    @SerializedName("isNeedLeaveChannel")
    private Boolean isNeedLeaveChannel;

    @SerializedName("reqSource")
    private String reqSource;

    public ma() {
    }

    public final String a() {
        return this.reqSource;
    }

    public final Boolean b() {
        return this.isNeedLeaveChannel;
    }
}
