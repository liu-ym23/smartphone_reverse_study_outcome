package org.ehcache.event;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum EventOrdering extends Enum<EventOrdering> {
    private static final /* synthetic */ EventOrdering[] $VALUES = null;
    public static final EventOrdering ORDERED = null;
    public static final EventOrdering UNORDERED = null;
    private final boolean ordered;

    static {
        EventOrdering r0 = new EventOrdering("UNORDERED", 0, false);
        UNORDERED = r0;
        EventOrdering r1 = new EventOrdering("ORDERED", 1, true);
        ORDERED = r1;
        $VALUES = new EventOrdering[]{r0, r1};
    }

    private EventOrdering(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.ordered = r3;
    }

    public static EventOrdering valueOf(String r2) {
        return (EventOrdering) ZeusTransformUtils.preCheckCast(Enum.valueOf(EventOrdering.class, r2), EventOrdering.class, "com.obric.memorydata.plugin");
    }

    public static EventOrdering[] values() {
        return (EventOrdering[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EventOrdering[].class, "com.obric.memorydata.plugin");
    }

    public boolean isOrdered() {
        return this.ordered;
    }
}
