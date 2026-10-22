package com.bytedance.android.live.profile.event;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/profile/event/SpreadStateType;", "", "Close", "Open", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SpreadStateType extends Enum<SpreadStateType> {
    public static final SpreadStateType Close = null;
    public static final SpreadStateType Open = null;
    public static final /* synthetic */ SpreadStateType[] a = null;

    static {
        SpreadStateType r1 = new SpreadStateType("Close", 0);
        Close = r1;
        SpreadStateType r2 = new SpreadStateType("Open", 1);
        Open = r2;
        a = new SpreadStateType[]{r1, r2};
    }

    public static SpreadStateType valueOf(String r1) {
        return (SpreadStateType) r27.a.a(SpreadStateType.class, r1);
    }

    public static SpreadStateType[] values() {
        return (SpreadStateType[]) a.clone();
    }

    public SpreadStateType(String r1, int r2) {
        super(r1, r2);
    }
}
