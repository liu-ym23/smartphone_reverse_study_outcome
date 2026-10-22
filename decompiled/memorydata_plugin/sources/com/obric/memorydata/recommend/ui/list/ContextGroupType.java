package com.obric.memorydata.recommend.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/ContextGroupType;", "", "<init>", "(Ljava/lang/String;I)V", "DAY_TYPE", "LOCATION", "MOVEMENT_TYPE", "HOME_AND_COMPANY_LOCATION", "COMMUTE_TIME", "SLEEP_TIME", "FESTIVAL_AND_ANNIVERSARY_COMING_30_DAY", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ContextGroupType extends Enum<ContextGroupType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ContextGroupType[] $VALUES = null;
    public static final ContextGroupType COMMUTE_TIME = null;
    public static final ContextGroupType DAY_TYPE = null;
    public static final ContextGroupType FESTIVAL_AND_ANNIVERSARY_COMING_30_DAY = null;
    public static final ContextGroupType HOME_AND_COMPANY_LOCATION = null;
    public static final ContextGroupType LOCATION = null;
    public static final ContextGroupType MOVEMENT_TYPE = null;
    public static final ContextGroupType SLEEP_TIME = null;

    private static final /* synthetic */ ContextGroupType[] $values() {
        return new ContextGroupType[]{DAY_TYPE, LOCATION, MOVEMENT_TYPE, HOME_AND_COMPANY_LOCATION, COMMUTE_TIME, SLEEP_TIME, FESTIVAL_AND_ANNIVERSARY_COMING_30_DAY};
    }

    static {
        DAY_TYPE = new ContextGroupType("DAY_TYPE", 0);
        LOCATION = new ContextGroupType("LOCATION", 1);
        MOVEMENT_TYPE = new ContextGroupType("MOVEMENT_TYPE", 2);
        HOME_AND_COMPANY_LOCATION = new ContextGroupType("HOME_AND_COMPANY_LOCATION", 3);
        COMMUTE_TIME = new ContextGroupType("COMMUTE_TIME", 4);
        SLEEP_TIME = new ContextGroupType("SLEEP_TIME", 5);
        FESTIVAL_AND_ANNIVERSARY_COMING_30_DAY = new ContextGroupType("FESTIVAL_AND_ANNIVERSARY_COMING_30_DAY", 6);
        ContextGroupType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ContextGroupType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ContextGroupType> getEntries() {
        return $ENTRIES;
    }

    public static ContextGroupType valueOf(String r2) {
        return (ContextGroupType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ContextGroupType.class, r2), ContextGroupType.class, "com.obric.memorydata.plugin");
    }

    public static ContextGroupType[] values() {
        return (ContextGroupType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContextGroupType[].class, "com.obric.memorydata.plugin");
    }
}
