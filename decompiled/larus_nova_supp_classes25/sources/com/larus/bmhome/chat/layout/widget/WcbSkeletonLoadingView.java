package com.larus.bmhome.chat.layout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.graphics.ColorUtils;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0002:;B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014J(\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0014J\b\u0010(\u001a\u00020\u001fH\u0014J\b\u0010)\u001a\u00020\u001fH\u0014J\u0018\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200H\u0014J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u000203H\u0014J\u0018\u00104\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u00020\u001fH\u0002J\b\u00106\u001a\u00020\u001fH\u0002J\b\u00107\u001a\u00020\u001fH\u0002J\b\u00108\u001a\u00020\u001fH\u0002J\b\u00109\u001a\u00020\u001fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/WcbSkeletonLoadingView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "strokePaint", "Landroid/graphics/Paint;", "blockPaint", "shimmerPaint", "outerRect", "Landroid/graphics/RectF;", "blockRect", "shimmerPath", "Landroid/graphics/Path;", "shimmerMatrix", "Landroid/graphics/Matrix;", "style", "Lcom/larus/bmhome/chat/layout/widget/WcbSkeletonLoadingView$Style;", "shimmerGradient", "Landroid/graphics/LinearGradient;", "animator", "Landroid/animation/ValueAnimator;", "shimmerWidth", "", "shimmerHighlightColor", "setStyle", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "width", "height", "oldWidth", "oldHeight", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "visibility", "onWindowVisibilityChanged", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "rebuildDrawingState", "rebuildGradient", "refreshColors", "updateAnimationState", "startShimmer", "stopShimmer", "Style", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class WcbSkeletonLoadingView extends View {
    public static final /* synthetic */ int m = 0;
    public final Paint a;
    public final Paint b;
    public final Paint c;
    public final RectF d;
    public final RectF e;
    public final Path f;
    public final Matrix g;
    public Style h;
    public LinearGradient i;
    public ValueAnimator j;
    public float k;
    public int l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/WcbSkeletonLoadingView$Style;", "", "<init>", "(Ljava/lang/String;I)V", "SUGGEST", "TITLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum Style extends Enum<Style> {
        public static final Style SUGGEST = null;
        public static final Style TITLE = null;
        public static final /* synthetic */ Style[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Style> getEntries() {
            return b;
        }

        static {
            Style r0 = new Style("SUGGEST", 0);
            SUGGEST = r0;
            Style r1 = new Style("TITLE", 1);
            TITLE = r1;
            Style[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Style[] values() {
            return (Style[]) a.clone();
        }

        public static Style valueOf(String r1) {
            return (Style) r27.a.a(Style.class, r1);
        }

        public Style(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Style.values().length];
            r0[Style.SUGGEST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Style.TITLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public WcbSkeletonLoadingView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public WcbSkeletonLoadingView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void d() {
        ValueAnimator r0 = this.j;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.j = null;
        this.g.reset();
        LinearGradient r1 = this.i;
        if (r1 == null) goto L9;
        r1.setLocalMatrix(this.g);
        return;
    }

    public final void b() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        this.k = getWidth() * 0.65f;
        LinearGradient r0 = new LinearGradient(0.0f, 0.0f, this.k, 0.0f, new int[]{0, this.l, 0}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.c.setShader(r0);
        this.i = r0;
    }

    public final void c() {
        int r0 = v19.c.a(2130972079, getContext(), 2131103136);
        this.b.setColor(ColorUtils.setAlphaComponent(r0, 10));
        this.l = ColorUtils.setAlphaComponent(r0, 18);
        this.a.setColor(v19.c.a(2130972087, getContext(), 2131103163));
    }

    public final void e() {
        if (isAttachedToWindow() == true) goto L5;
    L23:
        d();
        return;
    L5:
        if (isShown() == false) goto L23;
        if (getWindowVisibility() != 0) goto L23;
        if (getWidth() <= 0) goto L23;
        if (getHeight() <= 0) goto L23;
        ValueAnimator r0 = this.j;
        if (r0 != null) goto L15;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == false) goto L20;
        return;
    L20:
        if (this.i == null) goto L27;
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{-this.k, getWidth() + this.k});
        r2.setDuration(1200);
        r2.setRepeatCount(-1);
        r2.setInterpolator(new LinearInterpolator());
        r2.addUpdateListener(new n1(this));
        r2.start();
        this.j = r2;
        return;
    L27:
        return;
    L15:
        if (r0.isRunning() != true) goto L17;
        r1 = true;
        goto L18
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        d();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        c();
        b();
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        if (this.h != Style.SUGGEST) goto L5;
        r9.drawRoundRect(this.d, c7.b(8), c7.b(8), this.a);
    L5:
        r9.drawRoundRect(this.e, c7.b(6), c7.b(6), this.b);
        if (this.i != null) goto L8;
        return;
    L8:
        int r0 = r9.save();
        r9.clipPath(this.f);
        r9.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.c);
        r9.restoreToCount(r0);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        e();
    }

    public final void setStyle(Style r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        if (this.h != r2) goto L5;
        return;
    L5:
        this.h = r2;
        requestLayout();
        a(getWidth(), getHeight());
        invalidate();
    }

    public final void a(int r5, int r6) {
        if (r5 <= 0) goto L15;
        if (r6 <= 0) goto L16;
        this.f.reset();
        float r0 = this.a.getStrokeWidth() / 2.0f;
        float r7 = r5;
        float r8 = r6;
        this.d.set(r0, r0, r7 - r0, r8 - r0);
        int r1 = b.a[this.h.ordinal()];
        if (r1 != 1) goto L8;
        float r2 = c7.b(12);
        float r3 = c7.b(12);
        this.e.set(r2, r3, r7 - r2, r8 - r3);
    L13:
        this.f.addRoundRect(this.e, c7.b(6), c7.b(6), Path.Direction.CW);
        b();
        return;
    L8:
        if (r1 != 2) goto L11;
        this.e.set(0.0f, 0.0f, r7, r8);
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
    L16:
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r6, int r7) {
        Style r0 = this.h;
        int[] r1 = b.a;
        int r2 = r1[r0.ordinal()];
        if (r2 == 1) goto L8;
        if (r2 != 2) goto L7;
        int r3 = c7.b(56);
    L9:
        int r4 = r1[this.h.ordinal()];
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        int r5 = c7.b(12);
    L16:
        setMeasuredDimension(View.resolveSize(r3, r6), View.resolveSize(r5, r7));
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        r5 = c7.b(36);
        goto L16
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r3 = c7.b(102);
        goto L9
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        e();
    }

    public WcbSkeletonLoadingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.STROKE);
        r5.setStrokeWidth(c7.b(1));
        this.a = r5;
        this.b = new Paint(1);
        this.c = new Paint(1);
        this.d = new RectF();
        this.e = new RectF();
        this.f = new Path();
        this.g = new Matrix();
        this.h = Style.SUGGEST;
        setImportantForAccessibility(2);
        c();
    }

    public /* synthetic */ WcbSkeletonLoadingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        d();
        a(r1, r2);
        e();
    }
}
