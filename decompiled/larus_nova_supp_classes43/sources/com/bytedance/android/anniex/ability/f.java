package com.bytedance.android.anniex.ability;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.util.LruCache;
import com.bytedance.android.anniex.ability.service.BaseAnnieXPropsProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXPropsProvider;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.utils.AnnieXSettings;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.device.PropsUtilsKt;
import com.bytedance.ies.bullet.prefetchv2.a0;
import com.bytedance.ies.bullet.prefetchv2.v;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.TraceEvent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final ConcurrentHashMap<String, Object> a = null;
    public static final LruCache<String, ConcurrentHashMap<String, Object>> b = null;
    public static final LruCache<Integer, ConcurrentHashMap<String, Object>> c = null;
    public static final LruCache<String, ConcurrentHashMap<String, Object>> d = null;

    public f() {
    }

    static {
        a = new ConcurrentHashMap();
        b = new LruCache(1024);
        c = new LruCache(1024);
        d = new LruCache(1024);
    }

    public static final Map b() {
        TraceEvent.beginSection("GlobalPropsHelper:getDeviceProps");
        ConcurrentHashMap<String, Object> r1 = a;     // Catch: Throwable -> L11
        if ((!r1.isEmpty()) == true) goto L9;
        PropsUtilsKt.d(null);     // Catch: Throwable -> L11
        if (com.bytedance.ies.bullet.core.h.h.b == null) goto L9;
        LinkedHashMap r10 = new LinkedHashMap();     // Catch: Throwable -> L11
        r10.putAll(PropsUtilsKt.a);     // Catch: Throwable -> L11
        r1.putAll(r10);     // Catch: Throwable -> L11
    L9:
        TraceEvent.endSection("GlobalPropsHelper:getDeviceProps");
        return r1;
    L11:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:getDeviceProps");
        throw th;
    }

    public static final Map c(Context r10) {
        TraceEvent.beginSection("GlobalPropsHelper:getDeviceProps");
        ConcurrentHashMap<String, Object> r1 = a;     // Catch: Throwable -> L11
        if ((!r1.isEmpty()) == true) goto L9;
        PropsUtilsKt.d(r10);     // Catch: Throwable -> L11
        if (r10 == null) goto L9;
        LinkedHashMap r11 = new LinkedHashMap();     // Catch: Throwable -> L11
        r11.putAll(PropsUtilsKt.a);     // Catch: Throwable -> L11
        r1.putAll(r11);     // Catch: Throwable -> L11
    L9:
        TraceEvent.endSection("GlobalPropsHelper:getDeviceProps");
        return r1;
    L11:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:getDeviceProps");
        throw th;
    }

    public static final IAnnieXPropsProvider d(String r10) {
        Lazy r0 = AnnieXSettings.a;
        if (AnnieXSettings.a() == false) goto L5;
        AnnieXServiceCenter.a.getClass();
        return (IAnnieXPropsProvider) AnnieXServiceCenter.d(r10, IAnnieXPropsProvider.class);
    L5:
        com.bytedance.android.anniex.assemble.a r1 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXPropsProvider r11 = (IAnnieXPropsProvider) com.bytedance.android.anniex.assemble.a.g(r10, IAnnieXPropsProvider.class);
        if (r11 != null) goto L9;
        s26.d r12 = s26.d.c;
        return (IAnnieXPropsProvider) s26.d.c.d(r10, IAnnieXPropsProvider.class);
    L9:
        return r11;
    }

    public static final Map e(Activity r10) {
        int r0 = i16.a.i(r10);
        int r1 = i16.a.f(r10);
        if (r0 == 0) goto L7;
        if (r1 == 0) goto L7;
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("screenWidth", Integer.valueOf(i16.a.m(r0, r10)));
        r11.put("screenHeight", Integer.valueOf(i16.a.m(r1, r10)));
        r11.put("screenWidthPx", Integer.valueOf(r0));
        r11.put("screenHeightPx", Integer.valueOf(r1));
        r11.put("orientation", Integer.valueOf(t(r10) ? 1 : 0));
        return r11;
    L7:
        HybridLogger r12 = HybridLogger.a;
        HybridLogger.m("AnnieX", "getScreenSize exp width:" + r0 + ", height: " + r1, null, null, 12);
        if (r10.getResources().getConfiguration().orientation != 2) goto L10;
        boolean r13 = true;
    L11:
        Boolean r14 = Boolean.valueOf(r13);
        int r15 = vd7.c.b(r10);
        int r16 = vd7.c.a(r10);
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L14;
        int r17 = Math.max(r15, r16);
        int r18 = Math.min(r15, r16);
    L15:
        LinkedHashMap r19 = new LinkedHashMap();
        r19.put("screenWidth", Integer.valueOf(i16.a.m(r17, r10)));
        r19.put("screenHeight", Integer.valueOf(i16.a.m(r18, r10)));
        r19.put("screenWidthPx", Integer.valueOf(r17));
        r19.put("screenHeightPx", Integer.valueOf(r18));
        r19.put("orientation", Integer.valueOf(t(r10) ? 1 : 0));
        return r19;
    L14:
        r17 = Math.min(r15, r16);
        r18 = Math.max(r15, r16);
        goto L15
    L10:
        r13 = false;
        goto L11
    }

    public static final Map f(Application r10) {
        int r0 = i16.a.i(r10);
        int r1 = i16.a.f(r10);
        if (r0 == 0) goto L7;
        if (r1 == 0) goto L7;
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("screenWidth", Integer.valueOf(i16.a.m(r0, r10)));
        r11.put("screenHeight", Integer.valueOf(i16.a.m(r1, r10)));
        r11.put("screenWidthPx", Integer.valueOf(r0));
        r11.put("screenHeightPx", Integer.valueOf(r1));
        r11.put("orientation", Integer.valueOf(u(r10) ? 1 : 0));
        return r11;
    L7:
        HybridLogger r12 = HybridLogger.a;
        HybridLogger.m("AnnieX", "getScreenSize exp width:" + r0 + ", height: " + r1, null, null, 12);
        if (r10.getResources().getConfiguration().orientation != 2) goto L10;
        boolean r13 = true;
    L11:
        Boolean r14 = Boolean.valueOf(r13);
        int r15 = vd7.c.b(r10);
        int r16 = vd7.c.a(r10);
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L14;
        int r17 = Math.max(r15, r16);
        int r18 = Math.min(r15, r16);
    L15:
        LinkedHashMap r19 = new LinkedHashMap();
        r19.put("screenWidth", Integer.valueOf(i16.a.m(r17, r10)));
        r19.put("screenHeight", Integer.valueOf(i16.a.m(r18, r10)));
        r19.put("screenWidthPx", Integer.valueOf(r17));
        r19.put("screenHeightPx", Integer.valueOf(r18));
        r19.put("orientation", Integer.valueOf(u(r10) ? 1 : 0));
        return r19;
    L14:
        r17 = Math.min(r15, r16);
        r18 = Math.max(r15, r16);
        goto L15
    L10:
        r13 = false;
        goto L11
    }

    public static KitType n(Uri r10) {
        String r11 = r10.getScheme();
        if (r11 == null) goto L24;
        int r0 = r11.hashCode();
        if (r0 == (-1772600516)) goto L20;
        if (r0 == 3213448) goto L16;
        if (r0 != 99617003) goto L24;
        if (r11.equals("https") == false) goto L24;
        return KitType.WEB;
    L16:
        if (r11.equals("http") == false) goto L24;
        return KitType.WEB;
    L20:
        if (r11.equals("lynxview") == false) goto L24;
        return KitType.LYNX;
    L24:
        return KitType.UNKNOWN;
    }

    public static Map q(Application r13) {
        TraceEvent.beginSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        ConcurrentHashMap<String, Object> r10 = null;
        if (r13 == null) goto L28;
        LruCache<Integer, ConcurrentHashMap<String, Object>> r11 = c;     // Catch: Throwable -> L31
        int r12 = 1;
        boolean r14 = true;
        if (r11.get(Integer.valueOf(r13.hashCode())) == null) goto L7;
        ConcurrentHashMap<String, Object> r15 = r11.get(Integer.valueOf(r13.hashCode()));     // Catch: Throwable -> L31
    L23:
        if (r15.get("screenWidth") != null) goto L25;
    L26:
        String r0 = "getScreenWidth exp, is by cache :" + r14;     // Catch: Throwable -> L31
        HybridLogger.m("AnnieX", r0, null, null, 12);     // Catch: Throwable -> L31
        com.bytedance.android.anniex.monitor.a.a(r0);     // Catch: Throwable -> L31
    L27:
        r10 = r15;
    L29:
        TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        return r10;
    L25:
        if (Intrinsics.areEqual(r15.get("screenWidth"), 0) == false) goto L27;
    L7:
        ConcurrentHashMap<String, Object> r16 = new ConcurrentHashMap();     // Catch: Throwable -> L31
        r16.putAll(f(r13));     // Catch: Throwable -> L31
        r16.put("statusBarHeight", Integer.valueOf(i16.a.m(i16.a.j(r13), r13)));     // Catch: Throwable -> L31
        r16.putAll(PropsUtilsKt.getPageCommonProps(r13, null));     // Catch: Throwable -> L31
        Object r17 = r16.get("contentHeight");     // Catch: Throwable -> L31
        if (r17 == null) goto L11;
        r16.put("safeAreaHeight", r17);     // Catch: Throwable -> L31
    L11:
        if (r13.getResources().getConfiguration().orientation != 2) goto L13;
        boolean r18 = true;
    L15:
        if (r18 == true) goto L18;
        r12 = 0;
    L18:
        r16.put("isLandscape", Integer.valueOf(r12));     // Catch: Throwable -> L31
        if (com.bytedance.ies.bullet.service.base.h.I() == false) goto L21;
        r16.putAll(c(r13));     // Catch: Throwable -> L31
    L21:
        r11.put(Integer.valueOf(r13.hashCode()), r16);     // Catch: Throwable -> L31
        r15 = r16;
        r14 = false;
        goto L23
    L13:
        r18 = false;
        goto L15
    L28:
        HybridLogger.m("AnnieX", "getPageGlobalPropsByActivity exp: context is not activity", null, null, 12);     // Catch: Throwable -> L31
        com.bytedance.android.anniex.monitor.a.a("getPageGlobalPropsByActivity exp: context is not activity");     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        throw th;
    }

    public static boolean t(Activity r10) {
        if (r10 == null) goto L4;
        Integer r11 = Integer.valueOf(r10.getRequestedOrientation());
    L5:
        if (r11 != null) goto L8;
    L9:
        if (r11 != null) goto L12;
    L13:
        if (r11 != null) goto L16;
        return false;
    L16:
        if (r11.intValue() == 6) goto L24;
        return false;
    L24:
        return true;
    L12:
        if (r11.intValue() != 8) goto L13;
        return true;
    L8:
        if (r11.intValue() != 0) goto L9;
        return true;
    L4:
        r11 = null;
        goto L5
    }

    public static boolean u(Application r10) {
        if (r10 == null) goto L8;
        Resources r11 = r10.getResources();
        if (r11 == null) goto L8;
        Configuration r12 = r11.getConfiguration();
        if (r12 == null) goto L8;
        Integer r13 = Integer.valueOf(r12.orientation);
    L9:
        if (r13 != null) goto L12;
    L13:
        if (r13 != null) goto L16;
    L17:
        if (r13 != null) goto L20;
        return false;
    L20:
        if (r13.intValue() == 6) goto L28;
        return false;
    L28:
        return true;
    L16:
        if (r13.intValue() != 8) goto L17;
        return true;
    L12:
        if (r13.intValue() != 0) goto L13;
        return true;
    L8:
        r13 = null;
        goto L9
    }

    public static final Map a(String r12, KitType r13) {
        TraceEvent.beginSection("GlobalPropsHelper:getCommonPageProps");
        IAnnieXPropsProvider r10 = d(r12);     // Catch: Throwable -> L34
        int r11 = 1;
        if (r10 == null) goto L17;
        HybridLogger r1 = HybridLogger.a;     // Catch: Throwable -> L34
        HybridLogger.m("AnnieX", "getCommonPageProps by provider bid:" + r12 + ", kitType:" + r13.getTag(), null, null, 12);     // Catch: Throwable -> L34
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Throwable -> L34
        Application r14 = com.bytedance.ies.bullet.core.h.h.b;     // Catch: Throwable -> L34
        if (r14 != null) goto L9;
    L16:
        r10.C(r12, r13);     // Catch: Throwable -> L34
    L32:
        TraceEvent.endSection("GlobalPropsHelper:getCommonPageProps");
        return r0;
    L9:
        if (r14.getResources().getConfiguration().orientation != 2) goto L11;
        boolean r15 = true;
    L12:
        if (r15 == true) goto L15;
        r11 = 0;
    L15:
        r0.put("isLandscape", Integer.valueOf(r11));     // Catch: Throwable -> L34
        goto L16
    L11:
        r15 = false;
        goto L12
    L17:
        HybridLogger r16 = HybridLogger.a;     // Catch: Throwable -> L34
        HybridLogger.m("AnnieX", "getCommonPageProps by reveal bid:" + r12 + ", kitType:" + r13.getTag(), null, null, 12);     // Catch: Throwable -> L34
        r0 = new LinkedHashMap();     // Catch: Throwable -> L34
        Application r17 = com.bytedance.ies.bullet.core.h.h.b;     // Catch: Throwable -> L34
        if (r17 == null) goto L32;
        r0.putAll(PropsUtilsKt.getPageCommonProps(r17, null));     // Catch: Throwable -> L34
        i16.c r18 = i16.c.a;     // Catch: Throwable -> L34
        int r19 = i16.c.k(r17, vd7.c.c());     // Catch: Throwable -> L34
        if (r17.getResources().getConfiguration().orientation != 2) goto L22;
        boolean r20 = true;
    L23:
        Boolean r21 = Boolean.valueOf(r20);     // Catch: Throwable -> L34
        int r22 = i16.c.k(r17, vd7.c.b(r17));     // Catch: Throwable -> L34
        int r110 = i16.c.k(r17, vd7.c.a(r17));     // Catch: Throwable -> L34
        if (Intrinsics.areEqual(r21, Boolean.TRUE) == false) goto L26;
        int r23 = Math.max(r22, r110);     // Catch: Throwable -> L34
        int r111 = Math.min(r22, r110);     // Catch: Throwable -> L34
    L27:
        r0.put("screenWidth", Integer.valueOf(r23));     // Catch: Throwable -> L34
        r0.put("screenHeight", Integer.valueOf(r111));     // Catch: Throwable -> L34
        r0.put("statusBarHeight", Integer.valueOf(r19));     // Catch: Throwable -> L34
        r0.put("topHeight", Integer.valueOf(r19));     // Catch: Throwable -> L34
        if (r21.booleanValue() == true) goto L31;
        r11 = 0;
    L31:
        r0.put("isLandscape", Integer.valueOf(r11));     // Catch: Throwable -> L34
        goto L32
    L26:
        r23 = Math.min(r22, r110);     // Catch: Throwable -> L34
        r111 = Math.max(r22, r110);     // Catch: Throwable -> L34
        goto L27
    L22:
        r20 = false;
    L34:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:getCommonPageProps");
        throw th;
    }

    public static final void g(Map r10, Uri r11) {
        TraceEvent.beginSection("GlobalPropsHelper:putGlobalProps");
        List r12 = a0.b(r11);     // Catch: Throwable -> L23
        if (r12 == null) goto L8;
        boolean r13 = true;
        if ((!r12.isEmpty()) != true) goto L8;
    L9:
        if (r13 == false) goto L20;
        Iterator r14 = r12.iterator();     // Catch: Throwable -> L23
    L12:
        if (r14.hasNext() == false) goto L20;
        v r1 = (v) r14.next();     // Catch: Throwable -> L23
        String r15 = r1.g;     // Catch: Throwable -> L23
        if (r15 == null) goto L12;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r15) == false) goto L12;
        JSONObject r16 = r1.c;     // Catch: Throwable -> L23
        if (r16 == null) goto L12;
        ((ConcurrentHashMap) r10).put(r15, String.valueOf(r16));     // Catch: Throwable -> L23
    L20:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L23
        TraceEvent.endSection("GlobalPropsHelper:putGlobalProps");
        return;
    L8:
        r13 = false;
    L23:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:putGlobalProps");
        throw th;
    }

    public static final void i(Map r10, Uri r11) {
        TraceEvent.beginSection("GlobalPropsHelper:putSchemeItems");
        String r12 = w36.a.a(r11, "font_scale");     // Catch: Throwable -> L11
        if (r12 == null) goto L6;
        ConcurrentHashMap r13 = (ConcurrentHashMap) r10;     // Catch: Throwable -> L11
        r13.put("fontScale", Float.valueOf(Float.parseFloat(r12)));     // Catch: Throwable -> L11
        ConcurrentHashMap r14 = (ConcurrentHashMap) r10;     // Catch: Throwable -> L11
        r14.put("font_scale", Float.valueOf(Float.parseFloat(r12)));     // Catch: Throwable -> L11
    L6:
        String r15 = w36.a.a(r11, "view_zoom");     // Catch: Throwable -> L11
        if (r15 == null) goto L9;
        ConcurrentHashMap r16 = (ConcurrentHashMap) r10;     // Catch: Throwable -> L11
        r16.put("viewZoom", Float.valueOf(Float.parseFloat(r15)));     // Catch: Throwable -> L11
    L9:
        TraceEvent.endSection("GlobalPropsHelper:putSchemeItems");
        return;
    L11:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:putSchemeItems");
        throw th;
    }

    public static Map k(KitType r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "kitType");
        Intrinsics.checkNotNullParameter(r11, "bid");
        TraceEvent.beginSection("GlobalPropsHelper:getCommonGlobalProps");
        String r1 = r11 + '_' + r10.getTag();     // Catch: Throwable -> L42
        LruCache<String, ConcurrentHashMap<String, Object>> r12 = b;     // Catch: Throwable -> L42
        ConcurrentHashMap<String, Object> r13 = r12.get(r11 + '_' + r10.getTag());     // Catch: Throwable -> L42
        if (r13 != null) goto L6;
    L9:
        boolean r14 = true;
    L10:
        if (r14 == false) goto L39;
        ConcurrentHashMap<String, Object> r15 = new ConcurrentHashMap();     // Catch: Throwable -> L42
        HybridLogger.m("AnnieX", "getCommonGlobalProps withoutCache", null, null, 12);     // Catch: Throwable -> L42
        r15.putAll(b());     // Catch: Throwable -> L42
        TraceEvent.beginSection("GlobalPropsHelper:getCommonAppProps");     // Catch: Throwable -> L42
        IAnnieXPropsProvider r16 = d(r11);     // Catch: Throwable -> L36
        if (r16 == null) goto L15;
        Map<String, Object> r17 = r16.p(r11, r10);     // Catch: Throwable -> L36
    L16:
        TraceEvent.endSection("GlobalPropsHelper:getCommonAppProps");     // Catch: Throwable -> L42
        if (r17 == null) goto L19;
        r15.putAll(r17);     // Catch: Throwable -> L42
    L19:
        AnnieXRuntime.a().getClass();     // Catch: Throwable -> L42
        r15.put("isPreInstallApp", 0);     // Catch: Throwable -> L42
        r15.putAll(a(r11, r10));     // Catch: Throwable -> L42
        if (r10 != KitType.LYNX) goto L28;
        TraceEvent.beginSection("GlobalPropsHelper:getLynxCommonProps");     // Catch: Throwable -> L42
        LinkedHashMap r18 = new LinkedHashMap();     // Catch: Throwable -> L24
        r18.put("lynxSdkVersion", LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L24
        TraceEvent.endSection("GlobalPropsHelper:getLynxCommonProps");     // Catch: Throwable -> L42
        r15.putAll(r18);     // Catch: Throwable -> L42
    L35:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L42
        r12.put(r1, r15);     // Catch: Throwable -> L42
        goto L39
    L24:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:getLynxCommonProps");     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L28:
        if (r10 != KitType.WEB) goto L35;
        TraceEvent.beginSection("GlobalPropsHelper:getWebCommonProps");     // Catch: Throwable -> L42
        LinkedHashMap r110 = new LinkedHashMap();     // Catch: Throwable -> L32
        TraceEvent.endSection("GlobalPropsHelper:getWebCommonProps");     // Catch: Throwable -> L42
        r15.putAll(r110);     // Catch: Throwable -> L42
        goto L35
    L32:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:getWebCommonProps");     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L15:
        r17 = new LinkedHashMap();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:getCommonAppProps");     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L39:
        ConcurrentHashMap<String, Object> r20 = r12.get(r1);     // Catch: Throwable -> L42
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");     // Catch: Throwable -> L42
        Map r21 = TypeIntrinsics.asMutableMap(r20);     // Catch: Throwable -> L42
        TraceEvent.endSection("GlobalPropsHelper:getCommonGlobalProps");
        return r21;
    L6:
        if (r13.isEmpty() == true) goto L9;
        r14 = false;
    L42:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:getCommonGlobalProps");
        throw th;
    }

    public static Map o(Context r17, String r18) {
        TraceEvent.beginSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        ConcurrentHashMap<String, Object> r10 = null;
        if (r17 != null) goto L54;
    L48:
        HybridLogger.m("AnnieX", "getPageGlobalPropsByActivity exp: context is not activity", null, null, 12);     // Catch: Throwable -> L51
        com.bytedance.android.anniex.monitor.a.a("getPageGlobalPropsByActivity exp: context is not activity");     // Catch: Throwable -> L51
    L49:
        TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        return r10;
    L54:
    L51:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        throw th;
    L5:
        if ((r17 instanceof Activity) == false) goto L48;
        Activity r11 = (Activity) r17;     // Catch: Throwable -> L51
        LruCache<Integer, ConcurrentHashMap<String, Object>> r12 = c;     // Catch: Throwable -> L51
        boolean r13 = true;
        if (r12.get(Integer.valueOf(r11.hashCode())) == null) goto L9;
        ConcurrentHashMap<String, Object> r1 = r12.get(Integer.valueOf(r11.hashCode()));     // Catch: Throwable -> L51
        boolean r14 = true;
    L25:
        Map r15 = x26.a.a;     // Catch: Throwable -> L51
        w26.g r16 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L51
        if (r16 == null) goto L32;
        w26.e r19 = (w26.e) r16.n0(w26.e.class);     // Catch: Throwable -> L51
        if (r19 == null) goto L32;
        Boolean r20 = r19.b();     // Catch: Throwable -> L51
        if (r20 == null) goto L32;
        boolean r21 = r20.booleanValue();     // Catch: Throwable -> L51
    L33:
        if (r21 == false) goto L43;
        ConcurrentHashMap r22 = PropsUtilsKt.a;     // Catch: Throwable -> L51
        LinkedHashMap r23 = new LinkedHashMap();     // Catch: Throwable -> L51
        if (r17.getResources().getConfiguration().orientation == 2) goto L38;
        r13 = false;
    L38:
        if (r13 == false) goto L40;
        String r0 = "landscape";
    L41:
        r23.put("screenOrientation", r0);     // Catch: Throwable -> L51
        r1.putAll(r23);     // Catch: Throwable -> L51
        goto L43
    L40:
        r0 = "portrait";
    L43:
        if (r1.get("screenWidth") != null) goto L45;
    L46:
        String r24 = "getScreenWidth exp, is by cache :" + r14;     // Catch: Throwable -> L51
        HybridLogger.m("AnnieX", r24, null, null, 12);     // Catch: Throwable -> L51
        com.bytedance.android.anniex.monitor.a.a(r24);     // Catch: Throwable -> L51
    L47:
        r10 = r1;
        goto L49
    L45:
        if (Intrinsics.areEqual(r1.get("screenWidth"), 0) == false) goto L47;
    L32:
        r21 = true;
        goto L33
    L9:
        ConcurrentHashMap<String, Object> r110 = new ConcurrentHashMap();     // Catch: Throwable -> L51
        r110.putAll(e(r11));     // Catch: Throwable -> L51
        r110.put("statusBarHeight", Integer.valueOf(i16.a.m(i16.a.j(r11), r11)));     // Catch: Throwable -> L51
        if (r18 == null) goto L12;
        t36.j r25 = com.bytedance.android.anniex.lite.c.b.get(r18);     // Catch: Throwable -> L51
    L13:
        r110.putAll(PropsUtilsKt.getPageCommonProps(r11, r25));     // Catch: Throwable -> L51
        if (r11.getResources().getConfiguration().orientation != 2) goto L16;
        boolean r26 = true;
    L18:
        if (r26 == false) goto L20;
        int r27 = 1;
    L21:
        r110.put("isLandscape", Integer.valueOf(r27));     // Catch: Throwable -> L51
        if (com.bytedance.ies.bullet.service.base.h.I() == false) goto L24;
        r110.putAll(c(r17));     // Catch: Throwable -> L51
    L24:
        r12.put(Integer.valueOf(r11.hashCode()), r110);     // Catch: Throwable -> L51
        r1 = r110;
        r14 = false;
        goto L25
    L20:
        r27 = 0;
        goto L21
    L16:
        r26 = false;
        goto L18
    L12:
        r25 = null;
        goto L13
    }

    public static final void h(Map r10, Uri r11, boolean r12) {
        TraceEvent.beginSection("GlobalPropsHelper:putQueryItems");
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L20
        Iterator<T> r13 = r11.getQueryParameterNames().iterator();     // Catch: Throwable -> L20
    L5:
        if (r13.hasNext() == false) goto L7;
        String r14 = (String) r13.next();     // Catch: Throwable -> L20
        r1.put(r14, r11.getQueryParameter(r14));     // Catch: Throwable -> L20
        goto L5
    L7:
        if (r12 == false) goto L17;
        Map r15 = x26.a.a;     // Catch: Throwable -> L20
        w26.g r16 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L20
        if (r16 == null) goto L13;
        w26.e r17 = (w26.e) r16.n0(w26.e.class);     // Catch: Throwable -> L20
        if (r17 == null) goto L13;
        boolean r18 = Intrinsics.areEqual(r17.f2(), Boolean.FALSE);     // Catch: Throwable -> L20
    L15:
        if ((!r18) == false) goto L17;
        r1.put(com.bytedance.android.ec.core.event.a.KEY_URL, r11.buildUpon().clearQuery().toString());     // Catch: Throwable -> L20
    L13:
        r18 = false;
    L17:
        ((ConcurrentHashMap) r10).put("queryItems", r1);     // Catch: Throwable -> L20
        TraceEvent.endSection("GlobalPropsHelper:putQueryItems");
        return;
    L20:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:putQueryItems");
        throw th;
    }

    public static final void j(Map r10, Uri r11, Context r12) {
        TraceEvent.beginSection("GlobalPropsHelper:putStorageGlobalProps");
        if (r12 != null) goto L23;
    L21:
        TraceEvent.endSection("GlobalPropsHelper:putStorageGlobalProps");
        return;
    L23:
        Map r1 = x26.a.a;     // Catch: Throwable -> L18
        com.bytedance.ies.bullet.service.base.l r13 = (com.bytedance.ies.bullet.service.base.l) x26.a.a(com.bytedance.ies.bullet.service.base.l.class);     // Catch: Throwable -> L18
        if (r13 == null) goto L11;
        Map r14 = r13.b(r11, r12);     // Catch: Throwable -> L18
        if (r14 == null) goto L11;
        Map r15 = MapsKt.toMap(r14);     // Catch: Throwable -> L18
        if (r15 == null) goto L11;
        ((ConcurrentHashMap) r10).put("bulletStorageValues", r15);     // Catch: Throwable -> L18
        ((ConcurrentHashMap) r10).putAll(r15);     // Catch: Throwable -> L18
    L11:
        if (r13 == null) goto L21;
        Map r16 = r13.a(r11, r12);     // Catch: Throwable -> L18
        if (r16 == null) goto L21;
        Map r17 = MapsKt.toMap(r16);     // Catch: Throwable -> L18
        if (r17 == null) goto L21;
        ((ConcurrentHashMap) r10).put("userDomainStorageValues", r17);     // Catch: Throwable -> L18
        ((ConcurrentHashMap) r10).putAll(r17);     // Catch: Throwable -> L18
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:putStorageGlobalProps");
        throw th;
    }

    public static Map l(KitType r10, String r11, Uri r12) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(k(r10, r11));
        com.bytedance.android.anniex.assemble.a r1 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXBizPropsProvider r13 = (IAnnieXBizPropsProvider) com.bytedance.android.anniex.assemble.a.g(r11, IAnnieXBizPropsProvider.class);
        if (r13 == null) goto L5;
        r13.a(r0, r10, r11, r12);
    L5:
        Map r14 = q(com.bytedance.ies.bullet.core.h.h.b);
        if (r14 == null) goto L12;
        r0.putAll(r14);
        if (Intrinsics.areEqual(r11, "webcast") == false) goto L12;
        Object r15 = r14.get("statusBarHeight");
        if (r15 == null) goto L12;
        r0.put("status_bar_height", r15);
    L12:
        return r0;
    }

    @Deprecated(message = "Use getStaticGlobalPropsForAppend instead")
    public static Map m(String r10, List r11, Uri r12) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r12, "uri");
        LinkedHashMap r0 = new LinkedHashMap();
        Map r13 = l(n(r12), r10, r12);
        if (r11 == null) goto L10;
        Iterator r14 = r11.iterator();
    L6:
        if (r14.hasNext() == false) goto L10;
        String r15 = (String) r14.next();
        Object r1 = ((LinkedHashMap) r13).get(r15);
        if (r1 == null) goto L6;
        r0.put(r15, r1.toString());
    L10:
        return r0;
    }

    public static Map p(String r10, KitType r11, Context r12) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "kitType");
        TraceEvent.beginSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        IAnnieXPropsProvider r13 = d(r10);     // Catch: Throwable -> L14
        if ((r13 instanceof BaseAnnieXPropsProvider) == false) goto L6;
        BaseAnnieXPropsProvider r14 = (BaseAnnieXPropsProvider) r13;     // Catch: Throwable -> L14
    L7:
        if (r14 == null) goto L9;
        Intrinsics.checkNotNullParameter(r10, "bid");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r11, "kitType");     // Catch: Throwable -> L14
    L12:
        TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        return null;
    L9:
        IAnnieXPropsProvider r0 = d(r10);     // Catch: Throwable -> L14
        if (r0 == null) goto L12;
        r0.t0(r10, r11, r12);     // Catch: Throwable -> L14
        goto L12
    L6:
        r14 = null;
    L14:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:getPageGlobalPropsByActivity");
        throw th;
    }

    public static Map r(Uri r10, String r11, String r12, List r13) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        LinkedHashMap r14 = new LinkedHashMap();
        KitType r15 = n(r10);
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r15, "kitType");
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        PropsUtilsKt.d(null);
        k(KitType.LYNX, "default_bid");
        k(KitType.WEB, "default_bid");
        LinkedHashMap r0 = new LinkedHashMap();
        Map r1 = l(r15, r11, r10);
        Map r16 = s(r15, r10, r11, r12, false);
        r0.putAll(r1);
        r0.putAll(r16);
        if (r13 == null) goto L10;
        Iterator r17 = r13.iterator();
    L6:
        if (r17.hasNext() == false) goto L10;
        String r18 = (String) r17.next();
        Object r19 = r0.get(r18);
        if (r19 == null) goto L6;
        r14.put(r18, r19);
    L10:
        return r14;
    }

    public static Map s(KitType r10, Uri r11, String r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "kitType");
        Intrinsics.checkNotNullParameter(r11, "uri");
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        TraceEvent.beginSection("GlobalPropsHelper:getUriGlobalProps");
        String r0 = r11.toString();     // Catch: Throwable -> L42
        LruCache<String, ConcurrentHashMap<String, Object>> r1 = d;     // Catch: Throwable -> L42
        ConcurrentHashMap<String, Object> r15 = r1.get(r0);     // Catch: Throwable -> L42
        boolean r16 = false;
        boolean r17 = true;
        if (r15 != null) goto L6;
    L9:
        boolean r18 = true;
    L10:
        if (r18 == true) goto L14;
        if (r14 == false) goto L14;
        ConcurrentHashMap<String, Object> r19 = r1.get(r0);     // Catch: Throwable -> L42
    L37:
        TraceEvent.endSection("GlobalPropsHelper:getUriGlobalProps");
        return r19;
    L14:
        ConcurrentHashMap<String, Object> r20 = new ConcurrentHashMap();     // Catch: Throwable -> L42
        TraceEvent.beginSection("GlobalPropsHelper:getPageDynamicProps");     // Catch: Throwable -> L42
        IAnnieXPropsProvider r21 = d(r12);     // Catch: Throwable -> L39
        if (r21 == null) goto L18;
        r21.q(r12, r10, r11);     // Catch: Throwable -> L39
        LinkedHashMap r22 = null;
    L19:
        TraceEvent.endSection("GlobalPropsHelper:getPageDynamicProps");     // Catch: Throwable -> L42
        if (r22 == null) goto L22;
        r20.putAll(r22);     // Catch: Throwable -> L42
    L22:
        i(r20, r11);     // Catch: Throwable -> L42
        if (r10 != KitType.WEB) goto L25;
        r16 = true;
    L25:
        h(r20, r11, r16);     // Catch: Throwable -> L42
        j(r20, r11, com.bytedance.ies.bullet.core.h.h.b);     // Catch: Throwable -> L42
        Map r23 = x26.a.a;     // Catch: Throwable -> L42
        w26.g r24 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L42
        if (r24 == null) goto L32;
        w26.e r25 = (w26.e) r24.n0(w26.e.class);     // Catch: Throwable -> L42
        if (r25 == null) goto L32;
        Boolean r26 = r25.E1();     // Catch: Throwable -> L42
        if (r26 == null) goto L32;
        r17 = r26.booleanValue();     // Catch: Throwable -> L42
    L32:
        if (r17 == false) goto L34;
        g(r20, r11);     // Catch: Throwable -> L42
    L34:
        if (r14 == false) goto L36;
        r1.put(r0, r20);     // Catch: Throwable -> L42
    L36:
        r19 = r20;
        goto L37
    L18:
        r22 = new LinkedHashMap();     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:getPageDynamicProps");     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L6:
        if (r15.isEmpty() == true) goto L9;
        r18 = false;
    L42:
        th = move-exception;
        TraceEvent.endSection("GlobalPropsHelper:getUriGlobalProps");
        throw th;
    }
}
