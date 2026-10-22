package g98;

import com.larus.avlink.env.DoraEnvObserveState;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final DoraEnvObserveState a;
    public final String b;
    public final EnvObserveChangeReason c;
    public final int d;
    public final int e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        EnvObserveChangeReason r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.d) * 31) + this.e;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraEnvObserveStateEvent(state=" + this.a + ", source=" + this.b + ", reason=" + this.c + ", type=" + this.d + ", code=" + this.e + ')';
    }

    public final int getType() {
        return this.d;
    }

    public /* synthetic */ f(DoraEnvObserveState r7, String r8) {
        this(r7, r8, null, 0, 0);
    }

    public f(DoraEnvObserveState r2, String r3, EnvObserveChangeReason r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
