package com.bytedance.android.livesdk.interactivity.like.barrage;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.core.math.MathUtils;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import com.ss.ugc.live.barrage.controller.AbsBarrageController;
import com.ss.ugc.live.barrage.view.BarrageLayout;
import java.util.ArrayList;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends AbsBarrageController {
    public final float[] n;
    public final ArrayList<Float> o;
    public final PathMeasure p;
    public final int q;

    public static final class a {
    }

    static {
    }

    public final void m() {
        p();
        this.o.clear();
        super.m();
    }

    public final void i(AbsBarrage r2) {
        Intrinsics.checkNotNullParameter(r2, "barrage");
        o();
    }

    public final void j(com.ss.ugc.live.barrage.util.a r18, float r19) {
        Intrinsics.checkNotNullParameter(r18, "runningBarrageList");
        float r2 = r19 / this.q;
        com.ss.ugc.live.barrage.util.a.a r3 = r18.iterator();
        ListIterator<Float> r4 = this.o.listIterator();
    L3:
        com.ss.ugc.live.barrage.util.a.a r5 = r3;
        if (r5.hasNext() == false) goto L25;
        com.bytedance.android.livesdk.interactivity.like.barrage.a r6 = (AbsBarrage) r5.next();
        float r11 = r4.next().floatValue();
        if ((r6 instanceof com.bytedance.android.livesdk.interactivity.like.barrage.a) == false) goto L3;
        float[] r13 = new float[2];
        float[] r14 = new float[2];
        PathMeasure r15 = this.p;
        r15.getPosTan(r15.getLength() * r11, r13, null);
        PathMeasure r16 = this.p;
        float r17 = r11 + r2;
        r16.getPosTan(r17 * r16.getLength(), r14, null);
        RectF r7 = ((AbsBarrage) r6).f;
        float r8 = r7.top;
        float r110 = r14[1] - r13[1];
        r7.top = r8 + r110;
        r7.bottom += r110;
        float r9 = r7.left;
        float r111 = r14[0] - r13[0];
        r7.left = r9 + r111;
        r7.right += r111;
        if (r17 <= 0.75f) goto L12;
        r6.t = (int) (((1.0f - r11) - r2) * 612.0f);
    L12:
        if (r17 < 0.2f) goto L17;
        com.bytedance.android.livesdk.interactivity.like.barrage.a r10 = r6;
        if (r10.s <= 0.8f) goto L17;
        r10.s = 0.8f;
    L19:
        if (r17 >= 1) goto L20;
        if (r6.t == 0) goto L23;
        r4.set(Float.valueOf(r17));
        goto L3
    L23:
        r5.remove();
        r4.remove();
        goto L3
    L20:
        r5.remove();
        r4.remove();
    L17:
        r6.s = MathUtils.clamp((3.2f * r17) + 0.36f, 0.0f, 0.8f);
    L25:
        com.bytedance.android.livesdk.interactivity.like.barrage.a r20 = g();
        if (r20 == null) goto L27;
        if ((r20 instanceof com.bytedance.android.livesdk.interactivity.like.barrage.a) == false) goto L25;
        float r21 = ((AbsBarrage) r20).f.width();
        float r23 = ((AbsBarrage) r20).f.height();
        RectF r24 = ((AbsBarrage) r20).f;
        float[] r25 = this.n;
        float r26 = r25[0];
        r24.left = r26;
        r24.right = r26 + r21;
        float r27 = r25[1];
        r24.top = r27;
        r24.bottom = r27 + r23;
        r20.s = 0.36f;
        r18.add(r20);
        this.o.add(Float.valueOf(0.0f));
        goto L25
    }

    public d(BarrageLayout r2, Path r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "barrageView");
        Intrinsics.checkNotNullParameter(r3, "path");
        super(r2);
        this.q = r4;
        float[] r5 = new float[2];
        this.n = r5;
        this.o = new ArrayList();
        PathMeasure r6 = new PathMeasure();
        r6.setPath(r3, false);
        r6.getPosTan(0.0f, r5, null);
        Unit r7 = Unit.INSTANCE;
        this.p = r6;
    }
}
