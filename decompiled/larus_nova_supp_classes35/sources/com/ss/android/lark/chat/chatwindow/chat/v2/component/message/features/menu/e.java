package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.c<y6b.c<?>> {
    public final /* synthetic */ MessageListMenuFeature a;

    public e(MessageListMenuFeature r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.c
    public final y6b.c getItem(int r4) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r1 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
        if (r1 == null) goto L11;
        com.ss.android.lark.chat.chatwindow.chat.a r2 = r1.getAdapter();
        if (r2 != null) goto L10;
        return null;
    L10:
        return (y6b.c) r2.getItem(r4);
    L11:
        return null;
    }
}
