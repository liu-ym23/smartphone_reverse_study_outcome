package com.larus.bmhome.view;

import android.view.View;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatTitleAlignLeftStyle$c implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ ChatTitleAlignLeftStyle b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r1) {
        this.a.removeOnAttachStateChangeListener(this);
        this.b.getBinding().D.cancelAnimation();
        this.b.V6();
    }

    public ChatTitleAlignLeftStyle$c(LottieAdapterView r1, ChatTitleAlignLeftStyle r2) {
        this.a = r1;
        this.b = r2;
    }
}
