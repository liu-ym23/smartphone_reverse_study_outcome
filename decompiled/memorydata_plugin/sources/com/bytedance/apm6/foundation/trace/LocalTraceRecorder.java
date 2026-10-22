package com.bytedance.apm6.foundation.trace;

import android.os.Process;
import com.bytedance.apm.e.a;
import com.bytedance.apm6.foundation.context.ApmContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocalTraceRecorder {
    private static final String LOG_TAG = "LogGenTrace";
    private static final int pid = 0;

    static {
        pid = Process.myPid();
    }

    public LocalTraceRecorder() {
    }

    public static void asyncTraceBegin(String r1, long r2, String r4, String r5, long r6, int r8, JSONObject r9) {
        a.b(LOG_TAG, new TraceBean().setProcessName(r1).setProcessId(r2).setTraceName(r4).setTimeStamp(r6).setName(r5).setAsyncTag(r8).setTraceType(TraceBean.TraceType.ASYNC_SLICE_BEGIN).setDebugAnnotation(r9).toJsonString());
    }

    public static void asyncTraceBegin(String r6, String r7, int r8, JSONObject r9) {
        asyncTraceBegin(r6, r7, System.currentTimeMillis(), r8, r9);
    }

    public static void asyncTraceBegin(String r9, String r10, long r11, int r13, JSONObject r14) {
        asyncTraceBegin(ApmContext.getCurrentProcessName(), pid, r9, r10, r11, r13, r14);
    }

    public static void asyncTraceEnd(String r8, int r9, long r10, JSONObject r12) {
        asyncTraceEnd(ApmContext.getCurrentProcessName(), pid, r8, r9, r10, r12);
    }

    public static void asyncTraceEnd(String r2, int r3, JSONObject r4) {
        asyncTraceEnd(r2, r3, System.currentTimeMillis(), r4);
    }

    public static void asyncTraceEnd(String r1, long r2, String r4, int r5, long r6, JSONObject r8) {
        a.b(LOG_TAG, new TraceBean().setProcessName(r1).setProcessId(r2).setTraceName(r4).setAsyncTag(r5).setTimeStamp(r6).setTraceType(TraceBean.TraceType.ASYNC_SLICE_END).setDebugAnnotation(r8).toJsonString());
    }

    public static void traceBegin(String r1, long r2, String r4, String r5, long r6, JSONObject r8) {
        a.b(LOG_TAG, new TraceBean().setProcessName(r1).setProcessId(r2).setTraceName(r4).setTimeStamp(r6).setName(r5).setTraceType(TraceBean.TraceType.SLICE_BEGIN).setDebugAnnotation(r8).toJsonString());
    }

    public static void traceBegin(String r8, String r9, long r10, JSONObject r12) {
        traceBegin(ApmContext.getCurrentProcessName(), pid, r8, r9, r10, r12);
    }

    public static void traceBegin(String r2, String r3, JSONObject r4) {
        traceBegin(r2, r3, System.currentTimeMillis(), r4);
    }

    public static void traceCounter(String r2, int r3) {
        traceCounter(r2, r3, System.currentTimeMillis());
    }

    public static void traceCounter(String r7, int r8, long r9) {
        traceCounter(ApmContext.getCurrentProcessName(), pid, r7, r8, r9);
    }

    public static void traceCounter(String r1, long r2, String r4, int r5, long r6) {
        a.b(LOG_TAG, new TraceBean().setProcessName(r1).setProcessId(r2).setTraceName(r4).setTimeStamp(r6).setCounterValue(r5).setTraceType(TraceBean.TraceType.COUNTER).toJsonString());
    }

    public static void traceEnd(String r1, long r2, String r4, long r5, JSONObject r7) {
        a.b(LOG_TAG, new TraceBean().setProcessName(r1).setProcessId(r2).setTraceName(r4).setTimeStamp(r5).setTraceType(TraceBean.TraceType.SLICE_END).setDebugAnnotation(r7).toJsonString());
    }

    public static void traceEnd(String r7, long r8, JSONObject r10) {
        traceEnd(ApmContext.getCurrentProcessName(), pid, r7, r8, r10);
    }

    public static void traceEnd(String r2, JSONObject r3) {
        traceEnd(r2, System.currentTimeMillis(), r3);
    }

    public static void traceEvent(String r1, long r2, String r4, String r5, long r6, JSONObject r8) {
        a.b(LOG_TAG, new TraceBean().setProcessName(r1).setProcessId(r2).setTraceName(r4).setTimeStamp(r6).setName(r5).setTraceType(TraceBean.TraceType.SLICE_INSTANT).setDebugAnnotation(r8).toJsonString());
    }

    public static void traceEvent(String r8, String r9, long r10, JSONObject r12) {
        traceEvent(ApmContext.getCurrentProcessName(), pid, r8, r9, r10, r12);
    }

    public static void traceEvent(String r2, String r3, JSONObject r4) {
        traceEvent(r2, r3, System.currentTimeMillis(), r4);
    }

    public static void traceFloatCounter(String r2, float r3) {
        traceFloatCounter(r2, r3, System.currentTimeMillis());
    }

    public static void traceFloatCounter(String r7, float r8, long r9) {
        traceFloatCounter(ApmContext.getCurrentProcessName(), pid, r7, r8, r9);
    }

    public static void traceFloatCounter(String r1, long r2, String r4, float r5, long r6) {
        a.b(LOG_TAG, new TraceBean().setProcessName(r1).setProcessId(r2).setTraceName(r4).setTimeStamp(r6).setFloatCounterValue(r5).setTraceType(TraceBean.TraceType.FLOAT_COUNTER).toJsonString());
    }
}
