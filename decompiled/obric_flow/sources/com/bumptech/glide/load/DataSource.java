package com.bumptech.glide.load;

/* JADX INFO: loaded from: classes.dex */
public final enum DataSource extends Enum<DataSource> {
    public static final DataSource DATA_DISK_CACHE = null;
    public static final DataSource LOCAL = null;
    public static final DataSource MEMORY_CACHE = null;
    public static final DataSource REMOTE = null;
    public static final DataSource RESOURCE_DISK_CACHE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataSource[] f1414a = null;

    static {
        DataSource r5 = new DataSource("LOCAL", 0);
        LOCAL = r5;
        DataSource r10 = new DataSource("REMOTE", 1);
        REMOTE = r10;
        DataSource r11 = new DataSource("DATA_DISK_CACHE", 2);
        DATA_DISK_CACHE = r11;
        DataSource r12 = new DataSource("RESOURCE_DISK_CACHE", 3);
        RESOURCE_DISK_CACHE = r12;
        DataSource r13 = new DataSource("MEMORY_CACHE", 4);
        MEMORY_CACHE = r13;
        f1414a = new DataSource[]{r5, r10, r11, r12, r13};
    }

    public static DataSource valueOf(String r5) {
        return (DataSource) Enum.valueOf(DataSource.class, r5);
    }

    public static DataSource[] values() {
        return (DataSource[]) f1414a.clone();
    }
}
