package com.bytedance.android.live.initialize;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/initialize/IWTOTask;", "", "", "taskID", "", "taskBusinessInfo", "", "taskCategoryList", "Lcom/bytedance/android/live/initialize/a;", "taskExecutePeriod", "Lcom/bytedance/android/live/initialize/WTOPriorityType;", "taskPriorityType", "Lcom/bytedance/android/live/initialize/WTOThreadType;", "taskThreadType", "", "run", "", "cancelable", "isEffective", "live-initialize-annotation_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IWTOTask {
    boolean cancelable();

    boolean isEffective();

    void run();

    String taskBusinessInfo();

    List<Integer> taskCategoryList();

    a taskExecutePeriod();

    int taskID();

    WTOPriorityType taskPriorityType();

    WTOThreadType taskThreadType();
}
