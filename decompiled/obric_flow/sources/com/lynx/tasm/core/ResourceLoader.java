package com.lynx.tasm.core;

import android.text.TextUtils;
import androidx.versionedparcelable.VersionedParcel;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.CalledByNative;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ResourceLoader {
    public static byte[] a(String r11) {
        String r5 = r11.substring(14);
        InputStream r10 = null;
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L57;
    L12:
        InputStream r12 = null;
    L13:
        if (r12 == null) goto L62;
    L19:
        if (r12 == null) goto L30;
        ByteArrayOutputStream r13 = new ByteArrayOutputStream();     // Catch: Throwable -> L15 IOException -> L17
        byte[] r14 = new byte[4096];     // Catch: Throwable -> L15 IOException -> L17
    L21:
        int r15 = r12.read(r14);     // Catch: Throwable -> L15 IOException -> L17
        if (r15 == (-1)) goto L24;
        r13.write(r14, 0, r15);     // Catch: Throwable -> L15 IOException -> L17
        goto L21
    L24:
        byte[] r16 = r13.toByteArray();     // Catch: Throwable -> L15 IOException -> L17
        r12.close();     // Catch: IOException -> L27
    L29:
        return r16;
    L27:
        e = move-exception;
        LynxLog.b(4, "ResourceLoader", "loadLynxJSAsset inputStream close error: " + e.getMessage());
    L17:
        e = e;
    L37:
        LynxLog.b(4, "ResourceLoader", "loadLynxJSAsset " + r11 + "with error message " + e.getMessage());     // Catch: Throwable -> L15
        if (r12 != null) goto L58;
    L44:
        LynxLog.b(4, "ResourceLoader", "loadLynxJSAsset failed, can not load ".concat(r11));
        return null;
    L58:
        r12.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        String r17 = "loadLynxJSAsset inputStream close error: " + e.getMessage();
    L43:
        LynxLog.b(4, "ResourceLoader", r17);
    L15:
        th = th;
        r10 = r12;
    L46:
        if (r10 != null) goto L55;
    L51:
        throw th;
    L55:
        r10.close();     // Catch: IOException -> L49
    L49:
        e = move-exception;
        LynxLog.b(4, "ResourceLoader", "loadLynxJSAsset inputStream close error: " + e.getMessage());
        goto L51
    L30:
        if (r12 == null) goto L44;
        r12.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        r17 = "loadLynxJSAsset inputStream close error: " + e.getMessage();
        goto L43
    L62:
        r12 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r5);     // Catch: Throwable -> L15 IOException -> L17
        goto L19
    L57:
        String[] r18 = r5.split("\\.");     // Catch: Throwable -> L10 IOException -> L52
        if (r18.length != 2) goto L12;
        r12 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r18[0] + "_dev." + r18[1]);     // Catch: Throwable -> L10 IOException -> L52
    L10:
        th = th;
    L35:
        e = e;
        r12 = null;
        goto L37
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CalledByNative
    private byte[] loadJSSource(String r10) {
        VersionedParcel.AnonymousClass1 r5 = 0;
        if (TextUtils.isEmpty(r10) == false) goto L6;
        LynxLog.b(3, "ResourceLoader", "loadJSSource failed with empty name");
        return null;
    L6:
        LynxLog.b(2, "ResourceLoader", "loadJSSource with name " + r10);
    L24:
        e = e;
        InputStream r11 = null;
    L59:
        LynxLog.b(4, "ResourceLoader", "loadJSSource " + r10 + "with error message " + e.getMessage());     // Catch: Throwable -> L20
        if (r11 != null) goto L75;
    L62:
        LynxLog.b(4, "ResourceLoader", "loadJSSource failed, can not load " + r10);
        return null;
    L75:
        r11.close();     // Catch: IOException -> L69
    L13:
        th = th;
    L64:
        if (r5 != 0) goto L71;
    L66:
        throw th;
    L71:
        r5.close();     // Catch: IOException -> L70
        goto L66
    L8:
        if ("assets://lynx_core.js".equals(r10) == true) goto L10;
    L26:
        r11 = null;
    L27:
        if (r11 == null) goto L29;
    L49:
        if (r11 == null) goto L57;
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();     // Catch: Throwable -> L20 IOException -> L22
        byte[] r13 = new byte[4096];     // Catch: Throwable -> L20 IOException -> L22
    L51:
        int r14 = r11.read(r13);     // Catch: Throwable -> L20 IOException -> L22
        if (r14 == (-1)) goto L54;
        r12.write(r13, 0, r14);     // Catch: Throwable -> L20 IOException -> L22
        goto L51
    L54:
        byte[] r15 = r12.toByteArray();     // Catch: Throwable -> L20 IOException -> L22
        r11.close();     // Catch: IOException -> L68
    L56:
        return r15;
    L57:
        if (r11 == null) goto L62;
    L29:
        if (r10.length() <= 7) goto L38;
        if (r10.startsWith("file://") == false) goto L38;
        String r16 = r10.substring(7);     // Catch: Throwable -> L20 IOException -> L22
        if (r16.startsWith("/") == false) goto L35;
        File r17 = new File(r16);     // Catch: Throwable -> L20 IOException -> L22
    L36:
        InputStream r18 = new FileInputStream(r17);     // Catch: Throwable -> L20 IOException -> L22
    L42:
        r11 = r18;
        goto L49
    L35:
        r17 = new File(LynxEnv.inst().getAppContext().getFilesDir(), r16);     // Catch: Throwable -> L20 IOException -> L22
    L38:
        if (r10.length() <= 9) goto L44;
        if (r10.startsWith("assets://") == false) goto L44;
        r18 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r10.substring(9));     // Catch: Throwable -> L20 IOException -> L22
    L44:
        if (r10.startsWith("lynx_assets://") == false) goto L49;
        byte[] r19 = a(r10);     // Catch: Throwable -> L20 IOException -> L22
        if (r11 != null) goto L80;
    L48:
        return r19;
    L80:
        r11.close();     // Catch: IOException -> L67
        goto L48
    L10:
        if (LynxEnv.inst().isDevtoolEnabled() == false) goto L26;
        r11 = LynxEnv.inst().getAppContext().getResources().getAssets().open("lynx_core_dev.js");     // Catch: Throwable -> L13 IOException -> L15
    L18:
        if (r11 == null) goto L27;
        nativeConfigLynxResourceSetting();     // Catch: Throwable -> L20 IOException -> L22
    L22:
        e = e;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13 IOException -> L24
        r11 = null;
        goto L18
    L20:
        th = th;
        r5 = 2;
        goto L64
    }

    private native void nativeConfigLynxResourceSetting();
}
