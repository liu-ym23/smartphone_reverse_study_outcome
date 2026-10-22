package com.obric.assistant.interaction.impl.window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class v implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ v(Runnable r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricListeningRelativeLayerController.d(this.a, this.b);
    }
}
