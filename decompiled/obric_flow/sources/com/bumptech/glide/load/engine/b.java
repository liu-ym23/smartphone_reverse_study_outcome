package com.bumptech.glide.load.engine;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class b extends WeakReference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f1440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0 f1442c;

    public b(x r5, y r10, ReferenceQueue r11) {
        super(r10, r11);
        io.reactivex.internal.observers.h.h(r5, "Argument must not be null");
        this.f1440a = r5;
        boolean r12 = r10.f1590a;
        this.f1442c = null;
        this.f1441b = r12;
    }
}
