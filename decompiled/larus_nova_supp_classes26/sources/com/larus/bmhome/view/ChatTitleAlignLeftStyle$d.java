package com.larus.bmhome.view;

import android.view.View;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatTitleAlignLeftStyle$d implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ ChatTitleAlignLeftStyle b;
    public final /* synthetic */ String c;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        this.a.removeOnAttachStateChangeListener(this);
        this.b.getBinding().D.setAnimation(this.c);
        this.b.getBinding().D.playAnimation();
    }

    public ChatTitleAlignLeftStyle$d(LottieAdapterView r1, ChatTitleAlignLeftStyle r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
