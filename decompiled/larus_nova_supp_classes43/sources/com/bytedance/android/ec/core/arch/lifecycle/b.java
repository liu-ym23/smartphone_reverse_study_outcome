package com.bytedance.android.ec.core.arch.lifecycle;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public boolean a;
    public boolean b;
    public boolean c;
    public final Queue<Runnable> d;

    public final void a() {
        if (this.c == false) goto L27;
        return;
    L27:
        this.c = true;     // Catch: Throwable -> L24
    L7:
        if ((!((ArrayDeque) this.d).isEmpty()) == false) goto L22;
        if (this.b == false) goto L12;
    L15:
        boolean r10 = true;
    L16:
        if (r10 == false) goto L22;
        Runnable r11 = (Runnable) ((ArrayDeque) this.d).poll();     // Catch: Throwable -> L24
        if (r11 == null) goto L7;
        r11.run();     // Catch: Throwable -> L24
        goto L7
    L12:
        if (this.a == false) goto L15;
        r10 = false;
    L22:
        this.c = false;
        return;
    L24:
        th = move-exception;
        this.c = false;
        throw th;
    }

    public b() {
        this.a = true;
        this.d = new ArrayDeque();
    }
}
