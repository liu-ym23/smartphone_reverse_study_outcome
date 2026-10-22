package com.bytedance.gkfs.io;

import android.os.Handler;
import com.bytedance.geckox.logger.DefaultLogger;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f4875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ChunkFrom f4876c;
    public final ConcurrentHashMap d;
    public final p e;
    public final AtomicBoolean f;
    public volatile int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final File f4877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h f4878i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.gkfs.d f4879j;

    public i(File r5, h r10, com.bytedance.gkfs.d r11) {
        this.f4877h = r5;
        this.f4878i = r10;
        this.f4879j = r11;
        this.f4874a = "GkFSChunkReader@" + hashCode();
        this.f4876c = ChunkFrom.f4835c;
        this.d = new ConcurrentHashMap();
        this.e = new p();
        int r12 = 0;
        this.f = new AtomicBoolean(false);
        ThreadPoolExecutor r13 = com.bytedance.gkfs.c.f4814a;
        GkFSChunkReader$1 r14 = new GkFSChunkReader$1();
        GkFSChunkReader$2 r15 = new GkFSChunkReader$2(this);
        r10.getClass();
        if (r10.f4871b.get() == false) goto L5;
        return;
    L5:
        r14.invoke(new g(r12, r10, r15));
    }

    public final int a(byte[] r17, int r18, int r19) {
        if (this.f.get() == false) goto L6;
        return -1;
    L6:
        int r5 = this.f4879j.f4829a.incrementAndGet();
        int r10 = Math.min(r17.length - r18, r19);
        int r11 = 0;
        if (r10 != 0) goto L10;
        com.bytedance.gkfs.d r12 = this.f4879j;
        String r13 = this.f4874a;
        StringBuilder r14 = new StringBuilder("No need to read, arraySize:");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r14, r17.length, ", off:", r18, ", len:");
        r14.append(r19);
        com.bytedance.gkfs.d.c(r12, r13, r14.toString(), r5, 8);
        return 0;
    L10:
        long r15 = System.currentTimeMillis();
        int r16 = 0;
    L64:
    L15:
        th = move-exception;
        this.f.set(true);     // Catch: Throwable -> L59
        IOException r20 = new IOException("error occur when reading", th);     // Catch: Throwable -> L59
        c("error occur when reading", r20, r5);     // Catch: Throwable -> L59
        throw r20;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        if (r16 <= 0) goto L62;
        this.g += r16;
    L62:
        this.e.e = System.currentTimeMillis() - r15;
        throw th;
    L13:
        if (this.f4875b != null) goto L17;
        com.bytedance.gkfs.d.c(this.f4879j, this.f4874a, "read chunk start", r11, 12);     // Catch: Throwable -> L15
        this.f4875b = b(this.f4878i.b());     // Catch: Throwable -> L15
    L17:
        b r110 = this.f4875b;     // Catch: Throwable -> L15
        if (r110 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("currentBuffer");     // Catch: Throwable -> L15
    L21:
        c r111 = r110.f4856c.f4865a;     // Catch: Throwable -> L15
        if (this.e.d.get(r111) != null) goto L24;
        this.e.d.put(r111, TuplesKt.to(Long.valueOf(r15), Long.valueOf(r15)));     // Catch: Throwable -> L15
    L24:
        b r21 = this.f4875b;     // Catch: Throwable -> L15
        if (r21 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("currentBuffer");     // Catch: Throwable -> L15
    L27:
        r21.getClass();     // Catch: Throwable -> L15
        int r22 = ((InputStream) r21.f4854a.getValue()).read(r17, r18 + r16, r10 - r16);     // Catch: Throwable -> L15
        if (r22 <= 0) goto L30;
        r21.f4855b += r22;     // Catch: Throwable -> L15
    L30:
        if (r22 <= 0) goto L32;
        r16 = r16 + r22;     // Catch: Throwable -> L15
        int r112 = 0;
    L49:
        if (r16 >= r10) goto L53;
        r11 = r112;
    L53:
        if (r16 <= 0) goto L55;
        this.g += r16;
    L55:
        this.e.e = System.currentTimeMillis() - r15;
        return r16;
    L32:
        b r23 = this.f4875b;     // Catch: Throwable -> L15
        if (r23 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("currentBuffer");     // Catch: Throwable -> L15
    L35:
        a6.a r24 = new a6.a(r23, 17);     // Catch: Throwable -> L15
        Lazy r113 = com.bytedance.gkfs.c.f4815b;     // Catch: Throwable -> L15
        ((Handler) r113.getValue()).post(r24);     // Catch: Throwable -> L15
        LinkedHashMap r25 = this.e.d;     // Catch: Throwable -> L15
        long r114 = System.currentTimeMillis();     // Catch: Throwable -> L15
        Object r115 = this.e.d.get(r111);     // Catch: Throwable -> L15
        if (r115 != null) goto L38;
        Intrinsics.throwNpe();     // Catch: Throwable -> L15
    L38:
        r25.put(r111, TuplesKt.to(((Pair) r115).getFirst(), Long.valueOf(r114)));     // Catch: Throwable -> L15
        ((Handler) r113.getValue()).post(new com.bytedance.android.anniex.scene.core.i(this, 7, r111, r23));     // Catch: Throwable -> L15
        h r26 = this.f4878i;     // Catch: Throwable -> L15
        if (r26.f4871b.get() == false) goto L41;
    L43:
        boolean r27 = false;
    L44:
        if (r27 == true) goto L46;
        r112 = 0;
        com.bytedance.gkfs.d.c(r26.f4873h, "ChunkMetaDecoder", "fetch chunk info finished, seq decode cost:" + r26.e, 0, 12);     // Catch: Throwable -> L15
    L47:
        if (r27 == false) goto L52;
        this.f4875b = b(this.f4878i.b());     // Catch: Throwable -> L15
        goto L49
    L52:
        com.bytedance.gkfs.d.c(this.f4879j, this.f4874a, "read chunks finished, totalReadCount:" + this.g + ", parallelIOCost=" + this.e.f4900b + ", parallelContentCost=" + this.e.f4901c + ", parallelCacheHitCount:" + this.e.f4899a, r5, 8);     // Catch: Throwable -> L15
        this.f.set(true);     // Catch: Throwable -> L15
        goto L53
    L46:
        r112 = 0;
        goto L47
    L41:
        if (r26.d >= (r26.g - 1)) goto L43;
        r27 = true;
        goto L44
    }

    public final b b(f r5) {
        this.f4876c = ChunkFrom.f4835c;
        ConcurrentHashMap r10 = this.d;
        c r11 = r5.f4865a;
        cb.a r12 = (cb.a) r10.get(r11);
        if (r12 == null) goto L5;
        this.e.f4899a++;
        this.f4876c = ChunkFrom.f4834b;
    L6:
        com.bytedance.gkfs.d r13 = com.bytedance.gkfs.storage.d.f4921a;
        return new b(r5, r12, com.bytedance.gkfs.storage.d.a(r11));
    L5:
        r12 = null;
        goto L6
    }

    public final void c(String r10, IOException r11, int r12) {
        com.bytedance.gkfs.d r5 = this.f4879j;
        r5.getClass();
        String r13 = r5.a(r12, this.f4874a, r10 + ", cause by " + r11);
        CopyOnWriteArrayList r14 = GeckoLogger.f4756a;
        if (r14.size() != 0) goto L5;
        GeckoLogger.f4757b.a("gkfs-debug-tag", r13, r11);
    L9:
        com.bytedance.gkfs.d.b(6, r13, r11);
        boolean r15 = false;
        n r16 = new n(false, r11, GkFSError.f4846m);
        b r17 = this.f4875b;
        if (r17 == null) goto L13;
        r15 = true;
    L13:
        if (r15 == false) goto L18;
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("currentBuffer");
    L16:
        f r18 = r17.f4856c;
    L17:
        f r19 = r18;
        if (r15 == false) goto L25;
        b r20 = this.f4875b;
        if (r20 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("currentBuffer");
    L23:
        File r21 = r20.e.f4926c;
    L26:
        ((Handler) com.bytedance.gkfs.c.f4815b.getValue()).post(new com.bytedance.apm.e(3, this, r16, r19, r21));
        return;
    L25:
        r21 = new File("");
        goto L26
    L18:
        r18 = new f(c.f4857b, 0);
        goto L17
    L5:
        Iterator r22 = r14.iterator();
    L7:
        if (r22.hasNext() == false) goto L9;
        ((DefaultLogger) ((Logger) r22.next())).a("gkfs-debug-tag", r13, r11);
        goto L7
    }
}
