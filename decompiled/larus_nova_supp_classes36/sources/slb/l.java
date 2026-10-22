package slb;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l {
    public final boolean a;
    public final Map<String, String> b;
    public final String c;

    public l() {
        this(null, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
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
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
        String r2 = this.c;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "PromptConfirmOptions(isPreviewMode=" + this.a + ", param=" + this.b + ", writingPlaceholder=" + this.c + ')';
    }

    public l(Map r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r3 & 2) == 0) goto L9;
        r2 = new LinkedHashMap();
    L9:
        Intrinsics.checkNotNullParameter(r2, "param");
        this.a = r0;
        this.b = r2;
        this.c = null;
        return;
    L5:
        r0 = false;
        goto L7
    }
}
