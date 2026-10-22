package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.MessageFullScreenRichTextSetup;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.ContentLongClickListener;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.ActionContextCreator;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ MessageFullScreenFragment a;

    public l(MessageFullScreenFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        Chat r4 = (Chat) r10;
        MessageFullScreenFragment r11 = this.a;
        MessageFullScreenRichTextSetup r7 = r11.p;
        if (r7 == null) goto L23;
        MessageFullScreenViewModel.c r0 = (MessageFullScreenViewModel.c) r11.T90().getLaunch().getValue();
        if (r0 == null) goto L26;
        MessageFullScreenViewModel.c r1 = (MessageFullScreenViewModel.c) r11.T90().getLaunch().getValue();
        if (r1 == null) goto L24;
        Message r2 = r1.b;
        if (r2 == null) goto L27;
        FragmentActivity r3 = r11.requireActivity();
        Intrinsics.checkNotNull(r4);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r5 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c(r3, r11, r4, r2);
        Intrinsics.checkNotNullParameter(r5, "clickContext");
        r7.c = r5;
        Context r6 = r7.getContext();
        v r8 = r11.f;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("chatContainer");
        r8 = null;
    L16:
        ActionContextCreator r9 = new ActionContextCreator(r6, r11, r8, r4, r0.a, r11.T90().getItem());
        r9.g = r11.r;
        r9.h = r11.s;
        Intrinsics.checkNotNullParameter(r9, "actionContextCreator");
        r7.e = r9;
        ContentLongClickListener r12 = r7.h;
        if (r12 == null) goto L19;
        r12.e(r9);
    L19:
        ContentLongClickListener r13 = r7.i;
        if (r13 == null) goto L25;
        r13.e(r9);
        return;
    L25:
        return;
    L27:
        return;
    L24:
        return;
    L26:
        return;
    }
}
