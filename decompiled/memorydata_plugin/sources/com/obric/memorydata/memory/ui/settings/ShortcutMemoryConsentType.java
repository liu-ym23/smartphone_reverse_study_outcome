package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentType;", "", "<init>", "(Ljava/lang/String;I)V", "AI_VOLUME", "GESTURE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ShortcutMemoryConsentType extends Enum<ShortcutMemoryConsentType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ShortcutMemoryConsentType[] $VALUES = null;
    public static final ShortcutMemoryConsentType AI_VOLUME = null;
    public static final ShortcutMemoryConsentType GESTURE = null;

    private static final /* synthetic */ ShortcutMemoryConsentType[] $values() {
        return new ShortcutMemoryConsentType[]{AI_VOLUME, GESTURE};
    }

    static {
        AI_VOLUME = new ShortcutMemoryConsentType("AI_VOLUME", 0);
        GESTURE = new ShortcutMemoryConsentType("GESTURE", 1);
        ShortcutMemoryConsentType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ShortcutMemoryConsentType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ShortcutMemoryConsentType> getEntries() {
        return $ENTRIES;
    }

    public static ShortcutMemoryConsentType valueOf(String r2) {
        return (ShortcutMemoryConsentType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ShortcutMemoryConsentType.class, r2), ShortcutMemoryConsentType.class, "com.obric.memorydata.plugin");
    }

    public static ShortcutMemoryConsentType[] values() {
        return (ShortcutMemoryConsentType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ShortcutMemoryConsentType[].class, "com.obric.memorydata.plugin");
    }
}
