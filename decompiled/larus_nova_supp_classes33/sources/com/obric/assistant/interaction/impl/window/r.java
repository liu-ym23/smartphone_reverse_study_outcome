package com.obric.assistant.interaction.impl.window;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class r implements Runnable {
    public final /* synthetic */ HomeSwipeUpGestureController a;
    public final /* synthetic */ int b;
    public final /* synthetic */ View c;

    public /* synthetic */ r(HomeSwipeUpGestureController r1, int r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HomeSwipeUpGestureController.a(this.a, this.b, this.c);
    }
}
