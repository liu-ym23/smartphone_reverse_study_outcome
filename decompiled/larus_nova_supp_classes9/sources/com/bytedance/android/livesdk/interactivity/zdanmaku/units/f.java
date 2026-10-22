package com.bytedance.android.livesdk.interactivity.zdanmaku.units;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.l;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.zdanmaku.j;
import com.facebook.drawee.generic.RootDrawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> extends tk6.b<T> implements com.bytedance.live.zdanmaku.render.canvas.c {
    public final RectF g;
    public final LinearGradient h;
    public final Matrix i;
    public float j;
    public final Paint k;
    public View l;
    public boolean m;
    public final LottieDrawable n;
    public RootDrawable o;
    public RootDrawable p;
    public final int q;
    public int r;
    public final int s;
    public final int t;
    public final boolean u;

    public final void f() {
        Canvas r0 = ((tk6.b) this).f;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.m == true) goto L9;
        MainThreadPostUtils.b(new e(this));
        this.m = true;
    L9:
        float r1 = c().c.b;
        of6.a r2 = ((of6.c) this).c;
        if (r2 == null) goto L14;
        com.bytedance.live.artist.render.f r4 = ((com.bytedance.live.artist.render.e) r2).b;
        if (r4 == null) goto L14;
        float r5 = r4.b;
    L15:
        if (r2 == null) goto L19;
        com.bytedance.live.artist.render.f r3 = ((com.bytedance.live.artist.render.e) r2).b;
        if (r3 == null) goto L19;
        float r6 = r3.a;
    L20:
        this.j = 1.5f * r5;
        float r7 = c().d.a;
        float r8 = c().d.b;
        this.k.setShader(this.h);
        this.i.reset();
        this.i.setTranslate(r7 - this.j, r8);
        Matrix r9 = this.i;
        float r10 = this.j;
        r9.postScale((2 * r10) + r6, r5, r7 - r10, r8);
        this.h.setLocalMatrix(this.i);
        RectF r11 = this.g;
        float r13 = this.j;
        r11.left = r7 - r13;
        r11.right = (r7 + r6) + r13;
        r11.top = r8;
        r11.bottom = r8 + r5;
        float r14 = (r1 - r5) * 0.5f;
        r0.save();
        r0.translate(0.0f, r14);
        r0.drawRoundRect(this.g, r5, r5, this.k);
        super/*of6.c*/.f();
        r0.restore();
        r0.save();
        float r15 = r8 + r14;
        double r16 = r15;
        r0.translate(c().d.a + this.s, (float) ((((double) (r5 - this.q)) * 0.5d) + r16));
        RootDrawable r17 = this.o;
        if (r17 == null) goto L23;
        r17.draw(r0);
    L23:
        r0.restore();
        RootDrawable r18 = this.p;
        if (r18 == null) goto L27;
        r0.save();
        r0.translate(((c().d.a + this.s) + this.r) + this.t, (float) (r16 + (((double) (r5 - this.q)) * 0.5d)));
        r18.draw(r0);
        r0.restore();
    L27:
        if (this.u == false) goto L30;
        r0.save();
        r0.translate(c().d.a, r15);
        r0.scale(0.5f, 0.5f);
        this.n.setAlpha(255);
        this.n.draw(r0);
        r0.restore();
        return;
    L30:
        return;
    L19:
        r6 = 0.0f;
    L14:
        r5 = 0.0f;
        goto L15
    }

    public final void d() {
        super/*of6.c*/.d();
        this.l = null;
        MainThreadPostUtils.b(new d(this));
        this.m = false;
    }

    public final void e() {
        super/*of6.c*/.e();
        RootDrawable r1 = null;
        if (this.u == false) goto L16;
        View r0 = this.l;
        if (r0 == null) goto L15;
        Context r2 = r0.getContext();
        if (r2 == null) goto L62;
        l r3 = LottieCompositionFactory.fromAssetSync(r2, "supreme/data.json");
        if (r3 == null) goto L12;
        LottieComposition r4 = (LottieComposition) r3.a;
    L13:
        if (r4 == null) goto L16;
        this.n.m(r4);
        LottieDrawable r5 = this.n;
        r5.j = "supreme/images";
        r5.w(-1);
        this.n.setCallback(this.l);
        this.n.e("image_0");
        goto L16
    L12:
        r4 = null;
        goto L13
    L62:
        return;
    L15:
        return;
    L16:
        Object r6 = ((of6.c) this).d;
        if ((r6 instanceof j) == true) goto L19;
        r6 = null;
    L19:
        j r7 = (j) r6;
        boolean r8 = true;
        if (r7 == null) goto L39;
        s3 r9 = r7.a;
        if (r9 == null) goto L39;
        if (r9.getBadgeDrawable() == null) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == true) goto L30;
        r9 = null;
    L30:
        if (r9 == null) goto L39;
        Drawable r11 = r9.getBadgeDrawable();
        if ((r11 instanceof RootDrawable) == true) goto L34;
        r11 = null;
    L34:
        RootDrawable r13 = (RootDrawable) r11;
        if (r13 == null) goto L37;
        r13.setBounds(0, 0, r9.getBadgeWidth(), r9.getBadgeHeight());
        this.r = r9.getBadgeWidth();
        r13.setCallback(this.l);
        Unit r14 = Unit.INSTANCE;
    L38:
        this.o = r13;
        goto L39
    L37:
        r13 = null;
        goto L38
    L26:
        r10 = false;
    L39:
        Object r15 = ((of6.c) this).d;
        if ((r15 instanceof j) == true) goto L42;
        r15 = null;
    L42:
        j r16 = (j) r15;
        if (r16 == null) goto L63;
        s3 r17 = r16.a;
        if (r17 != null) goto L47;
        return;
    L47:
        if (r17.getRecentBadgeDrawable() != null) goto L50;
        r8 = false;
    L50:
        if (r8 == true) goto L53;
        r17 = null;
    L53:
        if (r17 == null) goto L65;
        Drawable r18 = r17.getRecentBadgeDrawable();
        if ((r18 instanceof RootDrawable) == true) goto L57;
        r18 = null;
    L57:
        RootDrawable r19 = (RootDrawable) r18;
        if (r19 == null) goto L60;
        r19.setBounds(0, 0, r17.getRecentBadgeWidth(), r17.getRecentBadgeHeight());
        r19.setCallback(this.l);
        Unit r20 = Unit.INSTANCE;
        r1 = r19;
    L60:
        this.p = r1;
        return;
    L65:
        return;
    }

    public final void a(View r1) {
        this.l = r1;
    }

    public f(Object r9, tk6.e r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "template");
        super(r9, r10);
        this.u = r11;
        this.g = new RectF();
        this.h = new LinearGradient(0.0f, 1.0f, 1.0f, 1.0f, new int[]{0, -1, -1, 0}, new float[]{0.0f, 0.1f, 0.9f, 1.0f}, Shader.TileMode.CLAMP);
        this.i = new Matrix();
        Paint r13 = new Paint(1);
        r13.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Unit r14 = Unit.INSTANCE;
        this.k = r13;
        this.n = new LottieDrawable();
        this.q = s1.f(16.0f);
        this.r = s1.f(32.0f);
        this.s = s1.f(4.0f);
        this.t = s1.f(2.0f);
    }
}
