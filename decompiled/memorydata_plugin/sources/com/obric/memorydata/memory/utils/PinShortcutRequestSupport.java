package com.obric.memorydata.memory.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/utils/PinShortcutRequestSupport;", "", "<init>", "(Ljava/lang/String;I)V", "SUPPORTED", "UNSUPPORTED", "UNKNOWN", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PinShortcutRequestSupport extends Enum<PinShortcutRequestSupport> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PinShortcutRequestSupport[] $VALUES = null;
    public static final PinShortcutRequestSupport SUPPORTED = null;
    public static final PinShortcutRequestSupport UNKNOWN = null;
    public static final PinShortcutRequestSupport UNSUPPORTED = null;

    private static final /* synthetic */ PinShortcutRequestSupport[] $values() {
        return new PinShortcutRequestSupport[]{SUPPORTED, UNSUPPORTED, UNKNOWN};
    }

    static {
        SUPPORTED = new PinShortcutRequestSupport("SUPPORTED", 0);
        UNSUPPORTED = new PinShortcutRequestSupport("UNSUPPORTED", 1);
        UNKNOWN = new PinShortcutRequestSupport("UNKNOWN", 2);
        PinShortcutRequestSupport[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private PinShortcutRequestSupport(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<PinShortcutRequestSupport> getEntries() {
        return $ENTRIES;
    }

    public static PinShortcutRequestSupport valueOf(String r2) {
        return (PinShortcutRequestSupport) ZeusTransformUtils.preCheckCast(Enum.valueOf(PinShortcutRequestSupport.class, r2), PinShortcutRequestSupport.class, "com.obric.memorydata.plugin");
    }

    public static PinShortcutRequestSupport[] values() {
        return (PinShortcutRequestSupport[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PinShortcutRequestSupport[].class, "com.obric.memorydata.plugin");
    }
}
