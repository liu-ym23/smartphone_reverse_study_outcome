package com.bytedance.android.live.liveinteract.animation.universalwidget.effect;

import android.view.SurfaceView;
import android.view.View;
import androidx.lifecycle.Observer;
import ca0.i;
import com.bytedance.ies.sdk.widgets.KVData;
import kotlin.Pair;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        Pair<Integer, Integer> r6 = this.a.d();
        vc0.a r0 = this.a.a();
        View r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.b;
    L7:
        if ((r2 instanceof d0) == true) goto L9;
        r2 = null;
    L9:
        d0 r3 = (d0) r2;
        if (r3 == null) goto L12;
        View r7 = r3.Y();
    L14:
        if ((r7 instanceof SurfaceView) == false) goto L17;
        r1 = r7;
    L17:
        SurfaceView r8 = (SurfaceView) r1;
        i r9 = this.a.e;
        if (r9 == null) goto L27;
        if (r8 == null) goto L21;
        int r10 = r8.getMeasuredWidth();
    L22:
        if (r8 == null) goto L24;
        int r11 = r8.getMeasuredHeight();
    L25:
        r9.k(r10, r11, true);
        return;
    L24:
        r11 = ((Number) r6.getSecond()).intValue();
        goto L25
    L21:
        r10 = ((Number) r6.getFirst()).intValue();
        goto L22
    L27:
        return;
    L12:
        r7 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }
}
