package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class l0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;
    public final /* synthetic */ WindowAnimationType d;

    public /* synthetic */ l0(int r1, long r2, int r4, WindowAnimationType r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.x(this.a, this.b, this.c, this.d);
    }
}
