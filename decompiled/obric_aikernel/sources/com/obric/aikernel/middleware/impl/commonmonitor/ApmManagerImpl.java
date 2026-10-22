package com.obric.aikernel.middleware.impl.commonmonitor;

import android.os.SystemClock;
import android.util.Log;
import androidx.work.WorkRequest;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.commonmonitor.IApmManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import r0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class ApmManagerImpl implements IApmManager {
    private static final String DEFAULT_SPAN_MODULE_NAME = "base";
    public static final ApmManagerImpl INSTANCE = null;
    private static final String TAG = "ApmManagerImpl";
    private static volatile String enterFrom;
    private static final ConcurrentHashMap<String, String> extendedParams = null;
    private static volatile boolean isNewApp;
    private static volatile boolean isRecordEnd;
    private static volatile boolean isRecordStart;
    private static final ConcurrentHashMap<String, Long> sendToBdTrackerSpans = null;
    private static final ConcurrentHashMap<String, Long> spanStartTime = null;
    private static volatile long startTraceTime;

    static {
        INSTANCE = new ApmManagerImpl();
        spanStartTime = new ConcurrentHashMap();
        sendToBdTrackerSpans = new ConcurrentHashMap();
        extendedParams = new ConcurrentHashMap();
    }

    private ApmManagerImpl() {
    }

    @JvmStatic
    public static final ApmManagerImpl getInstance() {
        return INSTANCE;
    }

    private final void log(String r10) {
        Log.i(TAG, r10);
    }

    private final String replaceSpecialChars(String r13) {
        return StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r13, "/", "_", false, 4, null), "\\", "_", false, 4, null), "__", "_", false, 4, null), new char[]{' ', '_'});
    }

    @Override // com.obric.aikernel.middleware.api.commonmonitor.IApmManager
    public void addExtendedParams(Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        extendedParams.putAll(r10);
    }

    @Override // com.obric.aikernel.middleware.api.commonmonitor.IApmManager
    public void endSpan(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "moduleName");
        Intrinsics.checkNotNullParameter(r11, "taskName");
        if (isRecordEnd == false) goto L5;
        return;
    L5:
        String r13 = r10 + '/' + r11;
        Long r14 = spanStartTime.get(r13);
        if (r14 == null) goto L8;
        Long r15 = Long.valueOf(SystemClock.elapsedRealtime() - r14.longValue());
    L9:
        StringBuilder r16 = new StringBuilder();
        r16.append("endSpan: moduleName = ");
        r16.append(r10);
        r16.append(", taskName = ");
        r16.append(r11);
        r16.append(", usedTime = ");
        if (r15 != null) goto L12;
        Object r17 = "unknown";
    L13:
        r16.append(r17);
        r16.append(" ms");
        log(r16.toString());
        if (r12 == false) goto L17;
        if (r15 == null) goto L17;
        sendToBdTrackerSpans.put(r13, r15);
    L17:
        c.b(r10, r11);
        return;
    L12:
        r17 = r15;
        goto L13
    L8:
        r15 = null;
        goto L9
    }

    @Override // com.obric.aikernel.middleware.api.commonmonitor.IApmManager
    public void endSpan(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "taskName");
        endSpan(DEFAULT_SPAN_MODULE_NAME, r10, r11);
    }

    @Override // com.obric.aikernel.middleware.api.commonmonitor.IApmManager
    public synchronized void endTrace() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (isRecordStart == true) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (isRecordEnd == true) goto L15;
        int r10 = 1;
        isRecordEnd = true;     // Catch: Throwable -> L17
        long r11 = SystemClock.elapsedRealtime() - startTraceTime;     // Catch: Throwable -> L17
        if (isNewApp == true) goto L12;
        r10 = 2;
    L12:
        c.c(r10, AppContext.INSTANCE.getPackageName() + ".MainPage", WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);     // Catch: Throwable -> L17
        log("endTrace, usedTime = " + r11 + " ms");     // Catch: Throwable -> L17
        spanStartTime.clear();     // Catch: Throwable -> L17
        sendToBdTrackerSpans.clear();     // Catch: Throwable -> L17
        extendedParams.clear();     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    @Override // com.obric.aikernel.middleware.api.commonmonitor.IApmManager
    public void markAsNewApp() {
        isNewApp = true;
    }

    @Override // com.obric.aikernel.middleware.api.commonmonitor.IApmManager
    public void reportThreadCount(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sceneName");
        com.bytedance.apm.c.s(r10);
    }

    @Override // com.obric.aikernel.middleware.api.commonmonitor.IApmManager
    public void setEnterFrom(String r10) {
        enterFrom = r10;
    }

    @Override // com.obric.aikernel.middleware.api.commonmonitor.IApmManager
    public void slardarMonitorEvent(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r10, "serviceName");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullParameter(r12, EventBody.KEY_METRIC);
        Intrinsics.checkNotNullParameter(r13, "extraLog");
        com.bytedance.apm.c.h(r10, r11, r12, null);
    }

    @Override // com.obric.aikernel.middleware.api.commonmonitor.IApmManager
    public void startSpan(String r10) {
        Intrinsics.checkNotNullParameter(r10, "taskName");
        startSpan(DEFAULT_SPAN_MODULE_NAME, r10);
    }

    @Override // com.obric.aikernel.middleware.api.commonmonitor.IApmManager
    public void startSpan(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "moduleName");
        Intrinsics.checkNotNullParameter(r11, "taskName");
        if (isRecordEnd == false) goto L5;
        return;
    L5:
        log("startSpan: moduleName = " + r10 + ", taskName = " + r11);
        spanStartTime.put(r10 + '/' + r11, Long.valueOf(SystemClock.elapsedRealtime()));
        c.h(r10, r11);
    }

    @Override // com.obric.aikernel.middleware.api.commonmonitor.IApmManager
    public synchronized void startTrace() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (isRecordStart == false) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (isRecordEnd == true) goto L11;
        isRecordStart = true;     // Catch: Throwable -> L13
        startTraceTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L13
        c.i();     // Catch: Throwable -> L13
        log("startTrace");     // Catch: Throwable -> L13
        monitor-exit(this);
    }
}
