package com.obric.oui.material;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.VectorDrawable;
import android.provider.Settings;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.color.i0;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.layout.OUIFrameLayout;
import el9.a;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class OMaterialHelper {
    public static Integer a;
    public static final Map<String, Method> b = null;
    public static final float[] c = null;

    static {
        b = new HashMap();
        new HashMap();
        c = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public static int c() {
        Map<String, Method> r0 = b;
        Method r1 = (Method) ((HashMap) r0).get("getEffectApi");
        if (r1 == null) goto L12;
    L5:
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Exception -> L9
        if ((r2 instanceof Integer) == false) goto L14;
        return ((Integer) r2).intValue();
    L9:
        e = move-exception;
        e.toString();
        return 0;
    L14:
        return 0;
    L12:
        int r5 = NativeReflect.a;     // Catch: Exception -> L9
        r1 = a("android.view.IExtEffect").getDeclaredMethod("getEffectApi", new Class[0]);     // Catch: Exception -> L9
        r1.setAccessible(true);     // Catch: Exception -> L9
        ((HashMap) r0).put("getEffectApi", r1);     // Catch: Exception -> L9
        goto L5
    }

    public static int f() {
        if (a != null) goto L6;
        a = Integer.valueOf(c());
    L6:
        return a.intValue();
    }

    public static boolean k() {
        if (f() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean l() {
        if (f() < 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static Object e(Object r2) {
        if ((r2 instanceof View) == false) goto L7;
        return i((View) r2, "view_getExtEffect", View.class);
    L7:
        if ((r2 instanceof Paint) == false) goto L11;
        return i((Paint) r2, "paint_getExtEffect", Paint.class);
    L11:
        if ((r2 instanceof VectorDrawable) == true) goto L13;
        return r2;
    L13:
        return i((VectorDrawable) r2, "vectorDrawable_getExtEffect", VectorDrawable.class);
    }

    public static int g(Context r2) {
        return Settings.Global.getInt(r2.getContentResolver(), "obric_current_effect_id", 2);
    }

    public static boolean j(Context r2) {
        if (k() == true) goto L6;
        return false;
    L6:
        if (g(r2) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static int[] z(com.obric.oui.color.a[] r5) {
        int r0 = 0;
        if (r5 == null) goto L5;
        int r1 = r5.length * 2;
        int[] r2 = new int[r1];
    L7:
        if (r0 >= r1) goto L13;
        com.obric.oui.color.a r3 = r5[r0 / 2];
        if ((r0 % 2) != 0) goto L11;
        int r4 = r3.a;
    L12:
        r2[r0] = r4;
        r0 = r0 + 1;
        goto L7
    L11:
        r4 = r3.b;
        goto L12
    L13:
        return r2;
    L5:
        return new int[0];
    }

    public static i h(Object r8, int r9) {
        Object r10 = e(r8);
        Map<String, Method> r0 = b;
        Method r1 = (Method) ((HashMap) r0).get("getEffectParas");
        if (r1 == null) goto L14;
    L5:
        Object r11 = r1.invoke(r10, new Object[]{Integer.valueOf(r9)});     // Catch: Exception -> L11
        if (r11 == null) goto L16;
        return new i(r11);
    L11:
        e = move-exception;
        e.toString();
        return null;
    L16:
        return null;
    L14:
        Class r2 = a("android.view.IExtEffect");     // Catch: Exception -> L11
        Class<?>[] r6 = {Integer.TYPE};     // Catch: Exception -> L11
        int r7 = NativeReflect.a;     // Catch: Exception -> L11
        r1 = r2.getDeclaredMethod("getEffectParas", r6);     // Catch: Exception -> L11
        r1.setAccessible(true);     // Catch: Exception -> L11
        ((HashMap) r0).put("getEffectParas", r1);     // Catch: Exception -> L11
        goto L5
    }

    public static void m(Object r10, int... r11) {
        if (k() == false) goto L15;
        Object r12 = e(r10);
        Map<String, Method> r0 = b;
        Method r1 = (Method) ((HashMap) r0).get("setObricBlendEffect_curve");
        if (r1 == null) goto L13;
    L8:
        r1.invoke(r12, new Object[]{4, Float.valueOf(1.0f), r11});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.toString();
        return;
    L13:
        Class r2 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?>[] r8 = {Integer.TYPE, Float.TYPE, int[].class};     // Catch: Exception -> L10
        int r9 = NativeReflect.a;     // Catch: Exception -> L10
        r1 = r2.getDeclaredMethod("setObricBlendEffect", r8);     // Catch: Exception -> L10
        r1.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r0).put("setObricBlendEffect_curve", r1);     // Catch: Exception -> L10
        goto L8
    }

    public static void n(Object r7, int... r8) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r9 = e(r7);
        Map<String, Method> r0 = b;
        Method r1 = (Method) ((HashMap) r0).get("setObricBlendEffectToShadow");
        if (r1 == null) goto L15;
    L10:
        if (r9 == null) goto L17;
        r1.invoke(r9, new Object[]{r8});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.toString();
        return;
    L17:
        return;
    L15:
        int r6 = NativeReflect.a;     // Catch: Exception -> L8
        r1 = a("android.view.IExtEffect").getDeclaredMethod("setObricBlendEffectToShadow", new Class[]{int[].class});     // Catch: Exception -> L8
        r1.setAccessible(true);     // Catch: Exception -> L8
        ((HashMap) r0).put("setObricBlendEffectToShadow", r1);     // Catch: Exception -> L8
        goto L10
    }

    public static void q(Object r8, int r9) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r10 = e(r8);
        Map<String, Method> r0 = b;
        Method r1 = (Method) ((HashMap) r0).get("setObricEffectSource_1");
        if (r1 == null) goto L13;
    L8:
        r1.invoke(r10, new Object[]{Integer.valueOf(r9)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.toString();
        return;
    L13:
        Class r2 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?>[] r6 = {Integer.TYPE};     // Catch: Exception -> L10
        int r7 = NativeReflect.a;     // Catch: Exception -> L10
        r1 = r2.getDeclaredMethod("setObricEffectSource", r6);     // Catch: Exception -> L10
        r1.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r0).put("setObricEffectSource_1", r1);     // Catch: Exception -> L10
        goto L8
    }

    public static void r(OUIFrameLayout r10, OUIFrameLayout r11) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r12 = e(r10);
        Map<String, Method> r0 = b;
        Method r1 = (Method) ((HashMap) r0).get("setObricEffectSource_3");
        if (r1 == null) goto L13;
    L8:
        r1.invoke(r12, new Object[]{1, 0, r11});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        Class r2 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?> r9 = Integer.TYPE;     // Catch: Exception -> L10
        Class<?>[] r8 = {r9, r9, View.class};     // Catch: Exception -> L10
        int r13 = NativeReflect.a;     // Catch: Exception -> L10
        r1 = r2.getDeclaredMethod("setObricEffectSource", r8);     // Catch: Exception -> L10
        r1.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r0).put("setObricEffectSource_3", r1);     // Catch: Exception -> L10
        goto L8
    }

    public static void t(Object r7, View r8) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r9 = e(r7);
        Map<String, Method> r0 = b;
        Method r1 = (Method) ((HashMap) r0).get("setObricEffectSourceTarget");
        if (r1 == null) goto L13;
    L8:
        r1.invoke(r9, new Object[]{r8});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        int r6 = NativeReflect.a;     // Catch: Exception -> L10
        r1 = a("android.view.IExtEffect").getDeclaredMethod("setObricEffectSourceTarget", new Class[]{View.class});     // Catch: Exception -> L10
        r1.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r0).put("setObricEffectSourceTarget", r1);     // Catch: Exception -> L10
        goto L8
    }

    public static void b(Object r11, c r12, float r13) {
        kma.a r0 = r12.b;
        if (r0 == null) goto L5;
        m(r11, z(com.obric.oui.color.c.a(r0.a.c)));
    L18:
        com.obric.oui.blur.a r1 = r12.g;
        if (r1 == null) goto L21;
        o(r11, r1.a, r1.c, r1.b, r1.d, r1.e);
    L25:
        i0 r2 = r12.e;
        if (r2 == null) goto L35;
        float r3 = r2.a;
        if (r3 != 0.0f) goto L30;
        boolean r4 = true;
    L31:
        if (r4 == false) goto L33;
        int r5 = 0;
    L34:
        y(r11, r5, r2.b);
    L36:
        com.obric.oui.fluid.a r6 = r12.j;
        if (r6 == null) goto L39;
        u(r11, true, r6.a);
        return;
    L39:
        u(r11, false, c);
        return;
    L33:
        r5 = (int) ((r3 * r13) + 0.5f);
        goto L34
    L30:
        r4 = false;
        goto L31
    L35:
        y(r11, 0.0f, 0);
        goto L36
    L21:
        Float r7 = r12.h;
        if (r7 == null) goto L24;
        o(r11, r7.floatValue(), 1.0f, 0, 0, 1.0f);
        goto L25
    L24:
        o(r11, 0.0f, 1.0f, 0, 0, 1.0f);
        goto L25
    L5:
        com.obric.oui.color.a[] r8 = r12.c;
        if (r8 == null) goto L9;
        m(r11, z(r8));
        goto L18
    L9:
        if (k() == false) goto L18;
        Object r9 = e(r11);
        Map<String, Method> r10 = b;
        Method r14 = (Method) ((HashMap) r10).get("setObricBlendEffect_curve");
        if (r14 == null) goto L41;
    L14:
        r14.invoke(r9, new Object[]{0, Float.valueOf(1.0f), new int[]{0, 0}});     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        goto L18
    L41:
        Class r15 = a("android.view.IExtEffect");     // Catch: Exception -> L16
        Class<?>[] r16 = {Integer.TYPE, Float.TYPE, int[].class};     // Catch: Exception -> L16
        int r17 = NativeReflect.a;     // Catch: Exception -> L16
        r14 = r15.getDeclaredMethod("setObricBlendEffect", r16);     // Catch: Exception -> L16
        r14.setAccessible(true);     // Catch: Exception -> L16
        ((HashMap) r10).put("setObricBlendEffect_curve", r14);     // Catch: Exception -> L16
        goto L14
    }

    public static com.obric.oui.color.a[] d(Resources r4, int r5, int r6) {
        if (r5 == 0) goto L10;
        if (r6 == 0) goto L13;
        int[] r7 = r4.getIntArray(r5);
        int[] r8 = r4.getIntArray(r6);
        com.obric.oui.color.a[] r9 = new com.obric.oui.color.a[r7.length];
        int r0 = 0;
    L7:
        if (r0 >= r7.length) goto L9;
        r9[r0] = new com.obric.oui.color.a(r7[r0], BlendMode.mapToLegacyObricBlend(r8[r0]));
        r0 = r0 + 1;
        goto L7
    L9:
        return r9;
    L13:
        return null;
    L10:
        return null;
    }

    public static Object i(Object r5, String r6, Class r7) {
        Map<String, Method> r1 = b;
        Method r2 = (Method) ((HashMap) r1).get(r6);
        if (r2 == null) goto L10;
    L5:
        return r2.invoke(r5, new Object[0]);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        int r4 = NativeReflect.a;     // Catch: Exception -> L7
        r2 = r7.getDeclaredMethod("getExtEffect", new Class[0]);     // Catch: Exception -> L7
        r2.setAccessible(true);     // Catch: Exception -> L7
        ((HashMap) r1).put(r6, r2);     // Catch: Exception -> L7
        goto L5
    }

    public static void p(View r11, c r12, int r13) {
        if (r11 == null) goto L50;
        if (r12 != null) goto L6;
        return;
    L6:
        if (k() == false) goto L8;
        s(r11, r13, 1);
        com.obric.oui.color.a[] r14 = r12.c;
        if (r14 == null) goto L36;
        m(r11, z(r14));
    L36:
        com.obric.oui.blur.a r15 = r12.g;
        if (r15 == null) goto L51;
        o(r11, r15.a, r15.c, r15.b, r15.d, r15.e);
        return;
    L51:
        return;
    L8:
        if (r12.g == null) goto L47;
        com.obric.oui.color.a[] r16 = r12.c;
        if (r16 == null) goto L48;
        int[] r17 = z(r16);
        int r0 = j.a;
        int r2 = 0;
    L13:
        if (r2 >= r17.length) goto L18;
        if ((r2 % 2) == 0) goto L17;
        r17[r2] = BlendMode.mapToLegacyObricBlend(r17[r2], true);
    L17:
        r2 = r2 + 1;
        goto L13
    L18:
        com.obric.oui.blur.a r18 = r12.g;
        int r3 = r18.b;
        float r19 = r18.a;
        Map<String, Method> r4 = b;
        Method r5 = (Method) ((HashMap) r4).get("view_getExtView");
        if (r5 == null) goto L40;
    L21:
        Object r110 = r5.invoke(r11, new Object[0]);     // Catch: Exception -> L23
    L25:
        Map<String, Method> r6 = b;
        Method r7 = (Method) ((HashMap) r6).get("legacy_setBackdropBlurEffectExt");
        if (r7 == null) goto L42;
    L28:
        r7.invoke(r110, new Object[]{Integer.valueOf(r3), Float.valueOf(r19), r17});     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        e.toString();
        return;
    L42:
        Class r8 = a("android.view.IExtView");     // Catch: Exception -> L30
        Class<?>[] r9 = {Integer.TYPE, Float.TYPE, int[].class};     // Catch: Exception -> L30
        int r10 = NativeReflect.a;     // Catch: Exception -> L30
        r7 = r8.getDeclaredMethod("setBackdropBlurEffectExt", r9);     // Catch: Exception -> L30
        r7.setAccessible(true);     // Catch: Exception -> L30
        ((HashMap) r6).put("legacy_setBackdropBlurEffectExt", r7);     // Catch: Exception -> L30
    L23:
        e = move-exception;
        e.printStackTrace();
        r110 = null;
        goto L25
    L40:
        int r20 = NativeReflect.a;     // Catch: Exception -> L23
        r5 = View.class.getDeclaredMethod("getExt", new Class[0]);     // Catch: Exception -> L23
        r5.setAccessible(true);     // Catch: Exception -> L23
        ((HashMap) r4).put("view_getExtView", r5);     // Catch: Exception -> L23
        goto L21
    L48:
        return;
    L47:
        return;
    }

    public static void s(Object r9, int r10, int r11) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r12 = e(r9);
        Map<String, Method> r0 = b;
        Method r1 = (Method) ((HashMap) r0).get("setObricEffectSource_2");
        if (r1 == null) goto L13;
    L8:
        r1.invoke(r12, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        Class r2 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?> r8 = Integer.TYPE;     // Catch: Exception -> L10
        Class<?>[] r7 = {r8, r8};     // Catch: Exception -> L10
        int r13 = NativeReflect.a;     // Catch: Exception -> L10
        r1 = r2.getDeclaredMethod("setObricEffectSource", r7);     // Catch: Exception -> L10
        r1.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r0).put("setObricEffectSource_2", r1);     // Catch: Exception -> L10
        goto L8
    }

    public static void u(Object r7, boolean r8, float[] r9) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r10 = e(r7);
        Map<String, Method> r0 = b;
        Method r1 = (Method) ((HashMap) r0).get("setObricLiquidGlassEffectRR");
        if (r1 == null) goto L17;
    L8:
        Object[] r2 = new Object[1];     // Catch: Exception -> L14
        if (r8 == true) goto L12;
        r9 = new float[0];     // Catch: Exception -> L14
    L12:
        r2[0] = r9;     // Catch: Exception -> L14
        r1.invoke(r10, r2);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        e.toString();
        return;
    L17:
        int r6 = NativeReflect.a;     // Catch: Exception -> L14
        r1 = a("android.view.IExtEffect").getDeclaredMethod("setObricLiquidGlassEffectRR", new Class[]{float[].class});     // Catch: Exception -> L14
        r1.setAccessible(true);     // Catch: Exception -> L14
        ((HashMap) r0).put("setObricLiquidGlassEffectRR", r1);     // Catch: Exception -> L14
        goto L8
    }

    public static void x(Object r11, int r12, int r13) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r14 = e(r11);
        Map<String, Method> r0 = b;
        Method r1 = (Method) ((HashMap) r0).get("setObricOverlayBlendEffect_3");
        if (r1 == null) goto L13;
    L8:
        r1.invoke(r14, new Object[]{Integer.valueOf(r12), Float.valueOf(1.0f), Integer.valueOf(r13)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.toString();
        return;
    L13:
        Class r2 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?> r9 = Integer.TYPE;     // Catch: Exception -> L10
        Class<?>[] r8 = {r9, Float.TYPE, r9};     // Catch: Exception -> L10
        int r10 = NativeReflect.a;     // Catch: Exception -> L10
        r1 = r2.getDeclaredMethod("setObricOverlayBlendEffect", r8);     // Catch: Exception -> L10
        r1.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r0).put("setObricOverlayBlendEffect_3", r1);     // Catch: Exception -> L10
        goto L8
    }

    public static void y(Object r10, float r11, int r12) {
        int r0 = BlendMode.SRC_OVER.getPorterDuffMode();
        if (k() == false) goto L13;
        Object r13 = e(r10);
        Map<String, Method> r1 = b;
        Method r2 = (Method) ((HashMap) r1).get("setObricBlurStroke");
        if (r2 == null) goto L11;
    L8:
        r2.invoke(r13, new Object[]{Float.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r0)});     // Catch: Exception -> L10
        return;
    L14:
        return;
    L11:
        Class r3 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?> r9 = Integer.TYPE;     // Catch: Exception -> L10
        Class<?>[] r8 = {Float.TYPE, r9, r9};     // Catch: Exception -> L10
        int r14 = NativeReflect.a;     // Catch: Exception -> L10
        r2 = r3.getDeclaredMethod("setObricBlurStroke", r8);     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r1).put("setObricBlurStroke", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void v(Object r3, int r4, c r5, float r6) {
        if (r3 == null) goto L21;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.c == null) goto L8;
    L15:
        boolean r0 = true;
    L16:
        if (r0 == true) goto L19;
        s(r3, 0, 1);
        return;
    L19:
        s(r3, r4, 1);
        b(r3, r5, r6);
        return;
    L8:
        if (r5.g != null) goto L15;
        if (r5.h != null) goto L15;
        if (r5.j != null) goto L15;
        r0 = false;
        goto L16
    }

    public static void w(Object r6, int r7, c[] r8, float r9) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.length != 1) goto L7;
        c r10 = r8[0];
        Resources r11 = Resources.getSystem();
        v(r6, r7, r10, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density);
        return;
    L7:
        int r0 = 0;
    L9:
        if (r0 >= r8.length) goto L39;
        if (r0 != 0) goto L12;
        int r3 = 1;
    L13:
        c r4 = r8[r0];
        i r5 = h(r6, r3);
        if (r5 == null) goto L31;
        if (r4 == null) goto L31;
        Object r12 = r5.a;
        if (r4.c == null) goto L20;
    L27:
        boolean r13 = true;
    L28:
        if (r13 == true) goto L30;
        s(r12, 0, 1);
        goto L31
    L30:
        s(r12, r7, 1);
        b(r12, r4, r9);
        goto L31
    L20:
        if (r4.g != null) goto L27;
        if (r4.h != null) goto L27;
        if (r4.j != null) goto L27;
        r13 = false;
    L31:
        r0 = r0 + 1;
        goto L9
    L12:
        r3 = 2;
        goto L13
    }

    public static void o(Object r14, float r15, float r16, int r17, int r18, float r19) {
        if (k() == true) goto L5;
        return;
    L5:
        Object r0 = e(r14);
        Map<String, Method> r1 = b;
        Method r2 = (Method) ((HashMap) r1).get("setObricBlurEffect_5");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r0, new Object[]{Float.valueOf(r15), Float.valueOf(r16), Integer.valueOf(r17), Integer.valueOf(r18), Float.valueOf(r19)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        Class r3 = a("android.view.IExtEffect");     // Catch: Exception -> L10
        Class<?> r12 = Float.TYPE;     // Catch: Exception -> L10
        Class<?> r13 = Integer.TYPE;     // Catch: Exception -> L10
        Class<?>[] r11 = {r12, r12, r13, r13, r12};     // Catch: Exception -> L10
        int r110 = NativeReflect.a;     // Catch: Exception -> L10
        r2 = r3.getDeclaredMethod("setObricBlurEffect", r11);     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        ((HashMap) r1).put("setObricBlurEffect_5", r2);     // Catch: Exception -> L10
        goto L8
    }
}
