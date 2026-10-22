package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ ReplayVideoMetrics a;

    public f(ReplayVideoMetrics r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L15;
        r3.booleanValue();
        if (r3.booleanValue() == false) goto L10;
        com.bytedance.android.livesdk.chatroom.vs_base.log.g r4 = this.a.d;
        if (r4.e == true) goto L17;
        r4.h = false;
        r4.c(false);
        return;
    L17:
        return;
    L10:
        com.bytedance.android.livesdk.chatroom.vs_base.log.g r5 = this.a.d;
        if (r5.e == true) goto L18;
        r5.b();
        r5.h = true;
        return;
    L18:
        return;
    }
}
