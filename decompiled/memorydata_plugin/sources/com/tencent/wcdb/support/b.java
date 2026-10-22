package com.tencent.wcdb.support;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ss.bduploader.BDNetworkSpeedTest;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.tencent.wcdb.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    static {
        SQLiteGlobal.a();
    }

    public static SQLiteDatabase a(Context r11, String r12, byte[] r13, SQLiteCipherSpec r14, int r15, SQLiteDatabase.a r16, g r17, int r18) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        SQLiteDatabase.a r7 = (SQLiteDatabase.a) ZeusTransformUtils.wrapperContextForParams(r16, SQLiteDatabase.a.class, "com.obric.memorydata.plugin");
        g r9 = (g) ZeusTransformUtils.wrapperContextForParams(r17, g.class, "com.obric.memorydata.plugin");
        File r2 = a(r1, r12, true);
        if ((r15 & 8) == 0) goto L5;
        int r3 = 805306368;
    L6:
        String r4 = r2.getPath();
        SQLiteDatabase r5 = SQLiteDatabase.a(r4, r13, r14, r7, r3, r9, r18);
        a(r2.getPath(), r15, 0);
        return r5;
    L5:
        r3 = net.zetetic.database.sqlcipher.SQLiteDatabase.CREATE_IF_NECESSARY;
        goto L6
    }

    private static File a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L10;
        String r4 = r3.getApplicationInfo().dataDir;
        if (r4 != null) goto L11;
        return null;
    L11:
        return new File(r4);
    L10:
        throw new RuntimeException("Not supported in system context");
    }

    private static File a(Context r3, String r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4.charAt(0) != File.separatorChar) goto L5;
        File r0 = new File(r4.substring(0, r4.lastIndexOf(File.separatorChar)));
        File r7 = new File(r0, r4.substring(r4.lastIndexOf(File.separatorChar)));
    L6:
        if (r5 == true) goto L8;
    L12:
        return r7;
    L8:
        if (r0.isDirectory() == true) goto L12;
        if (r0.mkdir() == false) goto L12;
        FileUtils.setPermissions(r0.getPath(), TypedValues.PositionType.TYPE_SIZE_PERCENT, -1, -1);
        goto L12
    L5:
        r0 = b(r6);
        r7 = a(r0, r4);
        goto L6
    }

    private static File a(File r2, String r3) {
        if (r3.indexOf(File.separatorChar) >= 0) goto L7;
        return new File(r2, r3);
    L7:
        throw new IllegalArgumentException("File " + r3 + " contains a path separator");
    }

    private static void a(String r1, int r2, int r3) {
        int r4 = r3 | BDNetworkSpeedTest.KeyIsIntelligentTestResult;
        if ((r2 & 1) == 0) goto L6;
        r4 = r4 | 4;
    L6:
        if ((r2 & 2) == 0) goto L8;
        r4 = r4 | 2;
    L8:
        FileUtils.setPermissions(r1, r4, -1, -1);
    }

    private static File b(Context r2) {
        File r0 = new File(a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")), "databases");
        if (r0.getPath().equals("databases") == true) goto L5;
        return r0;
    L5:
        return new File("/data/system");
    }
}
