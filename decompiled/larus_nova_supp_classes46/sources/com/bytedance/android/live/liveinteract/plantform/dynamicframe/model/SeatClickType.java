package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/SeatClickType;", "", "", "type", "I", "getType", "()I", "GuestItem", "EmptyItem", "Fanticket", "SpecialItem", "FantiketThank", "FastInviteFriend", "SelfDisciplineRecord", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SeatClickType extends Enum<SeatClickType> {
    public static final SeatClickType EmptyItem = null;
    public static final SeatClickType Fanticket = null;
    public static final SeatClickType FantiketThank = null;
    public static final SeatClickType FastInviteFriend = null;
    public static final SeatClickType GuestItem = null;
    public static final SeatClickType SelfDisciplineRecord = null;
    public static final SeatClickType SpecialItem = null;
    public static final /* synthetic */ SeatClickType[] a = null;
    private final int type;

    static {
        SeatClickType r1 = new SeatClickType("GuestItem", 0, 0);
        GuestItem = r1;
        SeatClickType r2 = new SeatClickType("EmptyItem", 1, 1);
        EmptyItem = r2;
        SeatClickType r3 = new SeatClickType("Fanticket", 2, 2);
        Fanticket = r3;
        SeatClickType r4 = new SeatClickType("SpecialItem", 3, 3);
        SpecialItem = r4;
        SeatClickType r5 = new SeatClickType("FantiketThank", 4, 4);
        FantiketThank = r5;
        SeatClickType r6 = new SeatClickType("FastInviteFriend", 5, 5);
        FastInviteFriend = r6;
        SeatClickType r7 = new SeatClickType("SelfDisciplineRecord", 6, 6);
        SelfDisciplineRecord = r7;
        a = new SeatClickType[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static SeatClickType valueOf(String r1) {
        return (SeatClickType) a.a(SeatClickType.class, r1);
    }

    public static SeatClickType[] values() {
        return (SeatClickType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public SeatClickType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
