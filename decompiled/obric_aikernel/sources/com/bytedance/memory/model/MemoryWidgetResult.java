package com.bytedance.memory.model;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MemoryWidgetResult implements Serializable {
    private static final long serialVersionUID = 5865887187300488157L;
    private List<ResultLeakNode> mActivityLeakNodes;
    private List<ResultLeakNode> mBigObjLeakNodes;
    private List<ResultLeakNode> mBitmapLeakNodes;
    private List<ClassNumber> mClassNumbers;
    private MemoryWidgetMonitor mMemoryWidgetMonitor;

    public static class MemoryWidgetMonitor implements Serializable {
        private static final long serialVersionUID = -5276649811675595534L;
        private int appHeapInstanceSize;
        private long gcDurationMs;
        private long heapDumpDurationMs;
        private String heapDumpFilePath;
        private long heapDumpFileSize;
        private boolean isDebug;
        private int leakTraceSize;
        private String referenceName;
        private String stepTrace;
        private long watchDurationMs;

        public MemoryWidgetMonitor() {
        }

        public int getAppHeapInstanceSize() {
            return this.appHeapInstanceSize;
        }

        public long getGcDurationMs() {
            return this.gcDurationMs;
        }

        public long getHeapDumpDurationMs() {
            return this.heapDumpDurationMs;
        }

        public String getHeapDumpFilePath() {
            return this.heapDumpFilePath;
        }

        public long getHeapDumpFileSize() {
            return this.heapDumpFileSize;
        }

        public int getLeakTraceSize() {
            return this.leakTraceSize;
        }

        public String getReferenceName() {
            return this.referenceName;
        }

        public String getStepTrace() {
            return this.stepTrace;
        }

        public long getWatchDurationMs() {
            return this.watchDurationMs;
        }

        public boolean isDebug() {
            return this.isDebug;
        }

        public void setAppHeapInstanceSize(int r10) {
            this.appHeapInstanceSize = r10;
        }

        public void setDebug(boolean r10) {
            this.isDebug = r10;
        }

        public void setGcDurationMs(long r10) {
            this.gcDurationMs = r10;
        }

        public void setHeapDumpDurationMs(long r10) {
            this.heapDumpDurationMs = r10;
        }

        public void setHeapDumpFilePath(String r10) {
            this.heapDumpFilePath = r10;
        }

        public void setHeapDumpFileSize(long r10) {
            this.heapDumpFileSize = r10;
        }

        public void setLeakTraceSize(int r10) {
            this.leakTraceSize = r10;
        }

        public void setReferenceName(String r10) {
            this.referenceName = r10;
        }

        public void setStepTrace(String r10) {
            this.stepTrace = r10;
        }

        public void setWatchDurationMs(long r10) {
            this.watchDurationMs = r10;
        }

        @NonNull
        public String toString() {
            JSONObject r10 = new JSONObject();
            r10.put("appHeapInstanceSize", getAppHeapInstanceSize());     // Catch: JSONException -> L5
            r10.put("gcDurationMs", getGcDurationMs());     // Catch: JSONException -> L5
            r10.put("heapDumpDurationMs", getHeapDumpDurationMs());     // Catch: JSONException -> L5
            r10.put("heapDumpFilePath", getHeapDumpFilePath());     // Catch: JSONException -> L5
            r10.put("heapDumpFileSize", getHeapDumpFileSize());     // Catch: JSONException -> L5
            r10.put("leakTraceSize", getLeakTraceSize());     // Catch: JSONException -> L5
            r10.put("referenceName", getReferenceName());     // Catch: JSONException -> L5
            r10.put("stepTrace", getStepTrace());     // Catch: JSONException -> L5
            r10.put("watchDurationMs", getWatchDurationMs());     // Catch: JSONException -> L5
        L8:
            return r10.toString();
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }
    }

    public static class ResultLeakNode implements Serializable {
        private static final long serialVersionUID = -3143585016293965793L;
        private String leakClass;
        private String leakTrace;
        private double retainedHeapSize;

        public ResultLeakNode() {
        }

        public String getLeakClass() {
            return this.leakClass;
        }

        public String getLeakTrace() {
            return this.leakTrace;
        }

        public double getRetainedHeapSize() {
            return this.retainedHeapSize;
        }

        public void setLeakClass(String r10) {
            this.leakClass = r10;
        }

        public void setLeakTrace(String r10) {
            this.leakTrace = r10;
        }

        public void setRetainedHeapSize(double r10) {
            this.retainedHeapSize = r10;
        }

        @NonNull
        public String toString() {
            JSONObject r10 = new JSONObject();
            r10.put("object_class", getLeakClass());     // Catch: JSONException -> L5
            r10.put("object_trace", getLeakTrace());     // Catch: JSONException -> L5
            r10.put("retained_heap_size", getRetainedHeapSize());     // Catch: JSONException -> L5
        L8:
            return r10.toString();
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }
    }

    public MemoryWidgetResult() {
        this.mBigObjLeakNodes = new ArrayList();
        this.mActivityLeakNodes = new ArrayList();
        this.mBitmapLeakNodes = new ArrayList();
        this.mClassNumbers = new ArrayList();
        this.mMemoryWidgetMonitor = new MemoryWidgetMonitor();
    }

    private void transformLeakNodes(@NonNull JSONArray r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.length()) goto L11;
        ResultLeakNode r12 = new ResultLeakNode();
        r12.setRetainedHeapSize(r10.getJSONObject(0).optDouble("retainedHeapSize"));     // Catch: JSONException -> L8
        r12.setLeakClass(r10.getJSONObject(0).optString("leakClass"));     // Catch: JSONException -> L8
        r12.setLeakTrace(r10.getJSONObject(0).optString("leakTrace"));     // Catch: JSONException -> L8
    L10:
        this.mBigObjLeakNodes.add(r12);
        r11 = r11 + 1;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private void transformMonitor(@NonNull JSONObject r10) {
        this.mMemoryWidgetMonitor.setAppHeapInstanceSize(r10.optInt("appHeapInstanceSize"));
        this.mMemoryWidgetMonitor.setLeakTraceSize(r10.optInt("LeakTraceSize"));
        this.mMemoryWidgetMonitor.setHeapDumpFilePath(r10.optString("heapDumpFilePath"));
        this.mMemoryWidgetMonitor.setHeapDumpFileSize(r10.optInt("heapDumpFileSize"));
        this.mMemoryWidgetMonitor.setReferenceName(r10.optString("referenceName"));
        this.mMemoryWidgetMonitor.setDebug(r10.optBoolean("isDebug"));
        this.mMemoryWidgetMonitor.setWatchDurationMs(r10.optInt("watchDurationMs"));
        this.mMemoryWidgetMonitor.setGcDurationMs(r10.optInt("gcDurationMs"));
        this.mMemoryWidgetMonitor.setHeapDumpDurationMs(r10.optInt("heapDumpDurationMs"));
    }

    private void wrapToJson(JSONObject r10, JSONArray r11, JSONArray r12, JSONArray r13, JSONArray r14) {
        r10.put("object_node", r11);     // Catch: JSONException -> L4
        r10.put("activity_node", r12);     // Catch: JSONException -> L4
        r10.put("bitmap_node", r13);     // Catch: JSONException -> L4
        r10.put("instance_count_node", r14);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public List<ResultLeakNode> getActivityLeakNodes() {
        return this.mActivityLeakNodes;
    }

    @NonNull
    public List<ResultLeakNode> getBigObjLeakNodes() {
        return this.mBigObjLeakNodes;
    }

    public List<ResultLeakNode> getBitmapLeakNodes() {
        return this.mBitmapLeakNodes;
    }

    public List<ClassNumber> getClassNumbers() {
        return this.mClassNumbers;
    }

    @NonNull
    public MemoryWidgetMonitor getMemoryWidgetMonitor() {
        return this.mMemoryWidgetMonitor;
    }

    public void setActivityLeakNodes(List<ResultLeakNode> r10) {
        this.mActivityLeakNodes = r10;
    }

    public void setBigObjLeakNodes(@NonNull List<ResultLeakNode> r10) {
        this.mBigObjLeakNodes = r10;
    }

    public void setBitmapLeakNodes(List<ResultLeakNode> r10) {
        this.mBitmapLeakNodes = r10;
    }

    public void setClassNumbers(List<ClassNumber> r10) {
        this.mClassNumbers = r10;
    }

    public void setMemoryWidgetMonitor(@NonNull MemoryWidgetMonitor r10) {
        this.mMemoryWidgetMonitor = r10;
    }

    @NonNull
    public String toString() {
        JSONObject r10 = new JSONObject();
        JSONArray r11 = new JSONArray();
        JSONArray r12 = new JSONArray();
        JSONArray r13 = new JSONArray();
        JSONArray r14 = new JSONArray();
        Iterator<ResultLeakNode> r15 = this.mBigObjLeakNodes.iterator();
    L4:
        if (r15.hasNext() == false) goto L10;
        r11.put(new JSONObject(r15.next().toString()));     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        Iterator<ResultLeakNode> r16 = this.mActivityLeakNodes.iterator();
    L12:
        if (r16.hasNext() == false) goto L18;
        r12.put(new JSONObject(r16.next().toString()));     // Catch: JSONException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L18:
        Iterator<ResultLeakNode> r17 = this.mBitmapLeakNodes.iterator();
    L20:
        if (r17.hasNext() == false) goto L26;
        r13.put(new JSONObject(r17.next().toString()));     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L26:
        Iterator<ClassNumber> r18 = this.mClassNumbers.iterator();
    L28:
        if (r18.hasNext() == false) goto L34;
        r14.put(new JSONObject(r18.next().toString()));     // Catch: JSONException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L34:
        wrapToJson(r10, r11, r12, r13, r14);
        return r10.toString();
    }

    public void transForm(@NonNull JSONArray r10, @NonNull JSONObject r11) {
        transformLeakNodes(r10);
        transformMonitor(r11);
    }
}
