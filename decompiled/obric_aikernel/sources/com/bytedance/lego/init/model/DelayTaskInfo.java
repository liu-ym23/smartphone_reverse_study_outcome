package com.bytedance.lego.init.model;

import d6.c;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DelayTaskInfo implements Serializable, Comparable<DelayTaskInfo> {

    @c("delayTime")
    public DelayTime delayTime;

    @c("moduleName")
    public String moduleName;

    @c("mustRunInMainThread")
    public boolean mustRunInMainThread;

    @c("priority")
    public int priority;

    @c("realPriority")
    public int realPriority;

    @c("runInProcess")
    public List<String> runInProcess;
    public transient m3.c task;

    @c("taskId")
    public String taskId;

    public DelayTaskInfo() {
    }

    public DelayTaskInfo(String r10, String r11, m3.c r12, boolean r13, List<String> r14, int r15, DelayTime r16) {
        this.taskId = r10;
        this.moduleName = r11;
        this.mustRunInMainThread = r13;
        this.runInProcess = r14;
        this.priority = r15;
        this.delayTime = r16;
        this.realPriority = r16.getValue() - r15;
    }

    private String listToString(List<String> r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L15;
        StringBuilder r11 = new StringBuilder();
        r11.append("[");
        r11.append(r10.get(0));
        int r12 = 1;
    L8:
        if (r12 >= r10.size()) goto L10;
        r11.append("," + r10.get(r12));
        r12 = r12 + 1;
        goto L8
    L10:
        r11.append("]");
        return r11.toString();
    L15:
        return null;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(DelayTaskInfo r10) {
        int r11 = this.realPriority;
        int r12 = r10.realPriority;
        if (r11 >= r12) goto L6;
        return -1;
    L6:
        if (r11 <= r12) goto L10;
        return 1;
    L10:
        throw null;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(DelayTaskInfo r10) {
        return compareTo2(r10);
    }

    public String toString() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName + "," + this.delayTime.name() + "," + this.priority + "," + listToString(this.runInProcess);
    }
}
