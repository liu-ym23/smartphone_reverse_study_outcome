package com.bytedance.apm6.java_alloc;

import androidx.annotation.RequiresApi;
import com.bytedance.apm6.java_alloc.model.ReportInfo;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 19)
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
        JavaAllocConfig r10 = this.config;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.packJson();
    }

    public long getDuration() {
        return this.duration;
    }

    public ArrayList<ReportInfo> getResult() {
        return this.result;
    }

    @Override // com.bytedance.apm6.java_alloc.IRecordReader
    public void onHeadInfo(String r10, long r11, long r12, int r13, JavaAllocConfig r14, long r15, long r16) {
        if (ApmBaseContext.isDebugMode() == false) goto L5;
        Logger.d(TAG, "report totalObjectsCount: " + r11 + ", totalBytes: " + r12 + ", recordCount: " + r13);
    L5:
        this.traceReader.clear();
        this.scene = r10;
        this.config = r14;
        this.duration = r16 - r15;
        this.result.ensureCapacity(r13);
    }

    @Override // com.bytedance.apm6.java_alloc.IRecordReader
    public boolean onItem(String r10, int r11, int r12, Trace r13, int r14) {
        this.traceReader.setTrace(r13);
        r13.onTrace(this.traceReader);
        ReportInfo r15 = new ReportInfo(r10, r11, r12, r14, this.scene, new ArrayList(this.traceReader.getResult()));
        this.result.add(r15);
        this.traceReader.clear();
        return true;
    }
}
