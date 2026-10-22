package xh0;

import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public final IncompatibleTag a;
    public final int b;
    public final boolean c;
    public final String d;
    public final String e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L16;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        IncompatibleTag r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        boolean r4 = this.c;
        ?? r5 = r4;
        if (r4 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r3 + r5) * 31;
        String r7 = this.d;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        String r10 = this.e;
        if (r10 == null) goto L17;
        r1 = r10.hashCode();
    L17:
        return r9 + r1;
    L12:
        r8 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PlayModeCheckResult(incompatibleTag=" + this.a + ", ruleKey=" + this.b + ", result=" + this.c + ", reason=" + this.d + ", toast=" + this.e + ")";
    }

    public /* synthetic */ g(IncompatibleTag r7, int r8, boolean r9, String r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        int r2 = -1;
    L7:
        if ((r11 & 8) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r11 & 16) == 0) goto L13;
        String r5 = "";
    L14:
        this(r7, r2, r9, r4, r5);
        return;
    L13:
        r5 = null;
        goto L14
    L9:
        r4 = r10;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    public g(IncompatibleTag r2, int r3, boolean r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "incompatibleTag");
        Intrinsics.checkNotNullParameter(r5, "reason");
        Intrinsics.checkNotNullParameter(r6, "toast");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
