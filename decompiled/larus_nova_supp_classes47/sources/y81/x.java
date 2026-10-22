package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;
    public final /* synthetic */ Ref.IntRef b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationCancel(r2);
        l r3 = this.a;
        r3.S = false;
        r3.h();
    }

    public x(l r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        l r6 = this.a;
        r6.S = false;
        TextSwitcher r7 = r6.p;
        if (r7 == null) goto L5;
        r7.setCurrentText("");
    L5:
        TextSwitcher r8 = this.a.p;
        if (r8 == null) goto L8;
        r8.setVisibility(8);
    L8:
        TextView r9 = this.a.q;
        if (r9 == null) goto L11;
        r9.setVisibility(8);
    L11:
        l r10 = this.a;
        r10.r(r10.t, 1.0f);
        l r12 = this.a;
        int r1 = r12.N;
        if (r1 <= 0) goto L14;
        r12.m(r1);
    L28:
        View r13 = this.a.z;
        if (r13 == null) goto L31;
        r13.setVisibility(0);
    L31:
        HSImageView r14 = this.a.o;
        if (r14 == null) goto L34;
        r14.setVisibility(0);
    L34:
        List<String> r15 = this.a.s;
        if (r15 != null) goto L37;
    L39:
        this.a.h();
        RelativeLayout r16 = this.a.t;
        if (r16 == null) goto L46;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L47;
        r17.width = -2;
        return;
    L47:
        return;
    L46:
        return;
    L37:
        if ((!((ArrayList) r15).isEmpty()) != true) goto L39;
        this.a.o();
        return;
    L14:
        ViewGroup r18 = r12.n;
        if (r18 != null) goto L17;
    L21:
        TextSwitcher r19 = this.a.H;
        if (r19 == null) goto L28;
        if (r19.getVisibility() != 8) goto L28;
        TextSwitcher r20 = this.a.H;
        if (r20 == null) goto L28;
        r20.setVisibility(0);
        goto L28
    L17:
        if (r18.getVisibility() != 0) goto L21;
        ViewGroup r22 = this.a.n;
        if (r22 == null) goto L21;
        r22.setVisibility(8);
        goto L21
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "animation");
        Ref.IntRef r3 = this.b;
        ViewGroup r4 = this.a.k;
        if (r4 == null) goto L5;
        int r5 = r4.getWidth();
    L6:
        r3.element = r5;
        return;
    L5:
        r5 = 0;
        goto L6
    }
}
