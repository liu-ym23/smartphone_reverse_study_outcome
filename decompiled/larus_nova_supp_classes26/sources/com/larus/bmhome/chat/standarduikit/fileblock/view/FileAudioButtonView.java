package com.larus.bmhome.chat.standarduikit.fileblock.view;

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
import vl8.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 &2\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J(\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J(\u0010 \u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J(\u0010!\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J0\u0010\"\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0007H\u0002J(\u0010$\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J(\u0010%\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/fileblock/view/FileAudioButtonView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "", "fillPaint", "Landroid/graphics/Paint;", "strokePaint", "playPath", "Landroid/graphics/Path;", "progressBounds", "Landroid/graphics/RectF;", "playbackState", "Lcom/larus/bmhome/chat/standarduikit/localfileblock/view/LocalFilePlaybackState;", "loadingRotation", "render", "", "state", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawLoadingState", "centerX", "centerY", "radius", "drawIdleState", "drawPausedState", "drawPlayIcon", "color", "drawPlayingState", "drawProgressRing", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileAudioButtonView extends View {
    public final Paint a;
    public final Paint b;
    public final Path c;
    public final RectF d;
    public g e;
    public float f;

    public static final class a {
    }

    static {
    }

    public FileAudioButtonView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FileAudioButtonView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void c(g r6) {
        Intrinsics.checkNotNullParameter(r6, "state");
        float r0 = RangesKt.coerceIn(r6.d, 0.0f, 1.0f);
        boolean r1 = r6.a;
        boolean r3 = r6.b;
        this.e = new g(r1, r3, r6.c, r0);
        if (r3 == true) goto L5;
        this.f = 0.0f;
    L5:
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        super.onDraw(r18);
        float r0 = Math.min(getWidth(), getHeight());
        float r3 = getWidth() / 2.0f;
        float r4 = getHeight() / 2.0f;
        float r5 = (r0 / 2.0f) - this.b.getStrokeWidth();
        g r1 = this.e;
        if (r1.b == false) goto L6;
        this.a.setColor(-1);
        r18.drawCircle(r3, r4, r5, this.a);
        this.d.set(r3 - r5, r4 - r5, r3 + r5, r4 + r5);
        this.b.setColor(-2960686);
        r18.drawArc(this.d, -90.0f, 360.0f, false, this.b);
        this.b.setColor(-16777216);
        r18.drawArc(this.d, this.f - 90.0f, 100.0f, false, this.b);
        this.f = (this.f + 12.0f) % 360.0f;
        postInvalidateDelayed(16);
        return;
    L6:
        if (r1.a == false) goto L9;
        this.a.setColor(-1);
        r18.drawCircle(r3, r4, r5, this.a);
        b(r18, r3, r4, r5);
        this.a.setColor(-16777216);
        float r2 = 0.17f * r5;
        float r6 = 0.72f * r5;
        float r7 = r5 * 0.14f;
        float r10 = r3 - r7;
        float r8 = r6 / 2.0f;
        float r16 = r4 - r8;
        float r9 = r8 + r4;
        float r11 = r2 / 2.0f;
        r18.drawRoundRect(r10 - r2, r16, r10, r9, r11, r11, this.a);
        float r12 = r3 + r7;
        r18.drawRoundRect(r12, r16, r12 + r2, r9, r11, r11, this.a);
        return;
    L9:
        if (r1.c == false) goto L11;
        this.a.setColor(-1);
        r18.drawCircle(r3, r4, r5, this.a);
        b(r18, r3, r4, r5);
        a(r18, r3, r4, r5, -16777216);
        return;
    L11:
        this.a.setColor(-16777216);
        r18.drawCircle(r3, r4, r5, this.a);
        a(r18, r3, r4, r5, -1);
    }

    public FileAudioButtonView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        Resources r10 = getResources();
        float r11 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density;
        Paint r12 = new Paint(1);
        r12.setStyle(Paint.Style.FILL);
        this.a = r12;
        Paint r13 = new Paint(1);
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeCap(Paint.Cap.ROUND);
        r13.setStrokeWidth(r11 * 2.5f);
        this.b = r13;
        this.c = new Path();
        this.d = new RectF();
        this.e = new g(false, false, false, 0.0f, 15);
    }

    public /* synthetic */ FileAudioButtonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void b(Canvas r7, float r8, float r9, float r10) {
        this.d.set(r8 - r10, r9 - r10, r8 + r10, r9 + r10);
        this.b.setColor(-2960686);
        r7.drawArc(this.d, -90.0f, 360.0f, false, this.b);
        this.b.setColor(-16777216);
        r7.drawArc(this.d, -90.0f, this.e.d * 360.0f, false, this.b);
    }

    public final void a(Canvas r5, float r6, float r7, float r8, int r9) {
        float r0 = 0.42f * r8;
        float r1 = r6 - (0.2f * r8);
        this.c.reset();
        this.c.moveTo(r1, r7 - r0);
        this.c.lineTo(r1, r0 + r7);
        this.c.lineTo(r6 + (r8 * 0.48f), r7);
        this.c.close();
        this.a.setColor(r9);
        r5.drawPath(this.c, this.a);
    }
}
