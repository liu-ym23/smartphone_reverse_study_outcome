package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.ColorUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.oui.common.util.h;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0006H\u0002J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\bH\u0002J\b\u0010-\u001a\u00020\u0016H\u0016J\u000e\u0010.\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\b\u00100\u001a\u000201H\u0016J\u0006\u00102\u001a\u00020\bJ\u0014\u00103\u001a\u00020&2\n\u00104\u001a\u000605R\u000206H\u0002J \u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\u0002J\u001c\u0010;\u001a\u00020&2\n\u00104\u001a\u000605R\u0002062\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020&2\u0006\u0010)\u001a\u00020\bH\u0016J$\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\n\u00104\u001a\u000605R\u0002062\u0006\u0010<\u001a\u00020=H\u0016J\u000e\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u00020\bJ\u000e\u0010C\u001a\u00020&2\u0006\u0010B\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u0010\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\u0014R\u000e\u0010\u001f\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\u0014¨\u0006D"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelLayoutManager;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cameraDistancePx", "", "defaultEndColor", "", "getDefaultEndColor", "()I", "defaultEndColor$delegate", "Lkotlin/Lazy;", "defaultStartColor", "getDefaultStartColor", "defaultStartColor$delegate", "degToRad", "headTailPaddingItems", "getHeadTailPaddingItems", "setHeadTailPaddingItems", "(I)V", "isCyclic", "", "()Z", "setCyclic", "(Z)V", "itemAngle", "itemHeightPx", "normalColor", "getNormalColor", "setNormalColor", "quarterCount", "radiusPx", "scrollOffsetPx", "selectedColor", "getSelectedColor", "setSelectedColor", "applyTransform", "", "child", "Landroid/view/View;", "position", "scrollItems", "calculateRadius", "itemHeight", "canScrollVertically", "computeDeltaToCenterAtPosition", "computeSnapDeltaToNearestCenter", "generateDefaultLayoutParams", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$LayoutParams;", "getNearestCenterAdapterIndex", "layoutVisibleChildren", "recycler", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Recycler;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "lerp", CommonConsts.APM_INNER_EVENT_COST_START, "end", "t", "onLayoutChildren", "state", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$State;", "scrollToPosition", "scrollVerticallyBy", "dy", "setNormalTextColor", TypedValues.Custom.S_COLOR, "setSelectedTextColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d extends RecyclerView.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f14305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f14306b;
    private final Lazy c;
    private int d;
    private int e;
    private final float f;
    private final int g;
    private final float h;
    private int i;
    private float j;
    private float k;
    private boolean l;
    private int m;

    public d(Context r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f14305a = h.c(r5, 8000.0f);
        this.f14306b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new WheelLayoutManager$defaultStartColor$2(r5), Function0.class, "com.obric.memorydata.plugin"));
        this.c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new WheelLayoutManager$defaultEndColor$2(r5), Function0.class, "com.obric.memorydata.plugin"));
        this.d = i();
        this.e = j();
        this.f = 30.0f;
        this.g = 3;
        this.h = 0.017453292f;
    }

    private final float a(float r1, float r2, float r3) {
        return r1 + ((r2 - r1) * r3);
    }

    private final void a(View r7, int r8, float r9) {
        float r10 = r8 - r9;
        float r11 = RangesKt.coerceIn(this.f * r10, -90.0f, 90.0f);
        float r0 = this.h * r11;
        float r2 = RangesKt.coerceIn(Math.abs(r11) / 90.0f, 0.0f, 1.0f);
        float r12 = RangesKt.coerceIn(Math.abs(r10), 0.0f, 1.0f);
        float r1 = a(1.0f, 0.8f, r2);
        r7.setPivotX(r7.getWidth() / 2.0f);
        r7.setPivotY(r7.getHeight() / 2.0f);
        r7.setRotationX(r11);
        r7.setScaleX(r1);
        r7.setScaleY(r1);
        double r3 = r0;
        r7.setTranslationY(((float) Math.sin(r3)) * this.k);
        float r13 = (float) Math.cos(r3);
        float r4 = this.k;
        r7.setTranslationZ((r13 * r4) - r4);
        r7.setCameraDistance(this.f14305a);
        if (ZeusTransformUtils.instanceOf(r7, TextView.class) == false) goto L7;
        ((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin")).setTextColor(ColorUtils.blendARGB(this.d, this.e, r12));
        int r14 = MathKt.roundToInt(a(450.0f, 300.0f, r12));
        if (Build.VERSION.SDK_INT < 28) goto L7;
        ((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin")).setTypeface(Typeface.create(Typeface.DEFAULT, r14, false));
    L7:
        r7.setAlpha(a(1.0f, 0.2f, r2));
    }

    private final void d(RecyclerView.o r15) {
        a(r15);
        int r0 = (B() - D()) - F();
        if (r0 > 0) goto L5;
        return;
    L5:
        if (this.i == 0) goto L16;
        float r1 = D() + (r0 / 2.0f);
        float r2 = this.j / this.i;
        float r5 = 1;
        int r3 = RangesKt.coerceAtLeast((int) Math.floor((r2 - this.g) - r5), 0);
        int r4 = RangesKt.coerceAtMost((int) Math.ceil((this.g + r2) + r5), H() - 1);
        if (r3 > r4) goto L15;
    L9:
        int r6 = r3 + 1;
        View r13 = r15.c(r3);
        Intrinsics.checkNotNullExpressionValue(r13, "recycler.getViewForPosition(position)");
        b(r13);
        a(r13, 0, 0);
        int r7 = f(r13);
        int r9 = ((((A() - C()) - E()) - r7) / 2) + C();
        int r10 = MathKt.roundToInt(r1 - (this.i / 2.0f));
        a(r13, r9, r10, r9 + r7, r10 + this.i);
        a(r13, r3, r2);
        if (r3 == r4) goto L17;
        r3 = r6;
        goto L9
    L17:
        return;
    L15:
        return;
    }

    private final int i() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.f14306b.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final int j() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.c.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final float m(int r3) {
        return r3 / ((float) Math.tan(this.f * this.h));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public RecyclerView.LayoutParams a() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final void a(int r1) {
        this.m = r1;
    }

    public final void a(boolean r1) {
        this.l = r1;
    }

    public final int b(int r4) {
        if (this.i != 0) goto L5;
    L13:
        return 0;
    L5:
        if (H() == 0) goto L13;
        if (this.l == false) goto L10;
        int r5 = RangesKt.coerceIn(r4, 0, H() - 1);
    L12:
        return MathKt.roundToInt((r5 * this.i) - this.j);
    L10:
        int r0 = this.m;
        r5 = RangesKt.coerceIn(r4, r0, RangesKt.coerceAtLeast((H() - this.m) - 1, r0));
        goto L12
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public int b(int r4, RecyclerView.o r5, RecyclerView.s r6) {
        Intrinsics.checkNotNullParameter(r5, "recycler");
        Intrinsics.checkNotNullParameter(r6, "state");
        if (x() == 0) goto L16;
        if (r4 == 0) goto L16;
        if (this.i == 0) goto L16;
        if (H() == 0) goto L16;
        float r7 = RangesKt.coerceAtLeast(H() - 1, 0) * this.i;
        if (this.l == false) goto L13;
        Pair r8 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(r7));
    L14:
        float r9 = RangesKt.coerceIn(this.j + r4, ((Number) ZeusTransformUtils.preCheckCast(r8.component1(), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r8.component2(), Number.class, "com.obric.memorydata.plugin")).floatValue());
        float r10 = r9 - this.j;
        this.j = r9;
        d(r5);
        return MathKt.roundToInt(r10);
    L13:
        int r11 = this.m;
        int r0 = RangesKt.coerceAtLeast((H() - this.m) - 1, r11);
        int r1 = this.i;
        r8 = TuplesKt.to(Float.valueOf(r11 * r1), Float.valueOf(r0 * r1));
    L16:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void c(RecyclerView.o r3, RecyclerView.s r4) {
        Intrinsics.checkNotNullParameter(r3, "recycler");
        Intrinsics.checkNotNullParameter(r4, "state");
        if (H() != 0) goto L7;
        a(r3);
        this.j = 0.0f;
        return;
    L7:
        if (this.i != 0) goto L9;
        View r0 = r3.c(0);
        Intrinsics.checkNotNullExpressionValue(r0, "recycler.getViewForPosition(0)");
        b(r0);
        a(r0, 0, 0);
        int r5 = g(r0);
        this.i = r5;
        this.k = m(r5);
        a(r0, r3);
    L9:
        d(r3);
    }

    public final void d(int r1) {
        this.d = r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public void e(int r4) {
        if (H() != 0) goto L5;
        return;
    L5:
        if (this.i != 0) goto L8;
        return;
    L8:
        if (this.l == false) goto L10;
        int r0 = 0;
        int r1 = H() - 1;
    L11:
        this.j = RangesKt.coerceIn(r4, r0, r1) * this.i;
        q();
        return;
    L10:
        r0 = this.m;
        r1 = RangesKt.coerceAtLeast((H() - this.m) - 1, r0);
        goto L11
    }

    public final void f(int r1) {
        this.e = r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
    public boolean f() {
        return true;
    }

    public final int g() {
        int r1 = 0;
        if (this.i != 0) goto L5;
    L16:
        return 0;
    L5:
        if (x() == 0) goto L16;
        if (H() > 0) goto L10;
        return 0;
    L10:
        float r0 = this.j / this.i;
        if (this.l == false) goto L13;
        int r2 = MathKt.roundToInt(r0);
        int r3 = H() - 1;
    L15:
        return MathKt.roundToInt((RangesKt.coerceIn(r2, r1, r3) * this.i) - this.j);
    L13:
        r1 = this.m;
        r3 = RangesKt.coerceAtLeast((H() - this.m) - 1, r1);
        r2 = MathKt.roundToInt(r0);
        goto L15
    }

    public final int h() {
        if (this.i != 0) goto L5;
        return -1;
    L5:
        if (H() == 0) goto L15;
        int r0 = MathKt.roundToInt(this.j / this.i);
        if (this.l == false) goto L10;
        int r1 = 0;
        int r3 = H() - 1;
    L12:
        return RangesKt.coerceIn(r0, r1, r3);
    L10:
        r1 = this.m;
        r3 = RangesKt.coerceAtLeast((H() - this.m) - 1, r1);
        goto L12
    L15:
        return -1;
    }
}
