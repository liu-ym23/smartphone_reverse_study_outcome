package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text;

import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.TextClickListenerProviderV2$getDoubleClickListener$1;
import com.ss.android.lark.chatwindow.view.widget.TouchInterceptionLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements TouchInterceptionLayout.c {
    public final /* synthetic */ BaseTextContentRender a;

    @Override // com.ss.android.lark.chatwindow.view.widget.TouchInterceptionLayout.c
    public final void a() {
        BaseTextContentRender r0 = this.a;
        BaseTextContentRender.b r1 = r0.d;
        if (r1 == null) goto L8;
        TextClickListenerProviderV2$getDoubleClickListener$1 r2 = r1.a(r0.b, r0.h(), this.a.i());
        if (r2 == null) goto L9;
        r2.a();
        return;
    L9:
        return;
    }

    public a(BaseTextContentRender r1) {
        this.a = r1;
    }
}
