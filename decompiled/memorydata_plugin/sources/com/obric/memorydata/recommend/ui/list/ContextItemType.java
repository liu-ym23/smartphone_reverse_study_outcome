package com.obric.memorydata.recommend.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/ContextItemType;", "", "<init>", "(Ljava/lang/String;I)V", "DAY_TYPE", "LOCATION_TYPE", "LOCATION", "MOVEMENT_TYPE", "HOME_LOCATIONS", "COMPANY_LOCATIONS", "LEAVE_HOME_TIME", "ARRIVE_COMPANY_TIME", "LEAVE_COMPANY_TIME", "ARRIVE_HOME_TIME", "SLEEP_TIME", "WAKEUP_TIME", "FESTIVAL", "ANNIVERSARY", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ContextItemType extends Enum<ContextItemType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ContextItemType[] $VALUES = null;
    public static final ContextItemType ANNIVERSARY = null;
    public static final ContextItemType ARRIVE_COMPANY_TIME = null;
    public static final ContextItemType ARRIVE_HOME_TIME = null;
    public static final ContextItemType COMPANY_LOCATIONS = null;
    public static final ContextItemType DAY_TYPE = null;
    public static final ContextItemType FESTIVAL = null;
    public static final ContextItemType HOME_LOCATIONS = null;
    public static final ContextItemType LEAVE_COMPANY_TIME = null;
    public static final ContextItemType LEAVE_HOME_TIME = null;
    public static final ContextItemType LOCATION = null;
    public static final ContextItemType LOCATION_TYPE = null;
    public static final ContextItemType MOVEMENT_TYPE = null;
    public static final ContextItemType SLEEP_TIME = null;
    public static final ContextItemType WAKEUP_TIME = null;

    private static final /* synthetic */ ContextItemType[] $values() {
        return new ContextItemType[]{DAY_TYPE, LOCATION_TYPE, LOCATION, MOVEMENT_TYPE, HOME_LOCATIONS, COMPANY_LOCATIONS, LEAVE_HOME_TIME, ARRIVE_COMPANY_TIME, LEAVE_COMPANY_TIME, ARRIVE_HOME_TIME, SLEEP_TIME, WAKEUP_TIME, FESTIVAL, ANNIVERSARY};
    }

    static {
        DAY_TYPE = new ContextItemType("DAY_TYPE", 0);
        LOCATION_TYPE = new ContextItemType("LOCATION_TYPE", 1);
        LOCATION = new ContextItemType("LOCATION", 2);
        MOVEMENT_TYPE = new ContextItemType("MOVEMENT_TYPE", 3);
        HOME_LOCATIONS = new ContextItemType("HOME_LOCATIONS", 4);
        COMPANY_LOCATIONS = new ContextItemType("COMPANY_LOCATIONS", 5);
        LEAVE_HOME_TIME = new ContextItemType("LEAVE_HOME_TIME", 6);
        ARRIVE_COMPANY_TIME = new ContextItemType("ARRIVE_COMPANY_TIME", 7);
        LEAVE_COMPANY_TIME = new ContextItemType("LEAVE_COMPANY_TIME", 8);
        ARRIVE_HOME_TIME = new ContextItemType("ARRIVE_HOME_TIME", 9);
        SLEEP_TIME = new ContextItemType("SLEEP_TIME", 10);
        WAKEUP_TIME = new ContextItemType("WAKEUP_TIME", 11);
        FESTIVAL = new ContextItemType("FESTIVAL", 12);
        ANNIVERSARY = new ContextItemType("ANNIVERSARY", 13);
        ContextItemType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ContextItemType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ContextItemType> getEntries() {
        return $ENTRIES;
    }

    public static ContextItemType valueOf(String r2) {
        return (ContextItemType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ContextItemType.class, r2), ContextItemType.class, "com.obric.memorydata.plugin");
    }

    public static ContextItemType[] values() {
        return (ContextItemType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContextItemType[].class, "com.obric.memorydata.plugin");
    }
}
