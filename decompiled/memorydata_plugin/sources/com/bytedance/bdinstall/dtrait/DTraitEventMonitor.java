package com.bytedance.bdinstall.dtrait;

/* JADX INFO: loaded from: classes.dex */
public class DTraitEventMonitor {
    private static int encryptDuration = 0;
    private static boolean encryptResult = false;

    static {
    }

    public DTraitEventMonitor() {
    }

    public static int getEncryptDuration() {
        return encryptDuration;
    }

    public static boolean getEncryptResult() {
        return encryptResult;
    }

    public static void setEncryptDuration(int r0) {
        encryptDuration = r0;
    }

    public static void setEncryptResult(boolean r0) {
        encryptResult = r0;
    }
}
