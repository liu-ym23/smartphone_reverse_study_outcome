package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ k a;

    public i(k r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        View r0 = this.a.c;
        if (r0 == null) goto L5;
        r0.setBackgroundResource(2131251666);
    L5:
        ALogger.e(this.a.d, r4.toString());
    }
}
