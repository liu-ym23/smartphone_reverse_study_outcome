package com.ss.android.lark.opmonitor.service;

import android.os.SystemClock;
import android.os.Trace;
import byb.e;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.OfficeSDKDriveErrorCodes;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import fyb.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class OPMonitor {
    private static final String TAG = "OPMonitor";

    @SerializedName("categories")
    @Expose
    private HashMap<String, Object> categories;
    private OPMonitorCode code;
    private OPMonitorCode codeIfError;
    private HashMap<String, Object> commons;
    private long endTime;
    private boolean flushed;
    private OPMonitorLevel level;

    @SerializedName("metrics")
    @Expose
    private HashMap<String, Object> metrics;

    @SerializedName(AppbrandHostConstants.Schema_Meta.NAME)
    @Expose
    private String name;
    private int reportPlatform;
    private e service;
    private long startTime;
    private Set<String> tags;
    private long time;

    private synchronized void flushInner() {
        monitor-enter(this);
    L46:
        th = move-exception;
        throw th;
    L4:
        if (this.flushed == false) goto L9;
        Log.w(TAG, "this opmonitor is already flushed!!!");     // Catch: Throwable -> L46
        monitor-exit(this);
        return;
    L9:
        this.flushed = true;     // Catch: Throwable -> L46
        OPMonitorCode r0 = this.code;     // Catch: Throwable -> L46
        if (r0 == null) goto L13;
    L17:
        if (this.level != null) goto L20;
        if (r0 == null) goto L20;
        setLevel(r0.level);     // Catch: Throwable -> L46
    L20:
        if (r0 == null) goto L23;
        addCategoryValue("monitor_domain", r0.domain);     // Catch: Throwable -> L46
        addCategoryValue("monitor_code", Integer.valueOf(r0.code));     // Catch: Throwable -> L46
        addCategoryValue("monitor_id", r0.ID);     // Catch: Throwable -> L46
        addCategoryValue("monitor_message", r0.message);     // Catch: Throwable -> L46
    L23:
        if (this.tags.size() <= 0) goto L26;
        addCategoryValue("monitor_tags", tagsInLine());     // Catch: Throwable -> L46
    L26:
        if (fyb.e.b.a == null) goto L28;
        this.commons.putAll(Collections.EMPTY_MAP);     // Catch: Throwable -> L46
    L28:
        Trace.beginSection("computeFlushCommons");     // Catch: Throwable -> L46
        HashMap<String, Object> r1 = this.commons;     // Catch: Throwable -> L46
        if (r1 != null) goto L31;
    L41:
        Trace.endSection();     // Catch: Throwable -> L46
        if (this.service == null) goto L44;
        Trace.beginSection("computeServiceFlush");     // Catch: Throwable -> L46
        this.service.flush(this);     // Catch: Throwable -> L46
        Trace.endSection();     // Catch: Throwable -> L46
        Trace.beginSection("computeServiceLog");     // Catch: Throwable -> L46
        this.service.log(this);     // Catch: Throwable -> L46
        Trace.endSection();     // Catch: Throwable -> L46
    L44:
        monitor-exit(this);
        return;
    L31:
        if (r1.size() <= 0) goto L41;
        Iterator<String> r2 = this.commons.keySet().iterator();     // Catch: Throwable -> L46
    L34:
        if (r2.hasNext() == false) goto L41;
        String r3 = r2.next();     // Catch: Throwable -> L46
        if (containsKey(r3) == true) goto L34;
        Object r4 = this.commons.get(r3);     // Catch: Throwable -> L46
        if ((r4 instanceof Number) == true) goto L39;
        addCategoryValue(r3, r4);     // Catch: Throwable -> L46
        goto L34
    L39:
        addMetricValue(r3, r4);     // Catch: Throwable -> L46
        goto L34
    L13:
        if (hasErrorInfo() == false) goto L15;
        r0 = this.codeIfError;     // Catch: Throwable -> L46
        goto L17
    L15:
        r0 = null;
        goto L17
    }

    public synchronized void flush() {
        monitor-enter(this);
        flushInner();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized HashMap<String, Object> getCategories() {
        monitor-enter(this);
        HashMap<String, Object> r0 = this.categories;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized HashMap<String, Object> getCommons() {
        monitor-enter(this);
        HashMap<String, Object> r0 = this.commons;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized HashMap<String, Object> getData() {
        monitor-enter(this);
        HashMap<String, Object> r0 = new HashMap();     // Catch: Throwable -> L6
        r0.putAll(this.metrics);     // Catch: Throwable -> L6
        r0.putAll(this.categories);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized OPMonitorLevel getLevel() {
        monitor-enter(this);
        OPMonitorLevel r0 = this.level;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized HashMap<String, Object> getMetrics() {
        monitor-enter(this);
        HashMap<String, Object> r0 = this.metrics;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String getName() {
        monitor-enter(this);
        String r0 = this.name;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized OPMonitor timing() {
        monitor-enter(this);
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
        long r2 = this.startTime;     // Catch: Throwable -> L9
        if (r2 != 0) goto L6;
        this.startTime = r0;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return this;
    L6:
        this.endTime = r0;     // Catch: Throwable -> L9
        addMetricValue("duration", Long.valueOf(r0 - r2));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private boolean hasErrorInfo() {
        if (getValue(UniContext.KEY_OF_ERROR_CODE) == null) goto L5;
    L8:
        return true;
    L5:
        if (getValue(UniContext.KEY_OF_ERROR_MSG) != null) goto L8;
        return false;
    }

    private String tagsInLine() {
        Set<String> r0 = this.tags;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.size() == 0) goto L21;
        StringBuilder r1 = new StringBuilder();
        Iterator<String> r2 = this.tags.iterator();
        boolean r3 = true;
    L9:
        if (r2.hasNext() == false) goto L15;
        String r4 = r2.next();
        if (r3 == true) goto L13;
        r1.append(a.COMMA);
    L13:
        r1.append(r4);
        r3 = false;
        goto L9
    L15:
        return r1.toString();
    L21:
        return null;
    }

    public OPMonitorCode getMonitorCode() {
        OPMonitorCode r0 = this.code;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (hasErrorInfo() == true) goto L10;
        return null;
    L10:
        return this.codeIfError;
    }

    public OPMonitor setResultTypeCancel() {
        return setResultType("cancel");
    }

    public OPMonitor setResultTypeFail() {
        return setResultType("fail");
    }

    public OPMonitor setResultTypeSuccess() {
        return setResultType("success");
    }

    public OPMonitor setResultTypeTimeout() {
        return setResultType(OfficeSDKDriveErrorCodes.TIMEOUT);
    }

    public int getReportPlatform() {
        return this.reportPlatform;
    }

    public OPMonitor(OPMonitorCode r3) {
        this(fyb.e.b, null, r3);
    }

    public synchronized OPMonitor addCommonParams(Map<String, Object> r2) {
        monitor-enter(this);
        if (r2 != null) goto L13;
    L11:
        monitor-exit(this);
        return this;
    L13:
    L8:
        th = move-exception;
        throw th;
    L5:
        if (r2.size() <= 0) goto L11;
        this.commons.putAll(r2);     // Catch: Throwable -> L8
        goto L11
    }

    public OPMonitor addMap(Map<String, Object> r5) {
        Iterator<String> r0 = r5.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String r1 = r0.next();
        Object r2 = r5.get(r1);
        if ((r2 instanceof Number) == true) goto L7;
        addCategoryValue(r1, r2);
        goto L4
    L7:
        addMetricValue(r1, r2);
        goto L4
    L9:
        return this;
    }

    public synchronized OPMonitor addTag(String r2) {
        monitor-enter(this);
        this.tags.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean containsKey(String r2) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.metrics.containsKey(r2) == true) goto L9;
        if (this.categories.containsKey(r2) == true) goto L9;
        boolean r3 = false;
    L10:
        monitor-exit(this);
        return r3;
    L9:
        r3 = true;
        goto L10
    }

    public synchronized void flush(e r4) {
        monitor-enter(this);
        Trace.beginSection("computeMonitorTime");     // Catch: Throwable -> L23
        if (this.flushed == false) goto L9;
        Log.w(TAG, "this opmonitor is already flushed!!!");     // Catch: Throwable -> L23
        Trace.endSection();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L9:
        if (r4 != null) goto L14;
        Log.w(TAG, "serviceInterface is null!");     // Catch: Throwable -> L23
        Trace.endSection();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L14:
        if ((r4 instanceof OPTrace) == true) goto L16;
    L20:
        this.service = r4;     // Catch: Throwable -> L23
        flushInner();     // Catch: Throwable -> L23
        Trace.endSection();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L16:
        if (((OPTrace) r4).getBatchEnabled() == true) goto L20;
        Log.w(TAG, "batchEnabled is false,traceId:" + ((OPTrace) r4).getTracingID());     // Catch: Throwable -> L23
        Trace.endSection();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public synchronized Object getValue(String r2) {
        monitor-enter(this);
        Object r0 = this.metrics.get(r2);     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = this.categories.get(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    public OPMonitor reportPlatform(int r1) {
        this.reportPlatform = r1;
        return this;
    }

    public OPMonitor setDuration(long r2) {
        addMetricValue("duration", Long.valueOf(r2));
        return this;
    }

    public OPMonitor setError(Throwable r4) {
        if (r4 == null) goto L8;
        StackTraceElement[] r5 = r4.getStackTrace();
        if (r5 == null) goto L8;
        if (r5.length <= 0) goto L8;
        addCategoryValue("monitor_line", Integer.valueOf(r5[0].getLineNumber()));
        addCategoryValue("monitor_function", r5[0].getMethodName());
        addCategoryValue("monitor_file", r5[0].getClassName());
    L8:
        return this;
    }

    public OPMonitor setErrorCode(String r2) {
        addCategoryValue(UniContext.KEY_OF_ERROR_CODE, r2);
        return this;
    }

    public OPMonitor setErrorMessage(String r2) {
        addCategoryValue(UniContext.KEY_OF_ERROR_MSG, r2);
        return this;
    }

    public synchronized OPMonitor setLevel(OPMonitorLevel r2) {
        monitor-enter(this);
        this.level = r2;     // Catch: Throwable -> L6
        addCategoryValue("monitor_level", Integer.valueOf(r2.getNumber()));     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized OPMonitor setMonitorCode(OPMonitorCode r1) {
        monitor-enter(this);
        this.code = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized OPMonitor setMonitorCodeIfError(OPMonitorCode r1) {
        monitor-enter(this);
        this.codeIfError = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public OPMonitor setResultType(String r2) {
        addCategoryValue("result_type", r2);
        return this;
    }

    public synchronized OPMonitor setTime(long r2) {
        monitor-enter(this);
        this.time = r2;     // Catch: Throwable -> L6
        addMetricValue("time", Long.valueOf(r2));     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public OPMonitor tracing(OPTrace r2) {
        addCategoryValue("trace_id", r2.getTracingID());
        return this;
    }

    public OPMonitor(String r3) {
        this(fyb.e.b, r3, null);
    }

    public OPMonitor tracing(String r2) {
        addCategoryValue("trace_id", r2);
        return this;
    }

    public OPMonitor(String r2, OPMonitorCode r3) {
        this(fyb.e.b, r2, r3);
    }

    public synchronized OPMonitor addCategoryValue(String r2, Object r3) {
        monitor-enter(this);
        this.categories.put(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized OPMonitor addMetricValue(String r2, Object r3) {
        monitor-enter(this);
        this.metrics.put(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public OPMonitor(e r2, OPMonitorCode r3) {
        this(r2, null, r3);
    }

    public OPMonitor(e r2, String r3) {
        this(r2, r3, null);
    }

    public OPMonitor(e r2, String r3, OPMonitorCode r4) {
        this.flushed = false;
        this.service = r2;
        this.name = r3;
        this.code = r4;
        this.metrics = new HashMap();
        this.categories = new HashMap();
        this.tags = new HashSet();
        this.commons = new HashMap();
    }
}
