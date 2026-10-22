package ne8;

import com.larus.im.bean.message.block.Block;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public final int a;
    public final mf9.e b;
    public final Block c;
    public final Map<String, String> d;

    public m() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (this.a == r6.a) goto L12;
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
        int r0 = this.a * 31;
        mf9.e r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Block r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Map<String, String> r8 = this.d;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeepResearchData(viewType=" + this.a + ", reportPodcastData=" + this.b + ", block=" + this.c + ", clientExt=" + this.d + ')';
    }

    public m(int r3, mf9.e r4, Block r5, int r6) {
        LinkedHashMap r1 = null;
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r1 = new LinkedHashMap();
    L11:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r1;
    }
}
