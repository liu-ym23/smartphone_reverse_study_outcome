package com.bytedance.android.livesdk.chatroom.viewmodule.backtrack;

import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r0 = new int[IAnchorBacktrackService.State.values().length];
        a = r0;
        IAnchorBacktrackService.State r1 = IAnchorBacktrackService.State.BACKTRACK_DOING;
        r0[r1.ordinal()] = 1;
        int[] r2 = new int[BacktrackState.values().length];
        b = r2;
        BacktrackState r3 = BacktrackState.STARTED;
        r2[r3.ordinal()] = 1;
        BacktrackState r4 = BacktrackState.BACKTRACK_DOING;
        r2[r4.ordinal()] = 2;
        BacktrackState r5 = BacktrackState.PREVIEWING;
        r2[r5.ordinal()] = 3;
        int[] r6 = new int[BacktrackState.values().length];
        c = r6;
        r6[BacktrackState.IDLE.ordinal()] = 1;
        r6[r3.ordinal()] = 2;
        r6[r4.ordinal()] = 3;
        r6[r5.ordinal()] = 4;
        r6[BacktrackState.TIMEOUT.ordinal()] = 5;
        r6[BacktrackState.DONE.ordinal()] = 6;
        r6[BacktrackState.ERROR.ordinal()] = 7;
        int[] r7 = new int[IAnchorBacktrackService.State.values().length];
        d = r7;
        r7[IAnchorBacktrackService.State.IDLE.ordinal()] = 1;
        r7[r1.ordinal()] = 2;
        r7[IAnchorBacktrackService.State.BACKTRACK_DONE.ordinal()] = 3;
        r7[IAnchorBacktrackService.State.DOWNLOAD.ordinal()] = 4;
        r7[IAnchorBacktrackService.State.SAVE_DRAFT.ordinal()] = 5;
        r7[IAnchorBacktrackService.State.DONE.ordinal()] = 6;
    }
}
