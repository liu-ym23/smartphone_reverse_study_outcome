package com.obric.assistant.interaction.impl.essentialtask;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ Context a;

    public /* synthetic */ e(Context r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SubProcessTaskManager.c(this.a);
    }
}
