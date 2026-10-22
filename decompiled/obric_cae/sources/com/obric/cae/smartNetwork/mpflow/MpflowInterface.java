package com.obric.cae.smartNetwork.mpflow;

import com.cae.caed.SocketFilterParcel;
import com.cae.caed.SocketTupleParcel;
import com.obric.cae.smartNetwork.SmartNetworkBinder;

/* JADX INFO: loaded from: classes2.dex */
public class MpflowInterface {
    public static final byte NET_TYPE_CELLULAR_1 = 0;
    public static final byte NET_TYPE_CELLULAR_2 = 1;
    public static final byte NET_TYPE_WIFI_1 = 2;
    public static final byte NET_TYPE_WIFI_2 = 3;
    private static final String TAG = "MpflowInterface";
    private SmartNetworkBinder mSmartNetworkBinder;

    public MpflowInterface() {
        this.mSmartNetworkBinder = SmartNetworkBinder.getInstance();
    }

    public int SetNextPriorityAccel(final byte r8, final int r10) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass15(this, r8, r10));
    }

    public int bindNetByPid(final byte r8, final int r10, final boolean r11) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass5(this, r8, r10, r11));
    }

    public int bindNetByUid(final byte r8, final int r10, final boolean r11) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass4(this, r8, r10, r11));
    }

    public int denyAccelByUid(final byte r8, final int r10, final boolean r11) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass13(this, r8, r10, r11));
    }

    public int disconnectSocketByFilter(final SocketFilterParcel r8) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass9(this, r8));
    }

    public int disconnectSocketByPid(final int r8) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass7(this, r8));
    }

    public int disconnectSocketByTuple(final SocketTupleParcel r8) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass10(this, r8));
    }

    public int disconnectSocketByUid(final int r8) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass6(this, r8));
    }

    public int enableAccelByUid(final int r8, final int r10, final boolean r11) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass11(this, r8, r10, r11));
    }

    public int modifyNetName(final byte r8, final String r10) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass1(this, r8, r10));
    }

    public int setDefaultNetType(final byte r8) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass12(this, r8));
    }

    public int setGlobalAccelMaxQuota(final byte r8, final int r10) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass14(this, r8, r10));
    }

    public int setSocketOptByUid(final int r8, final int r10, final int r11) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass8(this, r8, r10, r11));
    }

    public int switchNetByPid(final byte r8, final int r10, final boolean r11) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass3(this, r8, r10, r11));
    }

    public int switchNetByUid(final byte r8, final int r10, final boolean r11) {
        return this.mSmartNetworkBinder.callRemoteMethod(new AnonymousClass2(this, r8, r10, r11));
    }
}
