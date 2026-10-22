package com.bytedance.android.live.liveinteract.plantform.commonwindow.audio;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.android.live.core.utils.s1;
import pn0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends ViewOutlineProvider {
    public final /* synthetic */ f.c a;

    public a(f.c r1) {
        this.a = r1;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r4, Outline r5) {
        f.c r0 = this.a;
        Rect r6 = new Rect(0, 0, r0.e, r0.f);
        if (r5 == null) goto L6;
        r5.setRoundRect(r6, s1.f(8.0f));
        return;
    }
}
