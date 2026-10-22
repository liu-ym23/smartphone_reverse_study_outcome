package com.bytedance.ies.bullet.service.preload;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.ies.bullet.pool.g;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod$Access;
import com.bytedance.sdk.xbridge.cn.protocol.i;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.utils.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ym.m;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends com.bytedance.ies.bullet.core.kit.bridge.b implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rb.b f6119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6120c;
    public final ArrayList d;
    public final String e;
    public final Lazy f;
    public final ConcurrentLinkedQueue g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f6121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final IBridgeMethod$Access f6122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f6123j;

    public f(rb.b r5) {
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        super(r5);
        this.f6119b = r5;
        this.f6120c = 10;
        this.d = new ArrayList();
        com.bytedance.ies.bullet.core.container.e r10 = (com.bytedance.ies.bullet.core.container.e) r5.a(com.bytedance.ies.bullet.core.container.e.class);
        if (r10 == null) goto L5;
        com.bytedance.ies.bullet.core.e r11 = r10.getBulletContext();
    L6:
        if (r11 == null) goto L9;
        String r12 = r11.f;
        if (r12 == null) goto L9;
    L10:
        this.e = r12;
        this.f = LazyKt.lazy(new WebPreloadBridge$preRenderService$2(this));
        this.g = new ConcurrentLinkedQueue();
        this.f6121h = LazyKt.lazy(WebPreloadBridge$isJSBReleaseCacheEnable$2.f6107a);
        this.f6122i = IBridgeMethod$Access.f5959a;
        this.f6123j = "bullet.preload";
        return;
    L9:
        r12 = "default_bid";
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final void a(JSONObject r14, sc.a r15) {
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r15, "callback");
        String r5 = r14.optString("schema");
        String r10 = r14.optString("strategy");
        if (r10 != null) goto L5;
    L32:
        WebPreloadBridge$Strategy r11 = WebPreloadBridge$Strategy.f6104a;
    L33:
        int r16 = r14.optInt("availableMemoryThreshold");
        rb.b r12 = this.f5335a;
        if (r12 == null) goto L36;
        Context r13 = (Context) r12.a(Context.class);
    L37:
        if (r13 != null) goto L39;
        long r17 = -1;
    L41:
        if (r17 <= r16) goto L43;
        boolean r18 = true;
    L44:
        rb.b r19 = this.f5335a;
        if (r19 == null) goto L47;
        Context r20 = (Context) r19.a(Context.class);
    L48:
        if (r18 == false) goto L93;
        if (r20 == null) goto L93;
        Uri r21 = Uri.parse(r5);
        boolean r110 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "Start Preload for schema " + r21, "XPreload");
        String r111 = m.f(r21, "view_cache_time");
        if (r111 == null) goto L54;
        long r22 = Long.parseLong(r111);
    L53:
        long r112 = r22;
        int r113 = r11.ordinal();
        if (r113 == 0) goto L91;
        if (r113 == 1) goto L66;
        if (r113 != 2) goto L60;
        e r114 = new e(this, r20, r21, r112, r15);
        this.d.add(r114);
        Looper.myQueue().addIdleHandler(r114);
        return;
    L60:
        if (r113 != 3) goto L98;
        h(r20, r21, r112, r15);
        return;
    L98:
        return;
    L66:
        i(r20, r15);
        com.bytedance.ies.bullet.service.base.b.a(2, "Start PreConnect", "XPreload");
        String r115 = r21.toString();
        pk.a r116 = pk.a.f21358a;
        Intrinsics.checkNotNullParameter(r115, "url");
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L81
        monitor-enter(r116);     // Catch: Throwable -> L81
    L74:
        th = move-exception;
        throw th;     // Catch: Throwable -> L81
    L70:
        if (pk.a.f21360c != null) goto L78;
        Class r118 = pk.a.f21359b;     // Catch: Throwable -> L74
        if (r118 == null) goto L76;
        Method r119 = r118.getMethod("preconnectUrl", new Class[]{String.class, Integer.TYPE});     // Catch: Throwable -> L74
    L77:
        pk.a.f21360c = r119;     // Catch: Throwable -> L74
        goto L78
    L76:
        r119 = null;
    L78:
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L74
        monitor-exit(r116);     // Catch: Throwable -> L81
        Method r121 = pk.a.f21360c;     // Catch: Throwable -> L81
        Intrinsics.checkNotNull(r121);     // Catch: Throwable -> L81
        Object r122 = Result.m124constructorimpl(r121.invoke(null, new Object[]{r115, 1}));     // Catch: Throwable -> L81
    L86:
        Throwable r123 = Result.m127exceptionOrNullimpl(r122);
        if (r123 != null) goto L90;
        return;
    L90:
        throw new InvocationTargetException(r123);
    L81:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r122 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L86
    L91:
        i(r20, r15);
        return;
    L54:
        r22 = this.f6120c;
    L93:
        JSONObject r125 = new JSONObject();
        r125.put("code", -1);
        JSONObject r23 = new JSONObject();
        r23.put("message", "memory is not allowed");
        r23.put("result", false);
        Unit r126 = Unit.INSTANCE;
        r125.put("data", r23);
        r15.a(r125);
        return;
    L47:
        r20 = null;
        goto L48
    L43:
        r18 = false;
        goto L44
    L39:
        ActivityManager.MemoryInfo r24 = new ActivityManager.MemoryInfo();
        Object r25 = r13.getSystemService("activity");
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) r25).getMemoryInfo(r24);
        r17 = r24.availMem / ((long) 1048576);
        goto L41
    L36:
        r13 = null;
        goto L37
    L5:
        if (r10.length() == 0) goto L32;
        int r26 = r10.hashCode();
        if (r26 == (-2001951915)) goto L29;
        if (r26 == (-1607411300)) goto L25;
        if (r26 == (-1085510111)) goto L21;
        if (r26 == 1503977306) goto L17;
    L30:
        r11 = WebPreloadBridge$Strategy.f6104a;
        goto L33
    L17:
        if (r10.equals("PreconnectSocket") == false) goto L30;
        r11 = WebPreloadBridge$Strategy.f6105b;
        goto L33
    L21:
        if (r10.equals("Default") == false) goto L30;
        r11 = WebPreloadBridge$Strategy.f6104a;
        goto L33
    L25:
        if (r10.equals("PreloadOnIdle") == false) goto L30;
        r11 = WebPreloadBridge$Strategy.f6106c;
        goto L33
    L29:
        if (r10.equals("PreloadImmediately") == false) goto L30;
        r11 = WebPreloadBridge$Strategy.d;
        goto L33
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final IBridgeMethod$Access f() {
        return this.f6122i;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final String g() {
        return this.f6123j;
    }

    public final void h(Context r10, Uri r11, long r12, sc.a r14) {
        if (((Boolean) this.f6121h.getValue()).booleanValue() == false) goto L7;
        String r5 = m.f(r11, "view_cache_key");
        if (r5 == null) goto L7;
        this.g.add(r5);
    L7:
        Lazy r13 = this.f;
        g r15 = (g) r13.getValue();
        if (r15 == null) goto L11;
        long r16 = r12 * ((long) 1000);
        p r17 = new p(4, this, r14);
        Intrinsics.checkNotNullParameter(r11, "schema");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r17, "callback");
        boolean r18 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "start to preRender on schema: " + r11 + ", duration: " + r16, "XPreRender");
        r15.b(r11, r10, r16, r17, new com.bytedance.ies.bullet.pool.b(r10, r15.f5811a, r11));
    L11:
        if (((g) r13.getValue()) != null) goto L15;
        if (r14 == null) goto L16;
        r14.onError(-1, "poolservice = null");
        return;
    L16:
        return;
    }

    public final void i(Context r5, sc.a r10) {
        ConcurrentHashMap r11 = yc.a.f23246a;
        c r12 = (c) yc.a.a(c.class, this.e);
        if (r12 != null) goto L6;
        com.bytedance.ies.bullet.service.base.b.a(2, "Preload fail, PreCreate service = null", "XPreload");
        r10.onError(-1, "Preload Fail, PreCreate service = null");
        return;
    L6:
        com.bytedance.ies.bullet.service.base.b.a(2, "Start PreCreate", "XPreload");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.webkit.c.class, "clazz");
        tc.c r13 = tc.c.f22119c;
        com.bytedance.ies.bullet.service.webkit.c r14 = (com.bytedance.ies.bullet.service.webkit.c) tc.c.f22119c.a(com.bytedance.ies.bullet.service.webkit.c.class, r12.f22117a);
        if (r14 == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "application");
        r14.d(r5, r14.d);
    L9:
        z4.a r15 = k.f11181a;
        if (r15 == null) goto L12;
        r15.b(1);
    L12:
        JSONObject r16 = new JSONObject();
        r16.put("code", 1);
        JSONObject r17 = new JSONObject();
        r17.put("message", "Preload Success");
        r17.put("result", true);
        Unit r18 = Unit.INSTANCE;
        r16.put("data", r17);
        r10.a(r16);
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b, com.bytedance.ies.bullet.service.base.m
    public final void release() {
        ArrayList r5 = this.d;
        if (r5.isEmpty() == true) goto L9;
        Iterator r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        MessageQueue.IdleHandler r11 = (MessageQueue.IdleHandler) r10.next();
        com.bytedance.ies.bullet.service.base.b.a(2, "===remove pendingPrerenderTask====", "XPreload");
        Looper.myQueue().removeIdleHandler(r11);
        goto L6
    L8:
        r5.clear();
    L9:
        ConcurrentLinkedQueue r12 = this.g;
        if (r12.isEmpty() == false) goto L12;
        return;
    L12:
        if (((Boolean) this.f6121h.getValue()).booleanValue() == false) goto L30;
        com.bytedance.ies.bullet.service.base.b.a(2, "===remove cacheKeys and cache====", "XPreload");
        g r13 = (g) this.f.getValue();
        if (r13 == null) goto L21;
        HashSet r14 = CollectionsKt.F(r12);
        Intrinsics.checkNotNullParameter(r14, "cacheKeys");
        Iterator r15 = r14.iterator();
    L17:
        if (r15.hasNext() == false) goto L21;
        String r16 = (String) r15.next();
        com.bytedance.ies.bullet.pool.d r17 = (com.bytedance.ies.bullet.pool.d) r13.f5813c.get(r13.f5811a);
        if (r17 == null) goto L17;
        Intrinsics.checkNotNullParameter(r16, "cacheKey");
        com.bytedance.ies.bullet.pool.impl.a r18 = r17.f5806b;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r16, "uniqueSchema");
        r18.f5817a.f(r16);
    L21:
        r12.clear();
        return;
    }
}
