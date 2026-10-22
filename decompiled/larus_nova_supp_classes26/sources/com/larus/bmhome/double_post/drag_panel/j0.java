package com.larus.bmhome.double_post.drag_panel;

import android.animation.ValueAnimator;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class j0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Ref.IntRef a;
    public final /* synthetic */ RecyclerView b;
    public final /* synthetic */ ChatAwemeNestedContainer c;

    public /* synthetic */ j0(Ref.IntRef r1, RecyclerView r2, ChatAwemeNestedContainer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        Ref.IntRef r0 = this.a;
        RecyclerView r1 = this.b;
        ChatAwemeNestedContainer r2 = this.c;
        int r3 = ChatAwemeNestedContainer.q;
        Intrinsics.checkNotNullParameter(r8, "animator");
        Object r9 = r8.getAnimatedValue();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Int");
        int r10 = ((Integer) r9).intValue();
        int r4 = r10 - r0.element;
        if (r4 > 0) goto L6;
        return;
    L6:
        if (r1 == null) goto L8;
        int r5 = r1.computeVerticalScrollOffset();
    L9:
        int r6 = Math.min(r4, r5);
        if (r6 <= 0) goto L13;
        if (r1 == null) goto L13;
        r1.scrollBy(0, -r6);
    L13:
        int r7 = r4 - r6;
        if (r7 <= 0) goto L16;
        r2.scrollTo(0, RangesKt.coerceAtLeast(r2.getScrollY() - r7, 0));
    L16:
        r0.element = r10;
        return;
    L8:
        r5 = 0;
        goto L9
    }
}
