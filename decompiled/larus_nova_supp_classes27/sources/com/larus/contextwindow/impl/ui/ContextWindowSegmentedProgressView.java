package com.larus.contextwindow.impl.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0014\u0010\"\u001a\u00020\u0007*\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/contextwindow/impl/ui/ContextWindowSegmentedProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "clipPath", "Landroid/graphics/Path;", "bounds", "Landroid/graphics/RectF;", "primary50", "segmentColors", "", "trackColor", "parts", "", "total", "", "setUsageParts", "", "segmentColorAt", "index", "onDraw", "canvas", "Landroid/graphics/Canvas;", "resolveColor", "attr", "fallback", "withAlpha", "fraction", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowSegmentedProgressView extends View {
    public final Paint a;
    public final Path b;
    public final RectF c;
    public final int[] d;
    public final int e;
    public long[] f;
    public long g;

    public static final class a {
    }

    static {
    }

    public ContextWindowSegmentedProgressView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ContextWindowSegmentedProgressView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int a(int r4) {
        int[] r0 = this.d;
        return r0[RangesKt.coerceIn(r4, 0, ArraysKt.getLastIndex(r0))];
    }

    @Override // android.view.View
    public final void onDraw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        super.onDraw(r18);
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L24;
        this.c.set(0.0f, 0.0f, getWidth(), getHeight());
        float r1 = getHeight() / 2.0f;
        this.b.reset();
        this.b.addRoundRect(this.c, r1, r1, Path.Direction.CW);
        int r9 = r18.save();
        r18.clipPath(this.b);
        this.a.setColor(this.e);
        r18.drawRect(this.c, this.a);
        if (this.g <= 0) goto L17;
        long[] r12 = this.f;
        int r13 = r12.length;
        int r2 = 0;
        float r3 = 0.0f;
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L17;
        long r4 = r12[r14];
        int r15 = r2 + 1;
        if (r3 >= getWidth()) goto L16;
        float r5 = RangesKt.coerceAtLeast(Math.min(getWidth() - r3, (float) ((RangesKt.coerceAtLeast(r4, 0) / this.g) * ((double) getWidth()))), 0.0f);
        if (r5 <= 0.0f) goto L16;
        this.a.setColor(this.d[r2]);
        float r16 = r3 + r5;
        r18.drawRect(r3, 0.0f, r16, getHeight(), this.a);
        r3 = r16;
    L16:
        r14 = r14 + 1;
        r2 = r15;
    L17:
        r18.restoreToCount(r9);
        return;
    }

    public ContextWindowSegmentedProgressView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = new Paint(1);
        this.b = new Path();
        this.c = new RectF();
        int r7 = v19.c.a(2130972123, getContext(), 2131103203);
        float r8 = 255;
        this.d = new int[]{v19.c.a(2130972126, getContext(), 2131103212), r7, ColorUtils.setAlphaComponent(r7, MathKt.roundToInt(0.7f * r8)), ColorUtils.setAlphaComponent(r7, MathKt.roundToInt(r8 * 0.4f))};
        this.e = v19.c.a(2130972086, getContext(), 2131103159);
        this.f = new long[0];
    }

    public /* synthetic */ ContextWindowSegmentedProgressView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
