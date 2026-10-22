package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu;

import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.a {
    public final /* synthetic */ MessageListMenuFeature a;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.a
    public final ListMode getCurrentMode() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        e4b.a r1 = (e4b.a) r0.b(e4b.a.class);
        if (r1 == null) goto L10;
        ListMode r2 = r1.o();
        if (r2 == null) goto L10;
        return r2;
    L10:
        return ListMode.NORMAL;
    }

    public f(MessageListMenuFeature r1) {
        this.a = r1;
    }
}
