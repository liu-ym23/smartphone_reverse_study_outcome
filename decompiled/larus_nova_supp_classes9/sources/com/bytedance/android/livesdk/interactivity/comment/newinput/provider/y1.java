package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y1 implements z62.i {
    public final /* synthetic */ t1.c a;

    @Override // z62.i
    public final void onUpdate() {
        t1.c r0 = this.a;
        boolean r1 = r0.b.m0();
        boolean r2 = this.a.b.H();
        if (r1 == true) goto L5;
        if (r2 == true) goto L5;
    L6:
        r0.l = true;
        x62.c r3 = r0.j;
        if (r3 == null) goto L10;
        MainThreadPostUtils.e(new x62.b(r3));
        return;
    L10:
        return;
    L5:
        r0.h();
        goto L6
    }

    public y1(t1.c r1) {
        this.a = r1;
    }
}
