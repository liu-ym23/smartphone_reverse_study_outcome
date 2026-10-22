package o3;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.util.LruCache;
import com.bytedance.android.anniex.base.service.c;
import com.bytedance.ies.bullet.core.device.PropsUtilsKt;
import com.bytedance.ies.bullet.prefetchv2.o;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.h;
import com.lynx.tasm.utils.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import m.f0;
import xc.d;
import xc.e;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f20403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache f20404b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache f20405c = null;
    public static final LruCache d = null;

    static {
        f20403a = new ConcurrentHashMap();
        f20404b = new LruCache(1024);
        f20405c = new LruCache(1024);
        d = new LruCache(1024);
    }

    public static KitType a(Uri r5) {
        String r10 = r5.getScheme();
        if (r10 == null) goto L27;
        int r11 = r10.hashCode();
        if (r11 == (-1772600516)) goto L22;
        if (r11 == 3213448) goto L17;
        if (r11 != 99617003) goto L27;
        if (r10.equals(IIvyAIPackageResourceService.SCHEMA) == false) goto L27;
        return KitType.f6012c;
    L17:
        if (r10.equals("http") == false) goto L27;
        return KitType.f6012c;
    L22:
        if (r10.equals("lynxview") == false) goto L27;
        return KitType.d;
    L27:
        return KitType.f6011b;
    }

    public static final LinkedHashMap b(Activity r10) {
        int r5 = nb.a.j(r10);
        int r11 = nb.a.h(r10);
        if (r5 == 0) goto L8;
        if (r11 == 0) goto L8;
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("screenWidth", Integer.valueOf(nb.a.b(r5, r10)));
        r12.put("screenHeight", Integer.valueOf(nb.a.b(r11, r10)));
        r12.put("screenWidthPx", Integer.valueOf(r5));
        r12.put("screenHeightPx", Integer.valueOf(r11));
        r12.put("orientation", Integer.valueOf(p(r10) ? 1 : 0));
        return r12;
    L8:
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieX", h.b(r5, r11, "getScreenSize exp width:", ", height: "), null, 12);
        if (r10.getResources().getConfiguration().orientation != 2) goto L11;
        boolean r14 = true;
    L12:
        Boolean r15 = Boolean.valueOf(r14);
        int r16 = i.a.n(r10);
        int r17 = i.a.a(r10);
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == false) goto L15;
        int r18 = Math.max(r16, r17);
        int r19 = Math.min(r16, r17);
    L16:
        LinkedHashMap r20 = new LinkedHashMap();
        r20.put("screenWidth", Integer.valueOf(nb.a.b(r18, r10)));
        r20.put("screenHeight", Integer.valueOf(nb.a.b(r19, r10)));
        r20.put("screenWidthPx", Integer.valueOf(r18));
        r20.put("screenHeightPx", Integer.valueOf(r19));
        r20.put("orientation", Integer.valueOf(p(r10) ? 1 : 0));
        return r20;
    L15:
        r18 = Math.min(r16, r17);
        r19 = Math.max(r16, r17);
        goto L16
    L11:
        r14 = false;
        goto L12
    }

    public static final LinkedHashMap c(Application r10) {
        int r5 = nb.a.j(r10);
        int r11 = nb.a.h(r10);
        if (r5 == 0) goto L8;
        if (r11 == 0) goto L8;
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("screenWidth", Integer.valueOf(nb.a.b(r5, r10)));
        r12.put("screenHeight", Integer.valueOf(nb.a.b(r11, r10)));
        r12.put("screenWidthPx", Integer.valueOf(r5));
        r12.put("screenHeightPx", Integer.valueOf(r11));
        r12.put("orientation", Integer.valueOf(q(r10) ? 1 : 0));
        return r12;
    L8:
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieX", h.b(r5, r11, "getScreenSize exp width:", ", height: "), null, 12);
        if (r10.getResources().getConfiguration().orientation != 2) goto L11;
        boolean r14 = true;
    L12:
        Boolean r15 = Boolean.valueOf(r14);
        int r16 = i.a.n(r10);
        int r17 = i.a.a(r10);
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == false) goto L15;
        int r18 = Math.max(r16, r17);
        int r19 = Math.min(r16, r17);
    L16:
        LinkedHashMap r20 = new LinkedHashMap();
        r20.put("screenWidth", Integer.valueOf(nb.a.b(r18, r10)));
        r20.put("screenHeight", Integer.valueOf(nb.a.b(r19, r10)));
        r20.put("screenWidthPx", Integer.valueOf(r18));
        r20.put("screenHeightPx", Integer.valueOf(r19));
        r20.put("orientation", Integer.valueOf(q(r10) ? 1 : 0));
        return r20;
    L15:
        r18 = Math.min(r16, r17);
        r19 = Math.max(r16, r17);
        goto L16
    L11:
        r14 = false;
        goto L12
    }

    public static LinkedHashMap d(Uri r5, String r10, String r11, List r12) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        LinkedHashMap r13 = new LinkedHashMap();
        KitType r14 = a(r5);
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r14, "kitType");
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        PropsUtilsKt.c(null);
        f(KitType.d, "default_bid");
        f(KitType.f6012c, "default_bid");
        LinkedHashMap r15 = new LinkedHashMap();
        LinkedHashMap r16 = m(r14, r10);
        ConcurrentHashMap r17 = i(r14, r5, r10, r11);
        r15.putAll(r16);
        r15.putAll(r17);
        Iterator r18 = r12.iterator();
    L4:
        if (r18.hasNext() == false) goto L8;
        String r19 = (String) r18.next();
        Object r20 = r15.get(r19);
        if (r20 == null) goto L4;
        r13.put(r19, r20);
        goto L4
    L8:
        return r13;
    }

    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v5 */
    public static final LinkedHashMap e(KitType r10, String r11) {
        TraceEvent.c("GlobalPropsHelper:getCommonPageProps");
        j(r11);     // Catch: Throwable -> L10
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Throwable -> L10
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieX", "getCommonPageProps by reveal bid:" + r11 + ", kitType:" + r10.f6013a, null, 12);     // Catch: Throwable -> L10
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L10
        com.bytedance.ies.bullet.core.h r13 = com.bytedance.ies.bullet.core.h.g;     // Catch: Throwable -> L10
        Application r14 = r13.f5316b;     // Catch: Throwable -> L10
        if (r14 == null) goto L21;
        r12.putAll(PropsUtilsKt.getPageCommonProps(r14));     // Catch: Throwable -> L10
        Application r15 = r13.f5316b;     // Catch: Throwable -> L10
        ?? r16 = 0;
        if (r15 == null) goto L12;
        int r17 = r15.getResources().getIdentifier("status_bar_height", "dimen", "android");     // Catch: Throwable -> L10
        if (r17 <= 0) goto L12;
        int r18 = r15.getResources().getDimensionPixelSize(r17);     // Catch: Throwable -> L10
    L13:
        int r19 = g.c(r14, r18);     // Catch: Throwable -> L10
        if (r14.getResources().getConfiguration().orientation != 2) goto L16;
        r16 = 1;
    L16:
        Boolean r20 = Boolean.valueOf(r16);     // Catch: Throwable -> L10
        int r21 = g.c(r14, i.a.n(r14));     // Catch: Throwable -> L10
        int r22 = g.c(r14, i.a.a(r14));     // Catch: Throwable -> L10
        if (Intrinsics.areEqual(r20, Boolean.TRUE) == false) goto L19;
        int r23 = Math.max(r21, r22);     // Catch: Throwable -> L10
        int r24 = Math.min(r21, r22);     // Catch: Throwable -> L10
    L20:
        r12.put("screenWidth", Integer.valueOf(r23));     // Catch: Throwable -> L10
        r12.put("screenHeight", Integer.valueOf(r24));     // Catch: Throwable -> L10
        r12.put("statusBarHeight", Integer.valueOf(r19));     // Catch: Throwable -> L10
        r12.put("topHeight", Integer.valueOf(r19));     // Catch: Throwable -> L10
        r12.put("isLandscape", Integer.valueOf(r16));     // Catch: Throwable -> L10
        goto L21
    L19:
        r23 = Math.min(r21, r22);     // Catch: Throwable -> L10
        r24 = Math.max(r21, r22);     // Catch: Throwable -> L10
    L12:
        r18 = 0;
    L21:
        TraceEvent.a(0, "GlobalPropsHelper:getCommonPageProps");
        return r12;
    L10:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:getCommonPageProps");
        throw th;
    }

    public static Map f(KitType r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "kitType");
        Intrinsics.checkNotNullParameter(r11, "bid");
        TraceEvent.c("GlobalPropsHelper:getCommonGlobalProps");
        String r5 = r11 + '_' + r10.f6013a;     // Catch: Throwable -> L8
        LruCache r12 = f20404b;     // Catch: Throwable -> L8
        Map r13 = (Map) r12.get(r11 + '_' + r10.f6013a);     // Catch: Throwable -> L8
        if (r13 != null) goto L6;
    L10:
        ConcurrentHashMap r14 = new ConcurrentHashMap();     // Catch: Throwable -> L8
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieX", "getCommonGlobalProps withoutCache", null, 12);     // Catch: Throwable -> L8
        r14.putAll(g());     // Catch: Throwable -> L8
        TraceEvent.c("GlobalPropsHelper:getCommonAppProps");     // Catch: Throwable -> L8
        j(r11);     // Catch: Throwable -> L32
        LinkedHashMap r15 = new LinkedHashMap();     // Catch: Throwable -> L32
        TraceEvent.a(0, "GlobalPropsHelper:getCommonAppProps");     // Catch: Throwable -> L8
        r14.putAll(r15);     // Catch: Throwable -> L8
        ((com.bytedance.android.anniex.base.depend.b) com.bytedance.android.anniex.base.depend.a.f3113b.getValue()).getClass();     // Catch: Throwable -> L8
        r14.put("isPreInstallApp", 0);     // Catch: Throwable -> L8
        r14.putAll(e(r10, r11));     // Catch: Throwable -> L8
        if (r10 != KitType.d) goto L21;
        TraceEvent.c("GlobalPropsHelper:getLynxCommonProps");     // Catch: Throwable -> L8
        LinkedHashMap r16 = new LinkedHashMap();     // Catch: Throwable -> L17
        r16.put("lynxSdkVersion", LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L17
        TraceEvent.a(0, "GlobalPropsHelper:getLynxCommonProps");     // Catch: Throwable -> L8
        r14.putAll(r16);     // Catch: Throwable -> L8
    L28:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L8
        r12.put(r5, r14);     // Catch: Throwable -> L8
    L29:
        Object r18 = r12.get(r5);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");     // Catch: Throwable -> L8
        Map r19 = TypeIntrinsics.asMutableMap(r18);     // Catch: Throwable -> L8
        TraceEvent.a(0, "GlobalPropsHelper:getCommonGlobalProps");
        return r19;
    L17:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:getLynxCommonProps");     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L21:
        if (r10 != KitType.f6012c) goto L28;
        TraceEvent.c("GlobalPropsHelper:getWebCommonProps");     // Catch: Throwable -> L8
        LinkedHashMap r110 = new LinkedHashMap();     // Catch: Throwable -> L25
        TraceEvent.a(0, "GlobalPropsHelper:getWebCommonProps");     // Catch: Throwable -> L8
        r14.putAll(r110);     // Catch: Throwable -> L8
        goto L28
    L25:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:getWebCommonProps");     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L32:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:getCommonAppProps");     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L6:
        if (r13.isEmpty() == false) goto L29;
    L8:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:getCommonGlobalProps");
        throw th;
    }

    public static final ConcurrentHashMap g() {
        TraceEvent.c("GlobalPropsHelper:getDeviceProps");
        ConcurrentHashMap r5 = f20403a;     // Catch: Throwable -> L10
        if (r5.isEmpty() == false) goto L12;
        PropsUtilsKt.c(null);     // Catch: Throwable -> L10
        if (com.bytedance.ies.bullet.core.h.g.f5316b == null) goto L12;
        LinkedHashMap r10 = new LinkedHashMap();     // Catch: Throwable -> L10
        r10.putAll(PropsUtilsKt.f5290a);     // Catch: Throwable -> L10
        r5.putAll(r10);     // Catch: Throwable -> L10
    L12:
        TraceEvent.a(0, "GlobalPropsHelper:getDeviceProps");
        return r5;
    L10:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:getDeviceProps");
        throw th;
    }

    public static final ConcurrentHashMap h(Context r5) {
        TraceEvent.c("GlobalPropsHelper:getDeviceProps");
        ConcurrentHashMap r10 = f20403a;     // Catch: Throwable -> L10
        if (r10.isEmpty() == false) goto L12;
        PropsUtilsKt.c(r5);     // Catch: Throwable -> L10
        if (r5 == null) goto L12;
        LinkedHashMap r11 = new LinkedHashMap();     // Catch: Throwable -> L10
        r11.putAll(PropsUtilsKt.f5290a);     // Catch: Throwable -> L10
        r10.putAll(r11);     // Catch: Throwable -> L10
    L12:
        TraceEvent.a(0, "GlobalPropsHelper:getDeviceProps");
        return r10;
    L10:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:getDeviceProps");
        throw th;
    }

    public static ConcurrentHashMap i(KitType r5, Uri r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "kitType");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        TraceEvent.c("GlobalPropsHelper:getUriGlobalProps");
        Map r13 = (Map) d.get(r10.toString());     // Catch: Throwable -> L6
        if (r13 == null) goto L8;
        r13.isEmpty();     // Catch: Throwable -> L6
    L8:
        ConcurrentHashMap r14 = new ConcurrentHashMap();     // Catch: Throwable -> L6
        TraceEvent.c("GlobalPropsHelper:getPageDynamicProps");     // Catch: Throwable -> L6
        j(r11);     // Catch: Throwable -> L41
        LinkedHashMap r15 = new LinkedHashMap();     // Catch: Throwable -> L41
        TraceEvent.a(0, "GlobalPropsHelper:getPageDynamicProps");     // Catch: Throwable -> L6
        r14.putAll(r15);     // Catch: Throwable -> L6
        o(r14, r10);     // Catch: Throwable -> L6
        k(r14, r10);     // Catch: Throwable -> L6
        l(r14, r10, com.bytedance.ies.bullet.core.h.g.f5316b);     // Catch: Throwable -> L6
        ConcurrentHashMap r16 = yc.a.f23246a;     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(e.class, "cls");     // Catch: Throwable -> L6
        e r17 = (e) yc.a.a(e.class, "default_bid");     // Catch: Throwable -> L6
        if (r17 == null) goto L17;
        d r18 = (d) r17.a(d.class);     // Catch: Throwable -> L6
        if (r18 == null) goto L17;
        Boolean r19 = r18.C0();     // Catch: Throwable -> L6
        if (r19 == null) goto L17;
        boolean r20 = r19.booleanValue();     // Catch: Throwable -> L6
    L18:
        if (r20 == false) goto L39;
        TraceEvent.c("GlobalPropsHelper:putGlobalProps");     // Catch: Throwable -> L6
        List r21 = o.a(r10);     // Catch: Throwable -> L31
        if (r21 != null) goto L23;
    L35:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L31
        TraceEvent.a(0, "GlobalPropsHelper:putGlobalProps");     // Catch: Throwable -> L6
        goto L39
    L23:
        if ((!r21.isEmpty()) != true) goto L35;
        Iterator r23 = r21.iterator();     // Catch: Throwable -> L31
        if (r23.hasNext() == false) goto L35;
        if (r23.next() != null) goto L34;
        throw null;     // Catch: Throwable -> L31
    L34:
        throw new ClassCastException();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:putGlobalProps");     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L39:
        TraceEvent.a(0, "GlobalPropsHelper:getUriGlobalProps");
        return r14;
    L17:
        r20 = true;
        goto L18
    L41:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:getPageDynamicProps");     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:getUriGlobalProps");
        throw th;
    }

    public static final void j(String r5) {
        if (((Boolean) com.bytedance.android.anniex.lite.utils.a.f3257a.getValue()).booleanValue() == false) goto L5;
        c.a(p3.g.class, r5);
        return;
    L5:
        com.bytedance.android.anniex.assemble.a.b(p3.g.class, r5);
        tc.c r10 = tc.c.f22119c;
        if (tc.c.f22119c.a(p3.g.class, r5) != null) goto L9;
        return;
    L9:
        throw new ClassCastException();
    }

    public static final void k(ConcurrentHashMap r10, Uri r11) {
        TraceEvent.c("GlobalPropsHelper:putQueryItems");
        LinkedHashMap r5 = new LinkedHashMap();     // Catch: Throwable -> L7
        Iterator<T> r12 = r11.getQueryParameterNames().iterator();     // Catch: Throwable -> L7
    L5:
        if (r12.hasNext() == false) goto L9;
        String r13 = (String) r12.next();     // Catch: Throwable -> L7
        r5.put(r13, r11.getQueryParameter(r13));     // Catch: Throwable -> L7
        goto L5
    L9:
        r10.put("queryItems", r5);     // Catch: Throwable -> L7
        TraceEvent.a(0, "GlobalPropsHelper:putQueryItems");
        return;
    L7:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:putQueryItems");
        throw th;
    }

    public static final void l(ConcurrentHashMap r10, Uri r11, Context r12) {
        TraceEvent.c("GlobalPropsHelper:putStorageGlobalProps");
        if (r12 != null) goto L20;
    L18:
        TraceEvent.a(0, "GlobalPropsHelper:putStorageGlobalProps");
        return;
    L20:
        ConcurrentHashMap r5 = yc.a.f23246a;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(lj.a.class, "cls");     // Catch: Throwable -> L9
        lj.a r13 = (lj.a) yc.a.a(lj.a.class, "default_bid");     // Catch: Throwable -> L9
        if (r13 == null) goto L11;
        Map r14 = MapsKt.toMap(lj.a.a(r12, r11));     // Catch: Throwable -> L9
        if (r14 == null) goto L11;
        r10.put("bulletStorageValues", r14);     // Catch: Throwable -> L9
        r10.putAll(r14);     // Catch: Throwable -> L9
    L11:
        if (r13 == null) goto L18;
        Map r15 = MapsKt.toMap(lj.a.b(r12, r11));     // Catch: Throwable -> L9
        if (r15 == null) goto L18;
        r10.put("userDomainStorageValues", r15);     // Catch: Throwable -> L9
        r10.putAll(r15);     // Catch: Throwable -> L9
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:putStorageGlobalProps");
        throw th;
    }

    public static LinkedHashMap m(KitType r16, String r17) {
        LinkedHashMap r5 = new LinkedHashMap();
        r5.putAll(f(r16, r17));
        com.bytedance.android.anniex.assemble.a.b(p3.b.class, r17);
        Application r10 = com.bytedance.ies.bullet.core.h.g.f5316b;
        TraceEvent.c("GlobalPropsHelper:getPageGlobalPropsByActivity");
        ConcurrentHashMap r11 = null;
        if (r10 == null) goto L34;
        LruCache r12 = f20405c;     // Catch: Throwable -> L7
        if (r12.get(Integer.valueOf(r10.hashCode())) == null) goto L9;
        ConcurrentHashMap r13 = (ConcurrentHashMap) r12.get(Integer.valueOf(r10.hashCode()));     // Catch: Throwable -> L7
        boolean r15 = true;
    L28:
        if (r13.get("screenWidth") != null) goto L30;
    L31:
        String r14 = "getScreenWidth exp, is by cache :" + r15;     // Catch: Throwable -> L7
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieX", r14, null, 12);     // Catch: Throwable -> L7
        f0.j(r14);     // Catch: Throwable -> L7
    L32:
        r11 = r13;
    L36:
        TraceEvent.a(0, "GlobalPropsHelper:getPageGlobalPropsByActivity");
        if (r11 == null) goto L43;
        r5.putAll(r11);
        if (Intrinsics.areEqual(r17, "webcast") == false) goto L43;
        Object r18 = r11.get("statusBarHeight");
        if (r18 == null) goto L43;
        r5.put("status_bar_height", r18);
    L43:
        return r5;
    L30:
        if (Intrinsics.areEqual(r13.get("screenWidth"), 0) == false) goto L32;
    L9:
        ConcurrentHashMap r19 = new ConcurrentHashMap();     // Catch: Throwable -> L7
        r19.putAll(c(r10));     // Catch: Throwable -> L7
        r19.put("statusBarHeight", Integer.valueOf(nb.a.b(nb.a.k(r10), r10)));     // Catch: Throwable -> L7
        r19.putAll(PropsUtilsKt.getPageCommonProps(r10));     // Catch: Throwable -> L7
        Object r20 = r19.get("contentHeight");     // Catch: Throwable -> L7
        if (r20 == null) goto L13;
        r19.put("safeAreaHeight", r20);     // Catch: Throwable -> L7
    L13:
        if (r10.getResources().getConfiguration().orientation != 2) goto L15;
        int r21 = 1;
    L16:
        r19.put("isLandscape", Integer.valueOf(r21));     // Catch: Throwable -> L7
        ConcurrentHashMap r22 = yc.a.f23246a;     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(e.class, "cls");     // Catch: Throwable -> L7
        e r23 = (e) yc.a.a(e.class, "default_bid");     // Catch: Throwable -> L7
        if (r23 == null) goto L23;
        d r24 = (d) r23.a(d.class);     // Catch: Throwable -> L7
        if (r24 == null) goto L23;
        Boolean r25 = r24.K();     // Catch: Throwable -> L7
        if (r25 == null) goto L23;
        boolean r110 = r25.booleanValue();     // Catch: Throwable -> L7
    L24:
        if (r110 == false) goto L26;
        r19.putAll(h(r10));     // Catch: Throwable -> L7
    L26:
        r12.put(Integer.valueOf(r10.hashCode()), r19);     // Catch: Throwable -> L7
        r13 = r19;
        r15 = false;
    L23:
        r110 = true;
        goto L24
    L15:
        r21 = 0;
        goto L16
    L34:
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieX", "getPageGlobalPropsByActivity exp: context is not activity", null, 12);     // Catch: Throwable -> L7
        f0.j("getPageGlobalPropsByActivity exp: context is not activity");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:getPageGlobalPropsByActivity");
        throw th;
    }

    public static ConcurrentHashMap n(Context r17) {
        TraceEvent.c("GlobalPropsHelper:getPageGlobalPropsByActivity");
        if (r17 != null) goto L58;
    L52:
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieX", "getPageGlobalPropsByActivity exp: context is not activity", null, 12);     // Catch: Throwable -> L10
        f0.j("getPageGlobalPropsByActivity exp: context is not activity");     // Catch: Throwable -> L10
        ConcurrentHashMap r10 = null;
    L54:
        TraceEvent.a(0, "GlobalPropsHelper:getPageGlobalPropsByActivity");
        return r10;
    L58:
    L10:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:getPageGlobalPropsByActivity");
        throw th;
    L5:
        if ((r17 instanceof Activity) == false) goto L52;
        Activity r11 = (Activity) r17;     // Catch: Throwable -> L10
        LruCache r12 = f20405c;     // Catch: Throwable -> L10
        boolean r16 = true;
        if (r12.get(Integer.valueOf(r11.hashCode())) == null) goto L12;
        ConcurrentHashMap r13 = (ConcurrentHashMap) r12.get(Integer.valueOf(r11.hashCode()));     // Catch: Throwable -> L10
        boolean r5 = true;
    L27:
        ConcurrentHashMap r14 = yc.a.f23246a;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(e.class, "cls");     // Catch: Throwable -> L10
        e r15 = (e) yc.a.a(e.class, "default_bid");     // Catch: Throwable -> L10
        if (r15 == null) goto L34;
        d r18 = (d) r15.a(d.class);     // Catch: Throwable -> L10
        if (r18 == null) goto L34;
        Boolean r19 = r18.U();     // Catch: Throwable -> L10
        if (r19 == null) goto L34;
        boolean r20 = r19.booleanValue();     // Catch: Throwable -> L10
    L35:
        if (r20 == false) goto L46;
        ConcurrentHashMap r21 = PropsUtilsKt.f5290a;     // Catch: Throwable -> L10
        LinkedHashMap r22 = new LinkedHashMap();     // Catch: Throwable -> L10
        if (r17.getResources().getConfiguration().orientation == 2) goto L41;
        r16 = false;
    L41:
        if (r16 == false) goto L43;
        String r23 = "landscape";
    L44:
        r22.put("screenOrientation", r23);     // Catch: Throwable -> L10
        r13.putAll(r22);     // Catch: Throwable -> L10
        goto L46
    L43:
        r23 = "portrait";
    L46:
        if (r13.get("screenWidth") != null) goto L48;
    L49:
        String r24 = "getScreenWidth exp, is by cache :" + r5;     // Catch: Throwable -> L10
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieX", r24, null, 12);     // Catch: Throwable -> L10
        f0.j(r24);     // Catch: Throwable -> L10
    L50:
        r10 = r13;
        goto L54
    L48:
        if (Intrinsics.areEqual(r13.get("screenWidth"), 0) == false) goto L50;
    L34:
        r20 = true;
        goto L35
    L12:
        ConcurrentHashMap r110 = new ConcurrentHashMap();     // Catch: Throwable -> L10
        r110.putAll(b(r11));     // Catch: Throwable -> L10
        r110.put("statusBarHeight", Integer.valueOf(nb.a.b(nb.a.k(r11), r11)));     // Catch: Throwable -> L10
        r110.putAll(PropsUtilsKt.getPageCommonProps(r11));     // Catch: Throwable -> L10
        if (r11.getResources().getConfiguration().orientation != 2) goto L15;
        int r25 = 1;
    L16:
        r110.put("isLandscape", Integer.valueOf(r25));     // Catch: Throwable -> L10
        ConcurrentHashMap r26 = yc.a.f23246a;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(e.class, "cls");     // Catch: Throwable -> L10
        e r27 = (e) yc.a.a(e.class, "default_bid");     // Catch: Throwable -> L10
        if (r27 == null) goto L23;
        d r28 = (d) r27.a(d.class);     // Catch: Throwable -> L10
        if (r28 == null) goto L23;
        Boolean r29 = r28.K();     // Catch: Throwable -> L10
        if (r29 == null) goto L23;
        boolean r30 = r29.booleanValue();     // Catch: Throwable -> L10
    L24:
        if (r30 == false) goto L26;
        r110.putAll(h(r17));     // Catch: Throwable -> L10
    L26:
        r12.put(Integer.valueOf(r11.hashCode()), r110);     // Catch: Throwable -> L10
        r13 = r110;
        r5 = false;
    L23:
        r30 = true;
        goto L24
    L15:
        r25 = 0;
        goto L16
    }

    public static final void o(ConcurrentHashMap r10, Uri r11) {
        TraceEvent.c("GlobalPropsHelper:putSchemeItems");
        String r5 = m.f(r11, "font_scale");     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        r10.put("fontScale", Float.valueOf(Float.parseFloat(r5)));     // Catch: Throwable -> L6
        r10.put("font_scale", Float.valueOf(Float.parseFloat(r5)));     // Catch: Throwable -> L6
    L8:
        String r12 = m.f(r11, "view_zoom");     // Catch: Throwable -> L6
        if (r12 == null) goto L11;
        r10.put("viewZoom", Float.valueOf(Float.parseFloat(r12)));     // Catch: Throwable -> L6
    L11:
        TraceEvent.a(0, "GlobalPropsHelper:putSchemeItems");
        return;
    L6:
        th = move-exception;
        TraceEvent.a(0, "GlobalPropsHelper:putSchemeItems");
        throw th;
    }

    public static boolean p(Activity r5) {
        if (r5 == null) goto L4;
        Integer r10 = Integer.valueOf(r5.getRequestedOrientation());
    L5:
        if (r10 != null) goto L8;
    L9:
        if (r10 != null) goto L12;
    L13:
        if (r10 != null) goto L16;
        return false;
    L16:
        if (r10.intValue() == 6) goto L24;
        return false;
    L24:
        return true;
    L12:
        if (r10.intValue() != 8) goto L13;
        return true;
    L8:
        if (r10.intValue() != 0) goto L9;
        return true;
    L4:
        r10 = null;
        goto L5
    }

    public static boolean q(Application r5) {
        if (r5 == null) goto L8;
        Resources r10 = r5.getResources();
        if (r10 == null) goto L8;
        Configuration r11 = r10.getConfiguration();
        if (r11 == null) goto L8;
        Integer r12 = Integer.valueOf(r11.orientation);
    L9:
        if (r12 != null) goto L12;
    L13:
        if (r12 != null) goto L16;
    L17:
        if (r12 != null) goto L20;
        return false;
    L20:
        if (r12.intValue() == 6) goto L28;
        return false;
    L28:
        return true;
    L16:
        if (r12.intValue() != 8) goto L17;
        return true;
    L12:
        if (r12.intValue() != 0) goto L13;
        return true;
    L8:
        r12 = null;
        goto L9
    }
}
