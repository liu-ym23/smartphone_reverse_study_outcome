package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessagePriority;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class o {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[PSMessageAction.values().length];
        a = r0;
        r0[PSMessageAction.BASIC.ordinal()] = 1;
        r0[PSMessageAction.CHAT.ordinal()] = 2;
        r0[PSMessageAction.BUSINESS.ordinal()] = 3;
        int[] r1 = new int[PSMessagePriority.values().length];
        b = r1;
        r1[PSMessagePriority.HIGH.ordinal()] = 1;
        r1[PSMessagePriority.LOW.ordinal()] = 2;
        r1[PSMessagePriority.NORMAL.ordinal()] = 3;
    }
}
