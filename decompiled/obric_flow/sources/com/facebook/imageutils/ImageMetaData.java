package com.facebook.imageutils;

import android.graphics.ColorSpace;
import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
public class ImageMetaData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pair f8456a;

    public ImageMetaData(int r5, int r10, ColorSpace r11) {
        if (r5 == (-1)) goto L7;
        if (r10 == (-1)) goto L7;
        Pair r12 = new Pair(Integer.valueOf(r5), Integer.valueOf(r10));
    L8:
        this.f8456a = r12;
        return;
    L7:
        r12 = null;
        goto L8
    }
}
