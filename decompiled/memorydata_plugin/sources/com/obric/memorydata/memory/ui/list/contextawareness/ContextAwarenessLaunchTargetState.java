package com.obric.memorydata.memory.ui.list.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessLaunchTargetState;", "", "<init>", "(Ljava/lang/String;I)V", "UNINITIALIZED", "PENDING", "CONSUMED", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ContextAwarenessLaunchTargetState extends Enum<ContextAwarenessLaunchTargetState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ContextAwarenessLaunchTargetState[] $VALUES = null;
    public static final ContextAwarenessLaunchTargetState CONSUMED = null;
    public static final ContextAwarenessLaunchTargetState PENDING = null;
    public static final ContextAwarenessLaunchTargetState UNINITIALIZED = null;

    private static final /* synthetic */ ContextAwarenessLaunchTargetState[] $values() {
        return new ContextAwarenessLaunchTargetState[]{UNINITIALIZED, PENDING, CONSUMED};
    }

    static {
        UNINITIALIZED = new ContextAwarenessLaunchTargetState("UNINITIALIZED", 0);
        PENDING = new ContextAwarenessLaunchTargetState("PENDING", 1);
        CONSUMED = new ContextAwarenessLaunchTargetState("CONSUMED", 2);
        ContextAwarenessLaunchTargetState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ContextAwarenessLaunchTargetState(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ContextAwarenessLaunchTargetState> getEntries() {
        return $ENTRIES;
    }

    public static ContextAwarenessLaunchTargetState valueOf(String r2) {
        return (ContextAwarenessLaunchTargetState) ZeusTransformUtils.preCheckCast(Enum.valueOf(ContextAwarenessLaunchTargetState.class, r2), ContextAwarenessLaunchTargetState.class, "com.obric.memorydata.plugin");
    }

    public static ContextAwarenessLaunchTargetState[] values() {
        return (ContextAwarenessLaunchTargetState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContextAwarenessLaunchTargetState[].class, "com.obric.memorydata.plugin");
    }
}
