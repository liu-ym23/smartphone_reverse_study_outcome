package com.bytedance.crypto.nativelib;

import android.content.Context;
import com.bytedance.crypto.platform.PlatKeyManager;
import com.bytedance.crypto.utils.LogUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class PlatKeyManagerProxy {
    private static final String TAG = "PlatKeyManagerProxy";
    private static volatile PlatKeyManagerProxy platKeyManagerProxy;

    public PlatKeyManagerProxy() {
    }

    public static PlatKeyManagerProxy getInstance() {
        if (platKeyManagerProxy != null) goto L15;
        monitor-enter(PlatKeyManagerProxy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (platKeyManagerProxy != null) goto L9;
        platKeyManagerProxy = new PlatKeyManagerProxy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PlatKeyManagerProxy.class);     // Catch: Throwable -> L11
    L15:
        return platKeyManagerProxy;
    }

    public byte[] decryptModelFile(Context r10, String r11, String r12, String r13) {
        LogUtils.d(TAG, "decryptModelFile enter");
        if (r11 != null) goto L5;
    L36:
        String r14 = "inPath is null or empty";
    L28:
        LogUtils.e(TAG, r14);
        return new byte[0];
    L5:
        if (r11.isEmpty() == true) goto L36;
        if (r12 != null) goto L9;
    L35:
        r14 = "FEKCipher is null or empty";
        goto L28
    L9:
        if (r12.isEmpty() == true) goto L35;
        if (r13 != null) goto L13;
    L34:
        r14 = "secAppId is null or empty";
        goto L28
    L13:
        if (r13.isEmpty() == true) goto L34;
        FileInputStream r15 = new FileInputStream(r11);     // Catch: Exception -> L25 IOException -> L30 FileNotFoundException -> L32
        byte[] r16 = PlatKeyManager.getInstance().decryptModelFileV2(r10, r15, r12, r13);     // Catch: Throwable -> L19
        r15.close();     // Catch: Exception -> L25 IOException -> L30 FileNotFoundException -> L32
        return r16;
    L19:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Exception -> L25 IOException -> L30 FileNotFoundException -> L32
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L25 IOException -> L30 FileNotFoundException -> L32
    L32:
        e = move-exception;
        StringBuilder r17 = new StringBuilder();
        r17.append("File not exist, exception: ");
        String r18 = e.getMessage();
    L27:
        r17.append(r18);
        r14 = r17.toString();
    L30:
        e = move-exception;
        r17 = new StringBuilder();
        r17.append("IOException: ");
        r18 = e.getMessage();
    L25:
        e = move-exception;
        r17 = new StringBuilder();
        r17.append("Other exception: ");
        r18 = e.getMessage();
        goto L27
    }

    public int decryptModelFileByStream(Context r10, String r11, String r12, String r13, String r14) {
        LogUtils.d(TAG, "decryptModelFileByStream enter");
        if (r11 != null) goto L5;
    L51:
        String r15 = "inPath is null or empty";
    L47:
        LogUtils.e(TAG, r15);
        return -2;
    L5:
        if (r11.isEmpty() == true) goto L51;
        if (r12 != null) goto L9;
    L50:
        r15 = "outPath is null or empty";
        goto L47
    L9:
        if (r12.isEmpty() == true) goto L50;
        if (r13 != null) goto L13;
    L49:
        r15 = "FEKCipher is null or empty";
        goto L47
    L13:
        if (r13.isEmpty() == true) goto L49;
        if (r14 != null) goto L17;
    L46:
        r15 = "secAppId is null or empty";
        goto L47
    L17:
        if (r14.isEmpty() == true) goto L46;
        FileInputStream r16 = new FileInputStream(r11);     // Catch: Exception -> L37 IOException -> L40 FileNotFoundException -> L43
        FileOutputStream r17 = new FileOutputStream(r12);     // Catch: Throwable -> L31
        int r18 = PlatKeyManager.getInstance().decryptModelFileV2(r10, r16, r17, r13, r14);     // Catch: Throwable -> L25
        r17.close();     // Catch: Throwable -> L31
        r16.close();     // Catch: Exception -> L37 IOException -> L40 FileNotFoundException -> L43
        return r18;
    L25:
        th = move-exception;
        r17.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Throwable -> L31
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L34
    L36:
        throw th;     // Catch: Exception -> L37 IOException -> L40 FileNotFoundException -> L43
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L37 IOException -> L40 FileNotFoundException -> L43
    L43:
        e = move-exception;
        LogUtils.e(TAG, "File not exist, exception: " + e.getMessage());
        return -16;
    L40:
        e = move-exception;
        LogUtils.e(TAG, "IOException: " + e.getMessage());
        return -17;
    L37:
        e = move-exception;
        LogUtils.e(TAG, "Other exception: " + e.getMessage());
        return -1000;
    }

    public String reEncryptFEK(Context r10, String r11, String r12, int r13) {
        LogUtils.d(TAG, "reEncryptFEK enter");
        return PlatKeyManager.getInstance().reEncryptFEKV2(r10, r11, r13, r12);
    }
}
