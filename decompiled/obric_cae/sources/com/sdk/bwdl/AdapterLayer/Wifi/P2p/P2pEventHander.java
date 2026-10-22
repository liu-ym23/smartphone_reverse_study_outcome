package com.sdk.bwdl.AdapterLayer.Wifi.P2p;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes2.dex */
public class P2pEventHander {
    private static final String TAG = "P2pAdapter";
    private static EventHander mEventHander;
    private Context mContext;
    private HandlerThread mHandlerThread;
    private final P2pAdapter mP2PAdapter;
    private P2pController mP2PController;

    public class EventHander extends Handler {
        final /* synthetic */ P2pEventHander this$0;

        public EventHander(P2pEventHander r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            int r10 = r8.what;
            if (r10 == 2) goto L26;
            if (r10 == 3) goto L23;
            if (r10 != 8) goto L9;
            BWDLDevice r11 = new BWDLDevice(BWDLInnerConstant.ConnectivityType.P2P, (P2pDevice) r8.obj);
            if (P2pEventHander.access$100(this.this$0) == null) goto L33;
            P2pEventHander.access$100(this.this$0).sendConnectionStateToUpper(r11, 4);
            return;
        L33:
            return;
        L9:
            if (r10 != 9) goto L11;
            BWDLDevice r12 = new BWDLDevice(BWDLInnerConstant.ConnectivityType.P2P, (P2pDevice) r8.obj);
            if (P2pEventHander.access$100(this.this$0) == null) goto L31;
            P2pEventHander.access$100(this.this$0).sendConnectionStateToUpper(r12, 2);
            return;
        L31:
            return;
        L11:
            if (r10 == 11) goto L14;
            return;
        L14:
            if (P2pEventHander.access$100(this.this$0) == null) goto L29;
            P2pEventHander.access$100(this.this$0).sendP2pGroupIpAvailableToUpper((InetAddress) r8.obj);
            return;
        L29:
            return;
        L23:
            if (P2pEventHander.access$100(this.this$0) == null) goto L35;
            P2pEventHander.access$100(this.this$0).sendP2pGroupAvailableToUpper((WifiP2pGroup) r8.obj);
            return;
        L35:
            return;
        L26:
            if (P2pEventHander.access$000(this.this$0) == null) goto L37;
            P2pEventHander.access$000(this.this$0).requestGroupInfo();
            return;
        }
    }

    public P2pEventHander(Context r8, P2pAdapter r10, int r11) {
        this.mContext = r8;
        this.mP2PAdapter = r10;
        HandlerThread r12 = new HandlerThread("p2p event hander");
        this.mHandlerThread = r12;
        r12.start();
        mEventHander = new EventHander(this, this.mHandlerThread.getLooper());
        init(r8, r11);
    }

    public static /* synthetic */ P2pController access$000(P2pEventHander r8) {
        return r8.mP2PController;
    }

    public static /* synthetic */ P2pAdapter access$100(P2pEventHander r8) {
        return r8.mP2PAdapter;
    }

    private void init(Context r8, int r10) {
        P2pController r11 = P2pController.getInstance(r8, r10);
        this.mP2PController = r11;
        r11.registerMsgHander(mEventHander);
    }

    public static void sendMessageWithParam(int r8) {
        Message.obtain(mEventHander, r8).sendToTarget();
    }

    public static void sendMessageWithParam(int r8, Object r10) {
        Message.obtain(mEventHander, r8, r10).sendToTarget();
    }
}
