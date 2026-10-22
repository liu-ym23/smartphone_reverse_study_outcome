package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {
    public static final com.ss.android.lark.storage.a g = null;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.page.flow.plugin.tip.a$a, reason: collision with other inner class name */
    public static final class C0038a {
    }

    public static final class b implements ChatWindowKeyboard.a {
        public final /* synthetic */ a a;
        public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c b;

        public final void a() {
        }

        public final void d() {
        }

        public final void f() {
        }

        public final void g(com.ss.android.lark.keyboard.b r4) {
            Intrinsics.checkNotNullParameter(r4, "keyboard");
            a r0 = this.a;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.c r1 = this.b;
            r0.getClass();
            r4.e().of(r0).c(znb.c.class, new FlowMentionDoubaoTipPlugin$observeKeyboardEvent$1(r0, r1));
        }

        public b(a r1, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        g = new com.ss.android.lark.storage.a("IM");
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r2, r3);
        ChatCoreModule.a().getDeviceId();
        ChatWindowKeyboard r4 = r2.n();
        if (r4 == null) goto L5;
        r4.m7(new b(this, r2));
    L5:
        if (r4 == null) goto L10;
        com.ss.android.lark.keyboard.b r5 = r4.n();
        if (r5 == null) goto L11;
        r5.e().of(this).c(znb.c.class, new FlowMentionDoubaoTipPlugin$observeKeyboardEvent$1(this, r2));
        return;
    L11:
        return;
    }
}
