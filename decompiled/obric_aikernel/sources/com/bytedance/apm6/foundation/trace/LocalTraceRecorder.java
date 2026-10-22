package com.bytedance.apm6.foundation.trace;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm6.foundation.context.ApmContext;
import e0.a;
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

    public static void asyncTraceBegin(@NonNull String r10, long r11, @NonNull String r12, @NonNull String r13, long r14, int r15, @Nullable JSONObject r16) {
        a.d(LOG_TAG, new TraceBean().setProcessName(r10).setProcessId(r11).setTraceName(r12).setTimeStamp(r14).setName(r13).setAsyncTag(r15).setTraceType(TraceBean.TraceType.ASYNC_SLICE_BEGIN).setDebugAnnotation(r16).toJsonString());
    }

    public static void asyncTraceBegin(@NonNull String r10, @NonNull String r11, int r12, @Nullable JSONObject r13) {
        asyncTraceBegin(r10, r11, System.currentTimeMillis(), r12, r13);
    }

    public static void asyncTraceBegin(@NonNull String r10, @NonNull String r11, long r12, int r13, @Nullable JSONObject r14) {
        asyncTraceBegin(ApmContext.getCurrentProcessName(), pid, r10, r11, r12, r13, r14);
    }

    public static void asyncTraceEnd(@NonNull String r10, int r11, long r12, @Nullable JSONObject r13) {
        asyncTraceEnd(ApmContext.getCurrentProcessName(), pid, r10, r11, r12, r13);
    }

    public static void asyncTraceEnd(@NonNull String r10, int r11, @Nullable JSONObject r12) {
        asyncTraceEnd(r10, r11, System.currentTimeMillis(), r12);
    }

    public static void asyncTraceEnd(@NonNull String r10, long r11, @NonNull String r12, int r13, long r14, @Nullable JSONObject r15) {
        a.d(LOG_TAG, new TraceBean().setProcessName(r10).setProcessId(r11).setTraceName(r12).setAsyncTag(r13).setTimeStamp(r14).setTraceType(TraceBean.TraceType.ASYNC_SLICE_END).setDebugAnnotation(r15).toJsonString());
    }

    public static void traceBegin(@NonNull String r10, long r11, @NonNull String r12, @NonNull String r13, long r14, @Nullable JSONObject r15) {
        a.d(LOG_TAG, new TraceBean().setProcessName(r10).setProcessId(r11).setTraceName(r12).setTimeStamp(r14).setName(r13).setTraceType(TraceBean.TraceType.SLICE_BEGIN).setDebugAnnotation(r15).toJsonString());
    }

    public static void traceBegin(@NonNull String r10, @NonNull String r11, long r12, @Nullable JSONObject r13) {
        traceBegin(ApmContext.getCurrentProcessName(), pid, r10, r11, r12, r13);
    }

    public static void traceBegin(@NonNull String r10, @NonNull String r11, @Nullable JSONObject r12) {
        traceBegin(r10, r11, System.currentTimeMillis(), r12);
    }

    public static void traceCounter(@NonNull String r10, int r11) {
        traceCounter(r10, r11, System.currentTimeMillis());
    }

    public static void traceCounter(@NonNull String r10, int r11, long r12) {
        traceCounter(ApmContext.getCurrentProcessName(), pid, r10, r11, r12);
    }

    public static void traceCounter(@NonNull String r10, @NonNull long r11, @NonNull String r12, int r13, long r14) {
        a.d(LOG_TAG, new TraceBean().setProcessName(r10).setProcessId(r11).setTraceName(r12).setTimeStamp(r14).setCounterValue(r13).setTraceType(TraceBean.TraceType.COUNTER).toJsonString());
    }

    public static void traceEnd(@NonNull String r10, long r11, @NonNull String r12, long r13, @Nullable JSONObject r14) {
        a.d(LOG_TAG, new TraceBean().setProcessName(r10).setProcessId(r11).setTraceName(r12).setTimeStamp(r13).setTraceType(TraceBean.TraceType.SLICE_END).setDebugAnnotation(r14).toJsonString());
    }

    public static void traceEnd(@NonNull String r10, long r11, @Nullable JSONObject r12) {
        traceEnd(ApmContext.getCurrentProcessName(), pid, r10, r11, r12);
    }

    public static void traceEnd(@NonNull String r10, @Nullable JSONObject r11) {
        traceEnd(r10, System.currentTimeMillis(), r11);
    }

    public static void traceEvent(@NonNull String r10, long r11, @NonNull String r12, @NonNull String r13, long r14, @Nullable JSONObject r15) {
        a.d(LOG_TAG, new TraceBean().setProcessName(r10).setProcessId(r11).setTraceName(r12).setTimeStamp(r14).setName(r13).setTraceType(TraceBean.TraceType.SLICE_INSTANT).setDebugAnnotation(r15).toJsonString());
    }

    public static void traceEvent(@NonNull String r10, @NonNull String r11, long r12, @Nullable JSONObject r13) {
        traceEvent(ApmContext.getCurrentProcessName(), pid, r10, r11, r12, r13);
    }

    public static void traceEvent(@NonNull String r10, @NonNull String r11, @Nullable JSONObject r12) {
        traceEvent(r10, r11, System.currentTimeMillis(), r12);
    }

    public static void traceFloatCounter(@NonNull String r10, float r11) {
        traceFloatCounter(r10, r11, System.currentTimeMillis());
    }

    public static void traceFloatCounter(@NonNull String r10, float r11, long r12) {
        traceFloatCounter(ApmContext.getCurrentProcessName(), pid, r10, r11, r12);
    }

    public static void traceFloatCounter(@NonNull String r10, long r11, @NonNull String r12, float r13, long r14) {
        a.d(LOG_TAG, new TraceBean().setProcessName(r10).setProcessId(r11).setTraceName(r12).setTimeStamp(r14).setFloatCounterValue(r13).setTraceType(TraceBean.TraceType.FLOAT_COUNTER).toJsonString());
    }
}
