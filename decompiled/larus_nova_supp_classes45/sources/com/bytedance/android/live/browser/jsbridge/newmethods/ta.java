package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ta<T, R> implements Function {
    public final /* synthetic */ stc.b a;

    public ta(stc.b r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        com.ss.ugc.live.sdk.message.wrsc.data.a r4 = (com.ss.ugc.live.sdk.message.wrsc.data.a) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        return new Pair(this.a.a, r4);
    }
}
