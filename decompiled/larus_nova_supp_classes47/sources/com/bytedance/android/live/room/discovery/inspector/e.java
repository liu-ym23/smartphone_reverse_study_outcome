package com.bytedance.android.live.room.discovery.inspector;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements Runnable {
    public final /* synthetic */ OfficialInspectorWidget a;
    public final /* synthetic */ l b;

    public e(OfficialInspectorWidget r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        OfficialInspectorWidget r0 = this.a;
        TextView r1 = r0.c;
        if (r1 == null) goto L5;
        int r2 = r1.getWidth();
    L6:
        r0.h = r2;
        OfficialInspectorWidget r3 = this.a;
        l r4 = this.b;
        TextView r5 = r3.c;
        LinearLayout r6 = r3.a;
        if (r6 == null) goto L13;
        if (r5 == null) goto L12;
        AnimatorSet r7 = new AnimatorSet();
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r6, "alpha", new float[]{0.0f, 1.0f});
        r8.setDuration(300);
        Unit r9 = Unit.INSTANCE;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{1.0f, 0.0f});
        r10.setStartDelay(r4.c * WebcastRedirectException.UNKNOWN);
        r10.setDuration(600);
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{r3.h, 0});
        r12.setDuration(600);
        r12.addUpdateListener(new g(r3));
        r7.playSequentially(new Animator[]{r8, r10, r12});
        r7.addListener(new h(r3));
        r7.start();
        r3.i = r7;
        AnimatorSet r13 = new AnimatorSet();
        ValueAnimator r14 = ValueAnimator.ofInt(new int[]{0, r3.h});
        r14.setDuration(600);
        r14.addUpdateListener(new i(r3));
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{0.0f, 1.0f});
        r15.setDuration(600);
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{1.0f, 0.0f});
        r16.setStartDelay(r4.c * WebcastRedirectException.UNKNOWN);
        r16.setDuration(600);
        ValueAnimator r17 = ValueAnimator.ofInt(new int[]{r3.h, 0});
        r17.setDuration(600);
        r17.addUpdateListener(new j(r3));
        r13.playSequentially(new Animator[]{r14, r15, r16, r17});
        r13.addListener(new k(r3));
        r3.j = r13;
        return;
    L12:
        return;
    L13:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
