package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements PointRecoderRecyclerView.a {
    public final /* synthetic */ MessageListRendererFeature a;

    public g(MessageListRendererFeature r1) {
        this.a = r1;
    }

    public final void a(float r4) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.c;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        s2b.d r2 = r0.a();
        if (r2 == null) goto L8;
        r2.w8((int) r4);
    L8:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r5 = this.a.c;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L12:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a r6 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a) r1.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a.class);
        if (r6 == null) goto L16;
        r6.a();
        return;
    L16:
        return;
    L11:
        r1 = r5;
        goto L12
    }
}
