package com.ss.ugc.live.barrage.util;

import android.graphics.Bitmap;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ View d;
    public final /* synthetic */ Function3 e;

    public e(Bitmap r1, int r2, int r3, View r4, olc.a r5, Function3 r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.invoke(this.a, Integer.valueOf(this.b), Integer.valueOf(this.c));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
