package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class b extends s {
    public final com.bytedance.android.live.base.model.message.j l;

    public b(com.bytedance.android.live.base.model.message.j r4) {
        this.l = r4;
        Long r0 = null;
        if (r4 == null) goto L5;
        Long r1 = Long.valueOf(r4.getMessageId());
    L6:
        this.e = r1;
        if (r4 == null) goto L9;
        String r2 = r4.getMessageMethod();
    L10:
        this.f = r2;
        if (r4 == null) goto L13;
        r0 = Long.valueOf(r4.getTimestamp());
    L13:
        this.g = r0;
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
