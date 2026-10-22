package com.bytedance.applog.compress;

import android.content.Context;
import c4.g;
import c4.m;
import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import java.util.Arrays;
import t2.b;
import w3.a;

/* JADX INFO: loaded from: classes.dex */
public class CompressManager {
    public static final int TYPE_EMPTY = -1;
    public static final int TYPE_GZIP = 0;
    public static final int TYPE_ZSTD = 1;
    public static final int TYPE_ZSTD_DICT = 2;
    private static byte[] mDictionary = null;
    private static int sZstdLevel = 15;
    private final Context mContext;
    private final g mLogger;

    public CompressManager(Context r8, g r10) {
        this.mContext = r8;
        if (r10 != null) goto L6;
        r10 = m.u();
    L6:
        this.mLogger = r10;
    }

    private int getEncodeType(int r8) {
        if (r8 == 2) goto L5;
    L8:
        return r8;
    L5:
        if (mDictionary != null) goto L8;
        return 1;
    }

    @Deprecated
    public static void setReportStatsEnabled(boolean r8) {
    }

    public static void setZstdDict(byte[] r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.length <= 0) goto L8;
        mDictionary = Arrays.copyOf(r8, r8.length);
        return;
    }

    public static void setZstdLevel(int r8) {
        sZstdLevel = r8;
    }

    public byte[] compress(byte[] r8, int r10, a r11) {
        int r12 = getEncodeType(r10);
        if (r12 != 0) goto L5;
        r8 = compressUsingGzip(r8, r11);
    L11:
        if (r8 == null) goto L15;
        if (r8.length == 0) goto L15;
        return r8;
    L15:
        return compressUsingGzip(r8, r11);
    L5:
        if (r12 != 1) goto L7;
    L9:
        r8 = compressUsingZstd(r8, r11, r10);
        goto L11
    L7:
        if (r12 == 2) goto L9;
        goto L9
    }

    public byte[] compressUsingGzip(byte[] r8, a r10) {
        if (r8 != null) goto L5;
        int r11 = 0;
    L6:
        r10.f12972a = r11;
        r10.f12974c = 0;
        long r12 = System.currentTimeMillis();
        byte[] r13 = b.r(r8);
        long r14 = System.currentTimeMillis();
        r10.f12976e = 0;
        r10.f12975d = r14 - r12;
        r10.f12973b = r13.length;
        return r13;
    L5:
        r11 = r8.length;
        goto L6
    }

    public byte[] compressUsingZstd(byte[] r8, a r10, int r11) {
        r10.f12972a = r8.length;
        r10.f12974c = r11;
        byte[] r12 = null;
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L11
        if (r11 == 2) goto L6;
    L8:
        byte[] r14 = ZstdCompress.compress(r8, sZstdLevel);     // Catch: Throwable -> L11
    L9:
        r12 = r14;
        r10.f12975d = System.currentTimeMillis() - r13;     // Catch: Throwable -> L11
        r10.f12973b = r12.length;     // Catch: Throwable -> L11
        r10.f12976e = 0;     // Catch: Throwable -> L11
        return r12;
    L6:
        if (mDictionary == null) goto L8;
        r14 = ZstdCompress.compress(r8, new ZstdDictCompress(mDictionary, sZstdLevel));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.mLogger.k(th, 14, "compress with zstd failed", new Object[0]);
        r10.f12976e = 1;
        return r12;
    }

    @Deprecated
    public CompressManager(Context r8, String r10, w3.b r11, g r12) {
        this(r8, r12);
    }
}
