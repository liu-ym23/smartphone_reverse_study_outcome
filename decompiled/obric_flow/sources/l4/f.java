package l4;

import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.bytedance.android.anniex.solutions.card.util.DataTypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R$\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u000f"}, d2 = {"Ll4/f;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "type", "b", "name", "", "c", "Ljava/util/List;", "()Ljava/util/List;", LynxResourceModule.PARAMS_KEY, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("$t")
    private final String f19531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("n")
    private final String f19532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME)
    @JsonAdapter(DataTypeAdapter.class)
    private final List<Object> f19533c;

    public f() {
        this.f19531a = null;
        this.f19532b = null;
        this.f19533c = null;
    }

    public static f b(f r5, ArrayList r10) {
        return new f(r5.f19531a, r5.f19532b, r10);
    }

    public final String a() {
        return this.f19532b;
    }

    public final List c() {
        return this.f19533c;
    }

    public final String d() {
        return this.f19531a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r10 = (f) r5;
        if (Intrinsics.areEqual(this.f19531a, r10.f19531a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19532b, r10.f19532b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19533c, r10.f19533c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f19531a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f19532b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        List<Object> r16 = this.f19533c;
        if (r16 == null) goto L15;
        r10 = r16.hashCode();
    L15:
        return r15 + r10;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Option(type=");
        r5.append(this.f19531a);
        r5.append(", name=");
        r5.append(this.f19532b);
        r5.append(", params=");
        return androidx.constraintlayout.motion.widget.a.v(r5, this.f19533c, ')');
    }

    public f(String r5, String r10, ArrayList r11) {
        this.f19531a = r5;
        this.f19532b = r10;
        this.f19533c = r11;
    }
}
