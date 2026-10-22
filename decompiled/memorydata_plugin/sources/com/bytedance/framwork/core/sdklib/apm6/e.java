package com.bytedance.framwork.core.sdklib.apm6;

import android.content.Context;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.NetUtils;
import com.bytedance.apm6.util.Tools;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
public class e implements com.bytedance.framwork.core.sdklib.a.b {
    private static AtomicInteger c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicLong f2589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentLinkedQueue<b> f2590b;
    private long d;

    /* JADX INFO: renamed from: com.bytedance.framwork.core.sdklib.apm6.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final e f2591a = null;

        static {
            f2591a = new e(null);
        }

        static /* synthetic */ e a() {
            return f2591a;
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        byte[] f2592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2593b;
        long c;

        b(byte[] r1, int r2, long r3) {
            this.f2592a = r1;
            this.f2593b = r2;
            this.c = r3;
        }
    }

    static {
        c = new AtomicInteger(0);
    }

    private e() {
        this.f2589a = new AtomicLong(0);
        this.f2590b = new ConcurrentLinkedQueue();
    }

    /* synthetic */ e(AnonymousClass1 r1) {
        this();
    }

    public static e a() {
        return a.a();
    }

    private void a(Map<String, List<c>> r12) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        if (j.d() == false) goto L12;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "sendLog: input sendList merged into " + r11.size() + " group(s)");
        Iterator r13 = r11.keySet().iterator();
        int r3 = 0;
    L6:
        if (r13.hasNext() == false) goto L15;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r11.get((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "----------------");
        int r8 = r3 + 1;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "group " + r3 + " aid " + ((c) ZeusTransformUtils.preCheckCast(r4.get(0), c.class, "com.obric.memorydata.plugin")).c() + " headerId " + ((c) ZeusTransformUtils.preCheckCast(r4.get(0), c.class, "com.obric.memorydata.plugin")).b() + " header:" + com.bytedance.framwork.core.sdklib.apm6.a.a.a().a(((c) ZeusTransformUtils.preCheckCast(r4.get(0), c.class, "com.obric.memorydata.plugin")).c(), ((c) ZeusTransformUtils.preCheckCast(r4.get(0), c.class, "com.obric.memorydata.plugin")).b()));
        int r5 = 0;
    L9:
        if (r5 >= r4.size()) goto L11;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "  log[" + r5 + "]=" + ((c) ZeusTransformUtils.preCheckCast(r4.get(r5), c.class, "com.obric.memorydata.plugin")).toString());
        r5 = r5 + 1;
        goto L9
    L11:
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "----------------");
        r3 = r8;
        goto L6
    L15:
        return;
    }

    private void a(JSONObject r2) {
        JSONObject r0 = r2.optJSONObject("_debug_self");
        if (r0 == null) goto L8;
    L5:
        r0.put("debug_sender_number", c.getAndIncrement());     // Catch: Exception -> L7
        return;
    L10:
        return;
    L8:
        r0 = new JSONObject();     // Catch: Exception -> L7
        r2.put("_debug_self", r0);     // Catch: Exception -> L7
        goto L5
    }

    private JSONArray b(Map<String, List<c>> r17) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.memorydata.plugin");
        JSONArray r3 = new JSONArray();
        Iterator r4 = r2.keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L26;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(r2.get(r5), List.class, "com.obric.memorydata.plugin");
        if (ListUtils.isEmpty(r6) == true) goto L4;
        JSONArray r7 = new JSONArray();
        int r9 = 0;
    L10:
        if (r9 >= r6.size()) goto L17;
        JSONObject r12 = new JSONObject(new String(((c) ZeusTransformUtils.preCheckCast(r6.get(r9), c.class, "com.obric.memorydata.plugin")).a()));     // Catch: Exception -> L14
        a(r12);
        r7.put(r12);
    L16:
        r9 = r9 + 1;
    L14:
        e = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "toJSON", e);
        goto L16
    L17:
        JSONObject r0 = com.bytedance.framwork.core.sdklib.apm6.a.a.a().a(((c) ZeusTransformUtils.preCheckCast(r6.get(0), c.class, "com.obric.memorydata.plugin")).c(), ((c) ZeusTransformUtils.preCheckCast(r6.get(0), c.class, "com.obric.memorydata.plugin")).b());
        if (r0 == null) goto L20;
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L24
        r8.put("data", r7);     // Catch: Exception -> L24
        r8.put("header", r0);     // Catch: Exception -> L24
        r3.put(r8);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "toJSON", e);
        goto L4
    L20:
        if (j.d() == false) goto L4;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.b("APM-SDK", "HeaderInfo null for key " + r5);
        goto L4
    L26:
        return r3;
    }

    private byte[] b(List<com.bytedance.framwork.core.sdklib.apm6.b> r4) {
        Map<String, List<c>> r5 = c((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        a(r5);     // Catch: Throwable -> L8
        JSONArray r3 = b(r5);     // Catch: Throwable -> L8
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L8
        r6.put(Constants.KEY_LIST, r3);     // Catch: Throwable -> L8
        if (j.d() == false) goto L6;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.b("APM-SDK", "request : " + r6.toString());     // Catch: Throwable -> L8
    L6:
        return Tools.safeGetBytes(r6.toString());
    L8:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "LogSender serialize failed.", th);
        return null;
    }

    private Map<String, List<c>> c(List<com.bytedance.framwork.core.sdklib.apm6.b> r9) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        HashMap r10 = new HashMap();
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        Iterator<c> r1 = ((com.bytedance.framwork.core.sdklib.apm6.b) ZeusTransformUtils.preCheckCast(r11.next(), com.bytedance.framwork.core.sdklib.apm6.b.class, "com.obric.memorydata.plugin")).b().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r1.next(), c.class, "com.obric.memorydata.plugin");
        String r3 = r2.b() + "_" + r2.c();
        List r4 = (List) ZeusTransformUtils.preCheckCast(r10.get(r3), List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L11;
        r4 = new ArrayList();
        r10.put(r3, r4);
    L11:
        r4.add(r2);
        goto L7
    L12:
        return r10;
    }

    private void c() {
        if (NetUtils.isNetworkTrulyAvailable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L5;
        return;
    L5:
        if (LogReportController.getInstance().isReportLogEnable() == true) goto L7;
        return;
    L7:
        if (j.d() == false) goto L9;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "trigger send.");
    L9:
        d();
        if (j.c() == false) goto L15;
        e();
        return;
    }

    private void d() {
        if (this.f2590b.isEmpty() == false) goto L5;
        return;
    L5:
        Object[] r0 = this.f2590b.toArray();
        b r1 = null;
        int r2 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L18;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r0[r3], b.class, "com.obric.memorydata.plugin");
        if (r5.f2593b <= LogReportController.getInstance().getMaxRetryCount()) goto L12;
        this.f2590b.remove(r5);
    L16:
        r3 = r3 + 1;
        goto L7
    L12:
        if (r5.f2593b <= 0) goto L17;
        if ((System.currentTimeMillis() - r5.c) <= 0) goto L16;
    L17:
        r1 = r5;
    L18:
        if (r1 == null) goto L20;
    L22:
        if (r1 != null) goto L25;
        return;
    L25:
        if (j.d() == false) goto L28;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "sendMemory");
    L28:
        if (h.a().a(r1.f2592a) == false) goto L30;
        this.f2590b.remove(r1);
        return;
    L30:
        r1.f2593b++;
        r1.c = LogReportController.getInstance().getRetryInterval(r1.f2593b) + System.currentTimeMillis();
        return;
    L20:
        if (this.f2590b.size() <= 0) goto L22;
        r1 = (b) ZeusTransformUtils.preCheckCast(this.f2590b.peek(), b.class, "com.obric.memorydata.plugin");
        goto L22
    }

    private void d(List<com.bytedance.framwork.core.sdklib.apm6.b> r4) {
        Iterator r3 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        com.bytedance.framwork.core.sdklib.apm6.b r5 = (com.bytedance.framwork.core.sdklib.apm6.b) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.framwork.core.sdklib.apm6.b.class, "com.obric.memorydata.plugin");
    L10:
        com.bytedance.framwork.core.sdklib.apm6.safety.c.b("APM-SDK", "delete LogFile's source File failed. logFile=" + r5.c());
        goto L4
    L7:
        if (r5.c() == null) goto L4;
        FileUtils.deleteFile(r5.c());     // Catch: Exception -> L10
        goto L4
    }

    private void e() {
        File r7 = f.a().b();
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.exists() == true) goto L8;
        return;
    L8:
        if (h.a().a(FileUtils.readFileToByteArray(r7)) == true) goto L10;
        f.b r0 = f.a().b(r7);
        int r2 = 0;
        if (r0 == null) goto L16;
        r2 = r0.a() + 1;
    L16:
        long r3 = LogReportController.getInstance().getRetryInterval(r2) + System.currentTimeMillis();
        f.a().a(r7, r2, r3);
        if (j.d() == false) goto L22;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "sendfile error retry count:" + r7.getName() + "  " + r2 + " nextRetryTime:" + r3);
        return;
    L22:
        return;
    L10:
        if (j.d() == false) goto L12;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "sendFile: success");
    L12:
        f.a().a(r7);
    }

    public void a(List<com.bytedance.framwork.core.sdklib.apm6.b> r12) {
        List<com.bytedance.framwork.core.sdklib.apm6.b> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
    L36:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "sendLog", th);
        return;
    L4:
        if (LogReportController.getInstance().isStopCollect() == true) goto L6;
        byte[] r2 = b(r13);     // Catch: Throwable -> L36
        if (r2 != null) goto L14;
        d(r13);     // Catch: Throwable -> L36
        return;
    L14:
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L36
        boolean r7 = false;
        if ((r4 - this.f2589a.get()) < 5000) goto L25;
        this.f2589a.set(r4);     // Catch: Throwable -> L36
        if (LogReportController.getInstance().isReportLogEnable() == true) goto L19;
    L21:
        int r3 = 0;
    L23:
        if (j.d() == false) goto L26;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "sendDirect:isReportLogEnable " + LogReportController.getInstance().isReportLogEnable() + " :sendResult " + r7);     // Catch: Throwable -> L36
    L26:
        if (r7 == true) goto L34;
        long r5 = LogReportController.getInstance().getRetryInterval(r3);     // Catch: Throwable -> L36
        long r6 = System.currentTimeMillis() + r5;     // Catch: Throwable -> L36
        boolean r8 = f.a().a(r2, r3, r6);     // Catch: Throwable -> L36
        if (j.d() == false) goto L30;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "saveFile:Result:" + r8 + " " + r3 + " " + r5);     // Catch: Throwable -> L36
    L30:
        if (r8 == true) goto L34;
        this.f2590b.add(new b(r2, r3, r6));     // Catch: Throwable -> L36
        if (this.f2590b.size() <= 10) goto L34;
        this.f2590b.poll();     // Catch: Throwable -> L36
    L34:
        d(r13);     // Catch: Throwable -> L36
        return;
    L19:
        if (NetUtils.isNetworkTrulyAvailable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L21;
        r7 = h.a().a(r2);     // Catch: Throwable -> L36
        r3 = 1;
        goto L23
    L25:
        r3 = 0;
        goto L26
    L6:
        if (j.d() == false) goto L8;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.c("APM-SDK", "stop collect log");     // Catch: Throwable -> L36
    L8:
        d(r13);     // Catch: Throwable -> L36
    }

    public void b() {
        com.bytedance.framwork.core.sdklib.a.a.a().a(this);
    }

    @Override // com.bytedance.framwork.core.sdklib.a.b
    public void onTimeEvent(long r3) {
        if ((r3 - this.d) < SubwayUtils.ALARM_DELAY_EXIT_CONFIDENCE_SCORING_MS) goto L12;
        c();     // Catch: Throwable -> L6
    L8:
        this.d = System.currentTimeMillis();
        return;
    L6:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "onTimeEvent", th);
        goto L8
    }
}
