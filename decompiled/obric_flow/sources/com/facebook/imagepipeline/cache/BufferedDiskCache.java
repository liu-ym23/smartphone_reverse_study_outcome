package com.facebook.imagepipeline.cache;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.DiskWrapperCacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.MemoryPooledByteBuffer;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferFactory;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import h.f;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class BufferedDiskCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileCache f8006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f8007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PooledByteStreams f8008c;
    public final ExecutorService d;
    public final ExecutorService e;
    public final StagingArea f;
    public final NoOpImageCacheStatsTracker g;

    public BufferedDiskCache(FileCache r5, PooledByteBufferFactory r10, PooledByteStreams r11, ExecutorService r12, ExecutorService r13, NoOpImageCacheStatsTracker r14) {
        this.f8006a = r5;
        this.f8007b = r10;
        this.f8008c = r11;
        this.d = r12;
        this.e = r13;
        this.g = r14;
        this.f = new StagingArea();
    }

    public static MemoryPooledByteBuffer a(BufferedDiskCache r10, SimpleCacheKey r11) {
        r10.getClass();
        String r5 = r11.f7579a;     // Catch: Exception -> L7
        Boolean r12 = Boolean.FALSE;     // Catch: Exception -> L7
        FLog.a(BufferedDiskCache.class, "Disk cache read for %s needEncrypt = %s", r5, r12);     // Catch: Exception -> L7
        BinaryResource r13 = ((DiskStorageCache) r10.f8006a).a(r11);     // Catch: Exception -> L7
        if (r13 != null) goto L9;
        FLog.a(BufferedDiskCache.class, "Disk cache miss for %s", r11.f7579a);     // Catch: Exception -> L7
        r10.g.getClass();     // Catch: Exception -> L7
        return null;
    L9:
        FLog.a(BufferedDiskCache.class, "Found entry in disk cache for %s", r11.f7579a);     // Catch: Exception -> L7
        r10.g.getClass();     // Catch: Exception -> L7
        FileInputStream r14 = new FileInputStream(((FileBinaryResource) r13).f7574a);     // Catch: Exception -> L7
        PooledByteBufferFactory r15 = r10.f8007b;     // Catch: Throwable -> L15
        int r16 = (int) ((FileBinaryResource) r13).f7574a.length();     // Catch: Throwable -> L15
        MemoryPooledByteBufferFactory r17 = (MemoryPooledByteBufferFactory) r15;     // Catch: Throwable -> L15
        r17.getClass();     // Catch: Throwable -> L15
        MemoryPooledByteBufferOutputStream r18 = new MemoryPooledByteBufferOutputStream(r17.f8231b, r16);     // Catch: Throwable -> L15
        r17.f8230a.a(r14, r18);     // Catch: Throwable -> L17
        MemoryPooledByteBuffer r19 = r18.b();     // Catch: Throwable -> L17
        r18.close();     // Catch: Throwable -> L15
        r14.close();     // Catch: Exception -> L7
        FLog.a(BufferedDiskCache.class, "Successful read from disk cache for %s needEncrypt = %s", r11.f7579a, r12);     // Catch: Exception -> L7
        return r19;
    L17:
        th = move-exception;
        r18.close();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r14.close();     // Catch: Exception -> L7
        throw th;     // Catch: Exception -> L7
    L7:
        e = move-exception;
        FLog.a(e, "Exception reading from cache for %s needEncrypt = %s", new Object[]{r11.f7579a, Boolean.FALSE});
        r10.g.getClass();
        throw e;
    }

    public final void b(final SimpleCacheKey r5, EncodedImage r10) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L18
        if (EncodedImage.c(r10) == false) goto L31;
        StagingArea r11 = this.f;     // Catch: Throwable -> L18
        monitor-enter(r11);     // Catch: Throwable -> L18
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L7:
        if (EncodedImage.c(r10) == false) goto L27;
        EncodedImage r12 = (EncodedImage) r11.f8040a.put(r5, EncodedImage.a(r10));     // Catch: Throwable -> L11
        if (r12 == null) goto L13;
        r12.close();     // Catch: Throwable -> L11
    L13:
        r11.a();     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        final EncodedImage r13 = EncodedImage.a(r10);     // Catch: Throwable -> L18
        this.e.execute(new AnonymousClass4(this, r5, r13));     // Catch: Throwable -> L18 Exception -> L20
    L24:
        FrescoSystrace.a().getClass();
        return;
    L20:
        e = move-exception;
        FLog.a(e, "Failed to schedule disk-cache write for %s", new Object[]{r5.f7579a});     // Catch: Throwable -> L18
        this.f.a(r5, r10);     // Catch: Throwable -> L18
        if (r13 == null) goto L24;
        r13.close();     // Catch: Throwable -> L18
        goto L24
    L27:
        throw new IllegalArgumentException();     // Catch: Throwable -> L11
    L31:
        throw new IllegalArgumentException();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public final void c(SimpleCacheKey r5, final EncodedImage r10) {
        FLog.a(BufferedDiskCache.class, "About to write to disk-cache for key %s", r5.f7579a);
        FileCache r11 = this.f8006a;     // Catch: IOException -> L5
        DiskStorageCache r12 = (DiskStorageCache) r11;     // Catch: IOException -> L5
        r12.a(new DiskWrapperCacheKey(r5, r10.f8184l), new AnonymousClass7(this, r10));     // Catch: IOException -> L5
        this.g.getClass();     // Catch: IOException -> L5
        FLog.a(BufferedDiskCache.class, "Successful disk-cache write for key %s", r5.f7579a);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        FLog.a(e, "Failed to write to disk-cache for key %s", new Object[]{r5.f7579a});
    }

    public final f a(final SimpleCacheKey r5, final AtomicBoolean r10) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L7
        EncodedImage r11 = this.f.a(r5);     // Catch: Throwable -> L7
        if (r11 == null) goto L30;
        f r12 = a(r5, r11);     // Catch: Throwable -> L7
        FrescoSystrace.a().getClass();
        return r12;
    L30:
        f r13 = f.b(new AnonymousClass3(this, r10, r5), this.d);     // Catch: Throwable -> L7 Exception -> L11
    L19:
        FrescoSystrace.a().getClass();
        return r13;
    L11:
        e = move-exception;
        FLog.a(e, "Failed to schedule disk-cache read for %s", new Object[]{r5.f7579a});     // Catch: Throwable -> L7
        f r14 = new f();     // Catch: Throwable -> L7
        monitor-enter(r14.f17267a);     // Catch: Throwable -> L7
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L7
    L15:
        if (r14.f17268b == true) goto L25;
        r14.f17268b = true;     // Catch: Throwable -> L21
        r14.e = e;     // Catch: Throwable -> L21
        r14.f17267a.notifyAll();     // Catch: Throwable -> L21
        r14.f();     // Catch: Throwable -> L21
        r13 = r14;
        goto L19
    L25:
        throw new IllegalStateException("Cannot set the error on a completed task.");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public final f a(SimpleCacheKey r5, EncodedImage r10) {
        FLog.a(BufferedDiskCache.class, "Found image for %s in staging area", r5.f7579a);
        this.g.getClass();
        ExecutorService r11 = f.g;
        f r12 = new f();
        if (r12.d(r10) == false) goto L6;
        return r12;
    L6:
        throw new IllegalStateException("Cannot set the result of a completed task.");
    }
}
