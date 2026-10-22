package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.CreateAddChatChatterApplyResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T> implements SdkSender.IParser {
    public final /* synthetic */ Function1<CreateAddChatChatterApplyResponse, Boolean> a;

    public a(x r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r3) {
        return (Boolean) this.a.invoke(CreateAddChatChatterApplyResponse.ADAPTER.decode(r3));
    }
}
