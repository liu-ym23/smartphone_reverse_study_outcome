package com.lynx.tasm.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Process;
import android.os.Trace;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.obric.aivoice.core.data.NameKeys;
import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class TraceController {
    private static final String ACTION_START = "LYNX_TRACE_START";
    private static final String ACTION_STOP = "LYNX_TRACE_STOP";
    private static final long ATRACE_TAG_ALL = 134217727;
    private static final String BUFFER_SIZE_EXTRA = "buffer";
    private static final String CATEGORIES_EXTRA = "categories";
    private static final int DEFAULT_BUFFER_SIZE = 40960;
    private static final String ENABLE_COMPRESS = "enableCompress";
    private static final String FILE_EXTRA = "file";
    private static final String TAG = "Lynx startup trace";
    private static boolean isTraceEnvInit;
    private static boolean mTracingStarted;
    private c mBroadcastReceiver;
    private List<b> mCompleteCallbacks;
    private Context mContext;
    private long mNativeTraceController;
    private String traceFilePath;
    private int tracingSession;

    public static class TraceIntentFilter extends IntentFilter {
        public TraceIntentFilter(Context r3) {
            addAction(r3.getPackageName() + ".LYNX_TRACE_START");
            addAction(r3.getPackageName() + ".LYNX_TRACE_STOP");
        }
    }

    public static /* synthetic */ class a {
    }

    public interface b {
        void onComplete();
    }

    public class c extends BroadcastReceiver {
        public final /* synthetic */ TraceController a;

        public c(TraceController r1) {
            this.a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r13, Intent r14) {
            if (r14.getAction().endsWith(TraceController.ACTION_START) == false) goto L13;
            String r0 = r14.getStringExtra(TraceController.CATEGORIES_EXTRA);
            String r2 = r14.getStringExtra(TraceController.FILE_EXTRA);
            int r6 = r14.getIntExtra(TraceController.BUFFER_SIZE_EXTRA, TraceController.DEFAULT_BUFFER_SIZE);
            boolean r11 = r14.getBooleanExtra(TraceController.ENABLE_COMPRESS, false);
            if (r2 != null) goto L7;
            r2 = TraceController.access$200(this.a);
        L7:
            TraceController r5 = this.a;
            if (r0 == null) goto L10;
            String[] r15 = r0.split(",");
        L11:
            r5.startTracing(r6, r15, null, r2, false, r11);
            Toast.makeText(r13, "Trace started at: " + r2, 0).show();
            return;
        L10:
            r15 = null;
            goto L11
        L13:
            if (r14.getAction().endsWith(TraceController.ACTION_STOP) == false) goto L17;
            this.a.stopTracing();
            Toast.makeText(r13, "Trace stopped", 0).show();
            return;
        }
    }

    public static class d {
        public static final TraceController a = null;

        static {
            a = new TraceController(null);
        }
    }

    private native long nativeCreateTraceController();

    private native void nativeStartStartupTracingIfNeeded(long r1);

    private native int nativeStartTracing(long r1, int r3, String[] r4, String[] r5, String r6, boolean r7, boolean r8);

    private native void nativeStopTracing(long r1, int r3);

    public void recordClockSyncMarker(String r1) {
    }

    private String generateTracingFileDir() {
        return this.mContext.getExternalFilesDir(null).getPath();
    }

    private static boolean isTraceEnvInited() {
        boolean r0 = isTraceEnvInit;
        if (r0 == false) goto L5;
        return r0;
    L5:
        boolean r1 = LynxTraceEnv.inst().init();
        isTraceEnvInit = r1;
        return r1;
    }

    private void refreshATraceTags() {
        Field r0 = Trace.class.getDeclaredField("sEnabledTags");     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        r0.setLong(null, ATRACE_TAG_ALL);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void startStartupTracingIfNeeded() {
        long r0 = this.mNativeTraceController;
        if (r0 == 0) goto L6;
        nativeStartStartupTracingIfNeeded(r0);
        return;
    }

    public void stopTracing() {
        long r0 = this.mNativeTraceController;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (mTracingStarted == false) goto L13;
        mTracingStarted = false;
        nativeStopTracing(r0, this.tracingSession);
        if (this.traceFilePath.isEmpty() == true) goto L12;
        onTracingComplete(this.traceFilePath);
        this.traceFilePath = NameKeys.UnloadStrategy_No_Strategy;
        return;
    L12:
        return;
    }

    private TraceController() {
        this.mCompleteCallbacks = new ArrayList();
        this.mNativeTraceController = 0;
        this.tracingSession = -1;
        if (0 != 0) goto L11;
        if (isTraceEnvInited() == false) goto L12;
        this.mNativeTraceController = nativeCreateTraceController();     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    private String generateTracingFileName() {
        return getFile().getPath();
    }

    private File getFile() {
        int r0 = Process.myPid();
        SimpleDateFormat r1 = new SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.US);
        r1.setTimeZone(TimeZone.getTimeZone("UTC"));
        return new PolarisFileWrapper(this.mContext.getExternalFilesDir(null), "lynx-profile-trace-" + r0 + "-" + r1.format(new Date()));
    }

    public void onTerminate() {
        if (TraceEvent.enableTrace() == false) goto L5;
        INVOKEVIRTUAL_com_lynx_tasm_base_TraceController_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this.mContext, this.mBroadcastReceiver);
    L5:
        this.mContext = null;
    }

    public String startTrace() {
        File r0 = getFile();
        String r8 = r0.getPath();
        startTracing(DEFAULT_BUFFER_SIZE, null, null, r8, false, false);
        Toast.makeText(this.mContext, "Trace started at: " + r8, 0).show();
        return r0.getAbsolutePath();
    }

    public void stopTrace() {
        stopTracing();
        Toast.makeText(this.mContext, "Trace stopped", 0).show();
    }

    public static TraceController getInstance() {
        return d.a;
    }

    public static boolean isTracingStarted() {
        return mTracingStarted;
    }

    public long getNativeTraceController() {
        return this.mNativeTraceController;
    }

    public /* synthetic */ TraceController(a r1) {
        this();
    }

    public static /* synthetic */ String access$200(TraceController r0) {
        return r0.generateTracingFileName();
    }

    private void setIsTracingStarted(boolean r1) {
        mTracingStarted = r1;
    }

    public void init(Context r4) {
        this.mContext = r4;
        if (TraceEvent.enableTrace() == false) goto L11;
        this.mBroadcastReceiver = new c(this);
        TraceIntentFilter r0 = new TraceIntentFilter(this.mContext);
        if (Build.VERSION.SDK_INT >= 34) goto L7;
    L9:
        INVOKEVIRTUAL_com_lynx_tasm_base_TraceController_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mBroadcastReceiver, r0);
        return;
    L7:
        if (r4.getApplicationInfo().targetSdkVersion < 34) goto L9;
        INVOKEVIRTUAL_com_lynx_tasm_base_TraceController_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mBroadcastReceiver, r0, 2);
        return;
    }

    public void onTracingComplete(String r2) {
        Iterator<b> r3 = this.mCompleteCallbacks.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().onComplete();
        goto L4
    L6:
        this.mCompleteCallbacks.clear();
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_lynx_tasm_base_TraceController_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    public void startTracing(b r9, Map<String, String> r10) {
        this.mCompleteCallbacks.add(r9);
        String r11 = generateTracingFileName();
        Boolean r0 = Boolean.FALSE;
        if (r10.containsKey("trace_file") == false) goto L5;
        r11 = r10.get("trace_file");
    L5:
        String r5 = r11;
        if (r10.containsKey("buffer_size") == false) goto L8;
        int r2 = CastIntegerProtector.parseInt(r10.get("buffer_size"));
    L10:
        if (r10.containsKey("enable_systrace") == false) goto L12;
        Boolean r12 = Boolean.valueOf(Boolean.parseBoolean(r10.get("enable_systrace")));
    L14:
        if (r10.containsKey("enable_compress") == false) goto L16;
        r0 = Boolean.valueOf(Boolean.parseBoolean(r10.get("enable_compress")));
    L16:
        startTracing(r2, null, null, r5, r12.booleanValue(), r0.booleanValue());
        return;
    L12:
        r12 = r0;
        goto L14
    L8:
        r2 = DEFAULT_BUFFER_SIZE;
        goto L10
    }

    public void startTracing(b r8, String r9) {
        this.mCompleteCallbacks.add(r8);
        startTracing(DEFAULT_BUFFER_SIZE, null, null, generateTracingFileName(), false, false);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_lynx_tasm_base_TraceController_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_lynx_tasm_base_TraceController_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10, int r11) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10, r11);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, r11, null, null, 3, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10, r11);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10, r11);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, r11);
    L35:
        return r8.registerReceiver(r9, r10, r11);
    }

    public void startTracing(int r10, String[] r11, String[] r12, String r13, boolean r14, boolean r15) {
        if (mTracingStarted == false) goto L7;
        Toast.makeText(this.mContext, "Trace already started, please stop it first", 0).show();
        return;
    L7:
        if (this.mNativeTraceController != 0) goto L9;
        return;
    L9:
        mTracingStarted = true;
        if (r13.isEmpty() == false) goto L12;
        r13 = getFile().getPath();
    L12:
        String r6 = r13;
        this.traceFilePath = r6;
        this.tracingSession = nativeStartTracing(this.mNativeTraceController, r10, r11, r12, r6, r14, r15);
        HashMap r16 = new HashMap();
        r16.put("Version", "4.1.1-rc.34");
        TraceEvent.instant(1, "Version", r16);
    }
}
