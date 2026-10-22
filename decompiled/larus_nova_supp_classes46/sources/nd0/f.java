package nd0;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[OperateType.values().length];
        a = r0;
        r0[OperateType.APPLY.ordinal()] = 1;
        r0[OperateType.REPLY.ordinal()] = 2;
        r0[OperateType.PRE_APPLY.ordinal()] = 3;
        r0[OperateType.RESUME.ordinal()] = 4;
        r0[OperateType.JOIN.ordinal()] = 5;
        r0[OperateType.PRE_REPLY.ordinal()] = 6;
        r0[OperateType.MIDI.ordinal()] = 7;
        r0[OperateType.UniversalAnimForSaas.ordinal()] = 8;
        int[] r1 = new int[BaseCheckException.CheckType.values().length];
        b = r1;
        r1[BaseCheckException.CheckType.Login.ordinal()] = 1;
        r1[BaseCheckException.CheckType.AndroidPermission.ordinal()] = 2;
        r1[BaseCheckException.CheckType.VideoShortPlugin.ordinal()] = 3;
        r1[BaseCheckException.CheckType.InteractPlugin.ordinal()] = 4;
        r1[BaseCheckException.CheckType.ServerPermission.ordinal()] = 5;
    }
}
