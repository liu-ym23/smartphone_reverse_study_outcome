package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.GetRepliesResponse;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m1<T, R> implements Function {
    public final /* synthetic */ Function1<GetRepliesResponse, List<MessageInfo>> a;

    public m1(t1 r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (List) this.a.invoke(r3.c);
    }
}
