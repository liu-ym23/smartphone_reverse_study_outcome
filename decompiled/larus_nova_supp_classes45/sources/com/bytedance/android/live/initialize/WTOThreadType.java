package com.bytedance.android.live.initialize;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/initialize/WTOThreadType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "UIThread", "PeriodThread", "WorkerThread", "live-initialize-annotation_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WTOThreadType extends Enum<WTOThreadType> {
    public static final WTOThreadType PeriodThread = null;
    public static final WTOThreadType UIThread = null;
    public static final WTOThreadType WorkerThread = null;
    public static final /* synthetic */ WTOThreadType[] a = null;
    private final String tag;

    static {
        WTOThreadType r1 = new WTOThreadType("UIThread", 0, "UIThread");
        UIThread = r1;
        WTOThreadType r2 = new WTOThreadType("PeriodThread", 1, "PeriodThread");
        PeriodThread = r2;
        WTOThreadType r3 = new WTOThreadType("WorkerThread", 2, "WorkThread");
        WorkerThread = r3;
        a = new WTOThreadType[]{r1, r2, r3};
    }

    public static WTOThreadType valueOf(String r1) {
        return (WTOThreadType) r27.a.a(WTOThreadType.class, r1);
    }

    public static WTOThreadType[] values() {
        return (WTOThreadType[]) a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public WTOThreadType(String r1, int r2, String r3) {
        super(r1, r2);
        this.tag = r3;
    }
}
