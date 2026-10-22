package com.bytedance.ai.lynx;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.LruCache;
import android.view.View;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxEnv;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q {
    public static final q a = null;
    public static final Map<String, Object> b = null;
    public static final ConcurrentHashMap<String, Map<String, Object>> c = null;
    public static final LruCache<String, Map<String, Object>> d = null;

    public q() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        d.evictAll();     // Catch: Throwable -> L6
        c.clear();     // Catch: Throwable -> L6
        ((LinkedHashMap) b).clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        a = new q();
        b = new LinkedHashMap();
        c = new ConcurrentHashMap();
        d = new LruCache(1024);
    }

    public static Map b() {
        h2.a r0 = f2.b.c;
        if (r0 == null) goto L9;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("channel", r0.h);
        r1.put("aid", Integer.valueOf(r0.d));
        r1.put(BdpAwemeConstant.KEY_APP_NAME, r0.c);
        r1.put("appVersion", r0.e);
        r1.put("updateVersionCode", r0.i);
        String r10 = r0.b;
        if (r10 != null) goto L7;
        r10 = "";
    L7:
        r1.put("deviceId", r10);
        r1.put("isOversea", Boolean.valueOf(r0.j));
        return r1;
    L9:
        return new LinkedHashMap();
    }

    public static Map e() {
        Map<String, Object> r0 = b;
        if ((!r0.isEmpty()) == false) goto L5;
        return r0;
    L5:
        h2.a r1 = f2.b.c;
        if (r1 == null) goto L8;
        Context r10 = r1.a;
    L9:
        if (r10 == null) goto L11;
        LinkedHashMap r11 = new LinkedHashMap();
        String r12 = Build.MODEL;
        r11.put("deviceModel", r12);
        r11.put("os", "android");
        r11.put("osVersion", Build.VERSION.RELEASE);
        IIvyLynxRuntimeService.Companion r13 = IIvyLynxRuntimeService.a;
        r11.put("language", r13.getLanguage());
        r11.put("deviceBrand", Build.BRAND);
        r11.put("density", Float.valueOf(r13.c(r10)));
        r11.put("deviceType", r12);
        r11.put("useXBridge3", Boolean.TRUE);
        r11.put("usePiperData", Boolean.FALSE);
        r0.putAll(r11);
    L11:
        return r0;
    L8:
        r10 = null;
        goto L9
    }

    public static Map c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        String r0 = String.valueOf(r10);
        if (f2.b.a() == false) goto L19;
        ConcurrentHashMap<String, Map<String, Object>> r1 = c;
        Map<String, Object> r11 = r1.get(r0);
        if (r11 != null) goto L17;
        q r12 = a;
        monitor-enter(r12);
        LinkedHashMap r13 = new LinkedHashMap();     // Catch: Throwable -> L13
        com.bytedance.ai.utils.g.a.i("AppletLynxView", "getCommonGlobalProps withoutCache");     // Catch: Throwable -> L13
        r13.putAll(e());     // Catch: Throwable -> L13
        r13.putAll(b());     // Catch: Throwable -> L13
        r13.putAll(d(r10));     // Catch: Throwable -> L13
        LinkedHashMap r14 = new LinkedHashMap();     // Catch: Throwable -> L13
        r14.put("lynxSdkVersion", LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L13
        r13.putAll(r14);     // Catch: Throwable -> L13
        monitor-exit(r12);
        r11 = r1.putIfAbsent(r0, r13);
        if (r11 != null) goto L17;
        r11 = r13;
    L13:
        th = move-exception;
        throw th;
    L17:
        return r11;
    L19:
        return new LinkedHashMap();
    }

    public static Map d(String r10) {
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        r0.i("AppletLynxView", "getCommonPageProps by provider bid:" + r10);
        LinkedHashMap r11 = new LinkedHashMap();
        h2.a r12 = f2.b.c;
        if (r12 == null) goto L26;
        Context r13 = r12.a;
        if (r13 == null) goto L26;
        IIvyLynxRuntimeService.Companion r14 = IIvyLynxRuntimeService.a;
        r11.putAll(r14.a(r13));
        Pair r15 = r14.b(r13);
        int r16 = 0;
        if (r15 == null) goto L9;
        int r17 = ((Number) r15.getFirst()).intValue();
    L10:
        if (r15 == null) goto L12;
        int r18 = ((Number) r15.getSecond()).intValue();
    L13:
        int r19 = com.bytedance.ai.utils.o.a;
        int r20 = com.bytedance.ai.utils.o.d(s4.a.b(r13, false), r13);
        if (r13.getResources().getConfiguration().orientation != 2) goto L16;
        r16 = 1;
    L16:
        if (r17 == 0) goto L18;
        if (r18 == 0) goto L18;
    L23:
        int r21 = com.bytedance.ai.utils.o.d(r17, r13);
        int r22 = com.bytedance.ai.utils.o.d(r18, r13);
        r11.put("screenWidth", Integer.valueOf(r21));
        r11.put("screenHeight", Integer.valueOf(r22));
        r11.put("screenWidthPx", Integer.valueOf(r17));
        r11.put("screenHeightPx", Integer.valueOf(r18));
        r11.put("statusBarHeight", Integer.valueOf(r20));
        r11.put("topHeight", Integer.valueOf(r20));
        r11.put("isLandscape", Integer.valueOf(r16));
        r11.put("appTheme", t2.a.a(r13));
        if (r17 != 0) goto L26;
        r0.e("AppletLynxView", "getScreenWidth exp, is by application");
    L18:
        r0.i("AppletLynxView", "getScreenSize by application exp width:" + r17 + ", height: " + r18);
        s4.f r23 = s4.f.a;
        int r24 = s4.f.b(r13);
        int r25 = s4.f.a(r13);
        if (r16 == 0) goto L21;
        int r26 = Math.max(r24, r25);
        r18 = Math.min(r24, r25);
    L22:
        r17 = r26;
        goto L23
    L21:
        r26 = Math.min(r24, r25);
        r18 = Math.max(r24, r25);
        goto L22
    L12:
        r18 = 0;
        goto L13
    L9:
        r17 = 0;
    L26:
        return r11;
    }

    public static Map f(Context r17) {
        if (r17 != null) goto L6;
    L15:
        Activity r0 = null;
    L17:
        if (r0 == null) goto L60;
        com.bytedance.ai.utils.g r1 = com.bytedance.ai.utils.g.a;
        r1.d("AppletLynxView", "===getPageGlobalPropsByActivity: " + r0.hashCode());
        StringBuilder r10 = new StringBuilder();
        r10.append(r0.hashCode());
        r10.append('_');
        int r11 = 1;
        boolean r12 = true;
        if (r0.getResources().getConfiguration().orientation != 2) goto L21;
        boolean r13 = true;
    L22:
        r10.append(r13);
        String r14 = r10.toString();
        LruCache<String, Map<String, Object>> r15 = d;
        if (r15.get(r14) == null) goto L25;
        Map<String, Object> r16 = r15.get(r14);
        r1 = r1;
    L57:
        if (r16.get("screenWidth") != null) goto L59;
        r1.i("AppletLynxView", "getScreenWidth exp, is by cache :" + r12);
    L59:
        return r16;
    L25:
        LinkedHashMap r18 = new LinkedHashMap();
        IIvyLynxRuntimeService.Companion r19 = IIvyLynxRuntimeService.a;
        Pair r110 = r19.b(r0);
        if (r110 == null) goto L28;
        int r111 = ((Number) r110.getFirst()).intValue();
    L29:
        if (r110 == null) goto L31;
        int r112 = ((Number) r110.getSecond()).intValue();
    L33:
        if (r0.getResources().getConfiguration().orientation == 2) goto L36;
        r11 = 0;
    L36:
        int r20 = r19.getStatusBarHeight(r0);
        Rect r113 = new Rect();
        View r114 = r0.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L41;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r115 = ThreadMethodProxy.currentThread();
        if (r115 == com.larus.home.impl.utils.c.a) goto L41;
        com.larus.home.impl.utils.c.a(r115, "getDecorView");
    L41:
        r114.getWindowVisibleDisplayFrame(r113);
        int r21 = r114.getHeight();
        int r116 = r113.top;
        int r117 = r113.bottom;
        if (r21 != 0) goto L45;
        if (r116 != 0) goto L45;
        r117 = r117 + r20;
    L45:
        if (r111 == 0) goto L47;
        if (r112 == 0) goto L47;
    L51:
        int r22 = com.bytedance.ai.utils.o.d(r111, r0);
        r18.put("screenWidth", Integer.valueOf(r22));
        r18.put("contentWidth", Integer.valueOf(r22));
        r18.put("screenHeight", Integer.valueOf(com.bytedance.ai.utils.o.d(r112, r0)));
        r18.put("screenWidthPx", Integer.valueOf(r111));
        r18.put("screenHeightPx", Integer.valueOf(r112));
        r18.put("screenOrientation", Integer.valueOf(r11));
        int r23 = Math.max(r112 - r117, 0);
        int r118 = Math.max((r112 - r23) - r20, 0);
        double r119 = r20;
        r18.put("statusBarHeight", Integer.valueOf(com.bytedance.ai.utils.o.d(r119, r0)));
        int r24 = com.bytedance.ai.utils.o.d(r119, r0);
        r18.put("topHeight", Integer.valueOf(r24));
        int r25 = com.bytedance.ai.utils.o.d(r23, r0);
        r18.put("bottomHeight", Integer.valueOf(r25));
        int r120 = com.bytedance.ai.utils.o.d(r118, r0);
        r18.put("contentHeight", Integer.valueOf(r120));
        r18.put("safeAreaHeight", Integer.valueOf(r120));
        if (r11 == 0) goto L54;
        LinkedHashMap r26 = new LinkedHashMap();
        r26.put("marginTop", 0);
        r26.put("marginBottom", 0);
        r26.put("marginLeft", Integer.valueOf(r24));
        r26.put("marginRight", Integer.valueOf(r25));
        r18.put("safeArea", r26);
    L55:
        r18.put("appTheme", t2.a.a(r0));
        r15.put(r14, r18);
        r16 = r18;
        r12 = false;
        goto L57
    L54:
        LinkedHashMap r27 = new LinkedHashMap();
        r27.put("marginTop", Integer.valueOf(r24));
        r27.put("marginBottom", Integer.valueOf(r25));
        r27.put("marginLeft", 0);
        r27.put("marginRight", 0);
        r18.put("safeArea", r27);
    L47:
        r1.i("AppletLynxView", "getScreenSize exp width:" + r111 + ", height: " + r112);
        s4.f r28 = s4.f.a;
        int r29 = s4.f.b(r0);
        int r121 = s4.f.a(r0);
        if (r11 == 0) goto L50;
        r111 = Math.max(r29, r121);
        r112 = Math.min(r29, r121);
        goto L51
    L50:
        r111 = Math.min(r29, r121);
        r112 = Math.max(r29, r121);
        goto L51
    L31:
        r112 = 0;
        goto L33
    L28:
        r111 = 0;
        goto L29
    L21:
        r13 = false;
        goto L22
    L60:
        com.bytedance.ai.utils.g.a.i("AppletLynxView", "===getPageGlobalPropsByActivity: activity is null");
        return null;
    L6:
        if ((r17 instanceof Activity) == false) goto L8;
        r0 = (Activity) r17;
        goto L17
    L8:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r30 = AppletRuntimeManager.d;
        if (r30 == null) goto L12;
        r0 = r30.currentActivity();
        if (r0 != null) goto L17;
    L12:
        g2.b r31 = AppletRuntimeManager.d;
        if (r31 == null) goto L15;
        r0 = r31.O();
        goto L17
    }
}
