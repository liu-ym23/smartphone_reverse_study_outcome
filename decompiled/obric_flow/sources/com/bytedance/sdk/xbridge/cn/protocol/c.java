package com.bytedance.sdk.xbridge.cn.protocol;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthErrorCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthMode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthPriority;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.e1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements kj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f7454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f7455c;
    public final Lazy d;
    public final LinkedHashMap e;
    public final Lazy f;
    public final ym.g g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public cj.a f7456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f7457i;

    public c(Context r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "containerId");
        this.f7453a = r5;
        this.f7454b = LazyKt.lazy(BDXBridge$authManager$2.f7424a);
        this.f7455c = LazyKt.lazy(BDXBridge$internalMethodFinder$2.f7432a);
        this.d = LazyKt.lazy(new BDXBridge$methodFinders$2(this));
        this.e = new LinkedHashMap();
        this.f = LazyKt.lazy(BDXBridge$unSupportMethod$2.f7437a);
        ym.g r11 = new ym.g();
        r11.f23298a = true;
        this.g = r11;
    }

    public static void f(bj.a r5, li.c r10, IDLXBridgeMethod r11) {
        r5.s = r10.f19640a;
        AuthErrorCode r12 = r10.d;
        if (r12 != null) goto L5;
        r12 = AuthErrorCode.f7311k;
    L5:
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r5.f947u = r10.f;
        r5.f945r = r10.f19646k;
        AuthErrorCode r13 = r10.d;
        if (r13 == null) goto L8;
        int r14 = r13.f7315a;
    L12:
        r5.f950x = r14;
        String r15 = r10.f19645j;
        if (r15 != null) goto L15;
        r15 = "0";
    L15:
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r5.f942o = r15;
        Intrinsics.checkNotNullParameter("0", "<set-?>");
        r5.f943p = "0";
        AuthBridgeAccess r16 = r10.g;
        if (r16 == null) goto L18;
        String r17 = r16.f7303a;
    L19:
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r5.f951y = r17;
        AuthMode r18 = r10.f19647l;
        String r19 = "unset";
        if (r18 == null) goto L22;
        String r20 = r18.f7319a;
    L23:
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r5.B = r20;
        r5.f952z = r10.f19643h.f7333a;
        Intrinsics.checkNotNullParameter("0", "<set-?>");
        r5.C = "0";
        AuthBridgeAccess r21 = r10.f19644i;
        if (r21 == null) goto L26;
        r19 = r21.f7303a;
    L26:
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r5.A = r19;
        r5.E = r10.f19648m;
        r5.G = true;
        return;
    L22:
        r20 = "unset";
        goto L23
    L18:
        r17 = r11.getAccess().f7466a;
        goto L19
    L8:
        AuthSuccessCode r22 = r10.e;
        if (r22 == null) goto L11;
        r14 = r22.f7325a;
        goto L12
    L11:
        r14 = 0;
        goto L12
    }

    public abstract f a();

    public abstract IDLXBridgeMethod.XBridgeThreadType b(bj.a r5);

    public final IDLXBridgeMethod c(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "bizId");
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        if (((HashSet) this.f.getValue()).contains(r10) == false) goto L5;
        return null;
    L5:
        IDLXBridgeMethod r12 = k.f7462c.a(r5, r10);
        if (r12 == null) goto L8;
        return r12;
    L8:
        Iterator r13 = ((List) this.d.getValue()).iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        IDLXBridgeMethod r14 = ((h) r13.next()).a(r5, r10);
        if (r14 == null) goto L10;
        return r14;
    L14:
        return null;
    }

    public final void d(aj.a r5, AuthPriority r10) {
        Intrinsics.checkNotNullParameter(r5, "authenticator");
        Intrinsics.checkNotNullParameter(r10, "priority");
        aj.d r11 = (aj.d) this.f7454b.getValue();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "authenticator");
        Intrinsics.checkNotNullParameter(r10, "priority");
        int r12 = aj.c.f311a[r10.ordinal()];
        CopyOnWriteArrayList r13 = r11.f312a;
        if (r12 != 1) goto L5;
        r13.add(0, r5);
        return;
    L5:
        r13.add(r5);
    }

    public void e(bj.a r5, li.c r10) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r10, "authResult");
    }

    public final void g(h r5) {
        Intrinsics.checkNotNullParameter(r5, "finder");
        ((List) this.d.getValue()).add(r5);
    }

    public final void h(IDLXBridgeMethod r5) {
        Intrinsics.checkNotNullParameter(r5, "method");
        h r10 = (h) this.f7455c.getValue();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "method");
        if ((r5 instanceof i) == true) goto L6;
        Log.w("BDXBridge", "非stateful的bridge无法动态注册: " + r5.getName());
        return;
    L6:
        ((j) r10.f7461b.getValue()).b("", r5);
    }

    public final void i(Class r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        cj.a r11 = this.f7456h;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("containerContext");
        r11 = null;
    L5:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "clazz");
        r11.d.put(r5, new cj.c(r10));
    }

    public boolean j(bj.a r5, e r10) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r10, "callback");
        return false;
    }

    public abstract d k();

    public final void l(final bj.a r19, final e r20) {
        Intrinsics.checkNotNullParameter(r19, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r20, "callback");
        cj.a r5 = this.f7456h;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("containerContext");
        r5 = null;
    L5:
        final cj.b r10 = new cj.b(r5, r19);
        r20.f7459b = r10.f1190b;
        if (j(r19, r20) == false) goto L9;
        return;
    L9:
        if (r19.d.length() != 0) goto L14;
        cj.a r11 = this.f7456h;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("containerContext");
        r11 = null;
    L13:
        String r12 = r11.f1188c;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r19.d = r12;
    L14:
        s6.c r13 = (s6.c) ki.a.d.f5321c;
        if (r13 == null) goto L17;
        Boolean r14 = Boolean.valueOf(r13.k(r19, r10, r20));
    L18:
        Boolean r15 = Boolean.TRUE;
        if (Intrinsics.areEqual(r14, r15) == false) goto L21;
        return;
    L21:
        String r16 = r19.f932a;
        final IDLXBridgeMethod r17 = c(r19.d, r16, r10.f1190b);
        final Object r18 = r19.b();
        com.bytedance.sdk.xbridge.cn.utils.c r110 = new com.bytedance.sdk.xbridge.cn.utils.c();
        String r111 = r10.f1190b;
        Intrinsics.checkNotNullParameter("bulletSession", "name");
        Intrinsics.checkNotNullParameter(r111, "sessionId");
        r110.f7501a.add(new com.bytedance.sdk.xbridge.cn.utils.d("bulletSession", r111));
        String r21 = r19.f934c;
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r21, "sessionId");
        r110.f7501a.add(new com.bytedance.sdk.xbridge.cn.utils.d("callId", r21));
        if (r17 != null) goto L25;
        Lazy r112 = com.bytedance.sdk.xbridge.cn.utils.e.f7504a;
        StringBuilder r113 = new StringBuilder("BDXBridge findMethod namespace: ");
        f8.b.e(r113, r19.d, " methodName: ", r16, " instance: ");
        r113.append(r17);
        com.bytedance.sdk.xbridge.cn.utils.e.a(r113.toString(), "BridgePrepare", MapsKt.mapOf(new Pair[]{TuplesKt.to("methodName", r16), TuplesKt.to("findMethod", Boolean.FALSE), TuplesKt.to("callId", r19.f934c)}), r110);
    L25:
        boolean r114 = true;
        if (r17 != null) goto L41;
        r19.s = true;
        r19.f950x = 3;
        Intrinsics.checkNotNullParameter("JSB method not found, return early without JSB auth.", "<set-?>");
        ConcurrentHashMap r22 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r23 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r23 == null) goto L34;
        xc.d r24 = (xc.d) r23.a(xc.d.class);
        if (r24 == null) goto L34;
        Boolean r25 = r24.s();
        if (r25 == null) goto L34;
        r114 = r25.booleanValue();
    L34:
        if (r114 == true) goto L36;
    L39:
        r20.c(k().c(r19, -2, "The JSBridge method is not found, please register"));
        return;
    L36:
        if (this.f7457i == false) goto L39;
        r20.c(k().c(r19, -12, "The JSBridge method is not found, and the container has been destroyed. Please check the timing of the call."));
        return;
    L41:
        r19.f948v = System.currentTimeMillis();
        li.c r26 = ((aj.d) this.f7454b.getValue()).a(r19, r17);
        r19.f949w = System.currentTimeMillis();
        if (r26.f19640a == true) goto L44;
        Lazy r27 = com.bytedance.sdk.xbridge.cn.utils.e.f7504a;
        com.bytedance.sdk.xbridge.cn.utils.e.a(td.d.b("auth to call JsBridge method ", r16), "BridgePrepare", MapsKt.mapOf(new Pair[]{TuplesKt.to("bridge auth", Boolean.valueOf(r26.f19640a)), TuplesKt.to("methodName", r16)}), r110);
    L44:
        f(r19, r26, r17);
        LinkedHashMap r28 = r19.H;
        Lazy r29 = com.bytedance.sdk.xbridge.cn.optimize.b.f7355a;
        Intrinsics.checkNotNullParameter("loki_jsb_log_drop_switch", STGroup.DICT_KEY);
        r28.put("loki_jsb_log_drop_switch", Boolean.valueOf(Intrinsics.areEqual(this.e.get("loki_jsb_log_drop_switch"), r15)));
        LinkedHashMap r30 = r19.H;
        Intrinsics.checkNotNullParameter("xbridge_model_proxy_enhancement", STGroup.DICT_KEY);
        r30.put("xbridge_model_proxy_enhancement", Boolean.valueOf(Intrinsics.areEqual(this.e.get("xbridge_model_proxy_enhancement"), r15)));
        if (r26.f19640a == true) goto L48;
        r20.c(k().c(r19, r19.f938k, r19.f939l));
        return;
    L48:
        Set r31 = com.bytedance.sdk.xbridge.cn.auth.h.f7346a;
        cj.a r32 = this.f7456h;
        if (r32 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("containerContext");
        r32 = null;
    L51:
        com.bytedance.sdk.xbridge.cn.auth.h.a(r32, r19);
        boolean r33 = this.g.f23298a;
        r19.f941n = b(r19);
        r19.f935h = Long.valueOf(System.currentTimeMillis());
        boolean r34 = r17.canRunInBackground();
        Function0<Unit> r35 = new BDXBridge$handleCall$handleMethod$1(r19, r10, this, r18, r17, r20);
        IDLXBridgeMethod.XBridgeThreadType r36 = r19.f941n;
        if (r36 != null) goto L54;
        int r37 = -1;
    L55:
        if (r37 != 1) goto L57;
        r35.invoke();
        return;
    L57:
        if (r37 != 2) goto L59;
        BuildersKt.launch$default(GlobalScope.INSTANCE, new e1((ThreadPoolExecutor) com.bytedance.sdk.xbridge.cn.optimize.b.f7355a.getValue()), null, new BDXBridge$handleCall$2(r35, null), 2, null);
        return;
    L59:
        if (r37 == 3) goto L77;
        if (r37 == 4) goto L68;
        if (r34 == true) goto L65;
        ExecutorService r38 = com.bytedance.sdk.xbridge.cn.utils.b.f7499a;
        com.bytedance.android.monitorV2.executor.a r39 = new com.bytedance.android.monitorV2.executor.a(5, r35);
        Intrinsics.checkNotNullParameter(r39, "runnable");
        ((Handler) com.bytedance.sdk.xbridge.cn.utils.b.f7500b.getValue()).post(r39);
        return;
    L65:
        r35.invoke();
        return;
    L68:
        if (com.bytedance.sdk.xbridge.cn.utils.b.a() == false) goto L71;
        r35.invoke();
        return;
    L71:
        if (r34 == true) goto L74;
        com.bytedance.android.monitorV2.executor.a r40 = new com.bytedance.android.monitorV2.executor.a(4, r35);
        Intrinsics.checkNotNullParameter(r40, "runnable");
        ((Handler) com.bytedance.sdk.xbridge.cn.utils.b.f7500b.getValue()).post(r40);
        return;
    L74:
        r35.invoke();
        return;
    L77:
        if (com.bytedance.sdk.xbridge.cn.utils.b.a() == false) goto L80;
        r35.invoke();
        return;
    L80:
        com.bytedance.android.monitorV2.executor.a r41 = new com.bytedance.android.monitorV2.executor.a(3, r35);
        Intrinsics.checkNotNullParameter(r41, "runnable");
        ((Handler) com.bytedance.sdk.xbridge.cn.utils.b.f7500b.getValue()).post(r41);
        return;
    L54:
        r37 = a.f7441a[r36.ordinal()];
        goto L55
    L17:
        r14 = null;
        goto L18
    }

    public final void m(bj.a r10, e r11) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "callback");
        IDLXBridgeMethod.XBridgeThreadType r5 = b(r10);
        r10.f941n = r5;
        if (r5 != null) goto L5;
        int r12 = -1;
    L6:
        if (r12 != 1) goto L8;
        p(r10, r11);
        return;
    L8:
        if (r12 != 2) goto L10;
        BuildersKt.launch$default(GlobalScope.INSTANCE, new e1((ThreadPoolExecutor) com.bytedance.sdk.xbridge.cn.optimize.b.f7355a.getValue()), null, new BDXBridge$handleCallV2$1(this, r10, r11, null), 2, null);
        return;
    L10:
        if (r12 == 3) goto L18;
        Lazy r13 = com.bytedance.sdk.xbridge.cn.optimize.b.f7355a;
        Intrinsics.checkNotNullParameter("can_run_in_background_fix", STGroup.DICT_KEY);
        if (Intrinsics.areEqual(this.e.get("can_run_in_background_fix"), Boolean.FALSE) == false) goto L15;
        ExecutorService r14 = com.bytedance.sdk.xbridge.cn.utils.b.f7499a;
        b r15 = new b(this, r10, r11, 1);
        Intrinsics.checkNotNullParameter(r15, "runnable");
        ((Handler) com.bytedance.sdk.xbridge.cn.utils.b.f7500b.getValue()).post(r15);
        return;
    L15:
        p(r10, r11);
        return;
    L18:
        if (com.bytedance.sdk.xbridge.cn.utils.b.a() == false) goto L21;
        p(r10, r11);
        return;
    L21:
        b r16 = new b(this, r10, r11, 0);
        Intrinsics.checkNotNullParameter(r16, "runnable");
        ((Handler) com.bytedance.sdk.xbridge.cn.utils.b.f7500b.getValue()).post(r16);
        return;
    L5:
        r12 = a.f7441a[r5.ordinal()];
        goto L6
    }

    public boolean n() {
        return false;
    }

    public final void o() {
        Iterator r5 = ((List) this.d.getValue()).iterator();
    L4:
        if (r5.hasNext() == false) goto L17;
        j r10 = (j) ((h) r5.next()).f7461b.getValue();
        ConcurrentHashMap r11 = r10.f7476b;
        if (r11.isEmpty() == true) goto L16;
        Iterator r12 = r11.entrySet().iterator();
    L9:
        if (r12.hasNext() == false) goto L16;
        Iterator r13 = ((Map) ((Map.Entry) r12.next()).getValue()).entrySet().iterator();
    L12:
        if (r13.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r13.next();
        if ((r14.getValue() instanceof i) == false) goto L12;
        Object r15 = r14.getValue();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod");
        ((i) r15).release();
    L16:
        r10.f7476b.clear();
        goto L4
    L17:
        cj.a r16 = this.f7456h;
        if (r16 == null) goto L20;
        r16.d();
    L20:
        q();
        this.f7457i = true;
    }

    public final void p(final bj.a r19, final e r20) {
        cj.a r5 = this.f7456h;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("containerContext");
        r5 = null;
    L5:
        final cj.b r10 = new cj.b(r5, r19);
        r20.f7459b = r10.f1190b;
        if (j(r19, r20) == false) goto L9;
        return;
    L9:
        if (r19.d.length() != 0) goto L14;
        cj.a r11 = this.f7456h;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("containerContext");
        r11 = null;
    L13:
        String r12 = r11.f1188c;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r19.d = r12;
    L14:
        s6.c r13 = (s6.c) ki.a.d.f5321c;
        if (r13 == null) goto L17;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<kotlin.Any>");
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback<kotlin.Any>");
        Boolean r14 = Boolean.valueOf(r13.k(r19, r10, r20));
    L18:
        Boolean r15 = Boolean.TRUE;
        if (Intrinsics.areEqual(r14, r15) == false) goto L21;
        return;
    L21:
        String r16 = r19.f932a;
        final IDLXBridgeMethod r17 = c(r19.d, r16, r10.f1190b);
        final Object r18 = r19.b();
        com.bytedance.sdk.xbridge.cn.utils.c r110 = new com.bytedance.sdk.xbridge.cn.utils.c();
        String r111 = r10.f1190b;
        Intrinsics.checkNotNullParameter("bulletSession", "name");
        Intrinsics.checkNotNullParameter(r111, "sessionId");
        r110.f7501a.add(new com.bytedance.sdk.xbridge.cn.utils.d("bulletSession", r111));
        String r21 = r19.f934c;
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r21, "sessionId");
        r110.f7501a.add(new com.bytedance.sdk.xbridge.cn.utils.d("callId", r21));
        if (r17 != null) goto L25;
        Lazy r112 = com.bytedance.sdk.xbridge.cn.utils.e.f7504a;
        StringBuilder r113 = new StringBuilder("BDXBridge findMethod namespace: ");
        f8.b.e(r113, r19.d, " methodName: ", r16, " instance: ");
        r113.append(r17);
        com.bytedance.sdk.xbridge.cn.utils.e.a(r113.toString(), "BridgePrepare", MapsKt.mapOf(new Pair[]{TuplesKt.to("methodName", r16), TuplesKt.to("findMethod", Boolean.FALSE), TuplesKt.to("callId", r19.f934c)}), r110);
    L25:
        if (r17 != null) goto L40;
        boolean r22 = true;
        r19.s = true;
        r19.f950x = 3;
        Intrinsics.checkNotNullParameter("JSB method not found, return early without JSB auth.", "<set-?>");
        ConcurrentHashMap r23 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r24 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r24 == null) goto L33;
        xc.d r25 = (xc.d) r24.a(xc.d.class);
        if (r25 == null) goto L33;
        Boolean r26 = r25.s();
        if (r26 == null) goto L33;
        r22 = r26.booleanValue();
    L33:
        if (r22 == true) goto L35;
    L38:
        r20.c(k().c(r19, -2, "The JSBridge method is not found, please register"));
        return;
    L35:
        if (this.f7457i == false) goto L38;
        r20.c(k().c(r19, -12, "The JSBridge method is not found, and the container has been destroyed. Please check the timing of the call."));
        return;
    L40:
        r19.f948v = System.currentTimeMillis();
        li.c r27 = ((aj.d) this.f7454b.getValue()).a(r19, r17);
        e(r19, r27);
        r19.f949w = System.currentTimeMillis();
        if (r27.f19640a == true) goto L43;
        Lazy r28 = com.bytedance.sdk.xbridge.cn.utils.e.f7504a;
        com.bytedance.sdk.xbridge.cn.utils.e.a(td.d.b("auth to call JsBridge method ", r16), "BridgePrepare", MapsKt.mapOf(new Pair[]{TuplesKt.to("bridge auth", Boolean.valueOf(r27.f19640a)), TuplesKt.to("methodName", r16)}), r110);
    L43:
        f(r19, r27, r17);
        LinkedHashMap r29 = r19.H;
        Lazy r30 = com.bytedance.sdk.xbridge.cn.optimize.b.f7355a;
        Intrinsics.checkNotNullParameter("loki_jsb_log_drop_switch", STGroup.DICT_KEY);
        r29.put("loki_jsb_log_drop_switch", Boolean.valueOf(Intrinsics.areEqual(this.e.get("loki_jsb_log_drop_switch"), r15)));
        LinkedHashMap r31 = r19.H;
        Intrinsics.checkNotNullParameter("xbridge_model_proxy_enhancement", STGroup.DICT_KEY);
        r31.put("xbridge_model_proxy_enhancement", Boolean.valueOf(Intrinsics.areEqual(this.e.get("xbridge_model_proxy_enhancement"), r15)));
        if (r27.f19640a == true) goto L47;
        r20.c(k().c(r19, r19.f938k, r19.f939l));
        return;
    L47:
        boolean r32 = this.g.f23298a;
        Set r33 = com.bytedance.sdk.xbridge.cn.auth.h.f7346a;
        cj.a r34 = this.f7456h;
        if (r34 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("containerContext");
        cj.a r35 = null;
    L51:
        com.bytedance.sdk.xbridge.cn.auth.h.a(r35, r19);
        r19.f941n = b(r19);
        r19.f935h = Long.valueOf(System.currentTimeMillis());
        boolean r114 = r17.canRunInBackground();
        Function0<Unit> r115 = new BDXBridge$realHandleCall$handleMethod$1(r19, r10, this, r18, r17, r20);
        Intrinsics.checkNotNullParameter("can_run_in_background_fix", STGroup.DICT_KEY);
        if (Intrinsics.areEqual(this.e.get("can_run_in_background_fix"), Boolean.FALSE) == false) goto L54;
    L61:
        r115.invoke();
        return;
    L54:
        if (r19.f941n != null) goto L61;
        if (r114 == true) goto L59;
        ExecutorService r36 = com.bytedance.sdk.xbridge.cn.utils.b.f7499a;
        com.bytedance.android.monitorV2.executor.a r37 = new com.bytedance.android.monitorV2.executor.a(6, r115);
        Intrinsics.checkNotNullParameter(r37, "runnable");
        ((Handler) com.bytedance.sdk.xbridge.cn.utils.b.f7500b.getValue()).post(r37);
        return;
    L59:
        r115.invoke();
        return;
    L50:
        r35 = r34;
        goto L51
    L17:
        r14 = null;
        goto L18
    }

    public abstract void q();

    public final void r() {
        if (n() == false) goto L11;
        monitor-enter(this);
        o();     // Catch: Throwable -> L8
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        o();
    }
}
