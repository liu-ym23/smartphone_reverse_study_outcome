package com.bytedance.monitor.util.thread;

/* JADX INFO: loaded from: classes2.dex */
public final enum AsyncTaskType extends Enum<AsyncTaskType> {
    public static final AsyncTaskType IO = null;
    public static final AsyncTaskType LIGHT_WEIGHT = null;
    public static final AsyncTaskType TIME_SENSITIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsyncTaskType[] f6948a = null;

    static {
        AsyncTaskType r5 = new AsyncTaskType("IO", 0);
        IO = r5;
        AsyncTaskType r10 = new AsyncTaskType("TIME_SENSITIVE", 1);
        TIME_SENSITIVE = r10;
        AsyncTaskType r11 = new AsyncTaskType("LIGHT_WEIGHT", 2);
        LIGHT_WEIGHT = r11;
        f6948a = new AsyncTaskType[]{r5, r10, r11};
    }

    public static AsyncTaskType valueOf(String r5) {
        return (AsyncTaskType) Enum.valueOf(AsyncTaskType.class, r5);
    }

    public static AsyncTaskType[] values() {
        return (AsyncTaskType[]) f6948a.clone();
    }
}
