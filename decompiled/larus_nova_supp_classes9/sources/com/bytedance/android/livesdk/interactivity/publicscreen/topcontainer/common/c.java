package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final ConflictStrategy a(int r1) {
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        return ConflictStrategy.QUEUE;
    L13:
        return ConflictStrategy.INTERRUPT;
    L14:
        return ConflictStrategy.QUEUE;
    L11:
        return ConflictStrategy.DISCARD;
    }
}
