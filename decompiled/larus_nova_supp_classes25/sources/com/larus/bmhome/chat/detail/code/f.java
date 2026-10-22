package com.larus.bmhome.chat.detail.code;

import android.animation.ValueAnimator;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ CustomMarkdownTextView a;
    public final /* synthetic */ CodeBlockDetailFragment b;
    public final /* synthetic */ int c;

    public /* synthetic */ f(CustomMarkdownTextView r1, CodeBlockDetailFragment r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CustomMarkdownTextView r0 = this.a;
        final CodeBlockDetailFragment r1 = this.b;
        int r2 = this.c;
        int r3 = CodeBlockDetailFragment.k0;
        int r4 = r0.getMeasuredHeight();
        ValueAnimator r5 = r1.V;
        if (r5 == null) goto L5;
        r5.cancel();
    L5:
        ValueAnimator r6 = ValueAnimator.ofInt(new int[]{r2, r4});
        r1.V = r6;
        r6.setDuration(500);
        r6.addUpdateListener(new p(r1));
        r6.addListener(new e0(r1, r6));
        r6.start();
    }
}
