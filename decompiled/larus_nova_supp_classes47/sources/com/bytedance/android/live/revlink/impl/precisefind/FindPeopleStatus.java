package com.bytedance.android.live.revlink.impl.precisefind;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/precisefind/FindPeopleStatus;", "", "UNKNOWN", "SELECT", "INVITE", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FindPeopleStatus extends Enum<FindPeopleStatus> {
    public static final FindPeopleStatus INVITE = null;
    public static final FindPeopleStatus SELECT = null;
    public static final FindPeopleStatus UNKNOWN = null;
    public static final /* synthetic */ FindPeopleStatus[] a = null;

    static {
        FindPeopleStatus r1 = new FindPeopleStatus("UNKNOWN", 0);
        UNKNOWN = r1;
        FindPeopleStatus r2 = new FindPeopleStatus("SELECT", 1);
        SELECT = r2;
        FindPeopleStatus r3 = new FindPeopleStatus("INVITE", 2);
        INVITE = r3;
        a = new FindPeopleStatus[]{r1, r2, r3};
    }

    public static FindPeopleStatus valueOf(String r1) {
        return (FindPeopleStatus) r27.a.a(FindPeopleStatus.class, r1);
    }

    public static FindPeopleStatus[] values() {
        return (FindPeopleStatus[]) a.clone();
    }

    public FindPeopleStatus(String r1, int r2) {
        super(r1, r2);
    }
}
