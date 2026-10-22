package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0007Jj\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00112\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010!2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010!H\u0007R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverAnimationHelper;", "", "()V", "animFloatP", "Lcom/obric/oui/animation/engine/FloatPropertyCompat;", "Landroid/view/View;", "getAnimFloatP", "()Lcom/obric/oui/animation/engine/FloatPropertyCompat;", "springAnimatorTagKey", "", "getSpringAnimatorTagKey", "()I", "startStackTransitionAnimation", "", "popover", "Lcom/obric/oui/popover/v2/OPopoverBase;", "toTop", "", "targetContentAlpha", "", "targetScale", "startVisibilityAnimation", "Landroid/animation/AnimatorSet;", "view", "Landroid/view/ViewGroup;", "isWindowMode", "gravity", "pivotX", "pivotY", "isIn", "customAnimator", "Landroid/animation/Animator;", "onAnimationStart", "Lkotlin/Function0;", "onAnimationEnd", "CommonFloatProperty", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14353a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f14354b = 0;
    private static final com.obric.oui.animation.a.c<View> c = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverAnimationHelper$CommonFloatProperty;", "", EventBody.KEY_VALUE, "", "(F)V", "getValue", "()F", "setValue", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f14355a;

        public a(float r1) {
            this.f14355a = r1;
        }

        public final float a() {
            return this.f14355a;
        }

        public final void a(float r1) {
            this.f14355a = r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.popover.v2.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"com/obric/oui/popover/v2/OPopoverAnimationHelper$animFloatP$1", "Lcom/obric/oui/animation/engine/FloatPropertyCompat;", "Landroid/view/View;", "getValue", "", "obj", "setValue", "", EventBody.KEY_VALUE, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0766b extends com.obric.oui.animation.a.c<View> {
        C0766b() {
            super(BaseSwitches.V);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public float a2(View r4) {
            if (r4 == null) goto L20;
            Object r5 = r4.getTag(b.f14353a.a());
            if (r5 == null) goto L21;
            com.obric.oui.c.c r0 = com.obric.oui.c.c.f13403a;
            Float r1 = null;
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L12;
            r5 = null;
        L12:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L16;
            r1 = Float.valueOf(r6.a());
        L16:
            if (r1 != null) goto L19;
            return 0.0f;
        L19:
            return r1.floatValue();
        L21:
            return 0.0f;
        L20:
            return 0.0f;
        }

        @Override // com.obric.oui.animation.a.c
        public /* synthetic */ float a(View r3) {
            return a2((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(View r2, float r3) {
            if (r2 == null) goto L16;
            Object r1 = r2.getTag(b.f14353a.a());
            if (r1 == null) goto L17;
            com.obric.oui.c.c r4 = com.obric.oui.c.c.f13403a;
            if (ZeusTransformUtils.instanceOf(r1, a.class) == true) goto L11;
            r1 = null;
        L11:
            a r5 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L18;
            r5.a(r3);
            return;
        L18:
            return;
        L17:
            return;
        }

        @Override // com.obric.oui.animation.a.c
        public /* synthetic */ void a(View r3, float r4) {
            a2((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/popover/v2/OPopoverAnimationHelper$startVisibilityAnimation$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f14356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f14357b;
        final /* synthetic */ Ref.ObjectRef<com.obric.oui.animation.easy.b<? extends View>> c;
        final /* synthetic */ Function0<Unit> d;
        final /* synthetic */ Function0<Unit> e;

        c(boolean r3, ViewGroup r4, Ref.ObjectRef<com.obric.oui.animation.easy.b<? extends View>> r5, Function0<Unit> r6, Function0<Unit> r7) {
            Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
            this.f14356a = r3;
            this.f14357b = r4;
            this.c = r5;
            this.d = r8;
            this.e = r9;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            super.onAnimationCancel(r3);
            this.f14357b.setLayerType(0, null);
            com.obric.oui.animation.easy.b r2 = (com.obric.oui.animation.easy.b) ZeusTransformUtils.preCheckCast(this.c.element, com.obric.oui.animation.easy.b.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            r2.c();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            super.onAnimationEnd(r3);
            this.f14357b.setLayerType(0, null);
            if (this.f14356a == true) goto L5;
            this.f14357b.setVisibility(8);
        L5:
            Function0<Unit> r2 = this.e;
            if (r2 == null) goto L10;
            r2.invoke();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            super.onAnimationStart(r3);
            if (this.f14356a == false) goto L5;
            this.f14357b.setLayerType(2, null);
        L5:
            com.obric.oui.animation.easy.b r4 = (com.obric.oui.animation.easy.b) ZeusTransformUtils.preCheckCast(this.c.element, com.obric.oui.animation.easy.b.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L10;
            r4.b();
        L10:
            if (this.f14356a == false) goto L17;
            Function0<Unit> r5 = this.d;
            if (r5 == null) goto L15;
            r5.invoke();
        L15:
            this.f14357b.setVisibility(0);
            return;
        }
    }

    static {
        f14353a = new b();
        f14354b = ZeusTransformUtils.mapRes(R.id.o_popover_anim_p, OaidModel.KEY_ID, "o_popover_anim_p");
        c = (com.obric.oui.animation.a.c) ZeusTransformUtils.preCheckCast(new C0766b(), com.obric.oui.animation.a.c.class, "com.obric.memorydata.plugin");
    }

    private b() {
    }

    private static final void a(ViewGroup r1, float r2, float r3, float r4, float r5, float r6, float r7, com.obric.oui.animation.a.b r8, float r9, float r10) {
        Intrinsics.checkNotNullParameter(r1, "$view");
        com.obric.oui.c.c r11 = com.obric.oui.c.c.f13403a;
        Object r12 = r1.getTag(f14354b);
        if (r12 != null) goto L6;
    L4:
        r12 = null;
    L8:
        if (((a) ZeusTransformUtils.preCheckCast(r12, a.class, "com.obric.memorydata.plugin")) == null) goto L11;
        float r13 = com.obric.oui.c.b.a(r9, r2, r3);
        float r14 = r4 + ((r5 - r4) * r13);
        r1.setScaleX(r14);
        r1.setScaleY(r14);
        r1.setTranslationY(r6 + ((r7 - r6) * r13));
        return;
    L11:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r12, a.class) == false) goto L4;
        goto L4
    }

    private static final void a(ViewGroup r1, float r2, float r3, float r4, float r5, View r6, float r7, float r8, com.obric.oui.animation.a.b r9, float r10, float r11) {
        Intrinsics.checkNotNullParameter(r1, "$view");
        com.obric.oui.c.c r12 = com.obric.oui.c.c.f13403a;
        Object r13 = r1.getTag(f14354b);
        if (r13 != null) goto L6;
    L4:
        r13 = null;
    L8:
        if (((a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.memorydata.plugin")) == null) goto L11;
        float r14 = com.obric.oui.c.b.a(r10, r2, r3);
        float r15 = r4 + ((r5 - r4) * r14);
        r1.setScaleX(r15);
        r1.setScaleY(r15);
        r6.setAlpha(r7 + ((r8 - r7) * r14));
        return;
    L11:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r13, a.class) == false) goto L4;
        goto L4
    }

    public static /* synthetic */ void lambda$LKwSiYDyfZIw1dkDZVg2s0FxK4A(ViewGroup r0, float r1, float r2, float r3, float r4, float r5, float r6, com.obric.oui.animation.a.b r7, float r8, float r9) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: lambda$vKFV0E7mtdbTLT-C_jXAGl2Rrt0, reason: not valid java name */
    public static /* synthetic */ void m1341lambda$vKFV0E7mtdbTLTC_jXAGl2Rrt0(ViewGroup r0, float r1, float r2, float r3, float r4, View r5, float r6, float r7, com.obric.oui.animation.a.b r8, float r9, float r10) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public final int a() {
        return f14354b;
    }

    /* JADX WARN: Type inference failed for: r14v4, types: [T, com.obric.oui.animation.easy.b] */
    public final AnimatorSet a(final ViewGroup r21, boolean r22, int r23, float r24, float r25, boolean r26, Animator r27, Function0<Unit> r28, Function0<Unit> r29) {
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r28, Function0.class, "com.obric.memorydata.plugin");
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r29, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r21, "view");
        r21.setPivotX(r24);
        r21.setPivotY(r25);
        r21.setVisibility(0);
        AnimatorSet r12 = new AnimatorSet();
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        if (r27 == null) goto L5;
        r12.play(r27);
    L52:
        r12.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new c(r26, r21, r13, r10, r11), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r12.start();
        return r12;
    L5:
        PathInterpolator r1 = new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f);
        final float r3 = 0.0f;
        if (r26 == false) goto L8;
        float r4 = 0.0f;
    L9:
        if (r26 == false) goto L11;
        float r5 = 1.0f;
    L12:
        int r14 = 1;
        if (r21.getAlpha() != 0.0f) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L18;
    L23:
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r21, "alpha", new float[]{r4, r5});
        r2.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r1, TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r2.setDuration(100);
        r12.play((Animator) ZeusTransformUtils.preCheckCast(r2, Animator.class, "com.obric.memorydata.plugin"));
        if (r26 == false) goto L26;
        final float r6 = 0.2f;
    L27:
        if (r26 == false) goto L29;
        final float r8 = 1.0f;
    L31:
        if (r23 != 48) goto L35;
        r14 = -1;
    L35:
        if (r26 == false) goto L37;
        float r9 = -h.b((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin"), 10);
    L38:
        float r15 = r14;
        final float r16 = r9 * r15;
        if (r26 == false) goto L41;
        float r0 = 0.0f;
    L42:
        final float r17 = r0 * r15;
        if (r26 == false) goto L45;
        final float r18 = 0.0f;
    L46:
        if (r26 == false) goto L49;
        r3 = 10000.0f;
    L49:
        if (com.obric.oui.animation.easy.c.a((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin")).a() == true) goto L51;
        r21.setScaleX(r6);
        r21.setScaleY(r6);
        r21.setTranslationY(r16);
        r21.setTag(f14354b, new a(r18));
    L51:
        ?? r19 = com.obric.oui.animation.easy.b.a(com.obric.oui.animation.easy.c.a((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin")).a(0.85f).b(632.0f), c, r3, null, 4, null);
        r19.a(new $$Lambda$b$LKwSiYDyfZIw1dkDZVg2s0FxK4A(r21, r18, r3, r6, r8, r16, r17));
        r13.element = r19;
        goto L52
    L45:
        r18 = 10000.0f;
        goto L46
    L41:
        r0 = -h.b((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin"), 10);
        goto L42
    L37:
        r9 = 0.0f;
        goto L38
    L29:
        r8 = 0.2f;
        goto L31
    L26:
        r6 = 1.0f;
        goto L27
    L18:
        if (r21.getAlpha() != 1.0f) goto L20;
        boolean r20 = true;
    L21:
        if (r20 == true) goto L23;
        r4 = r21.getAlpha();
        goto L23
    L20:
        r20 = false;
        goto L21
    L15:
        r7 = false;
        goto L16
    L11:
        r5 = 0.0f;
        goto L12
    L8:
        r4 = 1.0f;
        goto L9
    }

    public final void a(com.obric.oui.popover.v2.c<?> r17, boolean r18, final float r19, final float r20) {
        com.obric.oui.popover.v2.c r0 = (com.obric.oui.popover.v2.c) ZeusTransformUtils.wrapperContextForParams(r17, com.obric.oui.popover.v2.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "popover");
        final ViewGroup r4 = r0.getPopoverWindowFrame();
        final View r9 = r0.getPopoverBubbleLayout().getChildAt(0);
        if (r18 == false) goto L5;
        float r1 = 0.8f;
    L7:
        if (r18 == false) goto L9;
        final float r5 = 0.0f;
    L10:
        if (r18 == false) goto L12;
        final float r6 = 10000.0f;
    L13:
        final float r7 = r4.getScaleX();
        final float r2 = r9.getAlpha();
        com.obric.oui.animation.easy.b r3 = com.obric.oui.animation.easy.b.a(com.obric.oui.animation.easy.c.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin")).a(r1).b(439.0f), c, r6, null, 4, null);
        r3.a(new $$Lambda$b$vKFV0E7mtdbTLTC_jXAGl2Rrt0(r4, r5, r6, r7, r20, r9, r2, r19));
        r3.b();
        return;
    L12:
        r6 = 0.0f;
        goto L13
    L9:
        r5 = 10000.0f;
        goto L10
    L5:
        r1 = 1.0f;
        goto L7
    }
}
