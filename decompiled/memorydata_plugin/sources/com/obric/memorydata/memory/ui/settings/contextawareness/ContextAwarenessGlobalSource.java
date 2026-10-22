package com.obric.memorydata.memory.ui.settings.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessGlobalSource;", "", "<init>", "(Ljava/lang/String;I)V", "MOTION_STATE", "LOCATION", "NOTIFICATION_CONTENT", "DEVICE_STATE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ContextAwarenessGlobalSource extends Enum<ContextAwarenessGlobalSource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ContextAwarenessGlobalSource[] $VALUES = null;
    public static final ContextAwarenessGlobalSource DEVICE_STATE = null;
    public static final ContextAwarenessGlobalSource LOCATION = null;
    public static final ContextAwarenessGlobalSource MOTION_STATE = null;
    public static final ContextAwarenessGlobalSource NOTIFICATION_CONTENT = null;

    private static final /* synthetic */ ContextAwarenessGlobalSource[] $values() {
        return new ContextAwarenessGlobalSource[]{MOTION_STATE, LOCATION, NOTIFICATION_CONTENT, DEVICE_STATE};
    }

    static {
        MOTION_STATE = new ContextAwarenessGlobalSource("MOTION_STATE", 0);
        LOCATION = new ContextAwarenessGlobalSource("LOCATION", 1);
        NOTIFICATION_CONTENT = new ContextAwarenessGlobalSource("NOTIFICATION_CONTENT", 2);
        DEVICE_STATE = new ContextAwarenessGlobalSource("DEVICE_STATE", 3);
        ContextAwarenessGlobalSource[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ContextAwarenessGlobalSource(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ContextAwarenessGlobalSource> getEntries() {
        return $ENTRIES;
    }

    public static ContextAwarenessGlobalSource valueOf(String r2) {
        return (ContextAwarenessGlobalSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(ContextAwarenessGlobalSource.class, r2), ContextAwarenessGlobalSource.class, "com.obric.memorydata.plugin");
    }

    public static ContextAwarenessGlobalSource[] values() {
        return (ContextAwarenessGlobalSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContextAwarenessGlobalSource[].class, "com.obric.memorydata.plugin");
    }
}
