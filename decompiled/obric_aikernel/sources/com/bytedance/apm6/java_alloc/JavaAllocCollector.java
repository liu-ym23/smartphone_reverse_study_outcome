package com.bytedance.apm6.java_alloc;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.java_alloc.model.ReportData;
import com.bytedance.apm6.java_alloc.model.ReportInfo;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.crash.constants.Constants;
import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.monitor.collector.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import x.a;
import y.d;

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

    /* synthetic */ JavaAllocCollector(AnonymousClass1 r10) {
        this();
    }

    public static int fillStringBytes(ByteBuffer r10, byte[] r11) {
        int r12 = r10.getInt();
        if (r12 <= r11.length) goto L5;
        r10.position((r10.position() + r12) - r11.length);
        r10.get(r11, 0, r11.length);
        return r11.length;
    L5:
        r10.get(r11, 0, r12);
        return r12;
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

    @RequiresApi(api = 19)
    private static String getString(ByteBuffer r10, byte[] r11) {
        return new String(r11, 0, fillStringBytes(r10, r11), StandardCharsets.US_ASCII);
    }

    private boolean isInitJavaMem() {
        JavaAllocConfig r10 = getConfig();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.enable_collect == true) goto L8;
        return false;
    L8:
        if ((-1) != sJavaMemState) goto L13;
        if (k.t() == false) goto L13;
        sJavaMemState = MonitorJni.initJavaMem() ? 1 : 0;
    L13:
        if (sJavaMemState == 1) goto L15;
        return false;
    L15:
        return true;
    }

    private boolean isInitJavaMonitor() {
        JavaAllocConfig r10 = getConfig();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.enable_collect == true) goto L8;
        return false;
    L8:
        if ((-1) != sJavaMonitorState) goto L13;
        if (isInitJavaMem() == false) goto L13;
        sJavaMonitorState = MonitorJni.setEnableAllocatedMonitor(true, r10.collect_per_thousand_alloc, r10.dump_per_thousand_collect, r10.threshold_alloc_frequency, r10.threshold_alloc_size, MonitorJni.class.getClassLoader()) ? 1 : 0;
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
        List<ReportInfo> r11 = r10.infoList;
        if (r11 == null) goto L30;
        if (r11.size() == 0) goto L30;
        long r12 = System.currentTimeMillis();
        Iterator<ReportInfo> r13 = r10.infoList.iterator();
    L15:
        if (r13.hasNext() == false) goto L44;
        ReportInfo r14 = r13.next();
        JSONObject r15 = PerfFilterManager.getInstance().getPerfFiltersJson();     // Catch: JSONException -> L33
        r15.put("is_main_process", ApmContext.isMainProcess());     // Catch: JSONException -> L33
        r15.put("process_name", ApmContext.getCurrentProcessName());     // Catch: JSONException -> L33
        JSONObject r16 = r14.packJson(r15);     // Catch: JSONException -> L33
        JSONObject r17 = new JSONObject();     // Catch: JSONException -> L33
        r17.put("alloc_duration", r10.duration);     // Catch: JSONException -> L33
        JSONObject r18 = r10.config;     // Catch: JSONException -> L33
        if (r18 == null) goto L23;
        Iterator<String> r19 = r18.keys();     // Catch: JSONException -> L33
    L21:
        if (r19.hasNext() == false) goto L23;
        String r20 = r19.next();     // Catch: JSONException -> L33
        r17.put(r20, r10.config.opt(r20));     // Catch: JSONException -> L33
    L23:
        r16.put("custom", r17);     // Catch: JSONException -> L33
        if (r14.exceptionType != 1) goto L26;
        String r21 = "alloc_frequent_object";
    L27:
        r16.put(Constants.EVENT_TYPE, r21);     // Catch: JSONException -> L33
        d r22 = new d("java_alloc_monitor", r16, r12);     // Catch: JSONException -> L33
        r22.g();     // Catch: JSONException -> L33
        a.p().e(r22);     // Catch: JSONException -> L33
        goto L15
    L26:
        r21 = "alloc_large_object";
        goto L27
    L44:
        return;
    L30:
        if (ApmBaseContext.isDebugMode() == false) goto L43;
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

    public boolean enableAllocateMonitor(String r10) {
        if (getConfig() != null) goto L5;
        return false;
    L5:
        if (isInitJavaMonitor() == false) goto L13;
        if (r10 != null) goto L10;
        r10 = "unknown";
    L10:
        return MonitorJni.startOrStopAllocatedMonitor(true, r10);
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
        JavaAllocConfig r10 = this.forcedConfig;
        if (r10 == null) goto L6;
        return r10;
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
        if (k.t() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getMajorFaults();
    }

    public long getMinorFaults() {
        if (k.t() == true) goto L7;
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
        DefaultRecordReader r10 = new DefaultRecordReader();
        getReportInfo(r10);
        return new ReportData(r10.result, r10.getDuration(), r10.getConfig());
    L5:
        if (ApmBaseContext.isDebugMode() == false) goto L11;
        Logger.i(TAG, "version is too low");
        return null;
    L11:
        return null;
    }

    public void getReportInfo(IRecordReader r27) {
        if (k.t() == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L25;
        if (r27 == null) goto L26;
        ByteBuffer r10 = getReportInfoInner();
        if (r10 != null) goto L12;
        return;
    L12:
        r10.order(ByteOrder.LITTLE_ENDIAN);
        r10.position(0);
        if (r10.getInt() == MAGIC_NUM) goto L15;
        return;
    L15:
        byte[] r14 = new byte[4096];
        Trace r15 = new Trace();
        long r16 = r10.getLong();
        String r11 = getString(r10, r14);
        int r12 = r10.getInt();
        int r13 = r10.getInt();
        int r17 = r10.getInt();
        int r18 = r10.getInt();
        long r19 = r10.getLong();
        long r110 = r10.getLong();
        long r20 = r10.getLong();
        long r22 = r10.getLong();
        int r111 = r10.getInt();
        r27.onHeadInfo(r11, r20, r22, r111, new JavaAllocConfig(true, true, r12, r13, r17, r18), r19, r110);
        int r21 = 0;
    L16:
        if (r21 >= r111) goto L21;
        String r23 = getString(r10, r14);
        int r24 = r10.getInt();
        int r25 = r10.getInt();
        int r26 = r10.getInt();
        r15.setStream(r10);
        if (r27.onItem(r23, r25, r26, r15, r24) == false) goto L21;
        r21 = r21 + 1;
    L21:
        MonitorJni.releaseByteBuffer(r16);
        return;
    L26:
        return;
    }

    public void init() {
        if (this.initialized == true) goto L9;
        JavaAllocConfigService r10 = (JavaAllocConfigService) ServiceManager.getService(JavaAllocConfigService.class);
        if (r10 == null) goto L7;
        updateConfig(r10.getConfig());
    L7:
        isInitJavaMem();
        this.initialized = true;
        return;
    }

    public boolean initAllocateMonitor() {
        return isInitJavaMonitor();
    }

    public void updateConfig(JavaAllocConfig r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.config = r10;
    }
}
