package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import h18.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u0001:\u0001GB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010+\u001a\u00020,H\u0014J\u000e\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0018J$\u0010/\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0018002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104J(\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000eH\u0014J\b\u0010:\u001a\u00020,H\u0002J\u0010\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020=H\u0014J\b\u0010>\u001a\u00020,H\u0002J \u0010?\u001a\u00020,2\b\b\u0002\u0010@\u001a\u00020\u00182\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020,0BJ,\u0010C\u001a\u00020,*\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u0010H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(¨\u0006H"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceOvalBackground;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "path", "Landroid/graphics/Path;", "paint", "Landroid/graphics/Paint;", "borderPaint", "shadowColor", "", "shadowRadius", "", "shadowX", "shadowY", "borderSize", "borderColor", "rectF", "Landroid/graphics/RectF;", "isNormalState", "", "ovalBackgroundRegion", "Landroid/graphics/Region;", "startSemiMajorAxis", "startSemiMinorAxis", "endSemiMajorAxis", "endSemiMinorAxis", "currentSemiMajorAxis", "currentSemiMinorAxis", "whiteColor", "whiteColor10", "voiceRecordIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "gradientColor", "", "getGradientColor", "()[I", "gradientColor$delegate", "Lkotlin/Lazy;", "onFinishInflate", "", "setState", "isNormal", "checkTouchInOvalArea", "Lkotlin/Pair;", "event", "Landroid/view/MotionEvent;", "target", "Landroid/view/View;", "onSizeChanged", "w", "h", "oldw", "oldh", "updateOvalRegion", "onDraw", "canvas", "Landroid/graphics/Canvas;", "initData", "startAnimator", "isExpand", "onAnimatorEnd", "Lkotlin/Function0;", "addOval", "r1", "r2", "shadowHeight", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class VoiceOvalBackground extends FrameLayout {
    public final Path a;
    public final Paint b;
    public final Paint c;
    public final int d;
    public final int e;
    public final RectF f;
    public boolean g;
    public final Region h;
    public final float i;
    public final float j;
    public final float k;
    public final float l;
    public float m;
    public float n;
    public final int o;
    public final int p;
    public AppCompatImageView q;
    public final Lazy r;

    public static final class a {
    }

    static {
    }

    private final int[] getGradientColor() {
        return (int[]) this.r.getValue();
    }

    public final void e() {
        RectF r0 = new RectF();
        Path r1 = new Path(this.a);
        Path r2 = new Path();
        r2.addRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), Path.Direction.CW);
        r1.op(r2, Path.Op.INTERSECT);
        r1.computeBounds(r0, true);
        this.h.setPath(r1, new Region((int) r0.left, (int) r0.top, (int) r0.right, (int) r0.bottom));
    }

    public final void c() {
        this.f.set(0.0f, 0.0f, getWidth(), getHeight());
        boolean r0 = f.a(getContext());
        Paint r1 = this.b;
        r1.setStyle(Paint.Style.FILL);
        if (this.g == true) goto L5;
        r1.setShader(new LinearGradient(getWidth() / 2.0f, 0.0f, getWidth() / 2.0f, getHeight(), getGradientColor(), new float[]{0.0f, 0.6f, 1.0f}, Shader.TileMode.CLAMP));
        this.b.setColor(this.o);
    L10:
        Paint r2 = this.c;
        r2.setColor(this.e);
        r2.setStrokeWidth(this.d);
        if (r0 == false) goto L13;
        int r3 = 26;
    L14:
        r2.setAlpha(r3);
        r2.setStyle(Paint.Style.STROKE);
        this.a.reset();
        if (this.g == true) goto L17;
        a(this.a, this.f, this.n, this.m, this.d / 2.0f);
        return;
    L17:
        a(this.a, this.f, this.n, this.m, 0.0f);
        return;
    L13:
        r3 = 51;
        goto L14
    L5:
        this.b.setShader(null);
        Paint r4 = this.b;
        if (r0 == false) goto L8;
        int r5 = this.p;
    L9:
        r4.setColor(r5);
        goto L10
    L8:
        r5 = UIUtils.getColor(getContext(), 2131106504);
        goto L9
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        AppCompatImageView r0 = findViewById(2131374810);
        Drawable r1 = r0.getDrawable();
        if (r1 == null) goto L5;
        r1.setColorFilter(new PorterDuffColorFilter(UIUtils.getColor(r0.getContext(), 2131106511), PorterDuff.Mode.SRC_IN));
    L5:
        this.q = r0;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.onDraw(r4);
        if (this.g == true) goto L5;
        r4.drawPath(this.a, this.b);
        int r0 = r4.save();
        r4.translate(0.0f, this.d / 2.0f);
        r4.drawPath(this.a, this.c);
        r4.restoreToCount(r0);
        return;
    L5:
        r4.drawPath(this.a, this.b);
    }

    public final void setState(boolean r4) {
        this.g = r4;
        c();
        invalidate();
        if (r4 == false) goto L9;
        AppCompatImageView r5 = this.q;
        if (r5 == null) goto L15;
        Drawable r6 = r5.getDrawable();
        if (r6 == null) goto L16;
        r6.setColorFilter(new PorterDuffColorFilter(UIUtils.getColor(getContext(), 2131106530), PorterDuff.Mode.SRC_IN));
        return;
    L16:
        return;
    L15:
        return;
    L9:
        AppCompatImageView r7 = this.q;
        if (r7 == null) goto L18;
        Drawable r8 = r7.getDrawable();
        if (r8 == null) goto L19;
        r8.setColorFilter(new PorterDuffColorFilter(UIUtils.getColor(getContext(), 2131106511), PorterDuff.Mode.SRC_IN));
        return;
    L19:
        return;
    }

    public VoiceOvalBackground(final Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.a = new Path();
        this.b = new Paint(5);
        this.c = new Paint(5);
        ColorProtector.parseColor("#FFE4E5E5");
        UIUtils.dp2px(r3, 10.0f);
        UIUtils.dp2px(r3, 4.0f);
        UIUtils.dp2px(r3, -4.0f);
        this.d = UIUtils.dp2px(r3, 4.0f);
        this.e = -1;
        this.f = new RectF();
        this.h = new Region();
        float r5 = UIUtils.dp2px(r3, 153.0f);
        this.i = r5;
        float r0 = UIUtils.dp2px(r3, 23.0f);
        this.j = r0;
        this.k = UIUtils.dp2px(r3, 340.0f);
        this.l = UIUtils.dp2px(r3, 200.0f);
        this.m = r5;
        this.n = r0;
        this.o = UIUtils.getColor(r3, 2131106521);
        this.p = UIUtils.getColor(r3, 2131106522);
        this.r = LazyKt.lazy(new VoiceOvalBackground$gradientColor$2(r3));
        setWillNotDraw(false);
        setLayerType(1, null);
    }

    public final Pair<int[], Boolean> b(MotionEvent r7, View r8) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (r8 == null) goto L5;
        int[] r0 = {0, 0};
        if (sob.c.a(this) == false) goto L9;
        r8.getLocationInWindow(r0);
        int r9 = r0[0];
        int r1 = r0[1];
        getLocationInWindow(r0);
        r0[0] = ((int) r7.getX()) + (r9 - r0[0]);
        r0[1] = ((int) r7.getY()) + (r1 - r0[1]);
    L11:
        return new Pair(r0, Boolean.valueOf(this.h.contains(r0[0], r0[1]) | this.h.isEmpty()));
    L9:
        getLocationOnScreen(r0);
        r0[0] = (int) (r7.getRawX() - r0[0]);
        r0[1] = (int) (r7.getRawY() - r0[1]);
        goto L11
    L5:
        return new Pair(new int[]{0, 0}, Boolean.FALSE);
    }

    public static void d(VoiceOvalBackground r3, Function0 r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r5 & 2) == 0) goto L9;
        r4 = VoiceOvalBackground$startAnimator$1.INSTANCE;
    L9:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "onAnimatorEnd");
        ValueAnimator r6 = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r6.setDuration(150);
        r6.setInterpolator(new LinearInterpolator());
        r6.addUpdateListener(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.a(r3, r0));
        Intrinsics.checkNotNull(r6);
        r6.addListener(new b(r4));
        r6.start();
        return;
    L5:
        r0 = false;
        goto L7
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        c();
        e();
    }

    public static void a(Path r5, RectF r6, float r7, float r8, float r9) {
        float r0 = r6.width();
        float r1 = r6.height();
        float r2 = 2;
        float r10 = r8 * r2;
        float r3 = r2 * r7;
        float r11 = r10 - r0;
        if (r1 <= r7) goto L5;
        r6.set((-r11) / 2.0f, r1 - r7, r0 + (r11 / 2.0f), r1 + r7);
    L6:
        r5.addOval(r6, Path.Direction.CW);
        return;
    L5:
        r6.set((-r11) / 2.0f, r9, r0 + (r11 / 2.0f), r3);
        goto L6
    }
}
