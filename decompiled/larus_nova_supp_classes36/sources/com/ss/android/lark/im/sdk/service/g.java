package com.ss.android.lark.im.sdk.service;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g<T, R> implements Function {
    public static final g<T, R> a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final Object apply(Object r2) {
        com.bytedance.lark.rustclient.api.s r3 = (com.bytedance.lark.rustclient.api.s) r2;
        Intrinsics.checkNotNullParameter(r3, "r");
        return com.bytedance.lark.rustclient.api.t.e(r3, ImSdkChatServiceImplV2$isSelfInChat$1$1.INSTANCE);
    }
}
