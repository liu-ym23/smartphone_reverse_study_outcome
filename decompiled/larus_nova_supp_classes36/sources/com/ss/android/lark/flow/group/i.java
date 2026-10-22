package com.ss.android.lark.flow.group;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements DialogInterface.OnClickListener {
    public final /* synthetic */ FlowJoinGroupChatUtil.CallbackWrap a;

    public i(FlowJoinGroupChatUtil.CallbackWrap r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        if (r1 == null) goto L4;
        r1.dismiss();
    L4:
        this.a.onCancelSendApply();
    }
}
