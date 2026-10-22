package com.bytedance.applog.isolate;

import com.bytedance.crash.entity.Header;

/* JADX INFO: loaded from: classes.dex */
public final enum DataIsolateKey extends Enum<DataIsolateKey> {
    private static final /* synthetic */ DataIsolateKey[] $VALUES = null;
    public static final DataIsolateKey USER_ID = null;
    private final String key;

    static {
        DataIsolateKey r10 = new DataIsolateKey("USER_ID", 0, Header.KEY_USER_ID);
        USER_ID = r10;
        $VALUES = new DataIsolateKey[]{r10};
    }

    private DataIsolateKey(String r10, int r11, String r12) {
        super(r10, r11);
        this.key = r12;
    }

    public static DataIsolateKey fromKey(String r10) {
        DataIsolateKey[] r11 = values();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        DataIsolateKey r14 = r11[r13];
        if (r14.getKey().equals(r10) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L8:
        return null;
    }

    public static DataIsolateKey valueOf(String r10) {
        return (DataIsolateKey) Enum.valueOf(DataIsolateKey.class, r10);
    }

    public static DataIsolateKey[] values() {
        return (DataIsolateKey[]) $VALUES.clone();
    }

    public String getKey() {
        return this.key;
    }
}
