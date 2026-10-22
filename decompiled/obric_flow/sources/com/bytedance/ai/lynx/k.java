package com.bytedance.ai.lynx;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.LruCache;
import android.view.View;
import com.bytedance.ai.ex.widget.WidgetView;
import com.bytedance.ai.model.p;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.bullet.core.device.PropsUtilsKt;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.tasm.LynxEnv;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f2188a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f2189b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f2190c = null;
    public static final LruCache d = null;

    static {
        f2188a = new k();
        f2189b = new LinkedHashMap();
        f2190c = new ConcurrentHashMap();
        d = new LruCache(1024);
    }

    public static Map a(Context r15) {
        if (r15 != null) goto L6;
    L15:
        Activity r16 = null;
    L17:
        if (r16 == null) goto L64;
        String r5 = "===getPageGlobalPropsByActivity: " + r16.hashCode();
        Intrinsics.checkNotNullParameter("AppletLynxView", "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L21;
        r10.d("AppletLynxView", r5);
    L21:
        StringBuilder r11 = new StringBuilder();
        r11.append(r16.hashCode());
        r11.append('_');
        int r12 = 1;
        boolean r13 = true;
        if (r16.getResources().getConfiguration().orientation != 2) goto L24;
        boolean r14 = true;
    L25:
        r11.append(r14);
        String r17 = r11.toString();
        LruCache r18 = d;
        if (r18.get(r17) == null) goto L28;
        Map r19 = (Map) r18.get(r17);
    L59:
        if (r19.get("screenWidth") != null) goto L63;
        String r20 = "getScreenWidth exp, is by cache :" + r13;
        Intrinsics.checkNotNullParameter("AppletLynxView", "tag");
        t0.d r21 = com.bytedance.ai.utils.c.f2846a;
        if (r21 == null) goto L63;
        r21.i("AppletLynxView", r20);
    L63:
        return r19;
    L28:
        LinkedHashMap r22 = new LinkedHashMap();
        Pair r23 = nb.a.i(r16);
        if (r23 == null) goto L31;
        int r110 = ((Number) r23.getFirst()).intValue();
    L32:
        if (r23 == null) goto L34;
        int r24 = ((Number) r23.getSecond()).intValue();
    L36:
        if (r16.getResources().getConfiguration().orientation == 2) goto L39;
        r12 = 0;
    L39:
        int r25 = nb.a.k(r16);
        Rect r111 = new Rect();
        View r112 = r16.getWindow().getDecorView();
        r112.getWindowVisibleDisplayFrame(r111);
        int r113 = r112.getHeight();
        int r114 = r111.top;
        int r115 = r111.bottom;
        if (r113 != 0) goto L43;
        if (r114 != 0) goto L43;
        r115 = r115 + r25;
    L43:
        if (r110 == 0) goto L45;
        if (r24 == 0) goto L45;
    L53:
        int r116 = com.bytedance.ai.utils.c.a(r110, r16);
        r22.put("screenWidth", Integer.valueOf(r116));
        r22.put("contentWidth", Integer.valueOf(r116));
        r22.put("screenHeight", Integer.valueOf(com.bytedance.ai.utils.c.a(r24, r16)));
        r22.put("screenWidthPx", Integer.valueOf(r110));
        r22.put("screenHeightPx", Integer.valueOf(r24));
        r22.put("screenOrientation", Integer.valueOf(r12));
        int r117 = Math.max(r24 - r115, 0);
        int r26 = Math.max((r24 - r117) - r25, 0);
        r22.put("statusBarHeight", Integer.valueOf(com.bytedance.ai.utils.c.a(nb.a.k(r16), r16)));
        int r27 = com.bytedance.ai.utils.c.a(r25, r16);
        r22.put("topHeight", Integer.valueOf(r27));
        int r118 = com.bytedance.ai.utils.c.a(r117, r16);
        r22.put("bottomHeight", Integer.valueOf(r118));
        int r119 = com.bytedance.ai.utils.c.a(r26, r16);
        r22.put("contentHeight", Integer.valueOf(r119));
        r22.put("safeAreaHeight", Integer.valueOf(r119));
        if (r12 == 0) goto L56;
        LinkedHashMap r28 = new LinkedHashMap();
        r28.put("marginTop", 0);
        r28.put("marginBottom", 0);
        r28.put("marginLeft", Integer.valueOf(r27));
        r28.put("marginRight", Integer.valueOf(r118));
        r22.put("safeArea", r28);
    L57:
        r22.put("appTheme", WidgetView.UI_MODE_LIGHT);
        r18.put(r17, r22);
        r13 = false;
        r19 = r22;
        goto L59
    L56:
        LinkedHashMap r29 = new LinkedHashMap();
        r29.put("marginTop", Integer.valueOf(r27));
        r29.put("marginBottom", Integer.valueOf(r118));
        r29.put("marginLeft", 0);
        r29.put("marginRight", 0);
        r22.put("safeArea", r29);
    L45:
        String r30 = com.lynx.tasm.base.h.b(r110, r24, "getScreenSize exp width:", ", height: ");
        Intrinsics.checkNotNullParameter("AppletLynxView", "tag");
        t0.d r120 = com.bytedance.ai.utils.c.f2846a;
        if (r120 == null) goto L48;
        r120.i("AppletLynxView", r30);
    L48:
        int r31 = i.a.n(r16);
        int r121 = i.a.a(r16);
        if (r12 == 0) goto L52;
        int r122 = Math.max(r31, r121);
        r24 = Math.min(r31, r121);
    L51:
        r110 = r122;
        goto L53
    L52:
        r122 = Math.min(r31, r121);
        r24 = Math.max(r31, r121);
        goto L51
    L34:
        r24 = 0;
        goto L36
    L31:
        r110 = 0;
        goto L32
    L24:
        r14 = false;
        goto L25
    L64:
        Intrinsics.checkNotNullParameter("AppletLynxView", "tag");
        t0.d r123 = com.bytedance.ai.utils.c.f2846a;
        if (r123 == null) goto L67;
        r123.i("AppletLynxView", "===getPageGlobalPropsByActivity: activity is null");
    L67:
        return null;
    L6:
        if ((r15 instanceof Activity) == false) goto L8;
        r16 = (Activity) r15;
        goto L17
    L8:
        t0.b r124 = p.f2294c;
        if (r124 == null) goto L12;
        r16 = r124.currentActivity();
        if (r16 != null) goto L17;
    L12:
        t0.b r125 = p.f2294c;
        if (r125 == null) goto L15;
        r16 = r125.findMainActivity();
        goto L17
    }

    public static Map b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        String r5 = String.valueOf(r10);
        if (s0.a.f21798a.get() == false) goto L25;
        if (s0.a.f21800c == null) goto L25;
        ConcurrentHashMap r11 = f2190c;
        Object r12 = r11.get(r5);
        if (r12 != null) goto L23;
        k r13 = f2188a;
        monitor-enter(r13);
        LinkedHashMap r14 = new LinkedHashMap();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter("AppletLynxView", "tag");     // Catch: Throwable -> L13
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L13
        if (r15 == null) goto L15;
        r15.i("AppletLynxView", "getCommonGlobalProps withoutCache");     // Catch: Throwable -> L13
    L15:
        r14.putAll(e());     // Catch: Throwable -> L13
        r14.putAll(c());     // Catch: Throwable -> L13
        r14.putAll(d(r10));     // Catch: Throwable -> L13
        LinkedHashMap r16 = new LinkedHashMap();     // Catch: Throwable -> L13
        r16.put("lynxSdkVersion", LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L13
        r14.putAll(r16);     // Catch: Throwable -> L13
        monitor-exit(r13);
        r12 = r11.putIfAbsent(r5, r14);
        if (r12 != null) goto L23;
        r12 = r14;
    L13:
        th = move-exception;
        throw th;
    L23:
        return (Map) r12;
    L25:
        return new LinkedHashMap();
    }

    public static LinkedHashMap c() {
        u0.a r5 = s0.a.f21800c;
        if (r5 == null) goto L10;
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put(LynxMonitorService.KEY_CHANNEL, r5.f22197h);
        r10.put(WsConstants.KEY_APP_ID, Integer.valueOf(r5.d));
        r10.put("appName", r5.f22196c);
        r10.put("appVersion", r5.e);
        r10.put("updateVersionCode", r5.f22198i);
        String r11 = r5.f22195b;
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        r10.put("deviceId", r11);
        r10.put("isOversea", Boolean.valueOf(r5.f22199j));
        return r10;
    L10:
        return new LinkedHashMap();
    }

    public static LinkedHashMap d(String r10) {
        String r11 = com.lynx.tasm.behavior.utils.d.c("getCommonPageProps by provider bid:", r10, "AppletLynxView");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L5;
        r5.i("AppletLynxView", r11);
    L5:
        LinkedHashMap r12 = new LinkedHashMap();
        u0.a r13 = s0.a.f21800c;
        if (r13 == null) goto L41;
        Application r14 = r13.f22194a;
        if (r14 == null) goto L41;
        r12.putAll(PropsUtilsKt.getPageCommonProps(r14));
        Pair r15 = nb.a.i(r14);
        int r16 = 0;
        if (r15 == null) goto L12;
        int r17 = ((Number) r15.getFirst()).intValue();
    L13:
        if (r15 == null) goto L15;
        int r18 = ((Number) r15.getSecond()).intValue();
    L16:
        Application r19 = com.bytedance.ies.bullet.core.h.g.f5316b;
        if (r19 == null) goto L21;
        int r20 = r19.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r20 <= 0) goto L21;
        int r21 = r19.getResources().getDimensionPixelSize(r20);
    L22:
        int r22 = com.bytedance.ai.utils.c.a(r21, r14);
        if (r14.getResources().getConfiguration().orientation != 2) goto L26;
        r16 = 1;
    L26:
        if (r17 == 0) goto L28;
        if (r18 == 0) goto L28;
    L36:
        int r23 = com.bytedance.ai.utils.c.a(r17, r14);
        int r24 = com.bytedance.ai.utils.c.a(r18, r14);
        r12.put("screenWidth", Integer.valueOf(r23));
        r12.put("screenHeight", Integer.valueOf(r24));
        r12.put("screenWidthPx", Integer.valueOf(r17));
        r12.put("screenHeightPx", Integer.valueOf(r18));
        r12.put("statusBarHeight", Integer.valueOf(r22));
        r12.put("topHeight", Integer.valueOf(r22));
        r12.put("isLandscape", Integer.valueOf(r16));
        r12.put("appTheme", WidgetView.UI_MODE_LIGHT);
        if (r17 != 0) goto L41;
        Intrinsics.checkNotNullParameter("AppletLynxView", "tag");
        t0.d r25 = com.bytedance.ai.utils.c.f2846a;
        if (r25 == null) goto L41;
        r25.e("AppletLynxView", "getScreenWidth exp, is by application");
    L28:
        String r26 = com.lynx.tasm.base.h.b(r17, r18, "getScreenSize by application exp width:", ", height: ");
        Intrinsics.checkNotNullParameter("AppletLynxView", "tag");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L31;
        r27.i("AppletLynxView", r26);
    L31:
        int r28 = i.a.n(r14);
        int r29 = i.a.a(r14);
        if (r16 == 0) goto L35;
        int r30 = Math.max(r28, r29);
        r18 = Math.min(r28, r29);
    L34:
        r17 = r30;
        goto L36
    L35:
        r30 = Math.min(r28, r29);
        r18 = Math.max(r28, r29);
    L21:
        r21 = 0;
        goto L22
    L15:
        r18 = 0;
        goto L16
    L12:
        r17 = 0;
    L41:
        return r12;
    }

    public static LinkedHashMap e() {
        LinkedHashMap r5 = f2189b;
        if (r5.isEmpty() == false) goto L11;
        u0.a r10 = s0.a.f21800c;
        if (r10 == null) goto L8;
        Application r11 = r10.f22194a;
    L9:
        if (r11 == null) goto L11;
        LinkedHashMap r12 = new LinkedHashMap();
        String r13 = Build.MODEL;
        r12.put("deviceModel", r13);
        r12.put("os", "android");
        r12.put("osVersion", Build.VERSION.RELEASE);
        r12.put("language", nb.a.c());
        r12.put("deviceBrand", Build.BRAND);
        r12.put(WidgetView.DENSITY, Float.valueOf(nb.a.a(r11)));
        r12.put("deviceType", r13);
        r12.put("useXBridge3", Boolean.TRUE);
        r12.put("usePiperData", Boolean.FALSE);
        r5.putAll(r12);
        goto L11
    L8:
        r11 = null;
    L11:
        return r5;
    }
}
