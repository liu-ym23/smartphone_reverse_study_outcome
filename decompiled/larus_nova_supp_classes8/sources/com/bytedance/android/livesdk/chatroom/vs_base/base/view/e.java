package com.bytedance.android.livesdk.chatroom.vs_base.base.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public final long a;
    public final Animator b;
    public final ArrayList<Animator> c;
    public Function0<Unit> d;
    public Function0<Unit> e;

    public static final class a {
    }

    public static final class b {
        public final e a;

        public final void a() {
            e r0 = this.a;
            r0.b.cancel();
            r0.b.removeAllListeners();
            if (r0.d == null) goto L5;
        L7:
            r0.b.addListener(new g(r0));
        L8:
            Animator r1 = r0.b;
            if ((r1 instanceof AnimatorSet) == true) goto L11;
            r1 = null;
        L11:
            AnimatorSet r2 = (AnimatorSet) r1;
            if (r2 == null) goto L14;
            r2.playSequentially(r0.c);
        L14:
            r0.b.start();
            return;
        L5:
            if (r0.e != null) goto L7;
            goto L7
        }

        public b(e r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            this.a = r2;
        }
    }

    static {
    }

    public e() {
        this.a = -1;
        this.b = new AnimatorSet();
        this.c = new ArrayList();
    }

    public final void a(Function1<? super com.bytedance.android.livesdk.chatroom.vs_base.base.view.b, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "anim");
        com.bytedance.android.livesdk.chatroom.vs_base.base.view.b r0 = new com.bytedance.android.livesdk.chatroom.vs_base.base.view.b();
        r6.invoke(r0);
        Animator r7 = r0.a;
        if (r0.e == null) goto L5;
    L7:
        r7.addListener(new com.bytedance.android.livesdk.chatroom.vs_base.base.view.a(r0));
    L8:
        r7.setDuration(r0.d);
        r7.setInterpolator(r0.g);
        r7.setStartDelay(0);
        if ((r7 instanceof AnimatorSet) == true) goto L11;
        Animator r3 = null;
    L12:
        AnimatorSet r4 = (AnimatorSet) r3;
        if (r4 == null) goto L15;
        r4.playTogether(r0.b);
    L15:
        long r5 = this.a;
        if (r5 < 0) goto L18;
        r7.setDuration(r5);
    L18:
        this.c.add(r7);
        return;
    L11:
        r3 = r7;
        goto L12
    L5:
        if (r0.f != null) goto L7;
        goto L7
    }
}
