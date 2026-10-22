package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.MGetChatsResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.sdk.SdkSender;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g<T> implements SdkSender.IParser {
    public final /* synthetic */ Function1<MGetChatsResponse, Map<String, Chat>> a;

    public g(v r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r3) {
        return (Map) this.a.invoke(MGetChatsResponse.ADAPTER.decode(r3));
    }
}
