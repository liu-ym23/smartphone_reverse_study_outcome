package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\b¨\u0006+"}, d2 = {"Lw20/s8;", "", "", "scene", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "flow", "d", "setFlow", "ticket", "i", "setTicket", "cert_app_id", "a", "setCert_app_id", "identity_name", "f", "setIdentity_name", "identity_code", "e", "setIdentity_code", "", "face_only", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setFace_only", "(Ljava/lang/Boolean;)V", "Lorg/json/JSONObject;", "extra_params", "Lorg/json/JSONObject;", "b", "()Lorg/json/JSONObject;", "setExtra_params", "(Lorg/json/JSONObject;)V", "mode", "g", "setMode", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s8 {

    @SerializedName("cert_app_id")
    private String cert_app_id;

    @SerializedName("extra_params")
    private JSONObject extra_params;

    @SerializedName("face_only")
    private Boolean face_only;

    @SerializedName("flow")
    private String flow;

    @SerializedName("identity_code")
    private String identity_code;

    @SerializedName("identity_name")
    private String identity_name;

    @SerializedName("mode")
    private String mode;

    @SerializedName("scene")
    private String scene;

    @SerializedName("ticket")
    private String ticket;

    public s8() {
    }

    public final String a() {
        return this.cert_app_id;
    }

    public final JSONObject b() {
        return this.extra_params;
    }

    public final Boolean c() {
        return this.face_only;
    }

    public final String d() {
        return this.flow;
    }

    public final String e() {
        return this.identity_code;
    }

    public final String f() {
        return this.identity_name;
    }

    public final String g() {
        return this.mode;
    }

    public final String h() {
        return this.scene;
    }

    public final String i() {
        return this.ticket;
    }
}
