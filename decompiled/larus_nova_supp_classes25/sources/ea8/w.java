package ea8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w {
    public final String a;
    public final String b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "TranslationResultItem(id=" + this.a + ", originalText=" + this.b + ", translationText=" + this.c + ')';
    }

    public w(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "originalText");
        Intrinsics.checkNotNullParameter(r4, "translationText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static w a(w r2, String r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        String r0 = r2.a;
    L7:
        if ((r5 & 2) == 0) goto L10;
        r3 = r2.b;
    L10:
        if ((r5 & 4) == 0) goto L12;
        r4 = r2.c;
    L12:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "id");
        Intrinsics.checkNotNullParameter(r3, "originalText");
        Intrinsics.checkNotNullParameter(r4, "translationText");
        return new w(r0, r3, r4);
    L5:
        r0 = null;
        goto L7
    }
}
