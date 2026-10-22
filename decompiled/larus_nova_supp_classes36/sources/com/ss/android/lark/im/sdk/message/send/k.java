package com.ss.android.lark.im.sdk.message.send;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.im.sdk.service.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements jkb.b {
    public MessageParams<?, ?> a;
    public final o b;
    public MessageInfo c;
    public final Long d;
    public Long e;

    public k(MessageParams<?, ?> r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "messageParams");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
        this.d = r2.w;
    }
}
