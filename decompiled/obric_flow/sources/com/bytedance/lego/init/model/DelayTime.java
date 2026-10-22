package com.bytedance.lego.init.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final enum DelayTime extends Enum<DelayTime> implements Serializable {
    public static final DelayTime MINUTE_10 = null;
    public static final DelayTime MINUTE_15 = null;
    public static final DelayTime MINUTE_2 = null;
    public static final DelayTime MINUTE_5 = null;
    public static final DelayTime SECOND_15 = null;
    public static final DelayTime SECOND_3 = null;
    public static final DelayTime SECOND_30 = null;
    public static final DelayTime SECOND_5 = null;
    public static final DelayTime SECOND_60 = null;
    public static final DelayTime SECOND_8 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DelayTime[] f6752a = null;
    private int value;

    static {
        DelayTime r5 = new DelayTime("SECOND_3", 0, 5000);
        SECOND_3 = r5;
        DelayTime r10 = new DelayTime("SECOND_5", 1, 5000);
        SECOND_5 = r10;
        DelayTime r11 = new DelayTime("SECOND_8", 2, 8000);
        SECOND_8 = r11;
        DelayTime r12 = new DelayTime("SECOND_15", 3, 15000);
        SECOND_15 = r12;
        DelayTime r13 = new DelayTime("SECOND_30", 4, 30000);
        SECOND_30 = r13;
        DelayTime r14 = new DelayTime("SECOND_60", 5, 60000);
        SECOND_60 = r14;
        DelayTime r15 = new DelayTime("MINUTE_2", 6, 120000);
        MINUTE_2 = r15;
        DelayTime r16 = new DelayTime("MINUTE_5", 7, 300000);
        MINUTE_5 = r16;
        DelayTime r17 = new DelayTime("MINUTE_10", 8, 600000);
        MINUTE_10 = r17;
        DelayTime r18 = new DelayTime("MINUTE_15", 9, 900000);
        MINUTE_15 = r18;
        f6752a = new DelayTime[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    public DelayTime(String r5, int r10, int r11) {
        super(r5, r10);
        this.value = r11;
    }

    public static DelayTime from(int r5) {
        switch(r5) {
            case 3000: goto L24;
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
    L24:
        return SECOND_3;
    }

    public static DelayTime valueOf(String r5) {
        return (DelayTime) Enum.valueOf(DelayTime.class, r5);
    }

    public static DelayTime[] values() {
        return (DelayTime[]) f6752a.clone();
    }

    public int getValue() {
        return this.value;
    }
}
