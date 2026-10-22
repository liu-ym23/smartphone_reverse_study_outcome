package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    private AnimatorSet currentAnimation;

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ AnimatorSet access$002(ExpandableTransformationBehavior r0, AnimatorSet r1) {
        r0.currentAnimation = r1;
        return r1;
    }

    public abstract AnimatorSet onCreateExpandedStateChangeAnimation(View r1, View r2, boolean r3, boolean r4);

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public boolean onExpandedStateChange(View r4, View r5, boolean r6, boolean r7) {
        AnimatorSet r0 = this.currentAnimation;
        if (r0 == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r0.cancel();
    L8:
        AnimatorSet r8 = onCreateExpandedStateChangeAnimation(r4, r5, r6, r2);
        this.currentAnimation = r8;
        r8.addListener(new AnonymousClass1(this));
        this.currentAnimation.start();
        if (r7 == true) goto L11;
        this.currentAnimation.end();
    L11:
        return true;
    L5:
        r2 = false;
        goto L6
    }
}
