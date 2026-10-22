package com.bytedance.android.livesdk.jsbridge.methods;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m1<T> implements Consumer {
    public final /* synthetic */ p1 a;

    public m1(p1 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Pair r4 = (Pair) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        int r0 = ((Number) r4.getFirst()).intValue();
        String r5 = (String) r4.getSecond();
        if (r0 != 0) goto L5;
        this.a.finishWithSuccess();
        return;
    L5:
        this.a.j(r0, r5);
    }
}
