package vt1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lvt1/d;", "", "", "type", "Ljava/lang/Long;", "getType", "()Ljava/lang/Long;", "Lvt1/a;", "live", "Lvt1/a;", "a", "()Lvt1/a;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("lives")
    private final a live;

    @SerializedName("type")
    private final Long type;

    public d() {
        this.type = null;
        this.live = null;
    }

    public final a a() {
        return this.live;
    }

    public final Long getType() {
        return this.type;
    }
}
