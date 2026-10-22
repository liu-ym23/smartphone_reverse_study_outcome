package org.ehcache.xml.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/* JADX INFO: loaded from: classes7.dex */
@XmlEnum
@XmlType(name = "event-ordering-type")
public final enum EventOrderingType extends Enum<EventOrderingType> {
    private static final /* synthetic */ EventOrderingType[] $VALUES = null;
    public static final EventOrderingType ORDERED = null;
    public static final EventOrderingType UNORDERED = null;

    static {
        EventOrderingType r0 = new EventOrderingType("UNORDERED", 0);
        UNORDERED = r0;
        EventOrderingType r1 = new EventOrderingType("ORDERED", 1);
        ORDERED = r1;
        $VALUES = new EventOrderingType[]{r0, r1};
    }

    private EventOrderingType(String r1, int r2) {
        super(r1, r2);
    }

    public static EventOrderingType fromValue(String r0) {
        return valueOf(r0);
    }

    public static EventOrderingType valueOf(String r2) {
        return (EventOrderingType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EventOrderingType.class, r2), EventOrderingType.class, "com.obric.memorydata.plugin");
    }

    public static EventOrderingType[] values() {
        return (EventOrderingType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EventOrderingType[].class, "com.obric.memorydata.plugin");
    }

    public String value() {
        return name();
    }
}
