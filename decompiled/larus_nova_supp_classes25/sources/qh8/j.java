package qh8;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j implements Function1 {
    public /* synthetic */ j() {
    }

    public final Object invoke(Object r2) {
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "imageUrl");
        if (k.a(r3) == true) goto L5;
        return r3;
    L5:
        return "res:///2131240745";
    }
}
