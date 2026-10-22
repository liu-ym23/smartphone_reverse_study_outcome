package com.obric.memorydata.memory.ui.list.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessSettingsNavigationTarget;", "", "<init>", "(Ljava/lang/String;I)V", "CONTEXT_AWARENESS_SETTINGS", "GLOBAL_MEMORY_SETTINGS", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ContextAwarenessSettingsNavigationTarget extends Enum<ContextAwarenessSettingsNavigationTarget> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ContextAwarenessSettingsNavigationTarget[] $VALUES = null;
    public static final ContextAwarenessSettingsNavigationTarget CONTEXT_AWARENESS_SETTINGS = null;
    public static final ContextAwarenessSettingsNavigationTarget GLOBAL_MEMORY_SETTINGS = null;

    private static final /* synthetic */ ContextAwarenessSettingsNavigationTarget[] $values() {
        return new ContextAwarenessSettingsNavigationTarget[]{CONTEXT_AWARENESS_SETTINGS, GLOBAL_MEMORY_SETTINGS};
    }

    static {
        CONTEXT_AWARENESS_SETTINGS = new ContextAwarenessSettingsNavigationTarget("CONTEXT_AWARENESS_SETTINGS", 0);
        GLOBAL_MEMORY_SETTINGS = new ContextAwarenessSettingsNavigationTarget("GLOBAL_MEMORY_SETTINGS", 1);
        ContextAwarenessSettingsNavigationTarget[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ContextAwarenessSettingsNavigationTarget(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ContextAwarenessSettingsNavigationTarget> getEntries() {
        return $ENTRIES;
    }

    public static ContextAwarenessSettingsNavigationTarget valueOf(String r2) {
        return (ContextAwarenessSettingsNavigationTarget) ZeusTransformUtils.preCheckCast(Enum.valueOf(ContextAwarenessSettingsNavigationTarget.class, r2), ContextAwarenessSettingsNavigationTarget.class, "com.obric.memorydata.plugin");
    }

    public static ContextAwarenessSettingsNavigationTarget[] values() {
        return (ContextAwarenessSettingsNavigationTarget[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContextAwarenessSettingsNavigationTarget[].class, "com.obric.memorydata.plugin");
    }
}
