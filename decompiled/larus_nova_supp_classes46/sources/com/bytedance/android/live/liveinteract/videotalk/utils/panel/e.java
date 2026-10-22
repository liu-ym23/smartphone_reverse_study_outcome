package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ boolean a;

    public e(boolean r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ApiServerException r4 = (Throwable) r3;
        if (r4 != null) goto L6;
        a.j.dismissDialog();
        return;
    L6:
        if (this.a == false) goto L9;
        ExceptionUtils.handleException(jc1.a.b(), r4, 2131919335);
        return;
    L9:
        if ((r4 instanceof ApiServerException) == true) goto L11;
    L13:
        boolean r0 = false;
    L14:
        if (r0 == true) goto L19;
        ExceptionUtils.handleException(jc1.a.b(), r4, 2131919337);
        return;
    L19:
        return;
    L11:
        if (r4.getErrorCode() != 4004468) goto L13;
        r0 = true;
        goto L14
    }
}
