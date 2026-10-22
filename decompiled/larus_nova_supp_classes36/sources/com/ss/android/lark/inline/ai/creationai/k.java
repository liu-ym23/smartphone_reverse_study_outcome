package com.ss.android.lark.inline.ai.creationai;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements wlb.g.a {
    public final /* synthetic */ CreationAIDragView a;

    public k(CreationAIDragView r1) {
        this.a = r1;
    }

    @Override // wlb.g.a
    public final void b(int r8) {
        Log.i("CreationAIDragView", "content height change, contentHeight = " + r8 + ", isNestedScrolling = " + this.a.H);
        CreationAIDragView r9 = this.a;
        if ((r9.j instanceof wlb.g) == true) goto L5;
        return;
    L5:
        if (r9.H == true) goto L17;
        r9.u();
        CreationAIDragView r1 = this.a;
        if (r1.D == false) goto L10;
        int r10 = Math.max(r1.E, r1.I);
    L14:
        CreationAIDragView.f(r1, r10, false, false, CreationAIDragView.AdjustTopSource.CONTENT_HEIGHT_CHANGE, 12);
        return;
    L10:
        Integer r11 = r1.F;
        if (r11 == null) goto L13;
        r10 = Math.max(r11.intValue(), r1.I);
        goto L14
    L13:
        r10 = r1.I;
        goto L14
    }
}
