package com.bytedance.android.livesdk.dislike.action;

import android.content.Context;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ q a;

    public p(q r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        CustomApiServerException r4 = (Throwable) r3;
        if ((r4 instanceof CustomApiServerException) == true) goto L5;
    L11:
        NotificationSettingBottomDialog.b r5 = this.a.g;
        if (r5 == null) goto L15;
        r5.onFailure();
        return;
    L15:
        return;
    L5:
        if (r4.getErrorCode() != 20010) goto L11;
        com.bytedance.android.livesdk.dislike.m r6 = this.a.e.c;
        if (r6 == null) goto L9;
        Context r7 = r6.getContext();
    L10:
        f2.h(r7, 2131920760, 0);
        goto L11
    L9:
        r7 = null;
        goto L10
    }
}
