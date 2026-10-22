package com.larus.bmhome.chat.component.collection;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ ChatCollectMessageComponent a;
    public final /* synthetic */ View b;

    public /* synthetic */ c(ChatCollectMessageComponent r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatCollectMessageComponent r0 = this.a;
        View r1 = this.b;
        int r2 = ChatCollectMessageComponent.v;
        r0.z3(r1);
    }
}
