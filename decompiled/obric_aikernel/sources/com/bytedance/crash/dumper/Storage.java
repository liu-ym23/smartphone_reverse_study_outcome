package com.bytedance.crash.dumper;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.crash.Global;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class Storage {
    private static final int G_1 = 1073741824;
    private static final int M_100 = 104857600;
    public static final int UNIT = 52428800;

    public Storage() {
    }

    public static long formatSize(long r10) {
        return r10 / 52428800;
    }

    private static long getFreeSize(File r10) {
        StatFs r11 = new StatFs(r10.getPath());     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return r11.getFreeBytes();
    L8:
        return ((long) r11.getAvailableBlocks()) * r11.getBlockSize();
    L9:
        return 0;
    }

    public static String getInnerFreeSizeRange() {
        return getStorageRange(storageFreeSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static Pair<Long, Long> getSdcardStorage() {
        String r10 = Environment.getExternalStorageState();     // Catch: Throwable -> L4
    L5:
        long r11 = 0;
        long r12 = 0;
        r11 = 0;
        if (TextUtils.equals(r10, "mounted") == true) goto L24;
        long r13 = 0;
    L18:
        long r14 = r12;
        r11 = r13;
    L20:
        return new Pair(Long.valueOf(r11), Long.valueOf(r14));
    L24:
        StatFs r15 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L16
        r14 = 18;
        if (Build.VERSION.SDK_INT < 18) goto L13;
        long r16 = r15.getAvailableBytes();     // Catch: Throwable -> L16
        long r17 = r15.getBlockSizeLong();     // Catch: Throwable -> L21
        long r18 = r15.getBlockCountLong();     // Catch: Throwable -> L21
        r14 = r16;
    L11:
        r13 = r17 * r18;
        r11 = r14;
        r12 = r11;
    L13:
        long r19 = r15.getBlockSize() * ((long) r15.getAvailableBlocks());
        r17 = r15.getBlockSize();     // Catch: Throwable -> L21
        r18 = r15.getBlockCount();     // Catch: Throwable -> L21
        r14 = r19;
    L16:
        r14 = 0;
    L4:
        r10 = null;
        goto L5
    }

    public static String getStorageRange(long r10) {
        if (r10 > 52428800) goto L6;
        return "0 - 50M";
    L6:
        if (r10 > 104857600) goto L9;
        return "50M - 100M";
    L9:
        if (r10 > ProcInfo.GB) goto L11;
        return "100M - 1G";
    L11:
        return "1G - ";
    }

    private static long getTotalSize(File r10) {
        StatFs r11 = new StatFs(r10.getPath());     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return r11.getTotalBytes();
    L8:
        return ((long) r11.getBlockCount()) * r11.getBlockSize();
    L9:
        return 0;
    }

    public static long storageFreeSize() {
        Context r10 = Global.getContext();
        if (r10 != null) goto L7;
        return 0;
    L7:
        return getFreeSize(r10.getFilesDir());
    }

    public static long storageTotalSize() {
        Context r10 = Global.getContext();
        if (r10 != null) goto L7;
        return 0;
    L7:
        return getTotalSize(r10.getFilesDir());
    }
}
