package com.ss.android.lark.replyinthread.pages;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e extends s2b.d implements com.ss.android.lark.chat.message.menu.context.c, v6b.a {
    public final int v;
    public final a w;
    public ThreadTopic x;

    public interface a {
        void a();

        Message b(String r1);
    }

    public final boolean I() {
        return false;
    }

    public final int U() {
        return 0;
    }

    public final boolean Y() {
        return true;
    }

    public final boolean b0() {
        return false;
    }

    public final void c() {
    }

    public final boolean e0() {
        if (this.v == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String g0() {
        a r0 = this.w;
        if (r0 == null) goto L7;
        r0.a();
        return "";
    L7:
        return "";
    }

    public final ThreadTopic N1() {
        return this.x;
    }

    public final Chat getChat() {
        return ((s2b.d) this).d;
    }

    public final Message b(String r2) {
        a r0 = this.w;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.b(r2);
    }

    public e(FragmentActivity r1, v r2, FlowReplyInThreadFragment r3, int r4, com.ss.android.lark.flow.replyinthread.pages.c r5) {
        super(r1, r2, r3);
        this.w = null;
        this.v = r4;
        this.w = r5;
    }
}
