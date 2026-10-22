package com.bytedance.crash.dumper;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.crash.Global;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class Storage {
    private static final int G_1 = 1073741824;
    private static final int M_100 = 104857600;
    public static final int UNIT = 52428800;

    public Storage() {
    }

    public static long formatSize(long r2) {
        return r2 / 52428800;
    }

    private static long getFreeSize(File r5) {
        StatFs r0 = new StatFs(r5.getPath());     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return r0.getFreeBytes();
    L8:
        return ((long) r0.getAvailableBlocks()) * r0.getBlockSize();
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
        String r0 = Environment.getExternalStorageState();     // Catch: Throwable -> L4
    L5:
        long r1 = 0;
        long r2 = 0;
        r1 = 0;
        if (TextUtils.equals(r0, "mounted") == true) goto L24;
        long r6 = 0;
    L18:
        long r4 = r2;
        r1 = r6;
    L20:
        return new Pair(Long.valueOf(r1), Long.valueOf(r4));
    L24:
        StatFs r3 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L16
        r4 = 18;
        if (Build.VERSION.SDK_INT < 18) goto L13;
        long r5 = r3.getAvailableBytes();     // Catch: Throwable -> L16
        long r7 = r3.getBlockSizeLong();     // Catch: Throwable -> L21
        long r8 = r3.getBlockCountLong();     // Catch: Throwable -> L21
        r4 = r5;
    L11:
        r6 = r7 * r8;
        r1 = r4;
        r2 = r1;
    L13:
        long r9 = r3.getBlockSize() * ((long) r3.getAvailableBlocks());
        r7 = r3.getBlockSize();     // Catch: Throwable -> L21
        r8 = r3.getBlockCount();     // Catch: Throwable -> L21
        r4 = r9;
    L16:
        r4 = 0;
    L4:
        r0 = null;
        goto L5
    }

    public static String getStorageRange(long r2) {
        if (r2 > 52428800) goto L6;
        return "0 - 50M";
    L6:
        if (r2 > 104857600) goto L9;
        return "50M - 100M";
    L9:
        if (r2 > ProcInfo.GB) goto L11;
        return "100M - 1G";
    L11:
        return "1G - ";
    }

    private static long getTotalSize(File r5) {
        StatFs r0 = new StatFs(r5.getPath());     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return r0.getTotalBytes();
    L8:
        return ((long) r0.getBlockCount()) * r0.getBlockSize();
    L9:
        return 0;
    }

    public static long storageFreeSize() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return 0;
    L7:
        return getFreeSize(r0.getFilesDir());
    }

    public static long storageTotalSize() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return 0;
    L7:
        return getTotalSize(r0.getFilesDir());
    }
}
