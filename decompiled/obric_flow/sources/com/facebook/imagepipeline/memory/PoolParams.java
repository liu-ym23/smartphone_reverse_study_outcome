package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes2.dex */
public class PoolParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseIntArray f8249c;
    public final int d;

    public PoolParams(int r5, int r10, SparseIntArray r11, int r12) {
        if (r5 < 0) goto L8;
        if (r10 < r5) goto L8;
        this.f8248b = r5;
        this.f8247a = r10;
        this.f8249c = r11;
        this.d = r12;
        return;
    L8:
        throw new IllegalStateException();
    }
}
