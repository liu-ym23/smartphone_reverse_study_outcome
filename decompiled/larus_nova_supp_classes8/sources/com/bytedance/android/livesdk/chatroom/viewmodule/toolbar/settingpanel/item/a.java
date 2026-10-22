package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Action {
    public final /* synthetic */ PermissionGrantedItem a;

    public a(PermissionGrantedItem r1) {
        this.a = r1;
    }

    public final void run() {
        qk1.a r0 = this.a.b;
        if (r0 == null) goto L6;
        r0.a.clear();
        return;
    }
}
