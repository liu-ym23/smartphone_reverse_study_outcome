package com.bytedance.apm.h.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.util.k;
import com.bytedance.apm.util.v;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.crash.service.INetworkCallback;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.chromium.wschannel.TrafficChangedObservable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1329b;
    private Map<String, C0090a> c;
    private Map<String, C0090a> d;
    private Map<String, C0090a> e;
    private Map<String, C0090a> f;
    private Map<String, C0090a> g;
    private Map<String, C0090a> h;
    private v<h> i;
    private volatile long j;
    private Map<String, Map<String, C0090a>> k;
    private double l;
    private double m;

    /* JADX INFO: renamed from: com.bytedance.apm.h.b.a$a, reason: collision with other inner class name */
    class C0090a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, Long> f1333b;
        public long c;
        final /* synthetic */ a d;

        public C0090a(a r3, String r4) {
            this.d = r3;
            this.c = 0;
            this.f1332a = r4;
            this.f1333b = new HashMap();
        }

        public JSONObject a() {
            JSONObject r1 = new JSONObject();
            r1.put("biz", this.f1332a);     // Catch: JSONException -> L13
            r1.put("usage", this.c);     // Catch: JSONException -> L13
            JSONArray r2 = new JSONArray();     // Catch: JSONException -> L13
            Map<String, Long> r3 = this.f1333b;     // Catch: JSONException -> L13
            if (r3 != null) goto L6;
        L11:
            r1.put(MemoryListActivity.JUMP_FROM_DETAIL, r2);     // Catch: JSONException -> L13
            goto L12
        L6:
            if (r3.size() <= 0) goto L11;
            Iterator<Map.Entry<String, Long>> r7 = this.f1333b.entrySet().iterator();     // Catch: JSONException -> L13
        L9:
            if (r7.hasNext() == false) goto L11;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L13
            JSONObject r5 = new JSONObject();     // Catch: JSONException -> L13
            r5.put("source_id", r4.getKey());     // Catch: JSONException -> L13
            r5.put("usage", r4.getValue());     // Catch: JSONException -> L13
            r2.put(r5);     // Catch: JSONException -> L13
        L12:
            return r1;
        }

        public JSONObject a(long r9) {
            JSONObject r2 = new JSONObject();
            r2.put("biz", this.f1332a);     // Catch: JSONException -> L15
            r2.put("usage", this.c);     // Catch: JSONException -> L15
            JSONArray r3 = new JSONArray();     // Catch: JSONException -> L15
            Map<String, Long> r4 = this.f1333b;     // Catch: JSONException -> L15
            if (r4 != null) goto L6;
        L13:
            r2.put(MemoryListActivity.JUMP_FROM_DETAIL, r3);     // Catch: JSONException -> L15
            goto L14
        L6:
            if (r4.size() <= 0) goto L13;
            Iterator<Map.Entry<String, Long>> r8 = this.f1333b.entrySet().iterator();     // Catch: JSONException -> L15
        L9:
            if (r8.hasNext() == false) goto L13;
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L15
            if (((Long) ZeusTransformUtils.preCheckCast(r5.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue() < r9) goto L9;
            JSONObject r6 = new JSONObject();     // Catch: JSONException -> L15
            r6.put("source_id", r5.getKey());     // Catch: JSONException -> L15
            r6.put("usage", r5.getValue());     // Catch: JSONException -> L15
            r3.put(r6);     // Catch: JSONException -> L15
        L14:
            return r2;
        }

        public void a(String r5, long r6) {
            if (this.f1333b.containsKey(r5) == false) goto L5;
            Map<String, Long> r0 = this.f1333b;
            Long r1 = Long.valueOf(((Long) ZeusTransformUtils.preCheckCast(r0.get(r5), Long.class, "com.obric.memorydata.plugin")).longValue() + r6);
        L6:
            r0.put(r5, r1);
            this.c += r6;
            return;
        L5:
            r0 = this.f1333b;
            r1 = Long.valueOf(r6);
            goto L6
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1334a = null;

        static {
            f1334a = new a(null);
        }

        static /* synthetic */ a a() {
            return f1334a;
        }
    }

    private a() {
        this.j = 0;
        this.l = 102400.0d;
        this.m = 102400.0d;
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    public static a a() {
        return b.a();
    }

    private void a(String r6, long r7, String r9) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return;
    L5:
        boolean r0 = k.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        boolean r2 = false;
        ActivityLifecycleService r3 = (ActivityLifecycleService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(ActivityLifecycleService.class), ActivityLifecycleService.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r2 = r3.isForeground();
    L9:
        if (this.c != null) goto L12;
        this.c = new HashMap();
    L12:
        if (this.d != null) goto L15;
        this.d = new HashMap();
    L15:
        if (this.e != null) goto L18;
        this.e = new HashMap();
    L18:
        if (this.f != null) goto L21;
        this.f = new HashMap();
    L21:
        if (this.g != null) goto L24;
        this.g = new HashMap();
    L24:
        if (this.c.containsKey(r6) == false) goto L26;
        ((C0090a) ZeusTransformUtils.preCheckCast(this.c.get(r6), C0090a.class, "com.obric.memorydata.plugin")).a(r9, r7);
    L27:
        if (r0 == false) goto L33;
        if (r2 == true) goto L33;
        if (this.d.containsKey(r6) == false) goto L32;
        ((C0090a) ZeusTransformUtils.preCheckCast(this.d.get(r6), C0090a.class, "com.obric.memorydata.plugin")).a(r9, r7);
        goto L33
    L32:
        C0090a r4 = new C0090a(this, r6);
        r4.a(r9, r7);
        this.d.put(r6, r4);
    L33:
        if (r0 == false) goto L39;
        if (r2 == false) goto L39;
        if (this.e.containsKey(r6) == false) goto L38;
        ((C0090a) ZeusTransformUtils.preCheckCast(this.e.get(r6), C0090a.class, "com.obric.memorydata.plugin")).a(r9, r7);
        goto L39
    L38:
        C0090a r5 = new C0090a(this, r6);
        r5.a(r9, r7);
        this.e.put(r6, r5);
    L39:
        if (r0 == true) goto L45;
        if (r2 == true) goto L45;
        if (this.f.containsKey(r6) == false) goto L44;
        ((C0090a) ZeusTransformUtils.preCheckCast(this.f.get(r6), C0090a.class, "com.obric.memorydata.plugin")).a(r9, r7);
        goto L45
    L44:
        C0090a r8 = new C0090a(this, r6);
        r8.a(r9, r7);
        this.f.put(r6, r8);
    L45:
        if (r0 == true) goto L52;
        if (r2 == false) goto L52;
        if (this.g.containsKey(r6) == false) goto L50;
        ((C0090a) ZeusTransformUtils.preCheckCast(this.g.get(r6), C0090a.class, "com.obric.memorydata.plugin")).a(r9, r7);
        goto L52
    L50:
        C0090a r1 = new C0090a(this, r6);
        r1.a(r9, r7);
        this.g.put(r6, r1);
    L52:
        if (this.h != null) goto L55;
        this.h = new HashMap();
    L55:
        if (this.h.containsKey(r6) == false) goto L57;
        ((C0090a) ZeusTransformUtils.preCheckCast(this.h.get(r6), C0090a.class, "com.obric.memorydata.plugin")).a(r9, r7);
    L58:
        Map<String, Map<String, C0090a>> r10 = this.k;
        if (r10 == null) goto L67;
        Iterator<Map.Entry<String, Map<String, C0090a>>> r11 = r10.entrySet().iterator();
    L62:
        if (r11.hasNext() == false) goto L74;
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Map.class, "com.obric.memorydata.plugin");
        if (r12.containsKey(r6) == true) goto L65;
        C0090a r13 = new C0090a(this, r6);
        r13.a(r9, r7);
        r12.put(r6, r13);
        goto L62
    L65:
        ((C0090a) ZeusTransformUtils.preCheckCast(r12.get(r6), C0090a.class, "com.obric.memorydata.plugin")).a(r9, r7);
        goto L62
    L74:
        return;
    L67:
        return;
    L57:
        C0090a r14 = new C0090a(this, r6);
        r14.a(r9, r7);
        this.h.put(r6, r14);
        goto L58
    L26:
        C0090a r15 = new C0090a(this, r6);
        r15.a(r9, r7);
        this.c.put(r6, r15);
        goto L27
    }

    private void a(boolean r1) {
        this.f1328a = r1;
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.f1328a;
    }

    private void b(boolean r1) {
        this.f1329b = r1;
        com.bytedance.apm.e.a.a(r1);
    }

    private void l() {
        com.bytedance.apm.data.pipeline.d.b().a(new AnonymousClass1(this));
    }

    private void m() {
        com.bytedance.apm.data.pipeline.a.b().a(new AnonymousClass2(this));
    }

    public void a(double r1) {
        this.l = r1;
    }

    public void a(String r2) {
        if (this.k != null) goto L5;
        this.k = new HashMap();
    L5:
        this.k.put(r2, new HashMap());
    }

    public void a(String r10, JSONObject r11) {
        if (this.f1328a == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L39;
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.length() == 0) goto L41;
        String r1 = new URL(r10).getPath();     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r1) == false) goto L14;
        return;
    L14:
        String r2 = r11.optString("net_consume_type", INetworkCallback.TYPE_TTNET);     // Catch: Throwable -> L34
        JSONObject r3 = r11.optJSONObject("request_log");     // Catch: Throwable -> L34
        if (r3 != null) goto L19;
        String r12 = r11.optString("request_log");     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r12) == true) goto L19;
        r3 = new JSONObject(r12);     // Catch: Throwable -> L34
    L19:
        JSONObject r13 = r3.optJSONObject(ChatMessage.TYPE_RESPONSE);     // Catch: Throwable -> L34
        long r4 = 0;
        if (r13 == null) goto L22;
        r4 = r13.optLong(TrafficChangedObservable.TRAFFICCHANGED_RECEIVEDBYTES) + r13.optLong(TrafficChangedObservable.TRAFFICCHANGED_SENTBYTES);     // Catch: Throwable -> L34
    L22:
        this.j += r4;     // Catch: Throwable -> L34
        if (r4 > this.l) goto L25;
    L28:
        if (TextUtils.isEmpty(r10) == false) goto L37;
    L31:
        a(r2, r4, r10);
        c.a().a(r4, r1, r2);
        return;
    L37:
        r10 = Uri.parse(r10).buildUpon().clearQuery().build().toString();     // Catch: Exception -> L33
        goto L31
    L25:
        if (this.i != null) goto L27;
        this.i = new v(30);     // Catch: Throwable -> L34
    L27:
        this.i.a(new h(r1, r4, r2));     // Catch: Throwable -> L34
    L42:
        return;
    L41:
        return;
    }

    @Deprecated
    public void a(JSONObject r1) {
    }

    public void b() {
        a(true);
        b(true);
        l();
        m();
    }

    public void b(double r1) {
        this.m = r1;
    }

    public Map<String, C0090a> c() {
        return this.h;
    }

    public v<h> d() {
        return this.i;
    }

    public Map<String, C0090a> e() {
        return this.c;
    }

    public Map<String, C0090a> f() {
        return this.f;
    }

    public Map<String, C0090a> g() {
        return this.g;
    }

    public Map<String, C0090a> h() {
        return this.e;
    }

    public Map<String, C0090a> i() {
        return this.d;
    }

    public long j() {
        return this.j;
    }

    public void k() {
        Map<String, C0090a> r0 = this.c;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Map<String, C0090a> r1 = this.d;
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        Map<String, C0090a> r2 = this.e;
        if (r2 == null) goto L11;
        r2.clear();
    L11:
        Map<String, C0090a> r3 = this.f;
        if (r3 == null) goto L14;
        r3.clear();
    L14:
        Map<String, C0090a> r4 = this.g;
        if (r4 == null) goto L17;
        r4.clear();
    L17:
        v<h> r5 = this.i;
        if (r5 == null) goto L20;
        r5.c();
    L20:
        this.j = 0;
    }
}
