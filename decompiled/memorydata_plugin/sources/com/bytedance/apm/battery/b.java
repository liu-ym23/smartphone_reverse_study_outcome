package com.bytedance.apm.battery;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.h.b.g;
import com.bytedance.crash.dumper.Scraps;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.apm.h.a implements com.bytedance.apm.battery.e.a.InterfaceC0086a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1127b;
    private long c;
    private String d;
    private ConcurrentHashMap<String, a> e;
    private final Object f;
    private long h;
    private float i;
    private long j;
    private long k;
    private boolean l;
    private g m;
    private CopyOnWriteArrayList<Long> n;
    private com.ss.thor.b o;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f1129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f1130b;
        long c;
        long d;
        StringBuilder e;
        final /* synthetic */ b f;

        public a(b r1) {
            this.f = r1;
            this.e = new StringBuilder();
        }

        float a() {
            return this.f1129a;
        }

        void a(float r1) {
            this.f1129a = r1;
        }

        void a(long r1) {
            this.f1130b = r1;
        }

        void a(List<Long> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.size() == 0) goto L15;
            int r0 = 0;
        L9:
            if (r0 >= (r5.size() - 1)) goto L11;
            this.e.append(r5.get(r0)).append(',');
            r0 = r0 + 1;
            goto L9
        L11:
            this.e.append(r5.get(r5.size() - 1));
            return;
        }

        long b() {
            return this.f1130b;
        }

        void b(long r1) {
            this.c = r1;
        }

        long c() {
            return this.c;
        }

        public void c(long r1) {
            this.d = r1;
        }

        public long d() {
            return this.d;
        }

        String e() {
            return this.e.toString();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.battery.b$b, reason: collision with other inner class name */
    private static final class C0082b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f1131a = null;

        static {
            f1131a = new b(null);
        }

        static /* synthetic */ b a() {
            return f1131a;
        }
    }

    private b() {
        this.e = new ConcurrentHashMap();
        this.f = new Object();
        this.h = 0;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0;
        this.m = g.a();
        this.n = new CopyOnWriteArrayList();
        this.o = new AnonymousClass1(this);
        this.g = Scraps.BATTERY;
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ float a(b r0, float r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ long a(b r0, long r1) {
        r0.j = r1;
        return r1;
    }

    public static b a() {
        return C0082b.a();
    }

    static /* synthetic */ void a(b r0) {
        r0.h();
    }

    static /* synthetic */ long b(b r0, long r1) {
        r0.k = r1;
        return r1;
    }

    static /* synthetic */ Object b(b r0) {
        return r0.f;
    }

    static /* synthetic */ String c(b r0) {
        return r0.d;
    }

    static /* synthetic */ boolean d(b r0) {
        return r0.l();
    }

    static /* synthetic */ boolean e(b r0) {
        return r0.l;
    }

    static /* synthetic */ void f(b r0) {
        r0.g();
    }

    static /* synthetic */ long g(b r2) {
        return r2.h;
    }

    private void g() {
        if (TextUtils.isEmpty(this.d) == true) goto L6;
        this.d = null;
        com.bytedance.apm.l.b.a().b(this);
        com.ss.thor.a.a();
        h();
        return;
    }

    static /* synthetic */ g h(b r0) {
        return r0.m;
    }

    private void h() {
        this.h = 0;
        this.i = 0.0f;
    }

    static /* synthetic */ CopyOnWriteArrayList i(b r0) {
        return r0.n;
    }

    static /* synthetic */ long j(b r4) {
        long r0 = r4.h + 1;
        r4.h = r0;
        return r0;
    }

    static /* synthetic */ float k(b r0) {
        return r0.i;
    }

    static /* synthetic */ long l(b r2) {
        return r2.j;
    }

    static /* synthetic */ long m(b r2) {
        return r2.k;
    }

    static /* synthetic */ ConcurrentHashMap n(b r0) {
        return r0.e;
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.apm.api.d
    public void a(Activity r3) {
        super.a((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
        com.bytedance.apm.l.b.a().b(this);
        Object r4 = this.f;
        monitor-enter(r4);
        g();     // Catch: Throwable -> L7
        monitor-exit(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.h.a
    public void a(JSONObject r5) {
        boolean r1 = true;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        r1 = false;
    L8:
        this.f1126a = r1;
        if (r1 == false) goto L11;
        this.f1127b = r5.optInt("battery_energy_sample_interval", 3000);
        this.c = r5.optLong("battery_energy_upload_interval", 120000);
        return;
    L11:
        ActivityLifeObserver.getInstance().unregister(this);
        com.bytedance.apm.l.b.a().b(this);
        return;
    L5:
        if (r5.optInt("energy_enable", 0) != 1) goto L7;
        goto L7
    }

    @Override // com.bytedance.apm.h.a
    public void b() {
        this.l = com.bytedance.apm.battery.e.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this);
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.apm.api.d
    public void b(Activity r3) {
        super.b((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.apm.battery.e.a.InterfaceC0086a
    public void b(boolean r1) {
        this.l = r1;
        if (r1 == false) goto L12;
        Object r2 = this.f;
        monitor-enter(r2);
        g();     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.h.a
    public void b_() {
        super.b_();
    }

    @Override // com.bytedance.apm.h.a
    public boolean c() {
        return !l();
    }

    @Override // com.bytedance.apm.h.a
    public long d() {
        return this.c;
    }

    @Override // com.bytedance.apm.h.a
    public void e() {
        super.e();
        Iterator<Map.Entry<String, a>> r0 = this.e.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L10
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L10
        r8.put(MemoryInfoSectionEditActivity.KIND_SCENE, r1.getKey());     // Catch: JSONException -> L10
        r7.put("current", ((a) ZeusTransformUtils.preCheckCast(r1.getValue(), a.class, "com.obric.memorydata.plugin")).a());     // Catch: JSONException -> L10
        r7.put("capacity", ((a) ZeusTransformUtils.preCheckCast(r1.getValue(), a.class, "com.obric.memorydata.plugin")).d());     // Catch: JSONException -> L10
        JSONObject r9 = new JSONObject();     // Catch: JSONException -> L10
        r9.put("cpu_time", ((a) ZeusTransformUtils.preCheckCast(r1.getValue(), a.class, "com.obric.memorydata.plugin")).b());     // Catch: JSONException -> L10
        r9.put("traffic", ((a) ZeusTransformUtils.preCheckCast(r1.getValue(), a.class, "com.obric.memorydata.plugin")).c());     // Catch: JSONException -> L10
        r9.put("loc", ((a) ZeusTransformUtils.preCheckCast(r1.getValue(), a.class, "com.obric.memorydata.plugin")).e());     // Catch: JSONException -> L10
        com.bytedance.apm.data.a.e r2 = new com.bytedance.apm.data.a.e(Scraps.BATTERY, "", r7, r8, r9);     // Catch: JSONException -> L10
        com.bytedance.apm.h.b.a(r2, false);     // Catch: JSONException -> L10
        com.bytedance.apm.data.pipeline.a.b().a(r2);     // Catch: JSONException -> L10
        goto L4
    L8:
        this.e.clear();
    }
}
