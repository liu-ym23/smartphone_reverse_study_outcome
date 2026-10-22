package com.obric.memorydata.memory.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/utils/PinnedShortcutState;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE", "DISABLED", "ABSENT", "UNKNOWN", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PinnedShortcutState extends Enum<PinnedShortcutState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PinnedShortcutState[] $VALUES = null;
    public static final PinnedShortcutState ABSENT = null;
    public static final PinnedShortcutState ACTIVE = null;
    public static final PinnedShortcutState DISABLED = null;
    public static final PinnedShortcutState UNKNOWN = null;

    private static final /* synthetic */ PinnedShortcutState[] $values() {
        return new PinnedShortcutState[]{ACTIVE, DISABLED, ABSENT, UNKNOWN};
    }

    static {
        ACTIVE = new PinnedShortcutState("ACTIVE", 0);
        DISABLED = new PinnedShortcutState("DISABLED", 1);
        ABSENT = new PinnedShortcutState("ABSENT", 2);
        UNKNOWN = new PinnedShortcutState("UNKNOWN", 3);
        PinnedShortcutState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private PinnedShortcutState(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<PinnedShortcutState> getEntries() {
        return $ENTRIES;
    }

    public static PinnedShortcutState valueOf(String r2) {
        return (PinnedShortcutState) ZeusTransformUtils.preCheckCast(Enum.valueOf(PinnedShortcutState.class, r2), PinnedShortcutState.class, "com.obric.memorydata.plugin");
    }

    public static PinnedShortcutState[] values() {
        return (PinnedShortcutState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PinnedShortcutState[].class, "com.obric.memorydata.plugin");
    }
}
