package com.larus.bmhome.chat.component.bottom;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u0 implements Runnable {
    public final /* synthetic */ ChatBottomComponent a;
    public final /* synthetic */ ChatBottomComponent$b b;
    public final /* synthetic */ int c;

    public /* synthetic */ u0(ChatBottomComponent r1, ChatBottomComponent$b r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatBottomComponent r0 = this.a;
        ChatBottomComponent$b r1 = this.b;
        int r2 = this.c;
        if (Intrinsics.areEqual(r0.O, r1) == false) goto L6;
        r0.Z3(r1, r2 + 1);
        return;
    }
}
