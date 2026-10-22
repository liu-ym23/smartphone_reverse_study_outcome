package com.bytedance.android.live.liveinteract.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0 extends AnimatorListenerAdapter {
    public final /* synthetic */ y a;
    public final /* synthetic */ int b;
    public final /* synthetic */ EPointF c;
    public final /* synthetic */ EPointF d;
    public final /* synthetic */ AnimatedDrawable2 e;

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        if (this.a.o != null) goto L6;
        ALogger.i("InteractAnimation.InteractRewardEmojiAnimationTask", "path animation end since emoji cleared");
        return;
    L6:
        this.e.stop();
        HSImageView r5 = this.a.e;
        Intrinsics.checkNotNull(r5);
        UtilityKotlinExtentionsKt.u(r5);
        y r6 = this.a;
        InteractAnimationController.c r0 = r6.o;
        if (r0 != null) goto L9;
    L11:
        r6.i();
        y r7 = this.a;
        if (r7.d != null) goto L14;
        return;
    L14:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r8 = r7.l;
        if (r8 == null) goto L23;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r9 = r8.interactEmoji();
        if (r9 == null) goto L23;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r10 = r9.getReceiverEmoji();
        if (r10 == null) goto L23;
        if (r10.isValid() != true) goto L23;
        y.m(this.a);
        return;
    L23:
        y r11 = this.a;
        if (r11.p == false) goto L26;
        r11.h(r11);
        r11.s(false);
        return;
    L26:
        e r12 = r11.d;
        Intrinsics.checkNotNull(r12);
        int r13 = r12.zl(this.a.j);
        e r1 = this.a.d;
        Intrinsics.checkNotNull(r1);
        int r2 = r1.zl(this.a.k);
        this.a.q(r2, r13, true);
        return;
    L9:
        if (r0.d != true) goto L11;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        this.e.start();
        e r5 = this.a.d;
        if (r5 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r5);
        EPointF r0 = this.c;
        boolean r6 = r5.Mk(r0, r0, this.d);
        if (r6 == true) goto L11;
        y r1 = this.a;
        HSImageView r2 = r1.e;
        if (r2 == null) goto L12;
        Intrinsics.checkNotNull(r2);
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        r3.width = 1;
        r3.height = 1;
        HSImageView r7 = r1.e;
        Intrinsics.checkNotNull(r7);
        r7.setLayoutParams(r3);
    L12:
        InteractAnimationController.c r8 = this.a.o;
        if (r8 == null) goto L15;
        r8.c = r6;
    L15:
        ALogger.i("InteractAnimation.InteractRewardEmojiAnimationTask", "path emoji showWhenStart=" + r6);
        return;
    L11:
        this.a.p(this.b);
        goto L12
    }

    public a0(y r1, int r2, EPointF r3, EPointF r4, AnimatedDrawable2 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
