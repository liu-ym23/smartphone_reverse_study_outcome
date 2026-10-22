package com.bytedance.apm6.cpu.exception;

import android.text.TextUtils;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.proc.CommonProcUtil;
import com.bytedance.common.utility.io.a;
import com.bytedance.monitor.collector.k;
import com.bytedance.monitor.util.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ThreadCpuExceptionUtils {
    public ThreadCpuExceptionUtils() {
    }

    public static void filterThreads(int r8, List<ThreadExceptionItem> r9, double r10, Map<String, Double> r12) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        filterThreads(r8, r3, new LinkedList(), r10, r7);
    }

    public static void filterThreads(int r17, List<ThreadExceptionItem> r18, List<ThreadExceptionItem> r19, double r20, Map<String, Double> r22) {
        String r3 = " ";
        String r4 = "com.obric.memorydata.plugin";
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        String r8 = "/proc/" + r17 + "/task/";
        Logger.i(Constants.TAG, "size: " + r5.size());
        long r10 = CommonProcUtil.getAppCPUTime();
        Iterator r12 = r5.iterator();
        BufferedReader r13 = null;
    L4:
        if (r12.hasNext() == false) goto L53;
        ThreadExceptionItem r0 = (ThreadExceptionItem) ZeusTransformUtils.preCheckCast(r12.next(), ThreadExceptionItem.class, r4);
        if (r0 != null) goto L59;
        a.a(r13);
        r3 = r3;
        r4 = r4;
        List r110 = r5;
        String r111 = r8;
        Iterator r112 = r12;
    L46:
        r12 = r112;
        r5 = r110;
        r8 = r111;
        r3 = r3;
        r4 = r4;
        goto L4
    L59:
        r112 = r12;
        r110 = r5;
        r111 = r8;
        BufferedReader r14 = new BufferedReader(new InputStreamReader(new FileInputStream(new StringBuilder().append(r8).append(r0.getThreadId()).append("/stat").toString())), 1000);     // Catch: Throwable -> L39
        String r9 = r14.readLine();     // Catch: Throwable -> L36
        String[] r11 = r9.substring(r9.lastIndexOf(41) + 4).split(r3);     // Catch: Throwable -> L36
        long r15 = Long.parseLong(r11[10]) + Long.parseLong(r11[11]);     // Catch: Throwable -> L36
        BufferedReader r23 = r14;
        float r16 = (r15 - r0.getThreadCpuTime()) / (r10 - r0.getProcessCpuTime());     // Catch: Throwable -> L34
        Logger.i(Constants.TAG, r0.getThreadName() + " judge: " + r15 + r3 + r0.getThreadCpuTime() + r3 + r16 + r3 + r20);     // Catch: Throwable -> L34
        if (r7 != null) goto L20;
    L26:
        r3 = r3;
        r4 = r4;
        double r21 = r16;
        if (r21 < r20) goto L29;
        r0.setCpuUsage(r21);     // Catch: Throwable -> L32
        int r24 = Integer.parseInt(r11[18]);     // Catch: Throwable -> L32
    L25:
        r0.setPriority(r24);     // Catch: Throwable -> L32
    L30:
        Logger.i(Constants.TAG, "after item: " + r0);     // Catch: Throwable -> L32
        a.a(r23);
        r13 = r23;
    L29:
        r6.add(r0);     // Catch: Throwable -> L32
        goto L30
    L20:
        if (r7.containsKey(r0.getThreadName()) == false) goto L26;
        r3 = r3;
        r4 = r4;
        double r25 = r16;
        if (r25 < ((Double) ZeusTransformUtils.preCheckCast(r7.get(r0.getThreadName()), Double.class, r4)).doubleValue()) goto L29;
        r0.setCpuUsage(r25);     // Catch: Throwable -> L32
        r24 = Integer.parseInt(r11[18]);     // Catch: Throwable -> L32
    L32:
        th = th;
    L38:
        r13 = r23;
    L65:
        Logger.i(Constants.TAG, "error: " + th.getLocalizedMessage());     // Catch: Throwable -> L50
    L45:
        a.a(r13);
    L50:
        th = move-exception;
        a.a(r13);
        throw th;
    L34:
        th = th;
        r3 = r3;
        r4 = r4;
    L36:
        th = th;
        r3 = r3;
        r4 = r4;
        r23 = r14;
    L39:
        r3 = r3;
        r4 = r4;
    L71:
        r6.add(r0);     // Catch: Throwable -> L47
    L47:
        th = th;
    L42:
        r111 = r8;
    L41:
        r110 = r5;
    L43:
        r3 = r3;
        r4 = r4;
        r110 = r5;
        r111 = r8;
        r112 = r12;
        goto L71
    L53:
        List r1 = r5;
        r1.removeAll(r6);
        Logger.i(Constants.TAG, "after size: " + r1.size());
    }

    public static void getThreadInfo(int r14, List<ThreadExceptionItem> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        File[] r17 = new File("/proc/" + r14 + "/task/").listFiles();
        long r0 = CommonProcUtil.getAppCPUTime();
        int r2 = r17.length;
        BufferedReader r4 = null;
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L21;
        BufferedReader r7 = new BufferedReader(new InputStreamReader(new FileInputStream(r17[r5].getPath() + "/stat")), 1000);     // Catch: Throwable -> L22
        String r6 = r7.readLine();     // Catch: Throwable -> L18
        int r8 = r6.lastIndexOf(41);     // Catch: Throwable -> L18
        String r9 = r6.substring(0, r8);     // Catch: Throwable -> L18
        String r10 = r6.substring(r8 + 4);     // Catch: Throwable -> L18
        int r11 = r9.indexOf(40);     // Catch: Throwable -> L18
        int r12 = Integer.valueOf(r9.substring(0, r11 - 1)).intValue();     // Catch: Throwable -> L18
        String r13 = r9.substring(r11 + 1);     // Catch: Throwable -> L18
        String[] r18 = r10.split(" ");     // Catch: Throwable -> L18
        long r19 = Long.parseLong(r18[10]) + Long.parseLong(r18[11]);     // Catch: Throwable -> L18
        if (r12 != 0) goto L9;
    L17:
        d.a(r7);
        r4 = r7;
    L20:
        r5 = r5 + 1;
        goto L3
    L9:
        if (r13.isEmpty() == true) goto L17;
        if (r19 == 0) goto L17;
        if (Thread.currentThread().getName().contains(r13) == true) goto L17;
        ThreadExceptionItem r20 = new ThreadExceptionItem();     // Catch: Throwable -> L18
        r20.setThreadName(r13);     // Catch: Throwable -> L18
        r20.setThreadId(r12);     // Catch: Throwable -> L18
        r20.setThreadCpuTime(r19);     // Catch: Throwable -> L18
        r20.setProcessCpuTime(r0);     // Catch: Throwable -> L18
        r20.setPriority(Integer.parseInt(r18[14]));     // Catch: Throwable -> L18
        r16.add(r20);     // Catch: Throwable -> L18
    L18:
        r4 = r7;
    L19:
        d.a(r4);
        goto L20
    }

    public static void getThreadInfo(int r9, Map<Integer, ThreadExceptionItem> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        File[] r0 = new File("/proc/" + r9 + "/task/").listFiles();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L15;
        int r3 = Integer.parseInt(r0[r2].getName());     // Catch: NumberFormatException -> L16
        ThreadStatInfo r4 = k.a().a(r9, r3);     // Catch: NumberFormatException -> L16
        if (r3 == 0) goto L14;
        if (r4 == null) goto L14;
        if (TextUtils.isEmpty(r4.threadName) == true) goto L14;
        if (r4.threadCpuTime == 0) goto L14;
        ThreadExceptionItem r5 = new ThreadExceptionItem();     // Catch: NumberFormatException -> L16
        r5.setThreadId(r3);     // Catch: NumberFormatException -> L16
        r5.setThreadName(r4.threadName);     // Catch: NumberFormatException -> L16
        r5.setThreadCpuTime(r4.threadCpuTime);     // Catch: NumberFormatException -> L16
        r11.put(Integer.valueOf(r3), r5);     // Catch: NumberFormatException -> L16
    L14:
        r2 = r2 + 1;
        goto L3
    }
}
