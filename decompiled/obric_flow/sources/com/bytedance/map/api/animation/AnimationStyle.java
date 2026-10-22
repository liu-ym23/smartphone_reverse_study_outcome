package com.bytedance.map.api.animation;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f6871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f6872c;
    public long d;
    public Interpolator e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6873h;

    public AnimationStyle() {
        this.f6870a = 0;
        this.f6871b = 1.0f;
        this.f6872c = 1.0f;
        this.d = 250;
        this.e = new LinearInterpolator();
        this.f = 0;
        this.g = 0;
        this.f6873h = 1;
    }
}
