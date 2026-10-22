package com.bytedance.map.api.model;

import android.graphics.Bitmap;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class BDMarkerOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BDLatLng f6921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f6922c;
    public View d;
    public final float e;
    public final float f;
    public final float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f6923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f6924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f6925j;

    public BDMarkerOptions() {
        this.e = 0.5f;
        this.f = 0.5f;
        this.g = 0.0f;
        this.f6923h = 1.0f;
        this.f6924i = 0.0f;
        this.f6925j = true;
    }

    public BDMarkerOptions(BDLatLng r5, Bitmap r10, View r11, float r12, float r13, float r14, float r15, float r16, boolean r17, String r18) {
        this.f6921b = r5;
        this.f6922c = r10;
        this.d = r11;
        this.g = r12;
        this.f6923h = r13;
        this.e = r14;
        this.f = r15;
        this.f6924i = r16;
        this.f6925j = r17;
        this.f6920a = r18;
    }
}
