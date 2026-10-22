package m8a;

import android.graphics.Bitmap;
import android.util.Log;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.ILynxImageService;
import i8a.n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final Method a = null;
    public static final Method b = null;
    public static Method c = null;
    public static final Method d = null;
    public static final Method e = null;
    public static Method f = null;
    public static boolean g = true;
    public static boolean h = true;

    static {
        a = ImageDecodeOptionsBuilder.class.getDeclaredMethod("setPreDecodeFrameCount", new Class[]{Integer.TYPE});     // Catch: Throwable -> L5
    L26:
        b = AnimatedDrawable2.class.getDeclaredMethod("setPrivateFrameScheduler", new Class[]{FrameScheduler.class});     // Catch: Throwable -> L9
    L24:
        d = ImageRequestBuilder.class.getDeclaredMethod("setProgressiveRenderingAnimatedEnabled", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L13
    L20:
        e = ImageRequestBuilder.class.getDeclaredMethod("setProgressiveRenderingHeicEnabled", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(th));
        return;
    L13:
        th = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(th));
    L9:
        th = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(th));
    L5:
        th = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(th));
        goto L26
    }

    public static void a(ImageRequestBuilder r2) {
        b(r2, Bitmap.Config.ARGB_8888, false);
    }

    public static void c(AnimatedDrawable2 r5) {
        Method r1 = b;
        if (r1 != null) goto L13;
        return;
    L13:
        r1.invoke(r5, new Object[]{new DropFramesFrameScheduler(r5.getAnimationBackend())});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10
    L16:
        return;
    L10:
        e = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(e));
        return;
    L8:
        e = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(e));
    }

    public static boolean d(AnimatedDrawable2 r5) {
        if (g == true) goto L6;
        return false;
    L6:
        if (c != null) goto L23;
        c = AnimatedDrawable2.class.getDeclaredMethod("pause", new Class[0]);     // Catch: NoSuchMethodException -> L9
    L9:
        e = move-exception;
        g = false;
        LLog.e("Fresco", Log.getStackTraceString(e));
        return false;
    L23:
        c.invoke(r5, new Object[0]);     // Catch: InvocationTargetException -> L15 IllegalAccessException -> L18
        return true;
    L18:
        e = move-exception;
        g = false;
        LLog.e("Fresco", Log.getStackTraceString(e));
        return false;
    L15:
        e = move-exception;
        g = false;
        LLog.e("Fresco", Log.getStackTraceString(e));
        return false;
    }

    public static void e(ImageRequestBuilder r7, Map<String, String> r8) {
        if (h == true) goto L6;
        return;
    L6:
        if (f == null) goto L19;
    L17:
        f.invoke(r7, new Object[]{r8});     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(th));
        return;
    L19:
        f = ImageRequestBuilder.class.getDeclaredMethod("setCustomParam", new Class[]{Map.class});     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(th));
        h = false;
    }

    public static void b(ImageRequestBuilder r5, Bitmap.Config r6, boolean r7) {
        if (r6 != null) goto L5;
        r6 = Bitmap.Config.ARGB_8888;
    L5:
        ImageDecodeOptionsBuilder r8 = new ImageDecodeOptionsBuilder().setBitmapConfig(r6);
        Method r1 = a;
        if (r1 != null) goto L20;
    L14:
        if (r7 == false) goto L18;
        ILynxImageService r9 = (ILynxImageService) n.c().a(ILynxImageService.class);
        if (r9 == null) goto L18;
        r9.setCustomImageDecoder(r8);
    L18:
        r5.setImageDecodeOptions(r8.build());
        return;
    L20:
        r1.invoke(r8, new Object[]{0});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12
    L12:
        e = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(e));
    L10:
        e = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(e));
        goto L14
    }
}
