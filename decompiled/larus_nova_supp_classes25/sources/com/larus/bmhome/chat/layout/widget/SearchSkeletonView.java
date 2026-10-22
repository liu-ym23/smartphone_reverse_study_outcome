package com.larus.bmhome.chat.layout.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\rH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/SearchSkeletonView;", "Lcom/larus/common_ui/widget/roundlayout/RoundFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "overlay", "Landroid/view/View;", "colorAnimator", "Landroid/animation/Animator;", "onAttachedToWindow", "", "onDetachedFromWindow", "ensureCreateAnimator", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchSkeletonView extends RoundFrameLayout {
    public final View b;
    public Animator c;

    public SearchSkeletonView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SearchSkeletonView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        Animator r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        this.b.clearAnimation();
        ObjectAnimator r1 = ObjectAnimator.ofArgb(this.b, "backgroundColor", new int[]{ContextCompat.getColor(getContext(), v19.c.b(2130972086, getContext(), 2131103159)), ContextCompat.getColor(getContext(), v19.c.b(2130972087, getContext(), 2131103162))});
        r1.setDuration(600);
        r1.setInterpolator(new LinearInterpolator());
        r1.setRepeatCount(-1);
        r1.setRepeatMode(2);
        this.c = r1;
        r1.start();
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        Animator r0 = this.c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isRunning() == false) goto L9;
        r0.cancel();
        this.c = null;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchSkeletonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        FrameLayout.inflate(r2, 2131562882, this);
        this.b = findViewById(2131386815);
        getDelegate().e(i5.r0());
    }

    public /* synthetic */ SearchSkeletonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
