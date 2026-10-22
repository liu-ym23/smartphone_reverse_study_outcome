package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ MediaInteractCommentWidget a;

    public l(MediaInteractCommentWidget r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        MediaInteractCommentDataContext r4 = this.a.a;
        if (r4 == null) goto L5;
        r4.close();
    L5:
        this.a.f++;
        r2.dismiss();
    }
}
