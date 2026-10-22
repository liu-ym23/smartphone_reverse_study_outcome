package ea8;

import com.larus.avlink.simulInterpret.page.model.TextType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x {
    public final TextType a;
    public final String b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L8;
        return false;
    L8:
        x r6 = (x) r5;
        if (this.a == r6.a) goto L12;
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
        return "TranslationResultSentence(type=" + this.a + ", id=" + this.b + ", content=" + this.c + ')';
    }

    public final TextType getType() {
        return this.a;
    }

    public x(TextType r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, "content");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
