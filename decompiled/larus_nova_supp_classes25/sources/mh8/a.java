package mh8;

import fh8.i;
import java.util.List;
import kc8.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements i {
    public final String a;
    public final List<jc8.a> b;
    public final b c;

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        b r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MarkdownEmbeddedBlockContext(valueId=" + this.a + ", models=" + this.b + ", blockDependConfig=" + this.c + ')';
    }

    @Override // fh8.i
    public final String a() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r2, List<? extends jc8.a> r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "valueId");
        Intrinsics.checkNotNullParameter(r3, "models");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
