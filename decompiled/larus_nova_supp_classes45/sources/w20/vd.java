package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001c"}, d2 = {"Lw20/vd;", "", "", "card_type", "Ljava/lang/Integer;", "getCard_type", "()Ljava/lang/Integer;", "setCard_type", "(Ljava/lang/Integer;)V", "Lcom/google/gson/JsonObject;", "card_info", "Lcom/google/gson/JsonObject;", "a", "()Lcom/google/gson/JsonObject;", "setCard_info", "(Lcom/google/gson/JsonObject;)V", "", "keep_operation_level", "Ljava/lang/Boolean;", "getKeep_operation_level", "()Ljava/lang/Boolean;", "setKeep_operation_level", "(Ljava/lang/Boolean;)V", "extra_params", "getExtra_params", "setExtra_params", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class vd {

    @SerializedName("card_info")
    private JsonObject card_info;

    @SerializedName("card_type")
    private Integer card_type;

    @SerializedName("extra_params")
    private JsonObject extra_params;

    @SerializedName("keep_operation_level")
    private Boolean keep_operation_level;

    public vd() {
    }

    public final JsonObject a() {
        return this.card_info;
    }
}
