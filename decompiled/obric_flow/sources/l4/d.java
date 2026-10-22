package l4;

import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\f¨\u0006\u0010"}, d2 = {"Ll4/d;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "b", "name", "c", "Ljava/lang/Object;", "getDefaultValue", "()Ljava/lang/Object;", "defaultValue", "d", "param", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("$t")
    private final String f19525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("n")
    private final String f19526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("d")
    private final Object f19527c;

    @SerializedName(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME)
    private final Object d;

    public d() {
        this.f19525a = null;
        this.f19526b = null;
        this.f19527c = null;
        this.d = null;
    }

    public final String a() {
        return this.f19525a;
    }

    public final String b() {
        return this.f19526b;
    }

    public final Object c() {
        return this.d;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        if (Intrinsics.areEqual(this.f19525a, r10.f19525a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19526b, r10.f19526b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19527c, r10.f19527c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f19525a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f19526b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        Object r16 = this.f19527c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        Object r19 = this.d;
        if (r19 == null) goto L19;
        r10 = r19.hashCode();
    L19:
        return r18 + r10;
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "Expression(id=" + this.f19525a + ", name=" + this.f19526b + ", defaultValue=" + this.f19527c + ", param=" + this.d + ')';
    }
}
