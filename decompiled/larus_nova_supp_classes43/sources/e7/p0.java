package e7;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Le7/p0;", "", "", "mainUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "Lcom/google/gson/JsonObject;", "subRes", "Lcom/google/gson/JsonObject;", "c", "()Lcom/google/gson/JsonObject;", "setSubRes", "(Lcom/google/gson/JsonObject;)V", "containerType", "a", "setContainerType", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class p0 {

    @SerializedName("containerType")
    private String containerType;

    @SerializedName("mainUrl")
    private String mainUrl;

    @SerializedName("subRes")
    private JsonObject subRes;

    public p0() {
    }

    public final String a() {
        return this.containerType;
    }

    public final String b() {
        return this.mainUrl;
    }

    public final JsonObject c() {
        return this.subRes;
    }
}
