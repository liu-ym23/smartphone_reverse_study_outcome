package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements DialogInterface.OnDismissListener {
    public final /* synthetic */ LiveInputDialogV3 a;
    public final /* synthetic */ com.bytedance.android.live.profit.privilege.model.danmu.b b;

    public m(LiveInputDialogV3 r1, com.bytedance.android.live.profit.privilege.model.danmu.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        this.a.k = false;
    }
}
