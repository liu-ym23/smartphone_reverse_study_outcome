package ly8;

import com.larus.canvas.feature.component.base.ImageResId;
import com.larus.canvas.feature.component.base.TextRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final String a;
    public final ImageResId b;
    public final TextRes c;
    public final int d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d;
    }

    public final String toString() {
        return "DropdownItemData(id=" + this.a + ", icon=" + this.b + ", desc=" + this.c + ", color=" + this.d + ')';
    }

    public g(String r2, ImageResId r3, TextRes.StringResId r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "icon");
        Intrinsics.checkNotNullParameter(r4, "desc");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
