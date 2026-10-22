package com.obric.assistant.util;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l2 implements oga.b {
    public final /* synthetic */ OrionChatExtensionUtils a;

    public final void onRequestDismissKeyguard() {
    }

    public l2(OrionChatExtensionUtils r1) {
        this.a = r1;
    }

    public final void onDismissFailed(boolean r4) {
        OrionChatExtensionUtils r5 = this.a;
        r5.getClass();
        FLogger.a.i(r5.a, "onDismissFailed");
        r5.f.set(true);
    }

    public final void onDismissSucceeded(boolean r4) {
        OrionChatExtensionUtils r5 = this.a;
        r5.getClass();
        FLogger.a.i(r5.a, "onDismissSucceeded");
        r5.f.set(false);
    }
}
