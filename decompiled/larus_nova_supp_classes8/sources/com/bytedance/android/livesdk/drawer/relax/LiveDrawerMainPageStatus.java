package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerMainPageStatus;", "", "", "value", "I", "getValue", "()I", "Loading", "Ready", "FetchFail", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerMainPageStatus extends Enum<LiveDrawerMainPageStatus> {
    public static final LiveDrawerMainPageStatus FetchFail = null;
    public static final LiveDrawerMainPageStatus Loading = null;
    public static final LiveDrawerMainPageStatus Ready = null;
    public static final /* synthetic */ LiveDrawerMainPageStatus[] a = null;
    private final int value;

    static {
        LiveDrawerMainPageStatus r1 = new LiveDrawerMainPageStatus("Loading", 0, 0);
        Loading = r1;
        LiveDrawerMainPageStatus r2 = new LiveDrawerMainPageStatus("Ready", 1, 1);
        Ready = r2;
        LiveDrawerMainPageStatus r3 = new LiveDrawerMainPageStatus("FetchFail", 2, 2);
        FetchFail = r3;
        a = new LiveDrawerMainPageStatus[]{r1, r2, r3};
    }

    public static LiveDrawerMainPageStatus valueOf(String r1) {
        return (LiveDrawerMainPageStatus) r27.a.a(LiveDrawerMainPageStatus.class, r1);
    }

    public static LiveDrawerMainPageStatus[] values() {
        return (LiveDrawerMainPageStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveDrawerMainPageStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
