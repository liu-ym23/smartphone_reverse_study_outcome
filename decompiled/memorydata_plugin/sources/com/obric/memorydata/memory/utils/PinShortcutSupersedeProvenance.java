package com.obric.memorydata.memory.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/utils/PinShortcutSupersedeProvenance;", "", "<init>", "(Ljava/lang/String;I)V", "USER_DISABLE", "POLICY", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PinShortcutSupersedeProvenance extends Enum<PinShortcutSupersedeProvenance> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PinShortcutSupersedeProvenance[] $VALUES = null;
    public static final PinShortcutSupersedeProvenance POLICY = null;
    public static final PinShortcutSupersedeProvenance USER_DISABLE = null;

    private static final /* synthetic */ PinShortcutSupersedeProvenance[] $values() {
        return new PinShortcutSupersedeProvenance[]{USER_DISABLE, POLICY};
    }

    static {
        USER_DISABLE = new PinShortcutSupersedeProvenance("USER_DISABLE", 0);
        POLICY = new PinShortcutSupersedeProvenance("POLICY", 1);
        PinShortcutSupersedeProvenance[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private PinShortcutSupersedeProvenance(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<PinShortcutSupersedeProvenance> getEntries() {
        return $ENTRIES;
    }

    public static PinShortcutSupersedeProvenance valueOf(String r2) {
        return (PinShortcutSupersedeProvenance) ZeusTransformUtils.preCheckCast(Enum.valueOf(PinShortcutSupersedeProvenance.class, r2), PinShortcutSupersedeProvenance.class, "com.obric.memorydata.plugin");
    }

    public static PinShortcutSupersedeProvenance[] values() {
        return (PinShortcutSupersedeProvenance[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PinShortcutSupersedeProvenance[].class, "com.obric.memorydata.plugin");
    }
}
