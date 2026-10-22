package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.base.model.message.u0;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.z;
import com.bytedance.android.livesdk.utils.AnAnimator;
import com.bytedance.android.livesdk.utils.q4;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class b {
    public final AccelerateDecelerateInterpolator a;
    public long b;
    public final Lazy c;
    public final d d;
    public final e e;
    public final Lazy f;
    public final Lazy g;
    public final c h;
    public final View i;
    public final BaseWindScreenAnimEnterTrayView j;
    public final i k;

    public static final class a {
    }

    static {
    }

    public abstract Function1<AnAnimator, Unit> b();

    public abstract Function1<AnAnimator, Unit> c();

    public abstract Function1<AnAnimator, Unit> d();

    public static final void a(b r6) {
        com.bytedance.android.live.base.model.message.e r0 = r6.j.getComboInfo();
        if (r0 != null) goto L5;
        ((q4.b) r6.g.getValue()).c();
        return;
    L5:
        z r1 = (z) r6.k;
        r1.b.o1();
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r2 = r1.a;
        long r3 = r0.b().longValue();
        v72.f r4 = ((v72.c.a) r2).a.e;
        com.bytedance.android.live.base.model.message.d r5 = null;
        if (r4 == null) goto L13;
        LinkedList<k32.d> r7 = r4.a.get(Long.valueOf(r3));
        if (r7 == null) goto L13;
        if (r7.isEmpty() == false) goto L12;
        r4.a.remove(Long.valueOf(r3));
        goto L13
    L12:
        k32.d r8 = r7.removeFirst();
    L14:
        if (r8 != null) goto L16;
    L20:
        u0 r9 = ((z) r6.k).c;
        if (r9 == null) goto L23;
        long r10 = r9.a();
    L24:
        if (r5 != null) goto L26;
    L28:
        ((q4.b) r6.g.getValue()).c();
        return;
    L26:
        if (r6.b >= r10) goto L28;
        r6.j.S5(r5, r6.d);
        return;
    L23:
        r10 = 0;
        goto L24
    L16:
        if (r8.a() == false) goto L20;
        h3 r11 = r8.t;
        if (r11 == null) goto L20;
        r5 = r11.I0();
    L13:
        r8 = null;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(BaseWindScreenAnimEnterTrayView r2, BaseWindScreenAnimEnterTrayView r3, z r4) {
        Intrinsics.checkNotNullParameter(r2, "animView");
        Intrinsics.checkNotNullParameter(r3, "comboView");
        Intrinsics.checkNotNullParameter(r4, "comboAnimBridge");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.a = new AccelerateDecelerateInterpolator();
        this.c = LazyKt.lazy(new ComboEnterAnimHelper$enterAnim$2(this));
        this.d = new d(this);
        this.e = new e(this);
        this.f = LazyKt.lazy(new ComboEnterAnimHelper$stayAnim$2(this));
        this.g = LazyKt.lazy(new ComboEnterAnimHelper$exitAnim$2(this));
        this.h = new c(this);
    }
}
