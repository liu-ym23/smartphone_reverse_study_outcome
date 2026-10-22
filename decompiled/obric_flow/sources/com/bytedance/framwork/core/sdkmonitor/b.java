package com.bytedance.framwork.core.sdkmonitor;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f4703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList f4704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList f4705c;
    public final int d;
    public boolean e;

    public b() {
        this.f4703a = new LinkedList();
        this.f4704b = new LinkedList();
        this.f4705c = new LinkedList();
        this.d = 200;
    }

    public final void a(e r5) {
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        ia.a.f17554a.w(new ab.b(9, this, false, r5));
    }
}
