package org.ehcache.event;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum EventFiring extends Enum<EventFiring> {
    private static final /* synthetic */ EventFiring[] $VALUES = null;
    public static final EventFiring ASYNCHRONOUS = null;
    public static final EventFiring SYNCHRONOUS = null;

    static {
        EventFiring r0 = new EventFiring("ASYNCHRONOUS", 0);
        ASYNCHRONOUS = r0;
        EventFiring r1 = new EventFiring("SYNCHRONOUS", 1);
        SYNCHRONOUS = r1;
        $VALUES = new EventFiring[]{r0, r1};
    }

    private EventFiring(String r1, int r2) {
        super(r1, r2);
    }

    public static EventFiring valueOf(String r2) {
        return (EventFiring) ZeusTransformUtils.preCheckCast(Enum.valueOf(EventFiring.class, r2), EventFiring.class, "com.obric.memorydata.plugin");
    }

    public static EventFiring[] values() {
        return (EventFiring[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EventFiring[].class, "com.obric.memorydata.plugin");
    }
}
