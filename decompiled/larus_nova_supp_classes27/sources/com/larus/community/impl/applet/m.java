package com.larus.community.impl.applet;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ m(Ref.BooleanRef r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ref.BooleanRef r0 = this.a;
        Runnable r1 = this.b;
        if (r0.element == true) goto L7;
        r0.element = true;
        r1.run();
        return;
    }
}
