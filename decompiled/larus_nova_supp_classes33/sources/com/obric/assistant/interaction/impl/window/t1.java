package com.obric.assistant.interaction.impl.window;

import android.content.res.Configuration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class t1 implements Runnable {
    public final /* synthetic */ Configuration a;

    public /* synthetic */ t1(Configuration r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.configurationCallback.1.a(this.a);
    }
}
