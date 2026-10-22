package gb;

import com.bytedance.android.anniex.solutions.card.util.DataTypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lgb/d;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "b", "", "params", "Ljava/util/List;", "c", "()Ljava/util/List;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("n")
    private final String name;

    @SerializedName("p")
    @JsonAdapter(DataTypeAdapter.class)
    private final List<Object> params;

    @SerializedName("$t")
    private final String type;

    public d() {
        this(null, null, null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (Intrinsics.areEqual(this.type, r11.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r11.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r11.params) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.type;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.name;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        List<Object> r15 = this.params;
        if (r15 == null) goto L15;
        r1 = r15.hashCode();
    L15:
        return r14 + r1;
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "Option(type=" + this.type + ", name=" + this.name + ", params=" + this.params + ')';
    }

    public final String b() {
        return this.name;
    }

    public final List<Object> c() {
        return this.params;
    }

    public final String getType() {
        return this.type;
    }

    public static d a(d r10, List r11) {
        return new d(r10.type, r10.name, r11);
    }

    public d(String r1, String r10, List<? extends Object> r11) {
        this.type = r1;
        this.name = r10;
        this.params = r11;
    }
}
