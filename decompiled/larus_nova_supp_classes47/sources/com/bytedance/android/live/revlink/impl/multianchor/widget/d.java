package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.DialogInterface;
import com.bytedance.android.live.revlink.impl.control.s;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements DialogInterface.OnDismissListener {
    public final /* synthetic */ s a;

    public d(PkAutoMatchManager.b r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        this.a.onDismiss();
    }
}
