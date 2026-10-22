package com.bytedance.applog.isolate;

import com.bytedance.crash.entity.Header;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum DataIsolateKey extends Enum<DataIsolateKey> {
    private static final /* synthetic */ DataIsolateKey[] $VALUES = null;
    public static final DataIsolateKey USER_ID = null;
    private final String key;

    static {
        DataIsolateKey r0 = new DataIsolateKey("USER_ID", 0, Header.KEY_USER_ID);
        USER_ID = r0;
        $VALUES = new DataIsolateKey[]{r0};
    }

    private DataIsolateKey(String r1, int r2, String r3) {
        super(r1, r2);
        this.key = r3;
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

    public static DataIsolateKey valueOf(String r2) {
        return (DataIsolateKey) ZeusTransformUtils.preCheckCast(Enum.valueOf(DataIsolateKey.class, r2), DataIsolateKey.class, "com.obric.memorydata.plugin");
    }

    public static DataIsolateKey[] values() {
        return (DataIsolateKey[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DataIsolateKey[].class, "com.obric.memorydata.plugin");
    }

    public String getKey() {
        return this.key;
    }
}
