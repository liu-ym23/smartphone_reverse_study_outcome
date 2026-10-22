package com.bytedance.android.live.liveinteract.plantform.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/WaitingListType;", "", "UNKNOWN", "NORMAL", "PAID", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum WaitingListType extends Enum<WaitingListType> {
    public static final WaitingListType NORMAL = null;
    public static final WaitingListType PAID = null;
    public static final WaitingListType UNKNOWN = null;
    public static final /* synthetic */ WaitingListType[] a = null;

    static {
        WaitingListType r1 = new WaitingListType("UNKNOWN", 0);
        UNKNOWN = r1;
        WaitingListType r2 = new WaitingListType("NORMAL", 1);
        NORMAL = r2;
        WaitingListType r3 = new WaitingListType("PAID", 2);
        PAID = r3;
        a = new WaitingListType[]{r1, r2, r3};
    }

    public static WaitingListType valueOf(String r1) {
        return (WaitingListType) r27.a.a(WaitingListType.class, r1);
    }

    public static WaitingListType[] values() {
        return (WaitingListType[]) a.clone();
    }

    public WaitingListType(String r1, int r2) {
        super(r1, r2);
    }
}
