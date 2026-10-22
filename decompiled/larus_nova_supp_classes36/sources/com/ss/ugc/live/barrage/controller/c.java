package com.ss.ugc.live.barrage.controller;

import android.view.View;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.ugc.live.barrage.view.SurfaceBarrageLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends com.ss.ugc.live.barrage.util.d {
    public final /* synthetic */ AbsBarrageController l;

    public c(AbsBarrageController r1) {
        this.l = r1;
    }

    @Override // com.ss.ugc.live.barrage.util.d
    public final void a(int r5, int r6) {
        AbsBarrageController r0 = this.l;
        float r1 = r0.e;
        float r7 = r5 / r6;
        float r8 = AudioViewModel.ASR_SESSION_IDLE;
        float r9 = r7 * r8;
        r0.e = r9;
        float r2 = r9 - r1;
        if (r9 >= r1) goto L5;
        r2 = (r8 - r1) + r9;
    L5:
        r0.j(r0.a, r2);
        if (this.l.b.isEmpty() == true) goto L8;
    L12:
        View r10 = this.l.k;
        if ((r10 instanceof SurfaceBarrageLayout) == false) goto L15;
        ((SurfaceBarrageLayout) r10).c();
        return;
    L15:
        r10.invalidate();
        return;
    L8:
        if (this.l.c.isEmpty() == false) goto L12;
        if (this.l.a.isEmpty() == false) goto L12;
        this.l.p();
        goto L12
    }
}
