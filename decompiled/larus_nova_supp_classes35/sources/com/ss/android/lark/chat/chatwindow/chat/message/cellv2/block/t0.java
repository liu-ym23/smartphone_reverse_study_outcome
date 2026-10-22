package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t0 implements View.OnClickListener {
    public final /* synthetic */ ThreadForwardContentVOV2 a;
    public final /* synthetic */ ThreadForwardContentBlock b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public t0(ThreadForwardContentVOV2 r1, ThreadForwardContentBlock r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.g() == false) goto L8;
        b3b.m r5 = (b3b.m) this.b.u.getValue();
        if (r5 == null) goto L16;
        r5.g(this.c, this.d);
        return;
    L16:
        return;
    L8:
        if (this.a.f() == true) goto L10;
    L12:
        p4b.b r6 = (p4b.b) this.b.v.getValue();
        if (r6 == null) goto L19;
        r6.i(this.d);
        return;
    L19:
        return;
    L10:
        if (((MergeForwardContent) this.a.a).getThread() == null) goto L12;
        w4b.e0 r7 = ChatCoreModule.a().getThreadDependency();
        Context r0 = this.b.getContext();
        l1.a r1 = new l1.a();
        r1.e = this.c;
        r1.m = true;
        r7.b(r0, new l1(r1));
    }
}
