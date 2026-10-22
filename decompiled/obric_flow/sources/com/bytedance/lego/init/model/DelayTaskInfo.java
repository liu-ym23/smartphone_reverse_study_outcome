package com.bytedance.lego.init.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kf.b;

/* JADX INFO: loaded from: classes2.dex */
public class DelayTaskInfo implements Serializable, Comparable<DelayTaskInfo> {

    @SerializedName("delayTime")
    public DelayTime delayTime;

    @SerializedName("moduleName")
    public String moduleName;

    @SerializedName("mustRunInMainThread")
    public boolean mustRunInMainThread;

    @SerializedName("priority")
    public int priority;

    @SerializedName("realPriority")
    public int realPriority;

    @SerializedName("runInProcess")
    public List<String> runInProcess;
    public transient b task;

    @SerializedName("taskId")
    public String taskId;

    public DelayTaskInfo() {
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(DelayTaskInfo r5) {
        return compareTo2(r5);
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.realPriority);
        r5.append(",");
        r5.append(this.taskId);
        r5.append(",");
        r5.append(this.mustRunInMainThread);
        r5.append(",");
        r5.append(this.moduleName);
        r5.append(",");
        r5.append(this.delayTime.name());
        r5.append(",");
        r5.append(this.priority);
        r5.append(",");
        List<String> r10 = this.runInProcess;
        if (r10 != null) goto L5;
    L12:
        String r11 = null;
    L13:
        r5.append(r11);
        return r5.toString();
    L5:
        if (r10.isEmpty() == true) goto L12;
        StringBuilder r12 = new StringBuilder("[");
        r12.append(r10.get(0));
        int r13 = 1;
    L9:
        if (r13 >= r10.size()) goto L11;
        r12.append("," + r10.get(r13));
        r13 = r13 + 1;
        goto L9
    L11:
        r12.append("]");
        r11 = r12.toString();
        goto L13
    }

    public DelayTaskInfo(String r5, String r10, b r11, boolean r12, List<String> r13, int r14, DelayTime r15) {
        this.taskId = r5;
        this.moduleName = r10;
        this.mustRunInMainThread = r12;
        this.runInProcess = r13;
        this.priority = r14;
        this.delayTime = r15;
        this.realPriority = r15.getValue() - r14;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(DelayTaskInfo r5) {
        int r10 = this.realPriority;
        int r11 = r5.realPriority;
        if (r10 >= r11) goto L6;
        return -1;
    L6:
        if (r10 <= r11) goto L10;
        return 1;
    L10:
        throw null;
    }
}
