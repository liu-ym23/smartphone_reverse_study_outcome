package com.obric.assistant.interaction.impl.window;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class n1 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ AssistantChatDialog a;

    public /* synthetic */ n1(AssistantChatDialog r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        WindowHost.E(this.a, r2);
    }
}
