package ch0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final int a;
    public final int b;
    public final List<Integer> c;

    /* JADX INFO: renamed from: ch0.a$a, reason: collision with other inner class name */
    public static final class C0007a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        List<Integer> r1 = this.c;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "FeedViewRoomState(uiLayout=" + this.a + ", scene=" + this.b + ", playModes=" + this.c + ")";
    }

    public a(int r2, int r3, List<Integer> r4) {
        Intrinsics.checkNotNullParameter(r4, "playModes");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static a a(a r1, int r2, int r3, List r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.b;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = r1.c;
    L11:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "playModes");
        return new a(r2, r3, r4);
    }
}
