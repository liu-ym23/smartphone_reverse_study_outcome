package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ProducerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContentResolver f8121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f8122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AssetManager f8123c;
    public final ByteArrayPool d;
    public final DefaultImageDecoder e;
    public final SimpleProgressiveJpegConfig f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DefaultExecutorSupplier f8124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PooledByteBufferFactory f8125i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BufferedDiskCache f8126j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BufferedDiskCache f8127k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HashMap f8128l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final InstrumentedMemoryCache f8129m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final InstrumentedMemoryCache f8130n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DefaultCacheKeyFactory f8131o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final PlatformBitmapFactory f8132p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CloseableReferenceFactory f8133q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f8134r;

    public ProducerFactory(Context r5, ByteArrayPool r10, DefaultImageDecoder r11, SimpleProgressiveJpegConfig r12, boolean r13, DefaultExecutorSupplier r14, PooledByteBufferFactory r15, InstrumentedMemoryCache r16, InstrumentedMemoryCache r17, BufferedDiskCache r18, BufferedDiskCache r19, HashMap r110, DefaultCacheKeyFactory r111, PlatformBitmapFactory r112, CloseableReferenceFactory r113, int r114) {
        this.f8121a = r5.getApplicationContext().getContentResolver();
        this.f8122b = r5.getApplicationContext().getResources();
        this.f8123c = r5.getApplicationContext().getAssets();
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.f8124h = r14;
        this.f8125i = r15;
        this.f8130n = r16;
        this.f8129m = r17;
        this.f8126j = r18;
        this.f8127k = r19;
        this.f8128l = r110;
        this.f8131o = r111;
        this.f8132p = r112;
        new BoundedLinkedHashSet(r114);
        new BoundedLinkedHashSet(r114);
        this.f8134r = 2048;
        this.f8133q = r113;
    }

    public final LocalExifThumbnailProducer a() {
        return new LocalExifThumbnailProducer(this.f8124h.f8059a, this.f8125i, this.f8121a);
    }
}
