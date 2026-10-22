package no;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.ui.image.e0;
import wn.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends BasePostprocessor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20282c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f20283h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f20284i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ScalingUtils.ScaleType f20285j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SimpleCacheKey f20286k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String[] f20287l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f20288m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Bitmap.Config f20289n;

    public a(String r16, int r17, int r18, int r19, int r20, int r21, int r22, float[] r23, ScalingUtils.ScaleType r24, String r25, String r26, Bitmap.Config r27, boolean r28) {
        String[] r5 = null;
        this.f20289n = null;
        this.f20285j = r24;
        this.f20282c = r17;
        this.d = r18;
        this.e = r19;
        this.f20283h = r20;
        this.f = r21;
        this.g = r22;
        this.f20284i = r23;
        int r10 = 0;
        if (r25 != null) goto L5;
    L32:
        this.f20287l = r5;
        float r11 = 1.0f;
        if (r26 != null) goto L35;
    L41:
        this.f20288m = r11;
        this.f20289n = r27;
        StringBuilder r12 = new StringBuilder("");
        if (r28 == true) goto L44;
        r12.append(r16);
    L44:
        r12.append(r24);
        if (r23 == null) goto L49;
        int r13 = r23.length;
    L47:
        if (r10 >= r13) goto L49;
        r12.append(r23[r10]);
        r10 = r10 + 1;
    L49:
        r12.append(this.g);
        r12.append(this.f20283h);
        r12.append(this.e);
        r12.append(this.f);
        r12.append(this.f20285j);
        String[] r14 = this.f20287l;
        if (r14 == null) goto L52;
        r12.append(r14);
        r12.append(this.f20288m);
    L52:
        r12.append(this.f20289n);
        this.f20286k = new SimpleCacheKey(r12.toString());
        int r15 = this.e;
        int r29 = this.f;
        int r30 = r15 + r29;
        int r31 = this.f20282c;
        if (r30 <= r31) goto L56;
        if (r31 <= 0) goto L56;
        float r32 = r31 / r30;
        this.e = (int) (r15 * r32);
        this.f = (int) (r29 * r32);
    L56:
        int r33 = this.f20283h;
        int r34 = this.g;
        int r35 = r33 + r34;
        int r36 = this.d;
        if (r35 <= r36) goto L69;
        if (r36 <= 0) goto L70;
        float r37 = r36 / r35;
        this.f20283h = (int) (r33 * r37);
        this.g = (int) (r34 * r37);
        return;
    L70:
        return;
    L69:
        return;
    L35:
        if (r26.equalsIgnoreCase("") == true) goto L41;
        r11 = Float.parseFloat(r26);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        LynxLog.b(3, "BaseRoundedCornerPostprocessor", "initCapInsetsScale error " + th.getMessage());
        goto L41
    L5:
        if (r25.equalsIgnoreCase("") == true) goto L32;
        String[] r38 = r25.split(" ");
        if (r38.length > 4) goto L32;
        int r110 = 0;
        boolean r111 = true;
    L11:
        if (r110 >= Math.min(r38.length, 4)) goto L30;
        if (r38[r110].endsWith("px") == true) goto L18;
        if (r38[r110].endsWith("%") == true) goto L18;
    L27:
        r111 = false;
    L29:
        r110 = r110 + 1;
    L18:
        if (r38[r110].endsWith("px") == false) goto L24;
        if (r38[r110].length() <= 2) goto L27;
        String r112 = r38[r110];
        r111 = r112.substring(0, r112.length() - 2).matches("[+]?[0-9]*\\.?[0-9]+");
        goto L29
    L24:
        if (r38[r110].endsWith("%") == false) goto L29;
        if (r38[r110].length() <= 1) goto L27;
        String r113 = r38[r110];
        r111 = r113.substring(0, r113.length() - 1).matches("[+]?[0-9]*\\.?[0-9]+");
        goto L29
    L30:
        if (r111 == false) goto L32;
        r5 = r38;
        goto L32
    }

    public static boolean b(int r11, int r12, int r13, int r14, ScalingUtils.ScaleType r15, String r16, String r17, Canvas r18, Bitmap r19) {
        g r5 = g.f22893h;
        if (r15 == ScalingUtils.ScaleType.f7893a) goto L16;
        if (r15 != ScalingUtils.ScaleType.f7895c) goto L10;
        r5 = g.g;
        goto L16
    L10:
        if (r15 != ScalingUtils.ScaleType.g) goto L13;
        r5 = g.f;
        goto L16
    L13:
        if (r15 != ScalingUtils.ScaleType.e) goto L16;
        r5 = g.e;
    L16:
        return com.bytedance.ies.bullet.base.utils.b.j(r11, r12, r13, r14, r5, r16, r17, r18, r19);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey a() {
        return this.f20286k;
    }

    public final void c(Bitmap r28, Bitmap r29) {
        int r10 = this.f20282c;
        if (r10 == 0) goto L38;
        int r11 = this.d;
        if (r11 == 0) goto L39;
        Canvas r15 = new Canvas(r28);
        int r12 = this.f;
        int r14 = this.g;
        int r5 = this.e;
        int r13 = this.f20283h;
        r15.clipRect(r5, r13, r10 - r12, r11 - r14);
        r15.drawARGB(0, 0, 0, 0);
        Matrix r20 = new Matrix();
        Paint r16 = new Paint(1);
        float r17 = r5;
        float r18 = r13;
        float r19 = (r10 - r5) - r12;
        float r21 = (r11 - r13) - r14;
        float r22 = r29.getWidth();
        float r23 = r29.getHeight();
        Rect r24 = new Rect(r5, r13, r10 - r12, r11 - r14);
        ScalingUtils.ScaleType r110 = this.f20285j;
        Matrix r25 = e0.b(r110).a(r20, r24, (int) r22, (int) r23, 0.0f, 0.0f);
        if (r110 != ScalingUtils.ScaleType.f7895c) goto L17;
        float r26 = r19 / r22;
        float r111 = r21 / r23;
        if (r26 <= r111) goto L15;
        r22 = r22 * r111;
        r17 = androidx.constraintlayout.motion.widget.a.a(r19, r22, 2.0f, r17);
    L12:
        r19 = r22;
    L13:
        float r27 = r17;
        boolean r30 = true;
    L20:
        r16.setFilterBitmap(true);
        float r112 = r19;
        RectF r31 = new RectF(Math.min(r5, r10), Math.min(r13, r11), r10 - r12, r11 - r14);
        float r32 = r31.right;
        float r113 = r31.left;
        if (r32 >= r113) goto L23;
        r31.right = r113;
    L23:
        float r33 = r31.bottom;
        float r114 = r31.top;
        if (r33 >= r114) goto L26;
        r31.bottom = r114;
    L26:
        Path r34 = new Path();
        float[] r115 = this.f20284i;
        if (r115 != null) goto L29;
    L32:
        r34.addRect(r31, Path.Direction.CW);
    L33:
        r15.drawPath(r34, r16);
        r16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r15.drawBitmap(r29, r25, r16);
        if (r30 == false) goto L40;
        r16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        float r35 = r10;
        float r36 = r18;
        r15.drawRect(0.0f, 0.0f, r35, (float) Math.ceil(r36), r16);
        float r37 = r36 + r21;
        r15.drawRect(0.0f, (int) r37, r35, r11, r16);
        float r38 = (int) r36;
        float r39 = r27;
        double r40 = r37;
        r15.drawRect(0.0f, r38, (float) Math.ceil(r39), (float) Math.ceil(r40), r16);
        r15.drawRect((int) (r39 + r112), r38, r35, (float) Math.ceil(r40), r16);
        return;
    L40:
        return;
    L29:
        if (r115.length != 8) goto L32;
        r34.addRoundRect(r31, new float[]{Math.max(r115[0] - r5, 0.0f), Math.max(r115[1] - r13, 0.0f), Math.max(r115[2] - r12, 0.0f), Math.max(r115[3] - r13, 0.0f), Math.max(r115[4] - r12, 0.0f), Math.max(r115[5] - r14, 0.0f), Math.max(r115[6] - r5, 0.0f), Math.max(r115[7] - r14, 0.0f)}, Path.Direction.CW);
        goto L33
    L15:
        float r41 = r23 * r26;
        r18 = androidx.constraintlayout.motion.widget.a.a(r21, r41, 2.0f, r18);
        r21 = r41;
        goto L13
    L17:
        if (r110 != ScalingUtils.ScaleType.e) goto L19;
        r17 = Math.round((r19 - r22) * 0.5f);
        r18 = Math.round((r21 - r23) * 0.5f);
        r21 = r23;
        goto L12
    L19:
        r18 = 0.0f;
        r19 = 0.0f;
        r21 = 0.0f;
        r27 = 0.0f;
        r30 = false;
        goto L20
    L39:
        return;
    }

    public final void d(Bitmap r35, Bitmap r36) {
        int r5 = this.f20282c;
        if (r5 == 0) goto L50;
        int r10 = this.d;
        if (r10 == 0) goto L51;
        Canvas r11 = new Canvas(r35);
        int r12 = this.f;
        int r13 = this.g;
        int r14 = this.e;
        int r15 = this.f20283h;
        r11.clipRect(r14, r15, r5 - r12, r10 - r13);
        r11.drawARGB(0, 0, 0, 0);
        r11.clipRect(r14, r15, r5 - r12, r10 - r13);
        r11.drawARGB(0, 0, 0, 0);
        Paint r16 = new Paint(1);
        float r17 = r14;
        float r18 = r15;
        float r19 = (r5 - r14) - r12;
        float r20 = (r10 - r15) - r13;
        float r21 = r36.getWidth();
        float r22 = r36.getHeight();
        int r23 = (int) r21;
        int r110 = (int) r22;
        String[] r111 = this.f20287l;
        if (r111 != null) goto L10;
    L11:
        Canvas r112 = r11;
        float[] r24 = null;
    L29:
        float r113 = r24[3];
        float r25 = this.f20288m;
        Rect r26 = new Rect(0, 0, (int) (r113 * r25), (int) (r24[0] * r25));
        Rect r114 = new Rect(r26.right, r26.top, (int) (r21 - (r24[1] * r25)), r26.bottom);
        Rect r27 = new Rect(r114.right, r26.top, r23, r26.bottom);
        Rect r28 = new Rect(r26.left, r26.bottom, r26.right, (int) (r22 - (r24[2] * r25)));
        Rect r29 = new Rect(r28.right, r28.top, r114.right, r28.bottom);
        Rect r115 = new Rect(r29.right, r28.top, r27.right, r28.bottom);
        Rect r30 = new Rect(r28.left, r28.bottom, r28.right, r110);
        Rect r116 = new Rect(r30.right, r30.top, r29.right, r30.bottom);
        Rect r31 = new Rect(r116.right, r30.top, r115.right, r30.bottom);
        Rect r117 = new Rect();
        Rect r118 = new Rect();
        Rect r119 = new Rect();
        Rect r120 = new Rect();
        Rect r32 = new Rect();
        Rect r33 = new Rect();
        Rect r121 = new Rect();
        Rect r34 = new Rect();
        Rect r37 = new Rect();
        float r38 = r19 / r21;
        float r39 = r20 / r22;
        ScalingUtils.ScaleType r40 = ScalingUtils.ScaleType.f7895c;
        ScalingUtils.ScaleType r41 = this.f20285j;
        if (r41 != r40) goto L35;
        if (r38 > r39) goto L39;
    L38:
        float r42 = r22 * r38;
        r18 = androidx.constraintlayout.motion.widget.a.a(r20, r42, 2.0f, r18);
        r20 = r42;
        float r43 = r17;
    L43:
        int r44 = (int) r43;
        r117.left = r44;
        int r45 = (int) r18;
        r117.top = r45;
        r117.right = (int) (com.lynx.tasm.utils.g.a(r24[3], 0.0f) + r43);
        r117.bottom = (int) (com.lynx.tasm.utils.g.a(r24[0], 0.0f) + r18);
        r118.left = r117.right;
        r118.top = r117.top;
        int r46 = (int) ((r43 + r19) - com.lynx.tasm.utils.g.a(r24[1], 0.0f));
        r118.right = r46;
        r118.bottom = r117.bottom;
        r119.left = r46;
        r119.top = r117.top;
        r119.right = r44 + ((int) r19);
        r119.bottom = r117.bottom;
        r120.left = r117.left;
        r120.top = r117.bottom;
        r120.right = r117.right;
        int r47 = (int) ((r18 + r20) - ((int) com.lynx.tasm.utils.g.a(r24[2], 0.0f)));
        r120.bottom = r47;
        r32.left = r120.right;
        r32.top = r120.top;
        int r48 = r118.right;
        r32.right = r48;
        r32.bottom = r47;
        r33.left = r48;
        r33.top = r119.bottom;
        r33.right = r119.right;
        r33.bottom = r120.bottom;
        r121.left = r117.left;
        r121.top = r120.bottom;
        int r49 = r120.right;
        r121.right = r49;
        int r50 = r45 + ((int) r20);
        r121.bottom = r50;
        r34.left = r49;
        r34.top = r32.bottom;
        int r51 = r32.right;
        r34.right = r51;
        r34.bottom = r50;
        r37.left = r51;
        r37.top = r33.bottom;
        r37.right = r33.right;
        r37.bottom = r50;
        Canvas r52 = r112;
        r52.drawBitmap(r36, r26, r117, r16);
        r52.drawBitmap(r36, r114, r118, r16);
        r52.drawBitmap(r36, r27, r119, r16);
        r52.drawBitmap(r36, r28, r120, r16);
        r52.drawBitmap(r36, r29, r32, r16);
        r52.drawBitmap(r36, r115, r33, r16);
        r52.drawBitmap(r36, r30, r121, r16);
        r52.drawBitmap(r36, r116, r34, r16);
        r52.drawBitmap(r36, r31, r37, r16);
        return;
    L39:
        float r53 = r21 * r39;
        r43 = androidx.constraintlayout.motion.widget.a.a(r19, r53, 2.0f, r17);
        r19 = r53;
        goto L43
    L35:
        if (r41 == ScalingUtils.ScaleType.g) goto L37;
        r43 = r17;
        if (r41 != ScalingUtils.ScaleType.e) goto L43;
        float r54 = com.lynx.tasm.utils.g.a(1.0f, 0.0f);
        float r55 = r21 * r54;
        float r56 = r22 * r54;
        r43 = Math.round((r19 - r55) * 0.5f);
        r18 = Math.round((r20 - r56) * 0.5f);
        r19 = r55;
        r20 = r56;
        goto L43
    L37:
        if (r38 <= r39) goto L39;
    L10:
        if (r111.length > 4) goto L11;
        r24 = new float[4];
        r24[0] = 0.0f;
        r24[1] = 0.0f;
        r24[2] = 0.0f;
        r24[3] = 0.0f;
        int r122 = 0;
    L14:
        if (r122 >= r111.length) goto L27;
        if (r111[r122].endsWith("px") == false) goto L18;
        String r57 = r111[r122];
        Canvas r123 = r11;
        r24[r122] = Float.parseFloat(r57.substring(0, r57.length() - 2));
    L26:
        r122 = r122 + 1;
        r11 = r123;
        goto L14
    L18:
        r123 = r11;
        if (r111[r122].endsWith("%") == false) goto L26;
        if (r122 == 0) goto L25;
        if (r122 == 2) goto L25;
        String r58 = r111[r122];
        r24[r122] = Float.parseFloat(r58.substring(0, r58.length() - 2)) * r23;
    L25:
        String r59 = r111[r122];
        r24[r122] = Float.parseFloat(r59.substring(0, r59.length() - 2)) * r110;
        goto L26
    L27:
        r112 = r11;
        goto L29
    L51:
        return;
    }
}
