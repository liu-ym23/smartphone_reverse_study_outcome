package com.obric.memorydata.datatransport.excel;

import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/datatransport/excel/SessionType;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FINE_TUNE", "MEMORY", "TEST", "QUERY", "DATA", "ACCESSIBILITY_EVENT", "EVALUATION_PERSONAL_CONTEXT_OLD", "EVALUATION_PERSONAL_CONTEXT_EXTEND", "SYNONYMS", "USER_INFO", "EVALUATION_CRITERIA", "PERSONAL_CONTEXT_EVALUATION_DATA", "PERSONAL_CONTEXT_TEST_QUERY", "EVALUATION_PERSONAL_CONTEXT_QUERY_RESULT", "EVALUATION_PERSONAL_CONTEXT_INDICATOR_RESULT", "EVALUATION_PERSONAL_CONTEXT_FINAL_RESULT_RATE", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SessionType extends Enum<SessionType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SessionType[] $VALUES = null;
    public static final SessionType ACCESSIBILITY_EVENT = null;
    public static final SessionType DATA = null;
    public static final SessionType EVALUATION_CRITERIA = null;
    public static final SessionType EVALUATION_PERSONAL_CONTEXT_EXTEND = null;
    public static final SessionType EVALUATION_PERSONAL_CONTEXT_FINAL_RESULT_RATE = null;
    public static final SessionType EVALUATION_PERSONAL_CONTEXT_INDICATOR_RESULT = null;
    public static final SessionType EVALUATION_PERSONAL_CONTEXT_OLD = null;
    public static final SessionType EVALUATION_PERSONAL_CONTEXT_QUERY_RESULT = null;
    public static final SessionType FINE_TUNE = null;
    public static final SessionType MEMORY = null;
    public static final SessionType PERSONAL_CONTEXT_EVALUATION_DATA = null;
    public static final SessionType PERSONAL_CONTEXT_TEST_QUERY = null;
    public static final SessionType QUERY = null;
    public static final SessionType SYNONYMS = null;
    public static final SessionType TEST = null;
    public static final SessionType USER_INFO = null;
    private final String value;

    private static final /* synthetic */ SessionType[] $values() {
        return new SessionType[]{FINE_TUNE, MEMORY, TEST, QUERY, DATA, ACCESSIBILITY_EVENT, EVALUATION_PERSONAL_CONTEXT_OLD, EVALUATION_PERSONAL_CONTEXT_EXTEND, SYNONYMS, USER_INFO, EVALUATION_CRITERIA, PERSONAL_CONTEXT_EVALUATION_DATA, PERSONAL_CONTEXT_TEST_QUERY, EVALUATION_PERSONAL_CONTEXT_QUERY_RESULT, EVALUATION_PERSONAL_CONTEXT_INDICATOR_RESULT, EVALUATION_PERSONAL_CONTEXT_FINAL_RESULT_RATE};
    }

    static {
        FINE_TUNE = new SessionType("FINE_TUNE", 0, "fine-tune");
        MEMORY = new SessionType("MEMORY", 1, SlardarSettingsConstants.PERF_KEY_MEMORY);
        TEST = new SessionType("TEST", 2, "test");
        QUERY = new SessionType("QUERY", 3, ChatMessage.TYPE_QUERY);
        DATA = new SessionType("DATA", 4, "data");
        ACCESSIBILITY_EVENT = new SessionType("ACCESSIBILITY_EVENT", 5, "accessibility-event");
        EVALUATION_PERSONAL_CONTEXT_OLD = new SessionType("EVALUATION_PERSONAL_CONTEXT_OLD", 6, "evaluation-personal-context");
        EVALUATION_PERSONAL_CONTEXT_EXTEND = new SessionType("EVALUATION_PERSONAL_CONTEXT_EXTEND", 7, "evaluation-personal-context-extend");
        SYNONYMS = new SessionType("SYNONYMS", 8, "synonyms");
        USER_INFO = new SessionType("USER_INFO", 9, "user-info");
        EVALUATION_CRITERIA = new SessionType("EVALUATION_CRITERIA", 10, "evaluation-criteria");
        PERSONAL_CONTEXT_EVALUATION_DATA = new SessionType("PERSONAL_CONTEXT_EVALUATION_DATA", 11, "personal-context-evaluation-data");
        PERSONAL_CONTEXT_TEST_QUERY = new SessionType("PERSONAL_CONTEXT_TEST_QUERY", 12, "personal-context-test-query");
        EVALUATION_PERSONAL_CONTEXT_QUERY_RESULT = new SessionType("EVALUATION_PERSONAL_CONTEXT_QUERY_RESULT", 13, "evaluation-personal-context-query-result");
        EVALUATION_PERSONAL_CONTEXT_INDICATOR_RESULT = new SessionType("EVALUATION_PERSONAL_CONTEXT_INDICATOR_RESULT", 14, "evaluation-personal-context-indicator-result");
        EVALUATION_PERSONAL_CONTEXT_FINAL_RESULT_RATE = new SessionType("EVALUATION_PERSONAL_CONTEXT_FINAL_RESULT_RATE", 15, "evaluation-personal-context-final-result-rate");
        SessionType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private SessionType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<SessionType> getEntries() {
        return $ENTRIES;
    }

    public static SessionType valueOf(String r2) {
        return (SessionType) ZeusTransformUtils.preCheckCast(Enum.valueOf(SessionType.class, r2), SessionType.class, "com.obric.memorydata.plugin");
    }

    public static SessionType[] values() {
        return (SessionType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SessionType[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}
