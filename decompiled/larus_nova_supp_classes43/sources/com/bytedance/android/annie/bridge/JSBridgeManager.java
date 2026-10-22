package com.bytedance.android.annie.bridge;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.bridge.RegisterPolicy;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.method.abs.ResultCodeEnumSerializer;
import com.bytedance.android.annie.card.base.HybridDomainUtils;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.xbridge.mix.DefaultMixMethodCache;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.web.jsbridge2.f0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import e7.j0;
import e7.k0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.FutureTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class JSBridgeManager implements y6.c {
    public static final /* synthetic */ int w = 0;
    public final com.bytedance.android.annie.param.a a;
    public AnnieXLiveContext b;
    public d0 c;
    public f0 d;
    public final ConcurrentLinkedQueue<String> e;
    public IHybridComponent f;
    public WeakReference<IHybridComponent> g;
    public Context h;
    public WeakReference<Context> i;
    public ConcurrentLinkedQueue<q> j;
    public RegisterPolicy k;
    public boolean l;
    public String m;
    public final Lazy n;
    public final Lazy o;
    public volatile boolean p;
    public final FutureTask<Unit> q;
    public final String r;
    public boolean s;
    public final com.bytedance.android.annie.card.g t;
    public boolean u;
    public DefaultMixMethodCache v;

    public static final class a {
    }

    public static final class b extends com.bytedance.ies.web.jsbridge2.a {
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.b c;

        public final View b() {
            com.bytedance.ies.web.jsbridge2.b r0 = this.c;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.g();
        }

        public b(com.bytedance.ies.web.jsbridge2.b r1) {
            this.c = r1;
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.q {
        public final com.bytedance.ies.web.jsbridge2.q a;
        public final Gson b;

        public c() {
            this.a = ((w8.c) Annie.getService$default(w8.c.class, null, 2, null)).n1();
            this.b = new Gson().newBuilder().registerTypeHierarchyAdapter(j0.class, new ResultCodeEnumSerializer()).create();
        }

        public final <T> String a(T r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
            Class<?> r0 = r10.getClass();
            if (Intrinsics.areEqual(r0, JsonObject.class) == false) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L9;
            return r10.toString();
        L9:
            if (Intrinsics.areEqual(r0, String.class) == false) goto L12;
            return r10.toString();
        L12:
            if ((r10 instanceof k0) == false) goto L15;
            return GsonProtectorUtils.toJson(this.b, r10);
        L15:
            return this.a.a(r10);
        L5:
            r1 = Intrinsics.areEqual(r0, JsonArray.class);
            goto L6
        }

        public final <T> T b(String r10, Type r11) {
            Intrinsics.checkNotNullParameter(r10, "data");
            Intrinsics.checkNotNullParameter(r11, "type");
            return (T) GsonProtectorUtils.fromJson(this.b, r10, r11);
        }
    }

    public static final class d<V> implements Callable {
        public final /* synthetic */ JSBridgeManager a;

        public d(JSBridgeManager r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final Unit call() {
            JSBridgeManager r0 = this.a;
            int r1 = JSBridgeManager.w;
            r0.h();
            this.a.p = true;
            JSBridgeManager r10 = this.a;
            com.bytedance.android.annie.param.a r11 = r10.a;
            if (r11 == null) goto L7;
            x8.b r12 = r11.d;
            if (r12 == null) goto L7;
            r12.e(r10.r, "===JSB futureTask end:url:" + this.a.m + "===");
            return Unit.INSTANCE;
        L7:
            return null;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    static {
    }

    public /* synthetic */ JSBridgeManager() {
        this(null);
    }

    @Override // y6.c
    public final f0 a() {
        return new f0(null, this.c);
    }

    @Override // y6.c
    public final IHybridComponent c() {
        IHybridComponent r0 = this.f;
        if (r0 != null) goto L9;
        WeakReference<IHybridComponent> r1 = this.g;
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.get();
    L9:
        return r0;
    }

    @Override // y6.c
    public final d0 d() {
        if (this.u == false) goto L8;
        d0 r0 = this.c;
        if (r0 != null) goto L12;
        d0.a r1 = d0.g;
        return new d0(new com.bytedance.ies.web.jsbridge2.o(), Boolean.TRUE);
    L12:
        return r0;
    L8:
        d0 r10 = this.c;
        if (r10 != null) goto L13;
        d0.a r11 = d0.g;
        return new com.bytedance.ies.web.jsbridge2.o().a();
    L13:
        return r10;
    }

    public final String g() {
        com.bytedance.android.annie.param.a r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.getBizKey();
        if (r1 == null) goto L6;
        return r1;
    L6:
        AnnieXLiveContext r10 = this.b;
        if (r10 != null) goto L12;
        return "host";
    L12:
        return r10.getBizKey();
    }

    @Override // y6.c
    public Activity getActivity() {
        if (this.u == false) goto L12;
        WeakReference<Context> r0 = this.i;
        if (r0 == null) goto L16;
        Context r1 = r0.get();
        if (r1 != null) goto L9;
        return null;
    L9:
        if ((r1 instanceof Activity) == true) goto L11;
        return null;
    L11:
        return (Activity) r1;
    L16:
        return null;
    L12:
        Context r10 = this.h;
        if ((r10 instanceof Activity) == true) goto L15;
        return null;
    L15:
        return (Activity) r10;
    }

    public final void h() {
        d0 r0 = this.c;
        if (r0 == null) goto L5;
        r0.e = this.d;
    L5:
        IHybridComponent r1 = this.f;
        if (r1 == null) goto L20;
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r10 = com.bytedance.android.annie.bridge.method.j0.c(this, r1).entrySet().iterator();
    L9:
        if (r10.hasNext() == false) goto L11;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r11 = r10.next();
        registerMethod(r11.getKey(), r11.getValue());
        goto L9
    L11:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r12 = com.bytedance.android.annie.bridge.method.j0.b(this, r1).entrySet().iterator();
    L13:
        if (r12.hasNext() == false) goto L15;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r13 = r12.next();
        registerMethod(r13.getKey(), r13.getValue());
        goto L13
    L15:
        Iterator<Map.Entry<String, n56.c>> r14 = com.bytedance.android.annie.bridge.method.j0.a(this, r1).entrySet().iterator();
    L17:
        if (r14.hasNext() == false) goto L20;
        Map.Entry<String, n56.c> r15 = r14.next();
        registerMethod(r15.getKey(), r15.getValue());
    L20:
        if (this.u == false) goto L37;
        WeakReference<IHybridComponent> r16 = this.g;
        if (r16 == null) goto L37;
        IHybridComponent r17 = r16.get();
        if (r17 == null) goto L37;
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r18 = com.bytedance.android.annie.bridge.method.j0.c(this, r17).entrySet().iterator();
    L27:
        if (r18.hasNext() == false) goto L29;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r19 = r18.next();
        registerMethod(r19.getKey(), r19.getValue());
        goto L27
    L29:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r20 = com.bytedance.android.annie.bridge.method.j0.b(this, r17).entrySet().iterator();
    L31:
        if (r20.hasNext() == false) goto L33;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r21 = r20.next();
        registerMethod(r21.getKey(), r21.getValue());
        goto L31
    L33:
        Iterator<Map.Entry<String, n56.c>> r22 = com.bytedance.android.annie.bridge.method.j0.a(this, r17).entrySet().iterator();
    L35:
        if (r22.hasNext() == false) goto L37;
        Map.Entry<String, n56.c> r23 = r22.next();
        registerMethod(r23.getKey(), r23.getValue());
    L37:
        Iterator r24 = ((CopyOnWriteArraySet) a9.j.c).iterator();
    L39:
        if (r24.hasNext() == false) goto L84;
        y6.a r25 = (y6.a) r24.next();
        if (this.k == RegisterPolicy.SPECIFIED) goto L42;
        Iterator<Map.Entry<String, n56.c>> r26 = r25.d(this).entrySet().iterator();
    L74:
        if (r26.hasNext() == false) goto L76;
        Map.Entry<String, n56.c> r27 = r26.next();
        registerMethod(r27.getKey(), r27.getValue());
        goto L74
    L76:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r28 = r25.k(this).entrySet().iterator();
    L78:
        if (r28.hasNext() == false) goto L80;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r29 = r28.next();
        registerMethod(r29.getKey(), r29.getValue());
        goto L78
    L80:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r30 = r25.n(this).entrySet().iterator();
    L82:
        if (r30.hasNext() == false) goto L39;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r31 = r30.next();
        registerMethod(r31.getKey(), r31.getValue());
        goto L82
    L42:
        Map<String, n56.c> r32 = r25.e(this);
        if (r32.isEmpty() == false) goto L48;
        Iterator<Map.Entry<String, n56.c>> r33 = r25.d(this).entrySet().iterator();
    L46:
        if (r33.hasNext() == false) goto L52;
        Map.Entry<String, n56.c> r34 = r33.next();
        registerMethod(r34.getKey(), r34.getValue());
    L52:
        Map<String, com.bytedance.ies.web.jsbridge2.f.b> r35 = r25.l(this);
        if (r35.isEmpty() == false) goto L58;
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r36 = r25.k(this).entrySet().iterator();
    L56:
        if (r36.hasNext() == false) goto L62;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r37 = r36.next();
        registerMethod(r37.getKey(), r37.getValue());
    L62:
        Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r38 = r25.o(this);
        if (r38.isEmpty() == true) goto L64;
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r39 = r38.entrySet().iterator();
    L70:
        if (r39.hasNext() == false) goto L39;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r40 = r39.next();
        registerMethod(r40.getKey(), r40.getValue());
        goto L70
    L64:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r41 = r25.n(this).entrySet().iterator();
    L66:
        if (r41.hasNext() == false) goto L39;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r42 = r41.next();
        registerMethod(r42.getKey(), r42.getValue());
        goto L66
    L58:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r43 = r35.entrySet().iterator();
    L60:
        if (r43.hasNext() == false) goto L62;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r44 = r43.next();
        registerMethod(r44.getKey(), r44.getValue());
        goto L60
    L48:
        Iterator<Map.Entry<String, n56.c>> r45 = r32.entrySet().iterator();
    L50:
        if (r45.hasNext() == false) goto L52;
        Map.Entry<String, n56.c> r46 = r45.next();
        registerMethod(r46.getKey(), r46.getValue());
        goto L50
    L84:
        w8.c r47 = (w8.c) Annie.getService$default(w8.c.class, null, 2, null);
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r48 = r47.provideDefaultStatelessMethods(this.c, this.k).entrySet().iterator();
    L86:
        if (r48.hasNext() == false) goto L88;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r49 = r48.next();
        registerMethod(r49.getKey(), r49.getValue());
        goto L86
    L88:
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b>> r50 = r47.provideDefaultStatefulMethods(this.c, this.k).entrySet().iterator();
    L90:
        if (r50.hasNext() == false) goto L92;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.f.b> r51 = r50.next();
        registerMethod(r51.getKey(), r51.getValue());
        goto L90
    L92:
        Iterator r52 = r47.N(this.k).entrySet().iterator();
    L94:
        if (r52.hasNext() == false) goto L96;
        Map.Entry r53 = (Map.Entry) r52.next();
        registerMethod((String) r53.getKey(), (n56.c) r53.getValue());
        goto L94
    }

    public final void i() {
        ConcurrentLinkedQueue<q> r0 = this.j;
        if (r0 == null) goto L8;
        Iterator<q> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().release();
    L8:
        this.v = null;
        this.h = null;
        this.i = null;
        this.b = null;
        this.f = null;
        this.g = null;
        this.j = null;
        a9.j r10 = a9.j.a;
        a9.j.I1(this);
    }

    @Override // y6.c
    public final void release() {
        com.bytedance.android.annie.param.a r0 = this.a;
        if (r0 == null) goto L7;
        x8.b r1 = r0.d;
        if (r1 == null) goto L7;
        r1.e(this.r, "===JSBridgeManager release url:" + this.m + " ===");
    L7:
        this.s = true;
        a9.j.I1(this);
        this.q.cancel(true);
        ConcurrentLinkedQueue<q> r10 = this.j;
        if (r10 == null) goto L13;
        Iterator<q> r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L13;
        r11.next().release();
    L13:
        d0 r12 = this.c;
        if (r12 == null) goto L16;
        r12.e();
    L16:
        f0 r13 = this.d;
        if (r13 == null) goto L22;
        n56.a r14 = r13.b;
        r14.a = null;
        n56.a.a r15 = r14.h;
        if (r15 == null) goto L21;
        r15.removeCallbacksAndMessages(null);
    L21:
        r14.f = null;
    L22:
        d0 r16 = this.c;
        if (r16 == null) goto L27;
        Set<d0> r17 = h.a;
        Intrinsics.checkNotNullParameter(r16, "owner");
        h.a.remove(r16);
        return;
    }

    public JSBridgeManager(com.bytedance.android.annie.param.a r10) {
        this.e = new ConcurrentLinkedQueue();
        this.j = new ConcurrentLinkedQueue();
        this.k = RegisterPolicy.DEFAULT;
        this.m = "";
        this.n = LazyKt.lazy(JSBridgeManager$asyncJsbMethodAB$2.INSTANCE);
        this.o = LazyKt.lazy(JSBridgeManager$jsbMethodCallbackAB$2.INSTANCE);
        this.p = true;
        this.q = new FutureTask(new d(this));
        this.r = "JSBridgeManager";
        this.t = new com.bytedance.android.annie.card.g();
        this.a = r10;
    }

    @Override // y6.c
    public final void b(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        if (this.u == false) goto L5;
        this.i = new WeakReference(r10);
        return;
    L5:
        this.h = r10;
    }

    public final void j(String r14, String r15) {
        if (((Boolean) this.n.getValue()).booleanValue() == false) goto L10;
        this.p = false;
        com.bytedance.android.annie.param.a r0 = this.a;
        if (r0 == null) goto L9;
        x8.b r1 = r0.d;
        if (r1 == null) goto L9;
        r1.e(this.r, "===JSB futureTask execute:url:" + this.m + "===");
    L9:
        AsyncTask.THREAD_POOL_EXECUTOR.execute(this.q);
    L17:
        if (Intrinsics.areEqual(r14, "none") == true) goto L27;
        long r10 = SystemClock.elapsedRealtime();
        ((da.b) Annie.getService$default(da.b.class, null, 2, null)).J(this, r14);
        ((da.b) Annie.getService(da.b.class, r15)).J(this, r14);
        long r16 = SystemClock.elapsedRealtime() - r10;
        j9.b r11 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        String r12 = this.m;
        JSONObject r13 = new JSONObject();
        r13.put("cost", r16);
        Unit r17 = Unit.INSTANCE;
        JSONObject r18 = new JSONObject();
        com.bytedance.android.annie.ng.a r19 = com.bytedance.android.annie.ng.g.c.get(g());
        if (r19 == null) goto L24;
        o8.f r110 = r19.b;
        if (r110 == null) goto L24;
        String r111 = r110.a;
        if (r111 == null) goto L24;
    L25:
        r18.put("virtual_aid", r111);
        j9.b.a.a(r11, null, "latch_reg_xbridge_cost", r12, null, r13, null, r18, 0, 256);
    L24:
        r111 = "88888";
    L27:
        if (this.l == true) goto L32;
        d0 r112 = this.c;
        if (r112 == null) goto L33;
        ((w8.c) Annie.getService$default(w8.c.class, null, 2, null)).l1(r112);
        return;
    L33:
        return;
    L32:
        return;
    L10:
        com.bytedance.android.annie.param.a r20 = this.a;
        if (r20 == null) goto L15;
        x8.b r21 = r20.d;
        if (r21 == null) goto L15;
        r21.e(this.r, "===JSB normal execute:url:" + this.m + "===");
    L15:
        h();
        goto L17
    }

    @Override // y6.c
    public final void registerMethod(String r10, com.bytedance.ies.web.jsbridge2.f.b r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        d0 r0 = this.c;
        q r1 = null;
        if (r0 == null) goto L30;
        Intrinsics.checkNotNull(r0);
        if (r0.f == true) goto L30;
        if (this.s == true) goto L30;
        if (Intrinsics.areEqual(r10, "getStorage") == false) goto L11;
    L12:
        com.bytedance.android.annie.param.a r12 = this.a;
        if (r12 == null) goto L18;
        x8.b r13 = r12.d;
        if (r13 == null) goto L18;
        r13.f(this.r, "register_method", "===registerMethod url:" + this.m + "  methodName:" + r10 + "===");
    L18:
        if ((r11 instanceof q) == false) goto L20;
        q r14 = (q) r11;
    L21:
        if (r14 == null) goto L25;
        ConcurrentLinkedQueue<q> r15 = this.j;
        if (r15 == null) goto L25;
        r15.add(r14);
    L25:
        d0 r16 = this.c;
        if (r16 == null) goto L28;
        r16.c(r10, r11);
    L28:
        this.e.add(r10);
        ((c9.d) Annie.getService$default(c9.d.class, null, 2, null)).registerMethod(r10, r11);
        goto L30
    L20:
        r14 = null;
        goto L21
    L11:
        if (Intrinsics.areEqual(r10, "setStorage") == false) goto L18;
    L30:
        if (this.u == true) goto L32;
        return;
    L32:
        if ((r11 instanceof q) == false) goto L34;
        r1 = (q) r11;
    L34:
        if (r1 == null) goto L38;
        ConcurrentLinkedQueue<q> r17 = this.j;
        if (r17 == null) goto L38;
        r17.add(r1);
    L38:
        DefaultMixMethodCache r18 = this.v;
        if (r18 == null) goto L43;
        r18.b(r10, r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.android.annie.api.card.IHybridComponent] */
    /* JADX WARN: Type inference failed for: r15v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    @Override // y6.c
    public final <T> void sendJSEvent(String r14, T r15) {
        Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        d0 r0 = this.c;
        if (r0 == null) goto L45;
        Boolean r1 = Boolean.valueOf(r0.f);
        Intrinsics.checkNotNull(r1);
        if (r1.booleanValue() == true) goto L45;
        if (this.s == true) goto L45;
        d0 r10 = this.c;
        if (r10 == null) goto L11;
        r10.f(r14, r15);
    L11:
        com.bytedance.android.annie.param.a r11 = this.a;
        if (r11 == null) goto L17;
        x8.b r12 = r11.d;
        if (r12 == null) goto L17;
        r12.e(this.r, "x, eventName:" + r14 + ", url:" + this.m);
    L17:
        if (Intrinsics.areEqual("onDegradeHappened", r14) == false) goto L45;
        com.bytedance.android.annie.param.a r13 = this.a;
        String r16 = null;
        if (r13 == null) goto L21;
        String r17 = r13.getBizKey();
    L22:
        if (r17 != null) goto L55;
    L35:
        String r18 = "88888";
    L36:
        j9.b r19 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        String r20 = this.m;
        if ((r15 instanceof JSONObject) == false) goto L39;
        JSONObject r21 = (JSONObject) r15;
    L40:
        JSONObject r110 = new JSONObject();
        r110.put("virtual_aid", r18);
        Unit r22 = Unit.INSTANCE;
        com.bytedance.android.annie.param.a r23 = this.a;
        if (r23 == null) goto L43;
        r16 = r23.getMonitorID();
    L43:
        r19.b(null, "annie_container_degrade_event", r20, r21, null, null, r110, 0, r16);
        goto L45
    L39:
        r21 = null;
        goto L40
    L55:
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r24 = com.bytedance.android.annie.ng.g.c;     // Catch: Exception -> L54
        com.bytedance.android.annie.param.a r25 = this.a;     // Catch: Exception -> L54
        if (r25 == null) goto L28;
        String r26 = r25.getBizKey();     // Catch: Exception -> L54
        if (r26 == null) goto L28;
    L29:
        com.bytedance.android.annie.ng.a r27 = r24.get(r26);     // Catch: Exception -> L54
        if (r27 == null) goto L35;
        o8.f r28 = r27.b;     // Catch: Exception -> L54
        if (r28 == null) goto L35;
        r18 = r28.a;     // Catch: Exception -> L54
        if (r18 != null) goto L36;
    L28:
        r26 = "webcast";
        goto L29
    L21:
        r17 = null;
    L45:
        if (this.u == false) goto L57;
        WeakReference<IHybridComponent> r29 = this.g;
        if (r29 == null) goto L58;
        IHybridComponent r30 = r29.get();
        ?? r111 = r15;
        if (r30 == 0) goto L59;
        if (r15 != 0) goto L52;
        r111 = (T) new Object();
    L52:
        r30.sendJsEvent(r14, r111);
        return;
    L59:
        return;
    L58:
        return;
    }

    @Override // y6.c
    public final <P, R> void registerMethod(String r10, com.bytedance.ies.web.jsbridge2.g<P, R> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        d0 r0 = this.c;
        if (r0 == null) goto L22;
        Boolean r1 = Boolean.valueOf(r0.f);
        Intrinsics.checkNotNull(r1);
        if (r1.booleanValue() == true) goto L22;
        if (this.s == true) goto L22;
        if (Intrinsics.areEqual(r10, "getStorage") == false) goto L11;
    L12:
        com.bytedance.android.annie.param.a r12 = this.a;
        if (r12 == null) goto L17;
        x8.b r13 = r12.d;
        if (r13 == null) goto L17;
        r13.f(this.r, "register_method", "===registerMethod url:" + this.m + "  methodName:" + r10 + "===");
    L17:
        d0 r14 = this.c;
        if (r14 == null) goto L20;
        r14.d(r10, r11);
    L20:
        this.e.add(r10);
        ((c9.d) Annie.getService$default(c9.d.class, null, 2, null)).registerMethod(r10, r11);
        goto L22
    L11:
        if (Intrinsics.areEqual(r10, "setStorage") == false) goto L17;
    L22:
        if (this.u == false) goto L27;
        DefaultMixMethodCache r15 = this.v;
        if (r15 == null) goto L28;
        r15.c(r10, r11);
        return;
    L28:
        return;
    }

    @Override // y6.c
    public final void registerMethod(String r10, n56.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        if (this.s == true) goto L9;
        f0 r0 = this.d;
        if (r0 == null) goto L7;
        r0.d(r10, r11);
    L7:
        this.e.add(r10);
    L9:
        if (this.u == false) goto L14;
        DefaultMixMethodCache r1 = this.v;
        if (r1 == null) goto L15;
        r1.d(r10, r11);
        return;
    L15:
        return;
    }

    public JSBridgeManager(AnnieXLiveContext r10, IHybridComponent r11, Context r12) {
        Intrinsics.checkNotNullParameter(r10, "annieContext");
        Intrinsics.checkNotNullParameter(r11, "hybridComponent");
        Intrinsics.checkNotNullParameter(r12, "context");
        this.e = new ConcurrentLinkedQueue();
        this.j = new ConcurrentLinkedQueue();
        this.k = RegisterPolicy.DEFAULT;
        this.m = "";
        this.n = LazyKt.lazy(JSBridgeManager$asyncJsbMethodAB$2.INSTANCE);
        this.o = LazyKt.lazy(JSBridgeManager$jsbMethodCallbackAB$2.INSTANCE);
        this.p = true;
        this.q = new FutureTask(new d(this));
        this.r = "JSBridgeManager";
        this.t = new com.bytedance.android.annie.card.g();
        this.b = r10;
        this.g = new WeakReference(r11);
        this.u = true;
        this.i = new WeakReference(r12);
    }

    public final d0 f(Context r10, com.bytedance.ies.web.jsbridge2.o r11, com.bytedance.ies.web.jsbridge2.b r12, List<? extends com.bytedance.ies.web.jsbridge2.u> r13, final String r14) {
        String r1 = null;
        ((f9.b) Annie.getService$default(f9.b.class, null, 2, null)).m1();
        if (((Boolean) this.n.getValue()).booleanValue() == false) goto L5;
        ((o) Annie.getService$default(o.class, null, 2, null)).h1(r11, new JSBridgeManager$createRealJSBridge$1(this, r14));
    L5:
        com.bytedance.android.annie.param.a r0 = this.a;
        if (r0 == null) goto L9;
        String r15 = r0.getBizKey();
        if (r15 == null) goto L9;
    L10:
        r11.s = r15;
        r11.g = com.bytedance.android.annie.ng.g.b().a.a;
        r11.f = r10;
        r11.c = r12;
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r16 = com.bytedance.android.annie.ng.g.c;
        com.bytedance.android.annie.ng.a r17 = r16.get(r11.b());
        if (r17 == null) goto L15;
        o8.e r18 = r17.c;
        if (r18 == null) goto L15;
        String r19 = r18.a;
    L16:
        r11.k = r19;
        com.bytedance.android.annie.ng.a r20 = r16.get(r11.b());
        if (r20 == null) goto L21;
        o8.e r21 = r20.c;
        if (r21 == null) goto L21;
        r1 = r21.b;
    L21:
        r11.d = r1;
        com.bytedance.android.annie.ng.a r22 = r16.get(r11.b());
        if (r22 == null) goto L26;
        o8.e r23 = r22.c;
        if (r23 == null) goto L26;
        boolean r24 = r23.c;
    L27:
        r11.h = r24;
        if (o7.e.a() == false) goto L31;
        r11.o = true;
    L31:
        if (AnnieConfigSettingKeys.JSB_USE_CORRECT_PERMISSION_SETTING.a().booleanValue() == false) goto L33;
        r11.i = AnnieConfigSettingKeys.JSB_ENABLE_PERMISSION_CHECK.a().booleanValue();
    L33:
        r11.l.addAll((List) HybridDomainUtils.a.getValue());
        r11.c(new c());
        Iterator<T> r25 = r13.iterator();
    L35:
        if (r25.hasNext() == false) goto L37;
        r11.j.add((com.bytedance.ies.web.jsbridge2.u) r25.next());
        goto L35
    L37:
        final d0 r26 = r11.a();
        if (((Boolean) this.o.getValue()).booleanValue() == false) goto L40;
        ((r) Annie.getService(r.class, r26.c.b())).K0(r26, new JSBridgeManager$createRealJSBridge$3$1(r14, r26));
    L40:
        return r26;
    L26:
        r24 = false;
    L15:
        r19 = null;
    L9:
        r15 = "host";
        goto L10
    }

    public final void e(IHybridComponent r10, Context r11, com.bytedance.ies.web.jsbridge2.b r12, List<? extends com.bytedance.ies.web.jsbridge2.u> r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "hybridComponent");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r13, "jsbListeners");
        Intrinsics.checkNotNullParameter(r15, "xBridgeRegisterStrategy");
        this.f = r10;
        this.h = r11;
        this.m = r14;
        b r0 = new b(r12);
        d0.a r1 = d0.g;
        d0 r16 = f(r11, new com.bytedance.ies.web.jsbridge2.o(r0), r12, r13, r14);
        this.c = r16;
        this.d = new f0(null, r16);
        d0 r17 = this.c;
        if (r17 == null) goto L5;
        Set<d0> r18 = h.a;
        Intrinsics.checkNotNullParameter(r17, "owner");
    L5:
        j(r15, r10.getBizKey());
        a9.j r19 = a9.j.a;
        a9.j.H1(this);
    }
}
