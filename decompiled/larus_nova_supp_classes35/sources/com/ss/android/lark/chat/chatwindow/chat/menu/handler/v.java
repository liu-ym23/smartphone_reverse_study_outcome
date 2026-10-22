package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.IMRichTextCopyUtils;
import com.ss.android.lark.chat.utils.k1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v implements h<BaseTextContentVO<TextContent>> {
    public final Context a;

    public v(Context r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.h
    public final <M extends y6b.a<BaseTextContentVO<TextContent>>> void a(M r9) {
        if (r9 != null) goto L5;
        Log.e("TextMessageCopyHandler", "on copy return, message is null");
        return;
    L5:
        k1.a r0 = k1.a(this.a, r9);
        CharSequence r1 = r0.a;
        RichText r4 = r0.b;
        boolean r7 = r0.c;
        HashMap r2 = new HashMap();
        Map<String, Object> r3 = ChatParamUtils.e();
        if (r3 == null) goto L8;
        r2.putAll(r3);
    L8:
        r2.putAll(IMRichTextCopyUtils.d(r9));
        IMRichTextCopyUtils.l(com.ss.android.lark.chat.utils.u.a.a.c, r4, r2);
        b7b.b.b(this.a, IMRichTextCopyUtils.j(r1, r4), r4, r9.getId(), new Token("LARK-PSDA-messenger-android-copy-textmessage"), r7);
    }
}
