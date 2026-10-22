package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.CreateChatLastReadPositionResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d<T> implements SdkSender.IParser {
    public final /* synthetic */ Function1<CreateChatLastReadPositionResponse, Void> a;

    public d(w r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r3) {
        return (Void) this.a.invoke(CreateChatLastReadPositionResponse.ADAPTER.decode(r3));
    }
}
