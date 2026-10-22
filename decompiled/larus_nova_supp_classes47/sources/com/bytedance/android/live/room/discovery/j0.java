package com.bytedance.android.live.room.discovery;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ LiveSceneWidget a;

    public j0(LiveSceneWidget r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        this.a.wq("cancel");
        r2.dismiss();
    }
}
