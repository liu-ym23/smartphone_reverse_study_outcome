package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, SDKMonitor> f2649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, List<String>> f2650b;
    private static ConcurrentHashMap<String, List<String>> c;

    static {
        f2649a = new ConcurrentHashMap();
        f2650b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public g() {
    }

    public static SDKMonitor a(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L19;
        if (f2649a.get(r3) != null) goto L17;
        monitor-enter(g.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (f2649a.get(r3) != null) goto L11;
        SDKMonitor r1 = new SDKMonitor(r3);     // Catch: Throwable -> L13
        f2649a.put(r3, r1);     // Catch: Throwable -> L13
    L11:
        monitor-exit(g.class);     // Catch: Throwable -> L13
    L17:
        return (SDKMonitor) ZeusTransformUtils.preCheckCast(f2649a.get(r3), SDKMonitor.class, "com.obric.memorydata.plugin");
    L19:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
    }

    public static List<String> a(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        LinkedList r0 = new LinkedList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        r0.add((ReportConsts.HTTPS + new URL((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin")).getHost()) + "/monitor/collect/");     // Catch: MalformedURLException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r0;
    }

    public static synchronized void a(Context r5, String r6, JSONObject r7, SDKMonitor.c r8) {
        monitor-enter(g.class);
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        SDKMonitor.c r10 = (SDKMonitor.c) ZeusTransformUtils.wrapperContextForParams(r8, SDKMonitor.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r9 != null) goto L9;
        monitor-exit(g.class);
        return;
    L9:
        if (TextUtils.isEmpty(r6) == true) goto L26;
        if (r7 == null) goto L24;
        if (f2649a.get(r6) != null) goto L14;
    L17:
        SDKMonitor r1 = (SDKMonitor) ZeusTransformUtils.preCheckCast(f2649a.get(r6), SDKMonitor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r1 != null) goto L20;
        r1 = new SDKMonitor(r6);     // Catch: Throwable -> L27
        f2649a.put(r6, r1);     // Catch: Throwable -> L27
    L20:
        r1.resetConfigUrls((List) ZeusTransformUtils.preCheckCast(c.remove(r6), List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        r1.resetReportUrls((List) ZeusTransformUtils.preCheckCast(f2650b.remove(r6), List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        r1.init(r9, r7, r10);     // Catch: Throwable -> L27
        monitor-exit(g.class);
        return;
    L14:
        if (((SDKMonitor) ZeusTransformUtils.preCheckCast(f2649a.get(r6), SDKMonitor.class, "com.obric.memorydata.plugin")).isHasInit() == false) goto L17;
        monitor-exit(g.class);
        return;
    L24:
        throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");     // Catch: Throwable -> L27
    L26:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(String r5, List<String> r6) {
        monitor-enter(g.class);
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r5) == false) goto L7;
    L22:
        monitor-exit(g.class);
        return;
    L7:
        if (com.bytedance.framwork.core.sdklib.b.c.a(r7) == true) goto L22;
        com.bytedance.framwork.core.sdklib.apm6.safety.a.a(ReportConsts.HTTPS + new URL((String) ZeusTransformUtils.preCheckCast(r7.get(0), String.class, "com.obric.memorydata.plugin")).getHost());     // Catch: Exception -> L27 Throwable -> L24
    L11:
        LinkedList r1 = new LinkedList();     // Catch: Throwable -> L24
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L24
    L13:
        if (r8.hasNext() == false) goto L19;
        r1.add((ReportConsts.HTTPS + new URL((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin")).getHost()) + "/monitor/appmonitor/v4/settings");     // Catch: MalformedURLException -> L17 Throwable -> L24
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
        goto L13
    L19:
        c.put(r5, r1);     // Catch: Throwable -> L24
        monitor-exit(g.class);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(String r3, List<String> r4) {
        monitor-enter(g.class);
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r3) == false) goto L7;
    L14:
        monitor-exit(g.class);
        return;
    L7:
        if (com.bytedance.framwork.core.sdklib.b.c.a(r5) == true) goto L14;
        f2650b.put(r3, a(r5));     // Catch: Throwable -> L16
        com.bytedance.framwork.core.sdklib.apm6.safety.a.a(ReportConsts.HTTPS + new URL((String) ZeusTransformUtils.preCheckCast(r5.get(0), String.class, "com.obric.memorydata.plugin")).getHost());     // Catch: Exception -> L19 Throwable -> L16
    L12:
        monitor-exit(g.class);
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
