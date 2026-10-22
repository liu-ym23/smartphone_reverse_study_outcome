package com.obric.cae.BWDL.BwdlDrop;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.obric.cae.BWDL.BwdlDrop.fileTransmission.BwdlDropCmdGenerator;
import com.obric.cae.BWDL.BwdlDrop.fileTransmission.BwdlDropMessageAnalyzer;
import com.obric.cae.BWDL.BwdlDrop.fileTransmission.FileInfoTransmission;
import com.obric.cae.log.CaeLog;
import com.sdk.bwdl.ControlLink;
import com.sdk.bwdl.DataLink;
import com.sdk.bwdl.ExternalAPI.BWDLDiscoveryData;
import com.sdk.bwdl.Utils.BWDLLog;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropEventHandler {
    public static final int MSG_DEVICE_FOUND = 3;
    public static final int MSG_EVENT_RECEIVE = 9;
    public static final int MSG_FILE_TRANSFER_FAIL = 8;
    public static final int MSG_FILE_TRANSFER_NOTIFY = 12;
    public static final int MSG_FILE_TRANSFER_REQUEST = 6;
    public static final int MSG_FILE_TRANSFER_RESPONSE = 7;
    public static final int MSG_REMOVE_CONTROL_LINK = 10;
    public static final int MSG_REMOVE_DATA_LINK = 11;
    public static final int MSG_START_ADV = 4;
    public static final int MSG_START_SCAN = 1;
    public static final int MSG_STOP_ADV = 5;
    public static final int MSG_STOP_SCAN = 2;
    private static final String TAG = "BwdlDropEventHandler";
    private BwdlDropDiscoveryEngine mBwdlDropDiscoveryEngine;
    private BwdlDropManager mBwdlDropManager;
    private Context mContext;
    private EventHandler mEventHandler;
    private HandlerThread mEventHandlerThread;

    public class EventHandler extends Handler {
        final /* synthetic */ BwdlDropEventHandler this$0;

        public EventHandler(BwdlDropEventHandler r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            CaeLog.d(BwdlDropEventHandler.access$000(), "handleMessage: " + BwdlDropEventHandler.access$100(this.this$0, r8.what));
            BwdlDropEventHandler r10 = this.this$0;
            BwdlDropEventHandler.access$202(r10, BwdlDropManager.getInstance(BwdlDropEventHandler.access$300(r10)));
            BwdlDropMessageAnalyzer r11 = new BwdlDropMessageAnalyzer(BwdlDropEventHandler.access$300(this.this$0));
            switch(r8.what) {
                case 3: goto L23;
                case 4: goto L21;
                case 5: goto L20;
                case 6: goto L17;
                case 7: goto L14;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L5;
                default: goto L40;
            };
        L5:
            byte[] r12 = BwdlDropCmdGenerator.buildFileTransferNotify(BwdlDropEventHandler.access$300(this.this$0));
            if (r12.length == 0) goto L27;
            BwdlDropEventHandler.access$200(this.this$0).controlLinkWriteData(r12);
            return;
        L27:
            return;
        L8:
            BwdlDropEventHandler.access$200(this.this$0).disconnectDataLink((DataLink) r8.obj);
            return;
        L9:
            BwdlDropEventHandler.access$200(this.this$0).disconnectControlLink((ControlLink) r8.obj);
            return;
        L10:
            r11.processBwdlDropEvent(r8.arg2, (byte[]) r8.obj);
            return;
        L11:
            byte[] r13 = BwdlDropCmdGenerator.buildTransferFail(r8.arg2, (String) r8.obj);
            if (r13.length == 0) goto L33;
            BwdlDropEventHandler.access$200(this.this$0).controlLinkWriteData(r13);
            return;
        L33:
            return;
        L14:
            byte[] r14 = BwdlDropCmdGenerator.buildFileTransferResp((String) r8.obj);
            if (r14.length == 0) goto L35;
            BwdlDropEventHandler.access$200(this.this$0).controlLinkWriteData(r14);
            return;
        L35:
            return;
        L17:
            BwdlDropSession r15 = (BwdlDropSession) r8.obj;
            byte[] r16 = BwdlDropCmdGenerator.buildFileTransferReq(BwdlDropEventHandler.access$300(this.this$0), r15);
            if (r16.length == 0) goto L37;
            FileInfoTransmission.sendDataAsync(r15.getDeviceManager().getDataLinkDevice(), r16, BwdlDropEventHandler.access$200(this.this$0));
            return;
        L37:
            return;
        L20:
            BwdlDropDiscoveryEngine r17 = BwdlDropEventHandler.access$400(this.this$0);
            boolean r18 = false;
        L22:
            r17.advertising(r18);
            return;
        L21:
            r17 = BwdlDropEventHandler.access$400(this.this$0);
            r18 = true;
            goto L22
        L23:
            Iterator r19 = ((List) r8.obj).iterator();
        L25:
            if (r19.hasNext() == false) goto L41;
            BwdlDropEventHandler.access$200(this.this$0).sendDiscoveryDataToListener((BWDLDiscoveryData) r19.next());
            goto L25
        L41:
            return;
        }
    }

    public BwdlDropEventHandler(Context r8, BwdlDropDiscoveryEngine r10) {
        this.mContext = r8;
        HandlerThread r11 = new HandlerThread("Bwdl drop Event Handler");
        this.mEventHandlerThread = r11;
        r11.start();
        this.mEventHandler = new EventHandler(this, this.mEventHandlerThread.getLooper());
        this.mBwdlDropDiscoveryEngine = r10;
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ String access$100(BwdlDropEventHandler r8, int r10) {
        return r8.transformIntegerToString(r10);
    }

    public static /* synthetic */ BwdlDropManager access$200(BwdlDropEventHandler r8) {
        return r8.mBwdlDropManager;
    }

    public static /* synthetic */ BwdlDropManager access$202(BwdlDropEventHandler r8, BwdlDropManager r10) {
        r8.mBwdlDropManager = r10;
        return r10;
    }

    public static /* synthetic */ Context access$300(BwdlDropEventHandler r8) {
        return r8.mContext;
    }

    public static /* synthetic */ BwdlDropDiscoveryEngine access$400(BwdlDropEventHandler r8) {
        return r8.mBwdlDropDiscoveryEngine;
    }

    private String transformIntegerToString(int r8) {
        switch(r8) {
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            case 12: goto L5;
            default: goto L3;
        };
    L3:
        return "Unknown";
    L5:
        return "MSG_FILE_TRANSFER_NOTIFY";
    L7:
        return "MSG_REMOVE_DATA_LINK";
    L9:
        return "MSG_REMOVE_CONTROL_LINK";
    L11:
        return "MSG_EVENT_RECEIVE";
    L13:
        return "MSG_FILE_TRANSFER_FAIL";
    L15:
        return "MSG_FILE_TRANSFER_RESPONSE";
    L17:
        return "MSG_FILE_TRANSFER_REQUEST";
    L19:
        return "MSG_STOP_ADV";
    L21:
        return "MSG_START_ADV";
    L23:
        return "MSG_DEVICE_FOUND";
    }

    public void cleanup() {
        BWDLLog.d(TAG, "cleanup");
        HandlerThread r8 = this.mEventHandlerThread;
        if (r8 == null) goto L6;
        r8.quitSafely();
        return;
    }

    public void removeMessage(int r8, Object r10) {
        CaeLog.d(TAG, "removeMessage:" + transformIntegerToString(r8));
        this.mEventHandler.removeMessages(r8, r10);
    }

    public void sendMessageDelay(int r8, Object r10, long r11) {
        CaeLog.d(TAG, "sendMessageDelay:" + transformIntegerToString(r8));
        this.mEventHandler.sendMessageDelayed(Message.obtain(this.mEventHandler, r8, r10), r11);
    }

    public void sendMessageWithParam(int r8, int r10, int r11, Object r12) {
        Message.obtain(this.mEventHandler, r8, r10, r11, r12).sendToTarget();
    }
}
