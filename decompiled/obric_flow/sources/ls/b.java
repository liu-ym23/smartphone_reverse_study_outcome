package ls;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Paint f19783a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Paint f19784b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Matrix f19785c = null;
    public static final LinearGradient d = null;
    public static final LinearGradient e = null;

    static {
        PorterDuffXfermode r5 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        f19783a = new Paint();
        Paint r10 = new Paint();
        r10.setXfermode(r5);
        f19784b = r10;
        f19785c = new Matrix();
        Shader.TileMode r11 = Shader.TileMode.CLAMP;
        d = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, -1, ViewCompat.MEASURED_SIZE_MASK, r11);
        e = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, ViewCompat.MEASURED_SIZE_MASK, -1, r11);
    }

    public static Paint a(TextPaint r5) {
        Intrinsics.checkNotNullParameter(r5, "sourcePaint");
        Paint r10 = f19783a;
        r10.reset();
        if (r5.getBlendMode() == null) goto L6;
        r10.setBlendMode(r5.getBlendMode());
        return r10;
    L6:
        if (r5.getXfermode() == null) goto L8;
        r10.setXfermode(r5.getXfermode());
        return r10;
    L8:
        return null;
    }

    public static void b(Canvas r15, float r16, float r17, Paint r18, TextPaint r19, c r20, float r21, float r22, float r23, float r24, float r25, float r26, Function1 r27, BlendMode r28, Xfermode r29) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        Intrinsics.checkNotNullParameter(r19, "paint");
        Intrinsics.checkNotNullParameter(r20, "cache");
        Intrinsics.checkNotNullParameter(r27, "blurMaskFilterProvider");
        if (r24 > r23) goto L5;
        return;
    L5:
        int r14 = r15.saveLayer(r16, 0.0f, r17, r25, r18);
        r19.setBlendMode(null);     // Catch: Throwable -> L9
        r19.setXfermode(null);     // Catch: Throwable -> L9
        r19.setMaskFilter((MaskFilter) r27.invoke(Float.valueOf(r26)));     // Catch: Throwable -> L9
        r15.clipRect(r23, 0.0f, r24, r25);     // Catch: Throwable -> L9
        char[] r5 = r20.f19788c;     // Catch: Throwable -> L9
        r15.drawText(r5, 0, r5.length, r21, r22, r19);     // Catch: Throwable -> L9
        r15.restoreToCount(r14);
        r19.setBlendMode(r28);
        r19.setXfermode(r29);
        return;
    L9:
        th = move-exception;
        r15.restoreToCount(r14);
        r19.setBlendMode(r28);
        r19.setXfermode(r29);
        throw th;
    }
}
