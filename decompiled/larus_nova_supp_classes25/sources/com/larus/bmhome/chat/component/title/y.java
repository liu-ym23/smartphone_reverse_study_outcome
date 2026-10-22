package com.larus.bmhome.chat.component.title;

import android.content.Context;
import android.view.View;
import ce8.c;
import com.larus.bmhome.ability.FloatChatWindowEventType;
import com.larus.chat.ChatTitleBarIcon;
import com.larus.common.apphost.AppHost;
import java.util.Set;
import sd8.a;
import va8.f;
import va8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class y implements View.OnClickListener {
    public final /* synthetic */ ChatTitleComponent a;

    public /* synthetic */ y(ChatTitleComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        ChatTitleComponent r11 = this.a;
        int r0 = ChatTitleComponent.P1;
        if (c.a() == false) goto L5;
        t19.s r1 = t19.s.a;
        Context r12 = r11.getContext();
        String r2 = AppHost.a.getApplication().getString(2131901004);
        r1.getClass();
        t19.s.t(r12, r2);
        return;
    L5:
        r11.T4();
        a r3 = r11.E3();
        if (r3 == null) goto L14;
        qy8.a r4 = r3.yu();
        if (r4 == null) goto L14;
        Set r5 = r4.f;
        if (r5 == null) goto L14;
        boolean r6 = true;
        if (r5.contains(ChatTitleBarIcon.COLLAPSE) != true) goto L14;
    L15:
        if (r6 == false) goto L19;
        k r13 = (k) r11.B.getValue();
        if (r13 == null) goto L24;
        r13.hn(new f(FloatChatWindowEventType.BackPress, null, null, null, null, false, 62));
        return;
    L24:
        return;
    L19:
        gd8.f r14 = (gd8.f) r11.D.getValue();
        if (r14 == null) goto L26;
        r14.N9("click_back_button");
        return;
    L26:
        return;
    L14:
        r6 = false;
        goto L15
    }
}
