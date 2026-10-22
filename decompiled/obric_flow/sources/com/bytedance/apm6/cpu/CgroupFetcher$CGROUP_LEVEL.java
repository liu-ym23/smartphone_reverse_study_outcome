package com.bytedance.apm6.cpu;

/* JADX INFO: loaded from: classes2.dex */
public final enum CgroupFetcher$CGROUP_LEVEL extends Enum<CgroupFetcher$CGROUP_LEVEL> {
    public static final CgroupFetcher$CGROUP_LEVEL BACKGROUND = null;
    public static final CgroupFetcher$CGROUP_LEVEL FOREGROUND = null;
    public static final CgroupFetcher$CGROUP_LEVEL TOP_APP = null;
    public static final CgroupFetcher$CGROUP_LEVEL UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CgroupFetcher$CGROUP_LEVEL[] f3921a = null;
    private final int value;

    static {
        CgroupFetcher$CGROUP_LEVEL r5 = new CgroupFetcher$CGROUP_LEVEL("UNKNOWN", 0, -1);
        UNKNOWN = r5;
        CgroupFetcher$CGROUP_LEVEL r10 = new CgroupFetcher$CGROUP_LEVEL("TOP_APP", 1, 0);
        TOP_APP = r10;
        CgroupFetcher$CGROUP_LEVEL r11 = new CgroupFetcher$CGROUP_LEVEL("FOREGROUND", 2, 1);
        FOREGROUND = r11;
        CgroupFetcher$CGROUP_LEVEL r12 = new CgroupFetcher$CGROUP_LEVEL("BACKGROUND", 3, 2);
        BACKGROUND = r12;
        f3921a = new CgroupFetcher$CGROUP_LEVEL[]{r5, r10, r11, r12};
    }

    public CgroupFetcher$CGROUP_LEVEL(String r5, int r10, int r11) {
        super(r5, r10);
        this.value = r11;
    }

    public static CgroupFetcher$CGROUP_LEVEL valueOf(String r5) {
        return (CgroupFetcher$CGROUP_LEVEL) Enum.valueOf(CgroupFetcher$CGROUP_LEVEL.class, r5);
    }

    public static CgroupFetcher$CGROUP_LEVEL[] values() {
        return (CgroupFetcher$CGROUP_LEVEL[]) f3921a.clone();
    }

    public static CgroupFetcher$CGROUP_LEVEL valueOf(int r5) {
        if (r5 == (-1)) goto L18;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L14;
        if (r5 == 2) goto L12;
        return UNKNOWN;
    L12:
        return BACKGROUND;
    L14:
        return FOREGROUND;
    L16:
        return TOP_APP;
    L18:
        return UNKNOWN;
    }
}
