package com.bytedance.android.live.initialize;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/initialize/WTOThreadWorkType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "CPU_FIXED", "IO", "TIME_CLOCK", "live-initialize-annotation_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WTOThreadWorkType extends Enum<WTOThreadWorkType> {
    public static final WTOThreadWorkType CPU_FIXED = null;
    public static final WTOThreadWorkType IO = null;
    public static final WTOThreadWorkType TIME_CLOCK = null;
    public static final /* synthetic */ WTOThreadWorkType[] a = null;
    private final String tag;

    static {
        WTOThreadWorkType r1 = new WTOThreadWorkType("CPU_FIXED", 0, "CPU_FIXED");
        CPU_FIXED = r1;
        WTOThreadWorkType r2 = new WTOThreadWorkType("IO", 1, "IO");
        IO = r2;
        WTOThreadWorkType r3 = new WTOThreadWorkType("TIME_CLOCK", 2, "TIME_CLOCK");
        TIME_CLOCK = r3;
        a = new WTOThreadWorkType[]{r1, r2, r3};
    }

    public static WTOThreadWorkType valueOf(String r1) {
        return (WTOThreadWorkType) r27.a.a(WTOThreadWorkType.class, r1);
    }

    public static WTOThreadWorkType[] values() {
        return (WTOThreadWorkType[]) a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public WTOThreadWorkType(String r1, int r2, String r3) {
        super(r1, r2);
        this.tag = r3;
    }
}
