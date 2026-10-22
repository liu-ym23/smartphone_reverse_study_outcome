package com.sdk.bwdl.StateMachine;

import android.content.Context;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.ControlLink;
import com.sdk.bwdl.ControlLinkProperty;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.sdk.bwdl.Utils.BWDLLog;
import com.sdk.bwdl.Utils.BWDLUtil;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLEventAnalyzer {
    public static final int LENGTH_CHANNEL_ID = 2;
    public static final int LENGTH_COMMAND_TYPE = 1;
    public static final int LENGTH_PROCEDURE_TYPE = 1;
    public static final int LENGTH_PROPERTY_TYPE = 2;
    private static final String TAG = "BWDLEventAnalyzer";
    private Context mContext;
    private ControlLinkSM mControlLinkSM;

    public BWDLEventAnalyzer(Context r8, ControlLinkSM r10) {
        this.mControlLinkSM = r10;
        this.mContext = r8;
    }

    public static short getCID(byte[] r8) {
        byte[] r10 = new byte[2];
        System.arraycopy(r8, 3, r10, 0, 2);
        return BWDLUtil.byteToShort(r10);
    }

    public static byte getCommandType(byte[] r8) {
        return r8[5];
    }

    public static byte[] getDataLinkParam(byte[] r8) {
        byte[] r10 = new byte[2];
        System.arraycopy(r8, r8[1] + 3, r10, 0, 2);
        int r11 = BWDLUtil.byteToShort(r10);
        byte[] r12 = new byte[r11];
        System.arraycopy(r8, r8.length - r11, r12, 0, r11);
        return r12;
    }

    public static byte[] getLinkType(byte[] r8) {
        int r10 = r8[1];
        byte[] r11 = new byte[r10];
        System.arraycopy(r8, 2, r11, 0, r10);
        return r11;
    }

    public static byte[] getMetadata(byte[] r8) {
        int r10 = r8.length - 6;
        byte[] r11 = new byte[r10];
        System.arraycopy(r8, 6, r11, 0, r10);
        return r11;
    }

    public static boolean isBWDLInnerEvent(byte[] r8) {
        if (r8[2] == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static String transformByteToString(byte r8) {
        switch(r8) {
            case 19: goto L13;
            case 20: goto L11;
            case 21: goto L9;
            case 22: goto L7;
            case 23: goto L5;
            default: goto L3;
        };
    L3:
        return "Unknown";
    L5:
        return "DEVICE_CAPABILITIES";
    L7:
        return "CHANNEL_CONFIG_RESP";
    L9:
        return "CHANNEL_CONFIG_REQ";
    L11:
        return "DATA_LINK_RESP";
    L13:
        return "DATA_LINK_REQ";
    }

    public ControlLinkProperty findControlLinkByCID(short r8) {
        if (r8 != 0) goto L5;
        return null;
    L5:
        Iterator<ControlLink> r10 = this.mControlLinkSM.getControlLinkList().iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        ControlLink r11 = r10.next();
        if (r11.getControlLinkProperty().getSourceCID() != r8) goto L7;
        return r11.getControlLinkProperty();
    L12:
        return null;
    }

    public ControlLinkProperty findControlLinkByPeerCID(short r8) {
        if (r8 != 0) goto L5;
        return null;
    L5:
        Iterator<ControlLink> r10 = this.mControlLinkSM.getControlLinkList().iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        ControlLink r11 = r10.next();
        if (r11.getControlLinkProperty().getPeerCID() != r8) goto L7;
        return r11.getControlLinkProperty();
    L12:
        return null;
    }

    public void processBWDLEvent(byte[] r8, ControlLinkSM r10, BWDLDevice r11) {
        byte r12 = getCommandType(r8);
        BWDLLog.d(TAG, "CurrentState:" + r10.getCurrentSmState() + ", receive event:" + transformByteToString(r12));
        switch(r12) {
            case 19: goto L9;
            case 20: goto L8;
            case 21: goto L7;
            case 22: goto L6;
            case 23: goto L5;
            default: goto L15;
        };
    L5:
        findControlLinkByCID(getCID(r8)).setDeviceCapabilities(BWDLInnerConstant.ConnectivityType.P2P, getMetadata(r8));
        this.mControlLinkSM.sendMessage(107);
        return;
    L6:
        this.mControlLinkSM.getChannelConfiguration().handleChannelConfigResp(r8, r10, r11);
        return;
    L7:
        this.mControlLinkSM.getChannelConfiguration().handleChannelConfigReq(r8, r10, r11);
        return;
    L8:
        byte r13 = r8[r8.length - 1];
        new DataLinkNegotiation(this.mContext, findControlLinkByCID(getCID(r8))).handleDataLinkResp(getLinkType(getMetadata(r8)), r13);
        return;
    L9:
        new DataLinkNegotiation(this.mContext, findControlLinkByCID(getCID(r8))).handleDataLinkReq(getLinkType(getMetadata(r8)), getDataLinkParam(getMetadata(r8)));
        return;
    }
}
