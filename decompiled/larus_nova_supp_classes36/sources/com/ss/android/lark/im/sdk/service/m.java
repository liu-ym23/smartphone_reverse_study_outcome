package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.im.v1.GetChatChattersByIdsResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m<T, R> implements Function {
    public final /* synthetic */ String a;

    public m(String r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return com.ss.android.lark.parser.internal.j.b(((GetChatChattersByIdsResponse) r3.c).entity, this.a).c();
    }
}
