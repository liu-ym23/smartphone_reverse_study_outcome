package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements Animation.AnimationListener {
    public final /* synthetic */ MmSummaryLoadingTextView a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    public d(MmSummaryLoadingTextView r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [android.view.ViewGroup, com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSummaryLoadingTextView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r4) {
        this.a.b.setVisibility(4);
        ?? r5 = this.a;
        if (r5.e == false) goto L8;
        e r0 = r5.d;
        if (r0 == null) goto L9;
        r5.postDelayed(r0, r5.f);
        return;
    L9:
        return;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r2) {
        this.a.b.setVisibility(0);
    }
}
