package com.obric.cae.smartNetwork.netAccel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.os.Handler;
import android.os.Looper;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class NetPreception {
    private static final String TAG = null;
    private AtomicBoolean isRunning;
    private AccelConfigManager mAccelConfigManager;
    private final AccelControl mAccelControl;
    private final ConnectivityManager mConnectivityManager;
    private final L4NetEvaluate.L4NetErrReportCb mL4NetErrReportCb;
    private final L4NetEvaluate mL4NetEvaluate;
    private final L4NetEvaluate.L4NetErrReportCb mL4SpecificAppEvaluateCb;
    private MultiNetInfo mMultiNetInfo;
    private final ConcurrentMap<Integer, NetNode> mNetNodes;

    public class NetNode {
        private int mConsecutiveErrorCount;
        private int mConsecutiveGoodCount;
        private Runnable mDelayRunnable;
        private Handler mHandler;
        private boolean mIsWeakNetwork;
        final /* synthetic */ NetPreception this$0;

        private NetNode(NetPreception r8) {
            this.this$0 = r8;
            this.mIsWeakNetwork = false;
            this.mHandler = new Handler(Looper.getMainLooper());
            this.mConsecutiveErrorCount = 0;
            this.mConsecutiveGoodCount = 0;
        }

        public static /* synthetic */ void a(NetNode r8, String r10, String r11) {
            r8.lambda$enterWeak$0(r10, r11);
        }

        public static /* synthetic */ void access$300(NetNode r8, L4NetEvaluate.L4NetStats r10, int r11) {
            r8.onL4StatsUpdated(r10, r11);
        }

        private void enterAvailable(String r8, int r10) {
            if (this.mIsWeakNetwork == false) goto L6;
            CaeLog.i(NetPreception.access$000(), "Net " + r10 + "-" + r8 + " enter available, Allowing acceleration");
            this.mHandler.removeCallbacks(this.mDelayRunnable);
            NetPreception.access$700(this.this$0).denyNetAccel(r10, false);
            this.mIsWeakNetwork = false;
            return;
        }

        private void enterWeak(String r8, int r10) {
            if (this.mIsWeakNetwork == true) goto L6;
            String[] r11 = NetPreception.access$600(this.this$0, r8);
            final String r12 = r11[0];
            final String r13 = r11[1];
            CaeLog.i(NetPreception.access$000(), "Net" + r10 + "-" + r8 + ", Entering weak network state - denying current channel acceleration offloading");
            NetPreception.access$700(this.this$0).denyNetAccel(r10, true);
            CaeLog.i(NetPreception.access$000(), "Disconnecting 50% of current channel offloading, " + r12 + "-" + r13);
            NetPreception.access$700(this.this$0).disconnectSocket(r12, r13, NetPreception.access$500(this.this$0).getNetworkPerceptionReduceOffloadPercent()[0]);
            Runnable r14 = new g(this, r12, r13);
            this.mDelayRunnable = r14;
            this.mHandler.postDelayed(r14, (long) NetPreception.access$500(this.this$0).getNetworkPerceptionWeakThreshold());
            this.mIsWeakNetwork = true;
            return;
        }

        private /* synthetic */ void lambda$enterWeak$0(String r8, String r10) {
            CaeLog.i(NetPreception.access$000(), "Disconnecting 100% of current channel offloading, " + r8 + "-" + r10);
            NetPreception.access$700(this.this$0).disconnectSocket(r8, r10, NetPreception.access$500(this.this$0).getNetworkPerceptionReduceOffloadPercent()[1]);
        }

        private void onL4StatsUpdated(L4NetEvaluate.L4NetStats r8, int r10) {
            if (r8.errBitMap == 0) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L10;
            int r12 = this.mConsecutiveErrorCount + 1;
            this.mConsecutiveErrorCount = r12;
            this.mConsecutiveGoodCount = 0;
            if (r12 < NetPreception.access$500(this.this$0).getNetworkPerceptionWeakThreshold()) goto L14;
            enterWeak(r8.ifName, r10);
            return;
        L14:
            return;
        L10:
            int r13 = this.mConsecutiveGoodCount + 1;
            this.mConsecutiveGoodCount = r13;
            this.mConsecutiveErrorCount = 0;
            if (r13 < NetPreception.access$500(this.this$0).getNetworkPerceptionGoodThreshold()) goto L16;
            enterAvailable(r8.ifName, r10);
            return;
        L16:
            return;
        L5:
            r11 = false;
            goto L6
        }

        public /* synthetic */ NetNode(NetPreception r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    static {
        TAG = "MultiNetwork-NetPreception";
    }

    public NetPreception(Context r8, AccelControl r10) {
        this.mNetNodes = new ConcurrentHashMap();
        this.isRunning = new AtomicBoolean(false);
        this.mL4NetErrReportCb = new AnonymousClass1(this);
        this.mL4SpecificAppEvaluateCb = new AnonymousClass2(this);
        this.mAccelControl = r10;
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        this.mL4NetEvaluate = L4NetEvaluate.getInstance(r8);
        this.mAccelConfigManager = AccelConfigManager.getInstance(r8);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ MultiNetInfo access$100(NetPreception r8) {
        return r8.mMultiNetInfo;
    }

    public static /* synthetic */ ConcurrentMap access$200(NetPreception r8) {
        return r8.mNetNodes;
    }

    public static /* synthetic */ AccelConfigManager access$500(NetPreception r8) {
        return r8.mAccelConfigManager;
    }

    public static /* synthetic */ String[] access$600(NetPreception r8, String r10) {
        return r8.getIpAddressesFromInterface(r10);
    }

    public static /* synthetic */ AccelControl access$700(NetPreception r8) {
        return r8.mAccelControl;
    }

    private String[] getIpAddressesFromInterface(String r8) {
        Network[] r10 = this.mConnectivityManager.getAllNetworks();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        String r13 = "";
        if (r12 >= r11) goto L21;
        Network r14 = r10[r12];
        LinkProperties r15 = this.mConnectivityManager.getLinkProperties(r14);
        if (r15 == null) goto L20;
        if (r8.equals(r15.getInterfaceName()) == false) goto L20;
        Iterator<LinkAddress> r16 = r15.getLinkAddresses().iterator();
        String r17 = "";
    L12:
        if (r16.hasNext() == false) goto L23;
        LinkAddress r18 = r16.next();
        if ((r18.getAddress() instanceof Inet4Address) == true) goto L15;
        if ((r18.getAddress() instanceof Inet6Address) == false) goto L12;
        r17 = r18.getAddress().getHostAddress();
        String r19 = TAG;
        StringBuilder r20 = defpackage.b.h("ipv6: ", r17, ", ");
        r20.append(r18.toString());
        r20.append(", getScope:");
        r20.append(r18.getScope());
        r20.append(", getPrefixLength:");
        r20.append(r18.getPrefixLength());
        r20.append(", getFlags:");
        r20.append(r18.getFlags());
    L19:
        CaeLog.d(r19, r20.toString());
        goto L12
    L15:
        r13 = r18.getAddress().getHostAddress();
        r19 = TAG;
        r20 = defpackage.b.h("ipv4: ", r13, ", ");
        r20.append(r18.toString());
    L23:
        return new String[]{r13, r17};
    L20:
        r12 = r12 + 1;
        goto L3
    L21:
        r17 = "";
        goto L23
    }

    public void start(MultiNetInfo r8) {
        if (this.isRunning.get() == false) goto L7;
        CaeLog.e(TAG, "NetPreception is already running");
        return;
    L7:
        if (this.mAccelConfigManager.isNetworkPerceptionEnabled() == true) goto L10;
        CaeLog.e(TAG, "Network perception is disabled");
        return;
    L10:
        this.mMultiNetInfo = r8;
        Iterator<Map.Entry<Integer, MultiNetInfo.AccelNet>> r10 = r8.getAvailableNetMap().entrySet().iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        Map.Entry<Integer, MultiNetInfo.AccelNet> r11 = r10.next();
        this.mNetNodes.put(r11.getKey(), new NetNode(this, null));
        goto L12
    L14:
        this.mL4NetEvaluate.registerSpecificAppEvaluateCb(this.mL4SpecificAppEvaluateCb);
        this.mL4NetEvaluate.registerErrReportCb(this.mL4NetErrReportCb);
        this.mL4NetEvaluate.start();
        CaeLog.i(TAG, "NetPreception started");
        this.isRunning.set(true);
    }

    public void stop() {
        if (this.isRunning.get() == true) goto L6;
        CaeLog.e(TAG, "NetPreception is not running");
        return;
    L6:
        this.mL4NetEvaluate.stop();
        this.mL4NetEvaluate.unregisterSpecificAppEvaluateCb(this.mL4SpecificAppEvaluateCb);
        this.mL4NetEvaluate.unregisterErrReportCb(this.mL4NetErrReportCb);
        this.mNetNodes.clear();
        CaeLog.i(TAG, "NetPreception stopped");
        this.isRunning.set(false);
    }
}
