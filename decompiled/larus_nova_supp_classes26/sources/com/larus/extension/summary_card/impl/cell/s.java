package com.larus.extension.summary_card.impl.cell;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.layout.widget.MaxHeightRelativeLayout;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s implements Animator.AnimatorListener {
    public final /* synthetic */ SummaryCardBox a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ BotModel c;
    public final /* synthetic */ Function2<String, Boolean, Unit> d;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r6) {
        Intrinsics.checkNotNullParameter(r6, "animation");
        View r7 = this.a.x;
        if (r7 == null) goto L5;
        e1.o(r7);
    L5:
        MaxHeightRelativeLayout r8 = this.a.u;
        if (r8 == null) goto L8;
        r8.setAlpha(1.0f);
    L8:
        TextView r9 = this.a.y;
        if (r9 == null) goto L11;
        r9.setAlpha(1.0f);
    L11:
        View r10 = this.a.v;
        if (r10 == null) goto L14;
        r10.setAlpha(1.0f);
    L14:
        final SummaryCardBox r11 = this.a;
        TextView r0 = r11.y;
        if (r0 == null) goto L17;
        final Message r1 = this.b;
        final BotModel r2 = this.c;
        final Function2<String, Boolean, Unit> r3 = this.d;
        e1.d(r0, new q(r11, r1, r2, r3));
    L17:
        ConstraintLayout r12 = this.a.z;
        if (r12 == null) goto L24;
        ViewGroup.LayoutParams r4 = r12.getLayoutParams();
        if (r4 == null) goto L23;
        r4.height = -2;
        r12.setLayoutParams(r4);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r6) {
        Intrinsics.checkNotNullParameter(r6, "animation");
        View r7 = this.a.x;
        if (r7 == null) goto L5;
        e1.o(r7);
    L5:
        MaxHeightRelativeLayout r8 = this.a.u;
        if (r8 == null) goto L8;
        r8.setAlpha(1.0f);
    L8:
        TextView r9 = this.a.y;
        if (r9 == null) goto L11;
        r9.setAlpha(1.0f);
    L11:
        View r10 = this.a.v;
        if (r10 == null) goto L14;
        r10.setAlpha(1.0f);
    L14:
        final SummaryCardBox r11 = this.a;
        TextView r0 = r11.y;
        if (r0 == null) goto L17;
        final Message r1 = this.b;
        final BotModel r2 = this.c;
        final Function2<String, Boolean, Unit> r3 = this.d;
        e1.d(r0, new r(r11, r1, r2, r3));
    L17:
        ConstraintLayout r12 = this.a.z;
        if (r12 == null) goto L24;
        ViewGroup.LayoutParams r4 = r12.getLayoutParams();
        if (r4 == null) goto L23;
        r4.height = -2;
        r12.setLayoutParams(r4);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        View r3 = this.a.x;
        if (r3 == null) goto L5;
        r3.setAlpha(1.0f);
    L5:
        TextView r4 = this.a.y;
        if (r4 == null) goto L8;
        e1.x(r4);
    L8:
        TextView r5 = this.a.y;
        if (r5 == null) goto L11;
        r5.setAlpha(0.0f);
    L11:
        View r6 = this.a.v;
        if (r6 == null) goto L14;
        e1.x(r6);
    L14:
        View r7 = this.a.v;
        if (r7 == null) goto L17;
        r7.setAlpha(0.0f);
    L17:
        MaxHeightRelativeLayout r8 = this.a.u;
        if (r8 == null) goto L20;
        e1.x(r8);
    L20:
        MaxHeightRelativeLayout r9 = this.a.u;
        if (r9 == null) goto L24;
        r9.setAlpha(0.0f);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(SummaryCardBox r1, Message r2, BotModel r3, Function2<? super String, ? super Boolean, Unit> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
