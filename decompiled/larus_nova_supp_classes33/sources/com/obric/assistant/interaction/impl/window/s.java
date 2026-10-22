package com.obric.assistant.interaction.impl.window;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class s implements Executor {
    public final /* synthetic */ ObricListeningRelativeLayerController a;

    public /* synthetic */ s(ObricListeningRelativeLayerController r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r2) {
        ObricListeningRelativeLayerController.a(this.a, r2);
    }
}
