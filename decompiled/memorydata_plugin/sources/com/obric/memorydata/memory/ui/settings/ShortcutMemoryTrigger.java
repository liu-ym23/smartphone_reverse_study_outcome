package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "AI_VOLUME", "GESTURE", "OTHER", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ShortcutMemoryTrigger extends Enum<ShortcutMemoryTrigger> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ShortcutMemoryTrigger[] $VALUES = null;
    public static final ShortcutMemoryTrigger AI_VOLUME = null;
    public static final ShortcutMemoryTrigger GESTURE = null;
    public static final ShortcutMemoryTrigger OTHER = null;

    private static final /* synthetic */ ShortcutMemoryTrigger[] $values() {
        return new ShortcutMemoryTrigger[]{AI_VOLUME, GESTURE, OTHER};
    }

    static {
        AI_VOLUME = new ShortcutMemoryTrigger("AI_VOLUME", 0);
        GESTURE = new ShortcutMemoryTrigger("GESTURE", 1);
        OTHER = new ShortcutMemoryTrigger("OTHER", 2);
        ShortcutMemoryTrigger[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ShortcutMemoryTrigger(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ShortcutMemoryTrigger> getEntries() {
        return $ENTRIES;
    }

    public static ShortcutMemoryTrigger valueOf(String r2) {
        return (ShortcutMemoryTrigger) ZeusTransformUtils.preCheckCast(Enum.valueOf(ShortcutMemoryTrigger.class, r2), ShortcutMemoryTrigger.class, "com.obric.memorydata.plugin");
    }

    public static ShortcutMemoryTrigger[] values() {
        return (ShortcutMemoryTrigger[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ShortcutMemoryTrigger[].class, "com.obric.memorydata.plugin");
    }
}
