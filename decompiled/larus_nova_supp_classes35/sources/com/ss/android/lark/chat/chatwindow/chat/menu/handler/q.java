package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.IMRichTextCopyUtils;
import com.ss.android.lark.chat.utils.k1;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements h<PostContentVO> {
    public final Context a;

    public q(Context r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.h
    public final <M extends y6b.a<PostContentVO>> void a(M r11) {
        PostContentVO r0 = (PostContentVO) r11.b();
        boolean r1 = com.ss.android.lark.chat.utils.u.a.a.c;
        k1.a r2 = k1.a(this.a, r11);
        CharSequence r3 = r2.a;
        RichText r6 = r2.b;
        boolean r9 = r2.c;
        HashMap r4 = new HashMap();
        Map<String, Object> r5 = ChatParamUtils.e();
        if (r5 == null) goto L5;
        r4.putAll(r5);
    L5:
        r4.putAll(IMRichTextCopyUtils.d(r11));
        IMRichTextCopyUtils.l(r1, r6, r4);
        String r7 = r0.w;
        String r8 = r0.x;
        if (TextUtils.isEmpty(r7) == true) goto L8;
    L10:
        RichText.RichTextElements r10 = r6.getElements();
        if (r10 != null) goto L13;
    L23:
        b7b.b.b(this.a, IMRichTextCopyUtils.j(r3, r6), r6, r11.getId(), new Token("LARK-PSDA-messenger-android-copy-postmessage"), r9);
        return;
    L13:
        if (CollectionUtils.isEmpty(r10.getDictionary()) == true) goto L23;
        Iterator r12 = r10.getDictionary().values().iterator();
    L16:
        if (r12.hasNext() == false) goto L23;
        RichTextElement.MediaProperty r13 = ((RichTextElement) r12.next()).getProperty();
        if ((r13 instanceof RichTextElement.ImageProperty) == true) goto L19;
        if ((r13 instanceof RichTextElement.MediaProperty) == false) goto L16;
        RichTextElement.MediaProperty r14 = r13;
        r14.setResourcePreviewToken(r7);
        r14.setResourceMsgLinkToken(r8);
        goto L16
    L19:
        RichTextElement.ImageProperty r15 = (RichTextElement.ImageProperty) r13;
        r15.setResourcePreviewToken(r7);
        r15.setResourceMsgLinkToken(r8);
        goto L16
    L8:
        if (TextUtils.isEmpty(r8) == false) goto L10;
        goto L10
    }
}
