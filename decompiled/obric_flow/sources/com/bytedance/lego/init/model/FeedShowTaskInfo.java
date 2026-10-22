package com.bytedance.lego.init.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kf.a;

/* JADX INFO: loaded from: classes2.dex */
public class FeedShowTaskInfo implements Serializable, Comparable<FeedShowTaskInfo> {

    @SerializedName("moduleName")
    public String moduleName;

    @SerializedName("mustRunInMainThread")
    public boolean mustRunInMainThread;

    @SerializedName("priority")
    public int priority;
    public transient a task;

    @SerializedName("taskId")
    public String taskId;

    public FeedShowTaskInfo() {
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FeedShowTaskInfo r5) {
        return compareTo2(r5);
    }

    public String toString() {
        return this.priority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName;
    }

    public FeedShowTaskInfo(String r5, String r10, a r11, boolean r12, int r13) {
        this.taskId = r5;
        this.moduleName = r10;
        this.mustRunInMainThread = r12;
        this.priority = r13;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FeedShowTaskInfo r5) {
        int r10 = this.priority;
        int r11 = r5.priority;
        if (r10 >= r11) goto L6;
        return 1;
    L6:
        if (r10 <= r11) goto L10;
        return -1;
    L10:
        throw null;
    }
}
