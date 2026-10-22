package com.obric.memorydata.constants;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/constants/OsTeaTrackerEventId;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MOVEMENT_STATE", "LOCATION", "MEMORY_DEV_EVENT", "APP_USAGE_INFO", "MEMORY_TASK_EXECUTE_INFO", "RECOMMEND_DELETE_EXPIRED_DATA_EVENT", "IMAGE_TO_MEMORY_EVENT", "MEMORY_HAR_AND_LOCATION_STATE_EVENT", "SCREENSHOT_TO_FILE_EVENT", "MEMORY_COLLECT_SCREENSHOT_DATA_EVENT", "MEMORY_SAVE_SCREENSHOT_EVENT", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum OsTeaTrackerEventId extends Enum<OsTeaTrackerEventId> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OsTeaTrackerEventId[] $VALUES = null;
    public static final OsTeaTrackerEventId APP_USAGE_INFO = null;
    public static final OsTeaTrackerEventId IMAGE_TO_MEMORY_EVENT = null;
    public static final OsTeaTrackerEventId LOCATION = null;
    public static final OsTeaTrackerEventId MEMORY_COLLECT_SCREENSHOT_DATA_EVENT = null;
    public static final OsTeaTrackerEventId MEMORY_DEV_EVENT = null;
    public static final OsTeaTrackerEventId MEMORY_HAR_AND_LOCATION_STATE_EVENT = null;
    public static final OsTeaTrackerEventId MEMORY_SAVE_SCREENSHOT_EVENT = null;
    public static final OsTeaTrackerEventId MEMORY_TASK_EXECUTE_INFO = null;
    public static final OsTeaTrackerEventId MOVEMENT_STATE = null;
    public static final OsTeaTrackerEventId RECOMMEND_DELETE_EXPIRED_DATA_EVENT = null;
    public static final OsTeaTrackerEventId SCREENSHOT_TO_FILE_EVENT = null;
    private final String value;

    private static final /* synthetic */ OsTeaTrackerEventId[] $values() {
        return new OsTeaTrackerEventId[]{MOVEMENT_STATE, LOCATION, MEMORY_DEV_EVENT, APP_USAGE_INFO, MEMORY_TASK_EXECUTE_INFO, RECOMMEND_DELETE_EXPIRED_DATA_EVENT, IMAGE_TO_MEMORY_EVENT, MEMORY_HAR_AND_LOCATION_STATE_EVENT, SCREENSHOT_TO_FILE_EVENT, MEMORY_COLLECT_SCREENSHOT_DATA_EVENT, MEMORY_SAVE_SCREENSHOT_EVENT};
    }

    static {
        MOVEMENT_STATE = new OsTeaTrackerEventId("MOVEMENT_STATE", 0, "os_movement_state");
        LOCATION = new OsTeaTrackerEventId("LOCATION", 1, "os_location");
        MEMORY_DEV_EVENT = new OsTeaTrackerEventId("MEMORY_DEV_EVENT", 2, "os_memory_dev_event");
        APP_USAGE_INFO = new OsTeaTrackerEventId("APP_USAGE_INFO", 3, "os_app_usage_info");
        MEMORY_TASK_EXECUTE_INFO = new OsTeaTrackerEventId("MEMORY_TASK_EXECUTE_INFO", 4, "os_memory_task_execute_info");
        RECOMMEND_DELETE_EXPIRED_DATA_EVENT = new OsTeaTrackerEventId("RECOMMEND_DELETE_EXPIRED_DATA_EVENT", 5, "recommend_delete_expired_data_event");
        IMAGE_TO_MEMORY_EVENT = new OsTeaTrackerEventId("IMAGE_TO_MEMORY_EVENT", 6, "image_to_memory_event");
        MEMORY_HAR_AND_LOCATION_STATE_EVENT = new OsTeaTrackerEventId("MEMORY_HAR_AND_LOCATION_STATE_EVENT", 7, "memory_har_and_location");
        SCREENSHOT_TO_FILE_EVENT = new OsTeaTrackerEventId("SCREENSHOT_TO_FILE_EVENT", 8, "screenshot_to_file_event");
        MEMORY_COLLECT_SCREENSHOT_DATA_EVENT = new OsTeaTrackerEventId("MEMORY_COLLECT_SCREENSHOT_DATA_EVENT", 9, "memory_collect_screenshot_data_event");
        MEMORY_SAVE_SCREENSHOT_EVENT = new OsTeaTrackerEventId("MEMORY_SAVE_SCREENSHOT_EVENT", 10, "memory_save_screenshot_event");
        OsTeaTrackerEventId[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private OsTeaTrackerEventId(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<OsTeaTrackerEventId> getEntries() {
        return $ENTRIES;
    }

    public static OsTeaTrackerEventId valueOf(String r2) {
        return (OsTeaTrackerEventId) ZeusTransformUtils.preCheckCast(Enum.valueOf(OsTeaTrackerEventId.class, r2), OsTeaTrackerEventId.class, "com.obric.memorydata.plugin");
    }

    public static OsTeaTrackerEventId[] values() {
        return (OsTeaTrackerEventId[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OsTeaTrackerEventId[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}
