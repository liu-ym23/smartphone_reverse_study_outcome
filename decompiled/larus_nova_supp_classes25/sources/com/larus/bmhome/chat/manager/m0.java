package com.larus.bmhome.chat.manager;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m0 implements Function1 {
    public /* synthetic */ m0() {
    }

    public final Object invoke(Object r2) {
        PromptCacheManager.a r3 = (PromptCacheManager.a) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        List<String> r4 = r3.b();
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        return Boolean.valueOf(r5);
    L5:
        if (r4.isEmpty() == true) goto L8;
        r5 = false;
        goto L10
    }
}
