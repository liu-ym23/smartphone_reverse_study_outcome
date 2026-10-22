package com.obric.assistant.interaction.impl.window;

import android.view.SurfaceControl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class x implements SurfaceControl.TransactionCommittedListener {
    public final /* synthetic */ ObricListeningRelativeLayerController a;
    public final /* synthetic */ ObricListeningRelativeLayerController$SurfaceKey b;

    public /* synthetic */ x(ObricListeningRelativeLayerController r1, ObricListeningRelativeLayerController$SurfaceKey r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.SurfaceControl.TransactionCommittedListener
    public final void onTransactionCommitted() {
        ObricListeningRelativeLayerController.e(this.a, this.b);
    }
}
