package com.larus.bmhome.chat.layout.item;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import com.larus.avlink.model.DoraCallStateCode;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a0 implements Runnable {
    public final /* synthetic */ ExpertCardBox a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ FrameLayout c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ String e;

    public /* synthetic */ a0(ExpertCardBox r1, boolean r2, FrameLayout r3, boolean r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExpertCardBox r0 = this.a;
        boolean r1 = this.b;
        final FrameLayout r2 = this.c;
        boolean r3 = this.d;
        String r4 = this.e;
        int r5 = r0.r.e.getMeasuredHeight();
        if (r1 == false) goto L5;
        r5 = 0;
    L5:
        float r7 = Math.min(1200.0f, (Math.max(r5, r2.getHeight()) / i5.R()) * 400);
        if (r3 == false) goto L8;
        Number r6 = Float.valueOf(r7);
    L9:
        ValueAnimator r8 = ValueAnimator.ofInt(new int[]{r2.getHeight(), r5});
        r8.addUpdateListener(new c0(r2));
        r8.addListener(new m0(r1, r2));
        r8.setDuration(r6.longValue());
        r8.setInterpolator(r0.s);
        Intrinsics.checkNotNull(r8);
        r8.addListener(new n0(r0, r4, r1));
        r0.o(r1);
        r8.start();
        return;
    L8:
        r6 = Integer.valueOf(DoraCallStateCode.ENV_OBSERVE_END);
        goto L9
    }
}
