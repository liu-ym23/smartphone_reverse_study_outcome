package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z1 implements com.bytedance.android.livesdk.interactivity.comment.mention.k {
    public final /* synthetic */ t1.c a;

    public z1(t1.c r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.mention.k
    public final void a(boolean r3) {
        t1.c r0 = this.a;
        if (r0.b.m0() == true) goto L5;
        if (r3 == true) goto L5;
    L6:
        r0.l = true;
        x62.c r4 = r0.j;
        if (r4 == null) goto L10;
        MainThreadPostUtils.e(new x62.b(r4));
        return;
    L10:
        return;
    L5:
        r0.h();
        goto L6
    }
}
