package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowMessageList;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponentInner;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {

    public static final class a implements ChatWindowMessageList.a {
        public final /* synthetic */ IMessageListComponent a;
        public final /* synthetic */ g b;

        public final void b() {
        }

        public final void a() {
            s2b.d r0 = this.a.W2();
            b r1 = new b(this.a);
            if (r0 == null) goto L24;
            IMessageListComponentInner r5 = this.a;
            v r7 = null;
            if ((r5 instanceof IMessageListComponentInner) == false) goto L7;
            IMessageListComponentInner r6 = r5;
        L8:
            if (r6 == null) goto L10;
            a4b.b r8 = r6.Hq();
        L11:
            IMessageListComponentInner r9 = this.a;
            if ((r9 instanceof IMessageListComponentInner) == false) goto L14;
            IMessageListComponentInner r10 = r9;
        L15:
            if (r10 == null) goto L17;
            a4b.b r11 = r10.Hq();
        L18:
            com.ss.android.lark.coremd.clickcompat.c.a r4 = new com.ss.android.lark.coremd.clickcompat.c.a(r8, r11);
            v r12 = ((BaseChatPlugin) this.b).d;
            if (r12 == null) goto L21;
            r7 = r12;
        L22:
            r0.h0(MapsKt.mapOf(TuplesKt.to(com.ss.android.lark.coremd.clickcompat.c.class, new com.ss.android.lark.flow.chat.coremd.clickcompat.a(r0, r1, r4, r7))));
            return;
        L21:
            Intrinsics.throwUninitializedPropertyAccessException("chatContainer");
            goto L22
        L17:
            r11 = null;
            goto L18
        L14:
            r10 = null;
            goto L15
        L10:
            r8 = null;
            goto L11
        L7:
            r6 = null;
            goto L8
        }

        public a(IMessageListComponent r1, g r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements com.ss.android.lark.coremd.clickcompat.c.b {
        public final /* synthetic */ IMessageListComponent a;

        public b(IMessageListComponent r1) {
            this.a = r1;
        }

        public final y6b.a<?> getMessageById(String r4) {
            Intrinsics.checkNotNullParameter(r4, "msgId");
            Iterator r0 = this.a.Oq().iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            if (Intrinsics.areEqual(((y6b.c) r1).c, r4) == false) goto L4;
        L10:
            return (y6b.a) r1;
        L8:
            r1 = null;
            goto L10
        }
    }

    public g() {
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r2, r3);
        IMessageListComponent r4 = r2.a(IMessageListComponent.class);
        if (r4 == null) goto L6;
        r4.hg(new a(r4, this));
        return;
    }
}
