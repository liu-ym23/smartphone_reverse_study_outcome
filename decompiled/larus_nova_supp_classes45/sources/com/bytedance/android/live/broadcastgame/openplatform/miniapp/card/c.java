package com.bytedance.android.live.broadcastgame.openplatform.miniapp.card;

import android.animation.AnimatorSet;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerFrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements Runnable {
    public final /* synthetic */ IntroduceCardWidget a;
    public final /* synthetic */ AnimatorSet b;

    public c(IntroduceCardWidget r1, AnimatorSet r2) {
        this.a = r1;
        this.b = r2;
    }

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
    public final void a() {
        RoundCornerFrameLayout r0 = this.a.c;
        if (r0 == null) goto L11;
        r0.setPivotX(0.0f);
        RoundCornerFrameLayout r1 = this.a.c;
        if (r1 == null) goto L9;
        r1.setPivotY(r1.getHeight());
        this.b.start();
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
