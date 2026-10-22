package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.SubscribeChatEventResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e<T> implements SdkSender.IParser {
    public final /* synthetic */ Function1<SubscribeChatEventResponse, String> a;

    public e(b0 r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r3) {
        return (String) this.a.invoke(SubscribeChatEventResponse.ADAPTER.decode(r3));
    }
}
