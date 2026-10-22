package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.NetUtils;
import com.bytedance.apm6.util.Tools;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements k3.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AtomicInteger f1920d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicLong f1921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentLinkedQueue<c> f1922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f1923c;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final e f1924a = null;

        static {
            f1924a = new e(null);
        }

        static /* synthetic */ e a() {
            return f1924a;
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        byte[] f1925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f1927c;

        c(byte[] r10, int r11, long r12) {
            this.f1925a = r10;
            this.f1926b = r11;
            this.f1927c = r12;
        }
    }

    static {
        f1920d = new AtomicInteger(0);
    }

    private e() {
        this.f1921a = new AtomicLong(0);
        this.f1922b = new ConcurrentLinkedQueue();
    }

    /* synthetic */ e(a r10) {
        this();
    }

    private void a(JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("_debug_self");
        if (r11 == null) goto L8;
    L5:
        r11.put("debug_sender_number", f1920d.getAndIncrement());     // Catch: Exception -> L7
        return;
    L10:
        return;
    L8:
        r11 = new JSONObject();     // Catch: Exception -> L7
        r10.put("_debug_self", r11);     // Catch: Exception -> L7
        goto L5
    }

    private void b(Map<String, List<com.bytedance.framwork.core.sdklib.apm6.c>> r10) {
        if (j.f() == false) goto L14;
        j3.c.a("APM-SDK", "sendLog: input sendList merged into " + r10.size() + " group(s)");
        Iterator<Map.Entry<String, List<com.bytedance.framwork.core.sdklib.apm6.c>>> r11 = r10.entrySet().iterator();
        int r12 = 0;
    L6:
        if (r11.hasNext() == false) goto L21;
        List<com.bytedance.framwork.core.sdklib.apm6.c> r13 = r11.next().getValue();
        if (r13 == null) goto L6;
        j3.c.a("APM-SDK", "----------------");
        JSONObject r14 = h3.a.e().c(r13.get(0).a(), r13.get(0).c());
        StringBuilder r15 = new StringBuilder();
        r15.append("group ");
        int r16 = r12 + 1;
        r15.append(r12);
        r15.append(" aid ");
        r15.append(r13.get(0).a());
        r15.append(" headerId ");
        r15.append(r13.get(0).c());
        r15.append(" header:");
        r15.append(r14);
        j3.c.a("APM-SDK", r15.toString());
        int r17 = 0;
    L11:
        if (r17 >= r13.size()) goto L13;
        j3.c.a("APM-SDK", "  log[" + r17 + "]=" + r13.get(r17).toString());
        r17 = r17 + 1;
        goto L11
    L13:
        j3.c.a("APM-SDK", "----------------");
        r12 = r16;
        goto L6
    L21:
        return;
    }

    private void c(List<com.bytedance.framwork.core.sdklib.apm6.b> r10) {
        Iterator<com.bytedance.framwork.core.sdklib.apm6.b> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        com.bytedance.framwork.core.sdklib.apm6.b r12 = r11.next();
    L10:
        j3.c.f("APM-SDK", "delete LogFile's source File failed. logFile=" + r12.d());
        goto L4
    L7:
        if (r12.d() == null) goto L4;
        FileUtils.deleteFile(r12.d());     // Catch: Exception -> L10
        goto L4
    }

    public static e d() {
        return b.a();
    }

    private Map<String, List<com.bytedance.framwork.core.sdklib.apm6.c>> f(List<com.bytedance.framwork.core.sdklib.apm6.b> r10) {
        HashMap r11 = new HashMap();
        Iterator<com.bytedance.framwork.core.sdklib.apm6.b> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        Iterator<com.bytedance.framwork.core.sdklib.apm6.c> r13 = r12.next().c().iterator();
    L7:
        if (r13.hasNext() == false) goto L4;
        com.bytedance.framwork.core.sdklib.apm6.c r14 = r13.next();
        String r15 = r14.c() + "_" + r14.a();
        List r16 = (List) r11.get(r15);
        if (r16 != null) goto L11;
        r16 = new ArrayList();
        r11.put(r15, r16);
    L11:
        r16.add(r14);
        goto L7
    L12:
        return r11;
    }

    private void g() {
        if (NetUtils.isNetworkTrulyAvailable(j.c()) == true) goto L5;
        return;
    L5:
        if (LogReportController.getInstance().isReportLogEnable() == true) goto L7;
        return;
    L7:
        if (j.f() == false) goto L9;
        j3.c.a("APM-SDK", "trigger send.");
    L9:
        j();
        if (j.g() == false) goto L15;
        h();
        return;
    }

    private void h() {
        File r10 = f.c().e();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.exists() == true) goto L8;
        return;
    L8:
        if (h.b().e(FileUtils.readFileToByteArray(r10)) == true) goto L10;
        f.c r11 = f.c().d(r10);
        int r12 = 0;
        if (r11 == null) goto L16;
        r12 = r11.c() + 1;
    L16:
        long r13 = LogReportController.getInstance().getRetryInterval(r12) + System.currentTimeMillis();
        f.c().g(r10, r12, r13);
        if (j.f() == false) goto L22;
        j3.c.a("APM-SDK", "sendfile error retry count:" + r10.getName() + "  " + r12 + " nextRetryTime:" + r13);
        return;
    L22:
        return;
    L10:
        if (j.f() == false) goto L12;
        j3.c.a("APM-SDK", "sendFile: success");
    L12:
        f.c().a(r10);
    }

    private void j() {
        if (this.f1922b.isEmpty() == false) goto L5;
        return;
    L5:
        Object[] r10 = this.f1922b.toArray();
        c r11 = null;
        int r12 = r10.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L17;
        c r14 = (c) r10[r13];
        if (r14.f1926b <= LogReportController.getInstance().getMaxRetryCount()) goto L11;
        this.f1922b.remove(r14);
    L15:
        r13 = r13 + 1;
        goto L6
    L11:
        if (r14.f1926b <= 0) goto L16;
        if ((System.currentTimeMillis() - r14.f1927c) <= 0) goto L15;
    L16:
        r11 = r14;
    L17:
        if (r11 == null) goto L19;
    L21:
        if (r11 != null) goto L24;
        return;
    L24:
        if (j.f() == false) goto L27;
        j3.c.a("APM-SDK", "sendMemory");
    L27:
        if (h.b().e(r11.f1925a) == false) goto L29;
        this.f1922b.remove(r11);
        return;
    L29:
        r11.f1926b++;
        r11.f1927c = LogReportController.getInstance().getRetryInterval(r11.f1926b) + System.currentTimeMillis();
        return;
    L19:
        if (this.f1922b.size() <= 0) goto L21;
        r11 = this.f1922b.peek();
        goto L21
    }

    private byte[] k(List<com.bytedance.framwork.core.sdklib.apm6.b> r10, boolean r11) {
        Map<String, List<com.bytedance.framwork.core.sdklib.apm6.c>> r12 = f(r10);     // Catch: Throwable -> L8
        b(r12);     // Catch: Throwable -> L8
        JSONArray r13 = l(r12, r11);     // Catch: Throwable -> L8
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L8
        r14.put(Constants.KEY_LIST, r13);     // Catch: Throwable -> L8
        if (j.f() == false) goto L6;
        j3.c.f("APM-SDK", "request : " + r14.toString());     // Catch: Throwable -> L8
    L6:
        return Tools.safeGetBytes(r14.toString());
    L8:
        th = move-exception;
        j3.c.c("APM-SDK", "LogSender serialize failed.", th);
        return null;
    }

    private JSONArray l(Map<String, List<com.bytedance.framwork.core.sdklib.apm6.c>> r14, boolean r15) {
        JSONArray r10 = new JSONArray();
        Iterator<Map.Entry<String, List<com.bytedance.framwork.core.sdklib.apm6.c>>> r16 = r14.entrySet().iterator();
    L4:
        if (r16.hasNext() == false) goto L33;
        Map.Entry<String, List<com.bytedance.framwork.core.sdklib.apm6.c>> r11 = r16.next();
        String r12 = r11.getKey();
        List<com.bytedance.framwork.core.sdklib.apm6.c> r13 = r11.getValue();
        if (ListUtils.isEmpty(r13) == true) goto L4;
        JSONArray r17 = new JSONArray();
        int r18 = 0;
    L10:
        if (r18 >= r13.size()) goto L24;
        com.bytedance.framwork.core.sdklib.apm6.c r19 = r13.get(r18);
        JSONObject r20 = new JSONObject(new String(r19.b()));     // Catch: Exception -> L21
        if (com.bytedance.framwork.core.sdklib.apm6.downgrade.a.a().d(r20, (int) r19.a()) == false) goto L15;
        if (r15 == false) goto L20;
        a(r20);
    L20:
        r17.put(r20);
    L23:
        r18 = r18 + 1;
        goto L10
    L15:
        if (j.f() == false) goto L23;
        j3.c.a("APM-SDK", "failed to report: event is downgraded: " + r20.toString());     // Catch: Exception -> L21
    L21:
        e = move-exception;
        j3.c.c("APM-SDK", "toJSON", e);
        goto L23
    L24:
        JSONObject r21 = h3.a.e().c(r13.get(0).a(), r13.get(0).c());
        if (r21 == null) goto L27;
        JSONObject r22 = new JSONObject();     // Catch: Exception -> L31
        r22.put("data", r17);     // Catch: Exception -> L31
        r22.put("header", r21);     // Catch: Exception -> L31
        r10.put(r22);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        j3.c.c("APM-SDK", "toJSON", e);
        goto L4
    L27:
        if (j.f() == false) goto L4;
        j3.c.f("APM-SDK", "HeaderInfo null for key " + r12);
        goto L4
    L33:
        return r10;
    }

    public void e() {
        k3.a.e().d(this);
    }

    public void i(List<com.bytedance.framwork.core.sdklib.apm6.b> r12) {
    L36:
        th = move-exception;
        j3.c.c("APM-SDK", "sendLog", th);
        return;
    L4:
        if (LogReportController.getInstance().isStopCollect() == true) goto L6;
        int r10 = 1;
        byte[] r11 = k(r12, true);     // Catch: Throwable -> L36
        if (r11 != null) goto L14;
        c(r12);     // Catch: Throwable -> L36
        return;
    L14:
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L36
        boolean r14 = false;
        if ((r13 - this.f1921a.get()) < 5000) goto L25;
        this.f1921a.set(r13);     // Catch: Throwable -> L36
        if (LogReportController.getInstance().isReportLogEnable() == true) goto L19;
    L21:
        r10 = 0;
    L23:
        if (j.f() == false) goto L26;
        j3.c.a("APM-SDK", "sendDirect:isReportLogEnable " + LogReportController.getInstance().isReportLogEnable() + " :sendResult " + r14);     // Catch: Throwable -> L36
    L26:
        if (r14 == true) goto L34;
        long r15 = LogReportController.getInstance().getRetryInterval(r10);     // Catch: Throwable -> L36
        long r16 = System.currentTimeMillis() + r15;     // Catch: Throwable -> L36
        boolean r17 = f.c().f(r11, r10, r16);     // Catch: Throwable -> L36
        if (j.f() == false) goto L30;
        j3.c.a("APM-SDK", "saveFile:Result:" + r17 + " " + r10 + " " + r15);     // Catch: Throwable -> L36
    L30:
        if (r17 == true) goto L34;
        this.f1922b.add(new c(r11, r10, r16));     // Catch: Throwable -> L36
        if (this.f1922b.size() <= 10) goto L34;
        this.f1922b.poll();     // Catch: Throwable -> L36
    L34:
        c(r12);     // Catch: Throwable -> L36
        return;
    L19:
        if (NetUtils.isNetworkTrulyAvailable(j.c()) == false) goto L21;
        r14 = h.b().e(r11);     // Catch: Throwable -> L36
        goto L23
    L25:
        r10 = 0;
        goto L26
    L6:
        if (j.f() == false) goto L8;
        j3.c.b("APM-SDK", "stop collect log");     // Catch: Throwable -> L36
    L8:
        c(r12);     // Catch: Throwable -> L36
    }

    @Override // k3.b
    public void onTimeEvent(long r10) {
        if ((r10 - this.f1923c) < 90000) goto L12;
        g();     // Catch: Throwable -> L6
    L8:
        this.f1923c = System.currentTimeMillis();
        return;
    L6:
        th = move-exception;
        j3.c.c("APM-SDK", "onTimeEvent", th);
        goto L8
    }
}
