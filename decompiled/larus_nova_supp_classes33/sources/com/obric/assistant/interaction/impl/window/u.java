package com.obric.assistant.interaction.impl.window;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class u implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ObricListeningRelativeLayerController a;

    public /* synthetic */ u(ObricListeningRelativeLayerController r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        return ObricListeningRelativeLayerController.b(this.a);
    }
}
