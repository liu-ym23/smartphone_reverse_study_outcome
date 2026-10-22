package com.obric.common.oea.style.scene.qsanim.morph;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import rp.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\n8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/SeekBarMorphParentLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/SeekBar;", "a", "Landroid/widget/SeekBar;", "getSeekBarChild", "()Landroid/widget/SeekBar;", "setSeekBarChild", "(Landroid/widget/SeekBar;)V", "seekBarChild", "Landroid/graphics/PointF;", "c", "Landroid/graphics/PointF;", "getLastTouchPoint", "()Landroid/graphics/PointF;", "setLastTouchPoint", "(Landroid/graphics/PointF;)V", "lastTouchPoint", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SeekBarMorphParentLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SeekBar f11372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PointF f11374c;
    public float d;
    public float e;
    public final int f;

    @JvmOverloads
    public SeekBarMorphParentLayout(Context r5) {
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public abstract float a(MotionEvent r5);

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        SeekBar r5 = this.f11372a;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("seekBarChild");
    L5:
        float r11 = r5.getProgress();
        if (r10 == null) goto L8;
        Integer r12 = Integer.valueOf(r10.getAction());
    L10:
        if (r12 != null) goto L13;
    L16:
        if (r12 != null) goto L19;
    L40:
        if (r12 == null) goto L15;
        r12.intValue();
    L15:
        boolean r13 = false;
    L43:
        if (r13 == false) goto L45;
        return true;
    L45:
        if (super.dispatchTouchEvent(r10) == false) goto L48;
        return true;
    L48:
        return false;
    L19:
        if (r12.intValue() != 2) goto L40;
        float r14 = a(r10);
        float r15 = (r11 - this.d) / r14;
        float r16 = 0.0f;
        if (r15 == 0.0f) goto L23;
        this.f11373b = RangesKt.coerceIn(r15, 0.1f, 0.3f);
    L23:
        this.f11374c = new PointF(r10.getX(), r10.getY());
        this.d = r11;
        float r17 = this.f;
        if (r11 < r17) goto L26;
    L30:
        r16 = this.e + (this.f11373b * r14);
        if (r16 <= r17) goto L33;
    L36:
        this.e = r16;
        r13 = true;
    L37:
        String r18 = "needMorph: " + r13 + ", force: " + r16 + ", process: " + r11 + ", deltaMove: " + r14 + ", forceFactor: " + this.f11373b + ", f: " + r15;
        Intrinsics.checkNotNullParameter("MorphSeekBarParentLayout", "tag");
        Intrinsics.checkNotNullParameter(r18, "msg");
        if (b.f21793a == null) goto L43;
        androidx.constraintlayout.motion.widget.a.B(androidx.constraintlayout.motion.widget.a.D("MorphSeekBarParentLayout", "tag", r18, "msg", "MorphSeekBarParentLayout->"), r18, "OEA_SDK");
        goto L43
    L33:
        if (r16 < 0) goto L36;
        this.e = r11;
    L29:
        r13 = false;
        goto L37
    L26:
        if (r11 <= 0) goto L30;
        this.e = r11;
        goto L29
    L13:
        if (r12.intValue() != 0) goto L16;
        this.f11374c = new PointF(r10.getX(), r10.getY());
        this.d = r11;
        this.e = r11;
        this.f11373b = 0.2f;
        goto L15
    L8:
        r12 = null;
        goto L10
    }

    public final PointF getLastTouchPoint() {
        return this.f11374c;
    }

    public final SeekBar getSeekBarChild() {
        SeekBar r5 = this.f11372a;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("seekBarChild");
    L5:
        return r5;
    }

    public final void setLastTouchPoint(PointF r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f11374c = r5;
    }

    public final void setSeekBarChild(SeekBar r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f11372a = r5;
    }

    @JvmOverloads
    public SeekBarMorphParentLayout(Context r5, AttributeSet r10) {
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ SeekBarMorphParentLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public SeekBarMorphParentLayout(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f11374c = new PointF(0.0f, 0.0f);
        this.f = 100;
    }
}
