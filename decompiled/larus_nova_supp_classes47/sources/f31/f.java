package f31;

import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final List<k> a;
    public final RectF b;
    public final RectF c;
    public final Matrix d;
    public final o51.f e;
    public final com.bytedance.android.live.revlink.link.core.service.g f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L18;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        List<k> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        RectF r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        RectF r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Matrix r10 = this.d;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        o51.f r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        com.bytedance.android.live.revlink.link.core.service.g r17 = this.f;
        if (r17 == null) goto L26;
        r1 = r17.hashCode();
    L26:
        return r16 + r1;
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LayoutStatus(status=" + this.a + ", visibleArea=" + this.b + ", micVisibleArea=" + this.c + ", gridMatrix=" + this.d + ", uiLayoutIndex=" + this.e + ", containerMargin=" + this.f + ")";
    }

    public /* synthetic */ f(List r8, RectF r9, RectF r10, Matrix r12, o51.f r13) {
        this(r8, r9, r10, r12, r13, null);
    }

    public f(List<k> r2, RectF r3, RectF r4, Matrix r5, o51.f r6, com.bytedance.android.live.revlink.link.core.service.g r7) {
        Intrinsics.checkNotNullParameter(r3, "visibleArea");
        Intrinsics.checkNotNullParameter(r4, "micVisibleArea");
        Intrinsics.checkNotNullParameter(r5, "gridMatrix");
        Intrinsics.checkNotNullParameter(r6, "uiLayoutIndex");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
