package com.obric.common.oea.style.scene.qsanim.morph;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/VerticalSeekBarMorphFrame;", "Lcom/obric/common/oea/style/scene/qsanim/morph/SeekBarMorphParentLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class VerticalSeekBarMorphFrame extends SeekBarMorphParentLayout {
    public VerticalSeekBarMorphFrame(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VerticalSeekBarMorphFrame(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public final void a() {
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public final void b() {
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public final void d() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.obric.common.oea.style.scene.qsanim.morph.SeekBarMorphParentLayout
    public final float c(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "motionEvent");
        return r2.getY() - getLastTouchPoint().y;
    }

    public VerticalSeekBarMorphFrame(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ VerticalSeekBarMorphFrame(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
