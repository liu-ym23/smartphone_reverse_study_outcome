package l8a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.ui.image.o;
import com.lynx.tasm.utils.i;
import com.obric.aivoice.core.data.NameKeys;
import u7a.k;
import u7a.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class a extends BasePostprocessor {
    private Bitmap.Config mBitmapConfig;
    private float[] mBorderRadii;
    private SimpleCacheKey mCacheKey;
    private String[] mCapInsets;
    private float mCapInsetsScale;
    private int mHeight;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private ScalingUtils.ScaleType mScaleType;
    private int mWidth;

    private void adjustPaddings() {
        int r0 = this.mPaddingLeft;
        int r1 = this.mPaddingRight;
        int r2 = r0 + r1;
        int r3 = this.mWidth;
        if (r2 <= r3) goto L6;
        if (r3 <= 0) goto L6;
        float r4 = r3 / (r0 + r1);
        this.mPaddingLeft = (int) (r0 * r4);
        this.mPaddingRight = (int) (r1 * r4);
    L6:
        int r5 = this.mPaddingTop;
        int r6 = this.mPaddingBottom;
        int r7 = r5 + r6;
        int r8 = this.mHeight;
        if (r7 <= r8) goto L11;
        if (r8 <= 0) goto L12;
        float r9 = r8 / (r5 + r6);
        this.mPaddingTop = (int) (r5 * r9);
        this.mPaddingBottom = (int) (r6 * r9);
        return;
    L12:
        return;
    }

    public CacheKey getPostprocessorCacheKey() {
        return this.mCacheKey;
    }

    private float ceil(float r3) {
        return (float) Math.ceil(r3);
    }

    private static String[] getCapInsetsArr(String r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        if (r9.equalsIgnoreCase(NameKeys.UnloadStrategy_No_Strategy) == true) goto L41;
        String[] r10 = r9.split(" ");
        if (r10.length > 4) goto L39;
        int r4 = 0;
        boolean r5 = true;
    L11:
        if (r4 >= Math.min(r10.length, 4)) goto L30;
        if (r10[r4].endsWith("px") == true) goto L18;
        if (r10[r4].endsWith("%") == true) goto L18;
    L16:
        r5 = false;
    L29:
        r4 = r4 + 1;
    L18:
        if (r10[r4].endsWith("px") == false) goto L24;
        if (r10[r4].length() <= 2) goto L16;
        String r6 = r10[r4];
        r5 = r6.substring(0, r6.length() - 2).matches("[+]?[0-9]*\\.?[0-9]+");
        goto L29
    L24:
        if (r10[r4].endsWith("%") == false) goto L29;
        if (r10[r4].length() <= 1) goto L16;
        String r7 = r10[r4];
        r5 = r7.substring(0, r7.length() - 1).matches("[+]?[0-9]*\\.?[0-9]+");
        goto L29
    L30:
        if (r5 == true) goto L32;
        return null;
    L32:
        return r10;
    L39:
        return null;
    L41:
        return null;
    }

    private static float getCapInsetsScale(String r3) {
        if (r3 != null) goto L5;
        return 1.0f;
    L5:
        if (r3.equalsIgnoreCase(NameKeys.UnloadStrategy_No_Strategy) == true) goto L15;
        return CastFloatProtector.parseFloat(r3);
    L9:
        th = move-exception;
        LLog.w("BaseRoundedCornerPostprocessor", "initCapInsetsScale error " + th.getMessage());
        return 1.0f;
    L15:
        return 1.0f;
    }

    private static m.b getScaleType(ScalingUtils.ScaleType r2) {
        m.f r0 = m.b.a;
        if (r2 != ScalingUtils.ScaleType.FIT_XY) goto L6;
        return r0;
    L6:
        if (r2 != ScalingUtils.ScaleType.FIT_CENTER) goto L9;
        return m.b.b;
    L9:
        if (r2 != ScalingUtils.ScaleType.CENTER_CROP) goto L12;
        return m.b.d;
    L12:
        if (r2 == ScalingUtils.ScaleType.CENTER) goto L14;
        return r0;
    L14:
        return m.b.c;
    }

    private void initCapInsets(String r1) {
        this.mCapInsets = getCapInsetsArr(r1);
    }

    private void initCapInsetsScale(String r1) {
        this.mCapInsetsScale = getCapInsetsScale(r1);
    }

    public CloseableReference<Bitmap> process(Bitmap r6, PlatformBitmapFactory r7) {
        Bitmap.Config r1 = this.mBitmapConfig;
        if (r1 != null) goto L37;
        r1 = r6.getConfig();
    L37:
        int r3 = this.mWidth;     // Catch: Throwable -> L23
        int r4 = this.mHeight;     // Catch: Throwable -> L23
        if (r1 != null) goto L11;
        r1 = BasePostprocessor.FALLBACK_BITMAP_CONFIGURATION;     // Catch: Throwable -> L23
    L11:
        CloseableReference r8 = r7.createBitmapInternal(r3, r4, r1);     // Catch: Throwable -> L23
    L21:
        th = th;
    L33:
        LLog.e("BaseRoundedCornerPostprocessor", "process image error " + th.getMessage());     // Catch: Throwable -> L29
        if (r8 == null) goto L28;
        CloseableReference.closeSafely(r8);
    L28:
        return null;
    L29:
        th = move-exception;
        if (r8 == null) goto L32;
        CloseableReference.closeSafely(r8);
    L32:
        throw th;
    L14:
        if (this.mCapInsets != null) goto L16;
        LLog.i("Lynx Image Processor", "process image from Fresco without cap-insets");     // Catch: Throwable -> L21
        transform((Bitmap) r8.get(), r6);     // Catch: Throwable -> L21
    L17:
        CloseableReference<Bitmap> r9 = CloseableReference.cloneOrNull(r8);     // Catch: Throwable -> L21
        if (r8 == null) goto L20;
        CloseableReference.closeSafely(r8);
    L20:
        return r9;
    L16:
        LLog.i("Lynx Image Processor", "process image from Fresco with cap-insets");     // Catch: Throwable -> L21
        transformWithCapInsets((Bitmap) r8.get(), r6);     // Catch: Throwable -> L21
    L23:
        th = th;
        r8 = null;
        goto L33
    }

    public void transform(Bitmap r20, Bitmap r21) {
        int r1 = this.mWidth;
        if (r1 == 0) goto L36;
        int r2 = this.mHeight;
        if (r2 == 0) goto L37;
        Canvas r9 = getInitCanvas(r20, r1, r2);
        Matrix r11 = new Matrix();
        Paint r8 = new Paint(1);
        int r4 = this.mPaddingLeft;
        float r5 = r4;
        int r6 = this.mPaddingTop;
        float r7 = r6;
        float r10 = (r1 - r4) - this.mPaddingRight;
        float r12 = (r2 - r6) - this.mPaddingBottom;
        float r15 = r21.getWidth();
        float r14 = r21.getHeight();
        Matrix r13 = o.a(this.mScaleType).getTransform(r11, new Rect(this.mPaddingLeft, this.mPaddingTop, r1 - this.mPaddingRight, r2 - this.mPaddingBottom), (int) r15, (int) r14, 0.0f, 0.0f);
        ScalingUtils.ScaleType r16 = this.mScaleType;
        if (r16 != ScalingUtils.ScaleType.FIT_CENTER) goto L15;
        float r17 = r10 / r15;
        float r18 = r12 / r14;
        if (r17 <= r18) goto L12;
        float r19 = r15 * r18;
        r5 = r5 + ((r10 - r19) / 2.0f);
        r10 = r19;
    L13:
        float r110 = r10;
        float r111 = r5;
        float r112 = r12;
    L17:
        float r113 = r7;
        boolean r3 = true;
        boolean r22 = true;
    L19:
        r8.setFilterBitmap(r22);
        RectF r23 = new RectF(Math.min(this.mPaddingLeft, r1), Math.min(this.mPaddingTop, r2), r1 - this.mPaddingRight, r2 - this.mPaddingBottom);
        float r24 = r23.right;
        float r25 = r23.left;
        if (r24 >= r25) goto L22;
        r23.right = r25;
    L22:
        float r26 = r23.bottom;
        float r27 = r23.top;
        if (r26 >= r27) goto L25;
        r23.bottom = r27;
    L25:
        Path r28 = new Path();
        float[] r29 = this.mBorderRadii;
        if (r29 != null) goto L28;
    L30:
        r28.addRect(r23, Path.Direction.CW);
    L31:
        r9.drawPath(r28, r8);
        r8.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r9.drawBitmap(r21, r13, r8);
        if (r3 == true) goto L34;
        return;
    L34:
        r8.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        float r30 = r1;
        r9.drawRect(0.0f, 0.0f, r30, ceil(r113), r8);
        float r114 = r112 + r113;
        r9.drawRect(0.0f, (int) r114, r30, r2, r8);
        float r31 = (int) r113;
        r9.drawRect(0.0f, r31, ceil(r111), ceil(r114), r8);
        r9.drawRect((int) (r111 + r110), r31, r30, ceil(r114), r8);
        return;
    L28:
        if (r29.length != 8) goto L30;
        r28.addRoundRect(r23, new float[]{Math.max(r29[0] - this.mPaddingLeft, 0.0f), Math.max(this.mBorderRadii[1] - this.mPaddingTop, 0.0f), Math.max(this.mBorderRadii[2] - this.mPaddingRight, 0.0f), Math.max(this.mBorderRadii[3] - this.mPaddingTop, 0.0f), Math.max(this.mBorderRadii[4] - this.mPaddingRight, 0.0f), Math.max(this.mBorderRadii[5] - this.mPaddingBottom, 0.0f), Math.max(this.mBorderRadii[6] - this.mPaddingLeft, 0.0f), Math.max(this.mBorderRadii[7] - this.mPaddingBottom, 0.0f)}, Path.Direction.CW);
        goto L31
    L12:
        float r32 = r14 * r17;
        r7 = r7 + ((r12 - r32) / 2.0f);
        r12 = r32;
        goto L13
    L15:
        if (r16 != ScalingUtils.ScaleType.CENTER) goto L18;
        float r33 = i.b(1.0f, 0.0f);
        float r34 = r15 * r33;
        float r35 = r33 * r14;
        float r36 = Math.round((r10 - r34) * 0.5f);
        r7 = Math.round((r12 - r35) * 0.5f);
        r110 = r34;
        r111 = r36;
        r112 = r35;
        goto L17
    L18:
        r3 = false;
        r22 = true;
        r110 = 0.0f;
        r111 = 0.0f;
        r112 = 0.0f;
        r113 = 0.0f;
        goto L19
    L37:
        return;
    }

    public void transformWithCapInsets(Bitmap r37, Bitmap r38) {
        int r2 = this.mWidth;
        if (r2 == 0) goto L24;
        int r3 = this.mHeight;
        if (r3 == 0) goto L25;
        Canvas r4 = getInitCanvas(r37, r2, r3);
        r4.clipRect(this.mPaddingLeft, this.mPaddingTop, r2 - this.mPaddingRight, r3 - this.mPaddingBottom);
        r4.drawARGB(0, 0, 0, 0);
        Paint r6 = new Paint(1);
        int r8 = this.mPaddingLeft;
        float r9 = r8;
        int r10 = this.mPaddingTop;
        float r11 = r10;
        float r5 = (r2 - r8) - this.mPaddingRight;
        float r7 = (r3 - r10) - this.mPaddingBottom;
        float r12 = r38.getWidth();
        float r13 = r38.getHeight();
        int r14 = (int) r12;
        int r15 = (int) r13;
        float[] r16 = getFloatCapInsetsArr(this.mCapInsets, r14, r15);
        float r17 = r16[3];
        float r18 = this.mCapInsetsScale;
        Rect r19 = new Rect(0, 0, (int) (r17 * r18), (int) (r18 * r16[0]));
        Rect r1 = new Rect(r19.right, r19.top, (int) (r12 - (r16[1] * this.mCapInsetsScale)), r19.bottom);
        Rect r20 = new Rect(r1.right, r19.top, r14, r19.bottom);
        Rect r21 = new Rect(r19.left, r19.bottom, r19.right, (int) (r13 - (r16[2] * this.mCapInsetsScale)));
        Rect r22 = new Rect(r21.right, r21.top, r1.right, r21.bottom);
        Rect r23 = new Rect(r22.right, r21.top, r20.right, r21.bottom);
        Rect r24 = new Rect(r21.left, r21.bottom, r21.right, r15);
        Rect r25 = new Rect(r24.right, r24.top, r22.right, r24.bottom);
        Rect r26 = new Rect(r25.right, r24.top, r23.right, r24.bottom);
        Rect r27 = new Rect();
        Rect r110 = new Rect();
        Rect r111 = new Rect();
        Rect r112 = new Rect();
        Rect r28 = new Rect();
        Rect r29 = new Rect();
        Rect r30 = new Rect();
        Rect r31 = new Rect();
        Rect r32 = new Rect();
        float r33 = r5 / r12;
        float r34 = r7 / r13;
        ScalingUtils.ScaleType r35 = this.mScaleType;
        if (r35 != ScalingUtils.ScaleType.FIT_CENTER) goto L15;
        if (r33 <= r34) goto L12;
    L11:
        float r36 = r12 * r34;
        r9 = r9 + ((r5 - r36) / 2.0f);
        r5 = r36;
    L22:
        int r0 = (int) r9;
        r27.left = r0;
        int r39 = (int) r11;
        r27.top = r39;
        r27.right = (int) (i.b(r16[3], 0.0f) + r9);
        r27.bottom = (int) (i.b(r16[0], 0.0f) + r11);
        r110.left = r27.right;
        r110.top = r27.top;
        int r40 = (int) ((r9 + r5) - i.b(r16[1], 0.0f));
        r110.right = r40;
        r110.bottom = r27.bottom;
        r111.left = r40;
        r111.top = r27.top;
        r111.right = r0 + ((int) r5);
        r111.bottom = r27.bottom;
        r112.left = r27.left;
        r112.top = r27.bottom;
        r112.right = r27.right;
        int r41 = (int) ((r11 + r7) - ((int) i.b(r16[2], 0.0f)));
        r112.bottom = r41;
        r28.left = r112.right;
        r28.top = r112.top;
        int r42 = r110.right;
        r28.right = r42;
        r28.bottom = r41;
        r29.left = r42;
        r29.top = r111.bottom;
        r29.right = r111.right;
        r29.bottom = r112.bottom;
        r30.left = r27.left;
        r30.top = r112.bottom;
        int r43 = r112.right;
        r30.right = r43;
        int r44 = r39 + ((int) r7);
        r30.bottom = r44;
        r31.left = r43;
        r31.top = r28.bottom;
        int r45 = r28.right;
        r31.right = r45;
        r31.bottom = r44;
        r32.left = r45;
        r32.top = r29.bottom;
        r32.right = r29.right;
        r32.bottom = r44;
        r4.drawBitmap(r38, r19, r27, r6);
        r4.drawBitmap(r38, r1, r110, r6);
        r4.drawBitmap(r38, r20, r111, r6);
        r4.drawBitmap(r38, r21, r112, r6);
        r4.drawBitmap(r38, r22, r28, r6);
        r4.drawBitmap(r38, r23, r29, r6);
        r4.drawBitmap(r38, r24, r30, r6);
        r4.drawBitmap(r38, r25, r31, r6);
        r4.drawBitmap(r38, r26, r32, r6);
        return;
    L12:
        float r113 = r13 * r33;
        r11 = r11 + ((r7 - r113) / 2.0f);
    L13:
        r7 = r113;
        goto L22
    L15:
        if (r35 != ScalingUtils.ScaleType.CENTER_CROP) goto L20;
        if (r33 <= r34) goto L11;
    L20:
        if (r35 != ScalingUtils.ScaleType.CENTER) goto L22;
        float r46 = i.b(1.0f, 0.0f);
        float r47 = r12 * r46;
        r113 = r13 * r46;
        r9 = Math.round((r5 - r47) * 0.5f);
        r11 = Math.round((r7 - r113) * 0.5f);
        r5 = r47;
        goto L13
    L25:
        return;
    }

    private static float[] getFloatCapInsetsArr(String[] r6, int r7, int r8) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (r6.length > 4) goto L28;
        float[] r0 = {0.0f, 0.0f, 0.0f, 0.0f};
        int r2 = 0;
    L8:
        if (r2 >= r6.length) goto L20;
        if (r6[r2].endsWith("px") == false) goto L13;
        String r3 = r6[r2];
        r0[r2] = CastFloatProtector.parseFloat(r3.substring(0, r3.length() - 2));
    L19:
        r2 = r2 + 1;
        goto L8
    L13:
        if (r6[r2].endsWith("%") == false) goto L19;
        if (r2 == 0) goto L18;
        if (r2 == 2) goto L18;
        String r4 = r6[r2];
        r0[r2] = CastFloatProtector.parseFloat(r4.substring(0, r4.length() - 2)) * r7;
    L18:
        String r5 = r6[r2];
        r0[r2] = CastFloatProtector.parseFloat(r5.substring(0, r5.length() - 2)) * r8;
        goto L19
    L20:
        return r0;
    L28:
        return null;
    }

    private Canvas getInitCanvas(Bitmap r4, int r5, int r6) {
        Canvas r0 = new Canvas(r4);
        r0.clipRect(this.mPaddingLeft, this.mPaddingTop, r5 - this.mPaddingRight, r6 - this.mPaddingBottom);
        r0.drawARGB(0, 0, 0, 0);
        return r0;
    }

    public void updateCacheKey(String r3, float[] r4, ScalingUtils.ScaleType r5, boolean r6) {
        StringBuilder r0 = new StringBuilder(NameKeys.UnloadStrategy_No_Strategy);
        if (r6 == true) goto L5;
        r0.append(r3);
    L5:
        r0.append(r5);
        if (r4 == null) goto L10;
        int r7 = r4.length;
        int r8 = 0;
    L8:
        if (r8 >= r7) goto L10;
        r0.append(r4[r8]);
        r8 = r8 + 1;
    L10:
        r0.append(this.mPaddingBottom);
        r0.append(this.mPaddingTop);
        r0.append(this.mPaddingLeft);
        r0.append(this.mPaddingRight);
        r0.append(this.mScaleType);
        String[] r9 = this.mCapInsets;
        if (r9 == null) goto L13;
        r0.append(r9);
        r0.append(this.mCapInsetsScale);
    L13:
        r0.append(this.mBitmapConfig);
        this.mCacheKey = new SimpleCacheKey(r0.toString());
    }

    public static Matrix getMatrix(int r0, int r1, int r2, int r3, ScalingUtils.ScaleType r4) {
        return k.e(r0, r1, r2, r3, getScaleType(r4));
    }

    public static boolean customDraw(int r10, int r11, int r12, int r13, ScalingUtils.ScaleType r14, String r15, String r16, Canvas r17, Bitmap r18) {
        return k.a(r10, r11, r12, r13, getScaleType(r14), r15, r16, r17, r18, 255);
    }

    public a(String r15, int r16, int r17, int r18, int r19, int r20, int r21, float[] r22, ScalingUtils.ScaleType r23, String r24, String r25, Bitmap.Config r26) {
        this(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, false);
    }

    public a(String r2, int r3, int r4, int r5, int r6, int r7, int r8, float[] r9, ScalingUtils.ScaleType r10, String r11, String r12, Bitmap.Config r13, boolean r14) {
        this.mBitmapConfig = null;
        this.mScaleType = r10;
        this.mWidth = r3;
        this.mHeight = r4;
        this.mPaddingLeft = r5;
        this.mPaddingTop = r6;
        this.mPaddingRight = r7;
        this.mPaddingBottom = r8;
        this.mBorderRadii = r9;
        initCapInsets(r11);
        initCapInsetsScale(r12);
        this.mBitmapConfig = r13;
        updateCacheKey(r2, r9, r10, r14);
        adjustPaddings();
    }
}
