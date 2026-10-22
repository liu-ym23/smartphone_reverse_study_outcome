package com.obric.aiproactive.api;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveShortcutRequestResult;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED_PIN_REQUEST", "ALREADY_ACTIVE", "ENABLED_EXISTING", "RESTRICTED", "UNSUPPORTED", RawObservationEntity.STATE_FAILED, "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ProactiveShortcutRequestResult extends Enum<ProactiveShortcutRequestResult> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ProactiveShortcutRequestResult[] $VALUES = null;
    public static final ProactiveShortcutRequestResult ALREADY_ACTIVE = null;
    public static final ProactiveShortcutRequestResult ENABLED_EXISTING = null;
    public static final ProactiveShortcutRequestResult FAILED = null;
    public static final ProactiveShortcutRequestResult RESTRICTED = null;
    public static final ProactiveShortcutRequestResult STARTED_PIN_REQUEST = null;
    public static final ProactiveShortcutRequestResult UNSUPPORTED = null;

    private static final /* synthetic */ ProactiveShortcutRequestResult[] $values() {
        return new ProactiveShortcutRequestResult[]{STARTED_PIN_REQUEST, ALREADY_ACTIVE, ENABLED_EXISTING, RESTRICTED, UNSUPPORTED, FAILED};
    }

    static {
        STARTED_PIN_REQUEST = new ProactiveShortcutRequestResult("STARTED_PIN_REQUEST", 0);
        ALREADY_ACTIVE = new ProactiveShortcutRequestResult("ALREADY_ACTIVE", 1);
        ENABLED_EXISTING = new ProactiveShortcutRequestResult("ENABLED_EXISTING", 2);
        RESTRICTED = new ProactiveShortcutRequestResult("RESTRICTED", 3);
        UNSUPPORTED = new ProactiveShortcutRequestResult("UNSUPPORTED", 4);
        FAILED = new ProactiveShortcutRequestResult(RawObservationEntity.STATE_FAILED, 5);
        ProactiveShortcutRequestResult[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ProactiveShortcutRequestResult(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ProactiveShortcutRequestResult> getEntries() {
        return $ENTRIES;
    }

    public static ProactiveShortcutRequestResult valueOf(String r2) {
        return (ProactiveShortcutRequestResult) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProactiveShortcutRequestResult.class, r2), ProactiveShortcutRequestResult.class, "com.obric.memorydata.plugin");
    }

    public static ProactiveShortcutRequestResult[] values() {
        return (ProactiveShortcutRequestResult[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProactiveShortcutRequestResult[].class, "com.obric.memorydata.plugin");
    }
}
