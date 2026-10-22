package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.MessageFullScreenRichTextSetup;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.ActionContextCreator;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ MessageFullScreenFragment a;

    public k(MessageFullScreenFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r26) {
        MessageFullScreenViewModel.c r1 = (MessageFullScreenViewModel.c) r26;
        if (r1.b == null) goto L55;
        Log.i("MessageFullScreenFragment", "full screen launch start");
        MessageFullScreenFragment r2 = this.a;
        MessageFullScreenRichTextSetup r3 = r2.p;
        ArrayList<String> r11 = null;
        if (r3 == null) goto L12;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r4 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c(r2.requireActivity(), r2, r1.c, r1.b);
        Intrinsics.checkNotNullParameter(r4, "clickContext");
        r3.c = r4;
        Context r5 = r3.getContext();
        v r6 = r2.f;
        if (r6 == null) goto L10;
        v r7 = r6;
    L11:
        ActionContextCreator r12 = new ActionContextCreator(r5, r2, r7, r1.c, r1.a, r2.T90().getItem());
        r12.g = r2.r;
        r12.h = r2.s;
        Intrinsics.checkNotNullParameter(r12, "actionContextCreator");
        r3.e = r12;
        Intrinsics.checkNotNull(r1);
        r3.a(r1);
        goto L12
    L10:
        Intrinsics.throwUninitializedPropertyAccessException("chatContainer");
        r7 = null;
    L12:
        MessageFullScreenFragment r8 = this.a;
        Intrinsics.checkNotNull(r1);
        r8.getClass();
        Message r9 = r1.b;
        if (r9 == null) goto L56;
        Content r10 = r9.getContent();
        if ((r10 instanceof BaseTextContent) == false) goto L18;
        BaseTextContent r13 = (BaseTextContent) r10;
    L19:
        if (r13 == null) goto L21;
        ArrayList<File> r14 = r13.getAttachments();
    L22:
        y6b.a<?> r21 = r8.T90().getItem();
        LinearLayout r15 = r8.n;
        if (r15 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("attachmentList");
        LinearLayout r16 = null;
    L26:
        String r17 = r1.a.getMessageId();
        Chat r18 = r1.c;
        if (r21 == null) goto L29;
        int r19 = r21.A();
    L30:
        int r110 = r19;
        if (r21 != null) goto L33;
    L35:
        boolean r111 = false;
    L37:
        if (r21 != null) goto L39;
    L46:
        boolean r112 = false;
    L47:
        Content r20 = r9.getContent();
        if ((r20 instanceof PostContent) == false) goto L50;
        PostContent r22 = (PostContent) r20;
    L51:
        if (r22 == null) goto L53;
        r11 = r22.getRiskObjectKeys();
    L53:
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.d.b(r16, r14, r17, r18, r110, r111, null, r112, r11, r21, null, r9, 13376);
        return;
    L50:
        r22 = null;
        goto L51
    L39:
        if (r21.isPreMessage() == true) goto L41;
    L43:
        boolean r23 = false;
    L44:
        if (r23 != true) goto L46;
        r112 = true;
        goto L47
    L41:
        if (r21.G() != SendStatus.FAIL) goto L43;
        r23 = true;
        goto L44
    L33:
        if (r21.isPreMessage() != true) goto L35;
        r111 = true;
        goto L37
    L29:
        r19 = r9.getPosition();
        goto L30
    L25:
        r16 = r15;
        goto L26
    L21:
        r14 = null;
        goto L22
    L18:
        r13 = null;
        goto L19
    L56:
        return;
    }
}
