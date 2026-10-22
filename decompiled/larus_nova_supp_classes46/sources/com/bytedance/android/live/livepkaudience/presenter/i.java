package com.bytedance.android.live.livepkaudience.presenter;

import android.content.Context;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListContract$View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ g a;

    public i(g r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Context r0 = ((BasePkAudienceInviteListContract$View) this.a.b).getContext();
        ExceptionUtils.handleException(r0, (Throwable) r2);
    }
}
