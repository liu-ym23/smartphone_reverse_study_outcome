package com.obric.assistant.interaction.impl.window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class z0 implements Runnable {
    public final /* synthetic */ float a;

    public /* synthetic */ z0(float r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.b(this.a);
    }
}
