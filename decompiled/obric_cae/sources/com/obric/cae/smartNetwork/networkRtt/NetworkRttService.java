package com.obric.cae.smartNetwork.networkRtt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import com.obric.cae.libs.networkRtt.ICaeNetworkRtt;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkRttService extends ICaeNetworkRtt.Stub {
    private static final int RTT_UNAVAILABLE = -1;
    private static final String TAG = "NetworkRttService";
    private final Context mContext;
    private final L4NetEvaluate mL4NetEvaluate;

    public NetworkRttService(Context r8, L4NetEvaluate r10) {
        this.mContext = r8;
        this.mL4NetEvaluate = r10;
    }

    private String getDefaultNetworkIfName() {
        ConnectivityManager r8 = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        if (r8 != null) goto L5;
        return null;
    L5:
        Network r10 = r8.getActiveNetwork();
        if (r10 != null) goto L8;
        return null;
    L8:
        LinkProperties r11 = r8.getLinkProperties(r10);
        if (r11 != null) goto L12;
        return null;
    L12:
        return r11.getInterfaceName();
    }

    private int getDefaultNetworkRtt() {
        if (this.mL4NetEvaluate != null) goto L6;
        CaeLog.e(TAG, "getDefaultNetworkRtt: L4NetEvaluate is null");
        return -1;
    L6:
        String r8 = getDefaultNetworkIfName();
        if (r8 != null) goto L10;
        CaeLog.d(TAG, "getDefaultNetworkRtt: ifName is null");
        return -1;
    L10:
        ConcurrentHashMap<String, L4NetEvaluate.L4NetStats> r10 = this.mL4NetEvaluate.getNetifRttCache();
        if (r10 != null) goto L13;
    L22:
        CaeLog.d(TAG, "getDefaultNetworkRtt: cache empty, ifName=".concat(r8));
        return -1;
    L13:
        if (r10.isEmpty() == true) goto L22;
        L4NetEvaluate.L4NetStats r11 = r10.get(r8);
        if (r11 != null) goto L18;
        return -1;
    L18:
        int r12 = r11.rttAve;
        if (r12 > 0) goto L21;
        return -1;
    L21:
        return r12;
    }

    @Override // com.obric.cae.libs.networkRtt.ICaeNetworkRtt
    public int getGameRttbyUid(int r8) {
        return getDefaultNetworkRtt();
    }

    @Override // com.obric.cae.libs.networkRtt.ICaeNetworkRtt
    public int getRttByUid(int r8) {
        L4NetEvaluate r10 = this.mL4NetEvaluate;
        if (r10 != null) goto L6;
        CaeLog.e(TAG, "getRttByUid: L4NetEvaluate is null");
        return -1;
    L6:
        L4NetEvaluate.L4NetStats r11 = r10.getUidRttCache(r8);
        if (r11 != null) goto L10;
        CaeLog.d(TAG, "getRttByUid: uid=" + r8 + " no cache");
        return -1;
    L10:
        int r12 = r11.rttAve;
        if (r12 > 0) goto L13;
        return -1;
    L13:
        return r12;
    }
}
