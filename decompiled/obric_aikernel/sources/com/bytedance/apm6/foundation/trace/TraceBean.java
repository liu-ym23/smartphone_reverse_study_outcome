package com.bytedance.apm6.foundation.trace;

import com.bytedance.crash.tracker.ActivityLifecycle;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class TraceBean {
    int asyncTag;
    int counterValue;
    JSONObject debugAnnotation;
    float floatCounterValue;
    String name;
    long processId;
    String processName;
    long timeStamp;
    String traceName;
    TraceType traceType;

    static final enum TraceType extends Enum<TraceType> {
        private static final /* synthetic */ TraceType[] $VALUES = null;
        public static final TraceType ASYNC_SLICE_BEGIN = null;
        public static final TraceType ASYNC_SLICE_END = null;
        public static final TraceType COUNTER = null;
        public static final TraceType FLOAT_COUNTER = null;
        public static final TraceType SLICE_BEGIN = null;
        public static final TraceType SLICE_END = null;
        public static final TraceType SLICE_INSTANT = null;
        private final int value;

        static {
            TraceType r10 = new TraceType("SLICE_BEGIN", 0, 0);
            SLICE_BEGIN = r10;
            TraceType r11 = new TraceType("SLICE_END", 1, 1);
            SLICE_END = r11;
            TraceType r12 = new TraceType("ASYNC_SLICE_BEGIN", 2, 2);
            ASYNC_SLICE_BEGIN = r12;
            TraceType r13 = new TraceType("ASYNC_SLICE_END", 3, 3);
            ASYNC_SLICE_END = r13;
            TraceType r14 = new TraceType("SLICE_INSTANT", 4, 4);
            SLICE_INSTANT = r14;
            TraceType r15 = new TraceType("COUNTER", 5, 5);
            COUNTER = r15;
            TraceType r16 = new TraceType("FLOAT_COUNTER", 6, 6);
            FLOAT_COUNTER = r16;
            $VALUES = new TraceType[]{r10, r11, r12, r13, r14, r15, r16};
        }

        private TraceType(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        static /* synthetic */ int access$000(TraceType r10) {
            return r10.value;
        }

        public static TraceType valueOf(String r10) {
            return (TraceType) Enum.valueOf(TraceType.class, r10);
        }

        public static TraceType[] values() {
            return (TraceType[]) $VALUES.clone();
        }
    }

    TraceBean() {
    }

    public int getAsyncTag() {
        return this.asyncTag;
    }

    public float getCounterValue() {
        return this.counterValue;
    }

    public JSONObject getDebugAnnotation() {
        return this.debugAnnotation;
    }

    public float getFloatCounterValue() {
        return this.floatCounterValue;
    }

    public String getName() {
        return this.name;
    }

    public long getProcessId() {
        return this.processId;
    }

    public String getProcessName() {
        return this.processName;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String getTraceName() {
        return this.traceName;
    }

    public TraceType getTraceType() {
        return this.traceType;
    }

    public TraceBean setAsyncTag(int r10) {
        this.asyncTag = r10;
        return this;
    }

    public TraceBean setCounterValue(int r10) {
        this.counterValue = r10;
        return this;
    }

    public TraceBean setDebugAnnotation(JSONObject r10) {
        this.debugAnnotation = r10;
        return this;
    }

    public TraceBean setFloatCounterValue(float r10) {
        this.floatCounterValue = r10;
        return this;
    }

    public TraceBean setName(String r10) {
        this.name = r10;
        return this;
    }

    public TraceBean setProcessId(long r10) {
        this.processId = r10;
        return this;
    }

    public TraceBean setProcessName(String r10) {
        this.processName = r10;
        return this;
    }

    public TraceBean setTimeStamp(long r10) {
        this.timeStamp = r10;
        return this;
    }

    public TraceBean setTraceName(String r10) {
        this.traceName = r10;
        return this;
    }

    public TraceBean setTraceType(TraceType r10) {
        this.traceType = r10;
        return this;
    }

    String toJsonString() {
        JSONObject r10 = new JSONObject();
        r10.putOpt("processName", this.processName).putOpt("processId", Long.valueOf(this.processId)).putOpt("traceName", this.traceName).putOpt("timestamp", Long.valueOf(this.timeStamp)).putOpt("traceType", Integer.valueOf(TraceType.access$000(this.traceType)));     // Catch: JSONException -> L25
        TraceType r11 = this.traceType;     // Catch: JSONException -> L25
        if (r11 != TraceType.COUNTER) goto L8;
        String r12 = "counterValue";
        Object r13 = Integer.valueOf(this.counterValue);     // Catch: JSONException -> L25
    L6:
        r10.putOpt(r12, r13);     // Catch: JSONException -> L25
    L15:
        TraceType r14 = this.traceType;     // Catch: JSONException -> L25
        if (r14 != TraceType.ASYNC_SLICE_BEGIN) goto L18;
    L19:
        r10.putOpt("asyncTag", Integer.valueOf(this.asyncTag));     // Catch: JSONException -> L25
    L20:
        JSONObject r15 = this.debugAnnotation;     // Catch: JSONException -> L25
        if (r15 == null) goto L24;
        r10.putOpt("debugAnnotation", r15);     // Catch: JSONException -> L25
    L24:
        return r10.toString();
    L18:
        if (r14 != TraceType.ASYNC_SLICE_END) goto L20;
    L8:
        if (r11 != TraceType.FLOAT_COUNTER) goto L11;
        r12 = "floatCounterValue";
        r13 = Float.valueOf(this.floatCounterValue);     // Catch: JSONException -> L25
        goto L6
    L11:
        if (r11 == TraceType.SLICE_END) goto L15;
        if (r11 == TraceType.ASYNC_SLICE_END) goto L15;
        r12 = ActivityLifecycle.NAME;
        r13 = this.name;     // Catch: JSONException -> L25
    L25:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
