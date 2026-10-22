package com.bytedance.apm6.util.timetask;

/* JADX INFO: loaded from: classes2.dex */
public final enum AsyncTaskManagerType extends Enum<AsyncTaskManagerType> {
    public static final AsyncTaskManagerType CPU = null;
    public static final AsyncTaskManagerType IO = null;
    public static final AsyncTaskManagerType LIGHT_WEIGHT = null;
    public static final AsyncTaskManagerType TIME_SENSITIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsyncTaskManagerType[] f3924a = null;

    static {
        AsyncTaskManagerType r5 = new AsyncTaskManagerType("IO", 0);
        IO = r5;
        AsyncTaskManagerType r10 = new AsyncTaskManagerType("LIGHT_WEIGHT", 1);
        LIGHT_WEIGHT = r10;
        AsyncTaskManagerType r11 = new AsyncTaskManagerType("TIME_SENSITIVE", 2);
        TIME_SENSITIVE = r11;
        AsyncTaskManagerType r12 = new AsyncTaskManagerType("CPU", 3);
        CPU = r12;
        f3924a = new AsyncTaskManagerType[]{r5, r10, r11, r12};
    }

    public static AsyncTaskManagerType valueOf(String r5) {
        return (AsyncTaskManagerType) Enum.valueOf(AsyncTaskManagerType.class, r5);
    }

    public static AsyncTaskManagerType[] values() {
        return (AsyncTaskManagerType[]) f3924a.clone();
    }
}
