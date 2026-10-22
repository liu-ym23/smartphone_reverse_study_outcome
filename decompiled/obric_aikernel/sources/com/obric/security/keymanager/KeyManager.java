package com.obric.security.keymanager;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class KeyManager {
    private KeyManager() {
    }

    public static KeyManager getInstance() {
        throw new RuntimeException("Stub!!");
    }

    public int deleteKey(Context r10, String r11, Bundle r12) {
        throw new RuntimeException("Stub!!");
    }

    public int deleteSyncKey(Context r10, String r11) {
        throw new RuntimeException("Stub!!");
    }

    public int generateKeyPair(Context r10, String r11, Bundle r12) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult getCertificateChain(Context r10, String r11, Bundle r12) {
        throw new RuntimeException("Stub!!");
    }

    public UDIDManagerResult getUDID(Context r10, Bundle r11) {
        throw new RuntimeException("Stub!!");
    }

    public int importKey(Context r10, Bundle r11) {
        throw new RuntimeException("Stub!!");
    }

    public int importKeyLegacy(Context r10, Bundle r11) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult keyAgreement(Context r10, String r11, byte[] r12, Bundle r13) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult keyAttestation(Context r10, String r11, Bundle r12) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult sign(Context r10, String r11, byte[] r12, Bundle r13) {
        throw new RuntimeException("Stub!!");
    }

    public int verify(Context r10, String r11, byte[] r12, byte[] r13, Bundle r14) {
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult xcrypt(Context r10, int r11, byte[] r12, Bundle r13) {
        throw new RuntimeException("Stub!!");
    }
}
