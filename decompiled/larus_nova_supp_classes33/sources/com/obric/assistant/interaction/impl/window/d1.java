package com.obric.assistant.interaction.impl.window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d1 implements Runnable {
    public final /* synthetic */ AssistantChatDialog a;

    public /* synthetic */ d1(AssistantChatDialog r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.A(this.a);
    }
}
