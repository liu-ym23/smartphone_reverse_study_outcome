package com.ss.android.lark.flow.replyinthread.pages.plugin;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.keyboard.biz.voice.inject.VoiceInnerEndPlugin;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {
    public zhb.a g;
    public IMessageListComponent h;
    public ThreadTopic i;
    public VoiceInnerEndPlugin j;
    public final b k;

    public static final class a {
    }

    public static final class b implements ChatWindowKeyboard.a {
        public final /* synthetic */ q a;

        public final void a() {
        }

        public final void d() {
        }

        public final void f() {
        }

        public b(q r1) {
            this.a = r1;
        }

        public final void g(com.ss.android.lark.keyboard.b r2) {
            Intrinsics.checkNotNullParameter(r2, "keyboard");
            this.a.F(r2);
        }
    }

    public static final class c implements IMessageListComponent.a {
        public final /* synthetic */ q a;

        public final /* synthetic */ void A9() {
        }

        public final void B9(ChatChatter r2) {
            Intrinsics.checkNotNullParameter(r2, "chatChatter");
        }

        public final void e(BasePageStore r2) {
            Intrinsics.checkNotNullParameter(r2, "store");
        }

        public final /* synthetic */ void x9() {
        }

        public final /* synthetic */ void y9() {
        }

        public final void z9(Chat r2) {
            Intrinsics.checkNotNullParameter(r2, "chat");
        }

        public c(q r1) {
            this.a = r1;
        }

        public final void w9(ThreadTopic r3) {
            Intrinsics.checkNotNullParameter(r3, "threadTopic");
            zhb.a r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.w9(r3);
        L5:
            q r1 = this.a;
            r1.i = r3;
            VoiceInnerEndPlugin r2 = r1.j;
            if ((r2 instanceof VoiceInnerEndPlugin) == true) goto L9;
            r2 = null;
        L9:
            if (r2 == null) goto L12;
            r2.d = r3;
            return;
        }
    }

    static {
    }

    public q() {
        this.k = new b(this);
    }

    public final void F(com.ss.android.lark.keyboard.b r4) {
        com.ss.android.lark.keyboard.keyboard2.b r5 = r4.L();
        VoiceInnerEndPlugin r1 = null;
        if ((r5 instanceof FlowChatKeyboardEditor) == false) goto L5;
        FlowChatKeyboardEditor r6 = (FlowChatKeyboardEditor) r5;
    L7:
        if (r6 != null) goto L10;
        Log.e("ThreadTopicPlugin", "onKeyboardReady: keyboardEditor is null");
        return;
    L10:
        VoiceInnerEndPlugin.b r2 = VoiceInnerEndPlugin.t;
        wnb.b r7 = r6.H();
        if ((r7 instanceof VoiceInnerEndPlugin) == false) goto L13;
        r1 = (VoiceInnerEndPlugin) r7;
    L13:
        if (r1 != null) goto L16;
        Log.e("ThreadTopicPlugin", "onKeyboardReady: VoiceInnerEndPlugin is null");
        return;
    L16:
        this.j = r1;
        r1.d = this.i;
        return;
    L5:
        r6 = null;
        goto L7
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3, i7b.a r4) {
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        Intrinsics.checkNotNullParameter(r4, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r3, r4);
        zhb.a r5 = r3.getFragment();
        com.ss.android.lark.keyboard.b r1 = null;
        if ((r5 instanceof zhb.a) == false) goto L5;
        zhb.a r6 = r5;
    L6:
        this.g = r6;
        IMessageListComponent r7 = r3.a(IMessageListComponent.class);
        this.h = r7;
        if (r7 == null) goto L9;
        r7.m(new c(this));
    L9:
        ChatWindowKeyboard r8 = r3.n();
        if (r8 == null) goto L12;
        r1 = r8.n();
    L12:
        if (r1 != null) goto L16;
        if (r8 == null) goto L18;
        r8.m7(this.k);
        return;
    L18:
        return;
    L16:
        F(r1);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
