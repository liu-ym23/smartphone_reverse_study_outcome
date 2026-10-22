package com.facebook.imagepipeline.cache;

import android.os.SystemClock;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;

/* JADX INFO: loaded from: classes2.dex */
public class BitmapMemoryCacheKey implements CacheKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResizeOptions f8003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RotationOptions f8004c;
    public final ImageDecodeOptions d;
    public final CacheKey e;
    public final String f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f8005h;

    public BitmapMemoryCacheKey(String r5, ResizeOptions r10, RotationOptions r11, ImageDecodeOptions r12, CacheKey r13, String r14, Object r15) {
        r5.getClass();
        this.f8002a = r5;
        this.f8003b = r10;
        this.f8004c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        Integer r16 = Integer.valueOf(r5.hashCode());
        int r17 = 0;
        if (r10 == null) goto L5;
        int r18 = ((r10.f8051a + 31) * 31) + r10.f8052b;
    L6:
        Integer r19 = Integer.valueOf(r18);
        Integer r20 = Integer.valueOf(r11.hashCode());
        int r21 = r16.hashCode();
        int r22 = r19.hashCode();
        int r23 = r20.hashCode();
        if (r12 != null) goto L9;
        int r24 = 0;
    L10:
        if (r13 != null) goto L12;
        int r25 = 0;
    L13:
        if (r14 == null) goto L16;
        r17 = r14.hashCode();
    L16:
        this.g = ((((((((((r21 + 31) * 31) + r22) * 31) + r23) * 31) + r24) * 31) + r25) * 31) + r17;
        this.f8005h = r15;
        RealtimeSinceBootClock.get().getClass();
        SystemClock.elapsedRealtime();
        return;
    L12:
        r25 = r13.hashCode();
        goto L13
    L9:
        r24 = r12.hashCode();
        goto L10
    L5:
        r18 = 0;
        goto L6
    }

    @Override // com.facebook.cache.common.CacheKey
    public final String a() {
        return this.f8002a;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof BitmapMemoryCacheKey) == true) goto L5;
        return false;
    L5:
        BitmapMemoryCacheKey r10 = (BitmapMemoryCacheKey) r5;
        if (this.g == r10.g) goto L8;
    L21:
        return false;
    L8:
        if (this.f8002a.equals(r10.f8002a) == false) goto L21;
        if (Objects.a(this.f8003b, r10.f8003b) == false) goto L21;
        if (Objects.a(this.f8004c, r10.f8004c) == false) goto L21;
        if (Objects.a(this.d, r10.d) == false) goto L21;
        if (Objects.a(this.e, r10.e) == false) goto L21;
        if (Objects.a(this.f, r10.f) == false) goto L21;
        return true;
    }

    public final int hashCode() {
        return this.g;
    }

    public final String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", new Object[]{this.f8002a, this.f8003b, this.f8004c, this.d, this.e, this.f, Integer.valueOf(this.g)});
    }
}
