package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.animation.AnimatorSet;
import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.livesdk.vs.LiveBlurAnimView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public static final /* synthetic */ int e = 0;
    public py.k a;
    public FrameLayout b;
    public wr1.b c;
    public AnimatorSet d;

    public static final class a {
    }

    static {
    }

    public g() {
    }

    private final Context getContext() {
        FrameLayout r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContext();
    }

    public final void b() {
        AnimatorSet r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() != true) goto L11;
        AnimatorSet r1 = this.d;
        if (r1 == null) goto L12;
        r1.cancel();
        return;
    L12:
        return;
    }

    public final void a(py.k r3, FrameLayout r4, int r5, ImageView.ScaleType r6) {
        Intrinsics.checkNotNullParameter(r6, "scaleType");
        this.a = r3;
        this.b = r4;
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.c != null) goto L8;
        yr1.d r7 = r.d();
        Context r8 = getContext();
        Intrinsics.checkNotNull(r8);
        this.c = r7.j(r8);
    L8:
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-1, -1);
        r9.gravity = 17;
        wr1.b r10 = this.c;
        if (r10 == null) goto L13;
        LiveBlurAnimView r11 = r10.getView();
        if (r11 == null) goto L13;
        r11.setLayoutParams(r9);
        r11.setVisibility(0);
    L13:
        wr1.b r12 = this.c;
        if (r12 != null) goto L16;
    L56:
        wr1.b r13 = this.c;
        if (r13 == null) goto L60;
        r13.a(this.a, r5, r6);
    L60:
        if (this.a == null) goto L70;
        b();
        wr1.b r14 = this.c;
        if (r14 == null) goto L68;
        LiveBlurAnimView r15 = r14.getView();
        if (r15 == null) goto L69;
        r15.setVisibility(0);
        r15.setAlpha(1.0f);
        return;
    L69:
        return;
    L68:
        return;
    L70:
        return;
    L16:
        if (this.b == null) goto L56;
        LiveBlurAnimView r16 = r12.getView();
        if (r16 == null) goto L21;
        r16.setVisibility(8);
    L21:
        wr1.b r17 = this.c;
        LiveBlurAnimView r18 = null;
        if (r17 == null) goto L26;
        LiveBlurAnimView r19 = r17.getView();
        if (r19 == null) goto L26;
        ViewParent r20 = r19.getParent();
    L28:
        if ((r20 instanceof ViewGroup) == true) goto L30;
        r20 = null;
    L30:
        ViewGroup r21 = (ViewGroup) r20;
        if (r21 == null) goto L37;
        wr1.b r1 = this.c;
        if (r1 == null) goto L35;
        LiveBlurAnimView r2 = r1.getView();
    L36:
        r21.removeView(r2);
        goto L37
    L35:
        r2 = null;
    L37:
        FrameLayout r22 = this.b;
        if (r22 == null) goto L56;
        wr1.b r23 = this.c;
        if (r23 == null) goto L42;
        LiveBlurAnimView r24 = r23.getView();
    L44:
        if (r22.indexOfChild(r24) >= 0) goto L56;
        wr1.b r25 = this.c;
        if (r25 == null) goto L50;
        LiveBlurAnimView r26 = r25.getView();
        if (r26 == null) goto L50;
        r26.setVisibility(0);
    L50:
        FrameLayout r27 = this.b;
        if (r27 == null) goto L56;
        wr1.b r28 = this.c;
        if (r28 == null) goto L55;
        r18 = r28.getView();
    L55:
        r27.addView(r18);
        goto L56
    L42:
        r24 = null;
    L26:
        r20 = null;
        goto L28
    }
}
