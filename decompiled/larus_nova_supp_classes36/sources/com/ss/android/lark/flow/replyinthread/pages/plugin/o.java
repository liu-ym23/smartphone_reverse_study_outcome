package com.ss.android.lark.flow.replyinthread.pages.plugin;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.flow.chat.menu.provider.FlowCloseTopicActionHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ Message a;
    public final /* synthetic */ ThreadTopic b;
    public final /* synthetic */ ReplyInThreadTitleBarPlugin c;
    public final /* synthetic */ Function0<Unit> d;
    public final /* synthetic */ boolean e;

    public o(Message r1, ThreadTopic r2, ReplyInThreadTitleBarPlugin r3, Function0<Unit> r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Message r6 = this.a;
        boolean r0 = false;
        String r2 = null;
        if (r6 == null) goto L14;
        String r7 = r6.getId();
        if (r7 == null) goto L14;
        if (r7.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r7 = null;
    L13:
        if (r7 == null) goto L14;
    L24:
        this.d.invoke();
        int r1 = FlowCloseTopicActionHelper.a;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r4 = this.c.g;
        if (r4 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r4 = null;
    L27:
        Context r8 = r4.getContext();
        i7b.a r9 = this.c.h;
        if (r9 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("chatInitData");
        r9 = null;
    L30:
        Chat r10 = r9.f;
        if (r10 == null) goto L33;
        r2 = r10.getId();
    L33:
        if (r2 != null) goto L35;
        r2 = "";
    L35:
        FlowCloseTopicActionHelper.b(r8, r2, r7, this.e);
        return;
    L9:
        r3 = false;
    L14:
        r7 = this.b.getRootMsgId();
        if (r7 != null) goto L17;
    L21:
        r7 = null;
    L22:
        if (r7 != null) goto L24;
        return;
    L17:
        if (r7.length() <= 0) goto L19;
        r0 = true;
    L19:
        if (r0 == false) goto L21;
        goto L21
    }
}
