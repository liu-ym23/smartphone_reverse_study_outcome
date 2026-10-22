package com.obric.cae.cldReport;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.cae.caed.IEventListener;
import com.cae.caed.events.AntDivParcel;
import com.cae.caed.events.BlockUidRejectParcel;
import com.cae.caed.events.CaeRoamParcel;
import com.cae.caed.events.WakePacketParcel;
import com.cae.caed.events.WlanCrashParcel;
import com.google.protobuf.d;
import com.obric.cae.cldReport.bluetooth.BluetoothLogCollector;
import com.obric.cae.cldReport.gnss.GnssLogCollector;
import com.obric.cae.cldReport.network.NetworkLogCollector;
import com.obric.cae.cldReport.wifi.WifiLogCollector;
import com.obric.cae.libs.cldReport.ICldReportManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import com.obric.cae.smartNetwork.netPolicy.BlockUidRejectReporter;
import com.obric.cae.statusReport.wifi.CaeWifiStatusCollect;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class CldReportService extends Service {
    private static final int CLD_MSG_DO_REPORT_ERROR_EVENT = 5;
    private static final int CLD_MSG_REPORT_ERROR_EVENT = 1;
    private static final int CLD_MSG_RESTORE_ALL_LOG = 4;
    private static final int CLD_MSG_START_COLLECT = 2;
    private static final int CLD_MSG_STOP_COLLECT = 3;
    private static final String SERVICE_NAME_CLD_REPORT = "cae_cld_report";
    private static final String TAG = "CldReportService";
    private static final Pattern WIFI_CONNECT_SLOW_FORMATTED_START_TIME_PATTERN = null;
    private static final Pattern WIFI_CONNECT_SLOW_L2_TIME_PATTERN = null;
    private static final Pattern WIFI_CONNECT_SLOW_L3_TIME_PATTERN = null;
    private static final long WIFI_CONNECT_SLOW_MAX_TIME_MS = 60000;
    private static final String WIFI_CONNECT_SLOW_START_CONN_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final Pattern WIFI_CONNECT_SLOW_START_CONN_TIME_PATTERN = null;
    private static final String[] WIFI_DRIVER_LOAD_FAIL_PATTERNS = null;
    private static final int WIFI_DRIVER_LOGCAT_LINES = 2000;
    private static final long WIFI_DRIVER_LOGCAT_TIMEOUT_MS = 3000;
    private static final int WIFI_OPEN_FAIL_REASON_DRIVER = 1;
    private static final int WIFI_OPEN_FAIL_SUBREASON_DRIVER_LOAD_FAIL = 1;
    private static boolean mIsRestored;
    private final ICldReportManager.Stub mBinder;
    private final ConcurrentHashMap<IBinder, AbstractLogCollector> mCallbackLogCollectHashMap;
    private CldCommon mCldCommon;
    private HandlerThread mCldHandlerThread;
    private CldProcessHandler mCldProcessHandler;
    private Context mContext;
    private final ConcurrentHashMap<IBinder, CldCbDeathRecpnt> mDeathRecipLogCollectHashMap;
    private NefidEventListener mNefidEventListener;
    private boolean mNefidEventListenerRegistered;
    private NefidInterface mNefidInterface;
    private final ConcurrentHashMap<String, LinkedList<Long>> mReportLimitRecords;

    public class CldCbDeathRecpnt implements IBinder.DeathRecipient {
        private final IBinder mClientBinder;
        final /* synthetic */ CldReportService this$0;

        public CldCbDeathRecpnt(CldReportService r8, IBinder r10) {
            this.this$0 = r8;
            this.mClientBinder = r10;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            AbstractLogCollector r8 = (AbstractLogCollector) CldReportService.access$600(this.this$0).get(this.mClientBinder);
            if (r8 == null) goto L5;
            CaeLog.i(CldReportService.TAG, "Binder is dead, :" + this.mClientBinder + " logCollector summery=" + r8.mSummary.toString());
            r8.setOnStoped(true);
        L5:
            CldReportService.access$700(this.this$0, this.mClientBinder);
        }
    }

    public class CldProcessHandler extends Handler {
        final /* synthetic */ CldReportService this$0;

        public CldProcessHandler(CldReportService r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            int r10 = r8.what;
            if (r10 != 1) goto L5;
            ((AbstractLogCollector) r8.obj).collectAndUploadLog();
            return;
        L5:
            if (r10 != 2) goto L7;
            AbstractLogCollector r11 = (AbstractLogCollector) r8.obj;
            CldReportService.access$800(this.this$0, r11.mCallback.asBinder(), r11);
            r11.collectAndUploadLog();
            return;
        L7:
            if (r10 != 3) goto L9;
            AbstractLogCollector r12 = (AbstractLogCollector) r8.obj;
            r12.setOnStoped(true);
            CldReportService.access$700(this.this$0, r12.mCallback.asBinder());
            return;
        L9:
            if (r10 != 4) goto L11;
            int r13 = CldReportService.access$400(this.this$0).initAllModuleLogMasks(CldReportService.access$900());
            if (r13 > 0) goto L17;
        L19:
            CldReportService.access$902(true);
            return;
        L17:
            if (CldReportService.access$900() == true) goto L19;
            Message r14 = CldReportService.access$500(this.this$0).obtainMessage(4);
            CldReportService.access$500(this.this$0).sendMessageDelayed(r14, ((long) r13) * 1000);
            goto L19
        L11:
            if (r10 == 5) goto L13;
            CaeLog.e(CldReportService.TAG, "unknown report type");
            return;
        L13:
            CldReportService.access$1000(this.this$0, (ReportErrorEvent) r8.obj);
        }
    }

    public final class NefidEventListener extends IEventListener.Stub {
        private final Set<String> IGNORED_ROAMFAIL_REASONS;
        final /* synthetic */ CldReportService this$0;

        private NefidEventListener(CldReportService r10) {
            this.this$0 = r10;
            this.IGNORED_ROAMFAIL_REASONS = new HashSet(Arrays.asList(new String[]{"HOST ABORTED", "NO AP FOUND", "NO CANDIDATE FOUND", "No AP found on final BMISS", "No Candidate AP found on final BMISS", "SCAN CANCEL", "SCAN NOT STARTED", "CURRENT AP STILL OK"}));
        }

        @Override // com.cae.caed.IEventListener
        public void OnRecvAntDivEvent(AntDivParcel r8) {
            CaeLog.i(CldReportService.TAG, "OnRecvAntDivEvent");
        }

        @Override // com.cae.caed.IEventListener
        public void OnRecvBlockUidRejectEvent(BlockUidRejectParcel r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            CaeLog.i(CldReportService.TAG, "OnRecvBlockUidRejectEvent: uid=" + r8.f4224a + ", packageName=" + r8.f4225b + ", outIface=" + r8.f4226m + ", timestamp=" + r8.f4227n);
            BlockUidRejectReporter.getInstance(CldReportService.access$300(this.this$0)).onBlockUidRejectEvent(r8);
        }

        @Override // com.cae.caed.IEventListener
        public void OnRecvCaeRoamEvent(CaeRoamParcel r12) {
            if (r12 != null) goto L4;
            return;
        L4:
            String r8 = r12.f4236s;
            boolean r10 = "FAILED".equals(r8);
            if ("SUCCESS".equals(r8) == false) goto L16;
            Arrays.toString(r12.f4235r);
            Arrays.toString(r12.f4240w);
            Arrays.toString(r12.f4241x);
            Arrays.toString(r12.f4242y);
            Arrays.toString(r12.f4243z);
            Arrays.toString(r12.A);
            if (CldReportService.access$300(this.this$0) != null) goto L10;
            CaeLog.e(CldReportService.TAG, "OnRecvCaeRoamEvent: context is null");
            return;
        L10:
            WifiManager r11 = (WifiManager) CldReportService.access$300(this.this$0).getSystemService("wifi");
            if (r11 != null) goto L14;
            CaeLog.e(CldReportService.TAG, "OnRecvCaeRoamEvent: WifiManager is null");
            return;
        L14:
            CaeWifiStatusCollect.getInstance().init(CldReportService.access$300(this.this$0), r11);
            CaeWifiStatusCollect.getInstance().reportRoamSuccess(r12);
            return;
        L16:
            if (r10 == true) goto L18;
            return;
        L18:
            String r13 = r12.f4237t;
            if (r13 == null) goto L24;
            if (this.IGNORED_ROAMFAIL_REASONS.contains(r13) == false) goto L24;
            return;
        L24:
            if (CldReportService.access$1100(this.this$0, 0, 7) == false) goto L26;
            return;
        L26:
            CaeLog.i(CldReportService.TAG, "OnRecvCaeRoamEvent(FAILED), " + r12.f4228a + ", " + r12.f4230m + ", " + r12.f4231n + ", " + r8 + ", " + r12.f4237t);
            CldReportService.access$500(this.this$0).sendMessage(CldReportService.access$500(this.this$0).obtainMessage(1, new WifiLogCollector(CldReportService.access$300(this.this$0), null, false, true, CldReportService.access$400(this.this$0), new CldCommon.CldSummary(0, 7, 0, 0, r12.f4237t))));
        }

        @Override // com.cae.caed.IEventListener
        public void OnRecvWakePacketEvent(WakePacketParcel r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            CaeLog.i(CldReportService.TAG, "OnRecvWakePacketEvent: wakeReason=" + r8.f4245b + " packetType=" + r8.f4248o + " protocol=" + r8.f4250q + " packetLen=" + r8.f4251r + " srcIp=" + r8.f4257x + " dstIp=" + r8.f4258y + " ipProtocol=" + r8.A + " srcPort=" + r8.B + " dstPort=" + r8.C + " service=" + r8.D + " rawFrameLen=" + r8.f4254u + " rawFrameTruncated=" + r8.f4255v);
            if (CldReportService.access$300(this.this$0) != null) goto L8;
            CaeLog.e(CldReportService.TAG, "OnRecvWakePacketEvent: context is null");
            return;
        L8:
            WifiManager r10 = (WifiManager) CldReportService.access$300(this.this$0).getSystemService("wifi");
            if (r10 != null) goto L12;
            CaeLog.e(CldReportService.TAG, "OnRecvWakePacketEvent: WifiManager is null");
            return;
        L12:
            CaeWifiStatusCollect.getInstance().init(CldReportService.access$300(this.this$0), r10);
            CaeWifiStatusCollect.getInstance().reportWakePacket(r8);
        }

        @Override // com.cae.caed.IEventListener
        public void OnRecvWlanCrashEvent(WlanCrashParcel r10) {
            StringBuilder r8 = new StringBuilder("OnRecvWlanCrashEvent: reason=");
            r8.append(r10.f4260a);
            r8.append(" reasonStr=");
            r8.append(r10.A);
            r8.append(" recoveryCount=");
            r8.append(r10.B);
            r8.append(" triggerSource=");
            r8.append(r10.C);
            r8.append(" deviceId=");
            r8.append(r10.D);
            r8.append(" driverVersion=");
            r8.append(r10.E);
            r8.append(" fwVersion=");
            r8.append(r10.F);
            r8.append(" fwVersionStr=");
            r8.append(r10.G);
            r8.append(" fwBuildTimestamp=");
            r8.append(r10.H);
            r8.append(" subreason=");
            r8.append(r10.f4273x);
            r8.append(" rddm_sfr_info=");
            android.aimedia.a.r(r8, r10.f4267r, CldReportService.TAG);
            if (CldReportService.access$300(this.this$0) == null) goto L8;
            WifiManager r11 = (WifiManager) CldReportService.access$300(this.this$0).getSystemService("wifi");
            if (r11 == null) goto L7;
            CaeWifiStatusCollect.getInstance().init(CldReportService.access$300(this.this$0), r11);
            CaeWifiStatusCollect.getInstance().reportWlanCrash(r10);
        L11:
            if (CldReportService.access$1100(this.this$0, 0, 6) == false) goto L13;
            return;
        L13:
            CldCommon.CldSummary r12 = new CldCommon.CldSummary(0, 6, r10.f4260a, 0, r10.f4267r);
            WifiLogCollector r13 = new WifiLogCollector(CldReportService.access$300(this.this$0), null, false, true, CldReportService.access$400(this.this$0), r12);
            Message r14 = CldReportService.access$500(this.this$0).obtainMessage(1, r13);
            CldReportService.access$500(this.this$0).sendMessage(r14);
            return;
        L7:
            String r15 = "OnRecvWlanCrashEvent: WifiManager is null";
        L9:
            CaeLog.e(CldReportService.TAG, r15);
            goto L11
        L8:
            r15 = "OnRecvWlanCrashEvent: context is null";
            goto L9
        }

        public /* synthetic */ NefidEventListener(CldReportService r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public static final class ReportErrorEvent {
        final int errCode;
        final String extrainfo;
        final int moduleType;
        final int reason;
        final int subreason;

        public ReportErrorEvent(int r8, int r10, int r11, int r12, String r13) {
            this.moduleType = r8;
            this.errCode = r10;
            this.reason = r11;
            this.subreason = r12;
            this.extrainfo = r13;
        }
    }

    static {
        WIFI_CONNECT_SLOW_START_CONN_TIME_PATTERN = Pattern.compile("\\bstartConnTime\\s*[:=]\\s*([^,]+?)(?=\\s+l2timeconsumed\\b|\\s*,|$)");
        WIFI_CONNECT_SLOW_FORMATTED_START_TIME_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3}");
        WIFI_CONNECT_SLOW_L2_TIME_PATTERN = Pattern.compile("\\bl2timeconsumed\\s*[:=]\\s*(-?\\d+)\\b");
        WIFI_CONNECT_SLOW_L3_TIME_PATTERN = Pattern.compile("\\bl3timeconsumed\\s*[:=]\\s*(-?\\d+)\\b");
        WIFI_DRIVER_LOAD_FAIL_PATTERNS = new String[]{"is_driver_loaded 0", "cnss:Failed to probe host driver", "dp_prealloc_init: unable to allocate context memory"};
        mIsRestored = false;
    }

    public CldReportService() {
        this.mDeathRecipLogCollectHashMap = new ConcurrentHashMap();
        this.mCallbackLogCollectHashMap = new ConcurrentHashMap();
        this.mReportLimitRecords = new ConcurrentHashMap();
        this.mBinder = new AnonymousClass1(this);
    }

    public static /* synthetic */ LinkedList a(String r8) {
        return lambda$isReportLimited$0(r8);
    }

    public static /* synthetic */ void access$100(CldReportService r8, int r10, int r11, int r12, int r13, String r14) {
        r8.postReportErrorEvent(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void access$1000(CldReportService r8, ReportErrorEvent r10) {
        r8.handleReportErrorEvent(r10);
    }

    public static /* synthetic */ boolean access$1100(CldReportService r8, int r10, int r11) {
        return r8.isReportLimited(r10, r11);
    }

    public static /* synthetic */ ConcurrentHashMap access$200(CldReportService r8) {
        return r8.mDeathRecipLogCollectHashMap;
    }

    public static /* synthetic */ Context access$300(CldReportService r8) {
        return r8.mContext;
    }

    public static /* synthetic */ CldCommon access$400(CldReportService r8) {
        return r8.mCldCommon;
    }

    public static /* synthetic */ CldProcessHandler access$500(CldReportService r8) {
        return r8.mCldProcessHandler;
    }

    public static /* synthetic */ ConcurrentHashMap access$600(CldReportService r8) {
        return r8.mCallbackLogCollectHashMap;
    }

    public static /* synthetic */ void access$700(CldReportService r8, IBinder r10) {
        r8.unregisterCldReportCallback(r10);
    }

    public static /* synthetic */ void access$800(CldReportService r8, IBinder r10, AbstractLogCollector r11) {
        r8.registerCldReportCallback(r10, r11);
    }

    public static /* synthetic */ boolean access$900() {
        return mIsRestored;
    }

    public static /* synthetic */ boolean access$902(boolean r8) {
        mIsRestored = r8;
        return r8;
    }

    public static /* synthetic */ Boolean b(CldReportService r8, Process r10) {
        return r8.lambda$hasWifiDriverLoadFailLog$1(r10);
    }

    private CldCommon.CldSummary buildCldSummary(int r8, int r10, int r11, int r12, String r13) {
        if (r8 == 0) goto L4;
    L10:
        int r14 = r11;
        int r15 = r12;
    L12:
        return new CldCommon.CldSummary(r8, r10, r14, r15, r13);
    L4:
        if (r10 != 1) goto L10;
        if (r11 != 0) goto L10;
        if (r12 != 0) goto L10;
        if (hasWifiDriverLoadFailLog() == false) goto L10;
        CaeLog.i(TAG, "classify wifi open fail as driver load fail");
        r14 = 1;
        r15 = 1;
        goto L12
    }

    private Long extractLongField(Pattern r8, String r10) {
        String r11 = extractStringField(r8, r10);
        if (r11 != null) goto L8;
        return null;
    L8:
        return Long.valueOf(Long.parseLong(r11));
    L7:
        return null;
    }

    private String extractStringField(Pattern r8, String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Matcher r11 = r8.matcher(r10);
        if (r11.find() == true) goto L9;
        return null;
    L9:
        return r11.group(1).trim();
    }

    private void handleReportErrorEvent(ReportErrorEvent r15) {
        if (shouldDropInvalidWifiConnectSlowReport(r15) == false) goto L6;
        return;
    L6:
        if (isReportLimited(r15.moduleType, r15.errCode) == false) goto L8;
        return;
    L8:
        CldCommon.CldSummary r13 = buildCldSummary(r15.moduleType, r15.errCode, r15.reason, r15.subreason, r15.extrainfo);
        CaeLog.i(TAG, "handleReportErrorEvent: " + r13);
        int r16 = r15.moduleType;
        if (r16 != 0) goto L11;
        AbstractLogCollector r17 = new WifiLogCollector(this.mContext, null, false, true, this.mCldCommon, r13);
    L21:
        AbstractLogCollector r14 = r17;
    L22:
        if (r14 == null) goto L25;
        r14.collectAndUploadLog();
        return;
    L25:
        return;
    L11:
        if (r16 != 1) goto L13;
        r17 = new BluetoothLogCollector(this.mContext, null, false, true, this.mCldCommon, r13);
        goto L21
    L13:
        if (r16 != 2) goto L15;
        r17 = new NetworkLogCollector(this.mContext, null, false, true, this.mCldCommon, r13);
        goto L21
    L15:
        if (r16 == 3) goto L17;
        CaeLog.e(TAG, "unknown module type");
        r14 = null;
        goto L22
    L17:
        r17 = new GnssLogCollector(this.mContext, null, false, true, this.mCldCommon, r13);
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.obric.cae.cldReport.CldReportService, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Thread] */
    private boolean hasWifiDriverLoadFailLog() {
        int r8 = 0;
        FutureTask r10 = null;
        Process r11 = new ProcessBuilder(new String[]{"logcat", "-b", "kernel", "-d", "-t", String.valueOf(2000)}).redirectErrorStream(true).start();     // Catch: Throwable -> L47 ExecutionException -> L49 TimeoutException -> L62 InterruptedException -> L74 IOException -> L89
    L123:
        FutureTask r12 = new FutureTask(new b(r8, this, r11));     // Catch: Throwable -> L38 ExecutionException -> L40 TimeoutException -> L42 InterruptedException -> L43 IOException -> L45
        CldReportService this = new Thread(r12, "WifiDriverLoadFailLogScan");     // Catch: Throwable -> L24 ExecutionException -> L27 TimeoutException -> L30 InterruptedException -> L32 IOException -> L35
    L121:
        this.start();     // Catch: Throwable -> L16 ExecutionException -> L18 InterruptedException -> L20 IOException -> L22 TimeoutException -> L114
        boolean r13 = ((Boolean) r12.get(3000, TimeUnit.MILLISECONDS)).booleanValue();     // Catch: Throwable -> L16 ExecutionException -> L18 InterruptedException -> L20 IOException -> L22 TimeoutException -> L114
        goto L31
    L8:
        if (r12.isDone() == true) goto L10;
        r12.cancel(true);
    L10:
        if (r11 == null) goto L13;
        r11.destroy();
    L13:
        if (this.isAlive() == false) goto L15;
        this.interrupt();
    L15:
        return r13;
    L22:
        e = e;
    L37:
        r10 = r12;
        this = this;
    L91:
        CaeLog.e(TAG, "read wifi driver log failed: " + e);     // Catch: Throwable -> L87
        if (r10 != null) goto L94;
    L96:
        if (r11 == null) goto L98;
        r11.destroy();
    L98:
        if (this == 0) goto L115;
        boolean r14 = this.isAlive();
        this = this;
        if (r14 == false) goto L115;
    L73:
        this.interrupt();
    L115:
        return false;
    L94:
        if (r10.isDone() == true) goto L96;
        r10.cancel(true);
    L20:
        e = e;
    L34:
        r10 = r12;
        this = this;
    L76:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L87
        CaeLog.e(TAG, "read wifi driver log interrupted: " + e);     // Catch: Throwable -> L87
        if (r10 != null) goto L79;
    L81:
        if (r11 == null) goto L83;
        r11.destroy();
    L83:
        if (this == 0) goto L115;
        boolean r15 = this.isAlive();
        this = this;
        if (r15 == false) goto L115;
    L79:
        if (r10.isDone() == true) goto L81;
        r10.cancel(true);
    L18:
        e = e;
    L29:
        r10 = r12;
        this = this;
    L51:
        CaeLog.e(TAG, "read wifi driver log failed: " + e.getCause());     // Catch: Throwable -> L87
        if (r10 != null) goto L54;
    L56:
        if (r11 == null) goto L58;
        r11.destroy();
    L58:
        if (this == 0) goto L115;
        boolean r16 = this.isAlive();
        this = this;
        if (r16 == false) goto L115;
    L54:
        if (r10.isDone() == true) goto L56;
        r10.cancel(true);
    L16:
        th = th;
    L26:
        r10 = r12;
    L103:
        if (r10 != null) goto L105;
    L107:
        if (r11 == null) goto L109;
        r11.destroy();
    L109:
        if (this != 0) goto L111;
    L113:
        throw th;
    L111:
        if (this.isAlive() == false) goto L113;
        this.interrupt();
        goto L113
    L105:
        if (r10.isDone() == true) goto L107;
        r10.cancel(true);
    L31:
        r10 = r12;
        this = this;
    L63:
        CaeLog.w(TAG, "read wifi driver log timeout");     // Catch: Throwable -> L87
        if (r10 != null) goto L66;
    L68:
        if (r11 == null) goto L70;
        r11.destroy();
    L70:
        if (this == 0) goto L115;
        boolean r17 = this.isAlive();
        this = this;
        if (r17 == false) goto L115;
    L66:
        if (r10.isDone() == true) goto L68;
        r10.cancel(true);
    L35:
        e = e;
        this = 0;
    L32:
        e = e;
        this = 0;
    L27:
        e = e;
        this = 0;
    L30:
        this = 0;
    L24:
        th = th;
        this = 0;
        goto L26
    L45:
        e = e;
        this = 0;
    L43:
        e = e;
        this = 0;
    L40:
        e = e;
        this = 0;
    L42:
        this = 0;
    L38:
        th = th;
        this = 0;
    L87:
        th = th;
    L89:
        e = e;
        this = 0;
        r11 = null;
    L74:
        e = e;
        this = 0;
        r11 = null;
    L49:
        e = e;
        this = 0;
        r11 = null;
    L62:
        this = 0;
        r11 = null;
    L47:
        th = th;
        this = 0;
        r11 = null;
        goto L103
    }

    private boolean isReportLimited(int r13, int r14) {
        int r8 = 2;
        if (r13 != 2) goto L6;
        if (r14 != 3) goto L6;
        return false;
    L6:
        String r10 = r13 + BdimCategoryConstants.SEPARATOR_COLON + r14;
        long r11 = System.currentTimeMillis();
        LinkedList<Long> r12 = this.mReportLimitRecords.computeIfAbsent(r10, new d(r8));
        monitor-enter(r12);
    L43:
        th = move-exception;
        throw th;
    L9:
        if (r12.isEmpty() == false) goto L11;
    L15:
        monitor-exit(r12);     // Catch: Throwable -> L43
        monitor-enter(r12);
        Iterator<Long> r15 = r12.iterator();     // Catch: Throwable -> L40
    L19:
        if (r15.hasNext() == false) goto L23;
        if ((r11 - r15.next().longValue()) <= 3600000) goto L19;
        r15.remove();     // Catch: Throwable -> L40
        goto L19
    L23:
        monitor-exit(r12);     // Catch: Throwable -> L40
        monitor-enter(r12);
    L37:
        th = move-exception;
        throw th;
    L26:
        if (r12.size() < 3) goto L30;
        CaeLog.i(TAG, "moduleType=" + r13 + ", errCode=" + r14 + " hit 3 times in 3600 secs limit");     // Catch: Throwable -> L37
        monitor-exit(r12);     // Catch: Throwable -> L37
        return true;
    L30:
        r12.add(Long.valueOf(r11));     // Catch: Throwable -> L37
        monitor-exit(r12);     // Catch: Throwable -> L37
        int r16 = (int) CldUtil.calculateDirectorySize(new File(CldCommon.CLD_LOG_DIRECTORY));
        if (r16 <= 524288000) goto L36;
        CaeLog.i(TAG, "cldDir size=" + r16 + " exceeds max size=524288000");
        return true;
    L36:
        return false;
    L40:
        th = move-exception;
        throw th;
    L11:
        if ((r11 - r12.getLast().longValue()) >= 5000) goto L15;
        CaeLog.i(TAG, "moduleType=" + r13 + ", errCode=" + r14 + " hit 2 times in 5 secs limit");     // Catch: Throwable -> L43
        monitor-exit(r12);     // Catch: Throwable -> L43
        return true;
    }

    private boolean isValidConnectStageTime(Long r8) {
        if (r8 != null) goto L4;
    L8:
        return false;
    L4:
        if (r8.longValue() < 0) goto L8;
        if (r8.longValue() > 60000) goto L8;
        return true;
    }

    private boolean isValidFormattedStartConnTime(String r8) {
        if (WIFI_CONNECT_SLOW_FORMATTED_START_TIME_PATTERN.matcher(r8).matches() == true) goto L5;
        return false;
    L5:
        SimpleDateFormat r10 = new SimpleDateFormat(WIFI_CONNECT_SLOW_START_CONN_TIME_FORMAT, Locale.US);
        r10.setLenient(false);
        if (r10.parse(r8).getTime() <= 0) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    private boolean isValidStartConnTime(String r8) {
        if (r8 != null) goto L5;
    L17:
        return false;
    L5:
        if (r8.isEmpty() == true) goto L17;
        if (r8.startsWith("1970-") == false) goto L18;
        return false;
    L18:
        if (Long.parseLong(r8) <= 0) goto L20;
        return true;
    L20:
        return false;
    L16:
        return isValidFormattedStartConnTime(r8);
    }

    private /* synthetic */ Boolean lambda$hasWifiDriverLoadFailLog$1(Process r8) {
        return Boolean.valueOf(scanWifiDriverLoadFailLog(r8));
    }

    private static /* synthetic */ LinkedList lambda$isReportLimited$0(String r8) {
        return new LinkedList();
    }

    private void postReportErrorEvent(int r10, int r11, int r12, int r13, String r14) {
        CldProcessHandler r8 = this.mCldProcessHandler;
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "postReportErrorEvent: cld process handler is null");
        return;
    L6:
        Message r15 = r8.obtainMessage(5, new ReportErrorEvent(r10, r11, r12, r13, r14));
        this.mCldProcessHandler.sendMessage(r15);
    }

    private void registerCldReportCallback(IBinder r8, AbstractLogCollector r10) {
        CaeLog.d(TAG, "registerCldReportCallback logCollector=" + r10 + " iBinder=" + r8);
        CldCbDeathRecpnt r11 = new CldCbDeathRecpnt(this, r8);     // Catch: RemoteException -> L6
        r8.linkToDeath(r11, 0);     // Catch: RemoteException -> L6
        this.mDeathRecipLogCollectHashMap.put(r8, r11);
        this.mCallbackLogCollectHashMap.put(r8, r10);
        return;
    L6:
        e = move-exception;
        defpackage.b.n("registerCldReportCallback exception! :", e, TAG);
    }

    private boolean scanWifiDriverLoadFailLog(Process r8) {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(r8.getInputStream(), StandardCharsets.UTF_8));
    L26:
        String r11 = r10.readLine();     // Catch: Throwable -> L18
        int r12 = 0;
        if (r11 == null) goto L14;
        String[] r13 = WIFI_DRIVER_LOAD_FAIL_PATTERNS;     // Catch: Throwable -> L18
        int r14 = r13.length;     // Catch: Throwable -> L18
    L7:
        if (r12 >= r14) goto L26;
        String r15 = r13[r12];     // Catch: Throwable -> L18
        if (r11.contains(r15) == true) goto L10;
        r12 = r12 + 1;
        goto L7
    L10:
        CaeLog.i(TAG, "wifi driver load fail log matched: " + r15);     // Catch: Throwable -> L18
        r10.close();
        return true;
    L14:
        r10.close();
        int r16 = r8.waitFor();
        if (r16 == 0) goto L17;
        CaeLog.w(TAG, "logcat kernel exited with code " + r16);
    L17:
        return false;
    L18:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L21
    L23:
        throw th;
    L21:
        th = move-exception;
        th.addSuppressed(th);
        goto L23
    }

    private boolean shouldDropInvalidWifiConnectSlowReport(ReportErrorEvent r8) {
        boolean r10 = false;
        if (r8.moduleType == 0) goto L5;
    L18:
        return false;
    L5:
        if (r8.errCode != 4) goto L18;
        String r11 = r8.extrainfo;
        String r12 = extractStringField(WIFI_CONNECT_SLOW_START_CONN_TIME_PATTERN, r11);
        Long r13 = extractLongField(WIFI_CONNECT_SLOW_L2_TIME_PATTERN, r11);
        Long r14 = extractLongField(WIFI_CONNECT_SLOW_L3_TIME_PATTERN, r11);
        if (isValidStartConnTime(r12) == true) goto L10;
    L14:
        if (r10 == true) goto L17;
        CaeLog.i(TAG, "drop invalid wifi connect slow report, startConnTime=" + r12 + ", l2timeconsumed=" + r13 + ", l3timeconsumed=" + r14 + ", info=" + r11);
    L17:
        return !r10;
    L10:
        if (isValidConnectStageTime(r13) == false) goto L14;
        if (isValidConnectStageTime(r14) == false) goto L14;
        r10 = true;
        goto L14
    }

    private void unregisterCldReportCallback(IBinder r8) {
        CaeLog.d(TAG, "unregisterCldReportCallback iBinder=" + r8);
        if (this.mDeathRecipLogCollectHashMap.containsKey(r8) == false) goto L8;
        CldCbDeathRecpnt r10 = this.mDeathRecipLogCollectHashMap.get(r8);
        if (r10 == null) goto L7;
        r8.unlinkToDeath(r10, 0);
    L7:
        this.mDeathRecipLogCollectHashMap.remove(r8);
    L8:
        this.mCallbackLogCollectHashMap.remove(r8);
    }

    public void internalReportErrorEvent(int r8, int r10, int r11, int r12, String r13) {
        postReportErrorEvent(r8, r10, r11, r12, r13);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r8) {
        CaeLog.i(TAG, "onBind");
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        HandlerThread r8 = new HandlerThread("CldReport-HandlerThread");
        this.mCldHandlerThread = r8;
        r8.start();
        this.mCldProcessHandler = new CldProcessHandler(this, this.mCldHandlerThread.getLooper());
        CldInternalReport.addCldReportService(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        CaeLog.i(TAG, "onDestroy");
        NefidInterface r8 = this.mNefidInterface;
        if (r8 == null) goto L9;
        NefidEventListener r10 = this.mNefidEventListener;
        if (r10 == null) goto L9;
        if (this.mNefidEventListenerRegistered == false) goto L9;
        r8.unregisterNefidEventListener(r10);
        this.mNefidEventListenerRegistered = false;
    L9:
        CldProcessHandler r11 = this.mCldProcessHandler;
        if (r11 == null) goto L12;
        r11.removeCallbacksAndMessages(null);
    L12:
        HandlerThread r12 = this.mCldHandlerThread;
        if (r12 == null) goto L23;
        r12.quitSafely();
        this.mCldHandlerThread.join(1000);     // Catch: InterruptedException -> L17
    L19:
        this.mCldHandlerThread = null;
        return;
    L17:
        e = move-exception;
        CaeLog.e(TAG, "join thread interrupted: " + e.getMessage());
        Thread.currentThread().interrupt();
        goto L19
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r8, int r10, int r11) {
        CaeLog.i(TAG, "onStartCommand");
        this.mContext = this;
        ServiceManager.addService(SERVICE_NAME_CLD_REPORT, this.mBinder);
        this.mCldCommon = new CldCommon(this.mContext);
        Message r12 = this.mCldProcessHandler.obtainMessage(4);
        this.mCldProcessHandler.sendMessage(r12);
        this.mNefidInterface = NefidInterface.getInstance(this.mContext);
        if (this.mNefidEventListener != null) goto L6;
        this.mNefidEventListener = new NefidEventListener(this, null);
    L6:
        if (this.mNefidEventListenerRegistered == true) goto L10;
        boolean r13 = this.mNefidInterface.registerNefidEventListener(this.mNefidEventListener);
        this.mNefidEventListenerRegistered = r13;
        if (r13 == true) goto L12;
        CaeLog.e(TAG, "Failed to register NefidEventListener");
    L12:
        return super.onStartCommand(r8, r10, r11);
    L10:
        CaeLog.i(TAG, "NefidEventListener already registered, skip duplicate registration");
        goto L12
    }
}
