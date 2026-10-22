package com.ss.android.lark.chat.chatwindow.chat.model.data.decorator;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.q0;
import com.ss.android.lark.chatbase.i;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements i<MessageInfo> {
    public c() {
    }

    @Override // com.ss.android.lark.chatbase.i
    public final void a(f5b.b r2) {
        MessageInfo r3 = (MessageInfo) r2;
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        q0.a(r3);
    }
}
