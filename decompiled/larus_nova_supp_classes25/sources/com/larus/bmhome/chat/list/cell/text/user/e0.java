package com.larus.bmhome.chat.list.cell.text.user;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ViewGroup.LayoutParams a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ TextView f;

    public /* synthetic */ e0(ViewGroup.LayoutParams r1, int r2, int r3, int r4, int r5, CustomMarkdownTextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        ViewGroup.LayoutParams r0 = this.a;
        int r1 = this.b;
        int r2 = this.c;
        int r3 = this.d;
        int r4 = this.e;
        TextView r5 = this.f;
        int r6 = UserTextCell.z;
        Intrinsics.checkNotNullParameter(r8, "it");
        Object r9 = r8.getAnimatedValue();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Float");
        float r10 = ((Float) r9).floatValue();
        r0.width = r1 + ((int) ((r2 - r1) * r10));
        r0.height = r3 + ((int) ((r4 - r3) * r10));
        r5.setLayoutParams(r0);
    }
}
