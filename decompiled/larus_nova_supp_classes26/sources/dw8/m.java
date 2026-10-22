package dw8;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m {
    public final Function0<Boolean> a;
    public final Function0<Unit> b;
    public final Function1<String, Boolean> c;
    public final Function1<String, Boolean> d;
    public final boolean e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
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
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "AIChatHostConfig(canInterceptBack=" + this.a + ", onBackIntercepted=" + this.b + ", onLinkIntercepted=" + this.c + ", onArtifactIntercepted=" + this.d + ", imageSkipDownscaleEnabled=" + this.e + ')';
    }

    public m() {
        this(new zb8.c(), new j(), new k(), new l(), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function0<Boolean> r2, Function0<Unit> r3, Function1<? super String, Boolean> r4, Function1<? super String, Boolean> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "canInterceptBack");
        Intrinsics.checkNotNullParameter(r3, "onBackIntercepted");
        Intrinsics.checkNotNullParameter(r4, "onLinkIntercepted");
        Intrinsics.checkNotNullParameter(r5, "onArtifactIntercepted");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
