package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lw20/qd;", "", "", "charge_reason", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setCharge_reason", "(Ljava/lang/String;)V", "", "price", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "setPrice", "(Ljava/lang/Integer;)V", "", "manual_open_recharge", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setManual_open_recharge", "(Ljava/lang/Boolean;)V", "Lw20/qd$a;", "args", "Lw20/qd$a;", "a", "()Lw20/qd$a;", "setArgs", "(Lw20/qd$a;)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class qd {

    @SerializedName("args")
    private a args;

    @SerializedName("charge_reason")
    private String charge_reason;

    @SerializedName("manual_open_recharge")
    private Boolean manual_open_recharge;

    @SerializedName("price")
    private Integer price;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lw20/qd$a;", "", "", "business_scene", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setBusiness_scene", "(Ljava/lang/Integer;)V", "", "callback_scheme", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setCallback_scheme", "(Ljava/lang/String;)V", "charge_type", "getCharge_type", "setCharge_type", "request_page", "d", "setRequest_page", "type", "getType", "setType", "Lcom/google/gson/JsonObject;", "extra", "Lcom/google/gson/JsonObject;", "c", "()Lcom/google/gson/JsonObject;", "setExtra", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("business_scene")
        private Integer business_scene;

        @SerializedName("callback_scheme")
        private String callback_scheme;

        @SerializedName("charge_type")
        private Integer charge_type;

        @SerializedName("extra")
        private JsonObject extra;

        @SerializedName("request_page")
        private String request_page;

        @SerializedName("type")
        private String type;

        public a() {
        }

        public final Integer a() {
            return this.business_scene;
        }

        public final String b() {
            return this.callback_scheme;
        }

        public final JsonObject c() {
            return this.extra;
        }

        public final String d() {
            return this.request_page;
        }

        public final String getType() {
            return this.type;
        }
    }

    public qd() {
    }

    public final a a() {
        return this.args;
    }

    public final String b() {
        return this.charge_reason;
    }

    public final Boolean c() {
        return this.manual_open_recharge;
    }

    public final Integer d() {
        return this.price;
    }
}
