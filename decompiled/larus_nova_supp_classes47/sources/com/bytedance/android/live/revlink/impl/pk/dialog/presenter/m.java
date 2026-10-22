package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkPrecisionMatchInviteContract$View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ k a;

    public m(k r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        long r0 = ((Number) r3).longValue();
        InteractDialogPkPrecisionMatchInviteContract$View r4 = (InteractDialogPkPrecisionMatchInviteContract$View) this.a.c;
        if (r4 == null) goto L6;
        r4.da0(r0);
        return;
    }
}
