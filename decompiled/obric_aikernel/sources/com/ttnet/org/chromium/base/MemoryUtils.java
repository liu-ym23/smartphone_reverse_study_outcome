package com.ttnet.org.chromium.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryUtils {
    private static String TAG = "MemoryUtils";
    private static boolean sInitialized = false;
    private static String sMemoryInfoPath = "/proc/meminfo";
    private static final Object sMemoryLock = null;
    private static String sTotalMemoryGB = "unknown";

    static {
        sMemoryLock = new Object();
    }

    public MemoryUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [long] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    private static void fetchTotalMemory() {
        Pattern r10 = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        ?? r11 = 0;
        long r12 = 0;
        r12 = 0;
        long r13 = 0;
        r11 = 0;
        r13 = 0;
        r13 = 0;
        r11 = 0;
        ?? r14 = 0;
        BufferedReader r15 = null;
        r15 = null;
        r14 = 0;
        FileReader r16 = new FileReader(sMemoryInfoPath);     // Catch: Throwable -> L36 Exception -> L38
        BufferedReader r17 = new BufferedReader(r16);     // Catch: Exception -> L34 Throwable -> L54
    L88:
        String r18 = r17.readLine();     // Catch: Throwable -> L30 Exception -> L32
        Object r19 = r18;
        if (r18 == null) goto L82;
        Matcher r20 = r10.matcher(r18);     // Catch: Throwable -> L30 Exception -> L32
        if (r20.find() == false) goto L88;
        long r110 = Long.parseLong(r20.group(1));     // Catch: Throwable -> L30 Exception -> L32
    L12:
        if (r110 <= 1024) goto L91;
        r12 = r110;
        r19 = r20;
        goto L82
    L91:
        String r21 = TAG;     // Catch: Throwable -> L15 Exception -> L17
        String r22 = "Invalid " + sMemoryInfoPath + " total size in kB: " + r110;     // Catch: Throwable -> L15 Exception -> L17
        android.util.Log.w(r21, r22);     // Catch: Throwable -> L15 Exception -> L17
        r19 = r22;
    L17:
        e = e;
        r15 = r17;
        r13 = r110;
    L40:
        android.util.Log.w(TAG, "Cannot get total physical size from " + sMemoryInfoPath, e);     // Catch: Throwable -> L54
        if (r15 != null) goto L73;
    L43:
        if (r16 == null) goto L45;
        r16.close();     // Catch: Exception -> L69
    L45:
        Object r23 = sMemoryLock;
        monitor-enter(r23);
        String r24 = String.valueOf((int) Math.ceil((r13 * 1.0d) / 1048576.0d));     // Catch: Throwable -> L51
        sTotalMemoryGB = r24;     // Catch: Throwable -> L51
        r11 = r24;
        r14 = r15;
        monitor-exit(r23);     // Catch: Throwable -> L51
    L79:
        return;
    L51:
        th = move-exception;
        throw th;
    L73:
        r15.close();     // Catch: Exception -> L69
    L15:
        th = th;
        r14 = r17;
        r11 = r110;
    L55:
        if (r14 != 0) goto L71;
    L57:
        if (r16 == null) goto L59;
        r16.close();     // Catch: Exception -> L68
    L59:
        Object r25 = sMemoryLock;
        monitor-enter(r25);
        sTotalMemoryGB = String.valueOf((int) Math.ceil((((double) r11) * 1.0d) / 1048576.0d));     // Catch: Throwable -> L65
        monitor-exit(r25);     // Catch: Throwable -> L65
        throw th;
    L65:
        th = move-exception;
        throw th;
    L71:
        r14.close();     // Catch: Exception -> L68
    L82:
        r17.close();     // Catch: Exception -> L70
        r16.close();     // Catch: Exception -> L70
    L21:
        Object r26 = sMemoryLock;
        monitor-enter(r26);
        String r27 = String.valueOf((int) Math.ceil((r12 * 1.0d) / 1048576.0d));     // Catch: Throwable -> L27
        sTotalMemoryGB = r27;     // Catch: Throwable -> L27
        monitor-exit(r26);     // Catch: Throwable -> L27
        r11 = r27;
        r14 = r19;
    L27:
        th = move-exception;
        throw th;
    L32:
        e = e;
        r15 = r17;
    L30:
        th = th;
        r14 = r17;
    L34:
        e = e;
        goto L40
    L54:
        th = th;
    L38:
        e = e;
        r16 = null;
    L36:
        th = th;
        r16 = null;
        goto L55
    }

    public static String getTotalMemoryGB() {
        Object r10 = sMemoryLock;
        monitor-enter(r10);
        String r11 = sTotalMemoryGB;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean initialize() {
        if (sInitialized == false) goto L5;
        return true;
    L5:
        fetchTotalMemory();
        sInitialized = true;
        return true;
    }
}
