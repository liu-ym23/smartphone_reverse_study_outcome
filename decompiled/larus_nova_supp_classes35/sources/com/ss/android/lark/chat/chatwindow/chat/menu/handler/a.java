package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.IMRichTextCopyUtils;
import com.ss.android.lark.chat.utils.k1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements h<AudioContentVO> {
    public final Context a;

    public a(Context r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.menu.handler.h
    public final <M extends y6b.a<AudioContentVO>> void a(M r9) {
        if (r9 != null) goto L5;
        Log.e("TextMessageCopyHandler", "on copy return, message is null");
        return;
    L5:
        Context r0 = this.a;
        int r1 = k1.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r9, "messageVO");
        com.ss.android.lark.chat.base.view.vo.message.e r2 = ((AudioContentVO) r9.b()).h;
        if (r2 != null) goto L9;
        r2 = new com.ss.android.lark.chat.base.view.vo.message.e(new TextContent());
    L9:
        k1.a r3 = k1.b(r0, r9, r2);
        CharSequence r4 = r3.a;
        RichText r5 = r3.b;
        boolean r7 = r3.c;
        HashMap r6 = new HashMap();
        Map<String, Object> r8 = ChatParamUtils.e();
        if (r8 == null) goto L12;
        r6.putAll(r8);
    L12:
        r6.putAll(IMRichTextCopyUtils.d(r9));
        IMRichTextCopyUtils.l(com.ss.android.lark.chat.utils.u.a.a.c, r5, r6);
        b7b.b.b(this.a, IMRichTextCopyUtils.j(r4, r5), r5, r9.getId(), new Token("LARK-PSDA-messenger-android-copy-textmessage"), r7);
    }
}
