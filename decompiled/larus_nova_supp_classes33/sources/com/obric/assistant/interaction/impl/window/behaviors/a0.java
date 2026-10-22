package com.obric.assistant.interaction.impl.window.behaviors;

import android.content.ComponentName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a0 implements Runnable {
    public final /* synthetic */ ComponentName a;
    public final /* synthetic */ ComponentName b;

    public /* synthetic */ a0(ComponentName r1, ComponentName r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TaskStackChangeBehavior.a(this.a, this.b);
    }
}
