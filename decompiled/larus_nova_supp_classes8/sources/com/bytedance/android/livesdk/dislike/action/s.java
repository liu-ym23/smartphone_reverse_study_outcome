package com.bytedance.android.livesdk.dislike.action;

import com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ t a;

    public s(t r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        NotificationSettingBottomDialog.b r3 = this.a.g;
        if (r3 == null) goto L6;
        r3.onFailure();
        return;
    }
}
