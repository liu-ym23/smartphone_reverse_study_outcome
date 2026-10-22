package com.larksuite.component.blockit.hashtag.list;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        HashTagSwipeAdapter r3 = this.a.e;
        if (r3 == null) goto L6;
        r3.y2();
        return;
    }
}
