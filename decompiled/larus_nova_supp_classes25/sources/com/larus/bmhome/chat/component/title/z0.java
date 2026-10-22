package com.larus.bmhome.chat.component.title;

import android.content.Context;
import android.view.View;
import ce8.c;
import com.larus.bmhome.chat.g4;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z0 implements View.OnClickListener {
    public final /* synthetic */ ChatTitleComponent a;

    public /* synthetic */ z0(ChatTitleComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ChatTitleComponent r0 = this.a;
        int r1 = ChatTitleComponent.P1;
        g4 r2 = r0.e4();
        if (r2 == null) goto L7;
        Intrinsics.checkNotNull(r4);
        boolean r5 = r2.j(r4);
        boolean r3 = true;
        if (r5 != true) goto L7;
    L8:
        if (r3 == false) goto L11;
        return;
    L11:
        if (c.a() == false) goto L13;
        t19.s r6 = t19.s.a;
        Context r7 = r0.getContext();
        String r8 = AppHost.a.getApplication().getString(2131901003);
        r6.getClass();
        t19.s.t(r7, r8);
        return;
    L13:
        r0.T4();
        r0.R4();
        return;
    L7:
        r3 = false;
        goto L8
    }
}
