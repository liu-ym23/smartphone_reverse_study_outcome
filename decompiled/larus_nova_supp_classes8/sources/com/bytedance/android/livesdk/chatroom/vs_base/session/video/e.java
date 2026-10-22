package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ ReplayVideoMetrics a;

    public e(ReplayVideoMetrics r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L9;
        r3.booleanValue();
        if (r3.booleanValue() == false) goto L7;
        this.a.d.c(true);
        return;
    L7:
        this.a.d.b();
        return;
    }
}
