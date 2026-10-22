package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.apm6.util.constant.ReportConsts;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, SDKMonitor> f2019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, List<String>> f2020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, List<String>> f2021c;

    static {
        f2019a = new ConcurrentHashMap();
        f2020b = new ConcurrentHashMap();
        f2021c = new ConcurrentHashMap();
    }

    public g() {
    }

    public static List<String> a(List<String> r10) {
        LinkedList r11 = new LinkedList();
        Iterator<String> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        r11.add((ReportConsts.HTTPS + new URL(r12.next()).getHost()) + "/monitor/collect/");     // Catch: MalformedURLException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r11;
    }

    public static SDKMonitor b(@NonNull String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L19;
        if (f2019a.get(r10) != null) goto L17;
        monitor-enter(g.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (f2019a.get(r10) != null) goto L11;
        SDKMonitor r11 = new SDKMonitor(r10);     // Catch: Throwable -> L13
        f2019a.put(r10, r11);     // Catch: Throwable -> L13
    L11:
        monitor-exit(g.class);     // Catch: Throwable -> L13
    L17:
        return f2019a.get(r10);
    L19:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
    }

    public static synchronized void c(@NonNull Context r10, @NonNull String r11, @NonNull JSONObject r12, SDKMonitor.o r13) {
        monitor-enter(g.class);
        if (r10 != null) goto L29;
        monitor-exit(g.class);
        return;
    L29:
    L26:
        th = move-exception;
        throw th;
    L8:
        if (TextUtils.isEmpty(r11) == true) goto L25;
        if (r12 == null) goto L23;
        if (f2019a.get(r11) != null) goto L13;
    L16:
        SDKMonitor r14 = f2019a.get(r11);     // Catch: Throwable -> L26
        if (r14 != null) goto L19;
        r14 = new SDKMonitor(r11);     // Catch: Throwable -> L26
        f2019a.put(r11, r14);     // Catch: Throwable -> L26
    L19:
        r14.resetConfigUrls(f2021c.remove(r11));     // Catch: Throwable -> L26
        r14.resetReportUrls(f2020b.remove(r11));     // Catch: Throwable -> L26
        r14.init(r10, r12, r13);     // Catch: Throwable -> L26
        monitor-exit(g.class);
        return;
    L13:
        if (f2019a.get(r11).isHasInit() == false) goto L16;
        monitor-exit(g.class);
        return;
    L23:
        throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");     // Catch: Throwable -> L26
    L25:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");     // Catch: Throwable -> L26
    }

    public static synchronized void d(@NonNull String r10, @NonNull List<String> r11) {
        monitor-enter(g.class);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
    L22:
        monitor-exit(g.class);
        return;
    L7:
        if (l3.c.a(r11) == true) goto L22;
        j3.a.f(ReportConsts.HTTPS + new URL(r11.get(0)).getHost());     // Catch: Exception -> L27 Throwable -> L24
    L11:
        LinkedList r12 = new LinkedList();     // Catch: Throwable -> L24
        Iterator<String> r13 = r11.iterator();     // Catch: Throwable -> L24
    L13:
        if (r13.hasNext() == false) goto L19;
        r12.add((ReportConsts.HTTPS + new URL(r13.next()).getHost()) + "/monitor/appmonitor/v4/settings");     // Catch: MalformedURLException -> L17 Throwable -> L24
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
        goto L13
    L19:
        f2021c.put(r10, r12);     // Catch: Throwable -> L24
        monitor-exit(g.class);
    }

    public static synchronized void e(@NonNull String r10, @NonNull List<String> r11) {
        monitor-enter(g.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
    L14:
        monitor-exit(g.class);
        return;
    L7:
        if (l3.c.a(r11) == true) goto L14;
        f2020b.put(r10, a(r11));     // Catch: Throwable -> L16
        j3.a.f(ReportConsts.HTTPS + new URL(r11.get(0)).getHost());     // Catch: Exception -> L19 Throwable -> L16
    L12:
        monitor-exit(g.class);
    }
}
