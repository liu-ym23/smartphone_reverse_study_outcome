package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.anchor.AnchorTrayPostEffectService;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.scope.m;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import i12.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public AnimatedDrawable2 a;
    public AnimatorSet b;
    public final HSImageView c;
    public final View d;
    public final View e;
    public final View f;
    public final ViewGroup g;
    public final TextView h;
    public final q02.d i;
    public final NormalGiftMessage j;

    public static final class a {
    }

    static {
    }

    public final void b() {
        HSImageView r0 = this.c;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        AnimatedDrawable2 r1 = this.a;
        if (r1 == null) goto L8;
        r1.stop();
    L8:
        this.a = null;
        q02.d r2 = this.i;
        if (r2 == null) goto L12;
        r2.b();
        return;
    }

    public final void c() {
        AnimatedDrawable2 r0 = this.a;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        this.a = null;
        AnimatorSet r1 = this.b;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isRunning() != true) goto L18;
        AnimatorSet r2 = this.b;
        if (r2 == null) goto L12;
        r2.removeAllListeners();
    L12:
        AnimatorSet r3 = this.b;
        if (r3 == null) goto L15;
        r3.cancel();
    L15:
        this.b = null;
        return;
    }

    public static final void a(f r4) {
        r4.getClass();
        i12.e r0 = o.b();
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, AnchorTrayPostEffectService.class);
    L6:
        AnchorTrayPostEffectService r2 = (AnchorTrayPostEffectService) r1;
        if (r2 != null) goto L9;
    L12:
        AnimatedDrawable2 r3 = r4.a;
        if (r3 == null) goto L15;
        r3.stop();
    L15:
        r4.a = null;
        q02.d r5 = r4.i;
        if (r5 == null) goto L19;
        r5.b();
        return;
    L19:
        return;
    L9:
        if (com.bytedance.android.livesdk.gift.platform.business.anchor.c.a().b() == false) goto L12;
        r2.a.set(false);
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public f(HSImageView r1, View r2, View r3, View r4, ViewGroup r5, TextView r6, q02.d r7, NormalGiftMessage r8) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
    }
}
