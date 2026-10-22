package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.graphics.Path;
import android.util.SparseArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class c {
    public final SparseArray<Path> a;

    public abstract Path b(int r1, int r2, int r3);

    public abstract Path c(int r1, float r2, float r3);

    public c() {
        this.a = new SparseArray();
    }

    public final Path a(int r2, float r3, float r4) {
        if (this.a.get(r2) != null) goto L5;
        this.a.put(r2, c(r2, r3, r4));
    L5:
        Path r5 = this.a.get(r2);
        if (r5 == null) goto L8;
        return r5;
    L8:
        return new Path();
    }
}
