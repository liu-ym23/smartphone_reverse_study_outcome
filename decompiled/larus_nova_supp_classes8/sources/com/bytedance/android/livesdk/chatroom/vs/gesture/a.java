package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ b a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.j.getViewTreeObserver().removeOnPreDrawListener(this);
        float r0 = this.a.j.getWidth();
        float r1 = this.a.j.getHeight();
        float r2 = this.a.k.getWidth();
        float r3 = this.a.k.getHeight();
        ViewGroup.LayoutParams r4 = this.a.j.getLayoutParams();
        float r5 = r2 / r0;
        float r6 = r3 / r1;
        if (r0 >= r2) goto L8;
        float r7 = r5 * r1;
        if (r7 > r3) goto L8;
        r4.width = (int) r2;
        r4.height = (int) r7;
    L12:
        this.a.j.setLayoutParams(r4);
        return true;
    L8:
        if (r1 >= r3) goto L12;
        float r8 = r6 * r0;
        if (r8 > r2) goto L12;
        r4.height = (int) r3;
        r4.width = (int) r8;
        goto L12
    }

    public a(b r1) {
        this.a = r1;
    }
}
