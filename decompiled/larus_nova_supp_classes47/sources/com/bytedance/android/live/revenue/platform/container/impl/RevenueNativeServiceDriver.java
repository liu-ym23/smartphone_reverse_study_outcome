package com.bytedance.android.live.revenue.platform.container.impl;

import android.os.Looper;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.platform.aio.ServiceHub;
import com.bytedance.platform.aio.channel.RpcException;
import com.bytedance.platform.aio.channel.RpcExceptionMonitorLevel;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevenueNativeServiceDriver implements com.bytedance.platform.aio.a, com.bytedance.android.scope.o, s {
    public final Gson a;
    public final ConcurrentHashMap<Class<? extends com.bytedance.android.scope.j>, Set<t>> b;
    public final Map<Class<?>, w0> c;
    public final Map<String, y0> d;
    public final Map<Class<?>, Pair<com.bytedance.android.scope.j, Object>> e;
    public final ny0.a f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Object a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(Object r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            Throwable r5 = (Throwable) r7;
            int r8 = d.a;
            v r9 = (v) this.a;
            d.a(r9.b, r9.c, r9.d, this.b, this.c, r5);
        }
    }

    public final void g(ServiceHub r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceHub");
    }

    public final void i(com.bytedance.platform.aio.c r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceHub");
    }

    public final void onStart() {
        this.f.J0(this);
    }

    public final void onStop() {
        this.f.g(this);
    }

    public RevenueNativeServiceDriver(ny0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "rpcService");
        this.f = r2;
        this.a = GsonHelper.get();
        this.b = new ConcurrentHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
    }

    public static com.bytedance.android.scope.j o(com.bytedance.android.scope.j r1) {
        cy0.e.a.getClass();
        if (Intrinsics.areEqual(r1, cy0.e.a.a) == false) goto L5;
        return r1;
    L5:
        if (r1 == null) goto L9;
        return ((e33.h) r1).r();
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.scope.internal.ScopeChild<*>");
    }

    public final boolean d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interfaceId");
        if (x(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.s
    public final void f(com.bytedance.android.scope.j r5) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        Map<String, y0> r0 = this.d;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = ((LinkedHashMap) r0).entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) r2.next();
        if (Intrinsics.areEqual(((y0) r3.getValue()).c, r5) == false) goto L4;
        r1.put(r3.getKey(), r3.getValue());
        goto L4
    L8:
        Iterator r4 = r1.keySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        String r6 = (String) r4.next();
        this.d.remove(r6);
        goto L10
    L12:
        Map<Class<?>, Pair<com.bytedance.android.scope.j, Object>> r7 = this.e;
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator r9 = ((LinkedHashMap) r7).entrySet().iterator();
    L14:
        if (r9.hasNext() == false) goto L18;
        Map.Entry r10 = (Map.Entry) r9.next();
        if (Intrinsics.areEqual((com.bytedance.android.scope.j) ((Pair) r10.getValue()).getFirst(), r5) == false) goto L14;
        r8.put(r10.getKey(), r10.getValue());
        goto L14
    L18:
        Iterator r12 = r8.keySet().iterator();
    L20:
        if (r12.hasNext() == false) goto L22;
        Class r13 = (Class) r12.next();
        this.e.remove(r13);
        goto L20
    }

    public final w0 x(String r8) {
        Iterator<Map.Entry<Class<? extends com.bytedance.android.scope.j>, Set<t>>> r0 = this.b.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        Iterator<t> r1 = r0.next().getValue().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        t r2 = r1.next();
        x0 r3 = r2.b();
        Iterator<Map.Entry<String, u>> r4 = r3.b.entrySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        Map.Entry<String, u> r5 = r4.next();
        this.f.a(r5.getValue().a, this);
        goto L10
    L12:
        this.c.put(r2.a(), r3);
        Map<Class<?>, Pair<com.bytedance.android.scope.j, Object>> r6 = this.e;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        Pair r9 = (Pair) r7.get(r3.c);
        if (r9 == null) goto L15;
        y(r9.getSecond(), r3, (com.bytedance.android.scope.j) r9.getFirst());
        this.e.remove(r3.c);
    L15:
        r1.remove();
        if (r3.b.containsKey(r8) == false) goto L7;
        return r3;
    L18:
        return null;
    }

    public static j57.a j(String r4, Object r5) {
        Object r2 = null;
        if ((r5 instanceof com.bytedance.revenue.platform.api.core.rx.a) == false) goto L14;
        if (r5 == null) goto L12;
        Observable r0 = (Observable) r5;
        Object r6 = ((com.bytedance.revenue.platform.api.core.rx.a) r5).getValue();
        if ((r6 instanceof Object) == false) goto L32;
        r2 = r6;
    L32:
        return new j57.a(r0, r2, 4);
    L12:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.Observable<R>");
    L14:
        if ((r5 instanceof Observable) == false) goto L22;
        if (r5 == null) goto L20;
        j57.a r1 = new j57.a((Observable) r5, null, n(r4, "Observable"));
    L33:
        return r1;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.Observable<R>");
    L22:
        if ((r5 instanceof Single) == false) goto L28;
        Observable r7 = ((Single) r5).toObservable();
        if (r7 == null) goto L27;
        r1 = new j57.a(r7, null, n(r4, "Single"));
        goto L33
    L27:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.Observable<R>");
    L28:
        if (r5 != null) goto L31;
        return new j57.a(Observable.just(Unit.INSTANCE), null, 6);
    L31:
        return new j57.a(Observable.just(r5), r5, 4);
    }

    public static boolean k(com.bytedance.android.scope.j r4, y0 r5) {
        com.bytedance.android.scope.j r0 = r5.c;
    L3:
        cy0.e.a.getClass();
        if ((!Intrinsics.areEqual(r0, cy0.e.a.a)) == false) goto L11;
        com.bytedance.android.scope.m.e.getClass();
        if ((!Intrinsics.areEqual(r0, com.bytedance.android.scope.m.d)) == false) goto L11;
        if (Intrinsics.areEqual(r0.getClass(), cy0.f.class) == true) goto L9;
        r0 = o(r0);
        goto L3
    L9:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L40;
        com.bytedance.android.scope.j r6 = r5.c;
    L15:
        cy0.e.a.getClass();
        cy0.j r2 = cy0.e.a.a;
        if ((!Intrinsics.areEqual(r4, r2)) == false) goto L29;
        com.bytedance.android.scope.m.e.getClass();
        if ((!Intrinsics.areEqual(r4, com.bytedance.android.scope.m.d)) == false) goto L29;
        com.bytedance.android.scope.j r3 = r6;
    L20:
        cy0.e.a.getClass();
        if ((!Intrinsics.areEqual(r3, cy0.e.a.a)) == false) goto L28;
        com.bytedance.android.scope.m.e.getClass();
        if ((!Intrinsics.areEqual(r3, com.bytedance.android.scope.m.d)) == false) goto L28;
        if (Intrinsics.areEqual(r4, r3) == true) goto L30;
        r3 = o(r3);
    L30:
        cy0.e.a.getClass();
        return true ^ Intrinsics.areEqual(r4, cy0.e.a.a);
    L28:
        r4 = o(r4);
    L29:
        r4 = r2;
        goto L30
    L40:
        return true;
    L11:
        r1 = false;
        goto L12
    }

    public static RpcException n(String r2, String r3) {
        if (Intrinsics.areEqual(r2, "initial_prop") == true) goto L5;
        return null;
    L5:
        return com.bytedance.platform.aio.d.b("unsupported response type [" + r3 + "], please use BehaviorObservable instead if it has currentValue", null);
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.s
    public final void a(v0 r3, KClass r4) {
        Intrinsics.checkNotNullParameter(r3, "provider");
        Intrinsics.checkNotNullParameter(r4, "scope");
        if (this.c.containsKey(r3.a()) == true) goto L12;
        ConcurrentHashMap<Class<? extends com.bytedance.android.scope.j>, Set<t>> r0 = this.b;
        Class<? extends com.bytedance.android.scope.j> r5 = JvmClassMappingKt.getJavaClass(r4);
        Set<t> r1 = r0.get(r5);
        if (r1 != null) goto L10;
        r1 = new LinkedHashSet();
        Set<t> r6 = r0.putIfAbsent(r5, r1);
        if (r6 == null) goto L10;
        r1 = r6;
    L10:
        r1.add(r3);
        return;
    }

    public final y0 q(String r7, com.bytedance.android.scope.j r8) {
        y0 r0 = (y0) ((LinkedHashMap) this.d).get(r7);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Iterator r1 = CollectionsKt.asSequence(((LinkedHashMap) this.c).values()).iterator();
    L7:
        if (r1.hasNext() == false) goto L20;
        Object r2 = r1.next();
        Iterator<T> r3 = ((w0) r2).a().values().iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((u) r4).a, r7) == false) goto L10;
    L15:
        if (r4 == null) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L7;
    L21:
        w0 r6 = (w0) r2;
        if (r6 != null) goto L33;
        w0 r9 = x(r7);
        if (r9 == null) goto L31;
        y0 r10 = (y0) ((LinkedHashMap) this.d).get(r7);
        if (r10 == null) goto L29;
        return r10;
    L29:
        throw w(r7, ((x0) r9).d, r8);
    L31:
        throw com.bytedance.platform.aio.d.e("it's illegal to reach here, interfaceId:" + r7, null);
    L33:
        throw w(r7, r6.b(), r8);
    L17:
        r5 = false;
        goto L18
    L14:
        r4 = null;
        goto L15
    L20:
        r2 = null;
        goto L21
    }

    public static RpcException w(String r20, Class r22, com.bytedance.android.scope.j r23) {
        cy0.e.a.getClass();
        if (Intrinsics.areEqual(r23, cy0.e.a.a) == false) goto L7;
        return com.bytedance.platform.aio.d.d(r20);
    L7:
        if (com.bytedance.android.scope.l.b(r23) == true) goto L11;
        return com.bytedance.platform.aio.d.c(r20);
    L11:
        if (a0.c.contains(JvmClassMappingKt.getKotlinClass(r22)) == false) goto L13;
        Intrinsics.checkNotNullParameter(r20, "interfaceId");
        return new RpcException("service_scope_already_stopped", "service " + r20 + " scope already stopped", com.bytedance.platform.aio.d.g(new Exception()), RpcExceptionMonitorLevel.WARNING, null, 16, null);
    L13:
        Intrinsics.checkNotNullParameter(r20, "interfaceId");
        return new RpcException("service_scope_never_entered", "service " + r20 + " scope never entered", com.bytedance.platform.aio.d.g(new Exception()), RpcExceptionMonitorLevel.ERROR, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T, R> j57.a<R> c(final String r26, final String r27, final T r28) {
        Intrinsics.checkNotNullParameter(r26, "interfaceId");
        Intrinsics.checkNotNullParameter(r27, "methodId");
        Intrinsics.checkNotNullParameter(r28, "arguments");
        v r12 = (v) r28;
        com.bytedance.android.scope.j r4 = (com.bytedance.android.scope.j) r12.e.a(i57.e.f.b());
        if (r4 != null) goto L5;
        cy0.e.a.getClass();
        r4 = cy0.e.a.a;
    L5:
        long r5 = System.currentTimeMillis();
        y0 r8 = q(r26, r4);     // Catch: Throwable -> L40
        if (k(r4, r8) == true) goto L10;
        r8 = null;
    L10:
        if (r8 == null) goto L50;
        y r1 = r8.a.c(r26, r27);
        if (r1 == null) goto L33;
        Method r9 = r1.b;
        if (r9 == null) goto L33;
        final long r17 = System.currentTimeMillis() - r5;
        final long r19 = System.currentTimeMillis();     // Catch: Throwable -> L23
        j57.a<R> r2 = s(r26, r27, r8.b, r9, (v) r28);     // Catch: Throwable -> L23
        Observable r3 = r2.a.doOnError(new a(r28, r26, r27));     // Catch: Throwable -> L23
        final Function0<Unit> r6 = new RevenueNativeServiceDriver$invokeMethod$$inlined$apply$lambda$2(r28, r26, r27, r19, r17);     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r3, "$this$doOnCompleteAndDispose");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r6, "action");     // Catch: Throwable -> L21
        r3.doOnComplete(new z0(r6)).doOnDispose(new z0(r6));     // Catch: Throwable -> L21
        return r2;
    L21:
        th = th;
    L26:
        if ((th instanceof RpcException) == true) goto L58;
        int r7 = d.a;
        d.a(r12.b, r12.c, r12.d, r26, r27, th);
        String r10 = th.getMessage();
        if (r10 != null) goto L32;
        r10 = "";
    L32:
        return com.bytedance.platform.aio.d.a(com.bytedance.platform.aio.d.b(r10, th));
    L58:
        return com.bytedance.platform.aio.d.a(th);
    L23:
        th = th;
    L33:
        Intrinsics.checkNotNullParameter(r27, "methodId");
        return com.bytedance.platform.aio.d.a(new RpcException("no_such_method", "method " + r27 + " not found", com.bytedance.platform.aio.d.g(new Exception()), RpcExceptionMonitorLevel.ERROR, null, 16, null));
    L50:
        String r0 = "current scope is: " + r4 + ", but instance scope is " + q(r26, r4).c;     // Catch: Throwable -> L38
        Intrinsics.checkNotNullParameter(r0, "message");     // Catch: Throwable -> L38
        throw new RpcException("scope_not_match", r0, MapsKt.emptyMap(), RpcExceptionMonitorLevel.INFO, null, 16, null);     // Catch: Throwable -> L38
    L38:
        th = th;
    L43:
        if ((th instanceof RpcException) == true) goto L59;
        int r13 = d.a;
        d.c(r12.b, r12.c, r12.d, r26, r27, th, "lynx", "android");
        String r14 = th.getMessage();
        if (r14 != null) goto L49;
        r14 = "";
    L49:
        return com.bytedance.platform.aio.d.a(com.bytedance.platform.aio.d.e(r14, th));
    L59:
        return com.bytedance.platform.aio.d.a(th);
    L40:
        th = th;
        goto L43
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.s
    public final void h(Object r2, Class<?> r3, com.bytedance.android.scope.j r4) {
        Intrinsics.checkNotNullParameter(r2, "serviceInstance");
        Intrinsics.checkNotNullParameter(r3, "serviceCls");
        Intrinsics.checkNotNullParameter(r4, "scope");
        w0 r0 = (w0) ((LinkedHashMap) this.c).get(r3);
        if (r0 == null) goto L5;
        y(r2, r0, r4);
        return;
    L5:
        this.e.put(r3, TuplesKt.to(r4, r2));
    }

    public final void y(Object r5, w0 r6, com.bytedance.android.scope.j r7) {
        Iterator<Map.Entry<String, u>> r0 = r6.a().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, u> r1 = r0.next();
        this.d.put(r1.getValue().a, new y0(r6, r5, r7));
        goto L4
    }

    public final <R> j57.a<R> s(String r16, String r17, final Object r18, final Method r19, v r20) {
        final ArrayList r0 = new ArrayList();
        RpcParam[][] r1 = r19.getParameterAnnotations();
        int r3 = r1.length;
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r5 >= r3) goto L23;
        int r9 = r6 + 1;
        RpcParam[] r8 = (Annotation[]) r1[r5];
        Class<?> r10 = r19.getParameterTypes()[r6];
        Type r7 = r19.getGenericParameterTypes()[r6];
        int r12 = r8.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        RpcParam r14 = r8[r13];
        if ((r14 instanceof RpcParam) == true) goto L12;
        r13 = r13 + 1;
    L12:
        if (r14 == null) goto L19;
        JsonObject r15 = r20.a.get(r14.paramName());
        if ((r15 instanceof JsonObject) == false) goto L16;
        uh7.c r22 = uh7.c.d;
        KClass r110 = JvmClassMappingKt.getKotlinClass(r10);
        r22.getClass();
        Object r23 = uh7.c.a(r15, r110, null);
    L17:
        r0.add(r23);
    L22:
        r5 = r5 + 1;
        r6 = r9;
        goto L4
    L16:
        r23 = GsonProtectorUtils.fromJson(this.a, r15, r7);
        goto L17
    L19:
        if (r10.isAssignableFrom(i57.a.class) == false) goto L21;
        r0.add(r20.e);
        goto L22
    L21:
        uh7.c r24 = uh7.c.d;
        JsonObject r25 = r20.a;
        KClass r111 = JvmClassMappingKt.getKotlinClass(r10);
        r24.getClass();
        r0.add(uh7.c.a(r25, r111, null));
        goto L22
    L11:
        r14 = null;
        goto L12
    L23:
        Function0<Object> r4 = new RevenueNativeServiceDriver$invokeNativeMethod$2(r19, r18, r0);
        if (((List) py0.a.b.getValue(null, py0.a.a[0])).contains(r16) == true) goto L30;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L30;
        return new j57.a(Observable.defer(new l0(this, r20, r4, r16, r17)).subscribeOn(AndroidSchedulers.mainThread()).flatMap(m0.a), null, 4);
    L30:
        return j(r20.d, r4.invoke());
    }
}
