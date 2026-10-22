package com.ss.android.lark.flow.chat.message.layout;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import w4b.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ ThreadForwardContentVOV2 a;
    public final /* synthetic */ i b;
    public final /* synthetic */ b3b.f c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public j(ThreadForwardContentVOV2 r1, i r2, b3b.f r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.h.isNoTraceDelete() == false) goto L7;
        FlowToast.c(((com.ss.android.lark.blueprint.a) this.b).a.getContext(), 2131890433);
        return;
    L7:
        if (this.a.g() == false) goto L12;
        b3b.f r5 = this.c;
        if (r5 == null) goto L20;
        r5.g(this.d, this.e);
        return;
    L20:
        return;
    L12:
        if (this.a.f() == true) goto L14;
    L16:
        b3b.f r6 = this.c;
        if (r6 == null) goto L23;
        r6.i(this.e);
        return;
    L23:
        return;
    L14:
        if (((v5b.a) this.a).a.getThread() == null) goto L16;
        e0 r7 = ChatCoreModule.a().getThreadDependency();
        Context r0 = ((com.ss.android.lark.blueprint.a) this.b).a.getContext();
        l1.a r1 = new l1.a();
        r1.e = this.d;
        r1.m = true;
        r7.b(r0, new l1(r1));
    }
}
