package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class q0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ WindowAnimationType d;

    public /* synthetic */ q0(int r1, int r2, long r3, WindowAnimationType r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.k(this.a, this.b, this.c, this.d);
    }
}
