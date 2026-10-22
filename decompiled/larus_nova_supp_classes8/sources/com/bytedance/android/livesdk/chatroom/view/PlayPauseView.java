package com.bytedance.android.livesdk.chatroom.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.live.datacontext.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00015B\u001d\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\"\u0010!\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\fR\"\u0010%\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\"\u0010)\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R*\u0010.\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0010\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/view/PlayPauseView;", "Landroid/view/View;", "Landroid/graphics/Bitmap;", "bitmap", "", "setBgBitmap", "", "g", "Z", "getEnableBitmapBg", "()Z", "setEnableBitmapBg", "(Z)V", "enableBitmapBg", "", "j", "F", "getMSizeRatio", "()F", "setMSizeRatio", "(F)V", "mSizeRatio", "k", "getHeightOffset", "setHeightOffset", "heightOffset", "l", "getWidthOffset", "setWidthOffset", "widthOffset", "m", "getPlayStatus", "setPlayStatus", "playStatus", "n", "getMPauseWidth", "setMPauseWidth", "mPauseWidth", "u", "getMPlayWidth", "setMPlayWidth", "mPlayWidth", "value", "A", "getProgress", "setProgress", "progress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayPauseView extends View {
    public float A;
    public final PaintFlagsDrawFilter a;
    public final Paint b;
    public final Paint c;
    public final Paint d;
    public Animator e;
    public Animator f;
    public boolean g;
    public Bitmap h;
    public final Matrix i;
    public float j;
    public float k;
    public float l;
    public boolean m;
    public float n;
    public final PointF o;
    public final float p;
    public final float q;
    public final float r;
    public final float s;
    public final Path t;
    public float u;
    public final PointF v;
    public final float w;
    public final float x;
    public final float y;
    public final float z;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ PlayPauseView a;

        public b(PlayPauseView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            PlayPauseView r0 = this.a;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            r0.setProgress(((Float) r3).floatValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ PlayPauseView a;

        public c(PlayPauseView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            PlayPauseView r0 = this.a;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            r0.setProgress(((Float) r3).floatValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    public final void e() {
        this.m = true;
        c();
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{50.0f, 100.0f});
        r0.setDuration(350);
        r0.setInterpolator(new DecelerateInterpolator());
        r0.setStartDelay(70);
        r0.addUpdateListener(new c(this));
        Unit r1 = Unit.INSTANCE;
        this.e = r0;
        r0.start();
    }

    public final void c() {
        this.f.removeAllListeners();
        this.e.removeAllListeners();
        this.e.cancel();
        this.f.cancel();
    }

    public final void a() {
        c();
        setProgress(0.0f);
        this.m = true;
    }

    public final void b() {
        MiddlewareRoomContext r0 = o3.b();
        if (r0 == null) goto L10;
        m r1 = r0.getVsInChorusConcert();
        if (r1 == null) goto L10;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L10;
        a();
        return;
    L10:
        c();
        setProgress(50.0f);
        this.m = false;
    }

    public final void d() {
        MiddlewareRoomContext r0 = o3.b();
        if (r0 == null) goto L10;
        m r1 = r0.getVsInChorusConcert();
        if (r1 == null) goto L10;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L10;
        a();
        return;
    L10:
        this.m = false;
        c();
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 50.0f});
        r2.setDuration(350);
        r2.setInterpolator(new AccelerateInterpolator());
        r2.addUpdateListener(new b(this));
        Unit r3 = Unit.INSTANCE;
        this.f = r2;
        r2.start();
    }

    public final boolean getEnableBitmapBg() {
        return this.g;
    }

    public final float getHeightOffset() {
        return this.k;
    }

    public final float getMPauseWidth() {
        return this.n;
    }

    public final float getMPlayWidth() {
        return this.u;
    }

    public final float getMSizeRatio() {
        return this.j;
    }

    public final boolean getPlayStatus() {
        return this.m;
    }

    public final float getProgress() {
        return this.A;
    }

    public final float getWidthOffset() {
        return this.l;
    }

    public PlayPauseView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r22) {
        Intrinsics.checkNotNullParameter(r22, "canvas");
        if (this.g == false) goto L5;
        setLayerType(2, null);
        r22.drawARGB(0, 0, 0, 0);
    L5:
        r22.setDrawFilter(this.a);
        r22.save();
        r22.translate(this.l, this.k);
        float r1 = this.j;
        r22.scale(r1, r1);
        float r2 = this.A;
        float r10 = 25;
        if (r2 > r10) goto L8;
    L10:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L15;
    L23:
        float r4 = this.A;
        if (r4 > r10) goto L26;
    L29:
        boolean r5 = true;
    L31:
        if (r5 == false) goto L34;
    L38:
        r22.restore();
        if (this.g == false) goto L56;
        float r6 = this.A;
        float r7 = 50;
        if (r6 > r7) goto L43;
        float r8 = (r6 / r7) * 90.0f;
    L44:
        Bitmap r9 = this.h;
        if (r9 == null) goto L47;
        int r11 = r9.getWidth();
    L48:
        Bitmap r12 = this.h;
        if (r12 == null) goto L51;
        int r13 = r12.getHeight();
    L52:
        float r14 = r11;
        float r15 = r13;
        this.i.setRotate(r8, r14 / 2.0f, r15 / 2.0f);
        float r16 = RangesKt.coerceAtMost((r22.getWidth() * 1.0f) / r14, (r22.getHeight() * 1.0f) / r15);
        this.i.postScale(r16, r16);
        Bitmap r17 = this.h;
        if (r17 == null) goto L57;
        r22.drawBitmap(r17, this.i, this.d);
        return;
    L57:
        return;
    L51:
        r13 = 0;
        goto L52
    L47:
        r11 = 0;
        goto L48
    L43:
        r8 = (1 - ((r6 - r7) / r7)) * 90.0f;
        goto L44
    L56:
        return;
    L34:
        if (r4 >= 50) goto L36;
        float r18 = (r4 - r10) / r10;
    L37:
        this.b.setStrokeWidth(this.u);
        PointF r19 = this.v;
        float r20 = r19.x;
        float r21 = r20 - this.w;
        float r23 = r19.y;
        float r110 = (this.x * r18) / 2.0f;
        float r24 = r23 - r110;
        float r111 = r110 + r23;
        float r25 = 2;
        float r112 = this.y;
        float r26 = ((r20 + r21) / r25) + r112;
        float r113 = ((r23 + r24) / r25) - r112;
        float r114 = ((r23 + r111) / r25) + r112;
        float r27 = r21 - this.z;
        this.t.reset();
        Path r115 = this.t;
        PointF r28 = this.v;
        r115.moveTo(r28.x, r28.y);
        this.t.quadTo(r26, r113, r21, r24);
        this.t.quadTo(r27, r23, r21, r111);
        Path r29 = this.t;
        PointF r30 = this.v;
        r29.quadTo(r26, r114, r30.x, r30.y);
        this.t.close();
        r22.drawPath(this.t, this.b);
        goto L38
    L36:
        r18 = 1 - ((r4 - 50.0f) / r10);
        goto L37
    L26:
        if (r4 >= 75) goto L29;
        r5 = false;
        goto L31
    L15:
        if (r2 > r10) goto L17;
        float r31 = r2 / r10;
    L18:
        float r32 = r31 * 90.0f;
        double r33 = ((double) r32) * 0.017453292519943295d;
        float r34 = (float) Math.cos(r33);
        float r35 = (float) Math.sin(r33);
        float r36 = 90;
        float r37 = this.p;
        float r116 = (-1.0f) / (r36 / r37);
        if (r32 > r36) goto L21;
        float r38 = UtilityKotlinExtentionsKt.h((r116 * r32) + r37);
    L22:
        PointF r39 = this.o;
        float r40 = r39.x + (this.s * r31);
        float r41 = r39.y;
        float r42 = r38 * r34;
        float r117 = r40 - r42;
        float r43 = r38 * r35;
        float r118 = r41 - r43;
        float r44 = r40 + r42;
        float r45 = r41 + r43;
        float r46 = this.q;
        float r47 = r46 * r35;
        float r119 = r117 + r47;
        float r48 = r46 * r34;
        float r120 = r118 - r48;
        float r49 = r117 - r47;
        float r121 = r118 + r48;
        float r50 = this.r;
        float r51 = r35 * r50;
        float r52 = r50 * r34;
        this.c.setStrokeWidth(this.n);
        r22.drawLine(r119, r120, r49, r121, this.c);
        r22.drawLine(r44 + r51, r45 - r52, r44 - r51, r45 + r52, this.c);
        goto L23
    L21:
        r38 = UtilityKotlinExtentionsKt.h((r116 * Math.abs(r32 - 180.0f)) + this.p);
        goto L22
    L17:
        r31 = 1 - ((r2 - 75) / r10);
        goto L18
    L8:
        if (r2 >= 75) goto L10;
        r3 = true;
        goto L12
    }

    public final void setBgBitmap(Bitmap r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isRecycled() == true) goto L6;
        Bitmap r0 = r2;
    L7:
        if (r0 == null) goto L11;
        this.h = r2;
        invalidate();
        return;
    L11:
        return;
    L6:
        r0 = null;
        goto L7
    }

    public final void setEnableBitmapBg(boolean r1) {
        this.g = r1;
    }

    public final void setHeightOffset(float r1) {
        this.k = r1;
    }

    public final void setMPauseWidth(float r1) {
        this.n = r1;
    }

    public final void setMPlayWidth(float r1) {
        this.u = r1;
    }

    public final void setMSizeRatio(float r1) {
        this.j = r1;
    }

    public final void setPlayStatus(boolean r1) {
        this.m = r1;
    }

    public final void setProgress(float r3) {
        if (r3 >= 0) goto L6;
        r3 = 0.0f;
    L8:
        this.A = r3;
        invalidate();
        return;
    L6:
        if (r3 <= 100.0f) goto L8;
        r3 = 100.0f;
        goto L8
    }

    public final void setWidthOffset(float r1) {
        this.l = r1;
    }

    public PlayPauseView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        this.a = new PaintFlagsDrawFilter(0, 3);
        this.b = new Paint();
        this.c = new Paint();
        Paint r6 = new Paint();
        r6.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Unit r7 = Unit.INSTANCE;
        this.d = r6;
        this.e = new ValueAnimator();
        this.f = new ValueAnimator();
        Bitmap r8 = s1.g(2131252619);     // Catch: Exception -> L5
    L6:
        this.h = r8;
        this.i = new Matrix();
        this.j = 1.0f;
        this.m = true;
        this.n = UtilityKotlinExtentionsKt.h(3.25f);
        this.o = new PointF(UtilityKotlinExtentionsKt.h(20.0f), UtilityKotlinExtentionsKt.h(20.0f));
        this.p = 5.8f;
        this.q = UtilityKotlinExtentionsKt.h(7.25f);
        this.r = UtilityKotlinExtentionsKt.h(7.25f);
        this.s = UtilityKotlinExtentionsKt.h(1.5f);
        this.t = new Path();
        this.u = UtilityKotlinExtentionsKt.h(2.5f);
        this.v = new PointF(UtilityKotlinExtentionsKt.h(28.75f), UtilityKotlinExtentionsKt.h(20.0f));
        this.w = UtilityKotlinExtentionsKt.h(14.5f);
        this.x = UtilityKotlinExtentionsKt.h(15.2f);
        this.y = UtilityKotlinExtentionsKt.h(0.5f);
        this.z = UtilityKotlinExtentionsKt.h(0.45f);
        this.c.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setFilterBitmap(true);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setColor(-1);
        this.c.setStrokeCap(Paint.Cap.ROUND);
        this.b.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.b.setColor(-1);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        this.b.setStrokeJoin(Paint.Join.ROUND);
        return;
    L5:
        r8 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        int r6 = View.resolveSize(getSuggestedMinimumHeight(), r5);
        int r7 = View.resolveSize(getSuggestedMinimumWidth(), r4);
        int r0 = Math.min(r6, r7);
        this.j = r0 / ((int) UtilityKotlinExtentionsKt.h(40.0f));
        this.k = (r6 - r0) / 2.0f;
        this.l = (r7 - r0) / 2.0f;
    }
}
