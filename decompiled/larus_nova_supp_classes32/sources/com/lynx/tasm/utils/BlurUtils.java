package com.lynx.tasm.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BlurUtils {
    private static final int BLUR_DEFAULT_SAMPLING = 1;
    private static final int DEFAULT_ITERATIONS = 3;
    private static final String TAG = "BlurUtils";
    private static Method sCreateBlurEffect = null;
    private static Class sRenderEffectClass = null;
    private static Method sSetNodeRenderEffect = null;
    private static Method sSetRenderEffect = null;
    private static boolean sSupportRenderEffect = true;

    public BlurUtils() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private static native void nativeIterativeBoxBlur(Bitmap r0, int r1, int r2);

    private static boolean isSupportRenderEffect() {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L7:
        return false;
    L5:
        if (sSupportRenderEffect == false) goto L7;
        return true;
    }

    private static boolean prepareRenderEffect() {
        if (sRenderEffectClass == null) goto L23;
    L7:
        Class r0 = sRenderEffectClass;
        if (r0 == null) goto L16;
        if (sCreateBlurEffect != null) goto L16;
        Class<?> r5 = Float.TYPE;     // Catch: NoSuchMethodException -> L13
        sCreateBlurEffect = r0.getMethod("createBlurEffect", new Class[]{r5, r5, Shader.TileMode.class});     // Catch: NoSuchMethodException -> L13
    L13:
        LLog.e(TAG, "prepareRenderEffectClass failed");
        return false;
    L16:
        if (sRenderEffectClass != null) goto L18;
    L20:
        return false;
    L18:
        if (sCreateBlurEffect == null) goto L20;
        return true;
    L23:
        sRenderEffectClass = INVOKESTATIC_com_lynx_tasm_utils_BlurUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.graphics.RenderEffect");     // Catch: ClassNotFoundException -> L6
    L6:
        return false;
    }

    private static boolean prepareRenderNodeSetMethod() {
        if (prepareRenderEffect() == true) goto L6;
        return false;
    L6:
        if (sSetNodeRenderEffect == null) goto L12;
    L11:
        return true;
    L12:
        sSetNodeRenderEffect = RenderNode.class.getMethod("setRenderEffect", new Class[]{sRenderEffectClass});     // Catch: NoSuchMethodException -> L9
    L9:
        LLog.e(TAG, "prepareRenderNodeRenderEffectMethods failed");
        sSupportRenderEffect = false;
        return false;
    }

    private static boolean prepareViewSetMethod() {
        if (prepareRenderEffect() == true) goto L6;
        return false;
    L6:
        if (sSetRenderEffect == null) goto L12;
    L11:
        return true;
    L12:
        sSetRenderEffect = View.class.getMethod("setRenderEffect", new Class[]{sRenderEffectClass});     // Catch: NoSuchMethodException -> L9
    L9:
        LLog.e(TAG, "prepareRenderEffectMethods failed");
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_tasm_utils_BlurUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
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
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
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

    public static boolean removeEffect(View r5) {
        if (isSupportRenderEffect() == true) goto L6;
        return false;
    L6:
        if (prepareViewSetMethod() == true) goto L13;
        sSupportRenderEffect = false;
        return false;
    L13:
        sSetRenderEffect.invoke(r5, new Object[]{null});     // Catch: Throwable -> L11
        return true;
    L11:
        sSupportRenderEffect = false;
        return false;
    }

    public static boolean createEffect(RenderNode r5, float r6) {
        if (isSupportRenderEffect() == true) goto L6;
        return false;
    L6:
        if (r6 > 0.0f) goto L9;
        return false;
    L9:
        if (prepareRenderNodeSetMethod() == true) goto L21;
        sSupportRenderEffect = false;
        return false;
    L21:
        sSetNodeRenderEffect.invoke(r5, new Object[]{sCreateBlurEffect.invoke(null, new Object[]{Float.valueOf(r6), Float.valueOf(r6), Shader.TileMode.CLAMP})});     // Catch: Throwable -> L14 IllegalArgumentException -> L16 IllegalAccessException -> L18
        return true;
    L14:
        e = move-exception;
        LLog.e(TAG, "createNodeEffect failed " + e.getMessage());
        sSupportRenderEffect = false;
        return false;
    }

    public static void iterativeBoxBlur(Bitmap r3, int r4) {
        if (r3 != null) goto L6;
        LLog.w("Blur", "bitmap is null");
        return;
    L6:
        if (r4 > 0) goto L14;
        LLog.w("Blur", "radius <= 0");
        return;
    L14:
        TraceEvent.beginSection("image.BlurUtils.nativeIterativeBoxBlur");     // Catch: RuntimeException -> L11
        nativeIterativeBoxBlur(r3, 3, r4);     // Catch: RuntimeException -> L11
        TraceEvent.endSection("image.BlurUtils.nativeIterativeBoxBlur");     // Catch: RuntimeException -> L11
        return;
    L11:
        e = move-exception;
        LLog.w("Blur", e.getMessage());
    }

    public static boolean createEffect(View r5, float r6) {
        if (isSupportRenderEffect() == true) goto L6;
        return false;
    L6:
        if (r6 > 0.0f) goto L9;
        return false;
    L9:
        if (prepareViewSetMethod() == true) goto L21;
        sSupportRenderEffect = false;
        return false;
    L21:
        sSetRenderEffect.invoke(r5, new Object[]{sCreateBlurEffect.invoke(null, new Object[]{Float.valueOf(r6), Float.valueOf(r6), Shader.TileMode.CLAMP})});     // Catch: Throwable -> L14 IllegalArgumentException -> L16 IllegalAccessException -> L18
        return true;
    L14:
        e = move-exception;
        LLog.e(TAG, "createViewEffect failed " + e.getMessage());
        sSupportRenderEffect = false;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Bitmap rs(Context r5, Bitmap r6, float r7) throws RSRuntimeException {
        RenderScript r0 = null;
        ScriptIntrinsicBlur r1 = null;
        RenderScript r8 = RenderScript.create(r5);     // Catch: Throwable -> L16
        r8.setMessageHandler(new RenderScript.RSMessageHandler());     // Catch: Throwable -> L13
        Allocation r2 = Allocation.createFromBitmap(r8, r6, Allocation.MipmapControl.MIPMAP_NONE, 1);     // Catch: Throwable -> L13
        Allocation r3 = Allocation.createTyped(r8, r2.getType());     // Catch: Throwable -> L11
        r1 = ScriptIntrinsicBlur.create(r8, Element.U8_4(r8));     // Catch: Throwable -> L9
        r1.setInput(r2);     // Catch: Throwable -> L9
        r1.setRadius(r7);     // Catch: Throwable -> L9
        r1.forEach(r3);     // Catch: Throwable -> L9
        r3.copyTo(r6);     // Catch: Throwable -> L9
        r8.destroy();
        r2.destroy();
        r3.destroy();
        r1.destroy();
        return r6;
    L9:
        th = th;
        ScriptIntrinsicBlur r4 = r1;
        r0 = r8;
        ScriptIntrinsicBlur r9 = r4;
    L18:
        if (r0 == null) goto L20;
        r0.destroy();
    L20:
        if (r2 == null) goto L22;
        r2.destroy();
    L22:
        if (r3 == null) goto L24;
        r3.destroy();
    L24:
        if (r9 == 0) goto L26;
        r9.destroy();
    L26:
        throw th;
    L11:
        th = th;
        r3 = null;
    L15:
        r0 = r8;
        r9 = r3;
    L13:
        th = th;
        r2 = null;
        r3 = null;
    L16:
        th = th;
        r9 = 0;
        r2 = null;
        r3 = null;
        goto L18
    }

    public static Bitmap blur(Context r9, Bitmap r10, int r11, int r12, float r13, int r14) {
        if (r11 == 0) goto L20;
        if (r12 != 0) goto L6;
        return null;
    L6:
        if (r14 <= 1) goto L8;
        boolean r1 = true;
    L9:
        Boolean r2 = Boolean.valueOf(r1);
        if (r2.booleanValue() == false) goto L12;
        Bitmap r15 = Bitmap.createScaledBitmap(r10, r11 / r14, r12 / r14, true);
    L22:
        r15 = rs(r9, r15, r13);     // Catch: RSRuntimeException -> L15
    L17:
        if (r2.booleanValue() == false) goto L19;
        int[] r16 = new int[r11 * r12];
        Bitmap.createScaledBitmap(r15, r11, r12, true).getPixels(r16, 0, r11, 0, 0, r11, r12);
        r10.setPixels(r16, 0, r11, 0, 0, r11, r12);
    L19:
        return r10;
    L15:
        iterativeBoxBlur(r15, (int) r13);
        goto L17
    L12:
        r15 = r10;
        goto L22
    L8:
        r1 = false;
        goto L9
    L20:
        return null;
    }
}
