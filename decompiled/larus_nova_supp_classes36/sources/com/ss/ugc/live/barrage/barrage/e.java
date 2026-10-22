package com.ss.ugc.live.barrage.barrage;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import com.ss.ugc.live.barrage.util.f;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class e extends AbsBarrage {
    public final Context q;
    public final Function3<Bitmap, Integer, Integer, Unit> r;
    public int s;
    public View t;
    public Bitmap u;

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public void j() {
        Bitmap r0 = this.u;
        if (r0 == null) goto L6;
        this.m.d.a(r0);
        return;
    }

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public final void k() {
        View r0 = this.t;
        if (r0 == null) goto L5;
        q(r0);
        return;
    L5:
        int r1 = this.s;
        if (r1 <= 0) goto L10;
        this.s = r1;
        this.t = null;
        q(LayoutInflater.from(this.q).inflate(r1, null));
        return;
    }

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public final Bitmap h() {
        return this.u;
    }

    @Deprecated(message = "Use non-arg updateView() instead")
    public final void q(View r5) {
        this.t = r5;
        this.s = -1;
        if (this.g != AbsBarrage.State.PREPARING) goto L5;
    L6:
        AbsBarrage.b r0 = this.m;
        olc.a r1 = r0.d;
        r0.e.execute(new f(r5, r1, this.r));
        return;
    L5:
        if (this.g == AbsBarrage.State.VISIBLE) goto L6;
    }

    public e(View r1, AbsBarrage.b r2) {
        super(r2);
        this.r = new ViewWrapperBarrage$bitmapListener$1(this);
        this.s = -1;
        this.t = r1;
        this.q = r1.getContext();
    }
}
