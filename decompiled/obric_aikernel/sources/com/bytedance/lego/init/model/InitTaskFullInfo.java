package com.bytedance.lego.init.model;

import d6.c;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InitTaskFullInfo implements Serializable, Comparable<InitTaskFullInfo> {

    @c("afterPrivacyPopupWindow")
    public boolean afterPrivacyPopupWindow;
    public transient List<String> child;
    public transient List<String> dependencies;

    @c("dependon")
    public String[] dependon;

    @c("desc")
    public String desc;

    @c("earliestPeriod")
    public InitPeriod earliestPeriod;

    @c("executePriority")
    public int executePriority;

    @c("latestPeriod")
    public InitPeriod latestPeriod;

    @c("moduleName")
    public String moduleName;

    @c("mustRunInMainThread")
    public boolean mustRunInMainThread;
    public transient List<String> parent;
    public transient int priority;
    public transient float realPriority;

    @c("runInProcess")
    public List<String> runInProcess;

    @c("taskClassName")
    public String taskClassName;

    @c("taskId")
    public String taskId;

    public InitTaskFullInfo() {
        this.earliestPeriod = InitPeriod.APP_ATTACHBASE2SUPER;
        this.latestPeriod = InitPeriod.NONE;
        this.priority = -1;
        this.realPriority = 0.0f;
    }

    public InitTaskFullInfo(String r10, Boolean r11, boolean r12, InitPeriod r13, InitPeriod r14, float r15, List<String> r16, List<String> r17, List<String> r18, List<String> r19, String r110) {
        this.earliestPeriod = InitPeriod.APP_ATTACHBASE2SUPER;
        this.latestPeriod = InitPeriod.NONE;
        this.priority = -1;
        this.realPriority = 0.0f;
        this.taskId = r10;
        this.mustRunInMainThread = r11.booleanValue();
        this.earliestPeriod = r13;
        this.latestPeriod = r14;
        this.realPriority = r15;
        this.runInProcess = r16;
        this.child = r17;
        this.parent = r18;
        this.dependencies = r19;
        this.taskClassName = r110;
        this.afterPrivacyPopupWindow = r12;
    }

    private String arrayToString(String[] r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.length <= 0) goto L15;
        StringBuilder r11 = new StringBuilder();
        r11.append("[");
        r11.append(r10[0]);
        int r12 = 1;
    L8:
        if (r12 >= r10.length) goto L10;
        r11.append("," + r10[r12]);
        r12 = r12 + 1;
        goto L8
    L10:
        r11.append("]");
        return r11.toString();
    L15:
        return null;
    }

    private String getPeriodStr(InitPeriod r10) {
        if (r10 != null) goto L6;
        return InitPeriod.NONE.name();
    L6:
        return r10.name();
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
    public int compareTo2(InitTaskFullInfo r10) {
        float r11 = r10.realPriority - this.realPriority;
        if (r11 <= 0.0f) goto L7;
        return 1;
    L7:
        if (r11 >= 0.0f) goto L11;
        return -1;
    L11:
        return this.taskClassName.compareTo(r10.taskClassName);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(InitTaskFullInfo r10) {
        return compareTo2(r10);
    }

    public String getFullContent() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName + "," + this.taskClassName + "," + listToString(this.runInProcess) + "," + listToString(this.dependencies) + "," + listToString(this.child) + "," + listToString(this.parent);
    }

    public String toString() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread + ",[" + getPeriodStr(this.earliestPeriod) + "," + getPeriodStr(this.latestPeriod) + "]," + arrayToString(this.dependon) + "," + listToString(this.runInProcess) + "," + this.moduleName;
    }
}
