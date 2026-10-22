package com.larus.extension.summary_card.impl.cell;

import android.view.View;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(CustomMarkdownTextView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
        this.a.removeOnAttachStateChangeListener(this);
    }
}
