package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.DialogInterface;
import com.bytedance.android.live.revlink.impl.control.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements DialogInterface.OnDismissListener {
    public final /* synthetic */ s a;

    public e(com.bytedance.android.live.revlink.impl.pk.vm.linkout.g r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        this.a.onDismiss();
    }
}
