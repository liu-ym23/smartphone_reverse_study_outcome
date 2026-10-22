package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/TaskState;", "", "START", "COMPLETE", "CANCEL", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TaskState extends Enum<TaskState> {
    public static final TaskState CANCEL = null;
    public static final TaskState COMPLETE = null;
    public static final TaskState START = null;
    public static final /* synthetic */ TaskState[] a = null;

    static {
        TaskState r1 = new TaskState("START", 0);
        START = r1;
        TaskState r2 = new TaskState("COMPLETE", 1);
        COMPLETE = r2;
        TaskState r3 = new TaskState("CANCEL", 2);
        CANCEL = r3;
        a = new TaskState[]{r1, r2, r3};
    }

    public static TaskState valueOf(String r1) {
        return (TaskState) r27.a.a(TaskState.class, r1);
    }

    public static TaskState[] values() {
        return (TaskState[]) a.clone();
    }

    public TaskState(String r1, int r2) {
        super(r1, r2);
    }
}
