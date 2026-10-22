package com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements DialogInterface.OnDismissListener {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        this.a.c.b();
        this.a.a = null;
    }
}
