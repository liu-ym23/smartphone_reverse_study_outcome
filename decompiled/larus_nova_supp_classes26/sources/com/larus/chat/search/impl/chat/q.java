package com.larus.chat.search.impl.chat;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ ChatSearchFragment b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r4) {
        this.a.removeOnAttachStateChangeListener(this);
        ChatSearchFragment r0 = this.b;
        WindowInsetsCompat r1 = ViewCompat.getRootWindowInsets(r4);
        int r2 = ChatSearchFragment.A;
        r0.fa0(r4, r1);
    }

    public q(View r1, ChatSearchFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
