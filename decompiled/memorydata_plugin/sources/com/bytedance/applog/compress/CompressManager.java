package com.bytedance.applog.compress;

import android.content.Context;
import com.bytedance.applog.log.j;
import com.bytedance.applog.log.q;
import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CompressManager {
    public static final int TYPE_EMPTY = -1;
    public static final int TYPE_GZIP = 0;
    public static final int TYPE_ZSTD = 1;
    public static final int TYPE_ZSTD_DICT = 2;
    private static byte[] mDictionary = null;
    private static int sZstdLevel = 15;
    private final Context mContext;
    private final j mLogger;

    static {
    }

    public CompressManager(Context r3, j r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        r6 = q.a();
    L6:
        this.mLogger = r6;
    }

    @Deprecated
    public CompressManager(Context r2, String r3, c r4, j r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        this(r6, (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin"));
    }

    private int getEncodeType(int r1) {
        if (r1 == 2) goto L5;
    L8:
        return r1;
    L5:
        if (mDictionary != null) goto L8;
        return 1;
    }

    @Deprecated
    public static void setReportStatsEnabled(boolean r0) {
    }

    public static void setZstdDict(byte[] r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.length <= 0) goto L8;
        mDictionary = Arrays.copyOf(r1, r1.length);
        return;
    }

    public static void setZstdLevel(int r0) {
        sZstdLevel = r0;
    }

    public byte[] compress(byte[] r3, int r4, a r5) {
        int r0 = getEncodeType(r4);
        if (r0 != 0) goto L5;
        r3 = compressUsingGzip(r3, r5);
    L11:
        if (r3 == null) goto L15;
        if (r3.length == 0) goto L15;
        return r3;
    L15:
        return compressUsingGzip(r3, r5);
    L5:
        if (r0 != 1) goto L7;
    L9:
        r3 = compressUsingZstd(r3, r5, r4);
        goto L11
    L7:
        if (r0 == 2) goto L9;
        goto L9
    }

    public byte[] compressUsingGzip(byte[] r5, a r6) {
        if (r5 != null) goto L5;
        int r0 = 0;
    L6:
        r6.f1559a = r0;
        r6.c = 0;
        long r1 = System.currentTimeMillis();
        byte[] r7 = b.a(r5);
        long r2 = System.currentTimeMillis();
        r6.e = 0;
        r6.d = r2 - r1;
        r6.f1560b = r7.length;
        return r7;
    L5:
        r0 = r5.length;
        goto L6
    }

    public byte[] compressUsingZstd(byte[] r7, a r8, int r9) {
        r8.f1559a = r7.length;
        r8.c = r9;
        r8.f = 0;
        byte[] r1 = null;
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L11
        if (r9 == 2) goto L6;
    L8:
        byte[] r10 = ZstdCompress.compress(r7, sZstdLevel);     // Catch: Throwable -> L11
    L9:
        r1 = r10;
        r8.d = System.currentTimeMillis() - r2;     // Catch: Throwable -> L11
        r8.f1560b = r1.length;     // Catch: Throwable -> L11
        r8.e = 0;     // Catch: Throwable -> L11
        return r1;
    L6:
        if (mDictionary == null) goto L8;
        r10 = ZstdCompress.compress(r7, new ZstdDictCompress(mDictionary, sZstdLevel));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.mLogger.a(14, "compress with zstd failed", th, new Object[0]);
        r8.e = 1;
        return r1;
    }
}
