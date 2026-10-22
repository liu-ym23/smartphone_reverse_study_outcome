package com.obric.assistant.settings.voiceprint;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ c(Function0 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r0 = this.a;
        int r1 = ObricVoicePrintManagementActivity.q;
        r0.invoke();
    }
}
