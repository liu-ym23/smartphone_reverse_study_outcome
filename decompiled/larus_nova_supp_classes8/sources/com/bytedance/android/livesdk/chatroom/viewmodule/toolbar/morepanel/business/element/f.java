package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import com.bytedance.android.livehostapi.business.shareinter.ILiveIMSharePostscriptComponent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ ILiveIMSharePostscriptComponent a;

    public f(ILiveIMSharePostscriptComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.onOutSideClick();
    }
}
