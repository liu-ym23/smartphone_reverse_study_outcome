package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/entity/AlarmSwitchStatus;", "", "<init>", "(Ljava/lang/String;I)V", "ON", "OFF", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AlarmSwitchStatus extends Enum<AlarmSwitchStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AlarmSwitchStatus[] $VALUES = null;
    public static final AlarmSwitchStatus OFF = null;
    public static final AlarmSwitchStatus ON = null;

    private static final /* synthetic */ AlarmSwitchStatus[] $values() {
        return new AlarmSwitchStatus[]{ON, OFF};
    }

    static {
        ON = new AlarmSwitchStatus("ON", 0);
        OFF = new AlarmSwitchStatus("OFF", 1);
        AlarmSwitchStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AlarmSwitchStatus(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AlarmSwitchStatus> getEntries() {
        return $ENTRIES;
    }

    public static AlarmSwitchStatus valueOf(String r2) {
        return (AlarmSwitchStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(AlarmSwitchStatus.class, r2), AlarmSwitchStatus.class, "com.obric.memorydata.plugin");
    }

    public static AlarmSwitchStatus[] values() {
        return (AlarmSwitchStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AlarmSwitchStatus[].class, "com.obric.memorydata.plugin");
    }
}
