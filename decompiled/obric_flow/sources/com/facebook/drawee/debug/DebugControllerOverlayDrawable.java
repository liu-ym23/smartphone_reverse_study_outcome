package com.facebook.drawee.debug;

import ai.j0;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.facebook.drawee.drawable.ScalingUtils;
import io.reactivex.internal.observers.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DebugControllerOverlayDrawable extends Drawable {
    public static final boolean A = false;
    public static final boolean B = false;
    public static final boolean C = false;
    public static final float D = 0.0f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final boolean f7806v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f7807w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final boolean f7808x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final boolean f7809y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final boolean f7810z = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7813c;
    public int d;
    public ScalingUtils.ScaleType e;
    public HashMap f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f7815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f7816j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Matrix f7817k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f7818l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f7819m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7820n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7821o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f7822p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7823q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f7824r;
    public long s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f7825t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f7826u;

    static {
        int r5 = Resources.getSystem().getDisplayMetrics().widthPixels;
        f7806v = true;
        f7807w = true;
        f7808x = true;
        f7809y = true;
        f7810z = true;
        A = true;
        B = true;
        C = true;
        D = 1.0f;
    }

    public DebugControllerOverlayDrawable() {
        this.f = new HashMap();
        this.f7815i = 80;
        this.f7816j = new Paint(1);
        this.f7817k = new Matrix();
        this.f7818l = new Rect();
        this.f7819m = new RectF();
        this.f7826u = -1;
        a();
    }

    public final void a(Canvas r11, String r12, String r13, int r14) {
        String r15 = h.b(r12, ": ");
        float r5 = this.f7816j.measureText(r15);
        float r10 = this.f7816j.measureText(r13);
        this.f7816j.setColor(1711276032);
        int r16 = this.f7823q;
        int r17 = this.f7824r;
        r11.drawRect(r16 - 4, r17 + 8, ((r16 + r5) + r10) + 4.0f, (r17 + this.f7822p) + 8, this.f7816j);
        this.f7816j.setColor(-1);
        r11.drawText(r15, this.f7823q, this.f7824r, this.f7816j);
        this.f7816j.setColor(r14);
        r11.drawText(r13, this.f7823q + r5, this.f7824r, this.f7816j);
        this.f7824r += this.f7822p;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r19) {
        Rect r10 = getBounds();
        this.f7816j.setStyle(Paint.Style.STROKE);
        this.f7816j.setStrokeWidth(2.0f);
        this.f7816j.setColor(-26624);
        r19.drawRect(r10.left, r10.top, r10.right, r10.bottom, this.f7816j);
        Paint r5 = this.f7816j;
        Paint.Style r11 = Paint.Style.FILL;
        r5.setStyle(r11);
        this.f7816j.setColor(0);
        r19.drawRect(r10.left, r10.top, r10.right, r10.bottom, this.f7816j);
        this.f7816j.setStyle(r11);
        this.f7816j.setStrokeWidth(0.0f);
        this.f7816j.setColor(-1);
        this.f7823q = this.f7820n;
        this.f7824r = this.f7821o;
        if (B == false) goto L6;
        a(r19, "ID", this.f7811a, -1);
    L6:
        if (A == false) goto L8;
        int r12 = r10.width();
        int r13 = r10.height();
        Locale r14 = Locale.US;
        a(r19, "D", r12 + "x" + r13, -1);
    L8:
        int r15 = this.f7812b;
        int r16 = this.f7813c;
        ScalingUtils.ScaleType r17 = this.e;
        int r18 = getBounds().width();
        int r20 = getBounds().height();
        if (r18 <= 0) goto L26;
        if (r20 <= 0) goto L26;
        if (r15 <= 0) goto L26;
        if (r16 <= 0) goto L26;
        if (r17 == null) goto L16;
        Rect r21 = this.f7818l;
        r21.top = 0;
        r21.left = 0;
        r21.right = r18;
        r21.bottom = r20;
        this.f7817k.reset();
        r17.a(this.f7817k, this.f7818l, r15, r16, 0.0f, 0.0f);
        RectF r22 = this.f7819m;
        r22.top = 0.0f;
        r22.left = 0.0f;
        r22.right = r15;
        r22.bottom = r16;
        this.f7817k.mapRect(r22);
        int r23 = (int) this.f7819m.width();
        int r24 = (int) this.f7819m.height();
        r18 = Math.min(r18, r23);
        r20 = Math.min(r20, r24);
    L16:
        float r25 = r18;
        float r110 = r25 * 0.1f;
        float r26 = r25 * 0.5f;
        float r111 = r20;
        float r27 = 0.1f * r111;
        float r112 = r111 * 0.5f;
        int r28 = Math.abs(r15 - r18);
        int r29 = Math.abs(r16 - r20);
        float r30 = r28;
        if (r30 >= r110) goto L22;
        if (r29 >= r27) goto L22;
        int r31 = -16711936;
    L28:
        if (f7810z == false) goto L31;
        int r32 = this.f7812b;
        int r33 = this.f7813c;
        Locale r34 = Locale.US;
        a(r19, "I", r32 + "x" + r33, r31);
    L31:
        if (f7809y == false) goto L33;
        int r35 = this.d / 1024;
        Locale r36 = Locale.US;
        a(r19, "I", r35 + " KiB", -1);
    L33:
        int r37 = this.g;
        if (r37 > 0) goto L36;
    L38:
        ScalingUtils.ScaleType r38 = this.e;
        if (r38 != null) goto L41;
    L43:
        long r39 = this.s;
        if (r39 >= 0) goto L46;
    L48:
        String r40 = this.f7825t;
        if (r40 != null) goto L51;
    L53:
        Iterator r41 = this.f.entrySet().iterator();
    L55:
        if (r41.hasNext() == false) goto L57;
        Map.Entry r42 = (Map.Entry) r41.next();
        a(r19, (String) r42.getKey(), (String) r42.getValue(), -1);
        goto L55
    L57:
        return;
    L51:
        if (f7806v == false) goto L53;
        a(r19, "origin", r40, this.f7826u);
        goto L53
    L46:
        if (f7807w == false) goto L48;
        Locale r43 = Locale.US;
        a(r19, "t", r39 + " ms", -1);
        goto L48
    L41:
        if (f7808x == false) goto L43;
        a(r19, "scale", String.valueOf(r38), -1);
        goto L43
    L36:
        if (C == false) goto L38;
        int r44 = this.f7814h;
        Locale r45 = Locale.US;
        a(r19, "anim", j0.f(r37, r44, "f ", ", l "), -1);
    L22:
        if (r30 >= r26) goto L26;
        if (r29 >= r112) goto L26;
        r31 = InputDeviceCompat.SOURCE_ANY;
    L26:
        r31 = SupportMenu.CATEGORY_MASK;
        goto L28
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r10) {
        super.onBoundsChange(r10);
        int r5 = Math.min(40, Math.max(10, Math.min(r10.width() / 8, r10.height() / 9)));
        Paint r11 = this.f7816j;
        float r12 = D;
        r11.setTextSize(r5 * r12);
        int r13 = (int) ((r5 + 8) * r12);
        this.f7822p = r13;
        int r14 = this.f7815i;
        if (r14 != 80) goto L5;
        this.f7822p = r13 * (-1);
    L5:
        this.f7820n = r10.left + 10;
        if (r14 != 80) goto L8;
        int r15 = r10.bottom - 10;
    L9:
        this.f7821o = r15;
        return;
    L8:
        r15 = r10.top + 20;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
    }

    public final void a() {
        this.f7812b = -1;
        this.f7813c = -1;
        this.d = -1;
        this.f = new HashMap();
        this.g = -1;
        this.f7814h = -1;
        this.f7811a = "none";
        invalidateSelf();
        this.s = -1;
        this.f7825t = null;
        this.f7826u = -1;
        invalidateSelf();
    }
}
