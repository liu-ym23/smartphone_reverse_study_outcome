package org.ehcache.xml.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/* JADX INFO: loaded from: classes7.dex */
@XmlEnum
@XmlType(name = "event-type")
public final enum EventType extends Enum<EventType> {
    private static final /* synthetic */ EventType[] $VALUES = null;
    public static final EventType CREATED = null;
    public static final EventType EVICTED = null;
    public static final EventType EXPIRED = null;
    public static final EventType REMOVED = null;
    public static final EventType UPDATED = null;

    static {
        EventType r0 = new EventType("EVICTED", 0);
        EVICTED = r0;
        EventType r1 = new EventType("EXPIRED", 1);
        EXPIRED = r1;
        EventType r3 = new EventType("REMOVED", 2);
        REMOVED = r3;
        EventType r5 = new EventType("CREATED", 3);
        CREATED = r5;
        EventType r7 = new EventType("UPDATED", 4);
        UPDATED = r7;
        $VALUES = new EventType[]{r0, r1, r3, r5, r7};
    }

    private EventType(String r1, int r2) {
        super(r1, r2);
    }

    public static EventType fromValue(String r0) {
        return valueOf(r0);
    }

    public static EventType valueOf(String r2) {
        return (EventType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EventType.class, r2), EventType.class, "com.obric.memorydata.plugin");
    }

    public static EventType[] values() {
        return (EventType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EventType[].class, "com.obric.memorydata.plugin");
    }

    public String value() {
        return name();
    }
}
