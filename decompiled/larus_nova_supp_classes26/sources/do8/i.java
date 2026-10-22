package do8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final List<String> d;

    public i() {
        this(0);
    }

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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == true) goto L14;
        r1 = 1237;
    L14:
        int r5 = (r4 + r1) * 31;
        List<String> r6 = this.d;
        if (r6 != null) goto L17;
        int r7 = 0;
    L19:
        return r5 + r7;
    L17:
        r7 = r6.hashCode();
        goto L19
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "VLMContainerPreloadAndRecommendConfig(enableVideoRecommend=" + this.a + ", enableVideoPreload=" + this.b + ", enableVideoRecommendPreload=" + this.c + ", splitQuery=" + this.d + ')';
    }

    public /* synthetic */ i(int r2) {
        this(false, false, false, null);
    }

    public i(boolean r1, boolean r2, boolean r3, List<String> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
