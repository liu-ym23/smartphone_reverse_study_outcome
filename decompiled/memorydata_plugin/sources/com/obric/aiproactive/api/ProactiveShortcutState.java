package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveShortcutState;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE", "INACTIVE", "RESTRICTED", "UNKNOWN", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ProactiveShortcutState extends Enum<ProactiveShortcutState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ProactiveShortcutState[] $VALUES = null;
    public static final ProactiveShortcutState ACTIVE = null;
    public static final ProactiveShortcutState INACTIVE = null;
    public static final ProactiveShortcutState RESTRICTED = null;
    public static final ProactiveShortcutState UNKNOWN = null;

    private static final /* synthetic */ ProactiveShortcutState[] $values() {
        return new ProactiveShortcutState[]{ACTIVE, INACTIVE, RESTRICTED, UNKNOWN};
    }

    static {
        ACTIVE = new ProactiveShortcutState("ACTIVE", 0);
        INACTIVE = new ProactiveShortcutState("INACTIVE", 1);
        RESTRICTED = new ProactiveShortcutState("RESTRICTED", 2);
        UNKNOWN = new ProactiveShortcutState("UNKNOWN", 3);
        ProactiveShortcutState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ProactiveShortcutState(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ProactiveShortcutState> getEntries() {
        return $ENTRIES;
    }

    public static ProactiveShortcutState valueOf(String r2) {
        return (ProactiveShortcutState) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProactiveShortcutState.class, r2), ProactiveShortcutState.class, "com.obric.memorydata.plugin");
    }

    public static ProactiveShortcutState[] values() {
        return (ProactiveShortcutState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProactiveShortcutState[].class, "com.obric.memorydata.plugin");
    }
}
