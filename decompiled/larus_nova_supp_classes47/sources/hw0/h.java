package hw0;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u0006+"}, d2 = {"Lhw0/h;", "", "", "exchangeType", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "setExchangeType", "(Ljava/lang/Integer;)V", "diamond", "d", "setDiamond", "goldAmount", "f", "setGoldAmount", "cashAmount", "a", "setCashAmount", "", "requestPage", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "setRequestPage", "(Ljava/lang/String;)V", "chargeScene", "c", "setChargeScene", "chargeReason", "b", "setChargeReason", "Lcom/google/gson/JsonObject;", "extra", "Lcom/google/gson/JsonObject;", "getExtra", "()Lcom/google/gson/JsonObject;", "setExtra", "(Lcom/google/gson/JsonObject;)V", "logExtra", "g", "setLogExtra", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h {

    @SerializedName("cashAmount")
    private Integer cashAmount;

    @SerializedName("chargeReason")
    private String chargeReason;

    @SerializedName("chargeScene")
    private String chargeScene;

    @SerializedName("diamond")
    private Integer diamond;

    @SerializedName("exchangeType")
    private Integer exchangeType;

    @SerializedName("extra")
    private JsonObject extra;

    @SerializedName("goldAmount")
    private Integer goldAmount;

    @SerializedName("logExtra")
    private JsonObject logExtra;

    @SerializedName("requestPage")
    private String requestPage;

    public h() {
    }

    public final Integer a() {
        return this.cashAmount;
    }

    public final String b() {
        return this.chargeReason;
    }

    public final String c() {
        return this.chargeScene;
    }

    public final Integer d() {
        return this.diamond;
    }

    public final Integer e() {
        return this.exchangeType;
    }

    public final Integer f() {
        return this.goldAmount;
    }

    public final JsonObject g() {
        return this.logExtra;
    }

    public final String h() {
        return this.requestPage;
    }
}
