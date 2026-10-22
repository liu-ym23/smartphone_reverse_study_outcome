package com.bytedance.lego.init.model;

import d6.c;
import java.io.Serializable;
import m3.a;

/* JADX INFO: loaded from: classes.dex */
public class FeedShowTaskInfo implements Serializable, Comparable<FeedShowTaskInfo> {

    @c("moduleName")
    public String moduleName;

    @c("mustRunInMainThread")
    public boolean mustRunInMainThread;

    @c("priority")
    public int priority;
    public transient a task;

    @c("taskId")
    public String taskId;

    public FeedShowTaskInfo() {
    }

    public FeedShowTaskInfo(String r10, String r11, a r12, boolean r13, int r14) {
        this.taskId = r10;
        this.moduleName = r11;
        this.mustRunInMainThread = r13;
        this.priority = r14;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FeedShowTaskInfo r10) {
        int r11 = this.priority;
        int r12 = r10.priority;
        if (r11 >= r12) goto L6;
        return 1;
    L6:
        if (r11 <= r12) goto L10;
        return -1;
    L10:
        throw null;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FeedShowTaskInfo r10) {
        return compareTo2(r10);
    }

    public String toString() {
        return this.priority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName;
    }
}
