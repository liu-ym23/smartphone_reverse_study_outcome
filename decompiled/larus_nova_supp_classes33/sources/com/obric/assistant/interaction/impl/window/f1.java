package com.obric.assistant.interaction.impl.window;

import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f1 implements Runnable {
    public final /* synthetic */ Bundle a;

    public /* synthetic */ f1(Bundle r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.t(this.a);
    }
}
