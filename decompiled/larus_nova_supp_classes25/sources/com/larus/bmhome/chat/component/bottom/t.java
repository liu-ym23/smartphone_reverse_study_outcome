package com.larus.bmhome.chat.component.bottom;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t implements Runnable {
    public final /* synthetic */ View a;

    public /* synthetic */ t(View r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a;
        int r1 = ChatBottomComponent.L0;
        r0.setVisibility(0);
    }
}
