package com.bytedance.map.api.image;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public class BitmapWrapper implements Comparable<BitmapWrapper> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f6900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6901b;

    public BitmapWrapper(Bitmap r5, int r10) {
        this.f6900a = r5;
        this.f6901b = r10;
    }

    @Override // java.lang.Comparable
    public final int compareTo(BitmapWrapper r5) {
        return this.f6901b - r5.f6901b;
    }
}
