package com.xiphias.browser.scanner;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020!H\u0014J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\rH\u0014J\u0006\u0010%\u001a\u00020!J\u0006\u0010&\u001a\u00020!J0\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\rH\u0014J\u0010\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020>H\u0017J\u000e\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020\u0014J\u000e\u0010A\u001a\u00020!2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010*\"\u0004\b5\u0010,¨\u0006E"}, d2 = {"Lcom/xiphias/browser/scanner/ScannerMaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "linePaint", "edgePaint", "maskColor", "", "laserColor", "resultPointColor", "laserVisibility", "", "possibleResultPoints", "", "Lcom/google/zxing/ResultPoint;", "lastPossibleResultPoints", "scanLineOffset", "", EventBody.KEY_VALUE, "laserAnimationEnabled", "getLaserAnimationEnabled", "()Z", "setLaserAnimationEnabled", "(Z)V", "animator", "Landroid/animation/ValueAnimator;", "onAttachedToWindow", "", "onDetachedFromWindow", "onWindowVisibilityChanged", "visibility", "startLaserAnimation", "stopLaserAnimation", "captureRect", "Landroid/graphics/Rect;", "getCaptureRect", "()Landroid/graphics/Rect;", "setCaptureRect", "(Landroid/graphics/Rect;)V", "captureSize", "Landroid/util/Size;", "getCaptureSize", "()Landroid/util/Size;", "setCaptureSize", "(Landroid/util/Size;)V", "realCaptureRect", "getRealCaptureRect", "setRealCaptureRect", "onLayout", "changed", "left", "top", "right", "bottom", "onDraw", "canvas", "Landroid/graphics/Canvas;", "addPossibleResultPoint", "point", "setMaskColor", "setLaserVisibility", "visible", "Companion", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScannerMaskView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16314a = null;
    private static final String q = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f16315b;
    private final Paint c;
    private final Paint d;
    private int e;
    private final int f;
    private final int g;
    private boolean h;
    private List<com.google.zxing.b> i;
    private List<com.google.zxing.b> j;
    private float k;
    private boolean l;
    private final ValueAnimator m;
    private Rect n;
    private Size o;
    private Rect p;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/xiphias/browser/scanner/ScannerMaskView$Companion;", "", "<init>", "()V", "TAG", "", "ANIMATION_DELAY", "", "CURRENT_POINT_OPACITY", "", "MAX_RESULT_POINTS", "POINT_SIZE", "CAPTURE_SIZE_RATIO", "", "REAL_CAPTURE_SIZE_RATIO", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f16314a = new a(null);
        String r0 = ScannerMaskView.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r0, "getSimpleName(...)");
        q = r0;
    }

    public ScannerMaskView(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r10, r11);
        this.f16315b = new Paint(1);
        this.c = new Paint(1);
        this.d = new Paint(1);
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r12.setDuration(2000);
        r12.setRepeatCount(-1);
        r12.addUpdateListener(new $$Lambda$ScannerMaskView$xkPo473soDsaiflTw_U_vZZvuA(this));
        Intrinsics.checkNotNullExpressionValue(r12, "apply(...)");
        this.m = r12;
        ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        TypedArray r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r11, R.styleable.ScannerMaskView);
        Intrinsics.checkNotNullExpressionValue(r13, "obtainStyledAttributes(...)");
        this.e = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.ScannerMaskView_scanner_mask, "styleable", "ScannerMaskView_scanner_mask"), ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.scanner_mask, TypedValues.Custom.S_COLOR, "scanner_mask")));
        this.f = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.ScannerMaskView_scanner_laser, "styleable", "ScannerMaskView_scanner_laser"), ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.scanner_laser, TypedValues.Custom.S_COLOR, "scanner_laser")));
        this.g = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.ScannerMaskView_scanner_possible_result_points, "styleable", "ScannerMaskView_scanner_possible_result_points"), ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.scanner_possible_result_points, TypedValues.Custom.S_COLOR, "scanner_possible_result_points")));
        this.h = r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ScannerMaskView_scanner_laser_visibility, "styleable", "ScannerMaskView_scanner_laser_visibility"), true);
        this.n = new Rect();
        this.o = new Size(0, 0);
        this.p = new Rect();
        r13.recycle();
        this.i = (List) ZeusTransformUtils.preCheckCast(new ArrayList(20), List.class, "com.obric.memorydata.plugin");
        this.j = (List) ZeusTransformUtils.preCheckCast(new ArrayList(20), List.class, "com.obric.memorydata.plugin");
    }

    private static final void a(ScannerMaskView r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.invalidate();
    }

    /* JADX INFO: renamed from: lambda$xkPo47-3soDsaiflTw_U_vZZvuA, reason: not valid java name */
    public static /* synthetic */ void m1409lambda$xkPo473soDsaiflTw_U_vZZvuA(ScannerMaskView r0, ValueAnimator r1) {
        a(r0, r1);
    }

    public final void a() {
        if (this.h == true) goto L5;
        return;
    L5:
        if (this.l == true) goto L7;
        return;
    L7:
        if (this.m.isStarted() == true) goto L12;
        this.m.start();
        return;
    }

    public final void b() {
        if (this.m.isStarted() == false) goto L6;
        this.m.cancel();
        return;
    }

    public final Rect getCaptureRect() {
        return this.n;
    }

    public final Size getCaptureSize() {
        return this.o;
    }

    public final boolean getLaserAnimationEnabled() {
        return this.l;
    }

    public final Rect getRealCaptureRect() {
        return this.p;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.l == false) goto L6;
        a();
        return;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public void onDraw(Canvas r22) {
        Intrinsics.checkNotNullParameter(r22, "canvas");
        Rect r8 = this.n;
        Size r9 = this.o;
        int r1 = getWidth();
        int r10 = getHeight();
        this.f16315b.setColor(this.e);
        float r11 = r1;
        r22.drawRect(0.0f, 0.0f, r11, r8.top, this.f16315b);
        r22.drawRect(0.0f, r8.top, r8.left, r8.bottom + 1, this.f16315b);
        r22.drawRect(r8.right + 1, r8.top, r11, r8.bottom + 1, this.f16315b);
        r22.drawRect(0.0f, r8.bottom + 1, r11, r10, this.f16315b);
        if (this.h == false) goto L5;
        Object r2 = this.m.getAnimatedValue();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Float");
        this.k = ((Float) ZeusTransformUtils.preCheckCast(r2, Float.class, "com.obric.memorydata.plugin")).floatValue() * this.o.getHeight();
        float r14 = r8.left + 2;
        float r15 = (r8.top - 3) + this.k;
        float r3 = r8.right - 1;
        float r17 = (r8.top + 3) + this.k;
        int r13 = this.f;
        this.c.setShader((Shader) ZeusTransformUtils.preCheckCast(new LinearGradient(r14, r15, r3, r17, new int[]{0, r13, r13, 0}, new float[]{0.0f, 0.2f, 0.8f, 1.0f}, Shader.TileMode.CLAMP), Shader.class, "com.obric.memorydata.plugin"));
        r22.drawRect(r8.left + 2, this.k + (r8.top - 3), r8.right - 1, this.k + (r8.top + 3), this.c);
    L5:
        this.d.setColor(-1);
        r22.drawRect(r8.left - 3, r8.top - 3, r8.left + 51, r8.top + 3, this.d);
        r22.drawRect(r8.left - 3, r8.top - 3, r8.left + 3, r8.top + 51, this.d);
        r22.drawRect(r8.right - 51, r8.top - 3, r8.right + 3, r8.top + 3, this.d);
        r22.drawRect(r8.right - 3, r8.top - 3, r8.right + 3, r8.top + 51, this.d);
        r22.drawRect(r8.left - 3, r8.bottom - 51, r8.left + 3, r8.bottom + 3, this.d);
        r22.drawRect(r8.left - 3, r8.bottom - 3, r8.left + 51, r8.bottom + 3, this.d);
        r22.drawRect(r8.right - 51, r8.bottom - 3, r8.right + 3, r8.bottom + 3, this.d);
        r22.drawRect(r8.right - 3, r8.bottom - 51, r8.right + 3, r8.bottom + 3, this.d);
        float r4 = getWidth() / r9.getWidth();
        float r5 = getHeight() / r9.getHeight();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.j, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L13;
        this.f16315b.setAlpha(80);
        this.f16315b.setColor(this.g);
        Iterator<com.google.zxing.b> r6 = this.j.iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        com.google.zxing.b r7 = (com.google.zxing.b) ZeusTransformUtils.preCheckCast(r6.next(), com.google.zxing.b.class, "com.obric.memorydata.plugin");
        r22.drawCircle((int) (r7.a() * r4), (int) (r7.b() * r5), 3.0f, this.f16315b);
        goto L9
    L11:
        this.j.clear();
    L13:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.i, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L19;
        this.f16315b.setAlpha(160);
        this.f16315b.setColor(this.g);
        Iterator<com.google.zxing.b> r12 = this.i.iterator();
    L16:
        if (r12.hasNext() == false) goto L18;
        com.google.zxing.b r16 = (com.google.zxing.b) ZeusTransformUtils.preCheckCast(r12.next(), com.google.zxing.b.class, "com.obric.memorydata.plugin");
        r22.drawCircle((int) (r16.a() * r4), (int) (r16.b() * r5), 6.0f, this.f16315b);
        goto L16
    L18:
        List<com.google.zxing.b> r18 = this.i;
        List<com.google.zxing.b> r19 = this.j;
        this.i = r19;
        this.j = r18;
        r19.clear();
    L19:
        postInvalidateDelayed(80, r8.left - 6, r8.top - 6, r8.right + 6, r8.bottom + 6);
    }

    @Override // android.view.View
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        super.onLayout(r5, r6, r7, r8, r9);
        int r10 = r8 - r6;
        int r11 = r9 - r7;
        float r12 = Math.min(r10, r11);
        int r13 = (int) (0.65f * r12);
        int r14 = (r10 - r13) / 2;
        int r0 = (r11 - r13) / 2;
        this.n = new Rect(r14, r0, r14 + r13, r0 + r13);
        this.o = new Size(r13, r13);
        int r15 = (int) (r12 * 0.85f);
        int r16 = (r10 - r15) / 2;
        int r17 = (r11 - r15) / 2;
        this.p = new Rect(r16, r17, r16 + r15, r15 + r17);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        if (r1 == 0) goto L5;
    L7:
        b();
        return;
    L5:
        if (this.l == false) goto L7;
        a();
    }

    public final void setCaptureRect(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.n = r2;
    }

    public final void setCaptureSize(Size r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.o = r2;
    }

    public final void setLaserAnimationEnabled(boolean r1) {
        this.l = r1;
        if (r1 == true) goto L5;
    L7:
        b();
        return;
    L5:
        if (getWindowVisibility() != 0) goto L7;
        a();
    }

    public final void setLaserVisibility(boolean r1) {
        this.h = r1;
    }

    public final void setMaskColor(int r1) {
        this.e = r1;
    }

    public final void setRealCaptureRect(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.p = r2;
    }
}
