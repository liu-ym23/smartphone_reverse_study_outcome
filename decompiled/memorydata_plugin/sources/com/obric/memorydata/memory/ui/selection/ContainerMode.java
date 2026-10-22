package com.obric.memorydata.memory.ui.selection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/selection/ContainerMode;", "", "<init>", "(Ljava/lang/String;I)V", "NESTED_SCROLL", "RECYCLER_VIEW", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ContainerMode extends Enum<ContainerMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ContainerMode[] $VALUES = null;
    public static final ContainerMode NESTED_SCROLL = null;
    public static final ContainerMode RECYCLER_VIEW = null;

    private static final /* synthetic */ ContainerMode[] $values() {
        return new ContainerMode[]{NESTED_SCROLL, RECYCLER_VIEW};
    }

    static {
        NESTED_SCROLL = new ContainerMode("NESTED_SCROLL", 0);
        RECYCLER_VIEW = new ContainerMode("RECYCLER_VIEW", 1);
        ContainerMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ContainerMode(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ContainerMode> getEntries() {
        return $ENTRIES;
    }

    public static ContainerMode valueOf(String r2) {
        return (ContainerMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ContainerMode.class, r2), ContainerMode.class, "com.obric.memorydata.plugin");
    }

    public static ContainerMode[] values() {
        return (ContainerMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContainerMode[].class, "com.obric.memorydata.plugin");
    }
}
