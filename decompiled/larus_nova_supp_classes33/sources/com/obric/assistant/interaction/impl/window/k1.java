package com.obric.assistant.interaction.impl.window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class k1 implements Runnable {
    public final /* synthetic */ AssistantChatDialog a;
    public final /* synthetic */ WindowHost$NavigationBarInsetsRuntime b;

    public /* synthetic */ k1(AssistantChatDialog r1, WindowHost$NavigationBarInsetsRuntime r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.d(this.a, this.b);
    }
}
