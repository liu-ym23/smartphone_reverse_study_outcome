package e7;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&¨\u0006,"}, d2 = {"Le7/s0;", "", "", com.bytedance.android.ec.core.event.a.KEY_URL, "Ljava/lang/String;", "g", "()Ljava/lang/String;", "m", "(Ljava/lang/String;)V", "method", "c", "j", "Lcom/google/gson/JsonObject;", "header", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "i", "(Lcom/google/gson/JsonObject;)V", "Lcom/google/gson/JsonElement;", "body", "Lcom/google/gson/JsonElement;", "a", "()Lcom/google/gson/JsonElement;", "setBody", "(Lcom/google/gson/JsonElement;)V", "responseType", "f", "l", "params", "e", "setParams", "", "usePrefetch", "Ljava/lang/Boolean;", "h", "()Ljava/lang/Boolean;", "setUsePrefetch", "(Ljava/lang/Boolean;)V", "needCommonParams", "d", "k", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class s0 {

    @SerializedName("body")
    private JsonElement body;

    @SerializedName("header")
    private JsonObject header;

    @SerializedName("method")
    private String method;

    @SerializedName("needCommonParams")
    private Boolean needCommonParams;

    @SerializedName("params")
    private JsonObject params;

    @SerializedName("responseType")
    private String responseType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_URL)
    private String url;

    @SerializedName("usePrefetch")
    private Boolean usePrefetch;

    public s0() {
    }

    public final JsonElement a() {
        return this.body;
    }

    public final JsonObject b() {
        return this.header;
    }

    public final String c() {
        return this.method;
    }

    public final Boolean d() {
        return this.needCommonParams;
    }

    public final JsonObject e() {
        return this.params;
    }

    public final String f() {
        return this.responseType;
    }

    public final String g() {
        return this.url;
    }

    public final Boolean h() {
        return this.usePrefetch;
    }

    public final void i(JsonObject r1) {
        this.header = r1;
    }

    public final void j(String r1) {
        this.method = r1;
    }

    public final void k(Boolean r1) {
        this.needCommonParams = r1;
    }

    public final void l(String r1) {
        this.responseType = r1;
    }

    public final void m(String r1) {
        this.url = r1;
    }
}
