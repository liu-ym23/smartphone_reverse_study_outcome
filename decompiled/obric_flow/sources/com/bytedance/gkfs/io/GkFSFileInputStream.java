package com.bytedance.gkfs.io;

import ai.j0;
import android.os.Handler;
import androidx.annotation.Keep;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u0004\u0018\u00010\u001e8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00101R\u001b\u00105\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010 \u001a\u0004\b4\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00106¨\u00067"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSFileInputStream;", "Ljava/io/FileInputStream;", "Ljava/io/File;", "source", "<init>", "(Ljava/io/File;)V", "", "checkFinishIllegal", "()V", "report", "", "read", "()I", "", "b", "off", "len", "([BII)I", "", "n", "skip", "(J)J", "available", "close", "", "logTag", "Ljava/lang/String;", "Lcom/bytedance/gkfs/d;", "logger", "Lcom/bytedance/gkfs/d;", "Lcom/bytedance/gkfs/io/j;", "meta$delegate", "Lkotlin/Lazy;", "getMeta$geckox_noasanRelease", "()Lcom/bytedance/gkfs/io/j;", "meta", "Lcom/bytedance/gkfs/io/l;", "statistics", "Lcom/bytedance/gkfs/io/l;", "Lcom/bytedance/gkfs/io/i;", "chunkReader", "Lcom/bytedance/gkfs/io/i;", "totalReadCount", "J", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isFinished", "totalReadCost", "Ljava/lang/Long;", "tailReadCost", "totalDiskSize$delegate", "getTotalDiskSize", "totalDiskSize", "Ljava/io/File;", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class GkFSFileInputStream extends FileInputStream {
    private i chunkReader;
    private final AtomicBoolean isClosed;
    private final AtomicBoolean isFinished;
    private final String logTag;
    private final com.bytedance.gkfs.d logger;
    private final Lazy meta$delegate;
    private final File source;
    private l statistics;
    private volatile Long tailReadCost;
    private final Lazy totalDiskSize$delegate;
    private volatile Long totalReadCost;
    private long totalReadCount;

    public GkFSFileInputStream(File r5) {
        super(r5);
        this.source = r5;
        this.logTag = "GkFSFileInputStream@" + hashCode();
        this.logger = new com.bytedance.gkfs.d();
        this.meta$delegate = LazyKt.lazy(new GkFSFileInputStream$meta$2(this));
        this.isClosed = new AtomicBoolean(false);
        this.isFinished = new AtomicBoolean(false);
        this.totalDiskSize$delegate = LazyKt.lazy(new GkFSFileInputStream$totalDiskSize$2(this));
    }

    public static final /* synthetic */ i access$getChunkReader$p(GkFSFileInputStream r5) {
        return r5.chunkReader;
    }

    public static final /* synthetic */ String access$getLogTag$p(GkFSFileInputStream r5) {
        return r5.logTag;
    }

    public static final /* synthetic */ com.bytedance.gkfs.d access$getLogger$p(GkFSFileInputStream r5) {
        return r5.logger;
    }

    public static final /* synthetic */ File access$getSource$p(GkFSFileInputStream r5) {
        return r5.source;
    }

    public static final /* synthetic */ l access$getStatistics$p(GkFSFileInputStream r5) {
        return r5.statistics;
    }

    public static final /* synthetic */ long access$getTotalReadCount$p(GkFSFileInputStream r5) {
        return r5.totalReadCount;
    }

    public static final /* synthetic */ AtomicBoolean access$isClosed$p(GkFSFileInputStream r5) {
        return r5.isClosed;
    }

    public static final /* synthetic */ void access$report(GkFSFileInputStream r5) {
        r5.report();
    }

    public static final /* synthetic */ void access$setChunkReader$p(GkFSFileInputStream r5, i r10) {
        r5.chunkReader = r10;
    }

    public static final /* synthetic */ void access$setStatistics$p(GkFSFileInputStream r5, l r10) {
        r5.statistics = r10;
    }

    public static final /* synthetic */ void access$setTotalReadCount$p(GkFSFileInputStream r5, long r10) {
        r5.totalReadCount = r10;
    }

    /* JADX INFO: renamed from: access$skip$s-1820804163, reason: not valid java name */
    public static final /* synthetic */ long m87access$skip$s1820804163(GkFSFileInputStream r5, long r10) {
        return super.skip(r10);
    }

    private final void checkFinishIllegal() {
        int r5 = available();
        if (r5 != 0) goto L10;
        int r10 = super.available();
        if (r10 != 0) goto L8;
        return;
    L8:
        throw new IOException(com.lynx.jsbridge.a.d(r10, "Read finished but major file available is "));
    L10:
        throw new IOException(com.lynx.jsbridge.a.d(r5, "Read finished but available is "));
    }

    private final int getTotalDiskSize() {
        return ((Number) this.totalDiskSize$delegate.getValue()).intValue();
    }

    private final void report() {
        ArrayList r5 = com.bytedance.geckox.p.f4771a;
        if (StringsKt.k(this.source.getPath(), ".gkfsf") == false) goto L90;
        l r10 = this.statistics;
        if (r10 == null) goto L14;
        n r11 = r10.f4888c;
        if (r11 == null) goto L14;
        if (r11.f4895a != true) goto L14;
        if (this.isFinished.get() == true) goto L14;
        return;
    L14:
        l r12 = this.statistics;
        if (r12 == null) goto L89;
        LinkedHashMap r13 = new LinkedHashMap();
        j r14 = getMeta$geckox_noasanRelease();
        if (r14 == null) goto L24;
        List r15 = r14.f4882c;
        if (r15 == null) goto L24;
        Iterator r16 = r15.iterator();
    L22:
        if (r16.hasNext() == false) goto L24;
        d r17 = (d) r16.next();
        r13.put(r17.f4859a, r17.f4861c);
    L24:
        n r18 = r12.f4888c;
        long r19 = r12.d;
        j r20 = getMeta$geckox_noasanRelease();
        if (r20 == null) goto L29;
        k r21 = r20.f4881b;
        if (r21 == null) goto L29;
        long r110 = r21.f4885c;
    L30:
        e r111 = new e(MapsKt.emptyMap(), r13);
        i r22 = this.chunkReader;
        if (r22 == null) goto L33;
        long r112 = r22.e.e;
    L34:
        Long r23 = this.tailReadCost;
        if (r23 == null) goto L37;
        long r113 = r23.longValue();
    L38:
        j r24 = getMeta$geckox_noasanRelease();
        if (r24 == null) goto L41;
        long r25 = r24.f4880a.length() - r24.f4881b.f4885c;
    L42:
        Long r26 = this.totalReadCost;
        if (r26 == null) goto L45;
        long r27 = r26.longValue();
    L46:
        this.statistics = new l(r18, r19, r110, r111, r112, r113, r25, r27);
        File r28 = this.source;
        j r29 = getMeta$geckox_noasanRelease();
        if (r29 == null) goto L51;
        k r30 = r29.f4881b;
        if (r30 == null) goto L51;
    L52:
        j r31 = getMeta$geckox_noasanRelease();
        if (r31 == null) goto L57;
        List r32 = r31.f4882c;
        if (r32 == null) goto L57;
    L58:
        l r33 = this.statistics;
        if (r33 != null) goto L85;
        Intrinsics.throwNpe();
    L85:
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L64
        JSONObject r35 = new JSONObject();     // Catch: Throwable -> L64
        r35.put("source_file", r28.getAbsolutePath());     // Catch: Throwable -> L64
        r35.put("file_gkfs_version", r30.f4883a);     // Catch: Throwable -> L64
        r35.put("sdk_gkfs_version", 1);     // Catch: Throwable -> L64
        r35.put("stats", r33.f4888c.f4897c.f4849a);     // Catch: Throwable -> L64
        Throwable r36 = r33.f4888c.f4896b;     // Catch: Throwable -> L64
        if (r36 == null) goto L66;
        r35.put("error_msg", r36.getMessage() + ", cause:" + r36.getCause());     // Catch: Throwable -> L64
    L71:
        Object r37 = Result.m124constructorimpl(r35);     // Catch: Throwable -> L64
    L75:
        if (Result.m131isSuccessimpl(r37) == false) goto L77;
        com.lynx.tasm.utils.j.g("geckosdk_gkfs_read_stats", (JSONObject) r37);
    L77:
        Throwable r38 = Result.m127exceptionOrNullimpl(r37);
        if (r38 == null) goto L81;
        r38.printStackTrace();
    L81:
        if (Result.m130isFailureimpl(r37) == false) goto L83;
        r37 = null;
    L83:
        JSONObject r39 = (JSONObject) r37;
        return;
    L66:
        r35.put("header_time_cost", r33.d);     // Catch: Throwable -> L64
        r35.put("chunk_time_cost", r33.g);     // Catch: Throwable -> L64
        r35.put("tail_time_cost", r33.f4889h);     // Catch: Throwable -> L64
        r35.put("total_time_cost", r33.f4891j);     // Catch: Throwable -> L64
        long r40 = r33.e;     // Catch: Throwable -> L64
        r35.put("header_size", r40);     // Catch: Throwable -> L64
        Iterator r41 = r32.iterator();     // Catch: Throwable -> L64
        int r42 = 0;
    L68:
        if (r41.hasNext() == false) goto L70;
        r42 = r42 + ((d) r41.next()).f4861c.f4928i;     // Catch: Throwable -> L64
        goto L68
    L70:
        r35.put("chunk_size", r42);     // Catch: Throwable -> L64
        r35.put("tail_size", r33.f4890i);     // Catch: Throwable -> L64
        r35.put("total_size", (r28.length() + ((long) r42)) - r40);     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r37 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L57:
        r32 = CollectionsKt.emptyList();
    L51:
        r30 = k.d;
        goto L52
    L45:
        r27 = 0;
        goto L46
    L41:
        r25 = 0;
        goto L42
    L37:
        r113 = 0;
        goto L38
    L33:
        r112 = 0;
    L29:
        r110 = 0;
        goto L30
    L89:
        return;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int available() {
        if (getMeta$geckox_noasanRelease() != null) goto L7;
        return super.available();
    L7:
        return (int) (((long) getTotalDiskSize()) - this.totalReadCount);
    }

    @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed.compareAndSet(false, true) == false) goto L6;
        super.close();
        a6.a r5 = new a6.a(this, 18);
        ((Handler) com.bytedance.gkfs.c.f4815b.getValue()).post(r5);
        return;
    }

    public final j getMeta$geckox_noasanRelease() {
        return (j) this.meta$delegate.getValue();
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int read() {
        byte[] r5 = new byte[1];
        int r10 = read(r5, 0, 1);
        Integer r11 = Integer.valueOf(r10);
        if (r10 != (-1)) goto L6;
        r11 = null;
    L6:
        if (r11 != null) goto L8;
        return -1;
    L8:
        return r5[0] & UByte.MAX_VALUE;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public long skip(long r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int read(byte[] r35, int r36, int r37) {
        if (getMeta$geckox_noasanRelease() == null) goto L5;
        long r5 = System.currentTimeMillis();
        if (this.totalReadCost != null) goto L10;
        this.totalReadCost = 0L;
        com.bytedance.gkfs.d.c(this.logger, this.logTag, "start to read content from " + this.source, 0, 4);
    L10:
        if (this.isClosed.get() == true) goto L82;
        if (this.isFinished.get() == false) goto L14;
        return -1;
    L14:
        if (r35 == null) goto L80;
        if (r36 < 0) goto L78;
        if (r37 < 0) goto L78;
        if (r37 > (r35.length - r36)) goto L78;
        if (r37 != 0) goto L21;
        return 0;
    L21:
        int r12 = Math.min(r35.length - r36, r37);
        if (r12 != 0) goto L85;
        com.bytedance.gkfs.d r10 = this.logger;
        String r11 = this.logTag;
        StringBuilder r13 = new StringBuilder("No need to read, arraySize:");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r13, r35.length, ", off:", r36, ", len:");
        r13.append(r37);
        com.bytedance.gkfs.d.c(r10, r11, r13.toString(), 0, 12);
        return 0;
    L85:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L28
        i r15 = this.chunkReader;     // Catch: Throwable -> L28
        if (r15 != null) goto L30;
        Intrinsics.throwNpe();     // Catch: Throwable -> L28
    L30:
        Object r16 = Result.m124constructorimpl(Integer.valueOf(r15.a(r35, r36, r37)));     // Catch: Throwable -> L28
    L33:
        Throwable r17 = Result.m127exceptionOrNullimpl(r16);
        if (r17 == null) goto L36;
        String r18 = androidx.room.jarjarred.org.antlr.runtime.a.x(r17, new StringBuilder("error occur when read chunk, cause:"));
        com.bytedance.gkfs.d.d(this.logger, this.logTag, r18, r17, true, 4);
        this.statistics = new l(new n(false, new IOException(r18), GkFSError.f4846m), 0, 0, null, 0, 0, 0, 254);
    L36:
        ResultKt.throwOnFailure(r16);
        int r19 = ((Number) r16).intValue();
        if (r19 <= 0) goto L39;
        this.totalReadCount += (long) r19;
        int r20 = r19;
    L40:
        if (r20 != r12) goto L47;
        Long r21 = this.totalReadCost;
        if (r21 != null) goto L44;
        Intrinsics.throwNpe();
    L44:
        this.totalReadCost = Long.valueOf((System.currentTimeMillis() - r5) + r21.longValue());
        return r19;
    L47:
        if (this.tailReadCost != null) goto L49;
        com.bytedance.gkfs.d.c(this.logger, this.logTag, j0.o(new StringBuilder("chunk read finished, totalReadCount="), this.totalReadCount, ", start to read tail"), 0, 12);
        this.tailReadCost = 0L;
    L49:
        long r22 = System.currentTimeMillis();
        Object r23 = Result.m124constructorimpl(Integer.valueOf(super.read(r35, r36 + r20, r37 - r20)));     // Catch: Throwable -> L52
    L54:
        Throwable r110 = Result.m127exceptionOrNullimpl(r23);
        if (r110 == null) goto L57;
        String r24 = "error occur when read tail from " + this.source + ", cause:" + r110.getMessage();
        com.bytedance.gkfs.d.d(this.logger, this.logTag, r24, r110, true, 4);
        this.statistics = new l(new n(false, new IOException(r24), GkFSError.f4847n), 0, 0, null, 0, 0, 0, 254);
    L57:
        ResultKt.throwOnFailure(r23);
        int r25 = ((Number) r23).intValue();
        Long r26 = this.tailReadCost;
        if (r26 != null) goto L60;
        Intrinsics.throwNpe();
    L60:
        this.tailReadCost = Long.valueOf((System.currentTimeMillis() - r22) + r26.longValue());
        if (r25 <= 0) goto L65;
        int r27 = r20 + r25;
        this.totalReadCount += (long) r25;
        return r27;
    L65:
        if (r25 != (-1)) goto L76;
        this.isFinished.set(true);
        Long r28 = this.totalReadCost;
        if (r28 != null) goto L69;
        Intrinsics.throwNpe();
    L69:
        this.totalReadCost = Long.valueOf((System.currentTimeMillis() - r5) + r28.longValue());
        com.bytedance.gkfs.d r29 = this.logger;
        String r30 = this.logTag;
        StringBuilder r31 = new StringBuilder("All finish, time cost:{total:");
        r31.append(this.totalReadCost);
        r31.append(", header:");
        l r32 = this.statistics;
        if (r32 == null) goto L72;
        Long r33 = Long.valueOf(r32.d);
    L73:
        r31.append(r33);
        r31.append(", tail:");
        r31.append(this.tailReadCost);
        r31.append("}, totalReadCount=");
        r31.append(this.totalReadCount);
        com.bytedance.gkfs.d.c(r29, r30, r31.toString(), 0, 4);
        checkFinishIllegal();
        return -1;
    L72:
        r33 = null;
        goto L73
    L76:
        throw new IOException("Underlying input stream returned zero bytes when read tail");
    L52:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r23 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L54
    L39:
        r20 = 0;
    L28:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L78:
        throw new IndexOutOfBoundsException();
    L80:
        throw new NullPointerException("ByteArray is NULL!");
    L82:
        throw new IOException("Stream closed!");
    L5:
        return super.read(r35, r36, r37);
    }
}
