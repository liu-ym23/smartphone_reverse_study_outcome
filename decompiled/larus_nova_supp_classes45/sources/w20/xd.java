package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lw20/xd;", "", "", "tag", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "label", "e", "setLabel", "refer", "g", "setRefer", "creative_id", "b", "setCreative_id", "log_extra", "f", "setLog_extra", "Lcom/google/gson/JsonObject;", "extParam", "Lcom/google/gson/JsonObject;", "c", "()Lcom/google/gson/JsonObject;", "setExtParam", "(Lcom/google/gson/JsonObject;)V", "group_id", "d", "setGroup_id", "category", "a", "setCategory", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class xd {

    @SerializedName("category")
    private String category;

    @SerializedName("creative_id")
    private String creative_id;

    @SerializedName("extParam")
    private JsonObject extParam;

    @SerializedName("group_id")
    private String group_id;

    @SerializedName("label")
    private String label;

    @SerializedName("log_extra")
    private String log_extra;

    @SerializedName("refer")
    private String refer;

    @SerializedName("tag")
    private String tag;

    public xd() {
    }

    public final String a() {
        return this.category;
    }

    public final String b() {
        return this.creative_id;
    }

    public final JsonObject c() {
        return this.extParam;
    }

    public final String d() {
        return this.group_id;
    }

    public final String e() {
        return this.label;
    }

    public final String f() {
        return this.log_extra;
    }

    public final String g() {
        return this.refer;
    }

    public final String h() {
        return this.tag;
    }
}
