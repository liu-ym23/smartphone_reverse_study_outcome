package com.bytedance.android.livesdk.chatroom.ui.framework.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[IComponentScheduler.LoadMode.values().length];
        a = r0;
        IComponentScheduler.LoadMode r1 = IComponentScheduler.LoadMode.DIRECT;
        r0[r1.ordinal()] = 1;
        IComponentScheduler.LoadMode r2 = IComponentScheduler.LoadMode.PREVIEW;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[IComponentScheduler.LoadMode.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
    }
}
