package com.obric.memorydata.recommend.feature;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/recommend/feature/ScreenObservationRestoreAction;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "RESCHEDULE", "RESTORE", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ScreenObservationRestoreAction extends Enum<ScreenObservationRestoreAction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ScreenObservationRestoreAction[] $VALUES = null;
    public static final ScreenObservationRestoreAction NONE = null;
    public static final ScreenObservationRestoreAction RESCHEDULE = null;
    public static final ScreenObservationRestoreAction RESTORE = null;

    private static final /* synthetic */ ScreenObservationRestoreAction[] $values() {
        return new ScreenObservationRestoreAction[]{NONE, RESCHEDULE, RESTORE};
    }

    static {
        NONE = new ScreenObservationRestoreAction("NONE", 0);
        RESCHEDULE = new ScreenObservationRestoreAction("RESCHEDULE", 1);
        RESTORE = new ScreenObservationRestoreAction("RESTORE", 2);
        ScreenObservationRestoreAction[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ScreenObservationRestoreAction(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ScreenObservationRestoreAction> getEntries() {
        return $ENTRIES;
    }

    public static ScreenObservationRestoreAction valueOf(String r2) {
        return (ScreenObservationRestoreAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(ScreenObservationRestoreAction.class, r2), ScreenObservationRestoreAction.class, "com.obric.memorydata.plugin");
    }

    public static ScreenObservationRestoreAction[] values() {
        return (ScreenObservationRestoreAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ScreenObservationRestoreAction[].class, "com.obric.memorydata.plugin");
    }
}
