package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g2<T> implements Predicate {
    public final /* synthetic */ Object a;

    public g2(Object r1) {
        this.a = r1;
    }

    public final boolean test(Object r2) {
        com.bytedance.android.livesdk.event.z r3 = (com.bytedance.android.livesdk.event.z) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r3.a != this.a) goto L5;
        return true;
    L5:
        return false;
    }
}
