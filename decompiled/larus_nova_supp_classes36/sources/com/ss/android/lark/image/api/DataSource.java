package com.ss.android.lark.image.api;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum DataSource extends Enum<DataSource> {
    public static final DataSource DATA_DISK_CACHE = null;
    public static final DataSource LOCAL = null;
    public static final DataSource MEMORY_CACHE = null;
    public static final DataSource REMOTE = null;
    public static final DataSource RESOURCE_DISK_CACHE = null;
    public static final /* synthetic */ DataSource[] a = null;

    static {
        DataSource r0 = new DataSource("LOCAL", 0);
        LOCAL = r0;
        DataSource r1 = new DataSource("REMOTE", 1);
        REMOTE = r1;
        DataSource r3 = new DataSource("DATA_DISK_CACHE", 2);
        DATA_DISK_CACHE = r3;
        DataSource r5 = new DataSource("RESOURCE_DISK_CACHE", 3);
        RESOURCE_DISK_CACHE = r5;
        DataSource r7 = new DataSource("MEMORY_CACHE", 4);
        MEMORY_CACHE = r7;
        a = new DataSource[]{r0, r1, r3, r5, r7};
    }

    public static DataSource[] values() {
        return (DataSource[]) a.clone();
    }

    public static DataSource fromOrdinal(int r5) {
        DataSource[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        DataSource r3 = r0[r2];
        if (r3.ordinal() == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return LOCAL;
    }

    public static DataSource valueOf(String r1) {
        return (DataSource) a.a(DataSource.class, r1);
    }

    public DataSource(String r1, int r2) {
        super(r1, r2);
    }
}
