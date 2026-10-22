package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/MemorySettingsCardPosition;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "TOP", "BOTTOM", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemorySettingsCardPosition extends Enum<MemorySettingsCardPosition> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemorySettingsCardPosition[] $VALUES = null;
    public static final MemorySettingsCardPosition BOTTOM = null;
    public static final MemorySettingsCardPosition SINGLE = null;
    public static final MemorySettingsCardPosition TOP = null;

    private static final /* synthetic */ MemorySettingsCardPosition[] $values() {
        return new MemorySettingsCardPosition[]{SINGLE, TOP, BOTTOM};
    }

    static {
        SINGLE = new MemorySettingsCardPosition("SINGLE", 0);
        TOP = new MemorySettingsCardPosition("TOP", 1);
        BOTTOM = new MemorySettingsCardPosition("BOTTOM", 2);
        MemorySettingsCardPosition[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private MemorySettingsCardPosition(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<MemorySettingsCardPosition> getEntries() {
        return $ENTRIES;
    }

    public static MemorySettingsCardPosition valueOf(String r2) {
        return (MemorySettingsCardPosition) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemorySettingsCardPosition.class, r2), MemorySettingsCardPosition.class, "com.obric.memorydata.plugin");
    }

    public static MemorySettingsCardPosition[] values() {
        return (MemorySettingsCardPosition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemorySettingsCardPosition[].class, "com.obric.memorydata.plugin");
    }
}
