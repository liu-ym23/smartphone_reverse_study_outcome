package com.lynx.tasm.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.renderscript.Allocation;
import android.renderscript.BaseObj;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.base.TraceEvent;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@Keep
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

    @RequiresApi(17)
    public static Bitmap blur(Context r10, Bitmap r11, int r12, int r13, float r14, int r15) {
        if (r12 == 0) goto L18;
        if (r13 != 0) goto L6;
        return null;
    L6:
        if (r15 <= 1) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        Bitmap r16 = Bitmap.createScaledBitmap(r11, r12 / r15, r13 / r15, true);
    L20:
        r16 = rs(r10, r16, r14);     // Catch: RSRuntimeException -> L14
    L15:
        if (r5 == false) goto L17;
        int[] r17 = new int[r12 * r13];
        Bitmap.createScaledBitmap(r16, r12, r13, true).getPixels(r17, 0, r12, 0, 0, r12, r13);
        r11.setPixels(r17, 0, r12, 0, 0, r12, r13);
    L17:
        return r11;
    L14:
        iterativeBoxBlur(r16, (int) r14);
        goto L15
    L11:
        r16 = r11;
        goto L20
    L8:
        r5 = false;
        goto L9
    L18:
        return null;
    }

    public static boolean createEffect(View r5, float r10) {
        if (isSupportRenderEffect() == true) goto L6;
        return false;
    L6:
        if (r10 > 0.0f) goto L9;
        return false;
    L9:
        if (prepareViewSetMethod() == true) goto L18;
        sSupportRenderEffect = false;
        return false;
    L18:
        sSetRenderEffect.invoke(r5, new Object[]{sCreateBlurEffect.invoke(null, new Object[]{Float.valueOf(r10), Float.valueOf(r10), Shader.TileMode.CLAMP})});     // Catch: Throwable -> L15
        return true;
    L15:
        e = move-exception;
        LynxLog.b(4, TAG, "createViewEffect failed " + e.getMessage());
        sSupportRenderEffect = false;
        return false;
    }

    private static boolean isSupportRenderEffect() {
        if (sSupportRenderEffect == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static void iterativeBoxBlur(Bitmap r5, int r10) {
        if (r5 != null) goto L6;
        LynxLog.b(3, "Blur", "bitmap is null");
        return;
    L6:
        if (r10 > 0) goto L14;
        LynxLog.b(3, "Blur", "radius <= 0");
        return;
    L14:
        TraceEvent.c("image.BlurUtils.nativeIterativeBoxBlur");     // Catch: RuntimeException -> L11
        nativeIterativeBoxBlur(r5, 3, r10);     // Catch: RuntimeException -> L11
        TraceEvent.a(0, "image.BlurUtils.nativeIterativeBoxBlur");     // Catch: RuntimeException -> L11
        return;
    L11:
        e = move-exception;
        LynxLog.b(3, "Blur", e.getMessage());
    }

    private static native void nativeIterativeBoxBlur(Bitmap r5, int r10, int r11);

    private static boolean prepareRenderEffect() {
        if (sRenderEffectClass == null) goto L24;
    L7:
        Class r5 = sRenderEffectClass;
        if (r5 == null) goto L16;
        if (sCreateBlurEffect != null) goto L16;
        Class r10 = Float.TYPE;     // Catch: NoSuchMethodException -> L13
        sCreateBlurEffect = r5.getMethod("createBlurEffect", new Class[]{r10, r10, Shader.TileMode.class});     // Catch: NoSuchMethodException -> L13
    L13:
        LynxLog.b(4, TAG, "prepareRenderEffectClass failed");
        return false;
    L16:
        if (sRenderEffectClass != null) goto L18;
    L21:
        return false;
    L18:
        if (sCreateBlurEffect == null) goto L21;
        return true;
    L24:
        sRenderEffectClass = Class.forName("android.graphics.RenderEffect");     // Catch: ClassNotFoundException -> L6
    L6:
        return false;
    }

    @RequiresApi(api = 29)
    private static boolean prepareRenderNodeSetMethod() {
        if (prepareRenderEffect() == true) goto L6;
        return false;
    L6:
        if (sSetNodeRenderEffect == null) goto L13;
        return true;
    L13:
        sSetNodeRenderEffect = RenderNode.class.getMethod("setRenderEffect", new Class[]{sRenderEffectClass});     // Catch: NoSuchMethodException -> L9
        return true;
    L9:
        LynxLog.b(4, TAG, "prepareRenderNodeRenderEffectMethods failed");
        sSupportRenderEffect = false;
        return false;
    }

    private static boolean prepareViewSetMethod() {
        if (prepareRenderEffect() == true) goto L6;
        return false;
    L6:
        if (sSetRenderEffect == null) goto L13;
        return true;
    L13:
        sSetRenderEffect = View.class.getMethod("setRenderEffect", new Class[]{sRenderEffectClass});     // Catch: NoSuchMethodException -> L9
        return true;
    L9:
        LynxLog.b(4, TAG, "prepareRenderEffectMethods failed");
        return false;
    }

    public static boolean removeEffect(View r5) {
        if (isSupportRenderEffect() == true) goto L6;
        return false;
    L6:
        if (prepareViewSetMethod() == true) goto L14;
        sSupportRenderEffect = false;
        return false;
    L14:
        sSetRenderEffect.invoke(r5, new Object[]{null});     // Catch: Throwable -> L12
        return true;
    L12:
        sSupportRenderEffect = false;
        return false;
    }

    @RequiresApi(17)
    private static Bitmap rs(Context r5, Bitmap r10, float r11) {
        RenderScript r12 = null;
        ScriptIntrinsicBlur r13 = null;
        RenderScript r14 = RenderScript.create(r5);     // Catch: Throwable -> L16
        r14.setMessageHandler(new RenderScript.RSMessageHandler());     // Catch: Throwable -> L14
        Allocation r15 = Allocation.createFromBitmap(r14, r10, Allocation.MipmapControl.MIPMAP_NONE, 1);     // Catch: Throwable -> L14
        Allocation r16 = Allocation.createTyped(r14, r15.getType());     // Catch: Throwable -> L11
        r13 = ScriptIntrinsicBlur.create(r14, Element.U8_4(r14));     // Catch: Throwable -> L9
        r13.setInput(r15);     // Catch: Throwable -> L9
        r13.setRadius(r11);     // Catch: Throwable -> L9
        r13.forEach(r16);     // Catch: Throwable -> L9
        r16.copyTo(r10);     // Catch: Throwable -> L9
        r14.destroy();
        r15.destroy();
        r16.destroy();
        r13.destroy();
        return r10;
    L9:
        th = th;
        BaseObj r17 = r13;
        r12 = r14;
        BaseObj r18 = r17;
    L18:
        if (r12 == null) goto L20;
        r12.destroy();
    L20:
        if (r15 == null) goto L22;
        r15.destroy();
    L22:
        if (r16 == null) goto L24;
        r16.destroy();
    L24:
        if (r18 == null) goto L26;
        r18.destroy();
    L26:
        throw th;
    L11:
        th = th;
        r16 = null;
    L13:
        r12 = r14;
        r18 = r16;
    L14:
        th = th;
        r15 = null;
        r16 = null;
    L16:
        th = th;
        r18 = null;
        r15 = null;
        r16 = null;
        goto L18
    }

    public static boolean createEffect(RenderNode r5, float r10) {
        if (isSupportRenderEffect() == true) goto L6;
        return false;
    L6:
        if (r10 > 0.0f) goto L9;
        return false;
    L9:
        if (prepareRenderNodeSetMethod() == true) goto L18;
        sSupportRenderEffect = false;
        return false;
    L18:
        sSetNodeRenderEffect.invoke(r5, new Object[]{sCreateBlurEffect.invoke(null, new Object[]{Float.valueOf(r10), Float.valueOf(r10), Shader.TileMode.CLAMP})});     // Catch: Throwable -> L15
        return true;
    L15:
        e = move-exception;
        LynxLog.b(4, TAG, "createNodeEffect failed " + e.getMessage());
        sSupportRenderEffect = false;
        return false;
    }
}
