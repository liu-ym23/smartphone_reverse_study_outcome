package com.ss.android.lark.flow.chat.message.block.threadforward;

import android.content.Context;
import android.view.View;
import b3b.m;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import w4b.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ ThreadForwardContentVOV2 a;
    public final /* synthetic */ FlowThreadForwardHeaderBlock b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public c(ThreadForwardContentVOV2 r1, FlowThreadForwardHeaderBlock r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.g() == false) goto L8;
        m r5 = (m) this.b.i.getValue();
        if (r5 == null) goto L16;
        r5.g(this.c, this.d);
        return;
    L16:
        return;
    L8:
        if (this.a.f() == true) goto L10;
    L12:
        p4b.b r6 = (p4b.b) this.b.j.getValue();
        if (r6 == null) goto L19;
        r6.i(this.d);
        return;
    L19:
        return;
    L10:
        if (((v5b.a) this.a).a.getThread() == null) goto L12;
        e0 r7 = ChatCoreModule.a().getThreadDependency();
        Context r0 = this.b.getContext();
        l1.a r1 = new l1.a();
        r1.e = this.c;
        r1.m = true;
        r7.b(r0, new l1(r1));
    }
}
