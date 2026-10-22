package com.ss.android.lark.forseti.chain;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingLayout;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingView;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements ForsetiChainFragment.b {
    public final /* synthetic */ ForsetiChainFragment a;

    public static final class a implements com.ss.android.lark.forseti.util.dragging.a.InterfaceC0068a {
        public final /* synthetic */ ForsetiNormalChainDraggingLayout a;
        public final /* synthetic */ List<View> b;
        public final /* synthetic */ float c;
        public final /* synthetic */ ForsetiWidth d;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            ForsetiNormalChainDraggingLayout r5 = this.a;
            if (r5 == null) goto L5;
            r5.l(this.b, false, 0.0f);
        L5:
            ForsetiNormalChainDraggingLayout r6 = this.a;
            if (r6 == null) goto L8;
            r6.j();
        L8:
            ForsetiNormalChainDraggingLayout r7 = this.a;
            if (r7 == null) goto L11;
            r7.p(false);
        L11:
            ForsetiNormalChainDraggingLayout r8 = this.a;
            if (r8 == null) goto L14;
            r8.o(this.c);
        L14:
            this.a.n(this.d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            ForsetiNormalChainDraggingLayout r5 = this.a;
            if (r5 == null) goto L5;
            r5.l(this.b, true, 0.0f);
        L5:
            ForsetiNormalChainDraggingLayout r6 = this.a;
            if (r6 == null) goto L9;
            r6.p(true);
            return;
        }

        @Override // com.ss.android.lark.forseti.util.dragging.a.InterfaceC0068a
        public final void c(float r4, float r5) {
            ForsetiNormalChainDraggingLayout r0 = this.a;
            if (r0 == null) goto L5;
            r0.l(this.b, true, r5);
        L5:
            ForsetiNormalChainDraggingLayout r6 = this.a;
            if (r6 == null) goto L9;
            r6.o(r4);
            return;
        }

        public a(ForsetiNormalChainDraggingLayout r1, List<View> r2, float r3, ForsetiWidth r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public f(ForsetiChainFragment r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.forseti.chain.ForsetiChainFragment.b
    public final void a(ForsetiWidth r10, ForsetiWidth r11) {
        Intrinsics.checkNotNullParameter(r10, "from");
        Intrinsics.checkNotNullParameter(r11, "to");
        ViewGroup r0 = this.a.f;
        ViewGroup r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chainViewGroup");
        r0 = null;
    L5:
        ForsetiNormalChainDraggingLayout r2 = (ForsetiNormalChainDraggingLayout) r0.findViewWithTag("FST_DraggingLayout");
        if (r2 != null) goto L9;
        Log.e("Forseti_ChainFragment", "startAdsorptionAnimation, draggingLayout is null");
        return;
    L9:
        Object r3 = SequencesKt.firstOrNull(ViewGroupKt.getChildren(r2));
        if ((r3 instanceof ForsetiNormalChainDraggingView) == false) goto L12;
        ForsetiNormalChainDraggingView r4 = (ForsetiNormalChainDraggingView) r3;
    L13:
        ForsetiWidth r5 = ForsetiWidth.FULL;
        float r6 = 0.0f;
        if (r10 != r5) goto L16;
        float r7 = 0.0f;
    L17:
        if (r10 != r5) goto L19;
        float r12 = this.a.da0().j(r11);
    L20:
        if (r4 == null) goto L22;
        r6 = r4.getTranslationX();
    L22:
        ForsetiChainFragment r8 = this.a;
        r8.getClass();
        int r9 = cib.b.a;
        ViewGroup r13 = r8.g;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
    L26:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r14 = r1.getChildCount();
        ArrayList r15 = new ArrayList(r14);
        int r16 = 0;
    L27:
        if (r16 >= r14) goto L29;
        r15.add(r1.getChildAt(r16));
        r16 = r16 + 1;
        goto L27
    L29:
        com.ss.android.lark.forseti.util.dragging.a.a(r4, r7, r12, r6, new a(r2, r15, r12, r11));
        return;
    L25:
        r1 = r13;
        goto L26
    L19:
        r12 = 0.0f;
        goto L20
    L16:
        r7 = this.a.da0().j(r10);
        goto L17
    L12:
        r4 = null;
        goto L13
    }
}
