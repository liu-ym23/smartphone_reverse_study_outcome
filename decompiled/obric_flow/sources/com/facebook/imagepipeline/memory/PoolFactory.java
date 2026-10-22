package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class PoolFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PoolConfig f8242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MemoryChunkPool f8243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BitmapPool f8244c;
    public MemoryChunkPool d;
    public FlexByteArrayPool e;
    public MemoryChunkPool f;
    public MemoryPooledByteBufferFactory g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PooledByteStreams f8245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GenericByteArrayPool f8246i;

    public PoolFactory(PoolConfig r5) {
        this.f8242a = r5;
    }

    public final BitmapPool a() {
        if (this.f8244c != null) goto L48;
        String r5 = this.f8242a.f8240i;
        switch(r5.hashCode()) {
            case -1868884870: goto L20;
            case -1106578487: goto L17;
            case -404562712: goto L14;
            case -402149703: goto L11;
            case 95945896: goto L8;
            default: goto L55;
        };
    L55:
        byte r10 = -1;
    L23:
        if (r10 == 0) goto L46;
        if (r10 == 1) goto L45;
        if (r10 == 2) goto L33;
        if (r10 == 3) goto L28;
        PoolConfig r11 = this.f8242a;
        this.f8244c = new BucketsBitmapPool(r11.d, r11.f8236a, r11.f8237b);
        goto L48
    L28:
        NoOpMemoryTrimmableRegistry r12 = this.f8242a.d;
        SparseIntArray r13 = DefaultBitmapPoolParams.f8218a;
        int r14 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (r14 <= 16777216) goto L31;
        int r15 = (r14 / 4) * 3;
    L32:
        this.f8244c = new BucketsBitmapPool(r12, new PoolParams(0, r15, DefaultBitmapPoolParams.f8218a, -1), this.f8242a.f8237b);
        goto L48
    L31:
        r15 = r14 / 2;
        goto L32
    L33:
        int r16 = this.f8242a.f8241j;
        monitor-enter(NoOpPoolStatsTracker.class);
    L38:
        th = move-exception;
        throw th;
    L36:
        if (NoOpPoolStatsTracker.f8235a != null) goto L40;
        NoOpPoolStatsTracker.f8235a = new NoOpPoolStatsTracker();     // Catch: Throwable -> L38
    L40:
        NoOpPoolStatsTracker r17 = NoOpPoolStatsTracker.f8235a;     // Catch: Throwable -> L38
        monitor-exit(NoOpPoolStatsTracker.class);     // Catch: Throwable -> L38
        this.f8244c = new LruBitmapPool(r16, r17);
        goto L48
    L45:
        this.f8244c = new DummyTrackingInUseBitmapPool();
        goto L48
    L46:
        this.f8244c = new DummyBitmapPool();
        goto L48
    L8:
        if (r5.equals("dummy") == false) goto L22;
        r10 = 0;
        goto L23
    L22:
        r10 = -1;
        goto L23
    L11:
        if (r5.equals("dummy_with_tracking") == false) goto L51;
        r10 = 1;
        goto L23
    L51:
        r10 = -1;
        goto L23
    L14:
        if (r5.equals("experimental") == false) goto L52;
        r10 = 2;
        goto L23
    L52:
        r10 = -1;
        goto L23
    L17:
        if (r5.equals("legacy") == false) goto L53;
        r10 = 4;
        goto L23
    L53:
        r10 = -1;
        goto L23
    L20:
        if (r5.equals("legacy_default_params") == false) goto L54;
        r10 = 3;
        goto L23
    L54:
        r10 = -1;
    L48:
        return this.f8244c;
    }

    public final FlexByteArrayPool b() {
        if (this.e != null) goto L6;
        PoolConfig r5 = this.f8242a;
        this.e = new FlexByteArrayPool(r5.d, r5.f8238c);
    L6:
        return this.e;
    }

    public final PooledByteBufferFactory b(int r10) {
        if (this.g != null) goto L12;
        Preconditions.a(a(r10), "failed to get pool for chunk type: " + r10);
        MemoryChunkPool r11 = a(r10);
        if (this.f8245h == null) goto L7;
    L10:
        this.g = new MemoryPooledByteBufferFactory(r11, this.f8245h);
        goto L12
    L7:
        if (this.f8246i != null) goto L9;
        PoolConfig r5 = this.f8242a;
        this.f8246i = new GenericByteArrayPool(r5.d, r5.g, r5.f8239h);
    L9:
        this.f8245h = new PooledByteStreams(this.f8246i);
    L12:
        return this.g;
    }

    public final MemoryChunkPool a(int r10) {
        if (r10 == 0) goto L33;
        if (r10 == 1) goto L22;
        if (r10 != 2) goto L20;
        if (this.f8243b != null) goto L18;
        Constructor r11 = AshmemMemoryChunkPool.class.getConstructor(new Class[]{MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class});     // Catch: InvocationTargetException -> L12 NoSuchMethodException -> L13 InstantiationException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16
        PoolConfig r5 = this.f8242a;     // Catch: InvocationTargetException -> L12 NoSuchMethodException -> L13 InstantiationException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16
        this.f8243b = (MemoryChunkPool) r11.newInstance(new Object[]{r5.d, r5.e, r5.f});     // Catch: InvocationTargetException -> L12 NoSuchMethodException -> L13 InstantiationException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16
    L16:
        this.f8243b = null;
    L15:
        this.f8243b = null;
    L14:
        this.f8243b = null;
    L13:
        this.f8243b = null;
    L12:
        this.f8243b = null;
    L18:
        return this.f8243b;
    L20:
        throw new IllegalArgumentException("Invalid MemoryChunkType");
    L22:
        if (this.d != null) goto L31;
        Constructor r12 = BufferMemoryChunkPool.class.getConstructor(new Class[]{MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class});     // Catch: InvocationTargetException -> L25 NoSuchMethodException -> L26 InstantiationException -> L27 IllegalAccessException -> L28 ClassNotFoundException -> L29
        PoolConfig r13 = this.f8242a;     // Catch: InvocationTargetException -> L25 NoSuchMethodException -> L26 InstantiationException -> L27 IllegalAccessException -> L28 ClassNotFoundException -> L29
        this.d = (MemoryChunkPool) r12.newInstance(new Object[]{r13.d, r13.e, r13.f});     // Catch: InvocationTargetException -> L25 NoSuchMethodException -> L26 InstantiationException -> L27 IllegalAccessException -> L28 ClassNotFoundException -> L29
    L29:
        this.d = null;
    L28:
        this.d = null;
    L27:
        this.d = null;
    L26:
        this.d = null;
    L25:
        this.d = null;
    L31:
        return this.d;
    L33:
        if (this.f != null) goto L52;
        Constructor<?> r14 = Class.forName("com.facebook.imagepipeline.memory.NativeMemoryChunkPool").getConstructor(new Class[]{MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class});     // Catch: InvocationTargetException -> L36 NoSuchMethodException -> L38 InstantiationException -> L40 IllegalAccessException -> L42 ClassNotFoundException -> L44
        PoolConfig r15 = this.f8242a;     // Catch: InvocationTargetException -> L36 NoSuchMethodException -> L38 InstantiationException -> L40 IllegalAccessException -> L42 ClassNotFoundException -> L44
        this.f = (MemoryChunkPool) r14.newInstance(new Object[]{r15.d, r15.e, r15.f});     // Catch: InvocationTargetException -> L36 NoSuchMethodException -> L38 InstantiationException -> L40 IllegalAccessException -> L42 ClassNotFoundException -> L44
    L44:
        e = move-exception;
        FLog.a("PoolFactory", "", e);
        this.f = null;
    L42:
        e = move-exception;
        FLog.a("PoolFactory", "", e);
        this.f = null;
    L40:
        e = move-exception;
        FLog.a("PoolFactory", "", e);
        this.f = null;
    L38:
        e = move-exception;
        FLog.a("PoolFactory", "", e);
        this.f = null;
    L36:
        e = move-exception;
        FLog.a("PoolFactory", "", e);
        this.f = null;
    L52:
        return this.f;
    }
}
