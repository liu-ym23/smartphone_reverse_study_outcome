package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r0 = new int[ConflictStrategy.values().length];
        a = r0;
        ConflictStrategy r1 = ConflictStrategy.QUEUE;
        r0[r1.ordinal()] = 1;
        ConflictStrategy r2 = ConflictStrategy.INTERRUPT;
        r0[r2.ordinal()] = 2;
        ConflictStrategy r4 = ConflictStrategy.DISCARD;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[ConflictStrategy.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        int[] r5 = new int[ConflictStrategy.values().length];
        c = r5;
        r5[r1.ordinal()] = 1;
        r5[r4.ordinal()] = 2;
        r5[r2.ordinal()] = 3;
        int[] r6 = new int[CleanStrategy.values().length];
        d = r6;
        r6[CleanStrategy.NONE.ordinal()] = 1;
        r6[CleanStrategy.REMOVE_VIEWS.ordinal()] = 2;
        r6[CleanStrategy.REMOVE_WRAP_VIEW.ordinal()] = 3;
    }
}
