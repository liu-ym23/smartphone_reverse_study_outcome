package com.larus.bmhome.chat.component.list;

import android.view.View;
import com.larus.bmhome.databinding.LarusPageChatBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p5 implements View.OnLayoutChangeListener {
    public final /* synthetic */ LarusPageChatBinding a;
    public final /* synthetic */ ChatListComponent b;
    public final /* synthetic */ String c;

    public p5(LarusPageChatBinding r1, ChatListComponent r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        if (this.a.n.A == false) goto L6;
        this.b.kx(this.c, false);
        return;
    }
}
