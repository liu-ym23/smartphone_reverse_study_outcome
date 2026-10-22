package com.obric.memorydata.memory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/AutoMemoryRuntimeMode;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED", "IN_APP", "ACCESSIBILITY", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AutoMemoryRuntimeMode extends Enum<AutoMemoryRuntimeMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AutoMemoryRuntimeMode[] $VALUES = null;
    public static final AutoMemoryRuntimeMode ACCESSIBILITY = null;
    public static final AutoMemoryRuntimeMode DISABLED = null;
    public static final AutoMemoryRuntimeMode IN_APP = null;

    private static final /* synthetic */ AutoMemoryRuntimeMode[] $values() {
        return new AutoMemoryRuntimeMode[]{DISABLED, IN_APP, ACCESSIBILITY};
    }

    static {
        DISABLED = new AutoMemoryRuntimeMode("DISABLED", 0);
        IN_APP = new AutoMemoryRuntimeMode("IN_APP", 1);
        ACCESSIBILITY = new AutoMemoryRuntimeMode("ACCESSIBILITY", 2);
        AutoMemoryRuntimeMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AutoMemoryRuntimeMode(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AutoMemoryRuntimeMode> getEntries() {
        return $ENTRIES;
    }

    public static AutoMemoryRuntimeMode valueOf(String r2) {
        return (AutoMemoryRuntimeMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(AutoMemoryRuntimeMode.class, r2), AutoMemoryRuntimeMode.class, "com.obric.memorydata.plugin");
    }

    public static AutoMemoryRuntimeMode[] values() {
        return (AutoMemoryRuntimeMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AutoMemoryRuntimeMode[].class, "com.obric.memorydata.plugin");
    }
}
