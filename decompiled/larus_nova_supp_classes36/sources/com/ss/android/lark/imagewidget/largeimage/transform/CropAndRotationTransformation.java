package com.ss.android.lark.imagewidget.largeimage.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001+B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014J \u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010*\u001a\u00020\u001cH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/ss/android/lark/imagewidget/largeimage/transform/CropAndRotationTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "crop", "", "mRotation", "", "<init>", "([FF)V", "getCrop", "()[F", "getMRotation", "()F", "DEFAULT_PAINT", "Landroid/graphics/Paint;", "ID", "", "ID_BYTES", "", "updateDiskCacheKey", "", "p0", "Ljava/security/MessageDigest;", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "inBitmap", "width", "", "height", "applyMatrix", "targetBitmap", "matrix", "Landroid/graphics/Matrix;", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "getBitmapRect", "Landroid/graphics/Rect;", "sourceWidth", "sourceHeight", "hashCode", "Companion", "imagewidget_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CropAndRotationTransformation extends BitmapTransformation {
    public static final a Companion = null;
    private static final String TAG = null;
    private final Paint DEFAULT_PAINT;
    private final String ID;
    private final byte[] ID_BYTES;
    private final float[] crop;
    private final float mRotation;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        TAG = "CropAndRotationTransformation";
    }

    public int hashCode() {
        float[] r0 = this.crop;
        if (r0 == null) goto L5;
        int r1 = Arrays.hashCode(r0);
    L7:
        return (r1 * 31) + Float.floatToIntBits(this.mRotation);
    L5:
        r1 = 0;
        goto L7
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final float[] getCrop() {
        return this.crop;
    }

    public final float getMRotation() {
        return this.mRotation;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof CropAndRotationTransformation) == true) goto L5;
        return false;
    L5:
        CropAndRotationTransformation r6 = (CropAndRotationTransformation) r5;
        if (this.mRotation != r6.mRotation) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        return false;
    L12:
        if (Arrays.equals(this.crop, r6.crop) == true) goto L14;
        return false;
    L14:
        return true;
    L8:
        r0 = false;
        goto L9
    }

    public void updateDiskCacheKey(MessageDigest r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        r2.update(this.ID_BYTES);
    }

    public CropAndRotationTransformation(float[] r1, float r2) {
        this.crop = r1;
        this.mRotation = r2;
        this.DEFAULT_PAINT = new Paint(6);
        this.ID = "com.bytedance.ee.bear.thumbnail.CropAndRotationTransformation";
        this.ID_BYTES = "com.bytedance.ee.bear.thumbnail.CropAndRotationTransformation".getBytes(Key.CHARSET);
    }

    private final synchronized void applyMatrix(Bitmap r2, Bitmap r3, Matrix r4) {
        monitor-enter(this);
        Canvas r0 = new Canvas(r3);     // Catch: Throwable -> L6
        r0.drawBitmap(r2, r4, this.DEFAULT_PAINT);     // Catch: Throwable -> L6
        r0.setBitmap(null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private final Rect getBitmapRect(int r4, int r5, float[] r6) {
        float r7 = r4;
        float r8 = r5;
        return new Rect((int) (r6[0] * r7), (int) (r6[1] * r8), (int) (r7 * r6[2]), (int) (r8 * r6[3]));
    }

    public /* synthetic */ CropAndRotationTransformation(float[] r1, float r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0.0f;
    L5:
        this(r1, r2);
    }

    public Bitmap transform(BitmapPool r7, Bitmap r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "pool");
        Intrinsics.checkNotNullParameter(r8, "inBitmap");
        int r2 = 0;
        if (this.mRotation != 0.0f) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L14;
        float[] r1 = this.crop;
        if (r1 != null) goto L11;
    L12:
        Log.i(TAG, "return the inBitmap");
        return r8;
    L11:
        if (r1.length != 4) goto L12;
    L14:
        Log.i(TAG, "crop and rotation");
        Matrix r3 = new Matrix();
        float[] r4 = this.crop;
        if (r4 != null) goto L17;
    L19:
        Rect r5 = null;
    L20:
        if (r5 != null) goto L22;
        int r6 = 0;
    L31:
        r3.postTranslate(-r2, -r6);
        r3.postRotate(this.mRotation);
        if (r8.getConfig() == null) goto L34;
        Bitmap.Config r11 = r8.getConfig();
    L35:
        Bitmap r12 = r7.get(r9, r10, r11);
        r12.setHasAlpha(r8.hasAlpha());
        applyMatrix(r8, r12, r3);
        return r12;
    L34:
        r11 = Bitmap.Config.ARGB_8888;
        goto L35
    L22:
        if (r5.left <= r8.getWidth()) goto L24;
        int r13 = r8.getWidth();
    L25:
        r2 = r13;
        if (r5.top <= r8.getHeight()) goto L28;
        int r14 = r8.getHeight();
    L29:
        int r15 = Math.min(r5.width(), r8.getWidth());
        int r16 = Math.min(r5.height(), r8.getHeight());
        r6 = r14;
        r9 = r15;
        r10 = r16;
        goto L31
    L28:
        r14 = r5.top;
        goto L29
    L24:
        r13 = r5.left;
        goto L25
    L17:
        if (r4.length != 4) goto L19;
        r5 = getBitmapRect(r8.getWidth(), r8.getHeight(), this.crop);
        goto L20
    L5:
        r0 = false;
        goto L7
    }
}
