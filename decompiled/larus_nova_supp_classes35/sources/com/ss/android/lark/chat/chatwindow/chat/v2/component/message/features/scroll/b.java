package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll;

import com.ss.android.lark.biz.im.api.FirstMessagePaddingType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.f;
import kotlin.jvm.internal.Intrinsics;
import s2b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements n.d {
    public final /* synthetic */ MessageListScrollFeature a;

    public b(MessageListScrollFeature r1) {
        this.a = r1;
    }

    @Override // s2b.n.d
    public final int a() {
        MessageListScrollFeature r0 = this.a;
        r0.getClass();
        FirstMessagePaddingType r1 = FirstMessagePaddingType.TITLE_AND_TAB;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r2 = r0.l();
        if (r2 == null) goto L6;
        FirstMessagePaddingType r3 = r2.z();
        if (r3 == null) goto L6;
    L7:
        if (r1 != r3) goto L18;
        int r4 = ((Number) r0.c.getValue()).intValue();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r5 = r0.b;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r5 = null;
    L11:
        IMessageListComponent.e r6 = r5.getDependency();
        if (r6 == null) goto L16;
        f r7 = r6.c();
        if (r7 == null) goto L16;
        int r8 = r7.a();
    L17:
        int r9 = r4 + r8;
    L20:
        return r9 + ((Number) this.a.c.getValue()).intValue();
    L16:
        r8 = 0;
        goto L17
    L18:
        r9 = ((Number) r0.c.getValue()).intValue();
    L6:
        r3 = FirstMessagePaddingType.NONE;
        goto L7
    }
}
