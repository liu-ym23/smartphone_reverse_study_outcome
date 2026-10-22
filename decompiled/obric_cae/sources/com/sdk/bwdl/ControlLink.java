package com.sdk.bwdl;

import android.content.Context;
import com.sdk.bwdl.ExternalAPI.BWDLConfigs;
import com.sdk.bwdl.ExternalAPI.BWDLConstant;
import com.sdk.bwdl.StateMachine.BWDLCommandBuilder;
import com.sdk.bwdl.StateMachine.ControlLinkSM;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.sdk.bwdl.Utils.BWDLLog;
import com.sdk.bwdl.Utils.BWDLUtil;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ControlLink {
    private static final String TAG = "ControlLink";
    private BWDLCommandBuilder mBWDLCommandBuilder;
    private boolean mCbkFlag;
    private Context mContext;
    private ControlLink mControlLink;
    private ControlLinkProperty mControlLinkProperty;
    private ControlLinkSM mControlLinkSM;
    private List<DataLink> mDataLinkList;
    private ControlLinkSMListener mSMListener;

    /* JADX INFO: renamed from: com.sdk.bwdl.ControlLink$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class ControlLinkSMListener implements ControlLinkSM.IControlLinkSMListener {
        final /* synthetic */ ControlLink this$0;

        private ControlLinkSMListener(ControlLink r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.ControlLinkSM.IControlLinkSMListener
        public void onStateChanged(BWDLDevice r8, BWDLInnerConstant.ControlLinkSmState r10, BWDLInnerConstant.ControlLinkSmState r11, int r12) {
            BWDLLog.d(ControlLink.TAG, "ControlLinkSM transform：" + r10 + " to " + r11);
            if (r11 != BWDLInnerConstant.ControlLinkSmState.ActiveState) goto L8;
            if (ControlLink.access$100(this.this$0) == true) goto L8;
            this.this$0.sendConnectedToUpper();
            ControlLink.access$102(this.this$0, true);
            return;
        L8:
            if (r11 != BWDLInnerConstant.ControlLinkSmState.DisconnectedState) goto L11;
            ControlLink.access$200(this.this$0);
            ControlLink.access$300(this.this$0);
            return;
        L11:
            if (r12 != 200) goto L16;
            this.this$0.sendConnectFailToUpper();
            return;
        }

        public /* synthetic */ ControlLinkSMListener(ControlLink r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public ControlLink(Context r8, BWDLConfigs r10, ControlLinkSM r11, BWDLDevice r12) {
        this.mDataLinkList = new CopyOnWriteArrayList();
        this.mCbkFlag = false;
        BWDLLog.d(TAG, "new ControlLink");
        this.mContext = r8;
        this.mControlLink = this;
        this.mControlLinkSM = r11;
        this.mControlLinkProperty = buildControlLinkProperty(r10, r12);
        this.mBWDLCommandBuilder = new BWDLCommandBuilder();
        ControlLinkSMListener r13 = new ControlLinkSMListener(this, null);
        this.mSMListener = r13;
        this.mControlLinkSM.setControlLinkSMListener(r13);
    }

    public static /* synthetic */ boolean access$100(ControlLink r8) {
        return r8.mCbkFlag;
    }

    public static /* synthetic */ boolean access$102(ControlLink r8, boolean r10) {
        r8.mCbkFlag = r10;
        return r10;
    }

    public static /* synthetic */ void access$200(ControlLink r8) {
        r8.sendDisconnectedToUpper();
    }

    public static /* synthetic */ void access$300(ControlLink r8) {
        r8.cleanup();
    }

    private boolean addDataLinkToList(DataLink r8) {
        List<DataLink> r10 = this.mDataLinkList;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mDataLinkList.contains(r8) == false) goto L9;
        monitor-exit(r10);     // Catch: Throwable -> L13
        return false;
    L9:
        this.mDataLinkList.add(r8);     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return true;
    }

    private void cleanup() {
        BWDLLog.d(TAG, "cleanup");
        List<DataLink> r8 = this.mDataLinkList;
        monitor-enter(r8);
        Iterator<DataLink> r10 = this.mDataLinkList.iterator();     // Catch: Throwable -> L15
    L6:
        if (r10.hasNext() == false) goto L8;
        DataLink r11 = r10.next();     // Catch: Throwable -> L15
        removeDataLink(r11);     // Catch: Throwable -> L15
        r11.setExitFlag(true);     // Catch: Throwable -> L15
        goto L6
    L8:
        this.mDataLinkList.clear();     // Catch: Throwable -> L15
        monitor-exit(r8);     // Catch: Throwable -> L15
        ControlLinkSM r12 = this.mControlLinkSM;
        if (r12 == null) goto L13;
        r12.removeControlLinkToSm(this);
        this.mControlLinkSM.removeControlLinkSMListener(this.mSMListener);
    L13:
        BWDLDeviceManager.getInstance(this.mContext).removeControlLinkFromList(this);
        this.mControlLinkProperty = null;
        this.mControlLink = null;
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private boolean removeDataLinkFromList(DataLink r8) {
        List<DataLink> r10 = this.mDataLinkList;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mDataLinkList.contains(r8) == false) goto L10;
        this.mDataLinkList.remove(r8);     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return true;
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L13
        return false;
    }

    private void sendDisconnectedToUpper() {
        BWDLLog.d(TAG, "sendDisconnectedToUpper");
        if (this.mControlLinkProperty.getBWDLCallback() == null) goto L6;
        this.mControlLinkProperty.getBWDLCallback().onEventDisconnected(this);
        return;
    }

    public ControlLinkProperty buildControlLinkProperty(BWDLConfigs r8, BWDLDevice r10) {
        String r11 = r8.getFeatureName();
        BWDLLog.d(TAG, "buildControlLinkProperty for:" + r11);
        ControlLinkProperty r12 = new ControlLinkProperty(r8, BWDLUtil.buildRandomChannelID(r11), this);
        r12.setBWDLDevice(r10);
        r12.setControlLinkSM(this.mControlLinkSM);
        return r12;
    }

    public DataLink createDataLink(BWDLConstant.LinkType[] r8) {
        BWDLLog.d(TAG, "createDataLink");
        if (r8 != null) goto L6;
        return null;
    L6:
        if (this.mDataLinkList.isEmpty() == false) goto L9;
        DataLink r10 = new DataLink(this.mContext, this.mControlLinkProperty, r8);
        addDataLinkToList(r10);
        return r10;
    L9:
        Iterator<DataLink> r11 = this.mDataLinkList.iterator();
    L11:
        if (r11.hasNext() == false) goto L16;
        DataLink r12 = r11.next();
        if (Arrays.equals(r12.getLinkTypes(), r8) == false) goto L11;
        BWDLLog.d(TAG, "Same data link's types");
        return r12;
    L16:
        BWDLLog.d(TAG, "DataLink is already exit with difference types");
        return null;
    }

    public boolean disconnect() {
        BWDLLog.d(TAG, "disconnect");
        Iterator<DataLink> r8 = this.mDataLinkList.iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        r8.next().disconnect();
        goto L4
    L7:
        if (this.mControlLinkSM.getControlLinkList().size() <= 1) goto L10;
        sendDisconnectedToUpper();
        cleanup();
        return true;
    L10:
        ControlLinkSM r10 = this.mControlLinkSM;
        if (r10 == null) goto L14;
        r10.sendMessage(101, this.mControlLinkProperty.getBWDLDevice());
        return true;
    L14:
        return false;
    }

    public void encrypt() {
        ControlLinkSM r8 = this.mControlLinkSM;
        if (r8 == null) goto L6;
        r8.sendMessage(106, this.mControlLinkProperty.getBWDLDevice());
        return;
    }

    public ControlLinkProperty getControlLinkProperty() {
        return this.mControlLinkProperty;
    }

    public List<DataLink> getDataLinkList() {
        return this.mDataLinkList;
    }

    public boolean removeDataLink(DataLink r8) {
        BWDLLog.d(TAG, "removeDataLink");
        if (this.mDataLinkList.contains(r8) == false) goto L6;
        r8.setExitFlag(true);
        r8.disconnect();
        removeDataLinkFromList(r8);
        return true;
    L6:
        return false;
    }

    public void sendConnectFailToUpper() {
        BWDLLog.d(TAG, "sendConnectFailToUpper");
        if (this.mControlLinkProperty.getBWDLCallback() == null) goto L6;
        this.mControlLinkProperty.getBWDLCallback().onEventConnectFail(this.mControlLinkProperty.getBWDLDevice());
        return;
    }

    public void sendConnectedToUpper() {
        BWDLLog.d(TAG, "sendConnectedToUpper");
        if (this.mControlLinkProperty.getBWDLCallback() == null) goto L6;
        this.mControlLinkProperty.getBWDLCallback().onEventConnected(this.mControlLinkProperty.getBWDLDevice(), this);
        return;
    }

    public void sendDataReceiveToUpper(byte[] r8) {
        BWDLLog.d(TAG, "sendDataReceiveToUpper");
        if (this.mControlLinkProperty.getBWDLCallback() == null) goto L6;
        this.mControlLinkProperty.getBWDLCallback().onDataReceive(this, r8);
        return;
    }

    public void sendEventCompleteToUpper() {
        BWDLLog.d(TAG, "sendEventCompleteToUpper");
        if (this.mControlLinkProperty.getBWDLCallback() == null) goto L6;
        this.mControlLinkProperty.getBWDLCallback().onEventComplete(this);
        return;
    }

    public void sendEventFailToUpper() {
        BWDLLog.d(TAG, "sendEventFailToUpper");
        if (this.mControlLinkProperty.getBWDLCallback() == null) goto L6;
        this.mControlLinkProperty.getBWDLCallback().onEventFail(this);
        return;
    }

    public boolean sendMessageToHandler(int r8, int r10, int r11, Object r12) {
        BWDLLog.d(TAG, "sendMessageToHandler");
        if (this.mControlLinkSM.getCurrentSmState() != BWDLInnerConstant.ControlLinkSmState.ActiveState) goto L6;
        this.mControlLinkSM.getControlLinkHandler().sendMessageWithParam(r8, r10, r11, r12);
        return true;
    L6:
        return false;
    }

    public boolean sendMessageToHandlerDelay(int r8, int r10, int r11, Object r12, long r13) {
        BWDLLog.d(TAG, "sendMessageToHandlerDelay");
        if (this.mControlLinkSM.getCurrentSmState() != BWDLInnerConstant.ControlLinkSmState.ActiveState) goto L6;
        this.mControlLinkSM.getControlLinkHandler().sendMessageWithParamDelay(r8, r10, r11, r12, r13);
        return true;
    L6:
        return false;
    }

    public boolean write(byte[] r10) {
        BWDLLog.d(TAG, "writeData");
        if (r10 != null) goto L5;
        return false;
    L5:
        byte[] r11 = BWDLCommandBuilder.buildCustomizedWriteCmd(this.mControlLinkProperty.getPeerCID(), r10);
        sendMessageToHandlerDelay(6, 0, 0, r11, 3000);
        return sendMessageToHandler(5, 0, 0, r11);
    }
}
