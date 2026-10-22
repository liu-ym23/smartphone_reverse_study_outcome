package com.lynx.animax;

import android.content.Context;
import com.lynx.animax.base.CalledByNative;
import com.lynx.animax.util.AnimaX;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.utils.k;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class AnimaXResourceLoader {
    @CalledByNative
    public static String getCacheDirectory() {
        Context r5 = AnimaX.a().f9712c;
        if (r5 != null) goto L5;
        return null;
    L5:
        File r10 = r5.getCacheDir();
        if (r10 != null) goto L8;
        return null;
    L8:
        String r11 = r10.getAbsolutePath();
        if (r11 != null) goto L11;
        return null;
    L11:
        File r12 = new File(r11, "animax");
        if (r12.exists() == true) goto L17;
        if (r12.mkdirs() == true) goto L17;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXResourceLoader", "Failed to make animax cache directory: " + r12.getAbsolutePath());
    L17:
        if (r12.exists() == false) goto L22;
        if (r12.isFile() == false) goto L22;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXResourceLoader", "Failed to make animax cache directory, path is a file: " + r12.getAbsolutePath());
    L22:
        return r12.getAbsolutePath();
    }

    @CalledByNative
    public static byte[] readFile(String r5) {
        if (r5 != null) goto L6;
    L7:
        FileInputStream r10 = null;
    L19:
        int r11 = r10.available();     // Catch: IOException -> L14
    L15:
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();
        if (k.n(r10, r12, r11) == true) goto L18;
        return null;
    L18:
        return r12.toByteArray();
    L14:
        r11 = 0;
        goto L15
    L6:
        if (new File(r5).exists() == false) goto L7;
        r10 = new FileInputStream(r5);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXStreamUtil", "createFileInputStream error: " + e);
        goto L7
    }

    @CalledByNative
    public static boolean saveByteArrayIntoFile(String r5, byte[] r10) {
        ByteArrayInputStream r11 = new ByteArrayInputStream(r10);
        int r12 = r11.available();     // Catch: IOException -> L5
    L13:
        BufferedOutputStream r13 = new BufferedOutputStream(new FileOutputStream(r5));     // Catch: IOException -> L8
    L10:
        return k.n(r11, r13, r12);
    L8:
        String r14 = td.d.b("Failed to create FileOutputStream for file: ", r5);
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXStreamUtil", r14);
        r13 = null;
    L5:
        r12 = 0;
        goto L13
    }
}
