package com.larus.bmhome.chat.list.cell.text.user;

import android.view.View;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k0 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r1) {
    }

    public k0(CustomMarkdownTextView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
        this.a.removeOnAttachStateChangeListener(this);
    }
}
