package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 extends BaseAnimationListener {
    public final /* synthetic */ c0 a;

    public b0(c0 r1) {
        this.a = r1;
    }

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
    public final void onAnimationStop(AnimatedDrawable2 r4) {
        ALogger.i("InteractAnimation.InteractRewardEmojiAnimationTask", "receiver animation stop");
        HSImageView r5 = this.a.a.g;
        Intrinsics.checkNotNull(r5);
        UtilityKotlinExtentionsKt.t(r5);
        this.a.a.k();
        y r6 = this.a.a;
        e r0 = r6.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r6.p == false) goto L8;
        r6.h(r6);
        r6.s(false);
        return;
    L8:
        Intrinsics.checkNotNull(r0);
        int r7 = r0.zl(this.a.a.j);
        e r1 = this.a.a.d;
        Intrinsics.checkNotNull(r1);
        int r2 = r1.zl(this.a.a.k);
        this.a.a.q(r2, r7, true);
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        if (r3 < (r2.getFrameCount() - 1)) goto L6;
        r2.stop();
        return;
    }
}
