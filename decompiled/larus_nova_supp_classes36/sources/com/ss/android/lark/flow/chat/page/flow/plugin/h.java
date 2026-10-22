package com.ss.android.lark.flow.chat.page.flow.plugin;

import android.graphics.Rect;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chatbase.BasePageStore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.a implements mya.e {
    public static final a i = null;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c g;
    public IMessageListComponent h;

    public static final class a implements r4b.a {
        public a() {
        }
    }

    public static final class b {
    }

    public static final class c implements IMessageListComponent.a {
        public final /* synthetic */ h a;

        public final /* synthetic */ void A9() {
        }

        public final void B9(ChatChatter r2) {
            Intrinsics.checkNotNullParameter(r2, "chatChatter");
        }

        public final void e(BasePageStore r2) {
            Intrinsics.checkNotNullParameter(r2, "store");
        }

        public final void w9(ThreadTopic r2) {
            Intrinsics.checkNotNullParameter(r2, "threadTopic");
        }

        public final /* synthetic */ void x9() {
        }

        public final void z9(Chat r2) {
            Intrinsics.checkNotNullParameter(r2, "chat");
        }

        public final void y9() {
            IMessageListComponent r0 = this.a.h;
            if (r0 == null) goto L8;
            mya.h r1 = r0.j5();
            if (r1 == null) goto L9;
            r1.a(mya.e.class, this.a);
            return;
        L9:
            return;
        }

        public c(h r1) {
            this.a = r1;
        }
    }

    static {
        i = new a();
    }

    public h() {
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r2, r3);
        this.g = r2;
        IMessageListComponent r4 = r2.a(IMessageListComponent.class);
        this.h = r4;
        if (r4 == null) goto L6;
        r4.m(new c(this));
        return;
    }

    public final r4b.a H2(m<Object> r2, y6b.a<?> r3, Rect r4) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "messageVo");
        Intrinsics.checkNotNullParameter(r4, "selectedTextRectOnWindow");
        IMessageListComponent r0 = this.h;
        if (r0 == null) goto L7;
        r4b.a r5 = r0.H2(r2, r3, r4);
        if (r5 == null) goto L7;
        return r5;
    L7:
        return i;
    }
}
