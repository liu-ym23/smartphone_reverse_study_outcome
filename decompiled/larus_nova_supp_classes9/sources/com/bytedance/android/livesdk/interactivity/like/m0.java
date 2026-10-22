package com.bytedance.android.livesdk.interactivity.like;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m0 implements Action {
    public final /* synthetic */ DiggWidget a;
    public final /* synthetic */ o0 b;

    public m0(DiggWidget r1, o0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        DiggWidget r0 = this.a;
        int r1 = DiggWidget.M1;
        u32.l r2 = r0.Iq();
        if (r2 == null) goto L6;
        r2.removeListener(this.b);
        return;
    }
}
