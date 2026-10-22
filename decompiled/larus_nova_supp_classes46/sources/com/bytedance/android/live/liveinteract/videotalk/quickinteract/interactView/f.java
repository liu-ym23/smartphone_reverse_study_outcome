package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public final TextSwitcher a;
    public final TextView b;
    public final TextView c;
    public String d;

    public interface a {
        void a(String r1);
    }

    public f(View r4) {
        Intrinsics.checkNotNullParameter(r4, "parentContext");
        TextSwitcher r0 = (TextSwitcher) r4.findViewById(2131385176);
        this.a = r0;
        this.b = (TextView) r4.findViewById(2131388545);
        this.c = (TextView) r4.findViewById(2131385178);
        this.d = "0";
        r0.setMeasureAllChildren(false);
        r0.setInAnimation(AnimationUtils.loadAnimation(r0.getContext(), 2130772691));
        r0.setOutAnimation(AnimationUtils.loadAnimation(r0.getContext(), 2130772692));
        r0.setCurrentText("0");
        this.d = "0";
    }

    public static AnimatorSet a(f r2, String r3, long r4, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = 300;
    L6:
        if ((r6 & 4) == 0) goto L8;
        long r0 = 350;
    L9:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "score");
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{0, 1});
        r7.setDuration(r0);
        r7.setStartDelay(r4);
        r7.addListener(new g(r2, r3));
        AnimatorSet r5 = new AnimatorSet();
        r5.play(r7);
        return r5;
    L8:
        r0 = 0;
        goto L9
    }
}
