package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class k2 {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[BacktrackState.values().length];
        a = r0;
        BacktrackState r1 = BacktrackState.IDLE;
        r0[r1.ordinal()] = 1;
        BacktrackState r2 = BacktrackState.TIMEOUT;
        r0[r2.ordinal()] = 2;
        BacktrackState r4 = BacktrackState.ERROR;
        r0[r4.ordinal()] = 3;
        BacktrackState r6 = BacktrackState.BACKTRACK_DOING;
        r0[r6.ordinal()] = 4;
        BacktrackState r8 = BacktrackState.PREVIEWING;
        r0[r8.ordinal()] = 5;
        BacktrackState r10 = BacktrackState.DONE;
        r0[r10.ordinal()] = 6;
        int[] r3 = new int[BacktrackState.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
        r3[r8.ordinal()] = 5;
        r3[r10.ordinal()] = 6;
    }
}
