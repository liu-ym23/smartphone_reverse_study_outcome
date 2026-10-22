package com.obric.aiproactive.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 L2\u00020\u0001:\u0002LMB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J\u000e\u00106\u001a\u0002042\u0006\u00107\u001a\u00020)J\u000e\u00108\u001a\u0002042\u0006\u00109\u001a\u00020:J\u0016\u0010;\u001a\u0002042\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u000bJ\u000e\u0010>\u001a\u00020)2\u0006\u0010=\u001a\u00020\u000bJ\u0010\u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020AH\u0014J\u0010\u0010B\u001a\u0002042\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010C\u001a\u0002042\u0006\u0010@\u001a\u00020AH\u0002J(\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000bH\u0002J\b\u0010F\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0016\u0010\u000fR\u001b\u0010\u0018\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u0019\u0010\u000fR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u000602R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010I\u001a\u00020\u000b*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/obric/aiproactive/ui/widget/RequirementVoiceOverlayView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "", "scaledDensity", "normalBaseColor", "getNormalBaseColor", "()I", "normalBaseColor$delegate", "Lkotlin/Lazy;", "cancelBaseColor", "getCancelBaseColor", "cancelBaseColor$delegate", "cancelCoverColor", "getCancelCoverColor", "cancelCoverColor$delegate", "cancelTintColor", "getCancelTintColor", "cancelTintColor$delegate", "fallbackGlowPaint", "Landroid/graphics/Paint;", "textPaint", "barPaint", "barPhases", "", "", "[[F", "locationOnScreen", "", "glowShader", "Landroid/graphics/RuntimeShader;", "glowShaderPaint", "cancelling", "", "animating", "amplitude", "startedAt", "", "highlightX", "highlightY", "highlightVisible", "glowSurfaceView", "Lcom/obric/aiproactive/ui/widget/RequirementVoiceOverlayView$GlowSurfaceView;", "show", "", "hide", "setCancelling", EventBody.KEY_VALUE, "updateAudioData", "data", "", "updateTouchPosition", "rawX", "rawY", "shouldCancel", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawTip", "drawSpectrum", "spectrumHeight", "index", "elapsedSeconds", "minHeight", "maxHeight", "dp", "getDp", "(F)F", "Companion", "GlowSurfaceView", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RequirementVoiceOverlayView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6921a = null;
    private static final float[] w = null;
    private static final float[] x = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f6922b;
    private final float c;
    private final Lazy d;
    private final Lazy e;
    private final Lazy f;
    private final Lazy g;
    private final Paint h;
    private final Paint i;
    private final Paint j;
    private final float[][] k;
    private final int[] l;
    private final RuntimeShader m;
    private final Paint n;
    private boolean o;
    private boolean p;
    private float q;
    private long r;
    private float s;
    private float t;
    private boolean u;
    private final b v;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/aiproactive/ui/widget/RequirementVoiceOverlayView$Companion;", "", "<init>", "()V", "GLOW_HEIGHT_DP", "", "GLOW_RECT_HEIGHT_DP", "GLOW_RADIUS_RATIO", "GLOW_BLUR_DP", "HIGHLIGHT_RADIUS_DP", "BAR_COUNT", "", "BAR_WIDTH_DP", "BAR_GAP_DP", "BAR_MIN_HEIGHT_DP", "BAR_MAX_HEIGHT_DP", "BAR_BOTTOM_MARGIN_DP", "BAR_CONTAINER_HEIGHT_DP", "TIP_BOTTOM_MARGIN_DP", "NORMAL_COVER_COLOR", "NORMAL_NOISE_COLOR", "NORMAL_TIP_COLOR", "SPECTRUM_DRIVE", "SPECTRUM_CURVE", "SPECTRUM_ENVELOPE_CENTER", "SPECTRUM_ENVELOPE_EDGE", "SPECTRUM_LAYER_SPEEDS", "", "SPECTRUM_LAYER_AMPLITUDES", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/widget/RequirementVoiceOverlayView$GlowSurfaceView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Lcom/obric/aiproactive/ui/widget/RequirementVoiceOverlayView;Landroid/content/Context;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class b extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequirementVoiceOverlayView f6923a;

        public b(RequirementVoiceOverlayView r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "context");
            this.f6923a = r3;
            super(r5);
            setLayerType(2, null);
        }

        @Override // android.view.View
        public void onDraw(Canvas r12) {
            Intrinsics.checkNotNullParameter(r12, "canvas");
            super.onDraw(r12);
            float r5 = (getHeight() - RequirementVoiceOverlayView.a(this.f6923a, 160.0f)) + (getWidth() * 0.8f);
            RuntimeShader r0 = RequirementVoiceOverlayView.a(this.f6923a);
            if (r0 != null) goto L5;
        L23:
            float r1 = getWidth() * 0.8f;
            if (RequirementVoiceOverlayView.e(this.f6923a) == false) goto L26;
            int[] r2 = {RequirementVoiceOverlayView.i(this.f6923a), RequirementVoiceOverlayView.k(this.f6923a), 0};
        L27:
            RequirementVoiceOverlayView.m(this.f6923a).setShader((Shader) ZeusTransformUtils.preCheckCast(new RadialGradient(getWidth() / 2.0f, r5, r1 + RequirementVoiceOverlayView.a(this.f6923a, 30.0f), r2, new float[]{0.0f, 0.74f, 1.0f}, Shader.TileMode.CLAMP), Shader.class, "com.obric.memorydata.plugin"));
            Paint r3 = RequirementVoiceOverlayView.m(this.f6923a);
        L28:
            r12.drawPaint(r3);
            if (RequirementVoiceOverlayView.n(this.f6923a) == false) goto L32;
            postInvalidateOnAnimation();
            return;
        L32:
            return;
        L26:
            r2 = new int[]{RequirementVoiceOverlayView.j(this.f6923a), -865714717, 0};
            goto L27
        L5:
            if (Build.VERSION.SDK_INT < 33) goto L23;
            r0.setFloatUniform("uResolution", getWidth(), getHeight());
            r0.setFloatUniform("uTime", RequirementVoiceOverlayView.b(this.f6923a));
            r0.setFloatUniform("uDensity", RequirementVoiceOverlayView.c(this.f6923a));
            r0.setFloatUniform("uCenterY", r5);
            r0.setFloatUniform("uVolume", RequirementVoiceOverlayView.d(this.f6923a));
            r0.setFloatUniform("uRadiusRatio", 0.8f);
            float r4 = 1.0f;
            r0.setFloatUniform("uScale", 1.0f);
            r0.setFloatUniform("uBlurRadius", RequirementVoiceOverlayView.a(this.f6923a, 30.0f));
            if (RequirementVoiceOverlayView.e(this.f6923a) == false) goto L9;
            float r6 = 0.0f;
        L10:
            r0.setFloatUniform("uEffectShow", r6);
            r0.setFloatUniform("uHighlightPos", RequirementVoiceOverlayView.f(this.f6923a), RequirementVoiceOverlayView.g(this.f6923a) - (this.f6923a.getHeight() - getHeight()));
            if (RequirementVoiceOverlayView.h(this.f6923a) == true) goto L14;
            r4 = 0.0f;
        L14:
            r0.setFloatUniform("uHighlightShow", r4);
            r0.setFloatUniform("uHighlightRadius", RequirementVoiceOverlayView.a(this.f6923a, 240.0f));
            if (RequirementVoiceOverlayView.e(this.f6923a) == false) goto L17;
            int r7 = RequirementVoiceOverlayView.i(this.f6923a);
        L18:
            r0.setColorUniform("uBaseColor", r7);
            if (RequirementVoiceOverlayView.e(this.f6923a) == false) goto L21;
            int r8 = RequirementVoiceOverlayView.k(this.f6923a);
        L22:
            r0.setColorUniform("uCoverColor", r8);
            r0.setColorUniform("uNoiseColor", -10076701);
            r0.setColorUniform("uParticleColor", -1);
            r0.setColorUniform("uHighlightColor", -15840591);
            r3 = RequirementVoiceOverlayView.l(this.f6923a);
            goto L28
        L21:
            r8 = -6562561;
            goto L22
        L17:
            r7 = RequirementVoiceOverlayView.j(this.f6923a);
            goto L18
        L9:
            r6 = 1.0f;
            goto L10
        }
    }

    static {
        f6921a = new a(null);
        w = new float[]{5.5f, 9.8f, 14.2f, 3.7f, 19.5f};
        x = new float[]{1.0f, 0.8f, 0.6f, 0.7f, 0.4f};
    }

    public RequirementVoiceOverlayView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public RequirementVoiceOverlayView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public RequirementVoiceOverlayView(Context r10, AttributeSet r11, int r12) {
        final Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r12);
        this.f6922b = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        float r15 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().scaledDensity;
        this.c = r15;
        this.d = LazyKt.lazy(new $$Lambda$RequirementVoiceOverlayView$Kq5SLY9FrfKDPtswyRZKjArZzgE(r13));
        this.e = LazyKt.lazy(new $$Lambda$RequirementVoiceOverlayView$4lS1jfhjWFP1hicTVnfA0yUG7Q(r13));
        this.f = LazyKt.lazy(new $$Lambda$RequirementVoiceOverlayView$oO2To_y6yPdyjBOJxvNcuVVNTyw(r13));
        this.g = LazyKt.lazy(new $$Lambda$RequirementVoiceOverlayView$YqZwY7AvUIZ86CXWgNqqQRMOWF8(r13));
        this.h = new Paint(1);
        Paint r16 = new Paint(1);
        r16.setTypeface(Typeface.create("Olasans-sc-compact", 1));
        r16.setTextAlign(Paint.Align.CENTER);
        r16.setTextSize(r15 * 14.0f);
        this.i = r16;
        this.j = new Paint(1);
        int r17 = w.length;
        float[][] r18 = new float[r17][];
        int r3 = 0;
    L3:
        if (r3 >= r17) goto L8;
        float[] r5 = new float[36];
        int r6 = 0;
    L5:
        if (r6 >= 36) goto L7;
        r5[r6] = Random.Default.nextFloat() * 6.2831855f;
        r6 = r6 + 1;
        goto L5
    L7:
        r18[r3] = r5;
        r3 = r3 + 1;
        goto L3
    L8:
        this.k = r18;
        this.l = new int[2];
        if (Build.VERSION.SDK_INT < 33) goto L11;
        RuntimeShader r19 = new RuntimeShader("\n        uniform float2 uResolution;\n        uniform float  uDensity;\n        uniform float  uTime;\n        uniform float  uCenterY;\n        uniform float  uVolume;\n\n        layout(color) uniform half4 uBaseColor;\n        layout(color) uniform half4 uCoverColor;\n        layout(color) uniform half4 uHighlightColor;\n\n        uniform float  uRadiusRatio;\n        uniform float  uScale;\n        uniform float  uBlurRadius;\n\n        uniform float  uHighlightRadius;\n        uniform float2 uHighlightPos;\n        uniform float  uHighlightShow;\n\n        uniform float  uEffectShow;\n        layout(color) uniform half4 uParticleColor;\n        layout(color) uniform half4 uNoiseColor;\n\n        const float TAU                    = 6.28318;\n        const float VOLUME_GAIN            = 0.15;\n        const float PARTICLE_DENSITY       = 32.0;\n\n        float erfApprox(float x) {\n            float ax = abs(x);\n            float t = 1.0 / (1.0 + 0.3275911 * ax);\n            float y = 1.0 - (((((1.061405429 * t - 1.453152027) * t)\n                + 1.421413741) * t - 0.284496736) * t + 0.254829592)\n                * t * exp(-ax * ax);\n            return x >= 0.0 ? y : -y;\n        }\n\n        float gaussianEdge(float dist, float sigma) {\n            return 0.5 - 0.5 * erfApprox(dist / (sigma * 1.4142135));\n        }\n\n        float sdCircle(float2 p, float r) {\n            return length(p) - r;\n        }\n\n        float interleavedNoise(float2 p) {\n            float2 pixel = floor(p);\n            return fract(52.9829189 * fract(\n                0.06711056 * pixel.x + 0.00583715 * pixel.y));\n        }\n\n        float2 hash2(float2 p) {\n            p = float2(dot(p, float2(127.1, 311.7)),\n                       dot(p, float2(269.5, 183.3)));\n            return fract(sin(p) * 43758.5453);\n        }\n\n        int imod(int a, int b) { return a - (b * (a / b)); }\n\n        int3 imod3(int3 a, int b) {\n            return int3(imod(a.x, b), imod(a.y, b), imod(a.z, b));\n        }\n\n        float3 hash3d(float3 p) {\n            int3 v = int3(p);\n            v = v * 1671731 + 10139267;\n            v.x += v.y * v.z;\n            v.y += v.z * v.x;\n            v.z += v.x * v.y;\n            int3 v2 = v / 65536;\n            v = imod3(10 - imod3(v + v2, 10), 10);\n            v.x += v.y * v.z;\n            v.y += v.z * v.x;\n            v.z += v.x * v.y;\n            return float3(sin(float(v.x)), cos(float(v.y)), sin(float(v.z)));\n        }\n\n        const float SKEW = 0.3333333;\n        const float UNSKEW = 0.1666667;\n\n        float simplex3d(float3 p) {\n            float3 s = floor(p + (p.x + p.y + p.z) * SKEW);\n            float3 u = s - (s.x + s.y + s.z) * UNSKEW;\n            float3 c0 = p - u;\n            float3 en = c0 - float3(c0.y, c0.z, c0.x);\n            en = step(float3(0.0), en);\n            float3 offset1 = en * (1.0 - float3(en.z, en.x, en.y));\n            float3 offset2 = 1.0 - float3(en.z, en.x, en.y) * (1.0 - en);\n            float3 c1 = c0 - offset1 + UNSKEW;\n            float3 c2 = c0 - offset2 + UNSKEW * 2.0;\n            float3 c3 = c0 - float3(1.0) + UNSKEW * 3.0;\n            float4 w;\n            w.x = dot(c0, c0);\n            w.y = dot(c1, c1);\n            w.z = dot(c2, c2);\n            w.w = dot(c3, c3);\n            w = max(0.6 - w, 0.0);\n            float4 nc;\n            nc.x = dot(hash3d(s), c0);\n            nc.y = dot(hash3d(s + offset1), c1);\n            nc.z = dot(hash3d(s + offset2), c2);\n            nc.w = dot(hash3d(s + float3(1.0)), c3);\n            nc *= w * w * w * w;\n            return dot(float4(32.0), nc);\n        }\n\n        const float JITTER_SPEED   = 2.0;\n        const float JITTER_AMOUNT  = 0.15;\n        const float TWINKLE_SPEED  = 2.0;\n        const float TWINKLE_AMOUNT = 1.0;\n\n        float particle(float2 grid, float sqrtR, float sizePx, float radius) {\n            float2 id = floor(grid);\n            float2 local = fract(grid) - 0.5;\n            float2 jitter = (hash2(id) - 0.5) * 0.6\n                + sin(uTime * (hash2(id + 0.5) - 0.5) * JITTER_SPEED)\n                  * JITTER_AMOUNT;\n            float dPx = length((local - jitter) * float2(\n                sqrtR * sqrtR * TAU / PARTICLE_DENSITY,\n                2.0 * sqrtR / PARTICLE_DENSITY)) * radius;\n            float alpha = step(dPx, max(sizePx, 0.5) * 0.6);\n            float phase = hash2(id).x;\n            alpha *= mix(1.0,\n                sin(uTime * TWINKLE_SPEED + phase * TAU) * 0.5 + 0.5,\n                TWINKLE_AMOUNT);\n            return alpha;\n        }\n\n        const float DITHER_MIN_INTENSITY = 0.35;\n        const float DITHER_BLUR_RATIO    = 0.015;\n\n        float glowShape(float2 p) {\n            float glowScale = uScale + uVolume * VOLUME_GAIN;\n            float radius = uResolution.x * uRadiusRatio;\n            float r = radius * glowScale;\n            float blurSigma = uBlurRadius * glowScale;\n            float glowDist = sdCircle(p, r);\n            float ditherIntensity = max(DITHER_MIN_INTENSITY, blurSigma * DITHER_BLUR_RATIO);\n            float ditherOffset = (interleavedNoise(p) - 0.5) * ditherIntensity;\n            return gaussianEdge(glowDist + ditherOffset, blurSigma);\n        }\n\n        const float NOISE_SCALE    = 0.1;\n        const float NOISE_CONTRAST = 0.0;\n        const float NOISE_SPEED    = 0.5;\n        const float NOISE_BALANCE  = 0.5;\n\n        float noiseMask(float2 p) {\n            float2 noiseUV = p / uResolution.y;\n            float n = simplex3d(float3(\n                noiseUV * exp(NOISE_SCALE),\n                uTime * NOISE_SPEED));\n            return clamp(\n                (n * (NOISE_CONTRAST + 1.0) + NOISE_BALANCE) * 0.5 + 0.5,\n                0.0, 1.0);\n        }\n\n        float4 colorLayer(half4 color) {\n            float alpha = float(color.a);\n            return float4(\n                float(color.r) * alpha,\n                float(color.g) * alpha,\n                float(color.b) * alpha,\n                alpha);\n        }\n\n        float4 bodyColor(float nMask) {\n            float4 baseColor = colorLayer(uBaseColor);\n            if (uEffectShow < 0.5) return baseColor;\n            return mix(colorLayer(uNoiseColor), baseColor, nMask);\n        }\n\n        const float GOLDEN_ANGLE = 0.618034;\n        const float EMIT_SPEED   = 0.012;\n        const float PARTICLE_INNER_SIZE_DP = 1.2;\n        const float PARTICLE_OUTER_SIZE_DP = 0.6;\n        const float PARTICLE_WARP_DP       = 120.0;\n\n        float particleMask(float2 p, float2 highlightP) {\n            if (uEffectShow < 0.5) return 0.0;\n\n            float radius = uResolution.x * uRadiusRatio;\n\n            float2 highlightDir = p - highlightP;\n            float highlightDist2 = dot(highlightDir, highlightDir);\n            float highlightRadius2 = uHighlightRadius * uHighlightRadius;\n            float2 warpedP = p - highlightDir * (PARTICLE_WARP_DP * uDensity)\n                * uHighlightShow\n                * exp(-2.0 * highlightDist2 / highlightRadius2)\n                / uHighlightRadius;\n\n            float2 pOffset = warpedP / radius;\n            float pAngle = atan(pOffset.y, pOffset.x) / TAU + 0.5;\n            float pRadius = length(pOffset);\n            float sqrtR = sqrt(pRadius);\n            float2 polarGrid = float2(pAngle, sqrtR) * PARTICLE_DENSITY;\n            float radialT = clamp(pRadius, 0.0, 1.0);\n            float currentSizePx = mix(\n                PARTICLE_INNER_SIZE_DP, PARTICLE_OUTER_SIZE_DP, radialT) * uDensity;\n\n            float total = 0.0;\n            float layerAlpha = 1.0;\n            for (int i = 0; i < 4; i++) {\n                float fi = float(i);\n                float2 scroll = float2(\n                    fi * GOLDEN_ANGLE,\n                    -EMIT_SPEED * uTime * (1.0 + fi * 0.3));\n                float2 offset = hash2(float2(fi, fi * 7.919)) * 10.0;\n                total += particle(\n                    polarGrid * (1.0 + fi * 0.05)\n                        + scroll * PARTICLE_DENSITY + offset,\n                    sqrtR, currentSizePx, radius) * layerAlpha;\n                layerAlpha *= 0.9;\n            }\n\n            return min(total, 1.0);\n        }\n\n        float4 particleColor(float nMask) {\n            return mix(colorLayer(uNoiseColor), colorLayer(uParticleColor), nMask);\n        }\n\n        float4 highlightSpot(float2 p, float2 highlightP) {\n            if (uEffectShow < 0.5) return float4(0.0);\n            float2 delta = p - highlightP;\n            float dist2 = dot(delta, delta);\n            float field = exp(-4.0 * dist2\n                / (uHighlightRadius * uHighlightRadius)) * uHighlightShow;\n            return colorLayer(uHighlightColor) * field;\n        }\n\n        const float2 COVER_SCALE        = float2(1.0, 0.5);\n        const float2 COVER_SCALE_SILENT = float2(2.0, 0.4);\n\n        float4 coverLayer(float2 p) {\n            float2 scale = mix(COVER_SCALE_SILENT, COVER_SCALE, uEffectShow);\n            float radius = uResolution.x * uRadiusRatio;\n            float bx = p.x / (radius * scale.x);\n            float xFall = exp(-bx * bx * 1.5);\n            float domeH = radius * scale.y * xFall;\n            float by = p.y / max(domeH, 1.0);\n            float hl = xFall * exp(-by * by);\n            float hlGain = 1.0 + uVolume * VOLUME_GAIN * 8.0;\n            return colorLayer(uCoverColor) * hl * hlGain;\n        }\n\n        half4 main(float2 fragCoord) {\n            float2 origin = float2(uResolution.x * 0.5, uCenterY);\n            float2 p = fragCoord - origin;\n            float2 highlightP = uHighlightPos - origin;\n\n            float shape = glowShape(p);\n            float nMask = noiseMask(p);\n            float pMask = particleMask(p, highlightP);\n\n            float4 body = bodyColor(nMask);\n            float4 particles = particleColor(nMask);\n            float4 overlays = highlightSpot(p, highlightP) + coverLayer(p);\n\n            float4 color = mix(body, particles, pMask) + overlays;\n            float alpha = clamp(color.a, 0.0, 1.0);\n            return half4(color.rgb * shape, alpha * shape);\n        }\n    ");
    L12:
        this.m = r19;
        Paint r2 = new Paint();
        r2.setShader((Shader) ZeusTransformUtils.preCheckCast(r19, Shader.class, "com.obric.memorydata.plugin"));
        this.n = r2;
        this.q = 0.08f;
        b r110 = new b(this, r13);
        this.v = r110;
        setLayerType(2, null);
        setClipChildren(true);
        View r111 = (View) ZeusTransformUtils.preCheckCast(r110, View.class, "com.obric.memorydata.plugin");
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-1, MathKt.roundToInt(b(250.0f)));
        r112.gravity = 80;
        Unit r113 = Unit.INSTANCE;
        addView(r111, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r112, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        r19 = null;
        goto L12
    }

    public /* synthetic */ RequirementVoiceOverlayView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final float a(int r8, float r9, float r10, float r11) {
        int r0 = w.length;
        float r1 = 0.0f;
        int r3 = 0;
        float r2 = 0.0f;
    L3:
        if (r3 >= r0) goto L6;
        float r4 = x[r3];
        r1 = r1 + (((float) Math.sin((w[r3] * r9) + this.k[r3][r8])) * r4);
        r2 = r2 + r4;
        r3 = r3 + 1;
        goto L3
    L6:
        return Math.min(r11, r10 + (((r11 - r10) * ((float) Math.pow(((RangesKt.coerceIn(r1 * 1.7f, -r2, r2) / r2) * 0.5f) + 0.5f, 1.6f))) * (((Math.abs((r8 / 35) - 0.5f) * 2.0f) * (-0.5f)) + 1.0f)));
    }

    public static final /* synthetic */ float a(RequirementVoiceOverlayView r0, float r1) {
        return r0.b(r1);
    }

    private static final int a(Context r3) {
        return ContextCompat.getColor((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_requirement_send_enabled_bg, TypedValues.Custom.S_COLOR, "ai_proactive_requirement_send_enabled_bg"));
    }

    public static final /* synthetic */ RuntimeShader a(RequirementVoiceOverlayView r0) {
        return r0.m;
    }

    private final void a(Canvas r5) {
        Paint r0 = this.i;
        if (this.o == false) goto L5;
        int r1 = getCancelTintColor();
    L6:
        r0.setColor(r1);
        if (this.o == false) goto L9;
        String r2 = "松手取消";
    L10:
        r5.drawText(r2, getWidth() / 2.0f, (getHeight() - b(70.0f)) - this.i.getFontMetrics().bottom, this.i);
        return;
    L9:
        r2 = "松手发送，上移取消";
        goto L10
    L5:
        r1 = -1291845633;
        goto L6
    }

    private final float b(float r1) {
        return r1 * this.f6922b;
    }

    public static final /* synthetic */ float b(RequirementVoiceOverlayView r0) {
        return r0.c();
    }

    private static final int b(Context r3) {
        return ContextCompat.getColor((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_voice_cancel_base, TypedValues.Custom.S_COLOR, "ai_proactive_voice_cancel_base"));
    }

    private final void b(Canvas r29) {
        float r1 = b(2.4f);
        float r2 = b(3.6f);
        float r4 = (36 * r1) + (35 * r2);
        float r5 = (getHeight() - b(12.0f)) - (b(56.0f) / 2.0f);
        float r6 = (getWidth() - r4) / 2.0f;
        float r15 = b(7.0f);
        float r14 = b(24.0f);
        float r13 = c();
        float r16 = RangesKt.coerceIn(this.q, 0.0f, 1.0f);
        Paint r11 = this.j;
        if (this.o == false) goto L5;
        float r7 = 1.0f;
        Class<Shader> r8 = Shader.class;
        LinearGradient r9 = new LinearGradient(r6, 0.0f, r4 + r6, 0.0f, new int[]{654258995, getCancelTintColor(), getCancelTintColor(), 654258995}, new float[]{0.0f, 0.167f, 0.833f, 1.0f}, Shader.TileMode.CLAMP);
    L6:
        r11.setShader((Shader) ZeusTransformUtils.preCheckCast(r9, r8, "com.obric.memorydata.plugin"));
        int r3 = 0;
    L7:
        if (r3 >= 36) goto L9;
        float r10 = r13;
        float r21 = r6 + (r3 * (r1 + r2));
        float r17 = (r15 + ((a(r3, r10, r15, r14) - r15) * r16)) / 2.0f;
        r29.drawRoundRect(r21, r5 - r17, r21 + r1, r5 + r17, b(r7), b(r7), this.j);
        r3 = r3 + 1;
        r13 = r10;
        goto L7
    L9:
        return;
    L5:
        r7 = 1.0f;
        r8 = Shader.class;
        r9 = new LinearGradient(r6, 0.0f, r6 + r4, 0.0f, new int[]{654311423, -1, -1, 654311423}, new float[]{0.0f, 0.167f, 0.833f, 1.0f}, Shader.TileMode.CLAMP);
        goto L6
    }

    private final float c() {
        return RangesKt.coerceAtLeast(SystemClock.uptimeMillis() - this.r, 0) / 1000.0f;
    }

    public static final /* synthetic */ float c(RequirementVoiceOverlayView r0) {
        return r0.f6922b;
    }

    private static final int c(Context r3) {
        return ContextCompat.getColor((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_voice_cancel_cover, TypedValues.Custom.S_COLOR, "ai_proactive_voice_cancel_cover"));
    }

    public static final /* synthetic */ float d(RequirementVoiceOverlayView r0) {
        return r0.q;
    }

    private static final int d(Context r3) {
        return ContextCompat.getColor((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_voice_cancel_tint, TypedValues.Custom.S_COLOR, "ai_proactive_voice_cancel_tint"));
    }

    public static final /* synthetic */ boolean e(RequirementVoiceOverlayView r0) {
        return r0.o;
    }

    public static final /* synthetic */ float f(RequirementVoiceOverlayView r0) {
        return r0.s;
    }

    public static final /* synthetic */ float g(RequirementVoiceOverlayView r0) {
        return r0.t;
    }

    private final int getCancelBaseColor() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.e.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final int getCancelCoverColor() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.f.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final int getCancelTintColor() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.g.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final int getNormalBaseColor() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.d.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static final /* synthetic */ boolean h(RequirementVoiceOverlayView r0) {
        return r0.u;
    }

    public static final /* synthetic */ int i(RequirementVoiceOverlayView r0) {
        return r0.getCancelBaseColor();
    }

    public static final /* synthetic */ int j(RequirementVoiceOverlayView r0) {
        return r0.getNormalBaseColor();
    }

    public static final /* synthetic */ int k(RequirementVoiceOverlayView r0) {
        return r0.getCancelCoverColor();
    }

    public static final /* synthetic */ Paint l(RequirementVoiceOverlayView r0) {
        return r0.n;
    }

    /* JADX INFO: renamed from: lambda$4lS1jfhjWFP1hicTV-nfA0yUG7Q, reason: not valid java name */
    public static /* synthetic */ int m365lambda$4lS1jfhjWFP1hicTVnfA0yUG7Q(Context r0) {
        return b(r0);
    }

    public static /* synthetic */ int lambda$Kq5SLY9FrfKDPtswyRZKjArZzgE(Context r0) {
        return a(r0);
    }

    public static /* synthetic */ int lambda$YqZwY7AvUIZ86CXWgNqqQRMOWF8(Context r0) {
        return d(r0);
    }

    public static /* synthetic */ int lambda$oO2To_y6yPdyjBOJxvNcuVVNTyw(Context r0) {
        return c(r0);
    }

    public static final /* synthetic */ Paint m(RequirementVoiceOverlayView r0) {
        return r0.h;
    }

    public static final /* synthetic */ boolean n(RequirementVoiceOverlayView r0) {
        return r0.p;
    }

    public final void a() {
        if (getVisibility() == 0) goto L5;
    L7:
        setVisibility(0);
        this.p = true;
        this.r = SystemClock.uptimeMillis();
        setAlpha(1.0f);
        postInvalidateOnAnimation();
        return;
    L5:
        if (this.p == false) goto L7;
    }

    public final void a(float r3, float r4) {
        getLocationOnScreen(this.l);
        int[] r0 = this.l;
        this.s = r3 - r0[0];
        this.t = r4 - r0[1];
        this.u = true ^ this.o;
        this.v.invalidate();
        invalidate();
    }

    public final void a(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        int r0 = 0;
        int r1 = 0;
    L3:
        int r2 = r0 + 1;
        if (r2 >= r5.length) goto L6;
        r1 = Math.max(r1, Math.abs((short) ((r5[r2] << 8) | (r5[r0] & 255))));
        r0 = r0 + 2;
        goto L3
    L6:
        this.q = RangesKt.coerceIn(Math.max(this.q * 0.72f, RangesKt.coerceIn(r1 / 32767.0f, 0.0f, 1.0f)), 0.08f, 1.0f);
        this.v.postInvalidateOnAnimation();
        postInvalidateOnAnimation();
    }

    public final boolean a(float r4) {
        getLocationOnScreen(this.l);
        if (r4 < ((this.l[1] + getHeight()) - b(160.0f))) goto L7;
        return false;
    L7:
        return true;
    }

    public final void b() {
        if (getVisibility() == 0) goto L5;
        return;
    L5:
        setVisibility(8);
        this.p = false;
        this.q = 0.08f;
        this.u = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.dispatchDraw(r2);
        a(r2);
        b(r2);
        this.q = Math.max(0.08f, this.q * 0.94f);
        if (this.p == false) goto L6;
        this.v.postInvalidateOnAnimation();
        postInvalidateOnAnimation();
        return;
    }

    public final void setCancelling(boolean r2) {
        if (this.o != r2) goto L5;
        return;
    L5:
        this.o = r2;
        if (r2 == false) goto L8;
        this.u = false;
    L8:
        this.v.invalidate();
        invalidate();
    }
}
