package com.bumptech.glide.request;

import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;

/* JADX INFO: loaded from: classes.dex */
final enum SingleRequest$Status extends Enum<SingleRequest$Status> {
    public static final SingleRequest$Status CLEARED = null;
    public static final SingleRequest$Status COMPLETE = null;
    public static final SingleRequest$Status FAILED = null;
    public static final SingleRequest$Status PENDING = null;
    public static final SingleRequest$Status RUNNING = null;
    public static final SingleRequest$Status WAITING_FOR_SIZE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SingleRequest$Status[] f1672a = null;

    static {
        SingleRequest$Status r5 = new SingleRequest$Status("PENDING", 0);
        PENDING = r5;
        SingleRequest$Status r10 = new SingleRequest$Status("RUNNING", 1);
        RUNNING = r10;
        SingleRequest$Status r11 = new SingleRequest$Status("WAITING_FOR_SIZE", 2);
        WAITING_FOR_SIZE = r11;
        SingleRequest$Status r12 = new SingleRequest$Status("COMPLETE", 3);
        COMPLETE = r12;
        SingleRequest$Status r13 = new SingleRequest$Status(MiniAppWidgetAvailability.INSTALL_STATE_FAILED, 4);
        FAILED = r13;
        SingleRequest$Status r14 = new SingleRequest$Status("CLEARED", 5);
        CLEARED = r14;
        f1672a = new SingleRequest$Status[]{r5, r10, r11, r12, r13, r14};
    }

    public static SingleRequest$Status valueOf(String r5) {
        return (SingleRequest$Status) Enum.valueOf(SingleRequest$Status.class, r5);
    }

    public static SingleRequest$Status[] values() {
        return (SingleRequest$Status[]) f1672a.clone();
    }
}
