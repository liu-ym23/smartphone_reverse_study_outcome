package com.ss.android.lark.chat.chatwindow.chat.model.data.decorator;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.i;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements i<MessageInfo> {
    public final Function0<com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a> a;

    public f(q3b.f r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chatbase.i
    public final void a(f5b.b r2) {
        MessageInfo r3 = (MessageInfo) r2;
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a r0 = (com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a) this.a.invoke();
        if (r0 == null) goto L6;
        r0.b(r3);
        return;
    }
}
