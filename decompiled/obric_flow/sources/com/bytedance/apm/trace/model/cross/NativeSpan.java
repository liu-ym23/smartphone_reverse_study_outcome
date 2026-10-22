package com.bytedance.apm.trace.model.cross;

import androidx.annotation.Keep;
import b7.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
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

    public NativeSpan(String r5, String r10, String r11, String r12, long r13, long r14, String r15, HashMap<String, String> r16, boolean r17, boolean r18) {
        this.spanName = r5;
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

    public a parseToSpan(e7.a r5) {
        if (this.isFinish == true) goto L5;
        return null;
    L5:
        Long.parseLong(this.spanId);
        throw null;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("NativeSpan{, spanName='");
        r5.append(this.spanName);
        r5.append("', spanId=");
        r5.append(this.spanId);
        r5.append(", parentId=");
        r5.append(this.parentId);
        r5.append(", referenceId=");
        r5.append(this.referenceId);
        r5.append(", startTime=");
        r5.append(this.startTime);
        r5.append(", finishTime=");
        r5.append(this.finishTime);
        r5.append(", threadName='");
        r5.append(this.threadName);
        r5.append("', tags=");
        r5.append(this.tags);
        r5.append(", isErrorSpan=");
        r5.append(this.isErrorSpan);
        r5.append(", isFinish=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.isFinish, '}');
    }
}
