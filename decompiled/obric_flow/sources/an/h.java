package an;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.utils.GradientUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f334j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f335k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f336l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f337m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f338n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f339o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f340p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f341q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PointF f342r;

    public h(ReadableArray r10) {
        this.f332h = 0;
        this.f333i = 0;
        this.f334j = 36;
        this.f335k = 36;
        this.f336l = 0.5f;
        this.f337m = 0.5f;
        this.f342r = new PointF(0.5f, 0.5f);
        if (r10 != null) goto L7;
        LynxLog.b(4, "RadialGradient", "native parser error, array is null");
        return;
    L7:
        if (r10.size() == 3) goto L9;
        LynxLog.b(4, "RadialGradient", "native parser error, array.size must be 3");
    L9:
        ReadableArray r5 = r10.getArray(0);
        this.f332h = (int) r5.getLong(0);
        int r11 = (int) r5.getLong(1);
        this.f333i = r11;
        this.f334j = (int) r5.getLong(2);
        this.f336l = (float) r5.getDouble(3);
        this.f335k = (int) r5.getLong(4);
        this.f337m = (float) r5.getDouble(5);
        if (r11 != 4) goto L12;
        this.f338n = (float) r5.getDouble(10);
        this.f339o = r5.getInt(11);
        this.f340p = (float) r5.getDouble(12);
        this.f341q = r5.getInt(13);
    L12:
        j(r10.getArray(1), r10.getArray(2));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect r19) {
        this.f327c = r19.width();
        int r5 = r19.height();
        this.d = r5;
        PointF r10 = this.f342r;
        float r11 = this.f327c;
        int r12 = this.f334j;
        float r13 = this.f336l;
        if (r12 == 11) goto L9;
        switch(r12) {
            case 32: goto L8;
            case 33: goto L7;
            case 34: goto L7;
            case 35: goto L8;
            case 36: goto L6;
            default: goto L5;
        };
    L5:
        float r15 = r13;
    L10:
        r10.x = r15;
        float r14 = r5;
        int r16 = this.f335k;
        float r17 = this.f337m;
        if (r16 == 11) goto L17;
        switch(r16) {
            case 32: goto L16;
            case 33: goto L15;
            case 34: goto L15;
            case 35: goto L16;
            case 36: goto L14;
            default: goto L13;
        };
    L13:
        float r18 = r17;
    L18:
        r10.y = r18;
        int r20 = this.f333i;
        if (r20 != 4) goto L27;
        int r21 = this.f339o;
        float r22 = this.f338n;
        if (r21 != 1) goto L23;
        r22 = r22 * r11;
    L23:
        int r23 = this.f341q;
        float r24 = this.f340p;
        if (r23 != 1) goto L26;
        r24 = r24 * r14;
    L26:
        PointF r25 = new PointF(r22, r24);
    L28:
        int[] r26 = this.f;
        if (r26 != null) goto L31;
    L52:
        this.f326b = null;
    L53:
        super.setBounds(r19);
        return;
    L31:
        if (r26.length < 2) goto L52;
        float[] r27 = this.g;
        if (r27 != null) goto L36;
    L55:
        float r28 = r25.x;     // Catch: Exception -> L44
        if (r28 == 0.0f) goto L46;
        float r29 = r25.y;     // Catch: Exception -> L44
        if (r29 == 0.0f) goto L46;
        float r30 = r28 / r29;     // Catch: Exception -> L44
    L47:
        float r31 = r15;
        this.f326b = new RadialGradient(r15, r18, Math.max(r25.x, 1.0f), this.f, this.g, Shader.TileMode.CLAMP);     // Catch: Exception -> L44
        if (r30 == 1.0f) goto L53;
        Matrix r32 = new Matrix();     // Catch: Exception -> L44
        r32.preScale(1.0f, 1.0f / r30, r31, r18);     // Catch: Exception -> L44
        this.f326b.setLocalMatrix(r32);     // Catch: Exception -> L44
    L46:
        r30 = 1.0f;
    L44:
        e = move-exception;
        this.f326b = null;
        e.printStackTrace();
        LynxLog.b(3, "BackgroundRadialGradientLayer", "exception:\n" + e.toString());
        goto L53
    L36:
        if (r27.length == r26.length) goto L55;
        this.f326b = null;
        goto L53
    L27:
        r25 = GradientUtils.a(this.f332h, r20, r15, r18, r11, r14);
        goto L28
    L14:
        r17 = r14 * 0.5f;
        goto L13
    L15:
        r18 = r14;
        goto L18
    L16:
        r18 = 0.0f;
        goto L18
    L17:
        r17 = (r17 * r14) / 100.0f;
        goto L13
    L6:
        r13 = r11 * 0.5f;
        goto L5
    L7:
        r15 = r11;
        goto L10
    L8:
        r15 = 0.0f;
        goto L10
    L9:
        r13 = (r13 * r11) / 100.0f;
        goto L5
    }
}
