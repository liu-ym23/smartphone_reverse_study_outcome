package com.obric.oui.popover.v2;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.loc.o;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.i;
import com.obric.oui.common.util.h;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001iB=\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0002\u0010\u0012BQ\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0013J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\fH\u0016J\u0010\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020?H\u0014J\u0006\u0010@\u001a\u00020\fJ\u000e\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020\fJ\u0006\u0010C\u001a\u00020'J\u0006\u0010D\u001a\u00020\fJ\u0018\u0010E\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\b\u0010F\u001a\u00020\u0006H\u0016J\u0006\u0010G\u001a\u00020\u0006J\b\u0010H\u001a\u00020;H\u0014J\b\u0010I\u001a\u00020;H\u0014J\u0010\u0010J\u001a\u00020;2\u0006\u0010>\u001a\u00020?H\u0015J\u0012\u0010K\u001a\u00020\u00062\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0018\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020\f2\u0006\u0010P\u001a\u00020\fH\u0015J(\u0010Q\u001a\u00020;2\u0006\u0010R\u001a\u00020\f2\u0006\u0010S\u001a\u00020\f2\u0006\u0010T\u001a\u00020\f2\u0006\u0010U\u001a\u00020\fH\u0014J\u0012\u0010V\u001a\u00020\u00062\b\u0010W\u001a\u0004\u0018\u00010MH\u0016J\u0010\u0010X\u001a\u00020;2\b\b\u0001\u0010Y\u001a\u00020\fJ\u000e\u0010Z\u001a\u00020;2\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010[\u001a\u00020;2\u0006\u0010\\\u001a\u00020\fJ\u0010\u0010]\u001a\u00020;2\b\b\u0001\u0010^\u001a\u00020'J\u000e\u0010_\u001a\u00020;2\u0006\u0010`\u001a\u00020'J\u0018\u0010a\u001a\u00020;2\u0006\u0010b\u001a\u00020\u00062\b\b\u0003\u0010Y\u001a\u00020\fJ\u000e\u0010c\u001a\u00020;2\u0006\u0010d\u001a\u00020\u0006J\b\u0010e\u001a\u00020;H\u0002J\u000e\u0010f\u001a\u00020;2\u0006\u0010g\u001a\u00020'J\b\u0010h\u001a\u00020;H\u0002R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u00020\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.R\u000e\u00108\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverLayout;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/common/style/ODynamicThemeWidget;", "context", "Landroid/content/Context;", "enableMaterialByUser", "", "materials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "materialSrcType", "", "(Landroid/content/Context;ZLkotlin/jvm/functions/Function1;I)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;IZLkotlin/jvm/functions/Function1;I)V", "appliedMaterialSrcType", "appliedMaterials", "borderColor", "borderWidth", "colorEvaluator", "Landroid/animation/ArgbEvaluator;", "coverColor", "coverColorOnAnimStart", "coverEnabled", "currentCoverColor", "enableMaterial", "fillPaintAnimator", "Landroid/animation/ValueAnimator;", "mBgColor", "getMBgColor", "()I", "setMBgColor", "(I)V", "mCornerRadius", "", "mFillPaint", "Landroid/graphics/Paint;", "mHeight", "getMHeight", "()F", "setMHeight", "(F)V", "mPath", "Landroid/graphics/Path;", "mRoundRect", "Landroid/graphics/Rect;", "mRoundRectF", "Landroid/graphics/RectF;", "mWidth", "getMWidth", "setMWidth", "pressStateColor", "strokePaint", "applyDynamicTheme", "", "themeStyle", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "getArrowHeight", "getBubbleOffset", "gravity", "getCornerRadius", "getPadding", CommonConsts.APM_INNER_EVENT_COST_INIT, "isDarkTheme", "isEnableMaterial", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", o.g, "oldw", "oldh", "onTouchEvent", "event", "setBgColor", TypedValues.Custom.S_COLOR, "setBorderColor", "setBorderWidth", "width", "setCornerRadius", "cornerRadius", "setCornerRadiusDp", "cornerRadiusDp", "setCovered", "covered", "setTransparentBg", "transparent", "startFillPaintFadeIfNeeded", "updateCoverAnimFraction", "fraction", "updateMaterial", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14348a = null;
    private static int w;
    private static float x;
    private static int y;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f14349b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private final ArgbEvaluator g;
    private Paint h;
    private Path i;
    private Rect j;
    private RectF k;
    private float l;
    private float m;
    private int n;
    private int o;
    private int p;
    private int q;
    private Paint r;
    private boolean s;
    private boolean t;
    private Function1<? super Boolean, com.obric.oui.material.c[]> u;
    private int v;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverLayout$Companion;", "", "()V", "ARROW_PADDING", "", "getARROW_PADDING", "()I", "setARROW_PADDING", "(I)V", "BOTTOM", "CORNER_RADIUS_DP", "", "getCORNER_RADIUS_DP", "()F", "setCORNER_RADIUS_DP", "(F)V", "DEFAULT_HEIGHT", "getDEFAULT_HEIGHT", "setDEFAULT_HEIGHT", "LEFT", "MIN_ARROW_DISTANCE_DP", "getMIN_ARROW_DISTANCE_DP", "setMIN_ARROW_DISTANCE_DP", "RIGHT", "TAG", "", "TOP", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final float a() {
            return OPopoverLayout.c();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/popover/v2/OPopoverLayout$init$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OPopoverLayout f14350a;

        b(OPopoverLayout r1) {
            this.f14350a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r4, Outline r5) {
            if (r4 == null) goto L9;
            OPopoverLayout r3 = this.f14350a;
            int r0 = (int) (OPopoverLayout.a(r3) / 2.0f);
            OPopoverLayout.b(r3).set(r0, r0, r4.getWidth() - r0, r4.getHeight() - r0);
            OPopoverLayout.c(r3).set(OPopoverLayout.b(r3));
            if (r5 == null) goto L10;
            r5.setRoundRect(OPopoverLayout.b(r3), OPopoverLayout.d(r3));
            return;
        L10:
            return;
        }
    }

    static {
        f14348a = new a(null);
        x = 28.0f;
        y = 36;
    }

    public OPopoverLayout(Context r12, AttributeSet r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, true, null, 0, 48, null);
    }

    public OPopoverLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f14349b = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), x);
        this.d = Color.parseColor("#20000000");
        this.f = this.e;
        this.g = new ArgbEvaluator();
        this.j = new Rect();
        this.k = new RectF();
        this.s = true;
        this.u = MaterialToken.OUI_Bg_Popup;
        this.v = 3;
        a(r6, r7);
    }

    public OPopoverLayout(Context r3, AttributeSet r4, int r5, boolean r6, Function1<? super Boolean, com.obric.oui.material.c[]> r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, com.obric.oui.material.c[]> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "materials");
        super(r9, r10, r5);
        this.f14349b = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), x);
        this.d = Color.parseColor("#20000000");
        this.f = this.e;
        this.g = new ArgbEvaluator();
        this.j = new Rect();
        this.k = new RectF();
        this.s = true;
        this.u = MaterialToken.OUI_Bg_Popup;
        this.v = 3;
        this.s = r6;
        this.u = r11;
        this.v = r8;
        a(r9, r10);
    }

    public /* synthetic */ OPopoverLayout(Context r10, AttributeSet r11, int r12, boolean r13, Function1 r14, int r15, int r16, DefaultConstructorMarker r17) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Function1<Boolean, com.obric.oui.material.c[]> r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        if ((r16 & 8) == 0) goto L5;
        boolean r6 = true;
    L7:
        if ((r16 & 16) == 0) goto L9;
        r0 = MaterialToken.OUI_Bg_Popup;
    L9:
        Function1<Boolean, com.obric.oui.material.c[]> r7 = r0;
        if ((r16 & 32) == 0) goto L12;
        int r8 = 3;
    L13:
        this(r3, r4, r12, r6, r7, r8);
        return;
    L12:
        r8 = r15;
        goto L13
    L5:
        r6 = r13;
        goto L7
    }

    public OPopoverLayout(Context r10, boolean r11, Function1<? super Boolean, com.obric.oui.material.c[]> r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r7, "materials");
        this(r3, null, 0, r11, r7, r13);
    }

    public static final /* synthetic */ int a(OPopoverLayout r0) {
        return r0.p;
    }

    public static /* synthetic */ void a(OPopoverLayout r0, boolean r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = Color.parseColor("#20000000");
    L5:
        r0.a(r1, r2);
    }

    public static final /* synthetic */ Rect b(OPopoverLayout r0) {
        return r0.j;
    }

    public static final /* synthetic */ float c() {
        return x;
    }

    public static final /* synthetic */ RectF c(OPopoverLayout r0) {
        return r0.k;
    }

    public static final /* synthetic */ float d(OPopoverLayout r0) {
        return r0.f14349b;
    }

    private final void d() {
        if (this.s == true) goto L6;
        return;
    L6:
        if (this.t == true) goto L8;
        return;
    L8:
        com.obric.oui.material.c[] r4 = (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(this.u.invoke(Boolean.valueOf(!a())), com.obric.oui.material.c[].class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4, false, this.v, null, 10, null);
        return;
    }

    public final void a(Context r7, AttributeSet r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        this.h = new Paint();
        this.i = new Path();
        Paint r11 = this.h;
        Paint r0 = null;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r11 = null;
    L5:
        r11.setStyle(Paint.Style.FILL);
        Paint r12 = this.h;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r12 = null;
    L8:
        r12.setStrokeCap(Paint.Cap.BUTT);
        Paint r13 = this.h;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r13 = null;
    L11:
        boolean r3 = true;
        r13.setAntiAlias(true);
        Paint r14 = this.h;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r14 = null;
    L14:
        r14.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.n = ContextCompat.getColor(r9, ZeusTransformUtils.mapRes(R.color.oui_bg_base_3, TypedValues.Custom.S_COLOR, "oui_bg_base_3"));
    L17:
        Paint r15 = this.h;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L21:
        r0.setColor(getMBgColor());
        setClipChildren(false);
        setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(new b(this), ViewOutlineProvider.class, "com.obric.memorydata.plugin"));
        setClipToOutline(true);
        setBackgroundColor(0);
        if (l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == true) goto L24;
    L26:
        r3 = false;
    L27:
        this.t = r3;
        d();
        return;
    L24:
        if (OMaterialHelper.d() == false) goto L26;
    L20:
        r0 = r15;
        goto L21
    }

    public final void a(boolean r1, int r2) {
        this.c = r1;
        this.d = r2;
        this.f = this.e;
        invalidate();
    }

    public boolean a() {
        if (getMBgColor() != 0) goto L7;
        return i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    L7:
        return com.obric.oui.color.d.a(getMBgColor());
    }

    public final boolean b() {
        if (this.t == true) goto L5;
    L7:
        return false;
    L5:
        if (this.s == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.dispatchDraw(r4);
        if (this.c == true) goto L5;
        return;
    L5:
        RectF r0 = this.k;
        Paint r1 = new Paint(1);
        r1.setColor(this.e);
        float r3 = this.f14349b;
        r4.drawRoundRect(r0, r3, r3, r1);
    }

    public final int getArrowHeight() {
        return w;
    }

    public final float getCornerRadius() {
        return this.f14349b;
    }

    public final int getMBgColor() {
        int r0 = this.o;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return this.n;
    }

    public final float getMHeight() {
        return this.m;
    }

    public final float getMWidth() {
        return this.l;
    }

    public final int getPadding() {
        return w / 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OMaterialHelper.b(this, this.v);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OMaterialHelper.b(this, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        Paint r1 = null;
        if (this.t == true) goto L12;
        Paint r0 = this.h;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r0 = null;
    L7:
        r0.setColor(getMBgColor());
        RectF r2 = this.k;
        float r3 = this.f14349b;
        Paint r4 = this.h;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L11:
        r6.drawRoundRect(r2, r3, r3, r1);
    L17:
        Paint r5 = this.r;
        if (r5 != null) goto L21;
        return;
    L21:
        if (this.p <= 0) goto L24;
        RectF r7 = this.k;
        float r8 = this.f14349b;
        r6.drawRoundRect(r7, r8, r8, r5);
        return;
    L24:
        return;
    L10:
        r1 = r4;
        goto L11
    L12:
        Paint r9 = this.h;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L16:
        r1.getAlpha();
        goto L17
    L15:
        r1 = r9;
        goto L16
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.c == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onInterceptTouchEvent(r2) == true) goto L8;
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.l = getMeasuredWidth();
        this.m = getMeasuredHeight();
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.c == false) goto L6;
        return true;
    L6:
        return super.onTouchEvent(r2);
    }

    public final void setBgColor(int r2) {
        if (getMBgColor() != r2) goto L5;
        return;
    L5:
        this.n = r2;
        Paint r3 = this.h;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r3 = null;
    L8:
        r3.setColor(getMBgColor());
        d();
    }

    public final void setBorderColor(int r2) {
        this.q = r2;
        if (this.r != null) goto L5;
        this.r = new Paint(1);
    L5:
        Paint r3 = this.r;
        if (r3 == null) goto L10;
        r3.setColor(this.q);
        return;
    }

    public final void setBorderWidth(int r4) {
        if (r4 > 0) goto L4;
        return;
    L4:
        this.p = r4;
        if (this.r != null) goto L7;
        this.r = new Paint(1);
    L7:
        Paint r5 = this.r;
        if (r5 == null) goto L12;
        r5.setStyle(Paint.Style.STROKE);
        r5.setStrokeWidth(this.p);
        r5.setStrokeCap(Paint.Cap.BUTT);
        r5.setStrokeJoin(Paint.Join.MITER);
        r5.setAntiAlias(true);
        r5.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER), Xfermode.class, "com.obric.memorydata.plugin"));
        r5.setColor(this.q);
        return;
    }

    public final void setCornerRadius(float r1) {
        this.f14349b = r1;
    }

    public final void setCornerRadiusDp(float r3) {
        this.f14349b = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setMBgColor(int r1) {
        this.n = r1;
    }

    public final void setMHeight(float r1) {
        this.m = r1;
    }

    public final void setMWidth(float r1) {
        this.l = r1;
    }

    public final void setTransparentBg(boolean r2) {
        setClipToOutline(!r2);
        if (r2 == false) goto L5;
        this.n = 0;
    L5:
        invalidateOutline();
        invalidate();
    }
}
