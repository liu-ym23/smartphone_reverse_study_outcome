package com.obric.memorydata.memory.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/utils/PinShortcutTerminalSource;", "", "<init>", "(Ljava/lang/String;I)V", "SYSTEM_CALLBACK", "FALLBACK", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PinShortcutTerminalSource extends Enum<PinShortcutTerminalSource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PinShortcutTerminalSource[] $VALUES = null;
    public static final PinShortcutTerminalSource FALLBACK = null;
    public static final PinShortcutTerminalSource SYSTEM_CALLBACK = null;

    private static final /* synthetic */ PinShortcutTerminalSource[] $values() {
        return new PinShortcutTerminalSource[]{SYSTEM_CALLBACK, FALLBACK};
    }

    static {
        SYSTEM_CALLBACK = new PinShortcutTerminalSource("SYSTEM_CALLBACK", 0);
        FALLBACK = new PinShortcutTerminalSource("FALLBACK", 1);
        PinShortcutTerminalSource[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private PinShortcutTerminalSource(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<PinShortcutTerminalSource> getEntries() {
        return $ENTRIES;
    }

    public static PinShortcutTerminalSource valueOf(String r2) {
        return (PinShortcutTerminalSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(PinShortcutTerminalSource.class, r2), PinShortcutTerminalSource.class, "com.obric.memorydata.plugin");
    }

    public static PinShortcutTerminalSource[] values() {
        return (PinShortcutTerminalSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PinShortcutTerminalSource[].class, "com.obric.memorydata.plugin");
    }
}
