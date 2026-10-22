package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class g1 implements Runnable {
    public final /* synthetic */ WindowAnimationType a;

    public /* synthetic */ g1(WindowAnimationType r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.L(this.a);
    }
}
