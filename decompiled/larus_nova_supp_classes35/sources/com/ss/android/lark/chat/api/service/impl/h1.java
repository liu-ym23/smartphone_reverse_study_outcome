package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.GetChannelThreadsResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h1<T> implements SdkSender.IParser {
    public final /* synthetic */ Function1<GetChannelThreadsResponse, l5b.b> a;

    public h1(p1 r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r3) {
        return (l5b.b) this.a.invoke(GetChannelThreadsResponse.ADAPTER.decode(r3));
    }
}
