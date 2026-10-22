package com.bytedance.android.live.cloudgrouplive.rtc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r0 = new int[RTSMessage.values().length];
        a = r0;
        RTSMessage r1 = RTSMessage.SYNC_VIEW_DISPLAY;
        r0[r1.ordinal()] = 1;
        RTSMessage r2 = RTSMessage.UPDATE_AUDIO;
        r0[r2.ordinal()] = 2;
        RTSMessage r4 = RTSMessage.UPDATE_VIEW_DISPLAY;
        r0[r4.ordinal()] = 3;
        RTSMessage r6 = RTSMessage.TRANSFER_VIEW;
        r0[r6.ordinal()] = 4;
        int[] r3 = new int[RTSMessage.values().length];
        b = r3;
        r3[r4.ordinal()] = 1;
        r3[r1.ordinal()] = 2;
        r3[r6.ordinal()] = 3;
        int[] r5 = new int[RTSMessage.values().length];
        c = r5;
        r5[r6.ordinal()] = 1;
        r5[r1.ordinal()] = 2;
        int[] r7 = new int[RTSMessage.values().length];
        d = r7;
        r7[r2.ordinal()] = 1;
        r7[r1.ordinal()] = 2;
    }
}
