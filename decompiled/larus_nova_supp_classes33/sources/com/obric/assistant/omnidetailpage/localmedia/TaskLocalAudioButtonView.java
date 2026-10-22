package com.obric.assistant.omnidetailpage.localmedia;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J(\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J(\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/assistant/omnidetailpage/localmedia/TaskLocalAudioButtonView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "", "fillPaint", "Landroid/graphics/Paint;", "strokePaint", "playPath", "Landroid/graphics/Path;", "progressBounds", "Landroid/graphics/RectF;", "playbackState", "Lcom/obric/assistant/omnidetailpage/localmedia/TaskLocalAudioPlaybackState;", "render", "", "state", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawIdleState", "centerX", "centerY", "radius", "drawPlayingState", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskLocalAudioButtonView extends View {
    public final Paint a;
    public final Paint b;
    public final Path c;
    public final RectF d;
    public q e;

    public static final class a {
    }

    static {
    }

    public TaskLocalAudioButtonView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TaskLocalAudioButtonView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a(q r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        float r0 = RangesKt.coerceIn(r4.b, 0.0f, 1.0f);
        this.e = new q(r4.a, r0);
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r17) {
        Intrinsics.checkNotNullParameter(r17, "canvas");
        super.onDraw(r17);
        float r1 = Math.min(getWidth(), getHeight());
        float r10 = getWidth() / 2.0f;
        float r8 = getHeight() / 2.0f;
        float r11 = (r1 / 2.0f) - this.b.getStrokeWidth();
        if (this.e.a == false) goto L5;
        this.a.setColor(-1);
        r17.drawCircle(r10, r8, r11, this.a);
        this.d.set(r10 - r11, r8 - r11, r10 + r11, r8 + r11);
        this.b.setColor(-2960686);
        r17.drawArc(this.d, -90.0f, 360.0f, false, this.b);
        this.b.setColor(-16777216);
        r17.drawArc(this.d, -90.0f, this.e.b * 360.0f, false, this.b);
        this.a.setColor(-16777216);
        float r12 = r11 * 0.17f;
        float r2 = 0.72f * r11;
        float r13 = r11 * 0.14f;
        float r4 = r10 - r13;
        float r3 = r2 / 2.0f;
        float r14 = r8 - r3;
        float r15 = r8 + r3;
        float r16 = r12 / 2.0f;
        r17.drawRoundRect(r4 - r12, r14, r4, r15, r16, r16, this.a);
        float r5 = r10 + r13;
        r17.drawRoundRect(r5, r14, r5 + r12, r15, r16, r16, this.a);
        return;
    L5:
        this.a.setColor(-16777216);
        r17.drawCircle(r10, r8, r11, this.a);
        float r6 = 0.42f * r11;
        float r7 = r10 - (0.2f * r11);
        this.c.reset();
        this.c.moveTo(r7, r8 - r6);
        this.c.lineTo(r7, r6 + r8);
        this.c.lineTo(r10 + (r11 * 0.48f), r8);
        this.c.close();
        this.a.setColor(-1);
        r17.drawPath(this.c, this.a);
    }

    public TaskLocalAudioButtonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Resources r5 = getResources();
        float r6 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density;
        Paint r7 = new Paint(1);
        r7.setStyle(Paint.Style.FILL);
        this.a = r7;
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.STROKE);
        r8.setStrokeCap(Paint.Cap.ROUND);
        r8.setStrokeWidth(r6 * 2.5f);
        this.b = r8;
        this.c = new Path();
        this.d = new RectF();
        this.e = new q(0);
    }

    public /* synthetic */ TaskLocalAudioButtonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
