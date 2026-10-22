package com.ss.android.lark.chat.api.service.impl;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f1<T, R> implements Function {
    public final /* synthetic */ e1 a;

    public f1(e1 r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        com.bytedance.lark.rustclient.api.s r4 = (com.bytedance.lark.rustclient.api.s) r3;
        Intrinsics.checkNotNullParameter(r4, "r");
        final e1 r1 = this.a;
        return com.bytedance.lark.rustclient.api.t.e(r4, new PrivateDescriptionRepository$pullUserPrivateDescriptions$2$1(r1));
    }
}
