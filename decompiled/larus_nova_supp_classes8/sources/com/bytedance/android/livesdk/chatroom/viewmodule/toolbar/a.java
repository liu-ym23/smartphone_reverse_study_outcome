package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ AbsAudienceToolbarButtonMoreDialog a;

    public a(AbsAudienceToolbarButtonMoreDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ALogger.d(this.a.B, ((Throwable) r2).toString());
    }
}
