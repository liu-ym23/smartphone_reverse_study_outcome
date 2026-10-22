package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ j a;

    public i(j r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        j r0 = this.a;
        r0.d((Throwable) r2);
        InteractDialogPKSearchContract$View r3 = (InteractDialogPKSearchContract$View) this.a.c;
        if (r3 == null) goto L7;
        r3.ba0();
        return;
    }
}
