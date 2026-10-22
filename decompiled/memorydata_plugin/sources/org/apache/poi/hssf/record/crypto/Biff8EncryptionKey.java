package org.apache.poi.hssf.record.crypto;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class Biff8EncryptionKey {
    private static final ThreadLocal<String> _userPasswordTLS = null;

    static {
        _userPasswordTLS = new ThreadLocal();
    }

    public static String getCurrentUserPassword() {
        return (String) ZeusTransformUtils.preCheckCast(_userPasswordTLS.get(), String.class, "com.obric.memorydata.plugin");
    }

    public static void setCurrentUserPassword(String r1) {
        if (r1 != null) goto L4;
        _userPasswordTLS.remove();
        return;
    L4:
        _userPasswordTLS.set(r1);
    }
}
