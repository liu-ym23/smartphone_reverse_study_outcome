package com.lynx.devtool.helper;

import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.obric.aivoice.core.data.NameKeys;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class TestbenchFileUtil {
    private static final int READ_BUFFER = 4096;

    public TestbenchFileUtil() {
    }

    public static String getBase64StringFile(String r6) {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        PolarisFileInputStreamWrapper r2 = new PolarisFileInputStreamWrapper(r6);     // Catch: IOException -> L10 FileNotFoundException -> L13
        byte[] r7 = new byte[READ_BUFFER];     // Catch: IOException -> L10 FileNotFoundException -> L13
    L4:
        int r3 = r2.read(r7);     // Catch: IOException -> L10 FileNotFoundException -> L13
        if (r3 == (-1)) goto L9;
        r1.write(r7, 0, r3);     // Catch: IOException -> L10 FileNotFoundException -> L13
    L9:
        return Base64.encodeToString(r1.toByteArray(), 0);
    L13:
        e = move-exception;
        e.printStackTrace();
        return NameKeys.UnloadStrategy_No_Strategy;
    L10:
        e = move-exception;
        e.printStackTrace();
        return NameKeys.UnloadStrategy_No_Strategy;
    }
}
