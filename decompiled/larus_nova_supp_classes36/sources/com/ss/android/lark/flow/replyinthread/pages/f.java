package com.ss.android.lark.flow.replyinthread.pages;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel;
import com.ss.android.lark.image.api.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements y6b.e<y6b.c<?>> {
    public final /* synthetic */ FlowReplyInThreadFragment a;

    public f(FlowReplyInThreadFragment r1) {
        this.a = r1;
    }

    public final List<y6b.c<?>> a(List<y6b.c<?>> r9) {
        List<y6b.c<?>> r0 = r9;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        ArrayList r3 = new ArrayList();
        Iterator<y6b.c<?>> r4 = r9.iterator();
    L14:
        if (r4.hasNext() == false) goto L20;
        y6b.c<?> r5 = r4.next();
        r3.add(r5);
        if (r1 == true) goto L14;
        if (r5.Y() == false) goto L14;
        int r6 = r9.size() - 1;
        y6b.c.a r7 = new y6b.c.a();
        r7.e("fake_message_reply_in_thread_count");
        r7.a("fake_message_reply_in_thread_count_cid");
        r7.f(Message.Type.UNKNOWN);
        r7.b("");
        r7.d("");
        r7.c(new com.ss.android.lark.chat.base.view.vo.message.g());
        r7.x0 = r6;
        y6b.c r8 = r7.g();
        r8.Y2 = true;
        r8.W2 = Target.SIZE_ORIGINAL;
        r3.add(r8);
        r1 = true;
        goto L14
    L20:
        FlowBaseReplyInThreadViewModel r10 = this.a.r;
        FlowBaseReplyInThreadViewModel r11 = null;
        if (r10 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r10 = null;
    L24:
        if (r10.canReply() == true) goto L30;
        y6b.c.a r12 = new y6b.c.a();
        r12.e("fake_message_reply_in_thread_auth_zone");
        r12.a("fake_message_reply_in_thread_not_in_chat_cid");
        r12.f(Message.Type.UNKNOWN);
        r12.b("");
        r12.d("");
        r12.c(new com.ss.android.lark.chat.base.view.vo.message.g());
        y6b.c r13 = r12.g();
        r13.Z2 = true;
        FlowBaseReplyInThreadViewModel r14 = this.a.r;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L29:
        r13.V2 = r11.isThreadClosed();
        r13.W2 = Target.SIZE_ORIGINAL;
        r3.add(r13);
        goto L30
    L28:
        r11 = r14;
    L30:
        return r3;
    L11:
        return new ArrayList();
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }
}
