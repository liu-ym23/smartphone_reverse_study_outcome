package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply;

import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ThreadReplyBlock;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends CommonThreadReplyContentRender {
    public final m2b.a b;
    public c c;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Message.Type.RED_PACKET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public d(m2b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        this.b = r2;
        this.c = null;
    }

    public static void a(ThreadReplyBlock.a r2) {
        r2.e.setImageResource(2131232612);
        r2.f.setRadius(6.0f);
        r2.f.setBorderWidth(1.0f);
        r2.f.setBorderColor(UIHelper.getColor(2131103351));
    }
}
