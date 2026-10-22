package tf0;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R2\u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ltf0/u;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "key", "b", "", "", "Ltf0/a;", "items", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "", "relativeLocation", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class u {
    public boolean a;
    public boolean b;

    @SerializedName("items")
    private final Map<String, List<a>> items;

    @SerializedName("key")
    private final String key;

    @SerializedName("relativeLocation")
    private final Boolean relativeLocation;

    @SerializedName("type")
    private String type;

    public final String toString() {
        return "SeatAnimateInfo(type='" + this.type + "', key=" + this.key + ", items=" + this.items + ", hasBeenUsed=" + this.a + ')';
    }

    public final Map<String, List<a>> a() {
        return this.items;
    }

    public final String b() {
        return this.key;
    }

    public final Boolean c() {
        return this.relativeLocation;
    }

    public final String getType() {
        return this.type;
    }
}
