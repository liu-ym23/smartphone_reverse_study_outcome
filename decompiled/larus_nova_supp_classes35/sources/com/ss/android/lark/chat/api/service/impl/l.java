package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.CreateChatLastReadPositionResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l<T, R> implements Function {
    public final /* synthetic */ Function1<CreateChatLastReadPositionResponse, Void> a;

    public l(w r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        com.bytedance.lark.rustclient.api.s r3 = (com.bytedance.lark.rustclient.api.s) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return com.bytedance.lark.rustclient.api.t.e(r3, this.a);
    }
}
