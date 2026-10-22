package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lw20/ya;", "", "", "operateType", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setOperateType", "(Ljava/lang/String;)V", "Lcom/google/gson/JsonObject;", "params", "Lcom/google/gson/JsonObject;", "c", "()Lcom/google/gson/JsonObject;", "setParams", "(Lcom/google/gson/JsonObject;)V", "extra", "a", "setExtra", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ya {

    @SerializedName("extra")
    private String extra;

    @SerializedName("operateType")
    private String operateType;

    @SerializedName("params")
    private JsonObject params;

    public ya() {
    }

    public final String a() {
        return this.extra;
    }

    public final String b() {
        return this.operateType;
    }

    public final JsonObject c() {
        return this.params;
    }
}
