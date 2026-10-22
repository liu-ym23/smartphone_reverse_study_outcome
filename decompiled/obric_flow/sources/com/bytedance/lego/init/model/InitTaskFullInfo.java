package com.bytedance.lego.init.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InitTaskFullInfo implements Serializable, Comparable<InitTaskFullInfo> {

    @SerializedName("afterPrivacyPopupWindow")
    public boolean afterPrivacyPopupWindow;
    public transient List<String> child;
    public transient List<String> dependencies;

    @SerializedName("dependon")
    public String[] dependon;

    @SerializedName("desc")
    public String desc;

    @SerializedName("earliestPeriod")
    public InitPeriod earliestPeriod;

    @SerializedName("executePriority")
    public int executePriority;

    @SerializedName("latestPeriod")
    public InitPeriod latestPeriod;

    @SerializedName("moduleName")
    public String moduleName;

    @SerializedName("mustRunInMainThread")
    public boolean mustRunInMainThread;
    public transient List<String> parent;
    public transient int priority;
    public transient float realPriority;

    @SerializedName("runInProcess")
    public List<String> runInProcess;

    @SerializedName("taskClassName")
    public String taskClassName;

    @SerializedName("taskId")
    public String taskId;

    public InitTaskFullInfo() {
        this.earliestPeriod = InitPeriod.APP_ATTACHBASE2SUPER;
        this.latestPeriod = InitPeriod.NONE;
        this.priority = -1;
        this.realPriority = 0.0f;
    }

    public static String a(List r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.isEmpty() == true) goto L15;
        StringBuilder r10 = new StringBuilder("[");
        r10.append((String) r5.get(0));
        int r11 = 1;
    L8:
        if (r11 >= r5.size()) goto L10;
        r10.append("," + ((String) r5.get(r11)));
        r11 = r11 + 1;
        goto L8
    L10:
        r10.append("]");
        return r10.toString();
    L15:
        return null;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(InitTaskFullInfo r5) {
        return compareTo2(r5);
    }

    public String getFullContent() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName + "," + this.taskClassName + "," + a(this.runInProcess) + "," + a(this.dependencies) + "," + a(this.child) + "," + a(this.parent);
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.realPriority);
        r5.append(",");
        r5.append(this.taskId);
        r5.append(",");
        r5.append(this.mustRunInMainThread);
        r5.append(",[");
        InitPeriod r10 = this.earliestPeriod;
        if (r10 != null) goto L5;
        String r11 = InitPeriod.NONE.name();
    L6:
        r5.append(r11);
        r5.append(",");
        InitPeriod r12 = this.latestPeriod;
        if (r12 != null) goto L9;
        String r13 = InitPeriod.NONE.name();
    L10:
        r5.append(r13);
        r5.append("],");
        String[] r14 = this.dependon;
        if (r14 != null) goto L13;
    L20:
        String r15 = null;
    L21:
        r5.append(r15);
        r5.append(",");
        r5.append(a(this.runInProcess));
        r5.append(",");
        r5.append(this.moduleName);
        return r5.toString();
    L13:
        if (r14.length <= 0) goto L20;
        StringBuilder r16 = new StringBuilder("[");
        r16.append(r14[0]);
        int r17 = 1;
    L17:
        if (r17 >= r14.length) goto L19;
        r16.append("," + r14[r17]);
        r17 = r17 + 1;
        goto L17
    L19:
        r16.append("]");
        r15 = r16.toString();
        goto L21
    L9:
        r13 = r12.name();
        goto L10
    L5:
        r11 = r10.name();
        goto L6
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(InitTaskFullInfo r5) {
        float r10 = r5.realPriority - this.realPriority;
        if (r10 <= 0.0f) goto L7;
        return 1;
    L7:
        if (r10 >= 0.0f) goto L11;
        return -1;
    L11:
        return this.taskClassName.compareTo(r5.taskClassName);
    }

    public InitTaskFullInfo(String r5, Boolean r10, boolean r11, InitPeriod r12, InitPeriod r13, float r14, List<String> r15, List<String> r16, List<String> r17, List<String> r18, String r19) {
        this.earliestPeriod = InitPeriod.APP_ATTACHBASE2SUPER;
        this.latestPeriod = InitPeriod.NONE;
        this.priority = -1;
        this.realPriority = 0.0f;
        this.taskId = r5;
        this.mustRunInMainThread = r10.booleanValue();
        this.earliestPeriod = r12;
        this.latestPeriod = r13;
        this.realPriority = r14;
        this.runInProcess = r15;
        this.child = r16;
        this.parent = r17;
        this.dependencies = r18;
        this.taskClassName = r19;
        this.afterPrivacyPopupWindow = r11;
    }
}
