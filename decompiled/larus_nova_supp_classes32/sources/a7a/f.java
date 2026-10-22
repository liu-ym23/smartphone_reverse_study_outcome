package a7a;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends b {
    public final double h;
    public final int i;
    public boolean j;

    public f(ReadableArray r5) {
        this.j = false;
        if (r5 != null) goto L7;
        LLog.e("LinearGradient", "native parse error array is null");
        return;
    L7:
        if (r5.size() >= 3) goto L10;
        LLog.e("LinearGradient", "native parse error, array.size must be 4  ");
        return;
    L10:
        this.h = r5.getDouble(0);
        k(r5.getArray(1), r5.getArray(2));
        if (r5.size() != 4) goto L13;
        int r6 = r5.getInt(3);
    L14:
        this.i = r6;
        return;
    L13:
        r6 = 9;
        goto L14
    }

    @Override // a7a.d
    public final void i(boolean r1) {
        this.j = r1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect r15) {
        this.c = Math.max(r15.width(), 1);
        this.d = Math.max(r15.height(), 1);
        int r1 = r15.left;
        int r3 = r15.top;
        int[] r4 = this.f;
        if (r4 != null) goto L5;
    L61:
        this.b = null;
    L62:
        super.setBounds(r15);
        return;
    L5:
        if (r4.length < 2) goto L61;
        float[] r6 = this.g;
        if (r6 != null) goto L10;
    L12:
        PointF r9 = new PointF();
        PointF r10 = new PointF();
        int r5 = this.c;     // Catch: Exception -> L59
        int r11 = this.d;     // Catch: Exception -> L59
        float r7 = ((r5 * 2.0f) * r11) / ((r5 * r5) + (r11 * r11));     // Catch: Exception -> L59
        int r12 = this.i;     // Catch: Exception -> L59
        if (r12 != 1) goto L16;
        float r2 = r1;
        r9.x = r2;     // Catch: Exception -> L59
        r9.y = r11 + r3;     // Catch: Exception -> L59
        r10.x = r2;     // Catch: Exception -> L59
        r10.y = r3;     // Catch: Exception -> L59
    L53:
        if (Build.VERSION.SDK_INT < 28) goto L55;
    L57:
        this.b = new LinearGradient(r9.x, r9.y, r10.x, r10.y, this.f, this.g, Shader.TileMode.CLAMP);     // Catch: Exception -> L59
        goto L62
    L55:
        if (this.j == false) goto L57;
        TraceEvent.beginSection("createBitmapShader");     // Catch: Exception -> L59
        l(r9, r10, this.f, this.g, (float) this.h);     // Catch: Exception -> L59
        TraceEvent.endSection("createBitmapShader");     // Catch: Exception -> L59
        goto L62
    L16:
        if (r12 != 2) goto L19;
        float r8 = r1;
        r9.x = r8;     // Catch: Exception -> L59
        r9.y = r3;     // Catch: Exception -> L59
        r10.x = r8;     // Catch: Exception -> L59
        r10.y = r3 + r11;     // Catch: Exception -> L59
        goto L53
    L19:
        if (r12 != 3) goto L22;
        r9.x = r5 + r1;     // Catch: Exception -> L59
        float r13 = r3;
        r9.y = r13;     // Catch: Exception -> L59
        r10.x = r1;     // Catch: Exception -> L59
        r10.y = r13;     // Catch: Exception -> L59
        goto L53
    L22:
        if (r12 != 4) goto L25;
        r9.x = r1;     // Catch: Exception -> L59
        float r14 = r3;
        r9.y = r14;     // Catch: Exception -> L59
        r10.x = r1 + r5;     // Catch: Exception -> L59
        r10.y = r14;     // Catch: Exception -> L59
        goto L53
    L25:
        if (r12 != 5) goto L28;
        r9.x = (r1 + r5) - (r11 * r7);     // Catch: Exception -> L59
        float r16 = r3;
        r9.y = (r5 * r7) + r16;     // Catch: Exception -> L59
        r10.x = r1 + r5;     // Catch: Exception -> L59
        r10.y = r16;     // Catch: Exception -> L59
        goto L53
    L28:
        if (r12 != 6) goto L31;
        float r17 = r1;
        r9.x = (r11 * r7) + r17;     // Catch: Exception -> L59
        float r18 = r3;
        r9.y = (r5 * r7) + r18;     // Catch: Exception -> L59
        r10.x = r17;     // Catch: Exception -> L59
        r10.y = r18;     // Catch: Exception -> L59
        goto L53
    L31:
        if (r12 != 7) goto L34;
        float r19 = r1;
        r9.x = r19;     // Catch: Exception -> L59
        float r20 = r3;
        r9.y = r20;     // Catch: Exception -> L59
        r10.x = r19 + (r11 * r7);     // Catch: Exception -> L59
        r10.y = r20 + (r5 * r7);     // Catch: Exception -> L59
        goto L53
    L34:
        if (r12 != 8) goto L36;
        r9.x = r1 + r5;     // Catch: Exception -> L59
        float r21 = r3;
        r9.y = r21;     // Catch: Exception -> L59
        r10.x = (r1 + r5) - (r11 * r7);     // Catch: Exception -> L59
        r10.y = r21 + (r5 * r7);     // Catch: Exception -> L59
        goto L53
    L36:
        PointF r22 = new PointF(this.c / 2.0f, this.d / 2.0f);     // Catch: Exception -> L59
        double r23 = Math.toRadians(this.h);     // Catch: Exception -> L59
        float r24 = (float) Math.sin(r23);     // Catch: Exception -> L59
        float r110 = (float) Math.cos(r23);     // Catch: Exception -> L59
        float r25 = (float) Math.tan(r23);     // Catch: Exception -> L59
        if (r24 >= 0.0f) goto L39;
    L41:
        if (r24 < 0.0f) goto L46;
        if (r110 >= 0.0f) goto L46;
        PointF r111 = new PointF(this.c, this.d);     // Catch: Exception -> L59
    L51:
        float r26 = r1;
        float r27 = r3;
        r9.offset(r26, r27);     // Catch: Exception -> L59
        r10.offset(r26, r27);     // Catch: Exception -> L59
        r22.offset(r26, r27);     // Catch: Exception -> L59
        r111.offset(r26, r27);     // Catch: Exception -> L59
        float r28 = r22.y;     // Catch: Exception -> L59
        float r29 = r28 - r111.y;     // Catch: Exception -> L59
        float r30 = r22.x;     // Catch: Exception -> L59
        float r31 = (r29 - (r25 * r30)) + (r111.x * r25);     // Catch: Exception -> L59
        float r32 = r30 + ((r24 * r31) / ((r24 * r25) + r110));     // Catch: Exception -> L59
        r10.x = r32;     // Catch: Exception -> L59
        float r33 = r28 - (r31 / ((r25 * r25) + 1.0f));     // Catch: Exception -> L59
        r10.y = r33;     // Catch: Exception -> L59
        r9.x = (r22.x * 2.0f) - r32;     // Catch: Exception -> L59
        r9.y = (r22.y * 2.0f) - r33;     // Catch: Exception -> L59
    L46:
        if (r24 < 0.0f) goto L48;
    L50:
        r111 = new PointF(0.0f, 0.0f);     // Catch: Exception -> L59
        goto L51
    L48:
        if (r110 >= 0.0f) goto L50;
        r111 = new PointF(0.0f, this.d);     // Catch: Exception -> L59
        goto L51
    L39:
        if (r110 < 0.0f) goto L41;
        r111 = new PointF(this.c, 0.0f);     // Catch: Exception -> L59
    L59:
        e = move-exception;
        this.b = null;
        this.e.setColor(this.f[0]);
        e.printStackTrace();
        LLog.w("BackgroundLinearGradientLayer", "exception:\n" + e);
        goto L62
    L10:
        if (r6.length == r4.length) goto L12;
        this.b = null;
        goto L62
    }

    public static void m(int[] r23, float[] r24, int r25, int[] r26) {
        int r1 = 0;
        int r2 = r23[0];
        float r3 = ((r2 >> 24) & 255) / 255.0f;
        float r5 = ((r2 >> 16) & 255) / 255.0f;
        float r6 = ((r2 >> 8) & 255) / 255.0f;
        float r4 = (r2 & 255) / 255.0f;
        int r7 = 1;
        int r8 = r23[1];
        float r9 = ((r8 >> 24) & 255) / 255.0f;
        float r10 = ((r8 >> 16) & 255) / 255.0f;
        float r11 = ((r8 >> 8) & 255) / 255.0f;
        float r12 = (r8 & 255) / 255.0f;
        float r13 = r24[0];
        float r14 = r24[1] - r13;
    L3:
        if (r1 >= r25) goto L8;
        float r15 = r1 / (r25 - 1.0f);
        float r16 = r24[r7];
        if (r15 <= r16) goto L7;
        r7 = r7 + 1;
        int r17 = r23[r7];
        float r18 = ((r17 >> 24) & 255) / 255.0f;
        float r19 = ((r17 >> 16) & 255) / 255.0f;
        float r20 = ((r17 >> 8) & 255) / 255.0f;
        r14 = r24[r7] - r16;
        r13 = r16;
        float r110 = r12;
        r12 = (r17 & 255) / 255.0f;
        r4 = r110;
        float r21 = r9;
        r9 = r18;
        r3 = r21;
        float r22 = r10;
        r10 = r19;
        r5 = r22;
        float r27 = r11;
        r11 = r20;
        r6 = r27;
    L7:
        float r111 = (r15 - r13) / r14;
        float r112 = 1.0f - r111;
        int r0 = ((int) (((r6 * r112) + (r11 * r111)) * 255.0f)) << 8;
        int r28 = r0 | ((((int) (((r112 * r3) + (r111 * r9)) * 255.0f)) << 24) | (((int) (((r5 * r112) + (r10 * r111)) * 255.0f)) << 16));
        r26[r1] = r28 | ((int) (((r4 * r112) + (r12 * r111)) * 255.0f));
        r1 = r1 + 1;
        r4 = r4;
        goto L3
    }

    public final void l(PointF r17, PointF r18, int[] r19, float[] r20, float r21) {
        int r2 = (int) PointF.length(r18.x - r17.x, r18.y - r17.y);
        if (r2 > 0) goto L6;
        this.b = null;
        return;
    L6:
        int[] r4 = new int[r2];
        if (r20 != null) goto L17;
        float[] r9 = new float[r19.length];
        if (r19.length != 2) goto L12;
        r9[0] = 0.0f;
        r9[1] = 1.0f;
    L19:
        if (r9[0] == 0.0f) goto L21;
        int r10 = 1;
    L23:
        if (r9[r9.length - 1] == 1.0f) goto L25;
        int r11 = 1;
    L26:
        int r12 = (r9.length + r10) + r11;
        if (r12 == r9.length) goto L35;
        int[] r13 = new int[r12];
        float[] r14 = new float[r12];
        if (r10 == 0) goto L31;
        r13[0] = r19[0];
        r14[0] = 0.0f;
    L31:
        System.arraycopy(r19, 0, r13, r10, r19.length);
        System.arraycopy(r9, 0, r14, r10, r9.length);
        if (r11 == 0) goto L34;
        int r15 = r12 - 1;
        r13[r15] = r19[r19.length - 1];
        r14[r15] = 1.0f;
    L34:
        m(r13, r14, r2, r4);
    L36:
        this.b = new BitmapShader(Bitmap.createBitmap(r4, r2, 1, Bitmap.Config.ARGB_8888), Shader.TileMode.CLAMP, Shader.TileMode.REPEAT);
        Matrix r3 = new Matrix();
        r3.postRotate(r21 + 270.0f);
        r3.postTranslate(r17.x, r17.y);
        this.b.setLocalMatrix(r3);
        return;
    L35:
        m(r19, r9, r2, r4);
        goto L36
    L25:
        r11 = 0;
        goto L26
    L21:
        r10 = 0;
        goto L23
    L12:
        if (r19.length <= 2) goto L19;
        int r16 = 0;
    L15:
        if (r16 >= r19.length) goto L19;
        r9[r16] = r16 / (r19.length - 1);
        r16 = r16 + 1;
        goto L15
    L17:
        r9 = r20;
        goto L19
    }
}
