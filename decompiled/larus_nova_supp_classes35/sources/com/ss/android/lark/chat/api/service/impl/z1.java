package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.TranslateMessagesV3Response;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class z1<T, R> implements Function {
    public final /* synthetic */ Function1<TranslateMessagesV3Response, fcb.a> a;

    public z1(d2 r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (fcb.a) this.a.invoke(r3.c);
    }
}
