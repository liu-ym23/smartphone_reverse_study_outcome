package com.obric.memorydata.memory.ui.list.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineSource;", "", "rank", "", "stablePrefix", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getRank", "()I", "getStablePrefix", "()Ljava/lang/String;", "SCREEN_CONTENT", "AMBIENT_AUDIO", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ContextAwarenessTimelineSource extends Enum<ContextAwarenessTimelineSource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ContextAwarenessTimelineSource[] $VALUES = null;
    public static final ContextAwarenessTimelineSource AMBIENT_AUDIO = null;
    public static final ContextAwarenessTimelineSource SCREEN_CONTENT = null;
    private final int rank;
    private final String stablePrefix;

    private static final /* synthetic */ ContextAwarenessTimelineSource[] $values() {
        return new ContextAwarenessTimelineSource[]{SCREEN_CONTENT, AMBIENT_AUDIO};
    }

    static {
        SCREEN_CONTENT = new ContextAwarenessTimelineSource("SCREEN_CONTENT", 0, 0, "screen");
        AMBIENT_AUDIO = new ContextAwarenessTimelineSource("AMBIENT_AUDIO", 1, 1, "audio");
        ContextAwarenessTimelineSource[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ContextAwarenessTimelineSource(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.rank = r3;
        this.stablePrefix = r4;
    }

    public static EnumEntries<ContextAwarenessTimelineSource> getEntries() {
        return $ENTRIES;
    }

    public static ContextAwarenessTimelineSource valueOf(String r2) {
        return (ContextAwarenessTimelineSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(ContextAwarenessTimelineSource.class, r2), ContextAwarenessTimelineSource.class, "com.obric.memorydata.plugin");
    }

    public static ContextAwarenessTimelineSource[] values() {
        return (ContextAwarenessTimelineSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContextAwarenessTimelineSource[].class, "com.obric.memorydata.plugin");
    }

    public final int getRank() {
        return this.rank;
    }

    public final String getStablePrefix() {
        return this.stablePrefix;
    }
}
