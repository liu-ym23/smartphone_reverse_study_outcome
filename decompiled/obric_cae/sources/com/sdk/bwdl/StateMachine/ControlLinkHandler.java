package com.sdk.bwdl.StateMachine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.sdk.bwdl.AdapterLayer.GATT.GattAdapter.GattOriginal;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapter;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.BWDLDeviceManager;
import com.sdk.bwdl.ControlLinkProperty;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.sdk.bwdl.Utils.BWDLLog;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class ControlLinkHandler {
    private static final int MSG_BOND_STATE_CHANGE = 2;
    public static final int MSG_BWDL_COMMAND = 5;
    public static final int MSG_COMMAND_TIMEOUT = 6;
    private static final int MSG_CONNECTION_STATE_CHANGE = 1;
    private static final int MSG_RECEIVE_DATA = 4;
    public static final int MSG_SM_STATE_CHANGE = 7;
    private static final int MSG_WRITE_COMPLETE = 3;
    private static final String TAG = "ControlLinkEventHandler";
    private BWDLAdapterEventHandler mAdapterEventHandler;
    private HandlerThread mAdapterEventHandlerThread;
    private BWDLAdapterEventListener mAdapterEventListener;
    private IBWDLAdapter mBWDLAdapter;
    private BWDLDeviceManager mBWDLDeviceManager;
    private BWDLEventAnalyzer mBWDLEventAnalyzer;
    private Queue<byte[]> mCommandQueue;
    private Context mContext;
    private ControlLinkSM mControlLinkSM;
    private BWDLDevice mDevice;
    private ControlLinkSMListener mSMListener;

    /* JADX INFO: renamed from: com.sdk.bwdl.StateMachine.ControlLinkHandler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class BWDLAdapterEventHandler extends Handler {
        private ControlLinkProperty mControlLinkProperty;
        final /* synthetic */ ControlLinkHandler this$0;

        private BWDLAdapterEventHandler(ControlLinkHandler r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
            this.mControlLinkProperty = null;
        }

        @Override // android.os.Handler
        @SuppressLint({"MissingPermission"})
        public void handleMessage(Message r8) {
            BWDLLog.d(ControlLinkHandler.TAG, "handleMessage: " + ControlLinkHandler.access$300(this.this$0, r8.what));
            switch(r8.what) {
                case 1: goto L46;
                case 2: goto L45;
                case 3: goto L32;
                case 4: goto L18;
                case 5: goto L13;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L62;
            };
        L8:
            byte[] r10 = (byte[]) r8.obj;
            ControlLinkHandler.access$800(this.this$0);
            ControlLinkProperty r11 = ControlLinkHandler.access$800(this.this$0).findControlLinkByPeerCID(BWDLEventAnalyzer.getCID(r10));
            this.mControlLinkProperty = r11;
            if (r11 != null) goto L11;
            return;
        L11:
            if (ControlLinkHandler.access$500(this.this$0).contains(r10) == false) goto L52;
            this.mControlLinkProperty.getControlLink().sendEventFailToUpper();
            ControlLinkHandler.access$500(this.this$0).remove(r10);
            return;
        L52:
            return;
        L13:
            byte[] r12 = (byte[]) r8.obj;
            if (ControlLinkHandler.access$500(this.this$0).peek() != null) goto L16;
            ControlLinkHandler.access$500(this.this$0).offer(r12);
            ControlLinkHandler.access$700(this.this$0).send(ControlLinkHandler.access$600(this.this$0), r12);
            String r13 = "Command queue is empty, send cmd directly";
        L17:
            BWDLLog.d(ControlLinkHandler.TAG, r13);
            return;
        L16:
            ControlLinkHandler.access$500(this.this$0).offer(r12);
            r13 = "Command is queued";
            goto L17
        L18:
            byte[] r14 = (byte[]) r8.obj;
            if (BWDLEventAnalyzer.isBWDLInnerEvent(r14) == true) goto L21;
            ControlLinkProperty r15 = ControlLinkHandler.access$800(this.this$0).findControlLinkByCID(BWDLEventAnalyzer.getCID(r14));
            this.mControlLinkProperty = r15;
            if (r15 == null) goto L57;
            r15.getControlLink().sendDataReceiveToUpper(BWDLEventAnalyzer.getMetadata(r14));
            return;
        L57:
            return;
        L21:
            if (ControlLinkHandler.access$800(this.this$0) != null) goto L23;
        L27:
            BWDLLog.e(ControlLinkHandler.TAG, "mBWDLEventAnalyzer:" + ControlLinkHandler.access$800(this.this$0) + " mControlLinkSM:" + ControlLinkHandler.access$400(this.this$0) + " mDevice:" + ControlLinkHandler.access$600(this.this$0));
            return;
        L23:
            if (ControlLinkHandler.access$400(this.this$0) == null) goto L27;
            if (ControlLinkHandler.access$600(this.this$0) == null) goto L27;
            ControlLinkHandler.access$800(this.this$0).processBWDLEvent(r14, ControlLinkHandler.access$400(this.this$0), ControlLinkHandler.access$600(this.this$0));
            return;
        L45:
            ControlLinkSM r16 = ControlLinkHandler.access$400(this.this$0);
            int r17 = r8.arg1;
            Object r18 = r8.obj;
            int r19 = BWDLInnerConstant.BondStateChange;
        L47:
            r16.sendMessage(r19, r17, 0, r18);
            return;
        L46:
            r17 = r8.arg1;
            r16 = ControlLinkHandler.access$400(this.this$0);
            r19 = 300;
            r18 = r8.obj;
            goto L47
        L62:
            return;
        L6:
            if (((BWDLInnerConstant.ControlLinkSmState) r8.obj) != BWDLInnerConstant.ControlLinkSmState.DisconnectedState) goto L49;
            this.this$0.cleanup();
            return;
        L49:
            return;
        L32:
            if (ControlLinkHandler.access$500(this.this$0).peek() == null) goto L63;
            ControlLinkHandler.access$800(this.this$0);
            this.mControlLinkProperty = ControlLinkHandler.access$800(this.this$0).findControlLinkByPeerCID(BWDLEventAnalyzer.getCID((byte[]) ControlLinkHandler.access$500(this.this$0).peek()));
            if (r8.arg1 != 1) goto L44;
            ControlLinkHandler.access$800(this.this$0);
            if (BWDLEventAnalyzer.isBWDLInnerEvent((byte[]) ControlLinkHandler.access$500(this.this$0).peek()) == false) goto L39;
        L41:
            ControlLinkHandler.access$500(this.this$0).poll();
            if (ControlLinkHandler.access$500(this.this$0).peek() == null) goto L59;
            ControlLinkHandler.access$700(this.this$0).send(ControlLinkHandler.access$600(this.this$0), (byte[]) ControlLinkHandler.access$500(this.this$0).peek());
            return;
        L59:
            return;
        L39:
            if (this.mControlLinkProperty == null) goto L41;
            removeMessages(6, ControlLinkHandler.access$500(this.this$0).peek());
            this.mControlLinkProperty.getControlLink().sendEventCompleteToUpper();
            goto L41
        L44:
            ControlLinkHandler.access$700(this.this$0).send(ControlLinkHandler.access$600(this.this$0), (byte[]) ControlLinkHandler.access$500(this.this$0).peek());
            return;
        }

        public /* synthetic */ BWDLAdapterEventHandler(ControlLinkHandler r8, Looper r10, AnonymousClass1 r11) {
            this(r8, r10);
        }
    }

    public class BWDLAdapterEventListener implements IBWDLAdapterEventListener {
        final /* synthetic */ ControlLinkHandler this$0;

        private BWDLAdapterEventListener(ControlLinkHandler r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onBondStateChanged(BWDLDevice r8, int r10) {
            this.this$0.sendMessageWithParam(2, r10, 0, r8);
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onConnectTimeOut(IBWDLAdapter r8) {
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onConnected(IBWDLAdapter r8) {
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onConnectionStateChanged(BWDLDevice r8, int r10) {
            this.this$0.sendMessageWithParam(1, r10, 0, r8);
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onDataReceived(byte[] r8) {
            this.this$0.sendMessageWithParam(4, 0, 0, r8);
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onDisconnected(IBWDLAdapter r8) {
        }

        @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener
        public void onWriteComplete(int r8) {
            this.this$0.sendMessageWithParam(3, r8, 0, null);
        }

        public /* synthetic */ BWDLAdapterEventListener(ControlLinkHandler r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class ControlLinkSMListener implements ControlLinkSM.IControlLinkSMListener {
        final /* synthetic */ ControlLinkHandler this$0;

        private ControlLinkSMListener(ControlLinkHandler r8) {
            this.this$0 = r8;
        }

        @Override // com.sdk.bwdl.StateMachine.ControlLinkSM.IControlLinkSMListener
        public void onStateChanged(BWDLDevice r8, BWDLInnerConstant.ControlLinkSmState r10, BWDLInnerConstant.ControlLinkSmState r11, int r12) {
            BWDLLog.d(ControlLinkHandler.TAG, "ControlLinkSM transform：" + r10 + " to " + r11);
            if (ControlLinkHandler.access$900(this.this$0) == null) goto L6;
            this.this$0.sendMessageWithParam(7, 0, 0, r11);
            return;
        }

        public /* synthetic */ ControlLinkSMListener(ControlLinkHandler r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public ControlLinkHandler(Context r8, ControlLinkSM r10, BWDLDevice r11) {
        this.mContext = r8;
        this.mControlLinkSM = r10;
        this.mDevice = r11;
        HandlerThread r12 = new HandlerThread("Control Link Event Handler");
        this.mAdapterEventHandlerThread = r12;
        r12.start();
        this.mAdapterEventHandler = new BWDLAdapterEventHandler(this, this.mAdapterEventHandlerThread.getLooper(), null);
        init();
    }

    public static /* synthetic */ String access$300(ControlLinkHandler r8, int r10) {
        return r8.transformIntegerToString(r10);
    }

    public static /* synthetic */ ControlLinkSM access$400(ControlLinkHandler r8) {
        return r8.mControlLinkSM;
    }

    public static /* synthetic */ Queue access$500(ControlLinkHandler r8) {
        return r8.mCommandQueue;
    }

    public static /* synthetic */ BWDLDevice access$600(ControlLinkHandler r8) {
        return r8.mDevice;
    }

    public static /* synthetic */ IBWDLAdapter access$700(ControlLinkHandler r8) {
        return r8.mBWDLAdapter;
    }

    public static /* synthetic */ BWDLEventAnalyzer access$800(ControlLinkHandler r8) {
        return r8.mBWDLEventAnalyzer;
    }

    public static /* synthetic */ HandlerThread access$900(ControlLinkHandler r8) {
        return r8.mAdapterEventHandlerThread;
    }

    private void init() {
        this.mCommandQueue = new LinkedList();
        this.mBWDLDeviceManager = BWDLDeviceManager.getInstance(this.mContext);
        this.mBWDLEventAnalyzer = new BWDLEventAnalyzer(this.mContext, this.mControlLinkSM);
        AnonymousClass1 r8 = null;
        this.mAdapterEventListener = new BWDLAdapterEventListener(this, r8);
        if (this.mDevice.getConnectivityType() != BWDLInnerConstant.ConnectivityType.GATT) goto L5;
        GattOriginal r10 = GattOriginal.getInstance(this.mContext);
        this.mBWDLAdapter = r10;
        r10.setBWDLAdapterEventListener(this.mDevice, this.mAdapterEventListener);
    L5:
        ControlLinkSMListener r11 = new ControlLinkSMListener(this, r8);
        this.mSMListener = r11;
        this.mControlLinkSM.setControlLinkSMListener(r11);
    }

    private String transformIntegerToString(int r8) {
        switch(r8) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        return "Unknown";
    L5:
        return "MSG_SM_STATE_CHANGE";
    L7:
        return "MSG_COMMAND_TIMEOUT";
    L9:
        return "MSG_BWDL_COMMAND";
    L11:
        return "MSG_RECEIVE_DATA";
    L13:
        return "MSG_WRITE_COMPLETE";
    L15:
        return "MSG_BOND_STATE_CHANGE";
    L17:
        return "MSG_CONNECTION_STATE_CHANGE";
    }

    public void cleanup() {
        BWDLLog.d(TAG, "cleanup");
        this.mControlLinkSM.removeControlLinkSMListener(this.mSMListener);
        IBWDLAdapter r8 = this.mBWDLAdapter;
        if (r8 == null) goto L5;
        r8.removeBWDLAdapterEventListener(this.mAdapterEventListener);
    L5:
        Queue<byte[]> r10 = this.mCommandQueue;
        if (r10 == null) goto L8;
        r10.clear();
    L8:
        HandlerThread r11 = this.mAdapterEventHandlerThread;
        if (r11 == null) goto L12;
        r11.quitSafely();
        this.mAdapterEventHandlerThread = null;
        return;
    }

    public void sendMessageWithParam(int r8, int r10, int r11, Object r12) {
        Message.obtain(this.mAdapterEventHandler, r8, r10, r11, r12).sendToTarget();
    }

    public void sendMessageWithParamDelay(int r8, int r10, int r11, Object r12, long r13) {
        Message r14 = Message.obtain(this.mAdapterEventHandler, r8, r10, r11, r12);
        this.mAdapterEventHandler.sendMessageDelayed(r14, r13);
    }
}
