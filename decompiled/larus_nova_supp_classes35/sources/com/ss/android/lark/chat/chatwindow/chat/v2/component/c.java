package com.ss.android.lark.chat.chatwindow.chat.v2.component;

import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.chat.chatwindow.biz.plugin.NewIntentScrollMessagePlugin$newIntentHandler$2;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c extends com.ss.android.lark.biz.im.api.extension.chat_window.c, ChatBaseComponent.a, m2b.b {
    public static final /* synthetic */ int E1 = 0;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }

        public a() {
        }
    }

    public interface b {
        boolean b(int r1, int r2, Intent r3);
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.c$c, reason: collision with other inner class name */
    public interface InterfaceC0058c {
        boolean l1();
    }

    public interface d {
        void a(fxa.b r1);
    }

    static {
        int r0 = a.a;
    }

    void a0(Intent r1);

    /* synthetic */ Context getContext();

    ChatWindowOpenViewModel getViewModel(Class r1);

    void i(FlowMessageSelectPlugin.b r1);

    void k0(NewIntentScrollMessagePlugin$newIntentHandler$2.a r1);

    ChatWindowKeyboard n();

    void p(FlowMessageSelectPlugin.h r1);

    void s(FlowMessageSelectPlugin.b r1);

    void t(NewIntentScrollMessagePlugin$newIntentHandler$2.a r1);
}
