package com.ss.android.lark.conditional.access.device.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements DialogInterface.OnClickListener {
    public final /* synthetic */ UserScopeDeviceDeclareFragment a;

    public m(UserScopeDeviceDeclareFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        UserScopeDeviceDeclareFragment r3 = this.a;
        int r4 = UserScopeDeviceDeclareFragment.m;
        r3.ba0().pin();
    }
}
