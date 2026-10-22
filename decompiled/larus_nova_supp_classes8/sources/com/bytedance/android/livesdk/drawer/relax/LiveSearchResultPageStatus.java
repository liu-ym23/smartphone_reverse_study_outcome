package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveSearchResultPageStatus;", "", "", "value", "J", "getValue", "()J", "None", "Loading", "Result", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveSearchResultPageStatus extends Enum<LiveSearchResultPageStatus> {
    public static final LiveSearchResultPageStatus Loading = null;
    public static final LiveSearchResultPageStatus None = null;
    public static final LiveSearchResultPageStatus Result = null;
    public static final /* synthetic */ LiveSearchResultPageStatus[] a = null;
    private final long value;

    static {
        LiveSearchResultPageStatus r1 = new LiveSearchResultPageStatus("None", 0, 0);
        None = r1;
        LiveSearchResultPageStatus r2 = new LiveSearchResultPageStatus("Loading", 1, 1);
        Loading = r2;
        LiveSearchResultPageStatus r3 = new LiveSearchResultPageStatus("Result", 2, 2);
        Result = r3;
        a = new LiveSearchResultPageStatus[]{r1, r2, r3};
    }

    public static LiveSearchResultPageStatus valueOf(String r1) {
        return (LiveSearchResultPageStatus) r27.a.a(LiveSearchResultPageStatus.class, r1);
    }

    public static LiveSearchResultPageStatus[] values() {
        return (LiveSearchResultPageStatus[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public LiveSearchResultPageStatus(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
