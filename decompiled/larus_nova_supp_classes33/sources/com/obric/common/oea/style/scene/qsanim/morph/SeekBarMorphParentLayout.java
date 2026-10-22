package com.obric.common.oea.style.scene.qsanim.morph;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/SeekBarMorphParentLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar;", "a", "Landroid/widget/SeekBar;", "getSeekBarChild", "()Landroid/widget/SeekBar;", "setSeekBarChild", "(Landroid/widget/SeekBar;)V", "seekBarChild", "Landroid/graphics/PointF;", "c", "Landroid/graphics/PointF;", "getLastTouchPoint", "()Landroid/graphics/PointF;", "setLastTouchPoint", "(Landroid/graphics/PointF;)V", "lastTouchPoint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SeekBarMorphParentLayout extends FrameLayout {
    public SeekBar a;
    public float b;
    public PointF c;
    public float d;
    public float e;
    public final int f;

    public static final class a {
    }

    static {
    }

    public SeekBarMorphParentLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SeekBarMorphParentLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public abstract void a();

    public abstract void b();

    public abstract float c(MotionEvent r1);

    public abstract void d();

    public final SeekBar getSeekBarChild() {
        SeekBar r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("seekBarChild");
    L5:
        return r0;
    }

    public final PointF getLastTouchPoint() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        SeekBar r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("seekBarChild");
    L5:
        float r1 = r0.getProgress();
        if (r10 == null) goto L8;
        Integer r2 = Integer.valueOf(r10.getAction());
    L10:
        if (r2 != null) goto L13;
    L15:
        if (r2 != null) goto L18;
    L39:
        if (r2 != null) goto L42;
    L44:
        if (r2 != null) goto L47;
    L49:
        boolean r6 = false;
    L50:
        if (r6 == false) goto L52;
        return true;
    L52:
        if (super.dispatchTouchEvent(r10) == true) goto L57;
        return false;
    L57:
        return true;
    L47:
        if (r2.intValue() != 3) goto L49;
    L48:
        b();
        goto L49
    L42:
        if (r2.intValue() != 1) goto L44;
    L18:
        if (r2.intValue() != 2) goto L39;
        float r3 = c(r10);
        float r4 = (r1 - this.d) / r3;
        float r5 = 0.0f;
        if (r4 == 0.0f) goto L22;
        this.b = RangesKt.coerceIn(r4, 0.1f, 0.3f);
    L22:
        this.c = new PointF(r10.getX(), r10.getY());
        this.d = r1;
        float r7 = this.f;
        if (r1 < r7) goto L25;
    L28:
        r5 = this.e + (this.b * r3);
        if (r5 <= r7) goto L31;
    L35:
        this.e = r5;
        r6 = true;
    L36:
        if (r6 == false) goto L38;
        a();
    L38:
        mja.a.C0063a r8 = mja.a.a;
        mja.a.a("MorphSeekBarParentLayout", "needMorph: " + r6 + ", force: " + r5 + ", process: " + r1 + ", deltaMove: " + r3 + ", forceFactor: " + this.b + ", f: " + r4);
        goto L50
    L31:
        if (r5 < 0) goto L35;
        this.e = r1;
    L34:
        r6 = false;
        goto L36
    L25:
        if (r1 <= 0) goto L28;
        this.e = r1;
        goto L34
    L13:
        if (r2.intValue() != 0) goto L15;
        d();
        this.c = new PointF(r10.getX(), r10.getY());
        this.d = r1;
        this.e = r1;
        this.b = 0.2f;
        goto L49
    L8:
        r2 = null;
        goto L10
    }

    public final void setLastTouchPoint(PointF r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setSeekBarChild(SeekBar r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public SeekBarMorphParentLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new PointF(0.0f, 0.0f);
        this.f = 100;
    }

    public /* synthetic */ SeekBarMorphParentLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
