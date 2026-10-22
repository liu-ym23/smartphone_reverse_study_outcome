package com.bytedance.crypto.platform;

import android.content.Context;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.obfuscated.b;
import com.bytedance.crypto.obfuscated.c;
import com.bytedance.crypto.obfuscated.g;
import com.bytedance.crypto.utils.LogUtils;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class PlatKeyManager {
    private static final String TAG = "PlatKeyManager";
    private static volatile PlatKeyManager platKeyManager;

    private PlatKeyManager() {
    }

    public static PlatKeyManager getInstance() {
        if (platKeyManager != null) goto L15;
        monitor-enter(PlatKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (platKeyManager != null) goto L9;
        platKeyManager = new PlatKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PlatKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return platKeyManager;
    }

    public int decryptModelFile(Context r10, InputStream r11, OutputStream r12, String r13) {
        g.a().getClass();
        return c.a().a(r10, r11, r12, r13);
    }

    public byte[] decryptModelFile(Context r10, InputStream r11, String r12) {
        g.a().getClass();
        c.a().getClass();
        if (r10 == null) goto L10;
        if (r11 == null) goto L10;
        if (r12 == null) goto L10;
        if (r12.isEmpty() == true) goto L10;
        return b.a(r10, r11, r12, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
    L10:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return new byte[0];
    }

    public int decryptModelFileV2(Context r10, InputStream r11, OutputStream r12, String r13, String r14) {
        String r15 = r14 + "-" + ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS;
        g.a().getClass();
        c.a().getClass();
        if (r10 == null) goto L14;
        if (r11 == null) goto L14;
        if (r12 == null) goto L14;
        if (r13 == null) goto L14;
        if (r13.isEmpty() == true) goto L14;
        if (r15 == null) goto L14;
        if (r15.isEmpty() == true) goto L14;
        return b.a(r10, r11, r12, r13, r15);
    L14:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return -2;
    }

    public byte[] decryptModelFileV2(Context r10, InputStream r11, String r12, String r13) {
        String r14 = r13 + "-" + ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS;
        g.a().getClass();
        c.a().getClass();
        if (r10 == null) goto L13;
        if (r11 == null) goto L13;
        if (r12 == null) goto L13;
        if (r12.isEmpty() == true) goto L13;
        if (r14 == null) goto L13;
        if (r14.isEmpty() == true) goto L13;
        return b.a(r10, r11, r12, r14);
    L13:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return new byte[0];
    }

    public String reEncryptFEK(Context r10, String r11, int r12) {
        return g.a().a(r10, r11, r12, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
    }

    public String reEncryptFEKV2(Context r10, String r11, int r12, String r13) {
        return g.a().a(r10, r11, r12, r13 + "-" + ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
    }
}
