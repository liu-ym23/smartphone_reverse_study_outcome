package va8;

import ic8.w;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o0 implements j0 {
    public final Function1<w, String> a;
    public final Function1<w, Boolean> b;

    @Override // va8.j0
    public final String a(w r3) {
        Intrinsics.checkNotNullParameter(r3, "strategy");
        Function1<w, Boolean> r0 = this.b;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L11;
        return null;
    L11:
        return (String) this.a.invoke(r3);
    L5:
        if (((Boolean) r0.invoke(r3)).booleanValue() == true) goto L7;
        r1 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o0(Function1<? super w, String> r2, Function1<? super w, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "lazyGenerator");
        this.a = r2;
        this.b = r3;
    }
}
