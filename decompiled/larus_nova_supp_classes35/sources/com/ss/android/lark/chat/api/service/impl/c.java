package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.HideChatTranslatedNameResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T> implements SdkSender.IParser {
    public final /* synthetic */ Function1<HideChatTranslatedNameResponse, Boolean> a;

    public c(r r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r3) {
        return (Boolean) this.a.invoke(HideChatTranslatedNameResponse.ADAPTER.decode(r3));
    }
}
