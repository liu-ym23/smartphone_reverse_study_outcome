package com.obric.assistant.interaction.impl.window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class i1 implements Runnable {
    public final /* synthetic */ AssistantChatDialog a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;

    public /* synthetic */ i1(AssistantChatDialog r1, float r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.s(this.a, this.b, this.c);
    }
}
