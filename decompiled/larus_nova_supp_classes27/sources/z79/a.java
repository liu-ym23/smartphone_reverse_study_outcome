package z79;

import ic8.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final d a;
    public final d b;
    public final d c;
    public final d d;

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
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "DriveGalleryAiEditParam(aiImageToVideoParam=" + this.a + ", aiImageEditParam=" + this.b + ", aiImageSharpnessParam=" + this.c + ", aiImageEraseParam=" + this.d + ')';
    }

    public a() {
        this(new d(false, null, null, false, null, null, 63), new d(false, null, null, false, null, null, 63), new d(false, null, null, false, null, null, 63), new d(false, null, null, false, null, null, 63));
    }

    public a(d r2, d r3, d r4, d r5) {
        Intrinsics.checkNotNullParameter(r2, "aiImageToVideoParam");
        Intrinsics.checkNotNullParameter(r3, "aiImageEditParam");
        Intrinsics.checkNotNullParameter(r4, "aiImageSharpnessParam");
        Intrinsics.checkNotNullParameter(r5, "aiImageEraseParam");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
