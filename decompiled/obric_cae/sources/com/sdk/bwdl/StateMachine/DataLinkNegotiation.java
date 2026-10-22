package com.sdk.bwdl.StateMachine;

import android.content.Context;
import com.sdk.bwdl.AdapterLayer.Wifi.P2p.P2pAdapter;
import com.sdk.bwdl.AdapterLayer.Wifi.P2p.P2pUtil;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.ControlLinkProperty;
import com.sdk.bwdl.ExternalAPI.BWDLConstant;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.sdk.bwdl.Utils.BWDLLog;
import com.sdk.bwdl.Utils.BWDLUtil;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class DataLinkNegotiation {
    private static final String TAG = "DataLinkNegotiation";
    private P2pAdapter mBWDLAdapter;
    private BWDLCommandBuilder mBWDLCommandBuilder;
    private Context mContext;
    private ControlLinkProperty mControlLinkProperty;
    private ControlLinkSM mControlLinkSM;

    /* JADX INFO: renamed from: com.sdk.bwdl.StateMachine.DataLinkNegotiation$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$LinkType = null;

        static {
            int[] r8 = new int[BWDLConstant.LinkType.values().length];
            $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$LinkType = r8;
            r8[BWDLConstant.LinkType.P2P.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$LinkType[BWDLConstant.LinkType.Socket.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public DataLinkNegotiation(Context r8, ControlLinkProperty r10) {
        this.mControlLinkProperty = r10;
        this.mControlLinkSM = r10.getControlLinkSM();
        this.mContext = r8;
        this.mBWDLCommandBuilder = new BWDLCommandBuilder();
    }

    private byte linkReqRuling(BWDLConstant.LinkType[] r8, byte[] r10) {
        int r11 = r8.length;
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L16;
        BWDLConstant.LinkType r13 = r8[r12];
        if (AnonymousClass1.$SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$LinkType[r13.ordinal()] != 1) goto L15;
        if (this.mBWDLAdapter != null) goto L12;
        this.mBWDLAdapter = P2pAdapter.getInstance(this.mContext, this.mControlLinkProperty.getBWDLConfigs().getP2pBand());
    L12:
        if (this.mBWDLAdapter.isAdapterReady() != 11) goto L15;
        return 4;
    L15:
        r12 = r12 + 1;
        goto L4
    L16:
        return 1;
    }

    public void handleDataLinkReq(byte[] r8, byte[] r10) {
        BWDLLog.d(TAG, "handleDataLinkReq");
        DataLinkSM r11 = this.mControlLinkProperty.getDataLinkSM();
        BWDLConstant.LinkType[] r12 = BWDLDataStructure.DataLinkParamStructure.ByteToLinkType(r8);
        byte r13 = linkReqRuling(r12, r10);
        sendDataLinkResp(r8, r13);
        if (r13 == 1) goto L5;
        if (r11 == null) goto L15;
        int r14 = BWDLInnerConstant.D_L2DISCONNECT;
        BWDLDevice r15 = null;
    L11:
        r11.sendMessage(r14, 0, 0, r15);
        return;
    L15:
        return;
    L5:
        if (BWDLUtil.getLinkLayerType(r12) != BWDLConstant.LinkType.P2P) goto L13;
        r15 = new BWDLDevice(BWDLInnerConstant.ConnectivityType.P2P, P2pUtil.parseByteArrayToConfig(r10));
        this.mControlLinkProperty.setDataLinkLLInfo(r15);
        if (r11 == null) goto L14;
        r14 = BWDLInnerConstant.D_L2_SERVER_READY;
        goto L11
    L14:
        return;
    }

    public void handleDataLinkResp(byte[] r8, byte r10) {
        BWDLLog.d(TAG, "handleDataLinkResp");
        DataLinkSM r11 = this.mControlLinkProperty.getDataLinkSM();
        BWDLDataStructure.DataLinkParamStructure.ByteToLinkType(r8);
        if (r10 != 4) goto L7;
        if (r11 == null) goto L8;
        r11.sendMessage(BWDLInnerConstant.LL_PARAM_FAIL, 11);
        return;
    L8:
        return;
    }

    public boolean sendDataLinkReq(BWDLConstant.LinkType[] r10) {
        byte[] r8 = new byte[0];
        byte[] r11 = new byte[0];
        DataLinkSM r12 = this.mControlLinkProperty.getDataLinkSM();
        int r13 = r10.length;
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L21;
        if (AnonymousClass1.$SwitchMap$com$sdk$bwdl$ExternalAPI$BWDLConstant$LinkType[r10[r14].ordinal()] != 1) goto L20;
        P2pAdapter r15 = P2pAdapter.getInstance(this.mContext, this.mControlLinkProperty.getBWDLConfigs().getP2pBand());
        this.mBWDLAdapter = r15;
        int r16 = r15.isAdapterReady();
        if (this.mBWDLAdapter.isAdapterReady() != 0) goto L10;
        if (this.mBWDLAdapter.getP2pGroup() == null) goto L14;
        r11 = (byte[]) P2pUtil.convertConfigToByteArray(this.mBWDLAdapter.getP2pGroup()).clone();
        goto L20
    L14:
        BWDLLog.d(TAG, "p2pGroupInfo is null");
        byte[] r17 = this.mControlLinkProperty.getDeviceCapabilities(BWDLInnerConstant.ConnectivityType.P2P);
        if (r17 == null) goto L17;
        this.mBWDLAdapter.startP2pGroup(P2pUtil.parseByteArrayToCapabilities(r17));
    L18:
        return false;
    L17:
        BWDLLog.d(TAG, "wifiCapabilities is null");
        goto L18
    L10:
        r12.sendMessage(BWDLInnerConstant.LL_PARAM_FAIL, r16, 0, null);
        BWDLLog.d(TAG, "p2pAdapter is not ready");
        return false;
    L20:
        r14 = r14 + 1;
        goto L4
    L21:
        BWDLDataStructure.DataLinkParamStructure r18 = new BWDLDataStructure.DataLinkParamStructure(r10, r11);
        r8 = BWDLCommandBuilder.buildDataLinkReq(r18.buildData(), this.mControlLinkProperty.getPeerCID());     // Catch: IOException -> L24
    L27:
        return this.mControlLinkProperty.getControlLink().sendMessageToHandler(5, 0, 0, r8);
    L24:
        e = move-exception;
        BWDLLog.d(TAG, "IOException:" + e.getMessage());
        goto L27
    }

    public void sendDataLinkResp(byte[] r8, byte r10) {
        byte[] r11 = new byte[0];
        r11 = BWDLCommandBuilder.buildDataLinkResp(new BWDLDataStructure.DataLinkParamStructure(r8, new byte[]{r10}).buildData(), this.mControlLinkProperty.getPeerCID());     // Catch: IOException -> L5
    L7:
        this.mControlLinkSM.getControlLinkHandler().sendMessageWithParam(5, 0, 0, r11);
        return;
    L5:
        e = move-exception;
        BWDLLog.d(TAG, "IOException:" + e.getMessage());
        goto L7
    }
}
