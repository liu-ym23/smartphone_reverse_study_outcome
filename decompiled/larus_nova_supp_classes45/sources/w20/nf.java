package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"¨\u0006("}, d2 = {"Lw20/nf;", "", "", "product", "Ljava/lang/String;", "getProduct", "()Ljava/lang/String;", "setProduct", "(Ljava/lang/String;)V", "businessType", "a", "setBusinessType", "traceName", "g", "setTraceName", "step", "f", "setStep", "", "errorCode", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setErrorCode", "(Ljava/lang/Integer;)V", "errorMessage", "c", "setErrorMessage", "Lcom/google/gson/JsonObject;", "index", "Lcom/google/gson/JsonObject;", "e", "()Lcom/google/gson/JsonObject;", "setIndex", "(Lcom/google/gson/JsonObject;)V", "extra", "d", "setExtra", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class nf {

    @SerializedName("businessType")
    private String businessType;

    @SerializedName("errorCode")
    private Integer errorCode;

    @SerializedName("errorMessage")
    private String errorMessage;

    @SerializedName("extra")
    private JsonObject extra;

    @SerializedName("index")
    private JsonObject index;

    @SerializedName("product")
    private String product;

    @SerializedName("step")
    private String step;

    @SerializedName("traceName")
    private String traceName;

    public nf() {
    }

    public final String a() {
        return this.businessType;
    }

    public final Integer b() {
        return this.errorCode;
    }

    public final String c() {
        return this.errorMessage;
    }

    public final JsonObject d() {
        return this.extra;
    }

    public final JsonObject e() {
        return this.index;
    }

    public final String f() {
        return this.step;
    }

    public final String g() {
        return this.traceName;
    }
}
