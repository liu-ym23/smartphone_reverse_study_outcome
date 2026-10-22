package com.bytedance.android.live.broadcastgame.openplatform.miniapp.card;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import com.bytedance.android.live.broadcastgame.opengame.GameIntroCard;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerFrameLayout;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class IntroduceCardWidget<T> implements IExternalWidget {
    public volatile boolean a;
    public boolean b;
    public GameIntroCard c;
    public final Lazy d;
    public final Context e;
    public final long f;

    public final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void onHide() {
    }

    public final void onLoad() {
        this.a = true;
    }

    public final void onShow() {
    }

    public final void onUnload() {
        this.a = false;
    }

    public final void onViewAttached(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public final void onViewDetached() {
    }

    public final void onViewWillAttach(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public final void onViewWillDetach() {
    }

    public final View getView() {
        RoundCornerFrameLayout r0 = this.c;
        if (r0 == null) goto L26;
        if (r0.getParent() == null) goto L19;
        RoundCornerFrameLayout r1 = this.c;
        if (r1 == null) goto L18;
        ViewParent r2 = r1.getParent();
        if (r2 == null) goto L16;
        ViewGroup r3 = (ViewGroup) r2;
        RoundCornerFrameLayout r4 = this.c;
        if (r4 == null) goto L14;
        r3.removeView(r4);
        goto L19
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L19:
        RoundCornerFrameLayout r5 = this.c;
        if (r5 == null) goto L24;
        r5.setAlpha(0.0f);
        return r5;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public final void g(Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "block");
        RoundCornerFrameLayout r0 = this.c;
        if (r0 == null) goto L23;
        if (r0.getParent() != null) goto L8;
        r9.invoke();
        return;
    L8:
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = r9;
        GameIntroCard r11 = this.c;
        if (r11 == null) goto L21;
        ObjectAnimator r12 = ObjectAnimator.ofFloat(r11, "ScaleX", new float[]{1.0f, 0.0f});
        r12.setDuration(280);
        r12.setInterpolator(new AccelerateInterpolator());
        GameIntroCard r5 = this.c;
        if (r5 == null) goto L19;
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r5, "ScaleY", new float[]{1.0f, 0.0f});
        r6.setDuration(280);
        r6.setInterpolator(new AccelerateInterpolator());
        GameIntroCard r7 = this.c;
        if (r7 == null) goto L17;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r7, LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, 0.0f});
        r2.setDuration(280);
        final AnimatorSet r3 = new AnimatorSet();
        r3.play(r12).with(r6).with(r2);
        j(200, new IntroduceCardWidget$hideCard$1(r1));
        j(0, new IntroduceCardWidget$hideCard$2(this, r3, r1));
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public final void q(final View.OnClickListener r3) {
        GameIntroCard r0 = this.c;
        if (r0 == null) goto L6;
        r0.setOnClickBlock(new IntroduceCardWidget$setClickListener$1(this, r3));
        return;
    }

    public final void t(final View.OnClickListener r3) {
        GameIntroCard r0 = this.c;
        if (r0 == null) goto L6;
        r0.setOnCloseBlock(new IntroduceCardWidget$setCloseClickListener$1(this, r3));
        return;
    }

    public IntroduceCardWidget(Context r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        this.e = r2;
        this.f = r3;
        this.d = LazyKt.lazy(new IntroduceCardWidget$viewHandler$2(this));
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
    public final void j(long r9, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        RoundCornerFrameLayout r0 = this.c;
        if (r0 == null) goto L21;
        if (r0.getParent() != null) goto L8;
        UtilityKotlinExtentionsKt.s(r9, false, false, r11, 6);
        return;
    L8:
        if (r9 > 0) goto L14;
        RoundCornerFrameLayout r12 = this.c;
        if (r12 == null) goto L13;
        r12.post(new a(r11));
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L14:
        RoundCornerFrameLayout r1 = this.c;
        if (r1 == null) goto L19;
        r1.postDelayed(new a(r11), r9);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }
}
