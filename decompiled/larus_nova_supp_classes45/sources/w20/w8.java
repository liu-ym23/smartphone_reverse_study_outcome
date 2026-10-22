package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lw20/w8;", "", "", "eventName", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "", "withCommonParams", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setWithCommonParams", "(Ljava/lang/Boolean;)V", "Lcom/google/gson/JsonObject;", "logParams", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "setLogParams", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w8 {

    @SerializedName("eventName")
    private String eventName;

    @SerializedName("logParams")
    private JsonObject logParams;

    @SerializedName("withCommonParams")
    private Boolean withCommonParams;

    public w8() {
    }

    public final String a() {
        return this.eventName;
    }

    public final JsonObject b() {
        return this.logParams;
    }

    public final Boolean c() {
        return this.withCommonParams;
    }
}
