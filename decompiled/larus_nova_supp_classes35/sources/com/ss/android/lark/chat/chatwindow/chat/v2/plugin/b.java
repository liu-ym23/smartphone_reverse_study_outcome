package com.ss.android.lark.chat.chatwindow.chat.v2.plugin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.a {
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c g;

    public static final class a<T> implements Observer {
        public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c a;

        public a(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Chat r4 = (Chat) r3;
            IMessageListComponent r0 = (IMessageListComponent) this.a.a(IMessageListComponent.class);
            if (r0 == null) goto L6;
            r0.g6(r4.getFirstMessagePosition());
            return;
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final boolean A() {
        return true;
    }

    public b() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3, i7b.a r4) {
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        Intrinsics.checkNotNullParameter(r4, "initData");
        super.C(r3, r4);
        this.g = r3;
        ChatWindowOpenViewModel r5 = r3.c();
        if (r5 == null) goto L8;
        MutableLiveData r6 = r5.getChat();
        if (r6 == null) goto L9;
        Object r0 = r3.getHost();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        r6.observe((Fragment) r0, new a(r3));
        return;
    L9:
        return;
    }
}
