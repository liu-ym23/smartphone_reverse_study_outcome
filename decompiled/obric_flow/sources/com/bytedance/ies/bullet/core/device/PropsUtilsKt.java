package com.bytedance.ies.bullet.core.device;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import androidx.annotation.Keep;
import com.bytedance.ai.ex.widget.WidgetView;
import com.bytedance.android.anniex.base.depend.c;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.bullet.service.base.b;
import com.bytedance.ies.bullet.service.base.d;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.x;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import nb.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\u001a;\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a%\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u0010\u001a'\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "kitType", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/bullet/core/e;", "bulletContext", "", "", "", "getDeviceProps", "(Lcom/bytedance/ies/bullet/service/base/utils/KitType;Landroid/content/Context;Lcom/bytedance/ies/bullet/core/e;)Ljava/util/Map;", "", "withSafeAreaHeight", "", "getPageCommonProps", "(Landroid/content/Context;Z)Ljava/util/Map;", "(Landroid/content/Context;)Ljava/util/Map;", "getContainerProps", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nPropsUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PropsUtils.kt\ncom/bytedance/ies/bullet/core/device/PropsUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,352:1\n1#2:353\n*E\n"})
public final class PropsUtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f5290a = null;

    static {
        f5290a = new ConcurrentHashMap();
    }

    public static final String a() {
        List r5 = a.f20224a;
        String r10 = Build.MODEL;
        String r11 = Build.BRAND;
        if (r10 != null) goto L5;
        return r11;
    L5:
        if (r11 != null) goto L7;
        return r10;
    L7:
        if (StringsKt.g(r10, r11) == false) goto L9;
        return r10;
    L9:
        return androidx.constraintlayout.motion.widget.a.m(r11, ' ', r10);
    }

    public static final boolean b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r10 = r5.getSystemService("activity");     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L9
        if (((ActivityManager) r10).getDeviceConfigurationInfo().reqGlEsVersion < 196608) goto L8;
        return true;
    L8:
        return false;
    }

    public static final void c(Context r5) {
        ConcurrentHashMap r10 = f5290a;
        if (r10.isEmpty() == false) goto L9;
        if (r5 != null) goto L6;
        r5 = h.g.f5316b;
    L6:
        if (r5 == null) goto L10;
        boolean r11 = b(r5);
        boolean r12 = b.f5956a;
        b.a(6, "getDeviceProps: isGLES3Support=" + r11, null);
        List r13 = a.f20224a;
        String r14 = Build.MODEL;
        r10.put("deviceModel", r14);
        r10.put("os", "android");
        r10.put("osVersion", Build.VERSION.RELEASE);
        r10.put("language", a.c());
        r10.put("deviceBrand", Build.BRAND);
        r10.put("glesVer", Integer.valueOf(a.g(r5)));
        r10.put("is32", Integer.valueOf(a.f() ? 1 : 0));
        r10.put(WidgetView.DENSITY, Float.valueOf(a.a(r5)));
        r10.put("isAccessable", Integer.valueOf(a.l(r5) ? 1 : 0));
        r10.put("deviceType", r14);
        r10.put("isGLES3Support", Boolean.valueOf(r11));
        r10.put("slardarModel", a());
        Lazy r15 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((c) r15.getValue()).getClass();
        r10.put("isFoldableDevice", 0);
        ((c) r15.getValue()).getClass();
        return;
    L10:
        return;
    }

    @Keep
    public static final Map<String, Object> getContainerProps(Context r5) {
        xq.b.f();
        if (r5 != null) goto L6;
        return null;
    L6:
        Activity r10 = ug.a.a(r5);
        if (r10 == null) goto L13;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L13;
        View r12 = r11.getDecorView();
        if (r12 == null) goto L13;
        int r13 = r12.getWidth();
        int r14 = r12.getHeight();
    L14:
        if (r13 <= 0) goto L16;
        if (r14 <= 0) goto L16;
    L22:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("containerWidth", Integer.valueOf(a.b(r13, r5))), TuplesKt.to("containerHeight", Integer.valueOf(a.b(r14, r5)))});
    L16:
        Resources r15 = r5.getResources();
        if (r15 == null) goto L22;
        DisplayMetrics r16 = r15.getDisplayMetrics();
        if (r16 == null) goto L22;
        r13 = r16.widthPixels;
        r14 = r16.heightPixels;
    L13:
        r13 = 0;
        r14 = 0;
        goto L14
    }

    @Keep
    public static final Map<String, Object> getDeviceProps(KitType r24, Context r25, e r26) {
        Intrinsics.checkNotNullParameter(r24, "kitType");
        if (r25 != null) goto L5;
        return null;
    L5:
        List r5 = a.f20224a;
        float r10 = r25.getResources().getDisplayMetrics().density;
        long r11 = System.currentTimeMillis();
        tc.c r12 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r13 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r13 == null) goto L8;
        d r14 = (d) r13.f6163b.getValue();
    L8:
        com.bytedance.ies.bullet.settings.b r15 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r15 == null) goto L11;
        d r16 = (d) r15.f6163b.getValue();
    L11:
        boolean r17 = b(r25);
        boolean r18 = b.f5956a;
        b.a(6, "getDeviceProps: isGLES3Support=" + r17, null);
        Pair r19 = TuplesKt.to("screenWidth", Integer.valueOf(a.b((double) a.j(r25), r25)));
        Pair r20 = TuplesKt.to("screenHeight", Integer.valueOf(a.b((double) a.h(r25), r25)));
        Pair r110 = TuplesKt.to("statusBarHeight", Integer.valueOf(a.b(a.k(r25), r25)));
        String r21 = Build.MODEL;
        Pair r111 = TuplesKt.to("deviceModel", r21);
        Pair r112 = TuplesKt.to("os", "android");
        Pair r113 = TuplesKt.to("osVersion", Build.VERSION.RELEASE);
        Pair r114 = TuplesKt.to("language", a.c());
        Pair r115 = TuplesKt.to("deviceBrand", Build.BRAND);
        Pair r116 = TuplesKt.to("glesVer", Integer.valueOf(a.g(r25)));
        Pair r117 = TuplesKt.to("is32", Integer.valueOf(a.f() ? 1 : 0));
        Pair r118 = TuplesKt.to(WidgetView.DENSITY, Float.valueOf(a.a(r25)));
        Pair r119 = TuplesKt.to("isAccessable", Integer.valueOf(a.l(r25) ? 1 : 0));
        Pair r22 = TuplesKt.to("deviceType", r21);
        Pair r23 = TuplesKt.to("isGLES3Support", Boolean.valueOf(r17));
        Pair r27 = TuplesKt.to("slardarModel", a());
        Lazy r28 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((c) r28.getValue()).getClass();
        Map<String, Object> r29 = MapsKt.mutableMapOf(new Pair[]{r19, r20, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r22, r23, r27, TuplesKt.to("isFoldableDevice", 0)});
        ((c) r28.getValue()).getClass();
        ((c) r28.getValue()).getClass();
        ((c) r28.getValue()).getClass();
        long r30 = System.currentTimeMillis();
        x r31 = new x("bullet_global_props_cost");
        if (r26 == null) goto L14;
        ad.a r32 = r26.f5303q;
    L15:
        r31.f6027j = r32;
        JSONObject r33 = new JSONObject();
        r33.put("device_props_cost", Math.max(0, r30 - r11));
        r33.put("global_props_cache_optimize", 0);
        r31.f = r33;
        tc.c r34 = tc.c.f22119c;
        if (r26 == null) goto L19;
        String r35 = r26.f;
        if (r35 == null) goto L19;
    L20:
        i r36 = (i) r34.a(i.class, r35);
        if (r36 == null) goto L24;
        ((com.bytedance.ies.bullet.service.monitor.i) r36).d(r31);
    L24:
        if (TypeIntrinsics.isMutableMap(r29) == false) goto L26;
        return r29;
    L26:
        return null;
    L19:
        r35 = "default_bid";
        goto L20
    L14:
        r32 = null;
        goto L15
    }

    @Keep
    public static final Map<String, Object> getPageCommonProps(Context r5, boolean r10) {
        if (r10 == true) goto L6;
        LinkedHashMap r11 = new LinkedHashMap();
        r11.putAll(getPageCommonProps(r5));
        r11.remove("safeAreaHeight");
        return r11;
    L6:
        return getPageCommonProps(r5);
    }

    @Keep
    public static final Map<String, Object> getPageCommonProps(Context r17) {
        LinkedHashMap r5 = new LinkedHashMap();
        if (r17 != null) goto L74;
    L59:
        return r5;
    L74:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L13
        int r11 = a.h(r17);     // Catch: Throwable -> L13
        int r12 = a.j(r17);     // Catch: Throwable -> L11
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L68:
        int r13 = a.k(r17);     // Catch: Throwable -> L41
    L34:
        th = move-exception;
        Throwable r14 = th;
        int r15 = 0;
        int r16 = 0;
        int r18 = 0;
    L43:
        Result.Companion r19 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(r14));
        int r20 = r18;
        int r21 = r16;
        int r22 = r15;
    L45:
        if (r17.getResources().getConfiguration().orientation != 2) goto L47;
        boolean r23 = true;
    L49:
        if (r23 == false) goto L51;
        LinkedHashMap r110 = new LinkedHashMap();
        r110.put("marginTop", 0);
        r110.put("marginBottom", 0);
        r110.put("marginLeft", Integer.valueOf(a.b(r13, r17)));
        r110.put("marginRight", Integer.valueOf(a.b(r20, r17)));
        r5.put("safeArea", r110);
    L52:
        r5.put("topHeight", Integer.valueOf(a.b(r13, r17)));
        r5.put("bottomHeight", Integer.valueOf(a.b(r20, r17)));
        int r24 = a.b(r21, r17);
        int r25 = a.b(r12, r17);
        r5.put("contentHeight", Integer.valueOf(r24));
        r5.put("contentWidth", Integer.valueOf(r25));
        r5.put("safeAreaHeight", Integer.valueOf(a.b(r22, r17)));
        if (r23 == false) goto L55;
        String r26 = "landscape";
    L56:
        r5.put("screenOrientation", r26);
        Lazy r27 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((c) r27.getValue()).getClass();
        ((c) r27.getValue()).getClass();
        Map<String, Object> r28 = getContainerProps(r17);
        if (r28 == null) goto L59;
        r5.putAll(r28);
        goto L59
    L55:
        r26 = "portrait";
        goto L56
    L51:
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put("marginTop", Integer.valueOf(a.b(r13, r17)));
        r111.put("marginBottom", Integer.valueOf(a.b(r20, r17)));
        r111.put("marginLeft", 0);
        r111.put("marginRight", 0);
        r5.put("safeArea", r111);
        goto L52
    L47:
        r23 = false;
        goto L49
    L18:
        if ((r17 instanceof Activity) == false) goto L36;
        Rect r29 = new Rect();     // Catch: Throwable -> L34
        View r30 = ((Activity) r17).getWindow().getDecorView();     // Catch: Throwable -> L34
        r30.getWindowVisibleDisplayFrame(r29);     // Catch: Throwable -> L34
        int r31 = r30.getHeight();     // Catch: Throwable -> L34
        int r32 = r29.top;     // Catch: Throwable -> L34
        int r33 = r29.bottom;     // Catch: Throwable -> L34
        if (r31 != 0) goto L23;
        if (r32 != 0) goto L23;
        r33 = r33 + r13;     // Catch: Throwable -> L34
    L23:
        r18 = Math.max(r11 - r33, 0);     // Catch: Throwable -> L34
        r16 = Math.max((r11 - r18) - r13, 0);     // Catch: Throwable -> L32
        int r34 = r29.height();     // Catch: Throwable -> L30
        if (r32 >= r13) goto L29;
        r34 = r34 - r13;
    L29:
        r20 = r18;
        r21 = r16;
        r22 = r34;
    L60:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        int r112 = r20;
        r14 = th;
        r15 = r22;
        r16 = r21;
        r18 = r112;
    L30:
        th = move-exception;
        r14 = th;
        r15 = 0;
    L32:
        th = move-exception;
        r14 = th;
        r15 = 0;
        r16 = 0;
        goto L43
    L36:
        r22 = 0;
        r21 = 0;
        r20 = 0;
    L41:
        th = move-exception;
        r14 = th;
        r15 = 0;
        r16 = 0;
        r13 = 0;
        r18 = 0;
    L9:
        th = th;
    L15:
        Result.Companion r35 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L11:
        th = th;
        r12 = 0;
    L13:
        th = th;
        r11 = 0;
        r12 = 0;
        goto L15
    }
}
