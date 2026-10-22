package com.bytedance.android.live.liveinteract.revenue.adventure.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/adventure/model/AdventureUpdateType;", "", "UPDATE", "JOIN_RTC_ROOM", "LEAVE_RTC_ROOM", "CHECK_RTC_ROOM", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AdventureUpdateType extends Enum<AdventureUpdateType> {
    public static final AdventureUpdateType CHECK_RTC_ROOM = null;
    public static final AdventureUpdateType JOIN_RTC_ROOM = null;
    public static final AdventureUpdateType LEAVE_RTC_ROOM = null;
    public static final AdventureUpdateType UPDATE = null;
    public static final /* synthetic */ AdventureUpdateType[] a = null;

    static {
        AdventureUpdateType r1 = new AdventureUpdateType("UPDATE", 0);
        UPDATE = r1;
        AdventureUpdateType r2 = new AdventureUpdateType("JOIN_RTC_ROOM", 1);
        JOIN_RTC_ROOM = r2;
        AdventureUpdateType r3 = new AdventureUpdateType("LEAVE_RTC_ROOM", 2);
        LEAVE_RTC_ROOM = r3;
        AdventureUpdateType r4 = new AdventureUpdateType("CHECK_RTC_ROOM", 3);
        CHECK_RTC_ROOM = r4;
        a = new AdventureUpdateType[]{r1, r2, r3, r4};
    }

    public static AdventureUpdateType valueOf(String r1) {
        return (AdventureUpdateType) a.a(AdventureUpdateType.class, r1);
    }

    public static AdventureUpdateType[] values() {
        return (AdventureUpdateType[]) a.clone();
    }

    public AdventureUpdateType(String r1, int r2) {
        super(r1, r2);
    }
}
