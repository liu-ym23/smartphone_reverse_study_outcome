package com.larus.bmhome.chat.component.bottom;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ ChatBottomComponent a;
    public final /* synthetic */ ChatBottomComponent$b b;

    public /* synthetic */ x(ChatBottomComponent r1, ChatBottomComponent$b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatBottomComponent r0 = this.a;
        ChatBottomComponent$b r1 = this.b;
        if (Intrinsics.areEqual(r0.O, r1) == false) goto L6;
        r0.Z3(r1, 0);
        return;
    }
}
