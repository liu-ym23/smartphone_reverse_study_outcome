package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkmicAdjustPositionPingType;", "", "AdjustPositionPingType_UnKnown", "AdjustPositinoPingType_Continue", "AdjustPositionPingType_Cancel", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicAdjustPositionPingType extends Enum<LinkmicAdjustPositionPingType> {
    public static final LinkmicAdjustPositionPingType AdjustPositinoPingType_Continue = null;
    public static final LinkmicAdjustPositionPingType AdjustPositionPingType_Cancel = null;
    public static final LinkmicAdjustPositionPingType AdjustPositionPingType_UnKnown = null;
    public static final /* synthetic */ LinkmicAdjustPositionPingType[] a = null;

    static {
        LinkmicAdjustPositionPingType r1 = new LinkmicAdjustPositionPingType("AdjustPositionPingType_UnKnown", 0);
        AdjustPositionPingType_UnKnown = r1;
        LinkmicAdjustPositionPingType r2 = new LinkmicAdjustPositionPingType("AdjustPositinoPingType_Continue", 1);
        AdjustPositinoPingType_Continue = r2;
        LinkmicAdjustPositionPingType r3 = new LinkmicAdjustPositionPingType("AdjustPositionPingType_Cancel", 2);
        AdjustPositionPingType_Cancel = r3;
        a = new LinkmicAdjustPositionPingType[]{r1, r2, r3};
    }

    public static LinkmicAdjustPositionPingType valueOf(String r1) {
        return (LinkmicAdjustPositionPingType) r27.a.a(LinkmicAdjustPositionPingType.class, r1);
    }

    public static LinkmicAdjustPositionPingType[] values() {
        return (LinkmicAdjustPositionPingType[]) a.clone();
    }

    public LinkmicAdjustPositionPingType(String r1, int r2) {
        super(r1, r2);
    }
}
