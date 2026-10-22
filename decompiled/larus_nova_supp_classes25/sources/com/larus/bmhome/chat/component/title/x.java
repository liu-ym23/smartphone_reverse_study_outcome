package com.larus.bmhome.chat.component.title;

import android.content.Context;
import android.view.View;
import ce8.c;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;
import sd8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x implements View.OnClickListener {
    public final /* synthetic */ ChatTitleComponent a;

    public /* synthetic */ x(ChatTitleComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        ChatTitleComponent r6 = this.a;
        int r0 = ChatTitleComponent.P1;
        if (c.a() == false) goto L5;
        t19.s r1 = t19.s.a;
        Context r7 = r6.getContext();
        String r2 = AppHost.a.getApplication().getString(2131901004);
        r1.getClass();
        t19.s.t(r7, r2);
        return;
    L5:
        ICoreInputAbility r3 = r6.W3();
        boolean r4 = false;
        if (r3 == null) goto L8;
        r3.C1(false, false, "click_side_bar");
    L8:
        r6.T4();
        a r8 = r6.E3();
        if (r8 == null) goto L13;
        qy8.a r9 = r8.yu();
        if (r9 == null) goto L13;
        qy8.c r10 = r9.a;
    L14:
        if (r10 == null) goto L19;
        if (r10.a() != true) goto L19;
        r4 = true;
    L19:
        if (r4 == false) goto L21;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        r10.c(com.larus.ui.arch.component.internal.attach.a.b(r6, r6));
        return;
    L21:
        Intrinsics.checkNotNullParameter(r6, "<this>");
        com.larus.bmhome.a0 r11 = com.larus.bmhome.b0.a(com.larus.ui.arch.component.internal.attach.a.b(r6, r6));
        if (r11 == null) goto L27;
        r11.cs();
        return;
    L27:
        return;
    L13:
        r10 = null;
        goto L14
    }
}
