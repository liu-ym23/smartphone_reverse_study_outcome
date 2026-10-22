package com.obric.common.oea.style.scene.qsanim.morph;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u0000 +2\u00020\u0001:\u0001+B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0017J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\nH&J\b\u0010#\u001a\u00020!H&J\u0010\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u001fH&J8\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00182\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010(\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0005J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\nH&R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/SeekBarMorphParentLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "forceFactor", "", "invertDirection", "", "lastForce", "lastProgress", "lastTouchPoint", "Landroid/graphics/PointF;", "getLastTouchPoint", "()Landroid/graphics/PointF;", "setLastTouchPoint", "(Landroid/graphics/PointF;)V", "maxProgress", "minProgress", "seekBarChild", "Landroid/widget/SeekBar;", "getSeekBarChild", "()Landroid/widget/SeekBar;", "setSeekBarChild", "(Landroid/widget/SeekBar;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "dragContinue", "", "force", "dragEnd", "getDeltaMove", "motionEvent", CommonConsts.APM_INNER_EVENT_COST_INIT, "seekBar", "morphFactor", "startDrag", "initForce", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SeekBarMorphParentLayout extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f7833b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SeekBar f7834a;
    private float c;
    private PointF d;
    private float e;
    private float f;
    private int g;
    private int h;
    private boolean i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/SeekBarMorphParentLayout$Companion;", "", "()V", "FORCE_FACTOR_DEF", "", "FORCE_FACTOR_MAX", "FORCE_FACTOR_MIN", "TAG", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f7833b = new a(null);
    }

    public SeekBarMorphParentLayout(Context r7) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
    }

    public SeekBarMorphParentLayout(Context r9, AttributeSet r10) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin"), 0, 4, null);
    }

    public SeekBarMorphParentLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.d = new PointF(0.0f, 0.0f);
        this.h = 100;
    }

    public /* synthetic */ SeekBarMorphParentLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = (AttributeSet) ZeusTransformUtils.preCheckCast(null, AttributeSet.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public abstract float a(MotionEvent r1);

    public abstract void a();

    public abstract void a(float r1);

    public abstract void b(float r1);

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r11) {
        SeekBar r0 = this.f7834a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("seekBarChild");
    L5:
        float r1 = r0.getProgress();
        if (r11 == null) goto L8;
        Integer r2 = Integer.valueOf(r11.getAction());
    L10:
        if (r2 == null) goto L21;
        if (r2.intValue() != 0) goto L21;
        a(r1);
        this.d = new PointF(r11.getX(), r11.getY());
        this.e = r1;
        this.f = r1;
        if (this.i == false) goto L17;
        float r3 = -0.2f;
    L18:
        this.c = r3;
    L19:
        boolean r6 = false;
    L57:
        if (r6 == false) goto L59;
        return true;
    L59:
        if (super.dispatchTouchEvent(r11) == false) goto L62;
        return true;
    L62:
        return false;
    L17:
        r3 = 0.2f;
    L21:
        if (r2 != null) goto L24;
    L46:
        if (r2 == null) goto L52;
        if (r2.intValue() != 1) goto L52;
    L56:
        a();
    L52:
        if (r2 == null) goto L19;
        if (r2.intValue() != 3) goto L19;
    L24:
        if (r2.intValue() != 2) goto L46;
        float r4 = a(r11);
        float r5 = (r1 - this.e) / r4;
        float r7 = 0.0f;
        if (r5 != 0.0f) goto L28;
    L32:
        this.d = new PointF(r11.getX(), r11.getY());
        this.e = r1;
        int r8 = this.h;
        if (r1 < r8) goto L35;
    L38:
        r7 = this.f + (this.c * r4);
        if (r7 <= r8) goto L41;
    L42:
        this.f = r7;
        r6 = true;
    L43:
        if (r6 == false) goto L45;
        b(r7);
    L45:
        com.obric.common.oea.foundation.a.b.f7661a.b("MorphSeekBarParentLayout", "needMorph: " + r6 + ", force: " + r7 + ", process: " + r1 + ", deltaMove: " + r4 + ", forceFactor: " + this.c + ", f: " + r5);
        goto L57
    L41:
        if (r7 < this.g) goto L42;
    L37:
        this.f = r1;
        r6 = false;
        goto L43
    L35:
        if (r1 > this.g) goto L37;
    L28:
        if (this.i == false) goto L30;
        float r9 = -0.3f;
        float r10 = -0.1f;
    L31:
        this.c = RangesKt.coerceIn(r5, r9, r10);
        goto L32
    L30:
        r9 = 0.1f;
        r10 = 0.3f;
        goto L31
    L8:
        r2 = null;
        goto L10
    }

    public final PointF getLastTouchPoint() {
        return this.d;
    }

    public final SeekBar getSeekBarChild() {
        SeekBar r1 = this.f7834a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("seekBarChild");
    L5:
        return r1;
    }

    public final void setLastTouchPoint(PointF r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setSeekBarChild(SeekBar r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f7834a = r2;
    }
}
