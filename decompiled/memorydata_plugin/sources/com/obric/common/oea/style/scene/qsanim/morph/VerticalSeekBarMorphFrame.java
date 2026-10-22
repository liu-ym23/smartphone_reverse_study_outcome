package com.obric.common.oea.style.scene.qsanim.morph;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J<\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000eH\u0007J\b\u0010\u001b\u001a\u00020\fH\u0014J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u000eH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/VerticalSeekBarMorphFrame;", "Lcom/obric/common/oea/style/scene/qsanim/morph/SeekBarMorphParentLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewMorphHelper", "Lcom/obric/common/oea/style/scene/qsanim/morph/ViewMorphAnimHelper;", "dragContinue", "", "force", "", "dragEnd", "getDeltaMove", "motionEvent", "Landroid/view/MotionEvent;", CommonConsts.APM_INNER_EVENT_COST_INIT, "seekBar", "Landroid/widget/SeekBar;", "maxProgress", "minProgress", "morphFactor", "originalWidth", "originalHeight", "onDetachedFromWindow", "startDrag", "initForce", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class VerticalSeekBarMorphFrame extends SeekBarMorphParentLayout {
    private a c;

    public VerticalSeekBarMorphFrame(Context r7) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
    }

    public VerticalSeekBarMorphFrame(Context r9, AttributeSet r10) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin"), 0, 4, null);
    }

    public VerticalSeekBarMorphFrame(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
    }

    public /* synthetic */ VerticalSeekBarMorphFrame(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public float a(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "motionEvent");
        return r2.getY() - getLastTouchPoint().y;
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public void a() {
        a r0 = this.c;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public void a(float r2) {
        a r1 = this.c;
        if (r1 == null) goto L6;
        r1.a(0.0f, r2);
        return;
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public void b(float r2) {
        a r1 = this.c;
        if (r1 == null) goto L6;
        r1.b(0.0f, r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a r0 = this.c;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }
}
