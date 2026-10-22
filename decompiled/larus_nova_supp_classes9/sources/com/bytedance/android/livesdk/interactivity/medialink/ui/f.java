package com.bytedance.android.livesdk.interactivity.medialink.ui;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ MediaMultiAnchorWindowV2 a;

    public f(MediaMultiAnchorWindowV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        r3.printStackTrace();
        if ((r3 instanceof ApiServerException) == true) goto L5;
        r3 = null;
    L5:
        ApiServerException r4 = (ApiServerException) r3;
        if (r4 == null) goto L8;
        IESUIUtils.displayToast(this.a.getContext(), r4.getPrompt());
        return;
    L8:
        IESUIUtils.displayToast(this.a.getContext(), 2131919116);
    }
}
