package com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure;

/* JADX INFO: loaded from: classes2.dex */
public class BwdlFlagDataStructure {
    public static final byte LE_GENERAL_DISCOVERABLE_MODE_BIT = 1;
    public static final byte LE_LIMITED_DISCOVERABLE_MODE_BIT = 0;
    public static final byte NO_BR_EDR_SUPPORT_BIT = 2;
    public static final byte RESERVED_BIT_1 = 5;
    public static final byte RESERVED_BIT_2 = 6;
    public static final byte RESERVED_BIT_3 = 7;
    public static final byte SAME_DEVICE_CAPABLE_CONTROLLER_BIT = 3;
    public static final byte SAME_DEVICE_CAPABLE_HOST_BIT = 4;
    private static final int mAdDataLen = 1;
    private byte mAdData;

    public BwdlFlagDataStructure() {
        setLELimitedDiscoverableMode(false);
        setLEGeneralDiscoverableMode(true);
        setNoBREDRSupport(true);
        setSameDeviceCapableController(false);
        setSameDeviceCapableHost(false);
    }

    private boolean isBitSet(int r8) {
        if ((this.mAdData & (1 << r8)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private void setBit(int r8, boolean r10) {
        if (r10 == false) goto L5;
        int r11 = 1 << r8;
        int r12 = r11 | this.mAdData;
    L6:
        this.mAdData = (byte) r12;
        return;
    L5:
        byte r13 = this.mAdData;
        r12 = (~(1 << r8)) & r13;
        goto L6
    }

    public byte[] getBytesData() {
        return new byte[]{this.mAdData};
    }

    public boolean isLEGeneralDiscoverableMode() {
        return isBitSet(1);
    }

    public boolean isLELimitedDiscoverableMode() {
        return isBitSet(0);
    }

    public boolean isNoBREDRSupport() {
        return isBitSet(2);
    }

    public boolean isSameDeviceCapableController() {
        return isBitSet(3);
    }

    public boolean isSameDeviceCapableHost() {
        return isBitSet(4);
    }

    public void setLEGeneralDiscoverableMode(boolean r8) {
        setBit(1, r8);
    }

    public void setLELimitedDiscoverableMode(boolean r8) {
        setBit(0, r8);
    }

    public void setNoBREDRSupport(boolean r8) {
        setBit(2, r8);
    }

    public void setSameDeviceCapableController(boolean r8) {
        setBit(3, r8);
    }

    public void setSameDeviceCapableHost(boolean r8) {
        setBit(4, r8);
    }
}
