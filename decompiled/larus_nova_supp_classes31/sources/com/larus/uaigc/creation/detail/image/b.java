package com.larus.uaigc.creation.detail.image;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements l19.f {
    public final /* synthetic */ AbsBigImageDetailFragment a;

    public final void onTransitionChanged(int r1, float r2) {
    }

    public b(AbsBigImageDetailFragment r1) {
        this.a = r1;
    }

    public final void onTransitionBegin(int r2) {
        View r3 = this.a.j;
        if (r3 == null) goto L6;
        r3.setVisibility(8);
        return;
    }

    public final void onTransitionEnd(int r2) {
        View r3 = this.a.j;
        if (r3 == null) goto L6;
        r3.setVisibility(0);
        return;
    }
}
