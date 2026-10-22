package com.tencent.wcdb.repair;

/* JADX INFO: loaded from: classes6.dex */
public class DBDumpUtil {
    public DBDumpUtil() {
    }

    private static native boolean nativeDumpDB(String r0, String r1, String r2);

    private static native boolean nativeIsSqlComplete(String r0);
}
