package l4;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0004\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0011"}, d2 = {"Ll4/b;", "", "", "Ll4/d;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "expression", "Ll4/a;", "Ll4/a;", "c", "()Ll4/a;", "ifBlock", "elseBlock", "d", "thenBlock", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("expression")
    private final List<d> f19519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("if")
    private final a f19520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("else")
    private final a f19521c;

    @SerializedName("then")
    private final a d;

    public b() {
        this.f19519a = null;
        this.f19520b = null;
        this.f19521c = null;
        this.d = null;
    }

    public final a a() {
        return this.f19521c;
    }

    public final List b() {
        return this.f19519a;
    }

    public final a c() {
        return this.f19520b;
    }

    public final a d() {
        return this.d;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        if (Intrinsics.areEqual(this.f19519a, r10.f19519a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19520b, r10.f19520b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19521c, r10.f19521c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<d> r5 = this.f19519a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        a r13 = this.f19520b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        a r16 = this.f19521c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        a r19 = this.d;
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
        return "HighExec(expression=" + this.f19519a + ", ifBlock=" + this.f19520b + ", elseBlock=" + this.f19521c + ", thenBlock=" + this.d + ')';
    }
}
