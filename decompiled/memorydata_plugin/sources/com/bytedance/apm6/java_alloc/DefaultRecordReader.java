package com.bytedance.apm6.java_alloc;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.java_alloc.model.ReportInfo;
import com.bytedance.apm6.util.log.Logger;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DefaultRecordReader implements IRecordReader {
    private static final String TAG = "APM-Alloc-RecordReader";
    private JavaAllocConfig config;
    private long duration;
    public final ArrayList<ReportInfo> result;
    private String scene;
    private final DefaultTraceReader traceReader;

    public DefaultRecordReader() {
        this.result = new ArrayList();
        this.traceReader = new DefaultTraceReader();
    }

    public JSONObject getConfig() {
        JavaAllocConfig r0 = this.config;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.packJson();
    }

    public long getDuration() {
        return this.duration;
    }

    public ArrayList<ReportInfo> getResult() {
        return this.result;
    }

    @Override // com.bytedance.apm6.java_alloc.IRecordReader
    public void onHeadInfo(String r3, long r4, long r6, int r8, JavaAllocConfig r9, long r10, long r12) {
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d(TAG, "report totalObjectsCount: " + r4 + ", totalBytes: " + r6 + ", recordCount: " + r8);
    L5:
        this.traceReader.clear();
        this.scene = r3;
        this.config = r9;
        this.duration = r12 - r10;
        this.result.ensureCapacity(r8);
    }

    @Override // com.bytedance.apm6.java_alloc.IRecordReader
    public boolean onItem(String r9, int r10, int r11, Trace r12, int r13) {
        this.traceReader.setTrace(r12);
        r12.onTrace(this.traceReader);
        ReportInfo r14 = new ReportInfo(r9, r10, r11, r13, this.scene, new ArrayList(this.traceReader.getResult()));
        this.result.add(r14);
        this.traceReader.clear();
        return true;
    }
}
