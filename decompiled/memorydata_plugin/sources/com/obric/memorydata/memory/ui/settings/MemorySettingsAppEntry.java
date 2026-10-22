package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/MemorySettingsAppEntry;", "", "<init>", "(Ljava/lang/String;I)V", "PROACTIVE", "LIFELOG", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemorySettingsAppEntry extends Enum<MemorySettingsAppEntry> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemorySettingsAppEntry[] $VALUES = null;
    public static final MemorySettingsAppEntry LIFELOG = null;
    public static final MemorySettingsAppEntry PROACTIVE = null;

    private static final /* synthetic */ MemorySettingsAppEntry[] $values() {
        return new MemorySettingsAppEntry[]{PROACTIVE, LIFELOG};
    }

    static {
        PROACTIVE = new MemorySettingsAppEntry("PROACTIVE", 0);
        LIFELOG = new MemorySettingsAppEntry("LIFELOG", 1);
        MemorySettingsAppEntry[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private MemorySettingsAppEntry(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<MemorySettingsAppEntry> getEntries() {
        return $ENTRIES;
    }

    public static MemorySettingsAppEntry valueOf(String r2) {
        return (MemorySettingsAppEntry) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemorySettingsAppEntry.class, r2), MemorySettingsAppEntry.class, "com.obric.memorydata.plugin");
    }

    public static MemorySettingsAppEntry[] values() {
        return (MemorySettingsAppEntry[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemorySettingsAppEntry[].class, "com.obric.memorydata.plugin");
    }
}
