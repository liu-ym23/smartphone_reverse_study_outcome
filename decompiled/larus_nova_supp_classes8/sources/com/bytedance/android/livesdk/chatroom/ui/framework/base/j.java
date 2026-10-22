package com.bytedance.android.livesdk.chatroom.ui.framework.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class j {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[IComponentScheduler.LoadBatch.values().length];
        a = r0;
        IComponentScheduler.LoadBatch r1 = IComponentScheduler.LoadBatch.FIRST_SCREEN;
        r0[r1.ordinal()] = 1;
        IComponentScheduler.LoadBatch r2 = IComponentScheduler.LoadBatch.P0;
        r0[r2.ordinal()] = 2;
        IComponentScheduler.LoadBatch r4 = IComponentScheduler.LoadBatch.P1;
        r0[r4.ordinal()] = 3;
        IComponentScheduler.LoadBatch r6 = IComponentScheduler.LoadBatch.P2;
        r0[r6.ordinal()] = 4;
        IComponentScheduler.LoadBatch r8 = IComponentScheduler.LoadBatch.POTHER;
        r0[r8.ordinal()] = 5;
        int[] r3 = new int[IComponentScheduler.LoadBatch.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
        r3[r8.ordinal()] = 5;
        int[] r5 = new int[IComponentScheduler.LoadBatch.values().length];
        c = r5;
        r5[r2.ordinal()] = 1;
        r5[r4.ordinal()] = 2;
        r5[r6.ordinal()] = 3;
        r5[r8.ordinal()] = 4;
    }
}
