package com.obric.assistant.interaction.impl.window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f0 implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;

    public /* synthetic */ f0(boolean r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.I(this.a, this.b);
    }
}
