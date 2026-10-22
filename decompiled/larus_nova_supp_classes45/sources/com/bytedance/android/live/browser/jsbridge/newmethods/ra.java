package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ra<T, R> implements Function {
    public static final ra a = null;

    static {
        a = new ra();
    }

    public ra() {
    }

    public final Object apply(Object r2) {
        com.ss.ugc.live.sdk.message.wrsc.data.a r3 = (com.ss.ugc.live.sdk.message.wrsc.data.a) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.g;
    }
}
