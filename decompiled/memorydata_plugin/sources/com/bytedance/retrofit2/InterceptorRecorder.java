package com.bytedance.retrofit2;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class InterceptorRecorder {
    public Deque<LogEntry> interceptorLogStack;
    public Deque<LogEntry> interceptorLogTrace;

    public static class LogEntry {
        public String exception_name;
        public boolean isInternalInterceptor;
        public String name;
        public long reqEndNs;
        public long reqStartNs;
        public long rspEndNs;
        public long rspStartNs;

        LogEntry(String r3, boolean r4, long r5) {
            this.reqStartNs = -1;
            this.reqEndNs = -1;
            this.rspStartNs = -1;
            this.rspEndNs = -1;
            this.exception_name = null;
            this.name = r3;
            this.isInternalInterceptor = r4;
            this.reqStartNs = r5;
        }

        public LogEntry deepCopy() {
            LogEntry r0 = new LogEntry(this.name, this.isInternalInterceptor, this.reqStartNs);
            r0.reqEndNs = this.reqEndNs;
            r0.rspStartNs = this.rspStartNs;
            r0.rspEndNs = this.rspEndNs;
            r0.exception_name = this.exception_name;
            return r0;
        }
    }

    public InterceptorRecorder() {
        this.interceptorLogStack = new ArrayDeque();
        this.interceptorLogTrace = new ArrayDeque();
    }

    public InterceptorRecorder deepCopy() {
        InterceptorRecorder r0 = new InterceptorRecorder();
        r0.interceptorLogStack = new ArrayDeque();
        Iterator<LogEntry> r1 = this.interceptorLogStack.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        LogEntry r2 = (LogEntry) ZeusTransformUtils.preCheckCast(r1.next(), LogEntry.class, "com.obric.memorydata.plugin");
        r0.interceptorLogStack.push(r2.deepCopy());
        goto L4
    L6:
        r0.interceptorLogTrace = new ArrayDeque();
        Iterator<LogEntry> r5 = this.interceptorLogTrace.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        LogEntry r3 = (LogEntry) ZeusTransformUtils.preCheckCast(r5.next(), LogEntry.class, "com.obric.memorydata.plugin");
        r0.interceptorLogTrace.push(r3.deepCopy());
        goto L8
    L10:
        return r0;
    }

    public LogEntry peek() {
        return (LogEntry) ZeusTransformUtils.preCheckCast(this.interceptorLogStack.peek(), LogEntry.class, "com.obric.memorydata.plugin");
    }

    public LogEntry pop() {
        LogEntry r0 = (LogEntry) ZeusTransformUtils.preCheckCast(this.interceptorLogStack.pop(), LogEntry.class, "com.obric.memorydata.plugin");     // Catch: NoSuchElementException -> L4
        this.interceptorLogTrace.push(r0);     // Catch: NoSuchElementException -> L4
        return r0;
    L4:
        return null;
    }

    public void push(LogEntry r1) {
        this.interceptorLogStack.push(r1);
    }

    public int size() {
        return this.interceptorLogStack.size();
    }

    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        JSONArray r1 = new JSONArray();
        new HashMap();
        Iterator<LogEntry> r14 = this.interceptorLogTrace.iterator();
        long r4 = 0;
        long r6 = 0;
    L4:
        if (r14.hasNext() == false) goto L15;
        LogEntry r8 = (LogEntry) ZeusTransformUtils.preCheckCast(r14.next(), LogEntry.class, "com.obric.memorydata.plugin");
        JSONObject r9 = new JSONObject();
        r9.put(ActivityLifecycle.NAME, r8.name);
        long r10 = TTMetricsUtil.calculateDurationUs(r8.reqStartNs, r8.reqEndNs);
        if (r10 <= 0) goto L8;
        r4 = r4 + r10;
    L8:
        r9.put("req", r10);
        long r11 = TTMetricsUtil.calculateDurationUs(r8.rspStartNs, r8.rspEndNs);
        if (r11 <= 0) goto L11;
        r6 = r6 + r11;
    L11:
        r9.put("rsp", r11);
        if (r8.exception_name == null) goto L14;
        r9.put("ex", r8.exception_name);
    L14:
        r1.put(r9);
        goto L4
    L15:
        r0.put(MemoryListActivity.JUMP_FROM_DETAIL, r1);
        r0.put("req_total", r4);
        r0.put("rsp_total", r6);
        return r0;
    }
}
