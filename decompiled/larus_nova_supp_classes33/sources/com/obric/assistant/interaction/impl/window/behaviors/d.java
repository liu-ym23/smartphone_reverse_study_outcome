package com.obric.assistant.interaction.impl.window.behaviors;

import android.app.Activity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ ActivityStartBehavior a;
    public final /* synthetic */ Activity b;

    public /* synthetic */ d(ActivityStartBehavior r1, Activity r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityStartBehavior.d(this.a, this.b);
    }
}
