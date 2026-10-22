package kb8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public final boolean a;
    public final String b;
    public final List<u> c;
    public final o d;
    public final boolean e;
    public final boolean f;
    public final DeepThinkFoldStatus g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        o r3 = this.d;
        if (r3 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.e == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.f == true) goto L19;
        r1 = 1237;
    L19:
        return ((r7 + r1) * 31) + this.g.hashCode();
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "QueryKeywordReferencesViewInput(needSetData=" + this.a + ", queries=" + this.b + ", referenceList=" + this.c + ", referenceData=" + this.d + ", needReferenceShowAnimation=" + this.e + ", needNotifyLastItemChanged=" + this.f + ", foldStatus=" + this.g + ')';
    }

    public i(boolean r2, String r3, List<u> r4, o r5, boolean r6, boolean r7, DeepThinkFoldStatus r8) {
        Intrinsics.checkNotNullParameter(r3, "queries");
        Intrinsics.checkNotNullParameter(r4, "referenceList");
        Intrinsics.checkNotNullParameter(r8, "foldStatus");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
