package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.GetChatChatterKickResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements SdkSender.IParser {
    public final /* synthetic */ Function1<GetChatChatterKickResponse, com.ss.android.lark.chat.entity.chat.b> a;

    public b(t r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r3) {
        return (com.ss.android.lark.chat.entity.chat.b) this.a.invoke(GetChatChatterKickResponse.ADAPTER.decode(r3));
    }
}
