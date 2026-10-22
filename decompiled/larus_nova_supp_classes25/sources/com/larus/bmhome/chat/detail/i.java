package com.larus.bmhome.chat.detail;

import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.trace.CopyContentTypeString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface i {
    String c();

    void d(by7.e r1, BotModel r2, String r3, long r4, CustomMarkdownTextView r6, String r7, int r8, boolean r9, @CopyContentTypeString String r10, AbstractCommonDetailFragment.c r11);

    void e(String r1);

    void j(Message r1);

    void setConversationId(String r1);

    void v();
}
