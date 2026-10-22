package com.larus.bmhome.chat.component.list;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.functions.Function0;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n4 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ n4(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        if (a.c(r0).isAdded() == true) goto L5;
    L9:
        boolean r2 = false;
    L11:
        return Boolean.valueOf(r2);
    L5:
        if (a.c(r0).isDetached() == true) goto L9;
        if (a.c(r0).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L9;
        r2 = true;
        goto L11
    }
}
