package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text;

import com.ss.android.lark.chatbase.view.TextChatView2;
import com.ss.android.lark.chatwindow.view.widget.TouchInterceptionLayout;
import com.ss.android.lark.widget.light.LKUILightTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TextClickListenerProviderV2$getDoubleClickListener$1 implements TouchInterceptionLayout.c {
    public final /* synthetic */ TextClickListenerProviderV2 a;
    public final /* synthetic */ TextChatView2 b;
    public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> c;
    public final /* synthetic */ boolean d;

    @Override // com.ss.android.lark.chatwindow.view.widget.TouchInterceptionLayout.c
    public final void a() {
        TextClickListenerProviderV2 r0 = this.a;
        LKUILightTextView r1 = this.b.getLightTextView();
        final y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r2 = this.c;
        boolean r3 = this.d;
        final TextClickListenerProviderV2 r5 = this.a;
        r0.d(r1, r2, r3, new TextClickListenerProviderV2$getDoubleClickListener$1$onDoubleClicked$1(r5, r2));
    }

    public TextClickListenerProviderV2$getDoubleClickListener$1(TextClickListenerProviderV2 r1, TextChatView2 r2, y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
