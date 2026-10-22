package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;

/* JADX INFO: loaded from: classes2.dex */
final enum Status extends Enum<Status> {
    public static final Status CANCELED = null;
    public static final Status FAILED = null;
    public static final Status IO_PENDING = null;
    public static final Status SUCCESS = null;
    public static final Status UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Status[] f4679a = null;

    static {
        Status r5 = new Status("UNKNOWN", 0);
        UNKNOWN = r5;
        Status r10 = new Status("SUCCESS", 1);
        SUCCESS = r10;
        Status r11 = new Status("IO_PENDING", 2);
        IO_PENDING = r11;
        Status r12 = new Status("CANCELED", 3);
        CANCELED = r12;
        Status r13 = new Status(MiniAppWidgetAvailability.INSTALL_STATE_FAILED, 4);
        FAILED = r13;
        f4679a = new Status[]{r5, r10, r11, r12, r13};
    }

    public static Status valueOf(String r5) {
        return (Status) Enum.valueOf(Status.class, r5);
    }

    public static Status[] values() {
        return (Status[]) f4679a.clone();
    }
}
