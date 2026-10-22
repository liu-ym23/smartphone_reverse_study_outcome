package com.bytedance.android.livesdk.chatroom.ui;

import android.content.DialogInterface;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class g implements DialogInterface.OnClickListener {
    public /* synthetic */ g() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        List<String> r3 = AbsInteractionFragment.u4;
        r1.dismiss();
    }
}
