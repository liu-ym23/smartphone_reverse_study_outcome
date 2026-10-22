package com.obric.aiproactive.ui.widget;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001cB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/aiproactive/ui/widget/LoadingGlowOrbitView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "glowLayers", "", "Lcom/obric/aiproactive/ui/widget/LoadingGlowOrbitView$GlowSpec;", "orbitPhaseDegrees", "", "setOrbitPhase", "", EventBody.KEY_VALUE, "getOrbitPhase", "onDraw", "canvas", "Landroid/graphics/Canvas;", "createGlowPaint", "Landroid/graphics/Paint;", TypedValues.Custom.S_COLOR, "", "alphaFraction", "blurRadiusDp", "dp", "withAlpha", "GlowSpec", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LoadingGlowOrbitView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f6909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f6910b;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006("}, d2 = {"Lcom/obric/aiproactive/ui/widget/LoadingGlowOrbitView$GlowSpec;", "", "baseAngleDegrees", "", "orbitRadiusFraction", "outerRadius", "middleRadius", "innerRadius", "outerPaint", "Landroid/graphics/Paint;", "middlePaint", "innerPaint", "<init>", "(FFFFFLandroid/graphics/Paint;Landroid/graphics/Paint;Landroid/graphics/Paint;)V", "getBaseAngleDegrees", "()F", "getOrbitRadiusFraction", "getOuterRadius", "getMiddleRadius", "getInnerRadius", "getOuterPaint", "()Landroid/graphics/Paint;", "getMiddlePaint", "getInnerPaint", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f6911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f6912b;
        private final float c;
        private final float d;
        private final float e;
        private final Paint f;
        private final Paint g;
        private final Paint h;

        public a(float r2, float r3, float r4, float r5, float r6, Paint r7, Paint r8, Paint r9) {
            Intrinsics.checkNotNullParameter(r7, "outerPaint");
            Intrinsics.checkNotNullParameter(r8, "middlePaint");
            Intrinsics.checkNotNullParameter(r9, "innerPaint");
            this.f6911a = r2;
            this.f6912b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }

        public final float a() {
            return this.f6911a;
        }

        public final float b() {
            return this.f6912b;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.d;
        }

        public final float e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Float.compare(this.f6911a, r6.f6911a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f6912b, r6.f6912b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r6.d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.e, r6.e) == 0) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final Paint f() {
            return this.f;
        }

        public final Paint g() {
            return this.g;
        }

        public final Paint h() {
            return this.h;
        }

        public int hashCode() {
            return (((((((((((((Float.hashCode(this.f6911a) * 31) + Float.hashCode(this.f6912b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
        }

        public String toString() {
            return "GlowSpec(baseAngleDegrees=" + this.f6911a + ", orbitRadiusFraction=" + this.f6912b + ", outerRadius=" + this.c + ", middleRadius=" + this.d + ", innerRadius=" + this.e + ", outerPaint=" + this.f + ", middlePaint=" + this.g + ", innerPaint=" + this.h + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoadingGlowOrbitView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public LoadingGlowOrbitView(Context r26, AttributeSet r27) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r26, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r2 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r27, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r2);
        this.f6909a = CollectionsKt.listOf(new a[]{new a(-90.0f, 0.19f, 0.29f, 0.2f, 0.1f, a(-11703297, 0.22f, 108.0f), a(-11703297, 0.32f, 68.0f), a(-11703297, 0.44f, 28.0f)), new a(145.0f, 0.21f, 0.27f, 0.18f, 0.095f, a(-38022, 0.2f, 98.0f), a(-38022, 0.3f, 62.0f), a(-38022, 0.42f, 26.0f)), new a(28.0f, 0.22f, 0.31f, 0.21f, 0.11f, a(-609957, 0.22f, 112.0f), a(-609957, 0.32f, 70.0f), a(-609957, 0.44f, 28.0f))});
        setLayerType(1, null);
    }

    public /* synthetic */ LoadingGlowOrbitView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    private final float a(float r2) {
        return r2 * ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density;
    }

    private final int a(int r3, float r4) {
        return Color.argb((int) (255 * RangesKt.coerceIn(r4, 0.0f, 1.0f)), Color.red(r3), Color.green(r3), Color.blue(r3));
    }

    private final Paint a(int r3, float r4, float r5) {
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.FILL);
        r0.setColor(a(r3, r4));
        r0.setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(a(r5), BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.memorydata.plugin"));
        return r0;
    }

    public final float getOrbitPhase() {
        return this.f6910b;
    }

    @Override // android.view.View
    public void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super.onDraw(r12);
        float r0 = getWidth();
        float r1 = getHeight();
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        if (r1 <= 0.0f) goto L13;
        float r2 = Math.min(r0, r1);
        float r3 = r0 * 0.5f;
        float r4 = r1 * 0.5f;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f6909a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r5.hasNext() == false) goto L14;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.memorydata.plugin");
        double r7 = Math.toRadians(r6.a() + this.f6910b);
        float r8 = r6.b() * r2;
        float r9 = (((float) Math.cos(r7)) * r8) + r3;
        float r10 = (((float) Math.sin(r7)) * r8) + r4;
        r12.drawCircle(r9, r10, r6.c() * r2, r6.f());
        r12.drawCircle(r9, r10, r6.d() * r2, r6.g());
        r12.drawCircle(r9, r10, r6.e() * r2, r6.h());
        goto L9
    L14:
        return;
    }

    public final void setOrbitPhase(float r1) {
        this.f6910b = r1;
        invalidate();
    }
}
