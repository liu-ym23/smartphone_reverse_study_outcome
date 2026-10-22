package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.content.Context;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ PkUserBanSettingDialog a;
    public final /* synthetic */ Context b;

    public r(PkUserBanSettingDialog r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        this.a.j = false;
        r4.printStackTrace();
        if ((r4 instanceof ApiServerException) == true) goto L5;
        r4 = null;
    L5:
        ApiServerException r5 = (ApiServerException) r4;
        if (r5 == null) goto L8;
        IESUIUtils.displayToast(this.b, r5.getPrompt());
        return;
    L8:
        IESUIUtils.displayToast(this.b, 2131919116);
    }
}
