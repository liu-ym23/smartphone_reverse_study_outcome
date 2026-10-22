package ns9;

import com.larus.reach.api.ReachType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t {
    public final l a;
    public final v b;
    public final s c;
    public final f d;
    public final r e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "ReachRequest(meta=" + this.a + ", target=" + this.b + ", policy=" + this.c + ", content=" + this.d + ", payload=" + this.e + ')';
    }

    public final ReachType getType() {
        return this.a.getType();
    }

    public /* synthetic */ t(l r13, a r14, s r15, f r16, int r17) {
        if ((r17 & 2) == 0) goto L5;
        a r4 = new a(0);
    L7:
        if ((r17 & 8) == 0) goto L9;
        f r6 = new f(null, null, null, null, null, 63);
    L11:
        if ((r17 & 16) == 0) goto L13;
        r r7 = new r(null, null, 3);
    L14:
        this(r13, r4, r15, r6, r7);
        return;
    L13:
        r7 = null;
        goto L14
    L9:
        r6 = r16;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    public t(l r2, v r3, s r4, f r5, r r6) {
        Intrinsics.checkNotNullParameter(r2, "meta");
        Intrinsics.checkNotNullParameter(r3, "target");
        Intrinsics.checkNotNullParameter(r4, "policy");
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r6, "payload");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
