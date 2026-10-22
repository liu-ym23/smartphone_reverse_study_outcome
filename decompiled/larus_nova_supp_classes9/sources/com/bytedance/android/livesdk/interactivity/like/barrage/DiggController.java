package com.bytedance.android.livesdk.interactivity.like.barrage;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.config.eg;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.config.kn;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.ss.ugc.live.barrage.controller.AbsBarrageController;
import com.ss.ugc.live.barrage.view.BarrageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class DiggController extends AbsBarrageController {
    public final int n;
    public final ArrayList<d> o;
    public final Random p;
    public float q;
    public final Handler r;
    public final Boolean s;
    public final BarrageLayout t;

    public static final class a {
    }

    static {
    }

    public final void m() {
        this.r.removeCallbacksAndMessages(null);
        p();
        Iterator<T> r0 = this.o.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).m();
        goto L4
    L6:
        super.m();
    }

    public final int r() {
        int r0 = (((AbsBarrageController) this).a.size() + ((LinkedList) ((AbsBarrageController) this).c).size()) + ((LinkedList) ((AbsBarrageController) this).b).size();
        Iterator r1 = SequencesKt.map(CollectionsKt.asSequence(this.o), DiggController$size$1.INSTANCE).iterator();
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
    L6:
        if (r1.hasNext() == false) goto L9;
        int r3 = ((Number) r1.next()).intValue();
        r2 = Integer.valueOf(((Number) r2).intValue() + r3);
        goto L6
    L9:
        return r0 + ((Number) r2).intValue();
    L11:
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    public DiggController(BarrageLayout r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "barrageView");
        super(r2);
        this.t = r2;
        this.n = r3;
        this.o = new ArrayList();
        this.p = new Random();
        this.q = 1.0f;
        this.r = new Handler(Looper.getMainLooper());
        Boolean r4 = (Boolean) eg.a.getValue();
        this.s = r4;
        if (r4.booleanValue() == false) goto L5;
        ((AbsBarrageController) this).h = true;
    L5:
        ((AbsBarrageController) this).g = ((Boolean) h21.d.getValue()).booleanValue();
    }

    public final void j(com.ss.ugc.live.barrage.util.a r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "runningBarrageList");
        float r13 = this.q + (r11 / this.n);
        this.q = r13;
        if (r13 > 0.2f) goto L5;
        return;
    L5:
        if (kotlin.random.Random.Default.nextInt(1, 100) >= (((Number) InteractivityOpt.c(kn.a)).floatValue() * 100)) goto L7;
        return;
    L7:
        int r14 = this.p.nextInt(2) + 1;
        int r2 = 0;
        long r3 = 0;
    L8:
        if (r2 >= r14) goto L14;
        c r5 = new c(this);
        if (r3 > 0) goto L12;
        this.r.post(r5);
    L13:
        r3 = r3 + Math.max(200, this.p.nextInt((int) ((this.n * 0.2f) / r14)));
        r2 = r2 + 1;
        goto L8
    L12:
        this.r.postDelayed(r5, r3);
        goto L13
    L14:
        this.q = 0.0f;
    }
}
