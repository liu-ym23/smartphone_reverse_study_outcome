package di8;

import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.d1;
import com.larus.bmhome.actionbar.model.t0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final List<t0> a;
    public final d1 b;
    public final List<b2> c;
    public final d1 d;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        d1 r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        d1 r5 = this.d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarNestedMenuItems(modeItems=" + this.a + ", modeExposeConfig=" + this.b + ", modelItems=" + this.c + ", modelExposeConfig=" + this.d + ')';
    }

    public /* synthetic */ a(List r4, d1 r5, int r6) {
        if ((r6 & 1) == 0) goto L5;
        List r0 = CollectionsKt.emptyList();
    L7:
        if ((r6 & 4) == 0) goto L10;
        r4 = CollectionsKt.emptyList();
    L10:
        if ((r6 & 8) == 0) goto L12;
        r5 = null;
    L12:
        this(r0, null, r4, r5);
        return;
    L5:
        r0 = null;
        goto L7
    }

    public a(List<t0> r2, d1 r3, List<b2> r4, d1 r5) {
        Intrinsics.checkNotNullParameter(r2, "modeItems");
        Intrinsics.checkNotNullParameter(r4, "modelItems");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
