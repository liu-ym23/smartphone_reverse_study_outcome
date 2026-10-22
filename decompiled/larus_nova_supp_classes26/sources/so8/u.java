package so8;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class u implements Function1 {
    public final /* synthetic */ k a;

    public /* synthetic */ u(k r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        k r0 = this.a;
        k r5 = (k) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        if (Intrinsics.areEqual(r5.a, r0.a) == true) goto L5;
    L7:
        boolean r6 = false;
    L9:
        return Boolean.valueOf(r6);
    L5:
        if (r5.c != r0.c) goto L7;
        r6 = true;
        goto L9
    }
}
