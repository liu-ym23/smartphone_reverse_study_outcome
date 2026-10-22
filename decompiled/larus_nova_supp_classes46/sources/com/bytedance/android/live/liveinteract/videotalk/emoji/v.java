package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;

    public v(int r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        r4.dismiss();
        rj0.l.n2.getClass();
        rj0.l r6 = rj0.l.a.a();
        if (r6 == null) goto L6;
        rj0.l.b.d(r6, this.a, true, false, 12);
        return;
    }
}
