package com.bytedance.applog.isolate;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum DataIsolateKey extends Enum<DataIsolateKey> {
    public static final DataIsolateKey USER_ID = null;
    public static final /* synthetic */ DataIsolateKey[] a = null;
    private final String key;

    static {
        DataIsolateKey r0 = new DataIsolateKey();
        USER_ID = r0;
        a = new DataIsolateKey[]{r0};
    }

    public DataIsolateKey() {
        super("USER_ID", 0);
        this.key = "user_id";
    }

    public static DataIsolateKey[] values() {
        return (DataIsolateKey[]) a.clone();
    }

    public String getKey() {
        return this.key;
    }

    public static DataIsolateKey fromKey(String r5) {
        DataIsolateKey[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        DataIsolateKey r3 = r0[r2];
        if (r3.getKey().equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static DataIsolateKey valueOf(String r1) {
        return (DataIsolateKey) a.a(DataIsolateKey.class, r1);
    }
}
