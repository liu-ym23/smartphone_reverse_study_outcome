package d21;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[PkBaseResult.values().length];
        PkBaseResult r1 = PkBaseResult.WIN;
        r0[r1.ordinal()] = 1;
        PkBaseResult r2 = PkBaseResult.LOSE;
        r0[r2.ordinal()] = 2;
        PkBaseResult r4 = PkBaseResult.EVEN;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[PkBaseResult.values().length];
        a = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        int[] r5 = new int[PkBaseStateMachine.Source.values().length];
        b = r5;
        r5[PkBaseStateMachine.Source.PKTimeUp.ordinal()] = 1;
        r5[PkBaseStateMachine.Source.PunishTimeUp.ordinal()] = 2;
        r5[PkBaseStateMachine.Source.RtcLinkerLeave.ordinal()] = 3;
        r5[PkBaseStateMachine.Source.RoomClose.ordinal()] = 4;
    }
}
