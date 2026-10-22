package com.larus.bmhome.chat;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v0 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    public v0(View r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        this.a.removeOnAttachStateChangeListener(this);
        ViewCompat.requestApplyInsets(r2);
    }
}
