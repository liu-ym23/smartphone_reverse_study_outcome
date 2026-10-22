package com.obric.cae.smartNetwork.networkRateLimit;

import androidx.activity.k;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import defpackage.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class AppRateLimitManager {
    private static final int CONFIG_BATCH_SIZE = 10;
    private static final String TAG = "AppRateLimitManager";
    private static final int UID_LIMITED_SOCK_TIMEOUT_THRESHOLD = 10;
    private final ConcurrentHashMap<Integer, AppRateLimitInfo> mAppRateLimitInfoMap;
    private Thread mConfigThread;
    private final TrafficControlConfig mNetTCConfig;

    public static class AppRateLimitInfo {
        TrafficControlConfig.AppClassType classType;
        ConcurrentHashMap<Integer, TrafficControlConfig.UidSocketInfo> delSockMaps;
        AtomicBoolean isNeedToConfig;
        AtomicBoolean isNeedToRemove;
        ConcurrentHashMap<Integer, TrafficControlConfig.UidSocketInfo> limitedSockMaps;
        ConcurrentHashMap<Integer, TrafficControlConfig.UidSocketInfo> newSockMaps;
        int rateLimit;
        int uid;

        public AppRateLimitInfo(int r8, int r10, TrafficControlConfig.AppClassType r11) {
            this.isNeedToConfig = new AtomicBoolean(false);
            this.isNeedToRemove = new AtomicBoolean(false);
            this.uid = r8;
            this.limitedSockMaps = new ConcurrentHashMap();
            this.newSockMaps = new ConcurrentHashMap();
            this.delSockMaps = new ConcurrentHashMap();
            this.rateLimit = r10;
            this.classType = r11;
            this.isNeedToConfig.set(true);
        }

        public void add(List<TrafficControlConfig.UidSocketInfo> r8) {
            Iterator<TrafficControlConfig.UidSocketInfo> r10 = r8.iterator();
        L4:
            if (r10.hasNext() == false) goto L17;
            TrafficControlConfig.UidSocketInfo r11 = r10.next();
            if (this.limitedSockMaps.containsKey(Integer.valueOf(r11.getKey())) == true) goto L7;
            if (this.newSockMaps.containsKey(Integer.valueOf(r11.getKey())) == true) goto L4;
            if (this.delSockMaps.containsKey(Integer.valueOf(r11.getKey())) == true) goto L4;
            this.newSockMaps.put(Integer.valueOf(r11.getKey()), r11);
            this.isNeedToConfig.set(true);
            goto L4
        L7:
            TrafficControlConfig.UidSocketInfo r12 = this.limitedSockMaps.get(Integer.valueOf(r11.getKey()));
            if (r12 == null) goto L4;
            r12.timeOutCnt = 0;
            goto L4
        }
    }

    public AppRateLimitManager(TrafficControlConfig r8) {
        this.mAppRateLimitInfoMap = new ConcurrentHashMap();
        this.mNetTCConfig = r8;
    }

    public static /* synthetic */ void a(AppRateLimitManager r8) {
        r8.lambda$config$0();
    }

    private /* synthetic */ void lambda$config$0() {
        Iterator<Map.Entry<Integer, AppRateLimitInfo>> r8 = this.mAppRateLimitInfoMap.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L15;
        AppRateLimitInfo r10 = r8.next().getValue();
        if (r10.isNeedToConfig.get() == false) goto L4;
        if (r10.delSockMaps.isEmpty() == true) goto L12;
        CaeLog.i(TAG, "remove delSockMaps, uid " + r10.uid + " delSockMaps size: " + r10.delSockMaps.size());
        this.mNetTCConfig.removeRateLimit(r10.delSockMaps);
        r10.delSockMaps.clear();
    L12:
        if (r10.isNeedToRemove.get() == true) goto L13;
        processBatchSocketsConfig(r10);
        r10.isNeedToConfig.set(false);
        goto L4
    L13:
        CaeLog.i(TAG, "remove uid " + r10.uid + " from mAppRateLimitInfoMap");
        r10.isNeedToConfig.set(false);
        r10.isNeedToRemove.set(false);
        this.mNetTCConfig.removeClassId(r10.uid);
        r8.remove();
        goto L4
    L15:
        this.mConfigThread = null;
    }

    private void processBatchSocketsConfig(AppRateLimitInfo r10) {
        String r8 = this.mNetTCConfig.getTargetIfName();
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "targetIfName is null, skip config");
        return;
    L6:
        ArrayList r11 = new ArrayList();
        if (r10.newSockMaps.size() <= 10) goto L10;
        CaeLog.i(TAG, "newSockMaps is too big, size: " + r10.newSockMaps.size() + ", batchSize: 10");
    L10:
        if (r10.newSockMaps.isEmpty() == true) goto L35;
        ConcurrentHashMap<Integer, TrafficControlConfig.UidSocketInfo> r12 = new ConcurrentHashMap();
        Iterator<Map.Entry<Integer, TrafficControlConfig.UidSocketInfo>> r13 = r10.newSockMaps.entrySet().iterator();
    L13:
        if (r13.hasNext() == false) goto L18;
        if (r12.size() >= 10) goto L18;
        Map.Entry<Integer, TrafficControlConfig.UidSocketInfo> r14 = r13.next();
        r12.put(r14.getKey(), r14.getValue());
    L18:
        if (r12.isEmpty() == true) goto L35;
        if (this.mNetTCConfig.setUidRateLimit(r10.uid, r12, r10.rateLimit, r10.classType) == false) goto L33;
        r11.addAll(r12.values());
        Iterator<Integer> r15 = r12.keySet().iterator();
    L24:
        if (r15.hasNext() == false) goto L26;
        r10.newSockMaps.remove(r15.next());
        goto L24
    L26:
        r10.limitedSockMaps.putAll(r12);
        if (r10.newSockMaps.isEmpty() == true) goto L10;
        Thread.sleep(10);     // Catch: InterruptedException -> L31
    L31:
        e = move-exception;
        CaeLog.e(TAG, "sleep interrupted", e);
        goto L10
    L33:
        StringBuilder r16 = new StringBuilder("config failed, uid ");
        r16.append(r10.uid);
        r16.append(" rate is ");
        b.p(r16, r10.rateLimit, TAG);
    L35:
        if (r11.isEmpty() == true) goto L64;
        ArrayList r17 = new ArrayList();
        Iterator r18 = r11.iterator();
    L37:
        boolean r19 = true;
        if (r18.hasNext() == false) goto L44;
        TrafficControlConfig.UidSocketInfo r20 = (TrafficControlConfig.UidSocketInfo) r18.next();
        if (r20.srcIP.indexOf(58) == (-1)) goto L43;
        r19 = false;
    L43:
        r17.add(new TcFilterParser.PortRequest(r19, r20.srcPort));
        goto L37
    L44:
        Map<String, TcFilterParser.FilterHandles> r21 = TcFilterParser.getHandlesByFilterLog(r8, r17);
        Iterator r110 = r11.iterator();
    L46:
        if (r110.hasNext() == false) goto L89;
        TrafficControlConfig.UidSocketInfo r22 = (TrafficControlConfig.UidSocketInfo) r110.next();
        if (r22.srcIP.indexOf(58) != (-1)) goto L50;
        boolean r23 = true;
    L51:
        StringBuilder r24 = new StringBuilder();
        if (r23 == false) goto L54;
        String r25 = "v4:";
    L55:
        r24.append(r25);
        r24.append(r22.srcPort);
        TcFilterParser.FilterHandles r26 = r21.get(r24.toString());
        if (r26 == null) goto L62;
        String r27 = r26.outputHandle;
        if (r27 == null) goto L62;
        r22.outputHandleId = r27;
        r22.inputHandleId = r26.inputHandle;
        StringBuilder r28 = android.aimedia.a.l("setUidRateLimit, isIpv4: ", r23, ", port: ");
        r28.append(r22.srcPort);
        r28.append(", outputHandleId: ");
        r28.append(r22.outputHandleId);
        r28.append(", inputHandleId: ");
        android.aimedia.a.r(r28, r22.inputHandleId, TAG);
        if (r22.inputHandleId != null) goto L46;
        StringBuilder r29 = new StringBuilder("Failed to get complete handles, output: ");
        r29.append(r22.outputHandleId);
        r29.append(", input: ");
        r29.append(r22.inputHandleId);
    L63:
        CaeLog.e(TAG, r29.toString());
    L62:
        r29 = new StringBuilder("Failed to get outputHandle for port ");
        r29.append(r22.srcPort);
        goto L63
    L54:
        r25 = "v6:";
        goto L55
    L50:
        r23 = false;
        goto L51
    L89:
        return;
    }

    public void clear() {
        this.mAppRateLimitInfoMap.clear();
    }

    public void config(ConcurrentHashMap<Integer, RateControlManager.UidRateControlInfo> r8) {
        Thread r10 = this.mConfigThread;
        if (r10 != null) goto L5;
    L13:
        Thread r11 = new Thread(new k(this, 22), "UidTrafficControlSetThread");     // Catch: RuntimeException -> L10
        this.mConfigThread = r11;     // Catch: RuntimeException -> L10
        r11.setDaemon(true);     // Catch: RuntimeException -> L10
        this.mConfigThread.start();     // Catch: RuntimeException -> L10
        return;
    L10:
        e = move-exception;
        CaeLog.e(TAG, "config thread error", e);
        this.mConfigThread = null;
        return;
    L5:
        if (r10.isAlive() == false) goto L13;
        CaeLog.i(TAG, "config thread is running");
    }

    public void needToConfig(int r8) {
        AppRateLimitInfo r10 = this.mAppRateLimitInfoMap.get(Integer.valueOf(r8));
        if (r10 == null) goto L6;
        r10.isNeedToConfig.set(true);
        return;
    }

    public void push(int r8, int r10, List<TrafficControlConfig.UidSocketInfo> r11, boolean r12, TrafficControlConfig.AppClassType r13) {
        AppRateLimitInfo r14 = this.mAppRateLimitInfoMap.get(Integer.valueOf(r8));
        if (r14 != null) goto L6;
        AppRateLimitInfo r15 = new AppRateLimitInfo(r8, r10, r13);
        r15.add(r11);
        this.mAppRateLimitInfoMap.put(Integer.valueOf(r8), r15);
        CaeLog.i(TAG, "add uid " + r8 + " rateLimit " + r10 + " classType " + r13 + " mAppRateLimitInfoMap size " + this.mAppRateLimitInfoMap.size());
        return;
    L6:
        r14.add(r11);
        if (r14.classType == r13) goto L9;
        r14.classType = r13;
        r14.isNeedToConfig.set(true);
    L9:
        int r16 = r14.rateLimit;
        if (r16 == r10) goto L16;
        if (r12 == false) goto L13;
    L14:
        r14.isNeedToConfig.set(true);
        r14.rateLimit = r10;
        StringBuilder r17 = defpackage.a.g("Rate update uid ", r8, " rateLimit ", r10, " isForceRate ");
        r17.append(r12);
        CaeLog.i(TAG, r17.toString());
        return;
    L13:
        if (Math.abs(r16 - r10) > 5000) goto L14;
        return;
    }

    public void remove(int r8) {
        AppRateLimitInfo r10 = this.mAppRateLimitInfoMap.get(Integer.valueOf(r8));
        if (r10 != null) goto L5;
        return;
    L5:
        r10.isNeedToRemove.set(true);
        r10.delSockMaps.putAll(r10.limitedSockMaps);
        r10.delSockMaps.putAll(r10.newSockMaps);
        r10.limitedSockMaps.clear();
        r10.newSockMaps.clear();
        r10.isNeedToConfig.set(true);
    }

    public void updateUidSockInfoTimeoutCnt() {
        Iterator<AppRateLimitInfo> r8 = this.mAppRateLimitInfoMap.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        AppRateLimitInfo r10 = r8.next();
        Iterator<TrafficControlConfig.UidSocketInfo> r11 = r10.limitedSockMaps.values().iterator();
    L7:
        if (r11.hasNext() == false) goto L4;
        TrafficControlConfig.UidSocketInfo r12 = r11.next();
        int r13 = r12.timeOutCnt + 1;
        r12.timeOutCnt = r13;
        if (r13 < 10) goto L7;
        r11.remove();
        r10.delSockMaps.put(Integer.valueOf(r12.getKey()), r12);
        r10.isNeedToConfig.set(true);
        CaeLog.i(TAG, "socket timeout, move sock " + r12.srcIP + BdimCategoryConstants.SEPARATOR_COLON + r12.srcPort + " outputHandleId " + r12.outputHandleId + " inputHandleId " + r12.inputHandleId + " to delSockMaps");
        goto L7
    }
}
