package com.bytedance.android.ec.core.vmsdk;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import android.view.View;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.gecko.ECForestLoader;
import com.bytedance.android.ec.core.hybrid.ECBridgeProvider;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.vmsdk.exception.InitJsContextException;
import com.bytedance.android.ec.core.vmsdk.module.BaseWorkerBridgeModule;
import com.bytedance.android.ec.core.vmsdk.module.WorkerBridgeModule;
import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.ec.opt.asynctask.w;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.xbridge.XBridge;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XBridgeRegister;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.worker.JsWorker;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p implements com.bytedance.android.ec.core.vmsdk.a {
    public static final p e = null;
    public final Map<String, WeakHashMap<Context, JsWorkerWrapper>> a;
    public final WeakHashMap<Context, Pair<d0, ai.b>> b;
    public String c;
    public final Map<String, Long> d;

    public class a implements com.bytedance.ies.web.jsbridge2.q {
        public a() {
        }

        public final <T> String a(T r1) {
            return u0.d(r1);
        }

        public final <T> T b(String r10, Type r11) {
            return (T) GsonProtectorUtils.fromJson(u0.c(), r10, r11);
        }
    }

    public class b extends com.bytedance.ies.web.jsbridge2.a {
        public final View b() {
            return null;
        }

        public b() {
        }
    }

    public class c implements w {
        public final /* synthetic */ Context a;
        public final /* synthetic */ d0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ com.bytedance.android.ec.core.vmsdk.b d;
        public final /* synthetic */ p e;

        public final com.bytedance.android.ec.opt.asynctask.k r() {
            com.bytedance.android.ec.opt.asynctask.r r0 = new com.bytedance.android.ec.opt.asynctask.r();
            r0.d = true;
            com.bytedance.android.ec.opt.asynctask.o r1 = r0.h;
            r1.b = true;
            com.bytedance.android.ec.opt.asynctask.n r10 = r1.c;
            r10.b = true;
            return r10.c;
        }

        public final void run() {
            p.d(this.e, this.a, this.b, this.c, this.d);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            ECExceptionMonitor.e(e);
        }

        public c(p r1, Context r10, d0 r11, String r12, com.bytedance.android.ec.core.vmsdk.b r13) {
            this.e = r1;
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
        }
    }

    public interface d {
        void a(String r1, String r10, String r11, boolean r12, String r13, long r14);
    }

    public interface e {
        void a(JsWorkerWrapper r1, String r10);
    }

    static {
        e = new p();
    }

    public p() {
        this.a = new HashMap();
        this.b = new WeakHashMap();
        this.d = new HashMap();
    }

    @Override // com.bytedance.android.ec.core.vmsdk.a
    public final void a(String r10) {
        WeakHashMap r11 = (WeakHashMap) ((HashMap) this.a).remove(r10);
        HashSet r0 = new HashSet();
        if (r11 == null) goto L10;
        Iterator r12 = r11.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r12.next();
        if (r1 == null) goto L6;
        r0.add((Context) r1.getKey());
        ((JsWorkerWrapper) r1.getValue()).f.terminate();
    L10:
        Iterator r13 = ((HashMap) this.a).values().iterator();
    L12:
        if (r13.hasNext() == false) goto L19;
        WeakHashMap r14 = (WeakHashMap) r13.next();
        if (r14 == null) goto L12;
        Iterator r15 = r14.keySet().iterator();
    L17:
        if (r15.hasNext() == false) goto L12;
        r0.remove((Context) r15.next());
        goto L17
    L19:
        Iterator r16 = r0.iterator();
    L21:
        if (r16.hasNext() == false) goto L25;
        Context r17 = (Context) r16.next();
        Pair<d0, ai.b> r18 = this.b.remove(r17);
        if (r18 == null) goto L21;
        ((d0) r18.first).e();
        goto L21
    }

    @Override // com.bytedance.android.ec.core.vmsdk.a
    public final void c(Context r10) {
        Iterator r0 = ((HashMap) this.a).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        JsWorkerWrapper r1 = (JsWorkerWrapper) ((Map) r0.next()).remove(r10);
        if (r1 == null) goto L4;
        r1.f.terminate();
        goto L4
    L8:
        Pair<d0, ai.b> r11 = this.b.remove(r10);
        if (r11 == null) goto L17;
        ((d0) r11.first).e();
        return;
    }

    public final Long e(String r10) {
        Long r11 = (Long) ((HashMap) this.d).remove(r10);
        if (r11 != null) goto L6;
        r11 = 0L;
    L6:
        return Long.valueOf(SystemClock.elapsedRealtime() - r11.longValue());
    }

    public final void i(String r10) {
        Map<String, Long> r0 = this.d;
        HashMap r1 = (HashMap) r0;
        r1.put(r10, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v7, types: [com.bytedance.android.ec.core.vmsdk.d] */
    @Override // com.bytedance.android.ec.core.vmsdk.a
    public final JsWorkerWrapper b(Context r14, final com.bytedance.android.ec.core.vmsdk.b r15) {
        final String r1 = r15.a;
        final String r10 = r15.b;
        if (r1.isEmpty() == false) goto L5;
    L41:
        return null;
    L5:
        if (r10.isEmpty() == true) goto L41;
        if (JsWorker.isIsInitialised() == true) goto L16;
        i("init");
        if (JsWorker.initialize() == false) goto L12;
    L14:
        this.c = r14.getFilesDir().getAbsoluteFile() + "/shopping/vmsdk/";
        e("init").longValue();
        goto L16
    L12:
        if (JsWorker.initializeWithPlugin2(np7.b.c()) == true) goto L14;
        return null;
    L16:
        monitor-enter(this);
        WeakHashMap r11 = (WeakHashMap) ((HashMap) this.a).get(r10);     // Catch: Throwable -> L25
        if (r11 != null) goto L20;
        r11 = new WeakHashMap();     // Catch: Throwable -> L25
        ((HashMap) this.a).put(r10, r11);     // Catch: Throwable -> L25
    L20:
        JsWorkerWrapper r12 = (JsWorkerWrapper) r11.get(r14);     // Catch: Throwable -> L25
        if (r12 != null) goto L23;
    L27:
        i("jsWorker");     // Catch: Throwable -> L25
        JSModuleManager r13 = new JSModuleManager(r14);     // Catch: Throwable -> L25
        JsWorkerWrapper r16 = new JsWorkerWrapper(new JsWorker(r13, JsWorker.EngineType.QUICKJS, this.c, false, r15.g), r10);     // Catch: Throwable -> L25
        r11.put(r14, r16);     // Catch: Throwable -> L25
        Pair<d0, ai.b> r17 = f(r14, r10, r15);     // Catch: Throwable -> L25
        if (r17 == null) goto L30;
        ai.b r18 = (ai.b) r17.second;     // Catch: Throwable -> L25
        r18.getClass();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r16, "jsWorker");     // Catch: Throwable -> L25
        r18.o.add(r16);     // Catch: Throwable -> L25
    L31:
        Function3<JSModuleManager, ai.b, String, Unit> r19 = r15.f;     // Catch: Throwable -> L25
        if (r19 != null) goto L34;
        r13.b("bridge", WorkerBridgeModule.class, new BaseWorkerBridgeModule.b(r18, r10));     // Catch: Throwable -> L25
    L35:
        i("init".concat(r10));     // Catch: Throwable -> L25
        g(r16, new com.bytedance.android.ec.core.vmsdk.d(this, r10, r1, r15), r15);     // Catch: Throwable -> L25
        int r110 = ci.a.a;     // Catch: Throwable -> L25
        ci.a.b(e("jsWorker").longValue(), "jsWorker", null, null);     // Catch: Throwable -> L25
        r12 = r16;
    L36:
        monitor-exit(this);     // Catch: Throwable -> L25
        return r12;
    L34:
        r19.invoke(r13, r18, r10);     // Catch: Throwable -> L25
        goto L35
    L30:
        r18 = null;
        goto L31
    L23:
        if (r12.f.isRunning() == true) goto L36;
    L25:
        th = move-exception;
        throw th;
    }

    public final void h(String r10, Context r11) {
        WeakHashMap r12 = (WeakHashMap) ((HashMap) this.a).get(r10);
        if (r12 == null) goto L20;
        JsWorkerWrapper r13 = (JsWorkerWrapper) r12.get(r11);
        if (r13 != null) goto L7;
        return;
    L7:
        if (r13.f.isRunning() == false) goto L22;
        boolean r0 = false;
        if (r13.c.compareAndSet(false, true) == false) goto L23;
        r13.e = true;
        if (r13.d == true) goto L13;
    L17:
        if (r0 == false) goto L24;
        r13.c();
        return;
    L24:
        return;
    L13:
        if (r13.e == false) goto L17;
        if (r13.f.isRunning() == false) goto L17;
        r0 = true;
        goto L17
    L23:
        return;
    L22:
        return;
    }

    public final Pair<d0, ai.b> f(Context r12, String r13, com.bytedance.android.ec.core.vmsdk.b r14) {
        Pair<d0, ai.b> r1 = null;
        if (r14.c == false) goto L5;
    L6:
        Pair<d0, ai.b> r0 = this.b.get(r12);
        if (r0 != null) goto L9;
        i("newJsb");
        ai.b r10 = new ai.b(r12, new ai.a());
        b r11 = new b();
        d0.a r15 = d0.g;
        com.bytedance.ies.web.jsbridge2.o r16 = new com.bytedance.ies.web.jsbridge2.o(r11);
        r16.c = r10;
        r16.f = r12;
        r16.h = true;
        r16.o = true;
        r16.c(new a());
        d0 r17 = r16.a();
        Pair<d0, ai.b> r18 = new Pair(r17, r10);
        this.b.put(r12, r18);
        t.b(new c(this, r12, r17, r13, r14));
        ci.a.b(e("newJsb").longValue(), "newJsb", null, null);
        return r18;
    L9:
        r1 = r0;
    L10:
        h(r13, r12);
        return r1;
    L5:
        if (r14.d == false) goto L10;
        goto L6
    }

    public final void g(final JsWorkerWrapper r10, final com.bytedance.android.ec.core.vmsdk.d r11, final com.bytedance.android.ec.core.vmsdk.b r12) {
        final String r0 = r12.e;
        if (r0 == null) goto L5;
        d r1 = new i(r12, r10, r11, r0);
        ECForestLoader.INSTANCE.fetchAsync(r0, new j(this, r1));
        return;
    L5:
        int r13 = ci.a.a;
        ci.a.a(null, null, null, r10.g, null);
        JSONObject r14 = new JSONObject();
        r14.put(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, r10.g);     // Catch: Exception -> L8
    L11:
        if (ECAppInfoService.e.i() == false) goto L13;
        int r15 = com.bytedance.android.ec.sdk.helper.j.a;
        com.bytedance.android.ec.sdk.helper.j.a("VmSdkService", r14.toString(), null, new InitJsContextException(r14.toString()));
    L14:
        r10.f.terminate();
        return;
    L13:
        ECExceptionMonitor.e(new InitJsContextException(r14.toString()));
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L11
    }

    public static void d(final p r10, Context r11, final d0 r12, String r13, com.bytedance.android.ec.core.vmsdk.b r14) {
        if (r12 == null) goto L6;
        r10.getClass();
        if (r12.f == false) goto L6;
        return;
    L6:
        r10.i("initJsBridge");
        if (r14.d == false) goto L26;
        ArrayList r1 = new ArrayList();
        final g66.c r15 = new g66.c();
        r15.f(Context.class, r11);
        r15.d(p56.c.class, new k());
        r15.d(XBridgeMethod.b.class, new l(r12));
        r15.d(p56.b.class, new m());
        r1.add(com.bytedance.ies.xbridge.event.bridge.c.class);
        r1.add(com.bytedance.ies.xbridge.event.bridge.e.class);
        r1.add(com.bytedance.ies.xbridge.event.bridge.f.class);
        Map r16 = XBridge.INSTANCE.getStandardMethodList(XBridgePlatformType.LYNX, "DEFAULT");
        if (r16 == null) goto L11;
        r1.addAll(r16.values());
    L11:
        XBridgeRegister r17 = new XBridgeRegister();
        Iterator r18 = r1.iterator();
    L13:
        if (r18.hasNext() == false) goto L19;
        final XBridgeMethod r19 = (XBridgeMethod) ((Class) r18.next()).newInstance();     // Catch: Exception -> L17
        r17.a(r19.getName(), new n(r19, r15));     // Catch: Exception -> L17
    L17:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L13
    L19:
        Iterator r20 = MapsKt.toMap(((XBridgeRegister.a) r17.a.getValue()).a).entrySet().iterator();
    L21:
        if (r20.hasNext() == false) goto L26;
        Map.Entry r21 = (Map.Entry) r20.next();
        final String r22 = (String) r21.getKey();
        final com.bytedance.ies.xbridge.n r23 = (com.bytedance.ies.xbridge.n) r21.getValue();
        if (r23 == null) goto L21;
        r12.c(r22, new o(r10, r23, r22));
    L26:
        if (r14.c == false) goto L37;
        boolean r110 = ECServiceManager.a;
        pd.e r111 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getIExternaHybridService();
        if (r111 == null) goto L37;
        final pd.f r112 = r111.getExternalJsBridgeMethodInjectorAdapter();
        Iterator r24 = ((ArrayList) ((ECBridgeProvider) ECBridgeProvider.a.getValue()).a()).iterator();
    L31:
        if (r24.hasNext() == false) goto L37;
        final IECBridgeMethod r25 = (IECBridgeMethod) r24.next();
        if ((r25 instanceof pd.a) == false) goto L35;
        com.bytedance.ies.web.jsbridge2.f.b r26 = new g(r112, r25);
    L36:
        r25.getName();
        r12.c(r25.getName(), r26);
        goto L31
    L35:
        r26 = new h(r112, r25);
    L37:
        ci.a.b(r10.e("initJsBridge").longValue(), "jsb", null, null);
        r10.h(r13, r11);
    }
}
