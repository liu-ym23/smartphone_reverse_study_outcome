package yaa;

import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final ObricAiKeyGestureAction a;
    public final ObricAiKeyGestureState b;
    public final long c;
    public final long d;
    public final int e;
    public final int f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.d;
        return ((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.e) * 31) + this.f;
    }

    public final String toString() {
        return "ObricAiKeyGestureEvent(action=" + this.a + ", stateBefore=" + this.b + ", eventTimeMillis=" + this.c + ", downTimeMillis=" + this.d + ", durationMillis=" + this.e + ", firstTapDurationMillis=" + this.f + ')';
    }

    public a(ObricAiKeyGestureAction r2, ObricAiKeyGestureState r3, long r4, long r6, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "stateBefore");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r8;
        this.f = r9;
    }
}
