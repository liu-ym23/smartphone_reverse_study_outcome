package com.obric.assistant.interaction.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ Exception a;

    public /* synthetic */ e(Exception r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AssistantChatWindowImpl.d(this.a);
    }
}
