package com.sdk.bwdl.StateMachine;

import android.content.Context;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.BWDLDeviceManager;
import com.sdk.bwdl.ControlLink;
import com.sdk.bwdl.ControlLinkProperty;
import com.sdk.bwdl.Utils.BWDLLog;
import com.sdk.bwdl.Utils.BWDLUtil;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ChannelConfiguration {
    private static final String TAG = "ChannelConfiguration";
    private BWDLEventAnalyzer mAnalyzer;
    private BWDLCommandBuilder mBWDLCommandBuilder;
    private BWDLDeviceManager mBWDLDeviceManager;
    private Context mContext;
    private ControlLinkHandler mControlLinkHandler;
    private ControlLinkSM mControlLinkSM;
    private BWDLDevice mDevice;
    private int mDeviceId;

    public ChannelConfiguration(Context r8, ControlLinkSM r10, BWDLDevice r11) {
        this.mContext = r8;
        this.mDeviceId = BWDLUtil.convertStringToUniqueCode(BWDLUtil.getAndroidId(r8));
        this.mControlLinkSM = r10;
        this.mBWDLCommandBuilder = new BWDLCommandBuilder();
        this.mControlLinkHandler = this.mControlLinkSM.getControlLinkHandler();
        this.mAnalyzer = new BWDLEventAnalyzer(r8, this.mControlLinkSM);
        this.mDevice = r11;
        this.mBWDLDeviceManager = BWDLDeviceManager.getInstance(r8);
        BWDLLog.d(TAG, " deviceId:" + this.mDeviceId);
    }

    private int getDeviceId() {
        return this.mDeviceId;
    }

    public void channelConfig() {
        BWDLLog.d(TAG, "channelConfig");
        Iterator<ControlLink> r8 = this.mControlLinkSM.getControlLinkList().iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        ControlLinkProperty r10 = r8.next().getControlLinkProperty();
        if (r10.getFeature().isEmpty() == true) goto L4;
        if (r10.getPeerCID() != 0) goto L4;
        short r11 = r10.getSourceCID();
        int r12 = getDeviceId();
        byte[] r13 = BWDLCommandBuilder.buildChannelConfigReq(r11, r10.getFeature(), r12);
        this.mControlLinkHandler.sendMessageWithParam(5, 0, 0, r13);
        this.mControlLinkSM.sendMessageDelayed(203, 5000);
        goto L4
    }

    public void channelConfigResp(ControlLinkProperty r8) {
        BWDLLog.d(TAG, "channelConfigResp");
        int r10 = getDeviceId();
        byte[] r11 = BWDLCommandBuilder.buildChannelConfigResp(r8.getSourceCID(), r8.getFeature(), r10);
        this.mControlLinkHandler.sendMessageWithParam(5, 0, 0, r11);
    }

    public void handleChannelConfigReq(byte[] r8, ControlLinkSM r10, BWDLDevice r11) {
        BWDLLog.d(TAG, "handleChannelConfigReq");
        short r12 = BWDLEventAnalyzer.getCID(r8);
        byte[] r13 = BWDLEventAnalyzer.getMetadata(r8);
        int r14 = ByteBuffer.wrap(r13, 0, 4).getInt();
        String r15 = new String(r13, 4, r13.length - 4);
        BWDLLog.d(TAG, "deviceId：" + r14 + " feature:" + r15);
        r11.setDeviceId(r14);
        this.mBWDLDeviceManager.updateControlLinkSmMap(r14, r10);
        if (this.mBWDLDeviceManager.isBWDLFeatureExit(r15) == true) goto L6;
        BWDLLog.d(TAG, "BWDL feature not found");
        return;
    L6:
        ControlLink r16 = this.mBWDLDeviceManager.isControlLinkExit(r15, r11);
        if (r16 != null) goto L9;
        r16 = this.mBWDLDeviceManager.createControlLink(r15, r11, r10);
    L9:
        ControlLinkProperty r17 = r16.getControlLinkProperty();
        r17.setPeerCID(r12);
        channelConfigResp(r17);
        this.mControlLinkSM.sendMessage(104, r16);
    }

    public boolean handleChannelConfigResp(byte[] r8, ControlLinkSM r10, BWDLDevice r11) {
        BWDLLog.d(TAG, "handleChannelConfigResp");
        short r12 = BWDLEventAnalyzer.getCID(r8);
        byte[] r13 = BWDLEventAnalyzer.getMetadata(r8);
        int r14 = ByteBuffer.wrap(r13, 0, 4).getInt();
        String r15 = new String(r13, 4, r13.length - 4);
        BWDLLog.d(TAG, "deviceId：" + r14 + " feature:" + r15);
        r11.setDeviceId(r14);
        this.mBWDLDeviceManager.updateControlLinkSmMap(r14, r10);
        if (r12 != 0) goto L8;
        String r16 = "Channel config fail for channel illegal:".concat(r15);
    L5:
        BWDLLog.d(TAG, r16);
        return false;
    L8:
        if (this.mBWDLDeviceManager.isBWDLFeatureExit(r15) == true) goto L10;
        r16 = "BWDL feature not found";
        goto L5
    L10:
        ControlLink r17 = this.mBWDLDeviceManager.isControlLinkExit(r15, r11);
        if (r17 != null) goto L13;
        r17 = this.mBWDLDeviceManager.createControlLink(r15, r11, r10);
    L13:
        r17.getControlLinkProperty().setPeerCID(r12);
        this.mControlLinkSM.sendMessage(104, r17);
        return true;
    }

    public void channelConfig(String r8) {
        BWDLLog.d(TAG, "channelConfig");
        Iterator<ControlLink> r10 = this.mControlLinkSM.getControlLinkList().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        ControlLinkProperty r11 = r10.next().getControlLinkProperty();
        if (r11.getFeature().equals(r8) == false) goto L4;
        if (r11.getPeerCID() != 0) goto L4;
        byte[] r12 = BWDLCommandBuilder.buildChannelConfigReq(r11.getSourceCID(), r8, getDeviceId());
        this.mControlLinkHandler.sendMessageWithParam(5, 0, 0, r12);
        goto L4
    }
}
