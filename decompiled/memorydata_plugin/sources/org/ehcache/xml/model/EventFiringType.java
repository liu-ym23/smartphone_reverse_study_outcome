package org.ehcache.xml.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/* JADX INFO: loaded from: classes7.dex */
@XmlEnum
@XmlType(name = "event-firing-type")
public final enum EventFiringType extends Enum<EventFiringType> {
    private static final /* synthetic */ EventFiringType[] $VALUES = null;
    public static final EventFiringType ASYNCHRONOUS = null;
    public static final EventFiringType SYNCHRONOUS = null;

    static {
        EventFiringType r0 = new EventFiringType("ASYNCHRONOUS", 0);
        ASYNCHRONOUS = r0;
        EventFiringType r1 = new EventFiringType("SYNCHRONOUS", 1);
        SYNCHRONOUS = r1;
        $VALUES = new EventFiringType[]{r0, r1};
    }

    private EventFiringType(String r1, int r2) {
        super(r1, r2);
    }

    public static EventFiringType fromValue(String r0) {
        return valueOf(r0);
    }

    public static EventFiringType valueOf(String r2) {
        return (EventFiringType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EventFiringType.class, r2), EventFiringType.class, "com.obric.memorydata.plugin");
    }

    public static EventFiringType[] values() {
        return (EventFiringType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EventFiringType[].class, "com.obric.memorydata.plugin");
    }

    public String value() {
        return name();
    }
}
