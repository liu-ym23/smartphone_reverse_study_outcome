package com.obric.memorydata.constants;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b \b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/obric/memorydata/constants/DevTrackerEventId;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PREDICT_APP_LAUNCH_ACCURACY", "PREDICT_APP_LAUNCH_RECALL", "PREDICT_NEXT_APP_LAUNCH_RESULT", "LLM_SUMMARY_EVENT_FAILED", "LLM_SUMMARY_EVENT_FAILED_TOO_MANY_TIMES", "AWARE_SCREEN_NER", "AWARE_TEXT_NER", "APP_ENTITY_TEXT_NER", "AWARE_SESSION_REFERENCE", "ENTITY_CONSISTENCY_STATE", "ENTITY_UPDATE_CHECK_STATE", "AWARE_ON_SCREEN_NER_QUERY_DELTA", "AWARE_ON_SCREEN_OCR_NER", "AWARE_ON_SCREEN_OCR", "AWARE_ON_SCREEN_OCR_RESULT", "AWARE_VIEW_TREE_BAD_CASE", "AWARE_SCREEN_LINK", "AWARE_REALM_RESULT", "TASK_PENDING_EVENT", "MEMORY_EXTRACT_END_TO_END_EVENT", "ON_SMART_MEMORY_SWITCH_COUNT_CHANGE_EVENT", "MEMORY_SOURCE_LINK_JUMP", "RECOMMEND_FUNCTION_CALL", "OPEN_AI_RECOMMEND_EVENT", "CLOSE_AI_RECOMMEND_EVENT", "REQUEST_LOCATION_EVENT", "MEMORY_CORRELATION_PERF_EVENT", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DevTrackerEventId extends Enum<DevTrackerEventId> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DevTrackerEventId[] $VALUES = null;
    public static final DevTrackerEventId APP_ENTITY_TEXT_NER = null;
    public static final DevTrackerEventId AWARE_ON_SCREEN_NER_QUERY_DELTA = null;
    public static final DevTrackerEventId AWARE_ON_SCREEN_OCR = null;
    public static final DevTrackerEventId AWARE_ON_SCREEN_OCR_NER = null;
    public static final DevTrackerEventId AWARE_ON_SCREEN_OCR_RESULT = null;
    public static final DevTrackerEventId AWARE_REALM_RESULT = null;
    public static final DevTrackerEventId AWARE_SCREEN_LINK = null;
    public static final DevTrackerEventId AWARE_SCREEN_NER = null;
    public static final DevTrackerEventId AWARE_SESSION_REFERENCE = null;
    public static final DevTrackerEventId AWARE_TEXT_NER = null;
    public static final DevTrackerEventId AWARE_VIEW_TREE_BAD_CASE = null;
    public static final DevTrackerEventId CLOSE_AI_RECOMMEND_EVENT = null;
    public static final DevTrackerEventId ENTITY_CONSISTENCY_STATE = null;
    public static final DevTrackerEventId ENTITY_UPDATE_CHECK_STATE = null;
    public static final DevTrackerEventId LLM_SUMMARY_EVENT_FAILED = null;
    public static final DevTrackerEventId LLM_SUMMARY_EVENT_FAILED_TOO_MANY_TIMES = null;
    public static final DevTrackerEventId MEMORY_CORRELATION_PERF_EVENT = null;
    public static final DevTrackerEventId MEMORY_EXTRACT_END_TO_END_EVENT = null;
    public static final DevTrackerEventId MEMORY_SOURCE_LINK_JUMP = null;
    public static final DevTrackerEventId ON_SMART_MEMORY_SWITCH_COUNT_CHANGE_EVENT = null;
    public static final DevTrackerEventId OPEN_AI_RECOMMEND_EVENT = null;
    public static final DevTrackerEventId PREDICT_APP_LAUNCH_ACCURACY = null;
    public static final DevTrackerEventId PREDICT_APP_LAUNCH_RECALL = null;
    public static final DevTrackerEventId PREDICT_NEXT_APP_LAUNCH_RESULT = null;
    public static final DevTrackerEventId RECOMMEND_FUNCTION_CALL = null;
    public static final DevTrackerEventId REQUEST_LOCATION_EVENT = null;
    public static final DevTrackerEventId TASK_PENDING_EVENT = null;
    private final String value;

    private static final /* synthetic */ DevTrackerEventId[] $values() {
        return new DevTrackerEventId[]{PREDICT_APP_LAUNCH_ACCURACY, PREDICT_APP_LAUNCH_RECALL, PREDICT_NEXT_APP_LAUNCH_RESULT, LLM_SUMMARY_EVENT_FAILED, LLM_SUMMARY_EVENT_FAILED_TOO_MANY_TIMES, AWARE_SCREEN_NER, AWARE_TEXT_NER, APP_ENTITY_TEXT_NER, AWARE_SESSION_REFERENCE, ENTITY_CONSISTENCY_STATE, ENTITY_UPDATE_CHECK_STATE, AWARE_ON_SCREEN_NER_QUERY_DELTA, AWARE_ON_SCREEN_OCR_NER, AWARE_ON_SCREEN_OCR, AWARE_ON_SCREEN_OCR_RESULT, AWARE_VIEW_TREE_BAD_CASE, AWARE_SCREEN_LINK, AWARE_REALM_RESULT, TASK_PENDING_EVENT, MEMORY_EXTRACT_END_TO_END_EVENT, ON_SMART_MEMORY_SWITCH_COUNT_CHANGE_EVENT, MEMORY_SOURCE_LINK_JUMP, RECOMMEND_FUNCTION_CALL, OPEN_AI_RECOMMEND_EVENT, CLOSE_AI_RECOMMEND_EVENT, REQUEST_LOCATION_EVENT, MEMORY_CORRELATION_PERF_EVENT};
    }

    static {
        PREDICT_APP_LAUNCH_ACCURACY = new DevTrackerEventId("PREDICT_APP_LAUNCH_ACCURACY", 0, "predict_app_launch_accuracy");
        PREDICT_APP_LAUNCH_RECALL = new DevTrackerEventId("PREDICT_APP_LAUNCH_RECALL", 1, "predict_app_launch_recall");
        PREDICT_NEXT_APP_LAUNCH_RESULT = new DevTrackerEventId("PREDICT_NEXT_APP_LAUNCH_RESULT", 2, "predict_next_app_launch_result");
        LLM_SUMMARY_EVENT_FAILED = new DevTrackerEventId("LLM_SUMMARY_EVENT_FAILED", 3, "llm_summary_event_failed");
        LLM_SUMMARY_EVENT_FAILED_TOO_MANY_TIMES = new DevTrackerEventId("LLM_SUMMARY_EVENT_FAILED_TOO_MANY_TIMES", 4, "llm_summary_event_failed_too_many_times");
        AWARE_SCREEN_NER = new DevTrackerEventId("AWARE_SCREEN_NER", 5, "aware_screen_ner");
        AWARE_TEXT_NER = new DevTrackerEventId("AWARE_TEXT_NER", 6, "aware_text_ner");
        APP_ENTITY_TEXT_NER = new DevTrackerEventId("APP_ENTITY_TEXT_NER", 7, "aware_app_entity_text_ner");
        AWARE_SESSION_REFERENCE = new DevTrackerEventId("AWARE_SESSION_REFERENCE", 8, "aware_session_reference");
        ENTITY_CONSISTENCY_STATE = new DevTrackerEventId("ENTITY_CONSISTENCY_STATE", 9, "entity_consistency_state");
        ENTITY_UPDATE_CHECK_STATE = new DevTrackerEventId("ENTITY_UPDATE_CHECK_STATE", 10, "entity_update_check_state");
        AWARE_ON_SCREEN_NER_QUERY_DELTA = new DevTrackerEventId("AWARE_ON_SCREEN_NER_QUERY_DELTA", 11, "aware_on_screen_ner_query_delta");
        AWARE_ON_SCREEN_OCR_NER = new DevTrackerEventId("AWARE_ON_SCREEN_OCR_NER", 12, "aware_on_screen_ocr_ner");
        AWARE_ON_SCREEN_OCR = new DevTrackerEventId("AWARE_ON_SCREEN_OCR", 13, "ocr_event");
        AWARE_ON_SCREEN_OCR_RESULT = new DevTrackerEventId("AWARE_ON_SCREEN_OCR_RESULT", 14, "ocr_event_result");
        AWARE_VIEW_TREE_BAD_CASE = new DevTrackerEventId("AWARE_VIEW_TREE_BAD_CASE", 15, "aware_view_tree_bad_case");
        AWARE_SCREEN_LINK = new DevTrackerEventId("AWARE_SCREEN_LINK", 16, "aware_screen_link");
        AWARE_REALM_RESULT = new DevTrackerEventId("AWARE_REALM_RESULT", 17, "aware_realm_result");
        TASK_PENDING_EVENT = new DevTrackerEventId("TASK_PENDING_EVENT", 18, "task_pending_event");
        MEMORY_EXTRACT_END_TO_END_EVENT = new DevTrackerEventId("MEMORY_EXTRACT_END_TO_END_EVENT", 19, "memory_extract_end_to_end_event");
        ON_SMART_MEMORY_SWITCH_COUNT_CHANGE_EVENT = new DevTrackerEventId("ON_SMART_MEMORY_SWITCH_COUNT_CHANGE_EVENT", 20, "on_smart_memory_switch_count_change_event");
        MEMORY_SOURCE_LINK_JUMP = new DevTrackerEventId("MEMORY_SOURCE_LINK_JUMP", 21, "memory_source_link_jump");
        RECOMMEND_FUNCTION_CALL = new DevTrackerEventId("RECOMMEND_FUNCTION_CALL", 22, "recommend_function_call");
        OPEN_AI_RECOMMEND_EVENT = new DevTrackerEventId("OPEN_AI_RECOMMEND_EVENT", 23, "open_ai_recommend_event");
        CLOSE_AI_RECOMMEND_EVENT = new DevTrackerEventId("CLOSE_AI_RECOMMEND_EVENT", 24, "close_ai_recommend_event");
        REQUEST_LOCATION_EVENT = new DevTrackerEventId("REQUEST_LOCATION_EVENT", 25, "request_location_event");
        MEMORY_CORRELATION_PERF_EVENT = new DevTrackerEventId("MEMORY_CORRELATION_PERF_EVENT", 26, "memory_correlation_perf_event");
        DevTrackerEventId[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private DevTrackerEventId(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<DevTrackerEventId> getEntries() {
        return $ENTRIES;
    }

    public static DevTrackerEventId valueOf(String r2) {
        return (DevTrackerEventId) ZeusTransformUtils.preCheckCast(Enum.valueOf(DevTrackerEventId.class, r2), DevTrackerEventId.class, "com.obric.memorydata.plugin");
    }

    public static DevTrackerEventId[] values() {
        return (DevTrackerEventId[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DevTrackerEventId[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}
