package com.bytedance.android.ec.core.anchorv3;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class q {
    public final CountDownLatch a;
    public volatile boolean b;
    public volatile boolean c;
    public int d;

    public static final class a {
    }

    static {
    }

    public q() {
        this(3);
    }

    public abstract void c();

    public final void a() {
        if (this.c == false) goto L5;
        return;
    L5:
        if (b() == true) goto L11;
        c();
        this.c = true;
        CountDownLatch r0 = this.a;
        if (r0 == null) goto L12;
        r0.countDown();
        return;
    L12:
        return;
    }

    public boolean b() {
        return this.b;
    }

    public q(int r10) {
        this.d = r10;
        if (r10 != (-1)) goto L5;
        CountDownLatch r11 = new CountDownLatch(1);
    L6:
        this.a = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }
}
