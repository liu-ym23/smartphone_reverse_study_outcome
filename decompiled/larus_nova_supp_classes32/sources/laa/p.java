package laa;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p {
    public final Message a;
    public final String b;
    public final int c;
    public final float d;
    public final long e;
    public final String f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof p) == true) goto L8;
        return false;
    L8:
        p r9 = (p) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r9.d) == 0) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + Float.floatToIntBits(this.d)) * 31;
        long r1 = this.e;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "ObricMessageVisibilityEvent(message=" + this.a + ", messageKey=" + this.b + ", position=" + this.c + ", visibleRatio=" + this.d + ", visibleDurationMs=" + this.e + ", reason=" + this.f + ')';
    }

    public p(Message r2, String r3, int r4, float r5, long r6, String r8) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "messageKey");
        Intrinsics.checkNotNullParameter(r8, "reason");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
    }
}
