package com.aiassistant.security.keymanager;

import android.content.Context;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class KeyManager {
    private KeyManager() {
    }

    public static KeyManager getInstance() {
        throw new RuntimeException("Stub!!");
    }

    public int deleteKey(Context r1, String r2, Bundle r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public int deleteSyncKey(Context r1, String r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public int generateKeyPair(Context r1, String r2, Bundle r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult getCertificateChain(Context r1, String r2, Bundle r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public UDIDManagerResult getUDID(Context r1, Bundle r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public int importKey(Context r1, Bundle r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public int importKeyLegacy(Context r1, Bundle r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult keyAgreement(Context r1, String r2, byte[] r3, Bundle r4) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult keyAttestation(Context r1, String r2, Bundle r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult sign(Context r1, String r2, byte[] r3, Bundle r4) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public int verify(Context r1, String r2, byte[] r3, byte[] r4, Bundle r5) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public KeyManagerResult xcrypt(Context r1, int r2, byte[] r3, Bundle r4) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }
}
