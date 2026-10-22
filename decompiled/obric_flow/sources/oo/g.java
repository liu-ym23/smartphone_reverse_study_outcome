package oo;

import android.graphics.Bitmap;
import android.util.Log;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.service.ILynxImageService;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f20803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f20804b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f20805c = null;
    public static Method d = null;
    public static boolean e = true;
    public static boolean f = true;

    static {
        f20803a = ImageDecodeOptionsBuilder.class.getDeclaredMethod("a", new Class[]{Integer.TYPE});     // Catch: Throwable -> L5
    L14:
        f20804b = AnimatedDrawable2.class.getDeclaredMethod("setPrivateFrameScheduler", new Class[]{FrameScheduler.class});     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        LynxLog.b(4, "Fresco", Log.getStackTraceString(th));
        return;
    L5:
        th = move-exception;
        LynxLog.b(4, "Fresco", Log.getStackTraceString(th));
        goto L14
    }

    public static void a(AnimatedDrawable2 r5) {
        Method r10 = f20804b;
        if (r10 != null) goto L15;
        return;
    L15:
        r10.invoke(r5, new Object[]{new DropFramesFrameScheduler(r5.getAnimationBackend())});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10
        return;
    L10:
        e = move-exception;
        LynxLog.b(4, "Fresco", Log.getStackTraceString(e));
        return;
    L8:
        e = move-exception;
        LynxLog.b(4, "Fresco", Log.getStackTraceString(e));
    }

    public static void b(ImageRequestBuilder r5, Bitmap.Config r10, boolean r11) {
        if (r10 != null) goto L5;
        r10 = Bitmap.Config.ARGB_8888;
    L5:
        ImageDecodeOptionsBuilder r12 = new ImageDecodeOptionsBuilder();
        r12.f8046b = r10;
        r12.d = true;
        Method r13 = f20803a;
        if (r13 != null) goto L22;
    L16:
        if (r11 == false) goto L20;
        ILynxImageService r14 = (ILynxImageService) r.g().e(ILynxImageService.class);
        if (r14 == null) goto L20;
        r14.setCustomImageDecoder(r12);
    L20:
        r5.e = new ImageDecodeOptions(r12);
        return;
    L22:
        r13.invoke(r12, new Object[]{0});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12
    L12:
        e = move-exception;
        LynxLog.b(4, "Fresco", Log.getStackTraceString(e));
    L10:
        e = move-exception;
        LynxLog.b(4, "Fresco", Log.getStackTraceString(e));
        goto L16
    }

    public static void c(ImageRequestBuilder r5, HashMap r10) {
        if (f == true) goto L6;
        return;
    L6:
        if (d == null) goto L19;
    L17:
        d.invoke(r5, new Object[]{r10});     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        LynxLog.b(4, "Fresco", Log.getStackTraceString(th));
        return;
    L19:
        d = ImageRequestBuilder.class.getDeclaredMethod("a", new Class[]{Map.class});     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        LynxLog.b(4, "Fresco", Log.getStackTraceString(th));
        f = false;
    }

    public static boolean d(AnimatedDrawable2 r10) {
        if (e == true) goto L6;
        return false;
    L6:
        if (f20805c != null) goto L25;
        f20805c = AnimatedDrawable2.class.getDeclaredMethod("pause", null);     // Catch: NoSuchMethodException -> L9
    L9:
        e = move-exception;
        e = false;
        LynxLog.b(4, "Fresco", Log.getStackTraceString(e));
        return false;
    L25:
        f20805c.invoke(r10, null);     // Catch: InvocationTargetException -> L15 IllegalAccessException -> L17
        return true;
    L17:
        e = move-exception;
        e = false;
        LynxLog.b(4, "Fresco", Log.getStackTraceString(e));
        return false;
    L15:
        e = move-exception;
        e = false;
        LynxLog.b(4, "Fresco", Log.getStackTraceString(e));
        return false;
    }
}
