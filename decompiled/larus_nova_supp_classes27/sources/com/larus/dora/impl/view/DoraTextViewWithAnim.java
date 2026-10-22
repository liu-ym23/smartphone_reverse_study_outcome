package com.larus.dora.impl.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/view/DoraTextViewWithAnim;", "Lcom/larus/dora/impl/view/DoraTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "objectAnimator", "Landroid/animation/ObjectAnimator;", "getObjectAnimator", "()Landroid/animation/ObjectAnimator;", "setObjectAnimator", "(Landroid/animation/ObjectAnimator;)V", "onDetachedFromWindow", "", "alphaAnimRepeat", "stopAlphaAnim", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraTextViewWithAnim extends DoraTextView {
    public ObjectAnimator a;

    public DoraTextViewWithAnim(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DoraTextViewWithAnim(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        ObjectAnimator r0 = this.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        setAlpha(0.3f);
        e1.x(this);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{0.3f, 1.0f});
        r2.setDuration(1000);
        r2.setInterpolator(new DecelerateInterpolator());
        r2.setRepeatMode(2);
        r2.setRepeatCount(-1);
        r2.start();
        this.a = r2;
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
        r1 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        setAlpha(1.0f);
        ObjectAnimator r0 = this.a;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        ObjectAnimator r0 = this.a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.a = null;
    }

    public final ObjectAnimator getObjectAnimator() {
        return this.a;
    }

    public final void setObjectAnimator(ObjectAnimator r1) {
        this.a = r1;
    }

    public DoraTextViewWithAnim(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ DoraTextViewWithAnim(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
