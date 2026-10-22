package com.bytedance.android.live.profile.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001YB'\b\u0007\u0012\u0006\u0010S\u001a\u00020R\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T\u0012\b\b\u0002\u0010V\u001a\u00020\u000b¢\u0006\u0004\bW\u0010XR*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R*\u0010\"\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR*\u0010&\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR*\u0010*\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR.\u00102\u001a\u0004\u0018\u00010+2\b\u0010\u0003\u001a\u0004\u0018\u00010+8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010;\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u00107R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00105\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u00105\u001a\u0004\bC\u0010DR\u001b\u0010H\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u00105\u001a\u0004\bG\u0010DR\u001b\u0010K\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u00105\u001a\u0004\bJ\u00107R\u001b\u0010N\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u00105\u001a\u0004\bM\u0010DR\u001b\u0010Q\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u00105\u001a\u0004\bP\u0010D¨\u0006Z"}, d2 = {"Lcom/bytedance/android/live/profile/customview/TrapezoidConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "value", "b", "F", "getStrokeWidth", "()F", "setStrokeWidth", "(F)V", "strokeWidth", "", "c", "I", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "strokeColor", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "d", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "getGradientOrientation", "()Landroid/graphics/drawable/GradientDrawable$Orientation;", "setGradientOrientation", "(Landroid/graphics/drawable/GradientDrawable$Orientation;)V", "gradientOrientation", "e", "getAcuteAnglePosition", "setAcuteAnglePosition", "acuteAnglePosition", "f", "getAcuteAngleDegree", "setAcuteAngleDegree", "acuteAngleDegree", "g", "getLeftCornerRadius", "setLeftCornerRadius", "leftCornerRadius", "h", "getRightCornerRadius", "setRightCornerRadius", "rightCornerRadius", "", "i", "[I", "getColors", "()[I", "setColors", "([I)V", "colors", "Landroid/graphics/Paint;", "j", "Lkotlin/Lazy;", "getFillPaint", "()Landroid/graphics/Paint;", "fillPaint", "k", "getStrokePaint", "strokePaint", "Landroid/graphics/RectF;", "l", "getDrawRect", "()Landroid/graphics/RectF;", "drawRect", "Landroid/graphics/Path;", "m", "getRoundPath", "()Landroid/graphics/Path;", "roundPath", "n", "getTempRoundRectPath", "tempRoundRectPath", "o", "getTempAnglePaint", "tempAnglePaint", "p", "getTempAcuteAnglePathRaw", "tempAcuteAnglePathRaw", "q", "getTempAcuteAnglePath", "tempAcuteAnglePath", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TrapezoidConstraintLayout extends ConstraintLayout {
    public boolean a;
    public float b;
    public int c;
    public GradientDrawable.Orientation d;
    public int e;
    public float f;
    public float g;
    public float h;
    public int[] i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;

    public static final class a {
    }

    static {
    }

    public TrapezoidConstraintLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TrapezoidConstraintLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final RectF getDrawRect() {
        return (RectF) this.l.getValue();
    }

    private final Paint getFillPaint() {
        return (Paint) this.j.getValue();
    }

    private final Path getRoundPath() {
        return (Path) this.m.getValue();
    }

    private final Paint getStrokePaint() {
        return (Paint) this.k.getValue();
    }

    private final Path getTempAcuteAnglePath() {
        return (Path) this.q.getValue();
    }

    private final Path getTempAcuteAnglePathRaw() {
        return (Path) this.p.getValue();
    }

    private final Paint getTempAnglePaint() {
        return (Paint) this.o.getValue();
    }

    private final Path getTempRoundRectPath() {
        return (Path) this.n.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        this.a = true;
        setWillNotDraw(false);
    }

    public final void reset() {
        setStrokeWidth(0.0f);
        setStrokeColor(0);
        setGradientOrientation(GradientDrawable.Orientation.TL_BR);
        setAcuteAnglePosition(1);
        setAcuteAngleDegree(90.0f);
        setLeftCornerRadius(0.0f);
        setRightCornerRadius(0.0f);
        setColors(null);
    }

    public final float getAcuteAngleDegree() {
        return this.f;
    }

    public final int getAcuteAnglePosition() {
        return this.e;
    }

    public final int[] getColors() {
        return this.i;
    }

    public final GradientDrawable.Orientation getGradientOrientation() {
        return this.d;
    }

    public final float getLeftCornerRadius() {
        return this.g;
    }

    public final float getRightCornerRadius() {
        return this.h;
    }

    public final int getStrokeColor() {
        return this.c;
    }

    public final float getStrokeWidth() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r19) {
        Intrinsics.checkNotNullParameter(r19, "canvas");
        if (this.a == false) goto L47;
        this.a = false;
        getDrawRect().set(0.0f, 0.0f, getWidth(), getHeight());
        int[] r2 = this.i;
        if (r2 != null) goto L8;
        r2 = new int[]{0, 0};
    L8:
        int[] r10 = r2;
        RectF r3 = getDrawRect();
        switch(com.bytedance.android.live.profile.customview.a.a[this.d.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L10:
        float r5 = r3.left;
        float r6 = r3.top;
        float r7 = r3.right;
        float r4 = r3.bottom;
    L20:
        float r17 = r6;
        float r8 = r4;
        float r9 = r7;
        float r12 = r17;
    L21:
        float r13 = r9;
        float r14 = r8;
        float r15 = r5;
    L22:
        getFillPaint().setShader(new LinearGradient(r15, r12, r13, r14, r10, null, Shader.TileMode.CLAMP));
        getStrokePaint().setStrokeWidth(this.b * 2);
        getStrokePaint().setColor(this.c);
        int r16 = this.e;
        if (r16 == 0) goto L27;
        if (r16 == 3) goto L27;
        boolean r18 = false;
    L28:
        Path r110 = getTempRoundRectPath();
        r110.reset();
        float r20 = this.g;
        float r22 = this.h;
        float[] r111 = {r20, r20, r22, r22, r22, r22, r20, r20};
        if (r18 == false) goto L31;
        r110.addRoundRect(getDrawRect().right * 0.4f, getDrawRect().top, getDrawRect().right, getDrawRect().bottom, r111, Path.Direction.CW);
    L32:
        r110.close();
        Paint r23 = getTempAnglePaint();
        if (r18 == false) goto L35;
        CornerPathEffect r24 = new CornerPathEffect(this.g);
    L36:
        r23.setPathEffect(r24);
        Path r25 = getTempAcuteAnglePathRaw();
        r25.reset();
        float r26 = (float) (((double) getDrawRect().height()) * Math.tan(Math.toRadians(((double) 90) - ((double) this.f))));
        int r27 = this.e;
        if (r27 == 0) goto L45;
        if (r27 == 1) goto L44;
        if (r27 == 2) goto L43;
        if (r27 != 3) goto L46;
        r25.moveTo(r26, getDrawRect().top);
        r25.lineTo(getDrawRect().right * 0.6f, getDrawRect().top);
        r25.lineTo(getDrawRect().right * 0.6f, getDrawRect().bottom);
        r25.lineTo(getDrawRect().left, getDrawRect().bottom);
        r25.close();
    L46:
        Path r28 = getTempAcuteAnglePath();
        r23.getFillPath(r25, r28);
        getRoundPath().op(r110, r28, Path.Op.UNION);
        goto L47
    L43:
        r25.moveTo(getDrawRect().right * 0.4f, getDrawRect().top);
        r25.lineTo(getDrawRect().right - r26, getDrawRect().top);
        r25.lineTo(getDrawRect().right, getDrawRect().bottom);
        r25.lineTo(getDrawRect().right * 0.4f, getDrawRect().bottom);
        r25.close();
        goto L46
    L44:
        r25.moveTo(getDrawRect().right * 0.4f, getDrawRect().top);
        r25.lineTo(getDrawRect().right, getDrawRect().top);
        r25.lineTo(getDrawRect().right - r26, getDrawRect().bottom);
        r25.lineTo(getDrawRect().right * 0.4f, getDrawRect().bottom);
        r25.close();
        goto L46
    L45:
        r25.moveTo(getDrawRect().left, getDrawRect().top);
        r25.lineTo(getDrawRect().right * 0.6f, getDrawRect().top);
        r25.lineTo(getDrawRect().right * 0.6f, getDrawRect().bottom);
        r25.lineTo(r26, getDrawRect().bottom);
        r25.close();
        goto L46
    L35:
        r24 = new CornerPathEffect(this.h);
        goto L36
    L31:
        r110.addRoundRect(getDrawRect().left, getDrawRect().top, getDrawRect().right * 0.6f, getDrawRect().bottom, r111, Path.Direction.CW);
    L27:
        r18 = true;
        goto L28
    L11:
        r5 = r3.left;
        r8 = r3.top;
        r9 = r3.right;
    L16:
        r12 = r8;
        goto L21
    L12:
        r5 = r3.left;
        r6 = r3.bottom;
        r7 = r3.right;
        r4 = r3.top;
        goto L20
    L13:
        float r29 = r3.left;
        float r30 = r3.bottom;
        float r32 = r3.top;
    L19:
        r14 = r32;
        r13 = r29;
        r12 = r30;
        r15 = r13;
        goto L22
    L14:
        r5 = r3.right;
        r6 = r3.bottom;
        r7 = r3.left;
        r4 = r3.top;
        goto L20
    L15:
        r5 = r3.right;
        r8 = r3.top;
        r9 = r3.left;
        goto L16
    L17:
        r5 = r3.right;
        r6 = r3.top;
        r7 = r3.left;
        r4 = r3.bottom;
        goto L20
    L18:
        r29 = r3.left;
        r30 = r3.top;
        r32 = r3.bottom;
    L47:
        r19.save();
        r19.clipPath(getRoundPath());
        r19.drawPath(getRoundPath(), getFillPaint());
        super/*android.view.ViewGroup*/.draw(r19);
        if (getStrokePaint().getStrokeWidth() <= 0) goto L50;
        r19.drawPath(getRoundPath(), getStrokePaint());
    L50:
        r19.restore();
    }

    public final void setAcuteAngleDegree(float r3) {
        R5();
        if (r3 < 90.0f) goto L5;
        r3 = 90.0f;
    L5:
        this.f = r3;
    }

    public final void setAcuteAnglePosition(int r1) {
        R5();
        this.e = r1;
    }

    public final void setColors(int[] r1) {
        R5();
        this.i = r1;
    }

    public final void setGradientOrientation(GradientDrawable.Orientation r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        R5();
        this.d = r2;
    }

    public final void setLeftCornerRadius(float r1) {
        R5();
        this.g = r1;
    }

    public final void setRightCornerRadius(float r1) {
        R5();
        this.h = r1;
    }

    public final void setStrokeColor(int r1) {
        R5();
        this.c = r1;
    }

    public final void setStrokeWidth(float r1) {
        R5();
        this.b = r1;
    }

    public TrapezoidConstraintLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = GradientDrawable.Orientation.TL_BR;
        this.e = 1;
        this.f = 90.0f;
        this.j = LazyKt.lazy(TrapezoidConstraintLayout$fillPaint$2.INSTANCE);
        this.k = LazyKt.lazy(TrapezoidConstraintLayout$strokePaint$2.INSTANCE);
        this.l = LazyKt.lazy(TrapezoidConstraintLayout$drawRect$2.INSTANCE);
        this.m = LazyKt.lazy(TrapezoidConstraintLayout$roundPath$2.INSTANCE);
        this.n = LazyKt.lazy(TrapezoidConstraintLayout$tempRoundRectPath$2.INSTANCE);
        this.o = LazyKt.lazy(TrapezoidConstraintLayout$tempAnglePaint$2.INSTANCE);
        this.p = LazyKt.lazy(TrapezoidConstraintLayout$tempAcuteAnglePathRaw$2.INSTANCE);
        this.q = LazyKt.lazy(TrapezoidConstraintLayout$tempAcuteAnglePath$2.INSTANCE);
    }

    public /* synthetic */ TrapezoidConstraintLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
