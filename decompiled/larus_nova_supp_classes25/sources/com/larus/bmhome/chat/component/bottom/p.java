package com.larus.bmhome.chat.component.bottom;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ ChatBottomComponent a;

    public /* synthetic */ p(ChatBottomComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatBottomComponent r0 = this.a;
        int r1 = ChatBottomComponent.L0;
        ICoreInputAbility r2 = r0.E3();
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L13;
        ICoreInputAbility r4 = r0.E3();
        if (r4 == null) goto L14;
        ICoreInputAbility.b.e(r4, "subConversation", null, false, 6);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r2.Rp() != 2) goto L7;
        r3 = true;
        goto L8
    }
}
