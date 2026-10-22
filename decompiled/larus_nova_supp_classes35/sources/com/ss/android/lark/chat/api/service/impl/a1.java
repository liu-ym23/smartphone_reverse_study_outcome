package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.url.v1.MGetUrlPreviewResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a1<T, R> implements Function {
    public static final a1<T, R> a = null;

    static {
        a = new a1();
    }

    public a1() {
    }

    public final Object apply(Object r2) {
        com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (MGetUrlPreviewResponse) r3.c;
    }
}
