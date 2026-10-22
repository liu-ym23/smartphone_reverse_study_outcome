package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final String a;

    public static final class a {
    }

    static {
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "meetingId");
        this.a = r2;
    }

    public static long c(File r6) {
        File[] r7 = r6.listFiles();
        long r0 = 0;
        if (r7 == null) goto L14;
        int r2 = r7.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L14;
        File r4 = r7[r3];
        if (r4.isFile() == false) goto L10;
        long r5 = r4.length();
    L12:
        r0 = r0 + r5;
    L13:
        r3 = r3 + 1;
        goto L5
    L10:
        if (r4.isDirectory() == false) goto L13;
        Intrinsics.checkNotNull(r4);
        r5 = c(r4);
    L14:
        return r0;
    }

    public static boolean d(File r5) {
        if (r5.isDirectory() == false) goto L12;
        File[] r0 = r5.listFiles();
        if (r0 == null) goto L12;
        Iterator r1 = ArrayIteratorKt.iterator(r0);
    L8:
        if (r1.hasNext() == false) goto L12;
        File r2 = (File) r1.next();
        Intrinsics.checkNotNull(r2);
        if (d(r2) == true) goto L8;
        lvb.a.e("MmAudioCacheCleanupUtil", "deleteRecursive: Failed to delete: " + r2.getAbsolutePath());
    L12:
        boolean r3 = r5.delete();
        if (r3 == true) goto L15;
        lvb.a.b("MmAudioCacheCleanupUtil", "deleteRecursive: Could not delete: " + r5.getAbsolutePath());
    L15:
        return r3;
    }

    public static final void a(b r11, VFSFile r12, long r13) {
        r11.getClass();
        lvb.a.e("MmAudioCacheCleanupUtil", "--- Cleaning by age (older than " + r13 + " days) ---");
        long r14 = TimeUnit.DAYS.toMillis(r13);
        long r2 = System.currentTimeMillis();
        File[] r15 = r12.listFiles();
        int r0 = 0;
        if (r15 == null) goto L16;
        int r4 = r15.length;
        int r5 = 0;
    L5:
        if (r0 >= r4) goto L15;
        File r6 = r15[r0];
        if ((r2 - r6.lastModified()) <= r14) goto L14;
        if (Intrinsics.areEqual(r11.a, r6.getName()) == true) goto L14;
        lvb.a.e("MmAudioCacheCleanupUtil", "Deleting old file: " + r6.getAbsolutePath() + " (Last modified: " + new Date(r6.lastModified()) + ')');
        Intrinsics.checkNotNull(r6);
        if (d(r6) == false) goto L13;
        r5 = r5 + 1;
        goto L14
    L13:
        lvb.a.b("MmAudioCacheCleanupUtil", "Error: Failed to delete file: " + r6.getAbsolutePath());
    L14:
        r0 = r0 + 1;
        goto L5
    L15:
        r0 = r5;
    L16:
        lvb.a.e("MmAudioCacheCleanupUtil", "Clean by age finished: Deleted " + r0 + " files.");
    }

    public static final void b(b r16, VFSFile r17, long r18) {
        StringBuilder r1 = new StringBuilder("--- Cleaning by size (threshold: ");
        long r2 = 1048576;
        long r4 = r18 / 1048576;
        r1.append(r4);
        r1.append(" MB) ---");
        lvb.a.e("MmAudioCacheCleanupUtil", r1.toString());
        long r7 = c(r17);
        lvb.a.e("MmAudioCacheCleanupUtil", "Current directory size: " + (r7 / 1048576) + " MB (" + r7 + " bytes). Threshold: " + r4 + " MB.");
        if (r7 > r18) goto L5;
        lvb.a.e("MmAudioCacheCleanupUtil", "Directory size is within threshold, no cleanup by size needed.");
        return;
    L5:
        lvb.a.e("MmAudioCacheCleanupUtil", "Directory size exceeds threshold, attempting to delete oldest files...");
        File[] r3 = r17.listFiles();
        if (r3 == null) goto L31;
        List r5 = ArraysKt.sortedWith(r3, new c());
        if (r5 == null) goto L31;
        Iterator r6 = r5.iterator();
        int r8 = 0;
        long r9 = 0;
    L12:
        if (r6.hasNext() == false) goto L28;
        File r11 = (File) r6.next();
        lvb.a.e("MmAudioCacheCleanupUtil", "meetingId: " + r16.a + ", fileToDelete.name:" + r11.getName());
        if (Intrinsics.areEqual(r16.a, r11.getName()) == false) goto L17;
        Iterator r19 = r6;
    L27:
        r6 = r19;
        r2 = 1048576;
        goto L12
    L17:
        if (r7 <= r18) goto L28;
        if (r11.isFile() == false) goto L22;
        long r12 = r11.length();
    L23:
        StringBuilder r14 = new StringBuilder("Deleting file to reduce size: ");
        r14.append(r11.getAbsolutePath());
        r14.append(" (Size: ");
        r19 = r6;
        r14.append(r12 / r2);
        r14.append(" MB, Created: ");
        r14.append(new Date(r11.lastModified()));
        r14.append(')');
        lvb.a.e("MmAudioCacheCleanupUtil", r14.toString());
        Intrinsics.checkNotNull(r11);
        if (d(r11) == false) goto L26;
        r7 = r7 - r12;
        r9 = r9 + r12;
        r8 = r8 + 1;
        lvb.a.e("MmAudioCacheCleanupUtil", "Deleted. New directory size: " + (r7 / 1048576) + " MB.");
        goto L27
    L26:
        lvb.a.b("MmAudioCacheCleanupUtil", "Error: Failed to delete file: " + r11.getAbsolutePath());
        goto L27
    L22:
        Intrinsics.checkNotNull(r11);
        r12 = c(r11);
    L28:
        lvb.a.e("MmAudioCacheCleanupUtil", "Clean by size finished: Deleted " + r8 + " files. Total size reduced: " + (r9 / 1048576) + " MB.");
        if (r7 <= r18) goto L39;
        lvb.a.e("MmAudioCacheCleanupUtil", "Warning: Directory size (" + (r7 / 1048576) + " MB) still exceeds threshold after cleanup. Some files might be undeletable or too large.");
        return;
    L39:
        return;
    L31:
        lvb.a.b("MmAudioCacheCleanupUtil", "Error: Could not list files in directory for size cleanup: " + r17.getAbsolutePath());
    }
}
