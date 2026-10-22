package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text;

import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.message.params.o;
import com.ss.android.lark.biz.im.api.message.params.y;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.k0;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.message.menu.MessageLongPressTextSelectHelper;
import com.ss.android.lark.chatbase.view.TextChatView2;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TextClickListenerProviderV2 implements BaseTextContentRender.b {
    public final m2b.a a;
    public final View b;
    public final a c;

    public interface a {
        boolean a(y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r1);

        void b(y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r1);

        void c(y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r1);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender.b
    public final com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.a b(y6b.a r2) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
        return new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.a(this, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextClickListenerProviderV2(m2b.a r2, TextChatView2 r3, k0 r4) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "popupAnchorView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender.b
    public final TextClickListenerProviderV2$getDoubleClickListener$1 a(y6b.a r2, boolean r3, TextChatView2 r4) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r4, "textChatView2");
        return new TextClickListenerProviderV2$getDoubleClickListener$1(this, r4, r2, r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.BaseTextContentRender.b
    public final b c(y6b.a r2, boolean r3, TextChatView2 r4) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r4, "targetView");
        return new b(this, r4, r2, r3);
    }

    public final void d(LKUILightTextView r8, final y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r9, boolean r10, final Function1<? super y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r8, "selectableView");
        Intrinsics.checkNotNullParameter(r9, "messageVO");
        m2b.a r2 = this.a;
        Function3<CharSequence, Boolean, PartialReplyInfo.PartialContentRelativePosition, Unit> r4 = new TextClickListenerProviderV2$showTextSelect$1(r9);
        Function0<Unit> r5 = new TextClickListenerProviderV2$showTextSelect$2(r11, r9, this);
        y r12 = this.a.d0(y.class);
        y6b.c r0 = null;
        if (r12 == null) goto L18;
        o r13 = r12.j;
        if (r13 == null) goto L18;
        if ((r9 instanceof y6b.c) == false) goto L9;
        r0 = (y6b.c) r9;
    L9:
        if (r0 == null) goto L13;
        boolean r14 = r0.i;
        boolean r1 = true;
        if (r14 != true) goto L13;
    L14:
        if (r1 == false) goto L16;
        int r15 = r13.a;
    L17:
        Integer r6 = Integer.valueOf(UIUtils.getColor(r8.getContext(), r15));
    L19:
        MessageLongPressTextSelectHelper.f(r8, r2, r10, r4, r5, r6);
        return;
    L16:
        r15 = r13.b;
    L13:
        r1 = false;
    L18:
        r6 = null;
        goto L19
    }
}
