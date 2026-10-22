package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n1 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ UserCompositeWidget a;

    public n1(UserCompositeWidget r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        UserCompositeWidget r3 = this.a;
        int r0 = UserCompositeWidget.f;
        r3.wq("query_user_holding_living");
        this.a.getClass();
        zg1.h1 r4 = new zg1.h1(8);
        xs2.b.a().post(r4);
    }
}
