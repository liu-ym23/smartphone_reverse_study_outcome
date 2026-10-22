package com.obric.assistant.interaction.impl.window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c1 implements Runnable {
    public final /* synthetic */ Throwable a;

    public /* synthetic */ c1(Throwable r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.i(this.a);
    }
}
