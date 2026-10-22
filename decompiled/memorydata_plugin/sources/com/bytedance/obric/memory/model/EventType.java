package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum EventType extends Enum<EventType> {
    private static final /* synthetic */ EventType[] $VALUES = null;

    @SerializedName("3")
    public static final EventType ArriveCompany = null;

    @SerializedName("1")
    public static final EventType ArriveHome = null;

    @SerializedName("5")
    public static final EventType BeginRecommend = null;

    @SerializedName("6")
    public static final EventType EvaluationRecommend = null;

    @SerializedName("4")
    public static final EventType LeaveCompany = null;

    @SerializedName("2")
    public static final EventType LeaveHome = null;
    private final int value;

    static {
        EventType r0 = new EventType("ArriveHome", 0, 1);
        ArriveHome = r0;
        EventType r1 = new EventType("LeaveHome", 1, 2);
        LeaveHome = r1;
        EventType r4 = new EventType("ArriveCompany", 2, 3);
        ArriveCompany = r4;
        EventType r6 = new EventType("LeaveCompany", 3, 4);
        LeaveCompany = r6;
        EventType r8 = new EventType("BeginRecommend", 4, 5);
        BeginRecommend = r8;
        EventType r10 = new EventType("EvaluationRecommend", 5, 6);
        EvaluationRecommend = r10;
        $VALUES = new EventType[]{r0, r1, r4, r6, r8, r10};
    }

    private EventType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EventType findByValue(int r0) {
        switch(r0) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return EvaluationRecommend;
    L8:
        return BeginRecommend;
    L10:
        return LeaveCompany;
    L12:
        return ArriveCompany;
    L14:
        return LeaveHome;
    L16:
        return ArriveHome;
    }

    public static EventType valueOf(String r2) {
        return (EventType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EventType.class, r2), EventType.class, "com.obric.memorydata.plugin");
    }

    public static EventType[] values() {
        return (EventType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EventType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
