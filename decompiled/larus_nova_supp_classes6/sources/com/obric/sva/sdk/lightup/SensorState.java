package com.obric.sva.sdk.lightup;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/sva/sdk/lightup/SensorState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "COVERED", "UNCOVERED", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum SensorState extends Enum<SensorState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SensorState[] $VALUES = null;
    public static final SensorState COVERED = null;
    public static final SensorState NA = null;
    public static final SensorState UNCOVERED = null;

    private static final /* synthetic */ SensorState[] $values() {
        return new SensorState[]{NA, COVERED, UNCOVERED};
    }

    public static EnumEntries<SensorState> getEntries() {
        return $ENTRIES;
    }

    static {
        NA = new SensorState("NA", 0);
        COVERED = new SensorState("COVERED", 1);
        UNCOVERED = new SensorState("UNCOVERED", 2);
        SensorState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static SensorState[] values() {
        return (SensorState[]) $VALUES.clone();
    }

    public static SensorState valueOf(String r1) {
        return (SensorState) r27.a.a(SensorState.class, r1);
    }

    private SensorState(String r1, int r2) {
        super(r1, r2);
    }
}
