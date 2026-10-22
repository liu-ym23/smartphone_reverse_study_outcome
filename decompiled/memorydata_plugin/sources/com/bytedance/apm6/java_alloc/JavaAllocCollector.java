package com.bytedance.apm6.java_alloc;

import android.os.Build;
import com.bytedance.apm.data.a.d;
import com.bytedance.apm.data.pipeline.a;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.java_alloc.model.ReportData;
import com.bytedance.apm6.java_alloc.model.ReportInfo;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.constants.Constants;
import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.monitor.collector.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JavaAllocCollector {
    private static final int MAGIC_NUM = 123457;
    public static final int MAX_BYTE_LEN = 4096;
    private static final int MEM_INIT_FAILED = 0;
    private static final int MEM_INIT_SUCC = 1;
    private static final int MEM_UNINIT = -1;
    private static final String TAG = "APM-JavaAlloc";
    public static final long UNKNOWN_VALUE = -1;
    private static int sJavaMemState = -1;
    private static int sJavaMonitorState = -1;
    private JavaAllocConfig config;
    public JavaAllocConfig forcedConfig;
    private volatile boolean initialized;

    /* JADX INFO: renamed from: com.bytedance.apm6.java_alloc.JavaAllocCollector$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class InnerHolder {
        private static final JavaAllocCollector instance = null;

        static {
            instance = new JavaAllocCollector(null);
        }

        private InnerHolder() {
        }

        static /* synthetic */ JavaAllocCollector access$000() {
            return instance;
        }
    }

    static {
    }

    private JavaAllocCollector() {
    }

    /* synthetic */ JavaAllocCollector(AnonymousClass1 r1) {
        this();
    }

    public static int fillStringBytes(ByteBuffer r3, byte[] r4) {
        int r0 = r3.getInt();
        if (r0 <= r4.length) goto L5;
        r3.position((r3.position() + r0) - r4.length);
        r3.get(r4, 0, r4.length);
        return r4.length;
    L5:
        r3.get(r4, 0, r0);
        return r0;
    }

    public static JavaAllocCollector getInstance() {
        return InnerHolder.access$000();
    }

    private ByteBuffer getReportInfoInner() {
        if (isInitJavaMem() == true) goto L7;
        return null;
    L7:
        return MonitorJni.getAllocReportInfo();
    }

    private static String getString(ByteBuffer r3, byte[] r4) {
        return new String(r4, 0, fillStringBytes(r3, r4), StandardCharsets.US_ASCII);
    }

    private boolean isInitJavaMem() {
        JavaAllocConfig r2 = getConfig();
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.enable_collect == true) goto L8;
        return false;
    L8:
        if ((-1) != sJavaMemState) goto L13;
        if (k.b() == false) goto L13;
        sJavaMemState = MonitorJni.initJavaMem() ? 1 : 0;
    L13:
        if (sJavaMemState == 1) goto L15;
        return false;
    L15:
        return true;
    }

    private boolean isInitJavaMonitor() {
        JavaAllocConfig r0 = getConfig();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.enable_collect == true) goto L8;
        return false;
    L8:
        if ((-1) != sJavaMonitorState) goto L13;
        if (isInitJavaMem() == false) goto L13;
        sJavaMonitorState = MonitorJni.setEnableAllocatedMonitor(true, r0.collect_per_thousand_alloc, r0.dump_per_thousand_collect, r0.threshold_alloc_frequency, r0.threshold_alloc_size, MonitorJni.class.getClassLoader()) ? 1 : 0;
    L13:
        if (sJavaMonitorState == 1) goto L15;
        return false;
    L15:
        return true;
    }

    public void clearAllocateInfo() {
        if (isInitJavaMem() == true) goto L5;
        return;
    L5:
        MonitorJni.clearAllocateInfo();
    }

    public void collectAndReport() {
        if (getConfig().enable_upload == true) goto L5;
        return;
    L5:
        if (getConfig().enable_collect == false) goto L42;
        ReportData r10 = getReportData();
        if (r10 == null) goto L30;
        if (r10.infoList == null) goto L30;
        if (r10.infoList.size() == 0) goto L30;
        long r0 = System.currentTimeMillis();
        Iterator<ReportInfo> r2 = r10.infoList.iterator();
    L15:
        if (r2.hasNext() == false) goto L44;
        ReportInfo r3 = (ReportInfo) ZeusTransformUtils.preCheckCast(r2.next(), ReportInfo.class, "com.obric.memorydata.plugin");
        JSONObject r4 = PerfFilterManager.getInstance().getPerfFiltersJson();     // Catch: JSONException -> L33
        r4.put(LocationMonitorConst.IS_MAIN_PROCESS, ApmContext.isMainProcess());     // Catch: JSONException -> L33
        r4.put("process_name", ApmContext.getCurrentProcessName());     // Catch: JSONException -> L33
        JSONObject r5 = r3.packJson(r4);     // Catch: JSONException -> L33
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L33
        r6.put("alloc_duration", r10.duration);     // Catch: JSONException -> L33
        if (r10.config == null) goto L23;
        Iterator<String> r7 = r10.config.keys();     // Catch: JSONException -> L33
    L21:
        if (r7.hasNext() == false) goto L23;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L33
        r6.put(r8, r10.config.opt(r8));     // Catch: JSONException -> L33
    L23:
        r5.put("custom", r6);     // Catch: JSONException -> L33
        if (r3.exceptionType != 1) goto L26;
        String r9 = "alloc_frequent_object";
    L27:
        r5.put(Constants.EVENT_TYPE, r9);     // Catch: JSONException -> L33
        d r11 = new d("java_alloc_monitor", r5, r0);     // Catch: JSONException -> L33
        r11.e();     // Catch: JSONException -> L33
        a.b().a(r11);     // Catch: JSONException -> L33
        goto L15
    L26:
        r9 = "alloc_large_object";
        goto L27
    L44:
        return;
    L30:
        if (ApmContext.isDebugMode() == false) goto L43;
        Logger.i(TAG, "empty report info");
        return;
    L43:
        return;
    }

    public boolean deinitAllocateMonitor() {
        if (1 != sJavaMonitorState) goto L10;
        if (isInitJavaMem() == false) goto L10;
        if (MonitorJni.setEnableAllocatedMonitor(false, 0, 0, Integer.MAX_VALUE, 2147483647L, MonitorJni.class.getClassLoader()) == false) goto L10;
        sJavaMonitorState = -1;
    L10:
        if (sJavaMonitorState == (-1)) goto L14;
        return false;
    L14:
        return true;
    }

    public boolean disableAllocateMonitor() {
        if (isInitJavaMonitor() == true) goto L6;
        return false;
    L6:
        return MonitorJni.startOrStopAllocatedMonitor(false, null);
    }

    public boolean enableAllocateMonitor(String r2) {
        if (getConfig() != null) goto L5;
        return false;
    L5:
        if (isInitJavaMonitor() == false) goto L13;
        if (r2 != null) goto L10;
        r2 = "unknown";
    L10:
        return MonitorJni.startOrStopAllocatedMonitor(true, r2);
    L13:
        return false;
    }

    public long getBlockingGcCount() {
        if (isInitJavaMem() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getBlockGCCount();
    }

    public long getBlockingGcTime() {
        if (isInitJavaMem() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getBlockGCTime();
    }

    public long getBytesAllocatedEver() {
        if (isInitJavaMem() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getBytesAllocatedEver();
    }

    public JavaAllocConfig getConfig() {
        JavaAllocConfig r0 = this.forcedConfig;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.config;
    }

    public long getGcCount() {
        if (isInitJavaMem() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getGCCount();
    }

    public long getGcTime() {
        if (isInitJavaMem() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getGCTime();
    }

    public long getMajorFaults() {
        if (k.b() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getMajorFaults();
    }

    public long getMinorFaults() {
        if (k.b() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getMinorFaults();
    }

    public long getObjectsAllocatedEver() {
        if (isInitJavaMem() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getObjectsAllocatedEver();
    }

    public ReportData getReportData() {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        DefaultRecordReader r0 = new DefaultRecordReader();
        getReportInfo(r0);
        return new ReportData(r0.result, r0.getDuration(), r0.getConfig());
    L5:
        if (ApmContext.isDebugMode() == false) goto L11;
        Logger.i(TAG, "version is too low");
        return null;
    L11:
        return null;
    }

    public void getReportInfo(IRecordReader r28) {
        IRecordReader r0 = (IRecordReader) ZeusTransformUtils.wrapperContextForParams(r28, IRecordReader.class, "com.obric.memorydata.plugin");
        if (k.b() == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L25;
        if (r0 == null) goto L26;
        ByteBuffer r13 = getReportInfoInner();
        if (r13 != null) goto L12;
        return;
    L12:
        r13.order(ByteOrder.LITTLE_ENDIAN);
        r13.position(0);
        if (r13.getInt() == MAGIC_NUM) goto L15;
        return;
    L15:
        byte[] r15 = new byte[4096];
        Trace r11 = new Trace();
        long r16 = r13.getLong();
        String r2 = getString(r13, r15);
        int r6 = r13.getInt();
        int r7 = r13.getInt();
        int r8 = r13.getInt();
        int r1 = r13.getInt();
        long r18 = r13.getLong();
        long r20 = r13.getLong();
        long r22 = r13.getLong();
        long r24 = r13.getLong();
        int r12 = r13.getInt();
        r0.onHeadInfo(r2, r22, r24, r12, new JavaAllocConfig(true, true, r6, r7, r8, r1), r18, r20);
        int r9 = 0;
    L16:
        if (r9 >= r12) goto L21;
        String r3 = getString(r13, r15);
        int r10 = r13.getInt();
        int r4 = r13.getInt();
        int r5 = r13.getInt();
        r11.setStream(r13);
        if (r0.onItem(r3, r4, r5, r11, r10) == false) goto L21;
        r9 = r9 + 1;
    L21:
        MonitorJni.releaseByteBuffer(r16);
        return;
    L26:
        return;
    }

    public void init() {
        if (this.initialized == true) goto L9;
        JavaAllocConfigService r0 = (JavaAllocConfigService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(JavaAllocConfigService.class), JavaAllocConfigService.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        updateConfig(r0.getConfig());
    L7:
        isInitJavaMem();
        this.initialized = true;
        return;
    }

    public boolean initAllocateMonitor() {
        return isInitJavaMonitor();
    }

    public void updateConfig(JavaAllocConfig r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.config = r1;
    }
}
