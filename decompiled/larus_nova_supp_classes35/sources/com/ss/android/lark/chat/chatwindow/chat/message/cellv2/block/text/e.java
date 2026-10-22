package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text;

import android.os.Trace;
import android.text.Layout;
import b3b.f;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n;
import com.ss.android.lark.chatbase.view.TextChatView2;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends BaseTextContentRender {
    public final TextChatView2 i;

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender
    public final boolean h() {
        return true;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender
    public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b f() {
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r0 = b();
        m2b.a r1 = this.a;
        int r2 = f3b.b.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r0.G = new f3b.a(r1);
        r0.k = true;
        return r0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender
    public final TextChatView2 i() {
        return this.i;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender
    public final Layout j(m2b.a r9) {
        Intrinsics.checkNotNullParameter(r9, "chatContext");
        Object r10 = this.b.b().g;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO<*>");
        BaseTextContentVO r11 = (BaseTextContentVO) r10;
        Layout r0 = r11.z;
        if (r0 != null) goto L16;
        long r3 = System.currentTimeMillis();
        int r1 = TextLayoutRender.j;
        if (TextLayoutRender.c.a() == false) goto L10;
        RichText r2 = r11.g();
        n r6 = e();
        Intrinsics.checkNotNullParameter(r6, "config");
        if (r2 != null) goto L9;
        r0 = null;
    L12:
        if (r11.A == false) goto L14;
        Log.i("AsyncParseLog", "needReParseLayout for message " + this.b.getId());
        a();
    L14:
        Log.i("TextMessageCell2", "bind origin and translate text layout is null, rebuild layout. Time cost:" + (System.currentTimeMillis() - r3));
    L18:
        return r0;
    L9:
        Trace.beginSection("generate_text_content");
        r0 = TextLayoutRenderExtKt.f(this.h, r2, r6);
        Trace.endSection();
        goto L12
    L10:
        Log.i("TextMessageCell2", "use markdown parser to render richText");
        r0 = d(this.b, f());
        goto L12
    L16:
        if (r11.A == false) goto L18;
        Log.i("AsyncParseLog", "needReParseLayout for message " + this.b.getId());
        a();
        goto L18
    }

    public e(m2b.a r9, y6b.a r10, TextChatView2 r11, BaseTextContentRender.c r12, TextClickListenerProviderV2 r13, f r14) {
        Intrinsics.checkNotNullParameter(r9, "chatContext");
        Intrinsics.checkNotNullParameter(r10, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r11, "targetView");
        Intrinsics.checkNotNullParameter(r12, "spanClickListener");
        Intrinsics.checkNotNullParameter(r14, "cellCallback");
        super(r9, r10, r12, r13, r14, null);
        this.i = r11;
    }
}
