package com.bytedance.apm6.foundation.trace;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
            TraceType r0 = new TraceType("SLICE_BEGIN", 0, 0);
            SLICE_BEGIN = r0;
            TraceType r1 = new TraceType("SLICE_END", 1, 1);
            SLICE_END = r1;
            TraceType r3 = new TraceType("ASYNC_SLICE_BEGIN", 2, 2);
            ASYNC_SLICE_BEGIN = r3;
            TraceType r5 = new TraceType("ASYNC_SLICE_END", 3, 3);
            ASYNC_SLICE_END = r5;
            TraceType r7 = new TraceType("SLICE_INSTANT", 4, 4);
            SLICE_INSTANT = r7;
            TraceType r9 = new TraceType("COUNTER", 5, 5);
            COUNTER = r9;
            TraceType r11 = new TraceType("FLOAT_COUNTER", 6, 6);
            FLOAT_COUNTER = r11;
            $VALUES = new TraceType[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private TraceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        static /* synthetic */ int access$000(TraceType r0) {
            return r0.value;
        }

        public static TraceType valueOf(String r2) {
            return (TraceType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TraceType.class, r2), TraceType.class, "com.obric.memorydata.plugin");
        }

        public static TraceType[] values() {
            return (TraceType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TraceType[].class, "com.obric.memorydata.plugin");
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

    public TraceBean setAsyncTag(int r1) {
        this.asyncTag = r1;
        return this;
    }

    public TraceBean setCounterValue(int r1) {
        this.counterValue = r1;
        return this;
    }

    public TraceBean setDebugAnnotation(JSONObject r1) {
        this.debugAnnotation = r1;
        return this;
    }

    public TraceBean setFloatCounterValue(float r1) {
        this.floatCounterValue = r1;
        return this;
    }

    public TraceBean setName(String r1) {
        this.name = r1;
        return this;
    }

    public TraceBean setProcessId(long r1) {
        this.processId = r1;
        return this;
    }

    public TraceBean setProcessName(String r1) {
        this.processName = r1;
        return this;
    }

    public TraceBean setTimeStamp(long r1) {
        this.timeStamp = r1;
        return this;
    }

    public TraceBean setTraceName(String r1) {
        this.traceName = r1;
        return this;
    }

    public TraceBean setTraceType(TraceType r1) {
        this.traceType = r1;
        return this;
    }

    String toJsonString() {
        JSONObject r0 = new JSONObject();
        r0.putOpt("processName", this.processName).putOpt("processId", Long.valueOf(this.processId)).putOpt("traceName", this.traceName).putOpt("timestamp", Long.valueOf(this.timeStamp)).putOpt("traceType", Integer.valueOf(TraceType.access$000(this.traceType)));     // Catch: JSONException -> L25
        if (this.traceType != TraceType.COUNTER) goto L8;
        String r1 = "counterValue";
        Object r2 = Integer.valueOf(this.counterValue);     // Catch: JSONException -> L25
    L6:
        r0.putOpt(r1, r2);     // Catch: JSONException -> L25
    L16:
        if (this.traceType != TraceType.ASYNC_SLICE_BEGIN) goto L18;
    L19:
        r0.putOpt("asyncTag", Integer.valueOf(this.asyncTag));     // Catch: JSONException -> L25
    L20:
        JSONObject r5 = this.debugAnnotation;     // Catch: JSONException -> L25
        if (r5 == null) goto L24;
        r0.putOpt("debugAnnotation", r5);     // Catch: JSONException -> L25
    L24:
        return r0.toString();
    L18:
        if (this.traceType != TraceType.ASYNC_SLICE_END) goto L20;
    L8:
        if (this.traceType != TraceType.FLOAT_COUNTER) goto L11;
        r1 = "floatCounterValue";
        r2 = Float.valueOf(this.floatCounterValue);     // Catch: JSONException -> L25
        goto L6
    L11:
        if (this.traceType == TraceType.SLICE_END) goto L16;
        if (this.traceType == TraceType.ASYNC_SLICE_END) goto L16;
        r1 = ActivityLifecycle.NAME;
        r2 = this.name;     // Catch: JSONException -> L25
    L25:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
