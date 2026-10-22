package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text;

import android.os.Trace;
import android.text.Layout;
import b3b.f;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n;
import com.ss.android.lark.chatbase.view.TextChatView2;
import com.ss.android.lark.chatwindow.view.widget.TouchInterceptionLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends BaseTextContentRender {
    public final TextChatView2 i;

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender
    public final boolean h() {
        return false;
    }

    public final void k() {
        if (this.b.b().A == false) goto L6;
        Log.i("AsyncParseLog", "needReParseLayout for message " + this.b.getId());
        a();
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender
    public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b f() {
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r0 = b();
        r0.c = false;
        if (this.a.Y() == false) goto L11;
        y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r1 = this.b;
        if ((r1 instanceof y6b.c) == true) goto L7;
    L9:
        int r2 = 23;
    L10:
        r0.x = r2;
        goto L11
    L7:
        if (((y6b.c) r1).Y() == false) goto L9;
        r2 = 22;
    L11:
        return r0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender
    public final TextChatView2 i() {
        return this.i;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender
    public final Layout j(m2b.a r7) {
        Intrinsics.checkNotNullParameter(r7, "chatContext");
        Layout r8 = this.b.b().z;
        if (r8 == null) goto L6;
        Log.d("TextMessageCell2", "bind textContent, contentLayout is not null, use content layout directly, msgPos is " + this.b.A() + '.');
        k();
        return r8;
    L6:
        long r1 = System.currentTimeMillis();
        int r9 = TextLayoutRender.j;
        if (TextLayoutRender.c.a() == false) goto L12;
        Log.i("TextMessageCell2", "use markdown parser to render richText");
        RichText r10 = this.b.b().g();
        n r3 = e();
        Intrinsics.checkNotNullParameter(r3, "config");
        if (r10 != null) goto L11;
        Layout r11 = null;
    L13:
        k();
        Log.i("TextMessageCell2", "bind origin text layout is null, rebuild layout. Time cost:" + (System.currentTimeMillis() - r1));
        return r11;
    L11:
        Trace.beginSection("generate_text_content");
        r11 = TextLayoutRenderExtKt.f(this.h, r10, r3);
        Trace.endSection();
        goto L13
    L12:
        r11 = d(this.b, f());
        goto L13
    }

    public d(m2b.a r8, y6b.a r9, TextChatView2 r10, BaseTextContentRender.c r11, TextClickListenerProviderV2 r12, f r13, TouchInterceptionLayout r14) {
        Intrinsics.checkNotNullParameter(r8, "chatContext");
        Intrinsics.checkNotNullParameter(r9, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r10, "targetView");
        Intrinsics.checkNotNullParameter(r11, "spanClickListener");
        Intrinsics.checkNotNullParameter(r13, "cellCallback");
        Intrinsics.checkNotNullParameter(r14, "touchInterceptionLayout");
        super(r8, r9, r11, r12, r13, r14);
        this.i = r10;
    }
}
