package com.obric.memorydata.intelligence.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\"\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/obric/memorydata/intelligence/api/ProfileLabel;", "", "<init>", "(Ljava/lang/String;I)V", "HOME_GPS", "HOME_CELL_ID", "HOME_BSS_ID", "HOME_CITY", "COMPANY_GPS", "COMPANY_CELL_ID", "COMPANY_BSS_ID", "ARRIVE_HOME_TIME", "LEAVE_HOME_TIME", "ARRIVE_COMPANY_TIME", "LEAVE_COMPANY_TIME", "COMMUTE_BY_SUBWAY", "WORK_DAY", "HOME_SUBWAY_STATION", "SLEEP_MOMENT", "WAKEUP_MOMENT", "DAILY_AVERAGE_CELL_PHONE_USAGE", "APP_TRAFFIC_CONCERN", "PHONE_TRAFFIC_CONCERN", "COMMUTE_TYPE", "UPCOMING_30_SPECIAL_DAY", "UPCOMING_365_SPECIAL_DAY", "FROM_HOME_TO_COMPANY_PERIOD", "FROM_COMPANY_TO_HOME_PERIOD", "WORKING_TIME_PERIOD", "UN_WORKING_TIME_PERIOD", "LUNCH_BREAK_PERIOD", "BED_TIME_PERIOD", "LUNCH_PERIOD", "DINNER_PERIOD", "HOME_GPS_FENCE_LIST", "intelligence_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ProfileLabel extends Enum<ProfileLabel> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ProfileLabel[] $VALUES = null;
    public static final ProfileLabel APP_TRAFFIC_CONCERN = null;
    public static final ProfileLabel ARRIVE_COMPANY_TIME = null;
    public static final ProfileLabel ARRIVE_HOME_TIME = null;
    public static final ProfileLabel BED_TIME_PERIOD = null;
    public static final ProfileLabel COMMUTE_BY_SUBWAY = null;
    public static final ProfileLabel COMMUTE_TYPE = null;
    public static final ProfileLabel COMPANY_BSS_ID = null;
    public static final ProfileLabel COMPANY_CELL_ID = null;
    public static final ProfileLabel COMPANY_GPS = null;
    public static final ProfileLabel DAILY_AVERAGE_CELL_PHONE_USAGE = null;
    public static final ProfileLabel DINNER_PERIOD = null;
    public static final ProfileLabel FROM_COMPANY_TO_HOME_PERIOD = null;
    public static final ProfileLabel FROM_HOME_TO_COMPANY_PERIOD = null;
    public static final ProfileLabel HOME_BSS_ID = null;
    public static final ProfileLabel HOME_CELL_ID = null;
    public static final ProfileLabel HOME_CITY = null;
    public static final ProfileLabel HOME_GPS = null;
    public static final ProfileLabel HOME_GPS_FENCE_LIST = null;
    public static final ProfileLabel HOME_SUBWAY_STATION = null;
    public static final ProfileLabel LEAVE_COMPANY_TIME = null;
    public static final ProfileLabel LEAVE_HOME_TIME = null;
    public static final ProfileLabel LUNCH_BREAK_PERIOD = null;
    public static final ProfileLabel LUNCH_PERIOD = null;
    public static final ProfileLabel PHONE_TRAFFIC_CONCERN = null;
    public static final ProfileLabel SLEEP_MOMENT = null;
    public static final ProfileLabel UN_WORKING_TIME_PERIOD = null;
    public static final ProfileLabel UPCOMING_30_SPECIAL_DAY = null;
    public static final ProfileLabel UPCOMING_365_SPECIAL_DAY = null;
    public static final ProfileLabel WAKEUP_MOMENT = null;
    public static final ProfileLabel WORKING_TIME_PERIOD = null;
    public static final ProfileLabel WORK_DAY = null;

    private static final /* synthetic */ ProfileLabel[] $values() {
        return new ProfileLabel[]{HOME_GPS, HOME_CELL_ID, HOME_BSS_ID, HOME_CITY, COMPANY_GPS, COMPANY_CELL_ID, COMPANY_BSS_ID, ARRIVE_HOME_TIME, LEAVE_HOME_TIME, ARRIVE_COMPANY_TIME, LEAVE_COMPANY_TIME, COMMUTE_BY_SUBWAY, WORK_DAY, HOME_SUBWAY_STATION, SLEEP_MOMENT, WAKEUP_MOMENT, DAILY_AVERAGE_CELL_PHONE_USAGE, APP_TRAFFIC_CONCERN, PHONE_TRAFFIC_CONCERN, COMMUTE_TYPE, UPCOMING_30_SPECIAL_DAY, UPCOMING_365_SPECIAL_DAY, FROM_HOME_TO_COMPANY_PERIOD, FROM_COMPANY_TO_HOME_PERIOD, WORKING_TIME_PERIOD, UN_WORKING_TIME_PERIOD, LUNCH_BREAK_PERIOD, BED_TIME_PERIOD, LUNCH_PERIOD, DINNER_PERIOD, HOME_GPS_FENCE_LIST};
    }

    static {
        HOME_GPS = new ProfileLabel("HOME_GPS", 0);
        HOME_CELL_ID = new ProfileLabel("HOME_CELL_ID", 1);
        HOME_BSS_ID = new ProfileLabel("HOME_BSS_ID", 2);
        HOME_CITY = new ProfileLabel("HOME_CITY", 3);
        COMPANY_GPS = new ProfileLabel("COMPANY_GPS", 4);
        COMPANY_CELL_ID = new ProfileLabel("COMPANY_CELL_ID", 5);
        COMPANY_BSS_ID = new ProfileLabel("COMPANY_BSS_ID", 6);
        ARRIVE_HOME_TIME = new ProfileLabel("ARRIVE_HOME_TIME", 7);
        LEAVE_HOME_TIME = new ProfileLabel("LEAVE_HOME_TIME", 8);
        ARRIVE_COMPANY_TIME = new ProfileLabel("ARRIVE_COMPANY_TIME", 9);
        LEAVE_COMPANY_TIME = new ProfileLabel("LEAVE_COMPANY_TIME", 10);
        COMMUTE_BY_SUBWAY = new ProfileLabel("COMMUTE_BY_SUBWAY", 11);
        WORK_DAY = new ProfileLabel("WORK_DAY", 12);
        HOME_SUBWAY_STATION = new ProfileLabel("HOME_SUBWAY_STATION", 13);
        SLEEP_MOMENT = new ProfileLabel("SLEEP_MOMENT", 14);
        WAKEUP_MOMENT = new ProfileLabel("WAKEUP_MOMENT", 15);
        DAILY_AVERAGE_CELL_PHONE_USAGE = new ProfileLabel("DAILY_AVERAGE_CELL_PHONE_USAGE", 16);
        APP_TRAFFIC_CONCERN = new ProfileLabel("APP_TRAFFIC_CONCERN", 17);
        PHONE_TRAFFIC_CONCERN = new ProfileLabel("PHONE_TRAFFIC_CONCERN", 18);
        COMMUTE_TYPE = new ProfileLabel("COMMUTE_TYPE", 19);
        UPCOMING_30_SPECIAL_DAY = new ProfileLabel("UPCOMING_30_SPECIAL_DAY", 20);
        UPCOMING_365_SPECIAL_DAY = new ProfileLabel("UPCOMING_365_SPECIAL_DAY", 21);
        FROM_HOME_TO_COMPANY_PERIOD = new ProfileLabel("FROM_HOME_TO_COMPANY_PERIOD", 22);
        FROM_COMPANY_TO_HOME_PERIOD = new ProfileLabel("FROM_COMPANY_TO_HOME_PERIOD", 23);
        WORKING_TIME_PERIOD = new ProfileLabel("WORKING_TIME_PERIOD", 24);
        UN_WORKING_TIME_PERIOD = new ProfileLabel("UN_WORKING_TIME_PERIOD", 25);
        LUNCH_BREAK_PERIOD = new ProfileLabel("LUNCH_BREAK_PERIOD", 26);
        BED_TIME_PERIOD = new ProfileLabel("BED_TIME_PERIOD", 27);
        LUNCH_PERIOD = new ProfileLabel("LUNCH_PERIOD", 28);
        DINNER_PERIOD = new ProfileLabel("DINNER_PERIOD", 29);
        HOME_GPS_FENCE_LIST = new ProfileLabel("HOME_GPS_FENCE_LIST", 30);
        ProfileLabel[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ProfileLabel(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ProfileLabel> getEntries() {
        return $ENTRIES;
    }

    public static ProfileLabel valueOf(String r2) {
        return (ProfileLabel) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProfileLabel.class, r2), ProfileLabel.class, "com.obric.memorydata.plugin");
    }

    public static ProfileLabel[] values() {
        return (ProfileLabel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProfileLabel[].class, "com.obric.memorydata.plugin");
    }
}
