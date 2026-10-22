package e7;

import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR0\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Le7/n0;", "", "", com.bytedance.android.ec.core.event.a.KEY_URL, "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "", "replace", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setReplace", "(Ljava/lang/Boolean;)V", "replaceType", "d", "setReplaceType", "Lcom/google/gson/JsonObject;", BaseHybridComponent.INITIAL_PROPS_QUERY_KEY, "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "setInitialProps", "(Lcom/google/gson/JsonObject;)V", "useSysBrowser", "f", "setUseSysBrowser", "", "extra", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class n0 {

    @SerializedName("extra")
    private Map<String, ? extends Object> extra;

    @SerializedName(BaseHybridComponent.INITIAL_PROPS_QUERY_KEY)
    private JsonObject initialProps;

    @SerializedName("replace")
    private Boolean replace;

    @SerializedName("replaceType")
    private String replaceType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_URL)
    private String url;

    @SerializedName("useSysBrowser")
    private Boolean useSysBrowser;

    public n0() {
    }

    public final Map<String, Object> a() {
        return this.extra;
    }

    public final JsonObject b() {
        return this.initialProps;
    }

    public final Boolean c() {
        return this.replace;
    }

    public final String d() {
        return this.replaceType;
    }

    public final String e() {
        return this.url;
    }

    public final Boolean f() {
        return this.useSysBrowser;
    }
}
