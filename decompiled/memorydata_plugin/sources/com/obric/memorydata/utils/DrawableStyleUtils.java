package com.obric.memorydata.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J@\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0003\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0013JH\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0003\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0013J<\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0001\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J<\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0001\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J2\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0001\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/utils/DrawableStyleUtils;", "", "<init>", "()V", "TAG", "", "getSystemIconMaskPath", "Landroid/graphics/Path;", "resources", "Landroid/content/res/Resources;", "createSystemMaskPath", "size", "", "clipAndStroke", "Landroid/graphics/drawable/Drawable;", "drawable", "strokeWidth", "strokeColor", "strokeStyle", "Lcom/obric/memorydata/utils/DrawableStyleUtils$StrokeStyle;", "clipAndStrokeWithCorners", "cornerRadii", "", "clipAndStrokeBitmap", "Landroid/graphics/Bitmap;", "bitmap", "clipAndStrokeBitmapWithCorners", "createFallbackRoundedSquarePath", "createRoundRectPath", "drawBitmapInPath", "", "canvas", "Landroid/graphics/Canvas;", "path", "drawInnerStroke", "drawableToBitmap", "targetSize", "StrokeStyle", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DrawableStyleUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DrawableStyleUtils f13143a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f13144b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/utils/DrawableStyleUtils$StrokeStyle;", "", "<init>", "(Ljava/lang/String;I)V", "SOLID", "DASHED", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum StrokeStyle extends Enum<StrokeStyle> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ StrokeStyle[] $VALUES = null;
        public static final StrokeStyle DASHED = null;
        public static final StrokeStyle SOLID = null;

        private static final /* synthetic */ StrokeStyle[] $values() {
            return new StrokeStyle[]{SOLID, DASHED};
        }

        static {
            SOLID = new StrokeStyle("SOLID", 0);
            DASHED = new StrokeStyle("DASHED", 1);
            StrokeStyle[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private StrokeStyle(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<StrokeStyle> getEntries() {
            return $ENTRIES;
        }

        public static StrokeStyle valueOf(String r2) {
            return (StrokeStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(StrokeStyle.class, r2), StrokeStyle.class, "com.obric.memorydata.plugin");
        }

        public static StrokeStyle[] values() {
            return (StrokeStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StrokeStyle[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f13143a = new DrawableStyleUtils();
        f13144b = "DrawableStyleUtils";
    }

    private DrawableStyleUtils() {
    }

    private final Bitmap a(Resources r10, Bitmap r11, int r12, int r13, int r14, StrokeStyle r15) {
        if (r12 > 0) goto L14;
        return null;
    L14:
        Bitmap r1 = Bitmap.createBitmap(r12, r12, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L11
        Canvas r8 = new Canvas(r1);     // Catch: Exception -> L11
        Path r4 = a(r10, r12);     // Catch: Exception -> L11
        int r9 = r8.save();     // Catch: Exception -> L11
        r8.clipPath(r4);     // Catch: Exception -> L11
        DrawableStyleUtils r2 = f13143a;     // Catch: Throwable -> L8
        r2.a(r8, r11, r4, r12);     // Catch: Throwable -> L8
        r2.a(r8, r4, r13, r14, r15);     // Catch: Throwable -> L8
        r8.restoreToCount(r9);     // Catch: Exception -> L11
        return r1;
    L8:
        th = move-exception;
        r8.restoreToCount(r9);     // Catch: Exception -> L11
        throw th;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private final Bitmap a(Drawable r4, int r5) {
        if (ZeusTransformUtils.instanceOf(r4, BitmapDrawable.class) == true) goto L5;
    L19:
        Bitmap r3 = Bitmap.createBitmap(r5, r5, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L16
        Canvas r0 = new Canvas(r3);     // Catch: Exception -> L16
        monitor-enter(r4);     // Catch: Exception -> L16
        Rect r1 = r4.copyBounds();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r1, "copyBounds(...)");     // Catch: Throwable -> L13
        r4.setBounds(0, 0, r5, r5);     // Catch: Throwable -> L13
        r4.draw(r0);     // Catch: Throwable -> L13
        r4.setBounds(r1);     // Catch: Throwable -> L13
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r4);     // Catch: Exception -> L16
        return r3;
    L13:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        RunLog.INSTANCE.error(f13144b, "drawableToBitmap failed for " + r4.getClass().getSimpleName(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L5:
        if (((BitmapDrawable) ZeusTransformUtils.preCheckCast(r4, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap() == null) goto L19;
        return ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r4, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap();
    }

    private final Path a(int r3) {
        float r2 = r3;
        float r4 = 0.18f * r2;
        RectF r0 = new RectF(0.0f, 0.0f, r2, r2);
        Path r5 = new Path();
        r5.addRoundRect(r0, r4, r4, Path.Direction.CW);
        return r5;
    }

    private final Path a(Resources r5) {
        Path r6 = new AdaptiveIconDrawable(null, null, null).getIconMask();     // Catch: Exception -> L7
        RunLog.INSTANCE.debug(f13144b, "maskPath: " + r6);     // Catch: Exception -> L7
        if ((!r6.isEmpty()) == true) goto L13;
        return null;
    L13:
        return r6;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private final Path a(Resources r2, int r3) {
        Path r4 = a(r2);
        if (r4 == null) goto L6;
        Path r1 = new Path(r4);
        Matrix r5 = new Matrix();
        float r6 = r3 / 100.0f;
        r5.setScale(r6, r6);
        r1.transform(r5);
        return r1;
    L6:
        return a(r3);
    }

    public static /* synthetic */ Drawable a(DrawableStyleUtils r9, Resources r10, Drawable r11, int r12, int r13, int r14, StrokeStyle r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        int r6 = 0;
    L7:
        if ((r16 & 16) == 0) goto L9;
        int r7 = 0;
    L11:
        if ((r16 & 32) == 0) goto L13;
        StrokeStyle r8 = StrokeStyle.SOLID;
    L15:
        return r9.a(r10, r11, r12, r6, r7, r8);
    L13:
        r8 = r15;
        goto L15
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }

    private final void a(Canvas r4, Bitmap r5, Path r6, int r7) {
        if (r5.getWidth() == r7) goto L5;
    L8:
        Bitmap r3 = Bitmap.createScaledBitmap(r5, r7, r7, true);
    L9:
        Paint r8 = new Paint(1);
        r8.setShader((Shader) ZeusTransformUtils.preCheckCast(new BitmapShader(r3, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP), Shader.class, "com.obric.memorydata.plugin"));
        r4.drawPath(r6, r8);
        if (r3 != r5) goto L12;
        return;
    L12:
        if (r3.isRecycled() == true) goto L16;
        r3.recycle();
        return;
    L16:
        return;
    L5:
        if (r5.getHeight() != r7) goto L8;
        r3 = r5;
        goto L9
    }

    private final void a(Canvas r3, Path r4, int r5, int r6, StrokeStyle r7) {
        if (r5 <= 0) goto L10;
        if (r6 == 0) goto L11;
        Paint r2 = new Paint(1);
        r2.setStyle(Paint.Style.STROKE);
        r2.setStrokeWidth(r5 * 2);
        r2.setColor(r6);
        if (r7 != StrokeStyle.DASHED) goto L8;
        r2.setPathEffect((PathEffect) ZeusTransformUtils.preCheckCast(new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f), PathEffect.class, "com.obric.memorydata.plugin"));
    L8:
        r3.drawPath(r4, r2);
        return;
    L11:
        return;
    }

    public final Drawable a(Resources r9, Drawable r10, int r11, int r12, int r13, StrokeStyle r14) {
        Intrinsics.checkNotNullParameter(r9, "resources");
        Intrinsics.checkNotNullParameter(r14, "strokeStyle");
        if (r10 != null) goto L5;
        return null;
    L5:
        Bitmap r3 = a(r10, r11);
        if (r3 != null) goto L8;
        return null;
    L8:
        Bitmap r8 = a(r9, r3, r11, r12, r13, r14);
        if (r8 != null) goto L12;
        return null;
    L12:
        return (Drawable) ZeusTransformUtils.preCheckCast(new BitmapDrawable(r9, r8), Drawable.class, "com.obric.memorydata.plugin");
    }
}
