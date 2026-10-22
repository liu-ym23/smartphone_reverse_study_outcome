package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class j0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ WindowAnimationType b;

    public /* synthetic */ j0(String r1, WindowAnimationType r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.O(this.a, this.b);
    }
}
