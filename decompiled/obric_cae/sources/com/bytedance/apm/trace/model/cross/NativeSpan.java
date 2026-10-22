package com.bytedance.apm.trace.model.cross;

import androidx.annotation.Keep;
import d3.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class NativeSpan {
    private long finishTime;
    private boolean isErrorSpan;
    private boolean isFinish;
    private String parentId;
    private String referenceId;
    private String spanId;
    private String spanName;
    private long startTime;
    private Map<String, String> tags;
    private String threadName;

    public NativeSpan(String r8, String r10, String r11, String r12, long r13, long r14, String r15, HashMap<String, String> r16, boolean r17, boolean r18) {
        this.spanName = r8;
        this.spanId = r10;
        this.parentId = r11;
        this.referenceId = r12;
        this.startTime = r13;
        this.finishTime = r14;
        this.threadName = r15;
        this.tags = r16;
        this.isErrorSpan = r17;
        this.isFinish = r18;
    }

    public long getFinishTime() {
        return this.finishTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public a parseToSpan(f3.a r8) {
        if (this.isFinish == true) goto L5;
        return null;
    L5:
        Long.parseLong(this.spanId);
        throw null;
    }

    public String toString() {
        return "NativeSpan{, spanName='" + this.spanName + "', spanId=" + this.spanId + ", parentId=" + this.parentId + ", referenceId=" + this.referenceId + ", startTime=" + this.startTime + ", finishTime=" + this.finishTime + ", threadName='" + this.threadName + "', tags=" + this.tags + ", isErrorSpan=" + this.isErrorSpan + ", isFinish=" + this.isFinish + '}';
    }
}
