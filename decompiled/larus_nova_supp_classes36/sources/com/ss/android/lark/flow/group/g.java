package com.ss.android.lark.flow.group;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements DialogInterface.OnCancelListener {
    public final /* synthetic */ FlowJoinGroupChatUtil.CallbackWrap a;

    public g(FlowJoinGroupChatUtil.CallbackWrap r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r1) {
        this.a.onCancelSendApply();
    }
}
