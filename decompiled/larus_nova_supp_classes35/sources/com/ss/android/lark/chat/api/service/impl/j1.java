package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.GetThreadMessagesV2Response;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j1<T> implements SdkSender.IParser {
    public final /* synthetic */ Function1<GetThreadMessagesV2Response, l5b.a> a;

    public j1(q1.a r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r3) {
        return (l5b.a) this.a.invoke(GetThreadMessagesV2Response.ADAPTER.decode(r3));
    }
}
