package va8;

import com.larus.bmhome.ability.FloatChatWindowState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public final FloatChatWindowState a;
    public final int b;
    public final int c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
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
        return (((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "FloatChatWindowSnapshot(state=" + this.a + ", heightPx=" + this.b + ", showPercent=" + this.c + ", from=" + this.d + ')';
    }

    public h(FloatChatWindowState r2, int r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r5, "from");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
