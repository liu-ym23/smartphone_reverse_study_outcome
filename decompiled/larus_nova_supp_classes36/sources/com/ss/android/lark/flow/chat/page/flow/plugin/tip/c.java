package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.biz.im.api.x0;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements com.ss.android.lark.chatwindow.view.tip.a.c {
    public final /* synthetic */ IMessageListComponent a;
    public final /* synthetic */ FlowMessageTipsPlugin b;

    public static final class a implements IMessageListComponent.k {
        public final /* synthetic */ FlowMessageTipsPlugin a;

        public final void a() {
            wgb.b<y6b.c<?>> r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.e();
            return;
        }

        public final void b() {
            wgb.b<y6b.c<?>> r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.l();
            return;
        }

        public a(FlowMessageTipsPlugin r1) {
            this.a = r1;
        }
    }

    public static final class b implements IMessageListComponent.k {
        public final /* synthetic */ FlowMessageTipsPlugin a;

        public final void a() {
            wgb.b<y6b.c<?>> r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.e();
            return;
        }

        public final void b() {
            wgb.b<y6b.c<?>> r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.l();
            return;
        }

        public b(FlowMessageTipsPlugin r1) {
            this.a = r1;
        }
    }

    public final void b(Message r10) {
        if (r10 == null) goto L13;
        IMessageListComponent r0 = this.a;
        FlowMessageTipsPlugin r1 = this.b;
        Log.i("FlowMessageTipsPlugin", "click at message " + r10.getId());
        ScrollScene r2 = ScrollScene.MESSAGE_TIPS_AT;
        IMessageListComponent r3 = r1.n;
        if (r3 == null) goto L10;
        x0 r4 = r3.rY();
        if (r4 == null) goto L10;
        a1 r5 = r4.k;
        if (r5 == null) goto L10;
        int r11 = r5.b(r10);
    L11:
        IMessageListComponent.-CC.scrollToPosition$default(r0, r2, r11, true, false, new a(r1), null, 32, null);
        return;
    L10:
        r11 = r10.getPosition();
        goto L11
    }

    public c(IMessageListComponent r1, FlowMessageTipsPlugin r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(int r12, boolean r13) {
        Log.i("FlowMessageTipsPlugin", "click to newMessagePosition: " + r12 + ", goto bottom: " + r13);
        IMessageListComponent.-CC.scrollToPosition$default(this.a, ScrollScene.MESSAGE_TIPS_NEW_MESSAGE, r12, false, r13, new b(this.b), null, 32, null);
    }
}
