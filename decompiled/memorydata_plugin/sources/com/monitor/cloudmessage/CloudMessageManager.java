package com.monitor.cloudmessage;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.x;
import com.bytedance.apm6.util.Tools;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.monitor.cloudmessage.a.a;
import com.monitor.cloudmessage.a.c;
import com.monitor.cloudmessage.a.d;
import com.monitor.cloudmessage.a.f;
import com.monitor.cloudmessage.a.g;
import com.monitor.cloudmessage.a.h;
import com.monitor.cloudmessage.a.i;
import com.monitor.cloudmessage.a.j;
import com.monitor.cloudmessage.b.a.e;
import com.monitor.cloudmessage.b.a.k;
import com.monitor.cloudmessage.b.a.l;
import com.monitor.cloudmessage.b.a.m;
import com.monitor.cloudmessage.b.a.n;
import com.monitor.cloudmessage.b.a.o;
import com.monitor.cloudmessage.b.a.p;
import com.monitor.cloudmessage.b.a.q;
import com.monitor.cloudmessage.b.a.r;
import com.monitor.cloudmessage.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CloudMessageManager {
    private static final long MIN_FETCH_INTERVAL_MS = 120000;
    private static a sAbTestConsumer = null;
    private static volatile String sAid = "";
    private static c sAlogConsumer = null;
    private static volatile String[] sBlackListForCloudContrlInf = null;
    private static volatile Context sContext = null;
    private static volatile String sDumpFileDir = "";
    private static String sHost = null;
    private static volatile CloudMessageManager sInstance = null;
    private static volatile boolean sIsFetchDataWithSocket = false;
    private static volatile boolean sIsInit = false;
    private static f sMonitorLogConsumer = null;
    private static g sPatchConsumer = null;
    private static h sPluginConsumer = null;
    private static i sRouteConsumer = null;
    private static j sTemplateConsumer = null;
    private static volatile String sUid = "";
    private static volatile String sUpdateVersionCode = "";
    private List<b> mCloudControlHandler;
    private volatile WeakReference<d> mCommandReiveObserver;
    private volatile HashMap<String, String> mCommonParams;
    private final ExecutorService mExecutorService;
    private long mLastFetchTime;
    private Vector mObverserList;

    static {
    }

    private CloudMessageManager() {
        this.mCommonParams = new HashMap();
        this.mCommandReiveObserver = null;
        this.mObverserList = new Vector(10);
        this.mExecutorService = (ExecutorService) ZeusTransformUtils.preCheckCast(AsyncTask.THREAD_POOL_EXECUTOR, ExecutorService.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList(20);
        r0.add(new com.monitor.cloudmessage.b.a.f());
        r0.add(new com.monitor.cloudmessage.b.a.c());
        r0.add(new q());
        r0.add(new com.monitor.cloudmessage.b.a.j());
        r0.add(new o());
        r0.add(new r());
        r0.add(new com.monitor.cloudmessage.b.a.d());
        r0.add(new p());
        r0.add(new m());
        r0.add(new com.monitor.cloudmessage.b.a.h());
        r0.add(new com.monitor.cloudmessage.b.a.b());
        r0.add(new com.monitor.cloudmessage.b.a.a());
        r0.add(new l());
        r0.add(new n());
        r0.add(new com.monitor.cloudmessage.b.a.g());
        r0.add(new com.monitor.cloudmessage.b.a.i());
        r0.add(new e());
        r0.add(new k());
        this.mCloudControlHandler = Collections.unmodifiableList(r0);
        handleCachedConsumer();
        clearDataCache();
        sDumpFileDir = dumpFileDir(sContext).getAbsolutePath() + "/dump.hprof";     // Catch: Exception -> L5
        return;
    }

    static /* synthetic */ void access$000(CloudMessageManager r0, com.monitor.cloudmessage.entity.a r1) {
        r0.handleCloudMessageInternal(r1);
    }

    static /* synthetic */ Context access$100() {
        return sContext;
    }

    private boolean addToObverserList(com.monitor.cloudmessage.d.a r3) {
        com.monitor.cloudmessage.d.a r4 = (com.monitor.cloudmessage.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.monitor.cloudmessage.d.a.class, "com.obric.memorydata.plugin");
        if (this.mObverserList.contains(r4) == true) goto L6;
        this.mObverserList.add(r4);
        return true;
    L6:
        return false;
    }

    private void clearDataCache() {
        this.mExecutorService.execute(new AnonymousClass3(this));
    }

    public static File dumpFileDir(Context r3) {
        File r0 = new File(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getExternalFilesDir(null) + "/monitor");
        if (r0.exists() == true) goto L5;
        r0.mkdir();
    L5:
        return r0;
    }

    public static String getAid() {
        return sAid;
    }

    public static String[] getBlackListForCloudContrlInf() {
        return sBlackListForCloudContrlInf;
    }

    public static String getDumpFileDir() {
        return sDumpFileDir;
    }

    public static CloudMessageManager getInstance() {
        if (sInstance != null) goto L19;
        monitor-enter(CloudMessageManager.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (sInstance == null) goto L9;
    L13:
        monitor-exit(CloudMessageManager.class);     // Catch: Throwable -> L15
        goto L19
    L9:
        if (sIsInit == false) goto L12;
        sInstance = new CloudMessageManager();     // Catch: Throwable -> L15
        goto L13
    L12:
        throw new RuntimeException("call CloudMessageManager.init() first");     // Catch: Throwable -> L15
    L19:
        return sInstance;
    }

    public static String getUid() {
        return sUid;
    }

    public static String getUpdateVersionCode() {
        return sUpdateVersionCode;
    }

    private void handleCachedConsumer() {
        h r0 = sPluginConsumer;
        if (r0 == null) goto L5;
        setPluginMessageConsumer(r0);
        sPluginConsumer = null;
    L5:
        g r1 = sPatchConsumer;
        if (r1 == null) goto L8;
        setPatchMessageConsumer(r1);
        sPatchConsumer = null;
    L8:
        a r2 = sAbTestConsumer;
        if (r2 == null) goto L11;
        setABTestConsumer(r2);
        sAbTestConsumer = null;
    L11:
        c r3 = sAlogConsumer;
        if (r3 == null) goto L14;
        setAlogConsumer(r3);
        sAlogConsumer = null;
    L14:
        f r4 = sMonitorLogConsumer;
        if (r4 == null) goto L17;
        setMonitorLogConsumer(r4);
        sMonitorLogConsumer = null;
    L17:
        i r5 = sRouteConsumer;
        if (r5 == null) goto L20;
        setRouteConsumer(r5);
        sRouteConsumer = null;
    L20:
        j r6 = sTemplateConsumer;
        if (r6 == null) goto L24;
        setTemplateConsumer(r6);
        sTemplateConsumer = null;
        return;
    }

    private void handleCloudMessageInternal(com.monitor.cloudmessage.entity.a r5) {
        if (com.bytedance.apm.b.k() == false) goto L5;
        com.bytedance.apm.e.e.d("cloudmessage", new String[]{"handleCloudMessageInternal cloudMessage=" + r5});
    L5:
        if (r5 != null) goto L8;
        return;
    L8:
        if (this.mCommandReiveObserver != null) goto L10;
        d r0 = null;
    L11:
        if (r0 == null) goto L13;
        r0.a(r5);
    L13:
        Iterator<b> r4 = this.mCloudControlHandler.iterator();
    L15:
        if (r4.hasNext() == false) goto L22;
        if (((b) ZeusTransformUtils.preCheckCast(r4.next(), b.class, "com.obric.memorydata.plugin")).a(r5) == false) goto L15;
        return;
    L22:
        return;
    L10:
        r0 = (d) ZeusTransformUtils.preCheckCast(this.mCommandReiveObserver.get(), d.class, "com.obric.memorydata.plugin");
        goto L11
    }

    public static void init(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        sIsInit = true;
        sContext = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        getInstance();
        if (com.bytedance.apm.b.k() == false) goto L6;
        com.bytedance.apm.e.e.d("cloudmessage", new String[]{"CloudMessageManager Init."});
        return;
    }

    public static boolean isFetchDataWithSocket() {
        return sIsFetchDataWithSocket;
    }

    private boolean removeFromObverserList(com.monitor.cloudmessage.d.a r3) {
        com.monitor.cloudmessage.d.a r4 = (com.monitor.cloudmessage.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.monitor.cloudmessage.d.a.class, "com.obric.memorydata.plugin");
        if (this.mObverserList.contains(r4) == false) goto L6;
        this.mObverserList.remove(r4);
        return true;
    L6:
        return false;
    }

    private void setABTestConsumer(a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        Iterator<b> r3 = this.mCloudControlHandler.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.monitor.cloudmessage.b.a.a.class) == false) goto L6;
        ((com.monitor.cloudmessage.b.a.a) ZeusTransformUtils.preCheckCast(r0, com.monitor.cloudmessage.b.a.a.class, "com.obric.memorydata.plugin")).a(r5);
        return;
    L15:
        return;
    }

    public static void setABTestConsumerSafely(a r2) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        if (sIsInit == false) goto L5;
        getInstance().setABTestConsumer(r3);
        return;
    L5:
        sAbTestConsumer = r3;
    }

    public static void setAid(String r0) {
        sAid = r0;
    }

    private void setAlogConsumer(c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        Iterator<b> r3 = this.mCloudControlHandler.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.monitor.cloudmessage.b.a.b.class) == false) goto L6;
        ((com.monitor.cloudmessage.b.a.b) ZeusTransformUtils.preCheckCast(r0, com.monitor.cloudmessage.b.a.b.class, "com.obric.memorydata.plugin")).a(r5);
        return;
    L15:
        return;
    }

    public static void setAlogConsumerSafely(c r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        if (sIsInit == false) goto L5;
        getInstance().setAlogConsumer(r3);
        return;
    L5:
        sAlogConsumer = r3;
    }

    public static void setBlackListForCloudContrlInf(String[] r0) {
        sBlackListForCloudContrlInf = r0;
    }

    public static void setDumpFileDir(String r0) {
        sDumpFileDir = r0;
    }

    public static void setFetchDataWithSocket(boolean r0) {
        sIsFetchDataWithSocket = r0;
    }

    private void setMonitorLogConsumer(f r4) {
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        Iterator<b> r3 = this.mCloudControlHandler.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.monitor.cloudmessage.b.a.h.class) == false) goto L6;
        ((com.monitor.cloudmessage.b.a.h) ZeusTransformUtils.preCheckCast(r0, com.monitor.cloudmessage.b.a.h.class, "com.obric.memorydata.plugin")).a(r5);
        return;
    L15:
        return;
    }

    public static void setMonitorLogConsumerSafely(f r2) {
        f r3 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
        if (sIsInit == false) goto L5;
        getInstance().setMonitorLogConsumer(r3);
        return;
    L5:
        sMonitorLogConsumer = r3;
    }

    private void setPatchMessageConsumer(g r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        Iterator<b> r3 = this.mCloudControlHandler.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, l.class) == false) goto L6;
        ((l) ZeusTransformUtils.preCheckCast(r0, l.class, "com.obric.memorydata.plugin")).a(r5);
        return;
    L15:
        return;
    }

    public static void setPatchMessageConsumerSafely(g r2) {
        g r3 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
        if (sIsInit == false) goto L5;
        getInstance().setPatchMessageConsumer(r3);
        return;
    L5:
        sPatchConsumer = r3;
    }

    public static void setPluginMessageComsumerSafely(h r2) {
        h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin");
        if (sIsInit == false) goto L5;
        getInstance().setPluginMessageConsumer(r3);
        return;
    L5:
        sPluginConsumer = r3;
    }

    private void setPluginMessageConsumer(h r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        Iterator<b> r3 = this.mCloudControlHandler.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, n.class) == false) goto L6;
        ((n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin")).a(r5);
        return;
    L15:
        return;
    }

    private void setRouteConsumer(i r4) {
        i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        Iterator<b> r3 = this.mCloudControlHandler.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, o.class) == false) goto L6;
        ((o) ZeusTransformUtils.preCheckCast(r0, o.class, "com.obric.memorydata.plugin")).a(r5);
        return;
    L15:
        return;
    }

    public static void setRouteConsumerSafely(i r2) {
        i r3 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
        if (sIsInit == false) goto L5;
        getInstance().setRouteConsumer(r3);
        return;
    L5:
        sRouteConsumer = r3;
    }

    private void setTemplateConsumer(j r4) {
        j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        Iterator<b> r3 = this.mCloudControlHandler.iterator();
    L6:
        if (r3.hasNext() == false) goto L15;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, r.class) == false) goto L6;
        ((r) ZeusTransformUtils.preCheckCast(r0, r.class, "com.obric.memorydata.plugin")).a(r5);
        return;
    L15:
        return;
    }

    public static void setTemplateConsumerSafely(j r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin");
        if (sIsInit == false) goto L5;
        getInstance().setTemplateConsumer(r3);
        return;
    L5:
        sTemplateConsumer = r3;
    }

    public static void setUid(String r0) {
        sUid = r0;
    }

    public static void setUpdateVersionCode(String r0) {
        sUpdateVersionCode = r0;
    }

    public void fetchCommandImmediately() {
        sHost = com.bytedance.apm.i.a.f1370a;
        long r3 = System.currentTimeMillis();
        if ((r3 - this.mLastFetchTime) >= 120000) goto L6;
        com.bytedance.apm.e.e.d("cloudmessage", new String[]{"fetchCommandImmediately too fast. just ignore for this time."});
        return;
    L6:
        this.mLastFetchTime = r3;
        String r4 = x.a(ReportConsts.HTTPS + sHost + "/monitor/collect/c/cloudcontrol/get", com.bytedance.apm.b.q());     // Catch: Exception -> L53
        HashMap r5 = new HashMap();     // Catch: Exception -> L53
        r5.put(NetConst.KEY_CONTENT_TYPE, "application/json");     // Catch: Exception -> L53
        r5.put(NetConst.KEY_REQUSET_VERISON_CODE, "1");     // Catch: Exception -> L53
        r5.put("Accept", "application/json");     // Catch: Exception -> L53
        com.bytedance.services.apm.api.c r1 = com.bytedance.apm.b.a(r4, Tools.safeGetBytes(new JSONObject().toString()), r5);     // Catch: Exception -> L53
        int r6 = 0;
        if (com.bytedance.apm.b.k() == false) goto L10;
        com.bytedance.apm.e.e.d("cloudmessage", new String[]{"fetchCommandImmediately: url=" + r4});     // Catch: Exception -> L53
    L10:
        if (r1 != null) goto L14;
        com.bytedance.apm.e.e.d("cloudmessage", new String[]{"fetchCommandImmediately: res null"});     // Catch: Exception -> L53
        return;
    L14:
        if (r1.a() != 200) goto L64;
        JSONObject r7 = new JSONObject(new String(r1.b()));     // Catch: Exception -> L53
        if (com.bytedance.apm.b.k() == false) goto L18;
        com.bytedance.apm.e.e.d("cloudmessage", new String[]{"fetchCommandImmediately: resultMsg=" + r7.toString()});     // Catch: Exception -> L53
    L18:
        Map<String, String> r2 = r1.c();     // Catch: Exception -> L53
        String r8 = null;
        if (r2 != null) goto L21;
    L32:
        String r0 = r7.optString("data");     // Catch: Exception -> L53
        if (r0.isEmpty() == true) goto L39;
        if (TextUtils.isEmpty(r8) == true) goto L37;
        r7 = new JSONObject(com.bytedance.apm.util.c.a(r0.getBytes(), r8));     // Catch: Exception -> L53
        goto L39
    L37:
        r7 = new JSONObject(new String(r0.getBytes()));     // Catch: Exception -> L53
    L39:
        if (com.bytedance.apm.b.k() == false) goto L42;
        com.bytedance.apm.e.e.d("cloudmessage", new String[]{"fetchCommandImmediately resultMsg=" + r7});     // Catch: Exception -> L53
    L42:
        if (JsonUtils.b(r7) == false) goto L44;
        return;
    L44:
        JSONObject r9 = r7.optJSONObject("configs");     // Catch: Exception -> L53
        if (JsonUtils.b(r9) == false) goto L47;
        return;
    L47:
        JSONArray r10 = r9.optJSONArray("cloud_commands");     // Catch: Exception -> L53
        if (r10 != null) goto L50;
        return;
    L50:
        if (r6 >= r10.length()) goto L66;
        handleCloudMessage(r10.optString(r6));     // Catch: Exception -> L53
        r6 = r6 + 1;
        goto L50
    L66:
        return;
    L21:
        if (r2.isEmpty() == true) goto L32;
        r8 = (String) ZeusTransformUtils.preCheckCast(r2.get(CommonConsts.KEY_DECODE), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L53
        if (TextUtils.isEmpty(r8) == false) goto L32;
        Iterator<Map.Entry<String, String>> r11 = r2.entrySet().iterator();     // Catch: Throwable -> L56
    L27:
        if (r11.hasNext() == false) goto L32;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        if (CommonConsts.KEY_DECODE.equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin")) == false) goto L27;
        r8 = (String) ZeusTransformUtils.preCheckCast(r12.getValue(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        goto L32
    L64:
        return;
    L53:
        e = move-exception;
        com.bytedance.apm.e.e.a("cloudmessage", e, new String[]{"fetchCommandImmediately error."});
    }

    public HashMap<String, String> getCommonParams() {
        return this.mCommonParams;
    }

    public Context getContext() {
        return sContext;
    }

    public Enumeration getObverserList() {
        return this.mObverserList.elements();
    }

    public void handleCloudMessage(final com.monitor.cloudmessage.entity.a r3) {
        this.mExecutorService.execute(new AnonymousClass1(this, r3));
    }

    public void handleCloudMessage(final String r3) {
        this.mExecutorService.execute(new AnonymousClass2(this, r3));
    }

    public void handleCloudMessage(byte[] r5, Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (com.bytedance.apm.b.k() == false) goto L5;
        com.bytedance.apm.e.e.d("cloudmessage", new String[]{"handleCloudMessage payload and headers"});
    L5:
        if (r7 != null) goto L7;
    L14:
        String r8 = "";
    L16:
        if (TextUtils.isEmpty(r8) == false) goto L32;
        r8 = com.monitor.cloudmessage.utils.a.a(r5);
    L32:
        JSONObject r9 = new JSONObject(r8).optJSONObject("configs");     // Catch: JSONException -> L29
        if (r9 == null) goto L40;
        JSONArray r10 = r9.optJSONArray("cloud_commands");     // Catch: JSONException -> L29
        if (r10 == null) goto L41;
        int r11 = 0;
    L24:
        if (r11 >= r10.length()) goto L42;
        String r0 = r10.optString(r11);     // Catch: JSONException -> L29
        if (TextUtils.isEmpty(r0) == true) goto L28;
        handleCloudMessage(r0);     // Catch: JSONException -> L29
    L28:
        r11 = r11 + 1;
        goto L24
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L29:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (r7.size() <= 0) goto L14;
        Iterator r1 = r7.keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (CommonConsts.KEY_DECODE.equals(r2) == false) goto L10;
        r8 = com.monitor.cloudmessage.utils.a.a(r5, (String) ZeusTransformUtils.preCheckCast(r7.get(r2), String.class, "com.obric.memorydata.plugin"));
        goto L16
    }

    public void registerCloudMessageObverser(com.monitor.cloudmessage.d.a r3) {
        com.monitor.cloudmessage.d.a r4 = (com.monitor.cloudmessage.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.monitor.cloudmessage.d.a.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        addToObverserList(r4);
        return;
    }

    public void setCommandReiveObserver(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.mCommandReiveObserver = new WeakReference(r4);
        return;
    }

    public void setCommonParams(HashMap<String, String> r1) {
        this.mCommonParams = r1;
    }

    public void unregisterCloudMessageObverser(com.monitor.cloudmessage.d.a r3) {
        com.monitor.cloudmessage.d.a r4 = (com.monitor.cloudmessage.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.monitor.cloudmessage.d.a.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        removeFromObverserList(r4);
        return;
    }
}
