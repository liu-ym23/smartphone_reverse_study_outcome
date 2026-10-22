package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.im.v1.GetChatApplicationBadgeResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i<T, R> implements Function {
    public static final i<T, R> a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final Object apply(Object r2) {
        com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (GetChatApplicationBadgeResponse) r3.c;
    }
}
