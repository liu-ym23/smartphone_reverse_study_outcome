package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.livesdk.interactivity.api.entity.PSMessagePriority;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PSMessagePriority.values().length];
        a = r0;
        r0[PSMessagePriority.HIGH.ordinal()] = 1;
        r0[PSMessagePriority.LOW.ordinal()] = 2;
        r0[PSMessagePriority.NORMAL.ordinal()] = 3;
    }
}
