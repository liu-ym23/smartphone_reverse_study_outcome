package com.obric.oui.material;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.VectorDrawable;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import com.obric.oui.graphic.BlendMode;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Integer f13677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f13678b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[] f13679c = null;

    static {
        f13678b = new HashMap();
        new HashMap();
        f13679c = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public static void a(Object r10, c r11) {
        cs.a r5 = r11.f13610b;
        if (r5 == null) goto L5;
        l(v(r5.f16500a.f16503c), r10);
    L19:
        xq.a r12 = r11.g;
        if (r12 == null) goto L22;
        n(r10, r12.f23207a, r12.f23209c, r12.f23208b, r12.d, r12.e);
    L26:
        com.obric.oui.color.d r13 = r11.e;
        if (r13 == null) goto L29;
        u(r10, r13.f12423a * Resources.getSystem().getDisplayMetrics().density, r11.e.f12424b);
    L30:
        com.obric.oui.fluid.a r14 = r11.f13614j;
        if (r14 == null) goto L33;
        s(r10, true, r14.f13225a);
        return;
    L33:
        s(r10, false, f13679c);
        return;
    L29:
        u(r10, 0.0f, 0);
        goto L30
    L22:
        Float r15 = r11.f13612h;
        if (r15 == null) goto L25;
        n(r10, r15.floatValue(), 1.0f, 0, 0, 1.0f);
        goto L26
    L25:
        n(r10, 0.0f, 1.0f, 0, 0, 1.0f);
        goto L26
    L5:
        com.obric.oui.color.a[] r16 = r11.f13611c;
        if (r16 == null) goto L9;
        l(v(r16), r10);
        goto L19
    L9:
        if (j() == false) goto L19;
        Object r17 = d(r10);
        HashMap r18 = f13678b;
        Method r19 = (Method) r18.get("setObricBlendEffect_curve");
        if (r19 == null) goto L35;
    L16:
        r19.invoke(r17, new Object[]{0, Float.valueOf(1.0f), new int[]{0, 0}});     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        Log.e("OMaterialHelper", "clearBlendEffect error: " + e);
        goto L19
    L35:
        r19 = Class.forName("android.view.IExtEffect").getDeclaredMethod("setObricBlendEffect", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: Exception -> L14
        r19.setAccessible(true);     // Catch: Exception -> L14
        r18.put("setObricBlendEffect_curve", r19);     // Catch: Exception -> L14
        goto L16
    }

    public static int b() {
        HashMap r5 = f13678b;
        Method r10 = (Method) r5.get("getEffectApi");
        if (r10 == null) goto L13;
    L7:
        Object r11 = r10.invoke(null, null);     // Catch: Exception -> L5
        if ((r11 instanceof Integer) == false) goto L15;
        return ((Integer) r11).intValue();
    L5:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "getEffectApi failed: ", "OUIMaterial");
        return 0;
    L15:
        return 0;
    L13:
        r10 = Class.forName("android.view.IExtEffect").getDeclaredMethod("getEffectApi", null);     // Catch: Exception -> L5
        r10.setAccessible(true);     // Catch: Exception -> L5
        r5.put("getEffectApi", r10);     // Catch: Exception -> L5
        goto L7
    }

    public static com.obric.oui.color.a[] c(Resources r5, int r10, int r11) {
        if (r10 == 0) goto L10;
        if (r11 == 0) goto L13;
        int[] r12 = r5.getIntArray(r10);
        int[] r13 = r5.getIntArray(r11);
        com.obric.oui.color.a[] r14 = new com.obric.oui.color.a[r12.length];
        int r15 = 0;
    L7:
        if (r15 >= r12.length) goto L9;
        r14[r15] = new com.obric.oui.color.a(r12[r15], BlendMode.mapToLegacyObricBlend(r13[r15]));
        r15 = r15 + 1;
        goto L7
    L9:
        return r14;
    L13:
        return null;
    L10:
        return null;
    }

    public static Object d(Object r5) {
        if ((r5 instanceof View) == false) goto L7;
        return h(View.class, (View) r5, "view_getExtEffect");
    L7:
        if ((r5 instanceof Paint) == false) goto L11;
        return h(Paint.class, (Paint) r5, "paint_getExtEffect");
    L11:
        if ((r5 instanceof VectorDrawable) == true) goto L13;
        return r5;
    L13:
        return h(VectorDrawable.class, (VectorDrawable) r5, "vectorDrawable_getExtEffect");
    }

    public static Object e(View r5) {
        HashMap r10 = f13678b;
        Method r11 = (Method) r10.get("view_getExtView");
        if (r11 == null) goto L11;
    L7:
        return r11.invoke(r5, null);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        r11 = View.class.getDeclaredMethod("getExt", null);     // Catch: Exception -> L5
        r11.setAccessible(true);     // Catch: Exception -> L5
        r10.put("view_getExtView", r11);     // Catch: Exception -> L5
        goto L7
    }

    public static int f() {
        if (f13677a != null) goto L6;
        f13677a = Integer.valueOf(b());
    L6:
        return f13677a.intValue();
    }

    public static sj.k g(int r5, Object r10) {
        Object r11 = d(r10);
        HashMap r12 = f13678b;
        Method r13 = (Method) r12.get("getEffectParas");
        if (r13 == null) goto L15;
    L7:
        Object r14 = r13.invoke(r11, new Object[]{Integer.valueOf(r5)});     // Catch: Exception -> L5
        if (r14 == null) goto L17;
        return new sj.k(r14);
    L5:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "getMaterialParams error: ", "OMaterialHelper");
        return null;
    L17:
        return null;
    L15:
        r13 = Class.forName("android.view.IExtEffect").getDeclaredMethod("getEffectParas", new Class[]{Integer.TYPE});     // Catch: Exception -> L5
        r13.setAccessible(true);     // Catch: Exception -> L5
        r12.put("getEffectParas", r13);     // Catch: Exception -> L5
        goto L7
    }

    public static Object h(Class r5, Object r10, String r11) {
        HashMap r12 = f13678b;
        Method r13 = (Method) r12.get(r11);
        if (r13 == null) goto L11;
    L7:
        return r13.invoke(r10, null);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        r13 = r5.getDeclaredMethod("getExtEffect", null);     // Catch: Exception -> L5
        r13.setAccessible(true);     // Catch: Exception -> L5
        r12.put(r11, r13);     // Catch: Exception -> L5
        goto L7
    }

    public static boolean i(Context r5) {
        if (j() == true) goto L6;
        return false;
    L6:
        if (Settings.Global.getInt(r5.getContentResolver(), "obric_current_effect_id", 2) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean j() {
        if (f() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean k() {
        if (f() < 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static void l(int[] r10, Object r11) {
        if (j() == false) goto L16;
        Object r12 = d(r11);
        HashMap r5 = f13678b;
        Method r13 = (Method) r5.get("setObricBlendEffect_curve");
        if (r13 == null) goto L14;
    L10:
        r13.invoke(r12, new Object[]{4, Float.valueOf(1.0f), r10});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "setBlendEffect error: ", "OMaterialHelper");
        return;
    L14:
        r13 = Class.forName("android.view.IExtEffect").getDeclaredMethod("setObricBlendEffect", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: Exception -> L8
        r13.setAccessible(true);     // Catch: Exception -> L8
        r5.put("setObricBlendEffect_curve", r13);     // Catch: Exception -> L8
        goto L10
    }

    public static void m(int[] r5, Object r10) {
        if (j() == true) goto L5;
        return;
    L5:
        Object r11 = d(r10);
        HashMap r12 = f13678b;
        Method r13 = (Method) r12.get("setObricBlendEffectToShadow");
        if (r13 == null) goto L15;
    L10:
        if (r11 == null) goto L17;
        r13.invoke(r11, new Object[]{r5});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "setBlendEffectToShadow error: ", "OMaterialHelper");
        return;
    L17:
        return;
    L15:
        r13 = Class.forName("android.view.IExtEffect").getDeclaredMethod("setObricBlendEffectToShadow", new Class[]{int[].class});     // Catch: Exception -> L8
        r13.setAccessible(true);     // Catch: Exception -> L8
        r12.put("setObricBlendEffectToShadow", r13);     // Catch: Exception -> L8
        goto L10
    }

    public static void n(Object r10, float r11, float r12, int r13, int r14, float r15) {
        if (j() == true) goto L5;
        return;
    L5:
        Object r16 = d(r10);
        HashMap r5 = f13678b;
        Method r17 = (Method) r5.get("setObricBlurEffect_5");
        if (r17 == null) goto L14;
    L10:
        r17.invoke(r16, new Object[]{Float.valueOf(r11), Float.valueOf(r12), Integer.valueOf(r13), Integer.valueOf(r14), Float.valueOf(r15)});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        Class<?> r18 = Class.forName("android.view.IExtEffect");     // Catch: Exception -> L8
        Class r19 = Float.TYPE;     // Catch: Exception -> L8
        Class r20 = Integer.TYPE;     // Catch: Exception -> L8
        r17 = r18.getDeclaredMethod("setObricBlurEffect", new Class[]{r19, r19, r20, r20, r19});     // Catch: Exception -> L8
        r17.setAccessible(true);     // Catch: Exception -> L8
        r5.put("setObricBlurEffect_5", r17);     // Catch: Exception -> L8
        goto L10
    }

    public static void o(View r10, c r11, int r12) {
        if (r10 == null) goto L43;
        if (r11 != null) goto L7;
        return;
    L7:
        if (j() == false) goto L9;
        q(r12, 1, r10);
        com.obric.oui.color.a[] r13 = r11.f13611c;
        if (r13 == null) goto L31;
        l(v(r13), r10);
    L31:
        xq.a r14 = r11.g;
        if (r14 == null) goto L44;
        float r5 = r14.f23207a;
        int r15 = r14.f23208b;
        n(r10, r5, r14.f23209c, r15, r14.d, r14.e);
        return;
    L44:
        return;
    L9:
        if (r11.g == null) goto L40;
        com.obric.oui.color.a[] r16 = r11.f13611c;
        if (r16 == null) goto L41;
        int[] r17 = v(r16);
        int r18 = 0;
    L14:
        if (r18 >= r17.length) goto L19;
        if ((r18 % 2) == 0) goto L18;
        r17[r18] = BlendMode.mapToLegacyObricBlend(r17[r18], true);
    L18:
        r18 = r18 + 1;
        goto L14
    L19:
        xq.a r19 = r11.g;
        int r20 = r19.f23208b;
        float r110 = r19.f23207a;
        Object r21 = e(r10);
        HashMap r22 = f13678b;
        Method r23 = (Method) r22.get("legacy_setBackdropBlurEffectExt");
        if (r23 == null) goto L35;
    L24:
        r23.invoke(r21, new Object[]{Integer.valueOf(r20), Float.valueOf(r110), r17});     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "setBackdropBlurEffectExt error: ", "OMaterialHelper");
        return;
    L35:
        r23 = Class.forName("android.view.IExtView").getDeclaredMethod("setBackdropBlurEffectExt", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: Exception -> L22
        r23.setAccessible(true);     // Catch: Exception -> L22
        r22.put("legacy_setBackdropBlurEffectExt", r23);     // Catch: Exception -> L22
        goto L24
    L41:
        return;
    L40:
        return;
    }

    public static void p(int r5, Object r10) {
        if (j() == true) goto L5;
        return;
    L5:
        Object r11 = d(r10);
        HashMap r12 = f13678b;
        Method r13 = (Method) r12.get("setObricEffectSource_1");
        if (r13 == null) goto L14;
    L10:
        r13.invoke(r11, new Object[]{Integer.valueOf(r5)});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "setEffectSrc error: ", "OMaterialHelper");
        return;
    L14:
        r13 = Class.forName("android.view.IExtEffect").getDeclaredMethod("setObricEffectSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L8
        r13.setAccessible(true);     // Catch: Exception -> L8
        r12.put("setObricEffectSource_1", r13);     // Catch: Exception -> L8
        goto L10
    }

    public static void q(int r5, int r10, Object r11) {
        if (j() == true) goto L5;
        return;
    L5:
        Object r12 = d(r11);
        HashMap r13 = f13678b;
        Method r14 = (Method) r13.get("setObricEffectSource_2");
        if (r14 == null) goto L14;
    L10:
        r14.invoke(r12, new Object[]{Integer.valueOf(r5), Integer.valueOf(r10)});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        Class<?> r15 = Class.forName("android.view.IExtEffect");     // Catch: Exception -> L8
        Class r16 = Integer.TYPE;     // Catch: Exception -> L8
        r14 = r15.getDeclaredMethod("setObricEffectSource", new Class[]{r16, r16});     // Catch: Exception -> L8
        r14.setAccessible(true);     // Catch: Exception -> L8
        r13.put("setObricEffectSource_2", r14);     // Catch: Exception -> L8
        goto L10
    }

    public static void r(View r5, Object r10) {
        if (j() == true) goto L5;
        return;
    L5:
        Object r11 = d(r10);
        HashMap r12 = f13678b;
        Method r13 = (Method) r12.get("setObricEffectSourceTarget");
        if (r13 == null) goto L14;
    L10:
        r13.invoke(r11, new Object[]{r5});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        r13 = Class.forName("android.view.IExtEffect").getDeclaredMethod("setObricEffectSourceTarget", new Class[]{View.class});     // Catch: Exception -> L8
        r13.setAccessible(true);     // Catch: Exception -> L8
        r12.put("setObricEffectSourceTarget", r13);     // Catch: Exception -> L8
        goto L10
    }

    public static void s(Object r5, boolean r10, float[] r11) {
        if (j() == true) goto L5;
        return;
    L5:
        Object r12 = d(r5);
        HashMap r13 = f13678b;
        Method r14 = (Method) r13.get("setObricLiquidGlassEffectRR");
        if (r14 == null) goto L17;
    L10:
        if (r10 == true) goto L13;
        r11 = new float[0];     // Catch: Exception -> L8
    L13:
        r14.invoke(r12, new Object[]{r11});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "setFluidEffect error: ", "OMaterialHelper");
        return;
    L17:
        r14 = Class.forName("android.view.IExtEffect").getDeclaredMethod("setObricLiquidGlassEffectRR", new Class[]{float[].class});     // Catch: Exception -> L8
        r14.setAccessible(true);     // Catch: Exception -> L8
        r13.put("setObricLiquidGlassEffectRR", r14);     // Catch: Exception -> L8
        goto L10
    }

    public static void t(Object r10, int r11, c[] r12) {
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.length != 1) goto L21;
        c r13 = r12[0];
        if (r10 == null) goto L47;
        if (r13 != null) goto L11;
        return;
    L11:
        if (r13.f13611c == null) goto L13;
    L20:
        q(r11, 1, r10);
        a(r10, r13);
        return;
    L13:
        if (r13.g != null) goto L20;
        if (r13.f13612h != null) goto L20;
        if (r13.f13614j != null) goto L20;
        q(0, 1, r10);
        return;
    L47:
        return;
    L21:
        int r5 = 0;
    L23:
        if (r5 >= r12.length) goto L57;
        if (r5 != 0) goto L26;
        int r14 = 1;
    L27:
        c r15 = r12[r5];
        sj.k r16 = g(r14, r10);
        if (r16 == null) goto L46;
        if (r15 == null) goto L46;
        if (r15.f13611c == null) goto L34;
    L41:
        boolean r17 = true;
    L42:
        Object r18 = r16.f21937a;
        if (r17 == true) goto L45;
        q(0, 1, r18);
        goto L46
    L45:
        q(r11, 1, r18);
        a(r18, r15);
        goto L46
    L34:
        if (r15.g != null) goto L41;
        if (r15.f13612h != null) goto L41;
        if (r15.f13614j != null) goto L41;
        r17 = false;
    L46:
        r5 = r5 + 1;
        goto L23
    L26:
        r14 = 2;
        goto L27
    }

    public static void u(Object r10, float r11, int r12) {
        int r5 = BlendMode.SRC_OVER.getPorterDuffMode();
        if (j() == false) goto L16;
        Object r13 = d(r10);
        HashMap r14 = f13678b;
        Method r15 = (Method) r14.get("setObricBlurStroke");
        if (r15 == null) goto L14;
    L10:
        r15.invoke(r13, new Object[]{Float.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r5)});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("OMaterialHelper", "setStrokeEffect error: ", e);
        return;
    L14:
        Class<?> r16 = Class.forName("android.view.IExtEffect");     // Catch: Exception -> L8
        Class r17 = Float.TYPE;     // Catch: Exception -> L8
        Class r18 = Integer.TYPE;     // Catch: Exception -> L8
        r15 = r16.getDeclaredMethod("setObricBlurStroke", new Class[]{r17, r18, r18});     // Catch: Exception -> L8
        r15.setAccessible(true);     // Catch: Exception -> L8
        r14.put("setObricBlurStroke", r15);     // Catch: Exception -> L8
        goto L10
    }

    public static int[] v(com.obric.oui.color.a[] r5) {
        int r10 = 0;
        if (r5 == null) goto L5;
        int r11 = r5.length * 2;
        int[] r12 = new int[r11];
    L7:
        if (r10 >= r11) goto L13;
        com.obric.oui.color.a r13 = r5[r10 / 2];
        if ((r10 % 2) != 0) goto L11;
        int r14 = r13.f12398a;
    L12:
        r12[r10] = r14;
        r10 = r10 + 1;
        goto L7
    L11:
        r14 = r13.f12399b;
        goto L12
    L13:
        return r12;
    L5:
        return new int[0];
    }
}
