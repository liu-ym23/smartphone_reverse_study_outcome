package com.larus.bmhome.chat.list.cell.spacer;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.view.ChatMessageList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SpacerCell a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Ref.IntRef d;
    public final /* synthetic */ View e;
    public final /* synthetic */ Ref.BooleanRef f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ Ref.IntRef h;

    public /* synthetic */ e(SpacerCell r1, int r2, int r3, Ref.IntRef r4, View r5, Ref.BooleanRef r6, boolean r7, Ref.IntRef r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r11) {
        SpacerCell r0 = this.a;
        int r1 = this.b;
        int r2 = this.c;
        Ref.IntRef r3 = this.d;
        View r4 = this.e;
        Ref.BooleanRef r5 = this.f;
        boolean r6 = this.g;
        Ref.IntRef r7 = this.h;
        PathInterpolator r8 = SpacerCell.e;
        Intrinsics.checkNotNullParameter(r11, "animator");
        PathInterpolator r9 = SpacerCell.e;
        Object r12 = r11.getAnimatedValue();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Float");
        float r13 = r9.getInterpolation(((Float) r12).floatValue());
        r0.getClass();
        int r14 = ((int) ((r2 - r1) * r13)) + r1;
        int r10 = r14 - r3.element;
        if (r10 == 0) goto L34;
        SpacerCell.x(r4, r14);
        if (r5.element == false) goto L32;
        if (r10 >= 0) goto L10;
        if (r6 == true) goto L10;
        r4.requestLayout();
    L10:
        ChatMessageList r15 = ((BaseMessageListCell) r0).b;
        LinearLayoutManager r16 = null;
        if ((r15 instanceof ChatMessageList) == false) goto L13;
        ChatMessageList r17 = r15;
    L14:
        if (r17 == null) goto L16;
        RecyclerView.LayoutManager r18 = r17.getLayoutManager();
    L18:
        if ((r18 instanceof LinearLayoutManager) == false) goto L21;
        r16 = (LinearLayoutManager) r18;
    L21:
        if (r17 == null) goto L31;
        if (r16 == null) goto L31;
        if (r17.isAttachedToWindow() == false) goto L31;
        if (r17.getScrollState() != 0) goto L31;
        if (r17.isComputingLayout() == true) goto L32;
        r16.scrollToPositionWithOffset(0, 0);
        r7.element = r14 - r1;
    L31:
        r5.element = false;
        goto L32
    L16:
        r18 = null;
        goto L18
    L13:
        r17 = null;
    L32:
        r3.element = r14;
        return;
    }
}
