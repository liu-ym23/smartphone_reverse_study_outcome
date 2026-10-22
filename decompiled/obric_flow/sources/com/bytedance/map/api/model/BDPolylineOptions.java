package com.bytedance.map.api.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BDPolylineOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f6929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6931c;
    public final boolean d;
    public final float e;
    public final float f;
    public final Bitmap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f6932h;

    public BDPolylineOptions(String r5, List r10, int r11, int r12, float r13, boolean r14, float r15, Bitmap r16) {
        Color.argb(255, 0, 0, 0);
        this.f6932h = false;
        this.f6929a = r10;
        this.f6931c = r11;
        this.f6930b = r12;
        this.e = r13;
        this.d = r14;
        this.f = r15;
        if (r16 == null) goto L6;
        this.g = r16;
        this.f6932h = true;
        return;
    }
}
