package com.larus.bmhome.chat.component.list;

import android.view.View;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n implements View.OnClickListener {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ n(ChatListComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ChatListComponent r5 = this.a;
        int r0 = ChatListComponent.W3;
        ICoreInputAbility r1 = r5.T4();
        boolean r2 = false;
        if (r1 == null) goto L5;
        r1.qp(false);
    L5:
        ICoreInputAbility r3 = r5.T4();
        if (r3 != null) goto L8;
    L10:
        if (r2 == false) goto L22;
        MessageAdapter r6 = r5.O;
        if (r6 == null) goto L22;
        Message r7 = r6.I2();
        if (r7 == null) goto L22;
        ChatControlTrace r8 = ChatControlTrace.b;
        com.larus.bmhome.chat.component.bottom.p1 r9 = (com.larus.bmhome.chat.component.bottom.p1) r5.y2.getValue();
        if (r9 == null) goto L20;
        View r10 = r9.bo();
        if (r10 == null) goto L20;
        Object r11 = r10.getTag();
    L21:
        r8.lb(r7, (String) r11);
    L20:
        r11 = null;
    L22:
        ICoreInputAbility r12 = r5.T4();
        if (r12 == null) goto L26;
        ICoreInputAbility.b.a(r12, 2);
        return;
    L26:
        return;
    L8:
        if (r3.Rp() != 4) goto L10;
        r2 = true;
        goto L10
    }
}
