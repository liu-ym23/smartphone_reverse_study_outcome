package com.obric.assistant.interaction.impl.window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class y implements Runnable {
    public final /* synthetic */ SystemEventDispatcher$startDisplayListener$newListener$1 a;
    public final /* synthetic */ int b;

    public /* synthetic */ y(SystemEventDispatcher$startDisplayListener$newListener$1 r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SystemEventDispatcher.a(this.a, this.b);
    }
}
