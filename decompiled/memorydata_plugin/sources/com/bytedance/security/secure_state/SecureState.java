package com.bytedance.security.secure_state;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SecureState {
    private SecureState() {
    }

    public static SecureState getInstance() {
        throw new RuntimeException("Stub!!");
    }

    public boolean avbIsVerified() {
        throw new RuntimeException("Stub!!");
    }

    public boolean buildIsUserDebug() {
        throw new RuntimeException("Stub!!");
    }

    public boolean deviceIsLocked() {
        throw new RuntimeException("Stub!!");
    }

    public boolean deviceIsSecure() {
        throw new RuntimeException("Stub!!");
    }

    public DeviceSecureState getDeviceSecureState() {
        throw new RuntimeException("Stub!!");
    }

    public boolean kernelIsSecure() {
        throw new RuntimeException("Stub!!");
    }

    public boolean registerCallback(SecureStateCallback r2) {
        SecureStateCallback r1 = (SecureStateCallback) ZeusTransformUtils.wrapperContextForParams(r2, SecureStateCallback.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public boolean securebootIsEnabled() {
        throw new RuntimeException("Stub!!");
    }

    public boolean selinuxIsEnforcing() {
        throw new RuntimeException("Stub!!");
    }

    public boolean unregisterCallback(SecureStateCallback r2) {
        SecureStateCallback r1 = (SecureStateCallback) ZeusTransformUtils.wrapperContextForParams(r2, SecureStateCallback.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }
}
