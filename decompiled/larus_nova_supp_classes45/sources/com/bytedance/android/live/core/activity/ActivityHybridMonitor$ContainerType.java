package com.bytedance.android.live.core.activity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/android/live/core/activity/ActivityHybridMonitor$ContainerType", "", "Lcom/bytedance/android/live/core/activity/ActivityHybridMonitor$ContainerType;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "WEB", "LYNX", "OTHER", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ActivityHybridMonitor$ContainerType extends Enum<ActivityHybridMonitor$ContainerType> {
    public static final ActivityHybridMonitor$ContainerType LYNX = null;
    public static final ActivityHybridMonitor$ContainerType OTHER = null;
    public static final ActivityHybridMonitor$ContainerType WEB = null;
    public static final /* synthetic */ ActivityHybridMonitor$ContainerType[] a = null;
    private final String type;

    static {
        ActivityHybridMonitor$ContainerType r1 = new ActivityHybridMonitor$ContainerType("WEB", 0, "web");
        WEB = r1;
        ActivityHybridMonitor$ContainerType r2 = new ActivityHybridMonitor$ContainerType("LYNX", 1, "lynx");
        LYNX = r2;
        ActivityHybridMonitor$ContainerType r3 = new ActivityHybridMonitor$ContainerType("OTHER", 2, "other");
        OTHER = r3;
        a = new ActivityHybridMonitor$ContainerType[]{r1, r2, r3};
    }

    public static ActivityHybridMonitor$ContainerType valueOf(String r1) {
        return (ActivityHybridMonitor$ContainerType) a.a(ActivityHybridMonitor$ContainerType.class, r1);
    }

    public static ActivityHybridMonitor$ContainerType[] values() {
        return (ActivityHybridMonitor$ContainerType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public ActivityHybridMonitor$ContainerType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
