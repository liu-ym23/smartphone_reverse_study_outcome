package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[PkBaseStateMachine.Source.values().length];
        a = r0;
        PkBaseStateMachine.Source r1 = PkBaseStateMachine.Source.BattleFinishInstantKill;
        r0[r1.ordinal()] = 1;
        PkBaseStateMachine.Source r2 = PkBaseStateMachine.Source.BattleFinishTimeUp;
        r0[r2.ordinal()] = 2;
        PkBaseStateMachine.Source r4 = PkBaseStateMachine.Source.PKTimeUp;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[PkBaseStateMachine.Source.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
    }
}
