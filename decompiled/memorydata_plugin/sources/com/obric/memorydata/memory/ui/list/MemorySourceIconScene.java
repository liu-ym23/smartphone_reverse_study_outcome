package com.obric.memorydata.memory.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySourceIconScene;", "", "<init>", "(Ljava/lang/String;I)V", "LIST", "DETAIL", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemorySourceIconScene extends Enum<MemorySourceIconScene> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemorySourceIconScene[] $VALUES = null;
    public static final MemorySourceIconScene DETAIL = null;
    public static final MemorySourceIconScene LIST = null;

    private static final /* synthetic */ MemorySourceIconScene[] $values() {
        return new MemorySourceIconScene[]{LIST, DETAIL};
    }

    static {
        LIST = new MemorySourceIconScene("LIST", 0);
        DETAIL = new MemorySourceIconScene("DETAIL", 1);
        MemorySourceIconScene[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private MemorySourceIconScene(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<MemorySourceIconScene> getEntries() {
        return $ENTRIES;
    }

    public static MemorySourceIconScene valueOf(String r2) {
        return (MemorySourceIconScene) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemorySourceIconScene.class, r2), MemorySourceIconScene.class, "com.obric.memorydata.plugin");
    }

    public static MemorySourceIconScene[] values() {
        return (MemorySourceIconScene[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemorySourceIconScene[].class, "com.obric.memorydata.plugin");
    }
}
