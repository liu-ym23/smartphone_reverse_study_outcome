package com.obric.oui.material;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.VectorDrawable;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import com.obric.oui.graphic.BlendMode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class OMaterialHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Integer f14011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Method> f14012b = null;
    private static final Map<String, Method> c = null;
    private static final float[] d = null;

    @Deprecated
    public static final enum LEGACY_BLEND_MODE extends Enum<LEGACY_BLEND_MODE> {
        private static final /* synthetic */ LEGACY_BLEND_MODE[] $VALUES = null;
        public static final LEGACY_BLEND_MODE COLOR_BURN = null;
        public static final LEGACY_BLEND_MODE COLOR_DODGE = null;
        public static final LEGACY_BLEND_MODE DEFAULT = null;
        public static final LEGACY_BLEND_MODE LUMINOSITY = null;
        public static final LEGACY_BLEND_MODE OVERLAY = null;
        public static final LEGACY_BLEND_MODE PLUS_DARKER = null;
        public static final LEGACY_BLEND_MODE PLUS_LIGHTER = null;
        public static final LEGACY_BLEND_MODE SOFT_LIGHT = null;

        static {
            LEGACY_BLEND_MODE r0 = new LEGACY_BLEND_MODE("DEFAULT", 0);
            DEFAULT = r0;
            LEGACY_BLEND_MODE r1 = new LEGACY_BLEND_MODE("COLOR_BURN", 1);
            COLOR_BURN = r1;
            LEGACY_BLEND_MODE r3 = new LEGACY_BLEND_MODE("COLOR_DODGE", 2);
            COLOR_DODGE = r3;
            LEGACY_BLEND_MODE r5 = new LEGACY_BLEND_MODE("PLUS_DARKER", 3);
            PLUS_DARKER = r5;
            LEGACY_BLEND_MODE r7 = new LEGACY_BLEND_MODE("PLUS_LIGHTER", 4);
            PLUS_LIGHTER = r7;
            LEGACY_BLEND_MODE r9 = new LEGACY_BLEND_MODE("LUMINOSITY", 5);
            LUMINOSITY = r9;
            LEGACY_BLEND_MODE r11 = new LEGACY_BLEND_MODE("OVERLAY", 6);
            OVERLAY = r11;
            LEGACY_BLEND_MODE r13 = new LEGACY_BLEND_MODE("SOFT_LIGHT", 7);
            SOFT_LIGHT = r13;
            $VALUES = new LEGACY_BLEND_MODE[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private LEGACY_BLEND_MODE(String r1, int r2) {
            super(r1, r2);
        }

        public static LEGACY_BLEND_MODE valueOf(String r2) {
            return (LEGACY_BLEND_MODE) ZeusTransformUtils.preCheckCast(Enum.valueOf(LEGACY_BLEND_MODE.class, r2), LEGACY_BLEND_MODE.class, "com.obric.memorydata.plugin");
        }

        public static LEGACY_BLEND_MODE[] values() {
            return (LEGACY_BLEND_MODE[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LEGACY_BLEND_MODE[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f14012b = new HashMap();
        c = new HashMap();
        d = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public static j a(Object r8, int r9) {
        Object r10 = a(r8);
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("getEffectParas"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L14;
    L5:
        Object r11 = r2.invoke(r10, new Object[]{Integer.valueOf(r9)});     // Catch: Exception -> L11
        if (r11 == null) goto L16;
        return new j(r11);
    L11:
        e = move-exception;
        Log.e("OMaterialHelper", "getMaterialParams error: " + e);
        return null;
    L16:
        return null;
    L14:
        r2 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin"), "getEffectParas", new Class[]{Integer.TYPE});     // Catch: Exception -> L11
        r2.setAccessible(true);     // Catch: Exception -> L11
        r0.put("getEffectParas", r2);     // Catch: Exception -> L11
        goto L5
    }

    public static Object a(Paint r3) {
        return a(r3, "paint_getExtEffect", Paint.class, "getExtEffect");
    }

    public static Object a(VectorDrawable r3) {
        return a(r3, "vectorDrawable_getExtEffect", VectorDrawable.class, "getExtEffect");
    }

    public static Object a(View r3) {
        return a(r3, "view_getExtEffect", View.class, "getExtEffect");
    }

    public static Object a(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, View.class) == false) goto L7;
        return a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r2, Paint.class) == false) goto L11;
        return a((Paint) ZeusTransformUtils.preCheckCast(r2, Paint.class, "com.obric.memorydata.plugin"));
    L11:
        if (ZeusTransformUtils.instanceOf(r2, VectorDrawable.class) == true) goto L13;
        return r2;
    L13:
        return a((VectorDrawable) ZeusTransformUtils.preCheckCast(r2, VectorDrawable.class, "com.obric.memorydata.plugin"));
    }

    private static Object a(Object r4, String r5, Class<?> r6, String r7) {
        Map<String, Method> r0 = f14012b;
        Method r1 = (Method) ZeusTransformUtils.preCheckCast(r0.get(r5), Method.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L10;
    L5:
        return r1.invoke(r4, new Object[0]);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        r1 = NativeReflect.a(r6, r7, new Class[0]);     // Catch: Exception -> L7
        r1.setAccessible(true);     // Catch: Exception -> L7
        r0.put(r5, r1);     // Catch: Exception -> L7
        goto L5
    }

    @Deprecated
    public static void a(View r10, int r11, float r12, int... r13) {
        Object r14 = b(r10);
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("legacy_setBackdropBlurEffectExt"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
    L5:
        r2.invoke(r14, new Object[]{Integer.valueOf(r11), Float.valueOf(r12), r13});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Log.e("OMaterialHelper", "setBackdropBlurEffectExt error: " + e);
        return;
    L10:
        r2 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtView", "com.obric.memorydata.plugin"), "setBackdropBlurEffectExt", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: Exception -> L7
        r2.setAccessible(true);     // Catch: Exception -> L7
        r0.put("legacy_setBackdropBlurEffectExt", r2);     // Catch: Exception -> L7
        goto L5
    }

    public static void a(View r1, c r2) {
        a(r1, r2, 2);
    }

    public static void a(View r3, c r4, int r5) {
        if (r3 == null) goto L34;
        if (r4 != null) goto L6;
        return;
    L6:
        if (a() == false) goto L8;
        a(r3, r5, 1);
        if (r4.c() == null) goto L26;
        a(r3, a(r4.c()));
    L26:
        if (r4.g() == null) goto L35;
        a(r3, r4.g());
        return;
    L35:
        return;
    L8:
        if (r4.g() != null) goto L10;
        return;
    L10:
        if (r4.c() == null) goto L33;
        int[] r6 = a(r4.c());
        if (k.f14024b == true) goto L20;
        int r0 = 0;
    L15:
        if (r0 >= r6.length) goto L20;
        if ((r0 % 2) == 0) goto L19;
        r6[r0] = BlendMode.mapToLegacyObricBlend(r6[r0], true);
    L19:
        r0 = r0 + 1;
    L20:
        a(r3, r4.g().b(), r4.g().a(), r6);
        return;
    L33:
        return;
    }

    public static void a(Object r6, float r7) {
        a(r6, r7, 1.0f, 0, 0, 1.0f);
    }

    public static void a(Object r13, float r14, float r15, int r16, int r17, float r18) {
        if (a() == true) goto L5;
        return;
    L5:
        Object r0 = a(r13);
        Map<String, Method> r1 = f14012b;
        Method r3 = (Method) ZeusTransformUtils.preCheckCast(r1.get("setObricBlurEffect_5"), Method.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L13;
    L8:
        r3.invoke(r0, new Object[]{Float.valueOf(r14), Float.valueOf(r15), Integer.valueOf(r16), Integer.valueOf(r17), Float.valueOf(r18)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        r3 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin"), "setObricBlurEffect", new Class[]{Float.TYPE, Float.TYPE, Integer.TYPE, Integer.TYPE, Float.TYPE});     // Catch: Exception -> L10
        r3.setAccessible(true);     // Catch: Exception -> L10
        r1.put("setObricBlurEffect_5", r3);     // Catch: Exception -> L10
        goto L8
    }

    public static void a(Object r1, float r2, int r3) {
        a(r1, r2, r3, BlendMode.SRC_OVER.getPorterDuffMode());
    }

    public static void a(Object r9, float r10, int r11, int r12) {
        if (a() == true) goto L5;
        return;
    L5:
        Object r13 = a(r9);
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("setObricBlurStroke"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r13, new Object[]{Float.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.e("OMaterialHelper", "setStrokeEffect error: ", e);
        return;
    L13:
        r2 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin"), "setObricBlurStroke", new Class[]{Float.TYPE, Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricBlurStroke", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void a(Object r10, int r11, float r12, int r13) {
        if (a() == true) goto L5;
        return;
    L5:
        Object r14 = a(r10);
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("setObricOverlayBlendEffect_3"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r14, new Object[]{Integer.valueOf(r11), Float.valueOf(r12), Integer.valueOf(r13)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.e("OMaterialHelper", "setOverlayBlendEffect error: " + e);
        return;
    L13:
        r2 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin"), "setObricOverlayBlendEffect", new Class[]{Integer.TYPE, Float.TYPE, Integer.TYPE});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricOverlayBlendEffect_3", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void a(Object r10, int r11, float r12, int... r13) {
        if (a() == true) goto L5;
        return;
    L5:
        Object r14 = a(r10);
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("setObricBlendEffect_curve"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r14, new Object[]{Integer.valueOf(r11), Float.valueOf(r12), r13});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.e("OMaterialHelper", "setBlendEffect error: " + e);
        return;
    L13:
        r2 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin"), "setObricBlendEffect", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricBlendEffect_curve", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void a(Object r9, int r10, int r11) {
        if (a() == true) goto L5;
        return;
    L5:
        Object r12 = a(r9);
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("setObricEffectSource_2"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r12, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        r2 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin"), "setObricEffectSource", new Class[]{Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricEffectSource_2", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void a(Object r10, int r11, int r12, View r13) {
        if (a() == true) goto L5;
        return;
    L5:
        Object r14 = a(r10);
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("setObricEffectSource_3"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r14, new Object[]{Integer.valueOf(r11), Integer.valueOf(r12), r13});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        r2 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin"), "setObricEffectSource", new Class[]{Integer.TYPE, Integer.TYPE, View.class});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricEffectSource_3", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void a(Object r1, int r2, int r3, c r4) {
        a(r1, r2, r3, r4, Resources.getSystem().getDisplayMetrics().density);
    }

    public static void a(Object r1, int r2, int r3, c r4, float r5) {
        if (r1 == null) goto L11;
        if (r4 != null) goto L6;
        return;
    L6:
        if (a(r4) == true) goto L9;
        c(r1, 0);
        return;
    L9:
        a(r1, r2, r3);
        a(r1, r4, r5);
        return;
    }

    public static void a(Object r0, int r1, int r2, c r3, int r4, float r5) {
        j r6 = a(r0, r4);
        if (r6 == null) goto L12;
        if (r3 == null) goto L13;
        Object r7 = r6.a();
        if (a(r3) == true) goto L10;
        c(r7, 0);
        return;
    L10:
        a(r7, r1, r2);
        a(r7, r3, r5);
        return;
    L13:
        return;
    }

    public static void a(Object r1, int r2, c r3, float r4) {
        a(r1, r2, 1, r3, r4);
    }

    public static void a(Object r6, int r7, c r8, int r9, int r10, float r11) {
        a(r6, r7, r10, r8, r9, r11);
    }

    public static void a(Object r1, int r2, c[] r3, float r4) {
        a(r1, r2, r3, 1, r4);
    }

    public static void a(Object r9, int r10, c[] r11, int r12, float r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        int r1 = 0;
        if (r11.length != 1) goto L9;
        a(r9, r10, r12, r11[0]);
        return;
    L9:
        if (r1 >= r11.length) goto L14;
        if (r1 != 0) goto L12;
        int r6 = 1;
    L13:
        a(r9, r10, r11[r1], r6, r12, r13);
        r1 = r1 + 1;
        goto L9
    L12:
        r6 = 2;
        goto L13
    }

    public static void a(Object r7, View r8) {
        if (a() == true) goto L5;
        return;
    L5:
        Object r9 = a(r7);
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("setObricEffectSourceTarget"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r9, new Object[]{r8});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        r2 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin"), "setObricEffectSourceTarget", new Class[]{View.class});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricEffectSourceTarget", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void a(Object r6, com.obric.oui.blur.a r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        a(r6, r7.a(), r7.c(), r7.b(), r7.d(), r7.e());
    }

    public static void a(Object r1, c r2, float r3) {
        if (r2.b() == null) goto L6;
        a(r1, a(r2.b().a()));
    L10:
        if (r2.g() == null) goto L13;
        a(r1, r2.g());
    L17:
        if (r2.e() == null) goto L19;
        float r4 = com.obric.oui.common.util.h.b(r2.e().a(), r3);
        int r0 = r2.e().b();
    L20:
        a(r1, r4, r0);
        if (r2.j() == null) goto L23;
        a(r1, true, r2.j().a());
        return;
    L23:
        d(r1);
        return;
    L19:
        r4 = 0.0f;
        r0 = 0;
        goto L20
    L13:
        if (r2.h() == null) goto L15;
        a(r1, r2.h().floatValue());
        goto L17
    L15:
        b(r1);
        goto L17
    L6:
        if (r2.c() == null) goto L8;
        a(r1, a(r2.c()));
        goto L10
    L8:
        c(r1);
        goto L10
    }

    public static void a(Object r1, boolean r2) {
        if (r2 == false) goto L4;
        a(r1, 2, 1);
        return;
    L4:
        a(r1, 0, 0);
    }

    public static void a(Object r7, boolean r8, float[] r9) {
        if (a() == true) goto L5;
        return;
    L5:
        Object r10 = a(r7);
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("setObricLiquidGlassEffectRR"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L17;
    L8:
        Object[] r1 = new Object[1];     // Catch: Exception -> L14
        if (r8 == true) goto L12;
        r9 = new float[0];     // Catch: Exception -> L14
    L12:
        r1[0] = r9;     // Catch: Exception -> L14
        r2.invoke(r10, r1);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Log.e("OMaterialHelper", "setFluidEffect error: " + e);
        return;
    L17:
        r2 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin"), "setObricLiquidGlassEffectRR", new Class[]{float[].class});     // Catch: Exception -> L14
        r2.setAccessible(true);     // Catch: Exception -> L14
        r0.put("setObricLiquidGlassEffectRR", r2);     // Catch: Exception -> L14
        goto L8
    }

    public static void a(Object r2, int... r3) {
        a(r2, 4, 1.0f, r3);
    }

    public static boolean a() {
        if (b() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (a() == true) goto L6;
        return false;
    L6:
        if (b(r3) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean a(c r1) {
        if (r1 != null) goto L4;
    L12:
        return false;
    L4:
        if (r1.c() == null) goto L6;
    L11:
        return true;
    L6:
        if (r1.g() != null) goto L11;
        if (r1.h() != null) goto L11;
        if (r1.j() == null) goto L12;
        goto L11
    }

    public static int[] a(com.obric.oui.color.a[] r5) {
        int r0 = 0;
        if (r5 == null) goto L5;
        int r1 = r5.length * 2;
        int[] r2 = new int[r1];
    L7:
        if (r0 >= r1) goto L13;
        com.obric.oui.color.a r3 = r5[r0 / 2];
        if ((r0 % 2) != 0) goto L11;
        int r4 = r3.a();
    L12:
        r2[r0] = r4;
        r0 = r0 + 1;
        goto L7
    L11:
        r4 = r3.b();
        goto L12
    L13:
        return r2;
    L5:
        return new int[0];
    }

    public static com.obric.oui.color.a[] a(Resources r0, int r1) {
        return com.obric.oui.color.a.a(r0, r1);
    }

    public static com.obric.oui.color.a[] a(Resources r4, int r5, int r6) {
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

    public static int b() {
        if (f14011a != null) goto L6;
        f14011a = Integer.valueOf(e());
    L6:
        return f14011a.intValue();
    }

    public static int b(Context r2) {
        return Settings.Global.getInt(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "obric_current_effect_id", 2);
    }

    public static Object b(View r6) {
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("view_getExtView"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
    L5:
        return r2.invoke(r6, new Object[0]);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        r2 = NativeReflect.a(View.class, "getExt", new Class[0]);     // Catch: Exception -> L7
        r2.setAccessible(true);     // Catch: Exception -> L7
        r0.put("view_getExtView", r2);     // Catch: Exception -> L7
        goto L5
    }

    public static void b(Object r6) {
        a(r6, 0.0f, 1.0f, 0, 0, 1.0f);
    }

    public static void b(Object r8, int r9) {
        if (a() == true) goto L5;
        return;
    L5:
        Object r10 = a(r8);
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("setObricEffectSource_1"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r10, new Object[]{Integer.valueOf(r9)});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.e("OMaterialHelper", "setEffectSrc error: " + e);
        return;
    L13:
        r2 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin"), "setObricEffectSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricEffectSource_1", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void b(Object r1, boolean r2) {
        if (r2 == false) goto L4;
        a(r1, 3, 1);
        return;
    L4:
        a(r1, 0, 0);
    }

    public static void b(Object r7, int... r8) {
        if (a() == true) goto L5;
        return;
    L5:
        Object r9 = a(r7);
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("setObricBlendEffectToShadow"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L15;
    L10:
        if (r9 == null) goto L17;
        r2.invoke(r9, new Object[]{r8});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("OMaterialHelper", "setBlendEffectToShadow error: " + e);
        return;
    L17:
        return;
    L15:
        r2 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin"), "setObricBlendEffectToShadow", new Class[]{int[].class});     // Catch: Exception -> L8
        r2.setAccessible(true);     // Catch: Exception -> L8
        r0.put("setObricBlendEffectToShadow", r2);     // Catch: Exception -> L8
        goto L10
    }

    public static int c() {
        return 1;
    }

    public static void c(Object r10) {
        if (a() == true) goto L5;
        return;
    L5:
        Object r11 = a(r10);
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("setObricBlendEffect_curve"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
    L8:
        r2.invoke(r11, new Object[]{0, Float.valueOf(1.0f), new int[]{0, 0}});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        Log.e("OMaterialHelper", "clearBlendEffect error: " + e);
        return;
    L13:
        r2 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin"), "setObricBlendEffect", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        r0.put("setObricBlendEffect_curve", r2);     // Catch: Exception -> L10
        goto L8
    }

    public static void c(Object r1, int r2) {
        a(r1, r2, 1);
    }

    public static void c(Object r1, boolean r2) {
        a(r1, r2, d);
    }

    public static void d(Object r1) {
        c(r1, false);
    }

    public static boolean d() {
        if (b() < 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static int e() {
        Map<String, Method> r0 = f14012b;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r0.get("getEffectApi"), Method.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L12;
    L5:
        Object r1 = r2.invoke(null, new Object[0]);     // Catch: Exception -> L9
        if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L14;
        return ((Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L9:
        e = move-exception;
        Log.e("OUIMaterial", "getEffectApi failed: " + e);
        return 0;
    L14:
        return 0;
    L12:
        r2 = NativeReflect.a(ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin"), "getEffectApi", new Class[0]);     // Catch: Exception -> L9
        r2.setAccessible(true);     // Catch: Exception -> L9
        r0.put("getEffectApi", r2);     // Catch: Exception -> L9
        goto L5
    }
}
