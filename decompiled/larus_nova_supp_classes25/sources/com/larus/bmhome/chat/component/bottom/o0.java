package com.larus.bmhome.chat.component.bottom;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o0 implements Runnable {
    public final /* synthetic */ ChatBottomComponent a;

    public /* synthetic */ o0(ChatBottomComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatBottomComponent r0 = this.a;
        int r1 = ChatBottomComponent.L0;
        ICoreInputAbility r2 = r0.E3();
        if (r2 == null) goto L6;
        ICoreInputAbility.b.e(r2, "humanMergeForward", null, false, 6);
        return;
    }
}
