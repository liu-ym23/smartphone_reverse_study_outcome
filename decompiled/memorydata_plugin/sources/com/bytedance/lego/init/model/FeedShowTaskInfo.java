package com.bytedance.lego.init.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class FeedShowTaskInfo implements Serializable, Comparable<FeedShowTaskInfo> {

    @SerializedName("moduleName")
    public String moduleName;

    @SerializedName("mustRunInMainThread")
    public boolean mustRunInMainThread;

    @SerializedName("priority")
    public int priority;
    public transient BaseFeedShowTask task;

    @SerializedName("taskId")
    public String taskId;

    public FeedShowTaskInfo() {
    }

    public FeedShowTaskInfo(String r1, String r2, BaseFeedShowTask r3, boolean r4, int r5) {
        this.taskId = r1;
        this.moduleName = r2;
        this.task = r3;
        this.mustRunInMainThread = r4;
        this.priority = r5;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FeedShowTaskInfo r3) {
        int r0 = this.priority;
        int r1 = r3.priority;
        if (r0 >= r1) goto L6;
        return 1;
    L6:
        if (r0 <= r1) goto L10;
        return -1;
    L10:
        return this.task.getClass().getSimpleName().compareTo(r3.task.getClass().getSimpleName());
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(FeedShowTaskInfo r3) {
        return compareTo2((FeedShowTaskInfo) ZeusTransformUtils.preCheckCast(r3, FeedShowTaskInfo.class, "com.obric.memorydata.plugin"));
    }

    public String toString() {
        return this.priority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName;
    }
}
