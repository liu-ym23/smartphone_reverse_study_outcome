package com.bytedance.apm6.cpu.exception;

import android.text.TextUtils;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.proc.CommonProcUtil;
import com.bytedance.monitor.collector.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import s1.a;
import x3.d;

/* JADX INFO: loaded from: classes.dex */
public class ThreadCpuExceptionUtils {
    public ThreadCpuExceptionUtils() {
    }

    public static void filterThreads(int r10, List<ThreadExceptionItem> r11, double r12, Map<String, Double> r13) {
        filterThreads(r10, r11, new LinkedList(), r12, r13);
    }

    public static void filterThreads(int r19, List<ThreadExceptionItem> r20, List<ThreadExceptionItem> r21, double r22, Map<String, Double> r24) {
        String r10 = "/proc/" + r19 + "/task/";
        Logger.i(Constants.TAG, "size: " + r20.size());
        long r11 = CommonProcUtil.getAppCPUTime();
        Iterator<ThreadExceptionItem> r12 = r20.iterator();
        BufferedReader r13 = null;
    L4:
        if (r12.hasNext() == false) goto L48;
        ThreadExceptionItem r14 = r12.next();
        if (r14 != null) goto L55;
        a.a(r13);
        String r110 = r10;
        Iterator<ThreadExceptionItem> r17 = r12;
    L41:
        r10 = r110;
        r12 = r17;
        goto L4
    L55:
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L37
        r15.append(r10);     // Catch: Throwable -> L37
        r110 = r10;
        r15.append(r14.getThreadId());     // Catch: Throwable -> L50
        r15.append("/stat");     // Catch: Throwable -> L50
        BufferedReader r16 = new BufferedReader(new InputStreamReader(new FileInputStream(r15.toString())), 1000);     // Catch: Throwable -> L50
        String r18 = r16.readLine();     // Catch: Throwable -> L33
        String[] r23 = r18.substring(r18.lastIndexOf(41) + 4).split(" ");     // Catch: Throwable -> L33
        long r111 = Long.parseLong(r23[10]) + Long.parseLong(r23[11]);     // Catch: Throwable -> L33
        r17 = r12;
        BufferedReader r112 = r16;
        float r113 = (r111 - r14.getThreadCpuTime()) / (r11 - r14.getProcessCpuTime());
        Logger.i(Constants.TAG, r14.getThreadName() + " judge: " + r111 + " " + r14.getThreadCpuTime() + " " + r113 + " " + r22);     // Catch: Throwable -> L29
        if (r24 != null) goto L18;
    L24:
        double r114 = r113;
        if (r114 >= r22) goto L26;
    L23:
        r21.add(r14);     // Catch: Throwable -> L29
    L27:
        Logger.i(Constants.TAG, "after item: " + r14);     // Catch: Throwable -> L29
        a.a(r112);
        r13 = r112;
        goto L41
    L26:
        r14.setCpuUsage(r114);     // Catch: Throwable -> L29
        int r25 = Integer.parseInt(r23[18]);     // Catch: Throwable -> L29
    L22:
        r14.setPriority(r25);     // Catch: Throwable -> L29
        goto L27
    L18:
        if (r24.containsKey(r14.getThreadName()) == false) goto L24;
        double r115 = r113;
        if (r115 < r24.get(r14.getThreadName()).doubleValue()) goto L23;
        r14.setCpuUsage(r115);     // Catch: Throwable -> L29
        r25 = Integer.parseInt(r23[18]);     // Catch: Throwable -> L29
    L29:
        th = th;
    L36:
        r13 = r112;
    L51:
        Logger.i(Constants.TAG, "error: " + th.getLocalizedMessage());     // Catch: Throwable -> L45
    L40:
        a.a(r13);
    L45:
        th = move-exception;
        a.a(r13);
        throw th;
    L31:
        th = th;
    L35:
        r112 = r16;
    L33:
        th = th;
        r17 = r12;
    L38:
        r17 = r12;
        r21.add(r14);     // Catch: Throwable -> L42
    L42:
        th = th;
    L37:
        r110 = r10;
        goto L38
    L48:
        r20.removeAll(r21);
        Logger.i(Constants.TAG, "after size: " + r20.size());
    }

    public static void getThreadInfo(int r14, List<ThreadExceptionItem> r15) {
        File[] r16 = new File("/proc/" + r14 + "/task/").listFiles();
        long r10 = CommonProcUtil.getAppCPUTime();
        int r11 = r16.length;
        BufferedReader r12 = null;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L21;
        BufferedReader r17 = new BufferedReader(new InputStreamReader(new FileInputStream(r16[r13].getPath() + "/stat")), 1000);     // Catch: Throwable -> L22
        String r18 = r17.readLine();     // Catch: Throwable -> L18
        int r19 = r18.lastIndexOf(41);     // Catch: Throwable -> L18
        String r20 = r18.substring(0, r19);     // Catch: Throwable -> L18
        String r21 = r18.substring(r19 + 4);     // Catch: Throwable -> L18
        int r22 = r20.indexOf(40);     // Catch: Throwable -> L18
        int r23 = Integer.valueOf(r20.substring(0, r22 - 1)).intValue();     // Catch: Throwable -> L18
        String r24 = r20.substring(r22 + 1);     // Catch: Throwable -> L18
        String[] r25 = r21.split(" ");     // Catch: Throwable -> L18
        long r110 = Long.parseLong(r25[10]) + Long.parseLong(r25[11]);     // Catch: Throwable -> L18
        if (r23 != 0) goto L9;
    L17:
        d.b(r17);
        r12 = r17;
    L20:
        r13 = r13 + 1;
        goto L3
    L9:
        if (r24.isEmpty() == true) goto L17;
        if (r110 == 0) goto L17;
        if (Thread.currentThread().getName().contains(r24) == true) goto L17;
        ThreadExceptionItem r26 = new ThreadExceptionItem();     // Catch: Throwable -> L18
        r26.setThreadName(r24);     // Catch: Throwable -> L18
        r26.setThreadId(r23);     // Catch: Throwable -> L18
        r26.setThreadCpuTime(r110);     // Catch: Throwable -> L18
        r26.setProcessCpuTime(r10);     // Catch: Throwable -> L18
        r26.setPriority(Integer.parseInt(r25[14]));     // Catch: Throwable -> L18
        r15.add(r26);     // Catch: Throwable -> L18
    L18:
        r12 = r17;
    L19:
        d.b(r12);
        goto L20
    }

    public static void getThreadInfo(int r10, Map<Integer, ThreadExceptionItem> r11) {
        File[] r12 = new File("/proc/" + r10 + "/task/").listFiles();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L15;
        int r15 = Integer.parseInt(r12[r14].getName());     // Catch: NumberFormatException -> L16
        ThreadStatInfo r16 = k.n().j(r10, r15);     // Catch: NumberFormatException -> L16
        if (r15 == 0) goto L14;
        if (r16 == null) goto L14;
        if (TextUtils.isEmpty(r16.threadName) == true) goto L14;
        if (r16.threadCpuTime == 0) goto L14;
        ThreadExceptionItem r17 = new ThreadExceptionItem();     // Catch: NumberFormatException -> L16
        r17.setThreadId(r15);     // Catch: NumberFormatException -> L16
        r17.setThreadName(r16.threadName);     // Catch: NumberFormatException -> L16
        r17.setThreadCpuTime(r16.threadCpuTime);     // Catch: NumberFormatException -> L16
        r11.put(Integer.valueOf(r15), r17);     // Catch: NumberFormatException -> L16
    L14:
        r14 = r14 + 1;
        goto L3
    }
}
