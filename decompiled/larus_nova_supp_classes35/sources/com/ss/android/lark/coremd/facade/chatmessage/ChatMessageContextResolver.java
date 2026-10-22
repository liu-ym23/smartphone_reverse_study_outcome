package com.ss.android.lark.coremd.facade.chatmessage;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.coremd.base.parse.b;
import com.ss.android.lark.coremd.base.parse.c;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import y6b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatMessageContextResolver {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static b a(final Chat r2, final Message r3) {
        return c.a(IMContextExtend.A, new ChatMessageContextResolver$resolveMessage$1(r3, r2));
    }

    public static b b(final Chat r2, final a r3) {
        return c.a(IMContextExtend.A, new ChatMessageContextResolver$resolveMessage$2(r3, r2));
    }
}
