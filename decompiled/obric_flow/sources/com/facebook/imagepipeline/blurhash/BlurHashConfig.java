package com.facebook.imagepipeline.blurhash;

/* JADX INFO: loaded from: classes2.dex */
public final class BlurHashConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f7996c;
    public final boolean d;

    public BlurHashConfig(int r5, int r10) {
        this.f7994a = Math.min(r5, 100);
        this.f7995b = Math.min(r10, 100);
        this.f7996c = 1.0f;
        this.d = true;
    }
}
