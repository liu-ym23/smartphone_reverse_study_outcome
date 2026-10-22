package com.obric.assistant.view.continuespeech;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u0000 j2\u00020\u0001:\u0002ijB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010)J\b\u0010R\u001a\u00020NH\u0002J\u0010\u0010S\u001a\u00020N2\u0006\u0010T\u001a\u00020;H\u0002J\u0010\u0010U\u001a\u00020N2\u0006\u0010T\u001a\u00020;H\u0002J\u0010\u0010V\u001a\u00020N2\u0006\u0010W\u001a\u00020\rH\u0002J\u0012\u0010X\u001a\u00020N2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010[\u001a\u00020NH\u0002J\u0010\u0010\\\u001a\u00020N2\u0006\u0010]\u001a\u00020^H\u0014J \u0010_\u001a\u00020N2\u0006\u0010]\u001a\u00020^2\u0006\u0010`\u001a\u00020\r2\u0006\u0010a\u001a\u00020\rH\u0002J\b\u0010b\u001a\u00020NH\u0014J\b\u0010c\u001a\u00020NH\u0014J\"\u0010d\u001a\u00020N2\u0006\u0010e\u001a\u00020,2\u0006\u0010f\u001a\u00020g2\b\b\u0001\u0010h\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R$\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR$\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR$\u0010\"\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/obric/assistant/view/continuespeech/AudioGradientView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialized", "", "value", "", "cornerRadius", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "blurRadius", "getBlurRadius", "setBlurRadius", "expandSize", "getExpandSize", "setExpandSize", "autoExpand", "getAutoExpand", "()Z", "setAutoExpand", "(Z)V", "isAnimating", "setAnimating", "isWarning", "setWarning", "grayRatio", "getGrayRatio", "setGrayRatio", "warningColor", "useCustomGradient", "customColorCount", "customColorsPacked", "", "customPositionsPacked", "runtimeShader", "Landroid/graphics/RuntimeShader;", "paint", "Landroid/graphics/Paint;", "grayPaint", "fadePaint", "leftFadeGradient", "Landroid/graphics/LinearGradient;", "rightFadeGradient", "leftFadeMatrix", "Landroid/graphics/Matrix;", "rightFadeMatrix", "animState", "Lcom/obric/assistant/view/continuespeech/AudioGradientView$AnimState;", "currentOffset", "lastFrameNanos", "", "retStartOffset", "retForwardDist", "retDurationMs", "retStartNanos", "warnValue", "warnTarget", "warnStartValue", "warnStartNanos", "warnRunning", "widthRatioMultiplier", "widthRatioAnimator", "Landroid/animation/ValueAnimator;", "baseMarginLeft", "baseMarginTop", "baseMarginRight", "baseMarginBottom", "isApplyingMargins", "setGradientColors", "", "colors", "", "positions", "startReturning", "updateOffset", "now", "updateWarning", "animateWidthRatio", "target", "setLayoutParams", "params", "Landroid/view/ViewGroup$LayoutParams;", "applyBlurMargins", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawGrayArea", "w", "h", "onAttachedToWindow", "onDetachedFromWindow", "setColorUniform", "shader", "name", "", "color", "AnimState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AudioGradientView extends View {
    public static final /* synthetic */ int J = 0;
    public float A;
    public long B;
    public float C;
    public float D;
    public float E;
    public long F;
    public boolean G;
    public float H;
    public ValueAnimator I;
    public final boolean a;
    public float b;
    public float c;
    public float d;
    public boolean e;
    public boolean f;
    public boolean g;
    public float h;
    public final int i;
    public boolean j;
    public int k;
    public final float[] l;
    public final float[] m;
    public final RuntimeShader n;
    public final Paint o;
    public final Paint p;
    public final Paint q;
    public final LinearGradient r;
    public final LinearGradient s;
    public final Matrix t;
    public final Matrix u;
    public AnimState v;
    public float w;
    public long x;
    public float y;
    public float z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/view/continuespeech/AudioGradientView$AnimState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "SCROLLING", "RETURNING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AnimState extends Enum<AnimState> {
        public static final AnimState IDLE = null;
        public static final AnimState RETURNING = null;
        public static final AnimState SCROLLING = null;
        public static final /* synthetic */ AnimState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AnimState> getEntries() {
            return b;
        }

        static {
            AnimState r0 = new AnimState("IDLE", 0);
            IDLE = r0;
            AnimState r1 = new AnimState("SCROLLING", 1);
            SCROLLING = r1;
            AnimState r3 = new AnimState("RETURNING", 2);
            RETURNING = r3;
            AnimState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static AnimState[] values() {
            return (AnimState[]) a.clone();
        }

        public static AnimState valueOf(String r1) {
            return (AnimState) r27.a.a(AnimState.class, r1);
        }

        public AnimState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AnimState.values().length];
            r0[AnimState.SCROLLING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AnimState.RETURNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AnimState.IDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        new a();
    }

    public AudioGradientView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AudioGradientView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.x = 0;
        if (this.v == AnimState.IDLE) goto L5;
    L6:
        postInvalidateOnAnimation();
        return;
    L5:
        if (this.G == true) goto L6;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.x = 0;
        ValueAnimator r0 = this.I;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public final boolean getAutoExpand() {
        return this.e;
    }

    public final float getBlurRadius() {
        return this.c;
    }

    public final float getCornerRadius() {
        return this.b;
    }

    public final float getExpandSize() {
        return this.d;
    }

    public final float getGrayRatio() {
        return this.h;
    }

    @Override // android.view.View
    public void onDraw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        float r8 = getWidth();
        float r9 = getHeight();
        float r1 = 0.0f;
        if (r8 > 0.0f) goto L5;
        return;
    L5:
        if (r9 <= 0.0f) goto L47;
        RuntimeShader r2 = this.n;
        if (r2 != null) goto L11;
        r18.drawRect(0.0f, 0.0f, r8, r9, this.o);
        a(r18, r8, r9);
        return;
    L11:
        long r3 = System.nanoTime();
        int r5 = b.a[this.v.ordinal()];
        if (r5 == 1) goto L22;
        if (r5 != 2) goto L15;
        float r6 = RangesKt.coerceIn(((r3 - this.B) / 1000000.0f) / this.A, 0.0f, 1.0f);
        float r14 = 1.0f - r6;
        this.w = this.y + (this.z * (1.0f - (r14 * r14)));
        if (r6 < 1.0f) goto L27;
        this.v = AnimState.IDLE;
    L27:
        if (this.G == false) goto L33;
        float r4 = RangesKt.coerceIn(((r3 - this.F) / 1000000.0f) / 200.0f, 0.0f, 1.0f);
        float r7 = this.E;
        float r10 = this.D;
        float r11 = 1.0f - r4;
        this.C = r7 + ((r10 - r7) * (1.0f - (r11 * r11)));
        if (r4 < 1.0f) goto L33;
        this.C = r10;
        this.G = false;
    L33:
        if (this.e == false) goto L35;
        float r12 = this.c * 1.3f;
    L36:
        float r13 = 2 * r12;
        float r15 = Math.min(r8 - r13, r9 - r13) / 2.0f;
        r2.setFloatUniform("uResolution", r8, r9);
        r2.setFloatUniform("uRadius", Math.min(this.b, r15));
        r2.setFloatUniform("uBlur", this.c);
        r2.setFloatUniform("uInset", r12);
        r2.setFloatUniform("uOffsetX", this.w);
        r2.setFloatUniform("uGradientWidthRatio", this.H * 0.8f);
        r2.setFloatUniform("uSpacingRatio", 1.5f);
        r2.setFloatUniform("uWarningProgress", this.C);
        if (this.j == false) goto L39;
        r1 = 1.0f;
    L39:
        r2.setFloatUniform("uUseCustomGradient", r1);
        r2.setFloatUniform("uCustomColorCount", this.k);
        r2.setFloatUniform("uCustomColors", this.l);
        r2.setFloatUniform("uCustomPositions", this.m);
        int r16 = this.i;
        r2.setFloatUniform("uWarningColor", Color.red(r16) / 255.0f, Color.green(r16) / 255.0f, Color.blue(r16) / 255.0f);
        r18.drawRect(0.0f, 0.0f, r8, r9, this.o);
        a(r18, r8, r9);
        if (this.v == AnimState.IDLE) goto L42;
    L43:
        postInvalidateOnAnimation();
        return;
    L42:
        if (this.G == true) goto L43;
        return;
    L35:
        r12 = 0.0f;
        goto L36
    L15:
        if (r5 == 3) goto L27;
        throw new NoWhenBranchMatchedException();
    L22:
        long r17 = this.x;
        if (r17 <= 0) goto L25;
        this.w += ((r3 - r17) * 1.0f) / 1.0E9f;
    L25:
        this.x = r3;
        goto L27
    }

    public void setAnimating(boolean r7) {
        if (this.f != r7) goto L5;
        return;
    L5:
        this.f = r7;
        if (r7 == false) goto L8;
        this.v = AnimState.SCROLLING;
        this.x = 0;
        postInvalidateOnAnimation();
    L12:
        if (r7 == false) goto L14;
        float r8 = 1.5f;
    L15:
        ValueAnimator r0 = this.I;
        if (r0 == null) goto L18;
        r0.cancel();
    L18:
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{this.H, r8});
        r9.setDuration(400);
        r9.addUpdateListener(new a0(this));
        r9.start();
        this.I = r9;
        return;
    L14:
        r8 = 0.8f;
        goto L15
    L8:
        float r2 = this.w;
        float r3 = (1.0f - ((((r2 - 0.3f) % 1.0f) + 1.0f) % 1.0f)) % 1.0f;
        if (r3 >= 0.001f) goto L11;
        this.v = AnimState.IDLE;
        goto L12
    L11:
        this.v = AnimState.RETURNING;
        this.y = r2;
        this.z = r3;
        this.A = ((r3 * 2.0f) / 1.0f) * 1000.0f;
        this.B = System.nanoTime();
        this.x = 0;
        postInvalidateOnAnimation();
        goto L12
    }

    public final void setAutoExpand(boolean r1) {
        this.e = r1;
        if (this.a == false) goto L6;
        invalidate();
        return;
    }

    public final void setBlurRadius(float r1) {
        this.c = r1;
        if (this.a == false) goto L6;
        invalidate();
        return;
    }

    public final void setCornerRadius(float r1) {
        this.b = r1;
        if (this.a == false) goto L6;
        invalidate();
        return;
    }

    public final void setExpandSize(float r1) {
        this.d = r1;
        if (this.a == false) goto L6;
        invalidate();
        return;
    }

    public final void setGrayRatio(float r2) {
        this.h = Math.max(0.0f, Math.min(1.0f, r2));
        invalidate();
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r3) {
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r3;
        int r1 = r0.leftMargin;
        int r2 = r0.topMargin;
        int r4 = r0.rightMargin;
        int r5 = r0.bottomMargin;
    L5:
        super.setLayoutParams(r3);
    }

    public final void setWarning(boolean r3) {
        if (this.g != r3) goto L5;
        return;
    L5:
        this.g = r3;
        if (r3 == false) goto L8;
        float r4 = 1.0f;
    L9:
        this.D = r4;
        this.E = this.C;
        this.F = System.nanoTime();
        this.G = true;
        postInvalidateOnAnimation();
        return;
    L8:
        r4 = 0.0f;
        goto L9
    }

    public AudioGradientView(Context r25, AttributeSet r26, int r27) {
        Intrinsics.checkNotNullParameter(r25, "context");
        super(r25, r26, r27);
        this.e = true;
        this.i = -42663;
        this.l = new float[32];
        this.m = new float[8];
        RuntimeShader r3 = new RuntimeShader("\nuniform float2 uResolution;\nuniform float uRadius;\nuniform float uBlur;\nuniform float uInset;\nuniform float uOffsetX;\nuniform float uGradientWidthRatio;\nuniform float uSpacingRatio;\nuniform float uWarningProgress;\nuniform float3 uWarningColor;\nuniform float uUseCustomGradient;\nuniform float uCustomColorCount;\nuniform float uCustomColors[32];\nuniform float uCustomPositions[8];\n\nfloat erf_approx(float x) {\n    float ax = abs(x);\n    float t  = 1.0 / (1.0 + 0.3275911 * ax);\n    float y  = 1.0 - (((((1.061405429 * t - 1.453152027) * t)\n               + 1.421413741) * t - 0.284496736) * t + 0.254829592)\n               * t * exp(-ax * ax);\n    return x >= 0.0 ? y : -y;\n}\n\nfloat gaussianEdge(float dist, float sigma) {\n    return 0.5 - 0.5 * erf_approx(dist / (sigma * 1.4142135));\n}\n\nfloat roundedRectSDF(float2 p, float2 size, float r) {\n    float2 h = size * 0.5;\n    float2 d = abs(p) - h + r;\n    float outside = length(max(d, 0.0));\n    float inside  = min(max(d.x, d.y), 0.0);\n    return outside + inside - r;\n}\n\n// 高斯加权三色渐变，softness 控制颜色过渡柔和度\nfloat4 gaussianGradient3(float2 p, float2 ctr, float angle, float w,\n                         float4 cA, float4 cB, float4 cC, float mirror,\n                         float softness) {\n    float cosA = cos(angle);\n    float sinA = sin(angle);\n    float projected = dot(p - ctr, float2(cosA, sinA));\n    float t = projected / w + 0.5;\n    if (mirror > 0.5) {\n        t = 1.0 - abs(t * 2.0 - 1.0);\n    }\n    float s = max(softness, 0.15);\n    float fade = s * 0.5;\n    float edge = smoothstep(-fade, 0.0, t) * smoothstep(-fade, 0.0, 1.0 - t);\n    if (edge <= 0.0) {\n        return float4(0.0);\n    }\n    float inv2s2 = 1.0 / (2.0 * s * s);\n    float wA = exp(-t * t * inv2s2);\n    float wB = exp(-(t - 0.5) * (t - 0.5) * inv2s2);\n    float wC = exp(-(t - 1.0) * (t - 1.0) * inv2s2);\n    float total = wA + wB + wC;\n    float4 result = (cA * wA + cB * wB + cC * wC) / total;\n    result.a *= edge;\n    return result;\n}\n\nconst float  GRADIENT_ANGLE    = 0.0;\nconst float  GRADIENT_SOFTNESS = 1.0 / 4.0;\nconst float3 COLOR_BG          = float3(0.373, 0.522, 1.0);\nconst float3 COLOR_WARNING     = float3(1.0, 0.349, 0.349);\nconst float4 COLOR_A           = float4(1.0, 0.565, 0.565, 0.0);\nconst float4 COLOR_B           = float4(1.0, 0.565, 0.565, 1.0);\nconst float4 COLOR_C           = float4(0.996, 0.757, 0.514, 1.0);\n\nint clampColorCount(int n) {\n    if (n < 0) {\n        return 0;\n    }\n    if (n > 8) {\n        return 8;\n    }\n    return n;\n}\n\nfloat4 customColor0() { return float4(uCustomColors[0], uCustomColors[1], uCustomColors[2], uCustomColors[3]); }\nfloat4 customColor1() { return float4(uCustomColors[4], uCustomColors[5], uCustomColors[6], uCustomColors[7]); }\nfloat4 customColor2() { return float4(uCustomColors[8], uCustomColors[9], uCustomColors[10], uCustomColors[11]); }\nfloat4 customColor3() { return float4(uCustomColors[12], uCustomColors[13], uCustomColors[14], uCustomColors[15]); }\nfloat4 customColor4() { return float4(uCustomColors[16], uCustomColors[17], uCustomColors[18], uCustomColors[19]); }\nfloat4 customColor5() { return float4(uCustomColors[20], uCustomColors[21], uCustomColors[22], uCustomColors[23]); }\nfloat4 customColor6() { return float4(uCustomColors[24], uCustomColors[25], uCustomColors[26], uCustomColors[27]); }\nfloat4 customColor7() { return float4(uCustomColors[28], uCustomColors[29], uCustomColors[30], uCustomColors[31]); }\n\nfloat4 mixSegment(float x, float prevPos, float pos, float4 prevCol, float4 col) {\n    float denom = max(pos - prevPos, 0.0001);\n    float t = clamp((x - prevPos) / denom, 0.0, 1.0);\n    return mix(prevCol, col, t);\n}\n\nfloat4 sampleCustomGradient(float x) {\n    int n = clampColorCount(int(uCustomColorCount + 0.5));\n    if (n <= 0) {\n        return float4(COLOR_BG, 1.0);\n    }\n    x = clamp(x, 0.0, 1.0);\n    float p0 = uCustomPositions[0];\n    float p1 = uCustomPositions[1];\n    float p2 = uCustomPositions[2];\n    float p3 = uCustomPositions[3];\n    float p4 = uCustomPositions[4];\n    float p5 = uCustomPositions[5];\n    float p6 = uCustomPositions[6];\n    float p7 = uCustomPositions[7];\n    float4 c0 = customColor0();\n    float4 c1 = customColor1();\n    float4 c2 = customColor2();\n    float4 c3 = customColor3();\n    float4 c4 = customColor4();\n    float4 c5 = customColor5();\n    float4 c6 = customColor6();\n    float4 c7 = customColor7();\n\n    if (n == 1) {\n        return c0;\n    }\n    if (x <= p0) {\n        return c0;\n    }\n    if (n == 2 || x <= p1) {\n        return mixSegment(x, p0, p1, c0, c1);\n    }\n    if (n == 3 || x <= p2) {\n        return mixSegment(x, p1, p2, c1, c2);\n    }\n    if (n == 4 || x <= p3) {\n        return mixSegment(x, p2, p3, c2, c3);\n    }\n    if (n == 5 || x <= p4) {\n        return mixSegment(x, p3, p4, c3, c4);\n    }\n    if (n == 6 || x <= p5) {\n        return mixSegment(x, p4, p5, c4, c5);\n    }\n    if (n == 7 || x <= p6) {\n        return mixSegment(x, p5, p6, c5, c6);\n    }\n    if (n == 8 || x <= p7) {\n        return mixSegment(x, p6, p7, c6, c7);\n    }\n    return c7;\n}\n\nhalf4 main(float2 p) {\n    float2 center = uResolution * 0.5;\n    float2 size   = uResolution - uInset * 2.0;\n\n    float dist = roundedRectSDF(p - center, size, uRadius);\n    float shape;\n    if (uBlur > 0.0) {\n        float sigma = uBlur * 0.5;\n        float inner = gaussianEdge(dist, sigma / 6.0);\n        float outer = gaussianEdge(dist, sigma);\n        shape = inner + outer * (1.0 - inner);\n    } else {\n        shape = clamp(0.5 - dist, 0.0, 1.0);\n    }\n\n    float3 color;\n    float colorAlpha = 1.0;\n    int n = clampColorCount(int(uCustomColorCount + 0.5));\n    if (uUseCustomGradient > 0.5 && n > 0) {\n        float4 customColor = sampleCustomGradient(p.x / uResolution.x);\n        color = customColor.rgb;\n        colorAlpha = customColor.a;\n    } else {\n        float gradientWidth = size.x * uGradientWidthRatio;\n        float spacing       = size.x * uSpacingRatio;\n        float wrapped       = mod(uOffsetX * spacing, spacing);\n\n        float4 g0 = gaussianGradient3(p, center + float2(wrapped - spacing, 0.0),\n                                       GRADIENT_ANGLE, gradientWidth,\n                                       COLOR_A, COLOR_B, COLOR_C, 1.0, GRADIENT_SOFTNESS);\n        float4 g1 = gaussianGradient3(p, center + float2(wrapped, 0.0),\n                                       GRADIENT_ANGLE, gradientWidth,\n                                       COLOR_A, COLOR_B, COLOR_C, 1.0, GRADIENT_SOFTNESS);\n\n        color = COLOR_BG;\n        color = g0.rgb * g0.a + color * (1.0 - g0.a);\n        color = g1.rgb * g1.a + color * (1.0 - g1.a);\n    }\n    color = mix(color, uWarningColor, uWarningProgress);\n    float finalAlpha = shape * colorAlpha;\n    return half4(half3(color) * half(finalAlpha), half(finalAlpha));\n}\n");     // Catch: Throwable -> L5
    L6:
        this.n = r3;
        Paint r4 = new Paint(1);
        r4.setShader(r3);
        if (r3 != null) goto L9;
        r4.setColor(ColorProtector.parseColor("#5F85FF"));
    L9:
        this.o = r4;
        Paint r5 = new Paint();
        r5.setColor(ColorProtector.parseColor("#FFC9CDCF"));
        this.p = r5;
        this.q = new Paint(1);
        this.r = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, new int[]{r5.getColor(), 16777215}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.s = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, new int[]{16777215, r5.getColor()}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.t = new Matrix();
        this.u = new Matrix();
        this.v = AnimState.IDLE;
        this.w = 0.3f;
        this.H = 1.0f;
        TypedArray r6 = r25.obtainStyledAttributes(r26, new int[]{2130968872, 2130969026, 2130969639, 2130969995}, r27, 0);
        setAutoExpand(r6.getBoolean(0, true));     // Catch: Throwable -> L13
        setCornerRadius(r6.getDimension(2, 0.0f));     // Catch: Throwable -> L13
        setBlurRadius(r6.getDimension(1, 0.0f));     // Catch: Throwable -> L13
        setExpandSize(r6.getDimension(3, 0.0f));     // Catch: Throwable -> L13
        r6.recycle();
        this.a = true;
        return;
    L13:
        th = move-exception;
        r6.recycle();
        throw th;
    L5:
        r3 = null;
        goto L6
    }

    public final void a(Canvas r21, float r22, float r23) {
        Resources r2 = getResources();
        float r3 = Math.min(0.04f * r22, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density * 24.0f);
        float r1 = ((r22 / 2.0f) + (2 * r3)) * this.h;
        if (r1 <= 0.0f) goto L10;
        float r6 = Math.max(0.0f, r1 - r3);
        if (r6 <= 0.0f) goto L8;
        r21.drawRect(0.0f, 0.0f, r6, r23, this.p);
    L8:
        if (r1 <= r6) goto L10;
        this.t.reset();
        this.t.setScale(RangesKt.coerceAtLeast(r1 - r6, 0.0f), 1.0f);
        this.t.postTranslate(r6, 0.0f);
        this.r.setLocalMatrix(this.t);
        this.q.setShader(this.r);
        r21.drawRect(r6, 0.0f, r1, r23, this.q);
        this.q.setShader(null);
    L10:
        if (r1 <= 0.0f) goto L18;
        float r15 = r22 - r1;
        float r4 = Math.min(r22, r3 + r15);
        if (r4 <= r15) goto L15;
        this.u.reset();
        this.u.setScale(RangesKt.coerceAtLeast(r4 - r15, 0.0f), 1.0f);
        this.u.postTranslate(r15, 0.0f);
        this.s.setLocalMatrix(this.u);
        this.q.setShader(this.s);
        r21.drawRect(r15, 0.0f, r4, r23, this.q);
        this.q.setShader(null);
    L15:
        if (r22 <= r4) goto L19;
        r21.drawRect(r4, 0.0f, r22, r23, this.p);
        return;
    L19:
        return;
    }

    public /* synthetic */ AudioGradientView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
