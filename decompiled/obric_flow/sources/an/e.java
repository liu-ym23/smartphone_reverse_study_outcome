package an;

import android.graphics.LinearGradient;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Shader;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final double f329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f330i;

    public e(ReadableArray r10) {
        if (r10 != null) goto L7;
        LynxLog.b(4, "LinearGradient", "native parse error array is null");
        return;
    L7:
        if (r10.size() >= 3) goto L10;
        LynxLog.b(4, "LinearGradient", "native parse error, array.size must be 4  ");
        return;
    L10:
        this.f329h = r10.getDouble(0);
        j(r10.getArray(1), r10.getArray(2));
        if (r10.size() != 4) goto L13;
        int r11 = r10.getInt(3);
    L14:
        this.f330i = r11;
        return;
    L13:
        r11 = 9;
        goto L14
    }

    @Override // an.c
    public final void d(boolean r5) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect r19) {
        this.f327c = Math.max(r19.width(), 1);
        this.d = Math.max(r19.height(), 1);
        int r5 = r19.left;
        int r10 = r19.top;
        int[] r11 = this.f;
        if (r11 == null) goto L56;
        if (r11.length < 2) goto L56;
        float[] r12 = this.g;
        if (r12 != null) goto L10;
    L12:
        PointF r13 = new PointF();
        PointF r14 = new PointF();
        int r15 = this.f327c;     // Catch: Exception -> L16
        float r16 = r15;
        int r17 = this.d;     // Catch: Exception -> L16
        float r18 = r17;
        float r110 = ((r16 * 2.0f) * r18) / ((r17 * r17) + (r15 * r15));     // Catch: Exception -> L16
        int r20 = this.f330i;     // Catch: Exception -> L16
        if (r20 != 1) goto L18;
        float r21 = r5;
        r13.x = r21;     // Catch: Exception -> L16
        r13.y = r17 + r10;     // Catch: Exception -> L16
        r14.x = r21;     // Catch: Exception -> L16
        r14.y = r10;     // Catch: Exception -> L16
    L53:
        this.f326b = new LinearGradient(r13.x, r13.y, r14.x, r14.y, this.f, this.g, Shader.TileMode.CLAMP);     // Catch: Exception -> L16
    L57:
        super.setBounds(r19);
        return;
    L18:
        if (r20 != 2) goto L20;
        float r22 = r5;
        r13.x = r22;     // Catch: Exception -> L16
        r13.y = r10;     // Catch: Exception -> L16
        r14.x = r22;     // Catch: Exception -> L16
        r14.y = r10 + r17;     // Catch: Exception -> L16
        goto L53
    L20:
        if (r20 != 3) goto L23;
        r13.x = r15 + r5;     // Catch: Exception -> L16
        float r23 = r10;
        r13.y = r23;     // Catch: Exception -> L16
        r14.x = r5;     // Catch: Exception -> L16
        r14.y = r23;     // Catch: Exception -> L16
        goto L53
    L23:
        if (r20 != 4) goto L26;
        r13.x = r5;     // Catch: Exception -> L16
        float r24 = r10;
        r13.y = r24;     // Catch: Exception -> L16
        r14.x = r5 + r15;     // Catch: Exception -> L16
        r14.y = r24;     // Catch: Exception -> L16
        goto L53
    L26:
        if (r20 != 5) goto L29;
        float r25 = r5 + r15;     // Catch: Exception -> L16
        r13.x = r25 - (r18 * r110);     // Catch: Exception -> L16
        float r26 = r10;
        r13.y = (r16 * r110) + r26;     // Catch: Exception -> L16
        r14.x = r25;     // Catch: Exception -> L16
        r14.y = r26;     // Catch: Exception -> L16
        goto L53
    L29:
        if (r20 != 6) goto L32;
        float r27 = r5;
        r13.x = (r18 * r110) + r27;     // Catch: Exception -> L16
        float r28 = r10;
        r13.y = (r16 * r110) + r28;     // Catch: Exception -> L16
        r14.x = r27;     // Catch: Exception -> L16
        r14.y = r28;     // Catch: Exception -> L16
        goto L53
    L32:
        if (r20 != 7) goto L35;
        float r29 = r5;
        r13.x = r29;     // Catch: Exception -> L16
        float r30 = r10;
        r13.y = r30;     // Catch: Exception -> L16
        r14.x = (r18 * r110) + r29;     // Catch: Exception -> L16
        r14.y = (r16 * r110) + r30;     // Catch: Exception -> L16
        goto L53
    L35:
        if (r20 != 8) goto L37;
        float r31 = r5 + r15;     // Catch: Exception -> L16
        r13.x = r31;     // Catch: Exception -> L16
        float r32 = r10;
        r13.y = r32;     // Catch: Exception -> L16
        r14.x = r31 - (r18 * r110);     // Catch: Exception -> L16
        r14.y = (r16 * r110) + r32;     // Catch: Exception -> L16
        goto L53
    L37:
        PointF r33 = new PointF(this.f327c / 2.0f, this.d / 2.0f);     // Catch: Exception -> L16
        double r111 = Math.toRadians(this.f329h);     // Catch: Exception -> L16
        float r34 = (float) Math.sin(r111);     // Catch: Exception -> L16
        float r35 = (float) Math.cos(r111);     // Catch: Exception -> L16
        float r112 = (float) Math.tan(r111);     // Catch: Exception -> L16
        if (r34 >= 0.0f) goto L40;
    L42:
        if (r34 < 0.0f) goto L47;
        if (r35 >= 0.0f) goto L47;
        PointF r113 = new PointF(this.f327c, this.d);     // Catch: Exception -> L16
    L52:
        float r36 = r5;
        float r37 = r10;
        r13.offset(r36, r37);     // Catch: Exception -> L16
        r14.offset(r36, r37);     // Catch: Exception -> L16
        r33.offset(r36, r37);     // Catch: Exception -> L16
        r113.offset(r36, r37);     // Catch: Exception -> L16
        float r38 = r33.y;     // Catch: Exception -> L16
        float r39 = r38 - r113.y;     // Catch: Exception -> L16
        float r114 = r33.x;     // Catch: Exception -> L16
        float r115 = (r113.x * r112) + (r39 - (r112 * r114));     // Catch: Exception -> L16
        float r40 = ((r34 * r115) / ((r34 * r112) + r35)) + r114;     // Catch: Exception -> L16
        r14.x = r40;     // Catch: Exception -> L16
        float r41 = r38 - (r115 / ((r112 * r112) + 1.0f));     // Catch: Exception -> L16
        r14.y = r41;     // Catch: Exception -> L16
        r13.x = (r33.x * 2.0f) - r40;     // Catch: Exception -> L16
        r13.y = (r33.y * 2.0f) - r41;     // Catch: Exception -> L16
    L47:
        if (r34 < 0.0f) goto L49;
    L51:
        r113 = new PointF(0.0f, 0.0f);     // Catch: Exception -> L16
        goto L52
    L49:
        if (r35 >= 0.0f) goto L51;
        r113 = new PointF(0.0f, this.d);     // Catch: Exception -> L16
        goto L52
    L40:
        if (r35 < 0.0f) goto L42;
        r113 = new PointF(this.f327c, 0.0f);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        this.f326b = null;
        this.e.setColor(this.f[0]);
        e.printStackTrace();
        LynxLog.b(3, "BackgroundLinearGradientLayer", "exception:\n" + e);
        goto L57
    L10:
        if (r12.length == r11.length) goto L12;
        this.f326b = null;
    L56:
        this.f326b = null;
        goto L57
    }
}
