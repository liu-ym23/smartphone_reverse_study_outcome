package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class UserEnterLevelView extends FrameLayout implements e {
    public BaseEnterView a;
    public Bitmap b;
    public float c;
    public Matrix d;
    public Shader e;
    public RectF f;
    public Shader g;
    public Shader h;
    public ComposeShader i;
    public Bitmap j;
    public Canvas k;
    public Matrix l;
    public float m;
    public Matrix n;
    public Paint o;
    public Paint p;
    public Paint q;
    public float r;
    public float s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;

    public final void c() {
        if (this.w != 2) goto L9;
        float r1 = this.r;
        float r7 = this.s;
        if (this.u == true) goto L16;
        this.u = true;
        this.d = new Matrix();
        this.c = (-r1) * 3.0f;
        int r8 = getResources().getColor(2131108469);
        this.f = new RectF(0.0f, 0.0f, r1, r7);
        float r15 = r1 * 4.0f;
        LinearGradient r10 = new LinearGradient(0.0f, 0.0f, r15, 0.0f, ColorUtils.setAlphaComponent(r8, 180), ColorUtils.setAlphaComponent(r8, 180), Shader.TileMode.CLAMP);
        Bitmap r5 = Bitmap.createBitmap((int) r15, (int) r7, Bitmap.Config.ARGB_8888);
        Canvas r9 = new Canvas(r5);
        Shader.TileMode r13 = Shader.TileMode.CLAMP;
        this.e = new BitmapShader(r5, r13, r13);
        float r6 = r1 / 4.0f;
        float r11 = r7 / 4.0f;
        float r14 = getResources().getDimension(2131169199);
        float r16 = getResources().getDimension(2131169198);
        float r17 = r6 * 2.0f;
        float r2 = r11 * 2.0f;
        float r4 = r17 + r14;
        float r18 = r6 * 1.0f;
        float r19 = r11 * 3.0f;
        float r20 = 0.0f * r6;
        float r110 = r20 + r14;
        float r21 = r6 * 3.0f;
        float r23 = r11 * 1.0f;
        float r111 = r14 + r21;
        float r112 = 2.0f * r1;
        float r3 = r1 * 3.0f;
        r9.drawPaint(this.q);
        this.p.setShader(r10);
        this.p.setStrokeWidth(r16);
        r9.drawLines(new float[]{r17, r2, r4, r2, r18, r19, r18 + r14, r19, r20 + r1, r2, r110 + r1, r2, r17 + r1, r19, r4 + r1, r19, r21 + r1, r23, r111 + r1, r23, r20 + r112, r19, r110 + r112, r19, r21 + r112, r23, r112 + r111, r23, r20 + r3, r19, r110 + r3, r19, r21 + r3, r23, r111 + r3, r23}, this.p);
        this.e.setLocalMatrix(this.n);
    L16:
        invalidate();
        return;
    L9:
        if (this.v == true) goto L16;
        this.v = true;
        int r113 = getResources().getColor(2131108466);
        int r24 = getResources().getColor(2131108468);
        int r25 = getResources().getColor(2131108467);
        this.l = new Matrix();
        this.m = 0.0f;
        this.f = new RectF(0.0f, 0.0f, this.r, this.s);
        this.g = new LinearGradient(0.0f, 0.0f, this.r, this.s, r113, r113, Shader.TileMode.CLAMP);
        this.h = new LinearGradient(0.0f, 0.0f, 30.0f, 7.0f, new int[]{r25, r24, r25}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.i = new ComposeShader(this.g, this.h, PorterDuff.Mode.DST_ATOP);
        int r26 = (int) this.s;
        int r27 = (int) this.r;
        if (r26 <= 0) goto L15;
        if (r27 <= 0) goto L15;
        this.j = Bitmap.createBitmap(r27, r26, Bitmap.Config.ARGB_8888);
        this.k = new Canvas(this.j);
    L15:
        this.g.setLocalMatrix(this.n);
        this.h.setLocalMatrix(this.n);
        this.i.setLocalMatrix(this.n);
        goto L16
    }

    public UserEnterLevelView(Context r2) {
        this(r2, null);
    }

    public final void a(Canvas r6) {
        Canvas r0 = this.k;
        if (r0 == null) goto L16;
        r0.drawPaint(this.q);
        float r1 = this.m + 30.0f;
        this.m = r1;
        this.l.setTranslate(r1, 0.0f);
        this.h.setLocalMatrix(this.l);
        ComposeShader r2 = new ComposeShader(this.g, this.h, PorterDuff.Mode.DST_ATOP);
        this.i = r2;
        r2.setLocalMatrix(this.n);
        this.o.setShader(this.i);
        this.k.drawRoundRect(this.f, 10.0f, 10.0f, this.o);
        this.o.setAlpha(128);
        Bitmap r3 = this.j;
        if (r3 == null) goto L7;
        r6.drawBitmap(r3, 0.0f, 0.0f, this.o);
    L7:
        float r7 = this.m;
        float r4 = this.r;
        if (r7 < (r4 * 1.5f)) goto L11;
        this.v = false;
        this.m = (-r4) / 2.0f;
    L11:
        if (this.v == true) goto L13;
        return;
    L13:
        if (this.m > (r4 * 1.5f)) goto L18;
        postInvalidateDelayed(20);
        return;
    L18:
        return;
    }

    public final void b(Canvas r4) {
        float r0 = this.c + 60.0f;
        this.c = r0;
        this.d.setTranslate(r0, 0.0f);
        this.e.setLocalMatrix(this.d);
        this.o.setAlpha(240);
        this.o.setShader(this.e);
        r4.drawRoundRect(this.f, 10.0f, 10.0f, this.o);
        float r5 = this.c;
        float r1 = this.r;
        if (r5 < (r1 * 4.0f)) goto L6;
        this.u = false;
        this.c = -r1;
    L6:
        if (this.u == true) goto L8;
        return;
    L8:
        if (this.c > (r1 * 4.0f)) goto L12;
        postInvalidateDelayed(20);
        return;
    }

    public final void e(BaseEnterView r1) {
        this.b = BitmapTranslateUtils.a(r1);
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        super.onDraw(r4);
        if (this.t == false) goto L5;
        return;
    L5:
        if (this.y == false) goto L22;
        this.o.reset();
        r4.drawBitmap(this.b, 0.0f, 0.0f, this.o);
        if (this.x == true) goto L19;
        return;
    L19:
        if (this.u == false) goto L14;
        b(r4);     // Catch: Exception -> L17
    L18:
        return;
    L14:
        if (this.v == false) goto L18;
        a(r4);     // Catch: Exception -> L17
    L23:
        return;
    }

    public void setEnableBitmap(boolean r1) {
        this.y = r1;
    }

    public void setEnableShader(boolean r1) {
        this.x = r1;
    }

    public void setUI(k32.a r2) {
        this.w = r2.h;
        this.a.setUI(r2);
        this.b = BitmapTranslateUtils.a(this.a);
        this.r = this.a.getWidth();
        this.s = this.a.getHeight();
        invalidate();
    }

    public UserEnterLevelView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.r = this.a.getWidth();
        float r3 = this.a.getHeight();
        this.s = r3;
        setMeasuredDimension((int) this.r, (int) r3);
    }

    public UserEnterLevelView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.t = false;
        this.u = false;
        this.v = false;
        this.x = true;
        this.y = true;
        BaseEnterView r0 = new BaseEnterView(r2);
        this.a = r0;
        r0.setDrawingCacheListener(this);
        this.b = BitmapTranslateUtils.a(this.a);
        Paint r5 = new Paint();
        this.o = r5;
        r5.setAntiAlias(true);
        Paint r6 = new Paint();
        this.p = r6;
        r6.setAntiAlias(true);
        Paint r7 = new Paint();
        this.q = r7;
        r7.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Matrix r8 = new Matrix();
        this.n = r8;
        r8.setTranslate(1.0f, 0.0f);
        setWillNotDraw(false);
    }

    public final void d(k32.a r3, int r4, CharSequence r5) {
        if (r3 == null) goto L41;
        BaseEnterView r0 = this.a;
        if (r0 == null) goto L42;
        this.w = r3.h;
        View r1 = r0.f;
        if (r1 == null) goto L39;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L12;
        r2.height = r4;
    L12:
        View r6 = r0.f;
        if (r6 == null) goto L15;
        r6.setLayoutParams(r2);
    L15:
        View r7 = r0.f;
        if (r7 == null) goto L18;
        r7.setBackgroundResource(2131249077);
    L18:
        ImageView r8 = r0.e;
        if (r8 == null) goto L22;
        r8.setVisibility(8);
    L22:
        if (TextUtils.isEmpty(r5) == true) goto L26;
        TextView r9 = r0.d;
        if (r9 == null) goto L29;
        r9.setText(r5);
    L29:
        TextView r10 = r0.c;
        if (r10 == null) goto L32;
        r10.setText(r3.b);
    L32:
        TextView r11 = r0.c;
        if (r11 == null) goto L35;
        r11.setTextColor(r0.getResources().getColor(2131107376));
    L35:
        TextView r13 = r0.d;
        if (r13 == null) goto L38;
        r13.setTextColor(r0.getResources().getColor(2131107376));
    L38:
        ImageLoader.loadBitmapSynchronized(r3.g, 0, 0, new b(r0));
        goto L39
    L26:
        TextView r14 = r0.d;
        if (r14 == null) goto L29;
        r14.setText(2131916479);
    L39:
        this.b = BitmapTranslateUtils.a(this.a);
        this.r = this.a.getWidth();
        this.s = this.a.getHeight();
        invalidate();
        return;
    L42:
        return;
    }
}
