package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements DialogInterface.OnClickListener {
    public final /* synthetic */ o a;

    public n(o r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
        this.a.b();
    }
}
