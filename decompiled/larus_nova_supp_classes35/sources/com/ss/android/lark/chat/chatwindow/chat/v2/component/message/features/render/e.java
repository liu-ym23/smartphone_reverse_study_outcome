package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.b<y6b.c<?>> {
    public final /* synthetic */ MessageListRendererFeature a;

    public e(MessageListRendererFeature r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.b
    public final String a(y6b.c<?> r2) {
        y6b.c<?> r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "item");
        return r3.c;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.b
    public final y6b.c getItem(int r2) {
        if (r2 >= 0) goto L4;
    L6:
        return null;
    L4:
        if (r2 >= this.a.I().getItemCount()) goto L6;
        return (y6b.c) this.a.I().getItem(r2);
    }
}
