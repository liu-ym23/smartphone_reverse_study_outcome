package com.bytedance.lego.init.model;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final enum DelayTime extends Enum<DelayTime> implements Serializable {
    private static final /* synthetic */ DelayTime[] $VALUES = null;
    public static final DelayTime MINUTE_10 = null;
    public static final DelayTime MINUTE_15 = null;
    public static final DelayTime MINUTE_2 = null;
    public static final DelayTime MINUTE_5 = null;
    public static final DelayTime SECOND_15 = null;
    public static final DelayTime SECOND_30 = null;
    public static final DelayTime SECOND_5 = null;
    public static final DelayTime SECOND_60 = null;
    public static final DelayTime SECOND_8 = null;
    private int value;

    static {
        DelayTime r0 = new DelayTime("SECOND_5", 0, 5000);
        SECOND_5 = r0;
        DelayTime r1 = new DelayTime("SECOND_8", 1, 8000);
        SECOND_8 = r1;
        DelayTime r3 = new DelayTime("SECOND_15", 2, 15000);
        SECOND_15 = r3;
        DelayTime r5 = new DelayTime("SECOND_30", 3, LocationInfoConst.HALF_MINUTES);
        SECOND_30 = r5;
        DelayTime r7 = new DelayTime("SECOND_60", 4, 60000);
        SECOND_60 = r7;
        DelayTime r9 = new DelayTime("MINUTE_2", 5, LocationInfoConst.TWO_MINUTES);
        MINUTE_2 = r9;
        DelayTime r11 = new DelayTime("MINUTE_5", 6, 300000);
        MINUTE_5 = r11;
        DelayTime r13 = new DelayTime("MINUTE_10", 7, 600000);
        MINUTE_10 = r13;
        DelayTime r12 = new DelayTime("MINUTE_15", 8, 900000);
        MINUTE_15 = r12;
        $VALUES = new DelayTime[]{r0, r1, r3, r5, r7, r9, r11, r13, r12};
    }

    private DelayTime(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static DelayTime from(int r0) {
        switch(r0) {
            case 5000: goto L22;
            case 8000: goto L20;
            case 15000: goto L18;
            case 30000: goto L16;
            case 60000: goto L14;
            case 120000: goto L12;
            case 300000: goto L10;
            case 600000: goto L8;
            case 900000: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return MINUTE_15;
    L8:
        return MINUTE_10;
    L10:
        return MINUTE_5;
    L12:
        return MINUTE_2;
    L14:
        return SECOND_60;
    L16:
        return SECOND_30;
    L18:
        return SECOND_15;
    L20:
        return SECOND_8;
    L22:
        return SECOND_5;
    }

    public static DelayTime valueOf(String r2) {
        return (DelayTime) ZeusTransformUtils.preCheckCast(Enum.valueOf(DelayTime.class, r2), DelayTime.class, "com.obric.memorydata.plugin");
    }

    public static DelayTime[] values() {
        return (DelayTime[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DelayTime[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
