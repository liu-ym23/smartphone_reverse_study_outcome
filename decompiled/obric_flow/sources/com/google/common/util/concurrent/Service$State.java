package com.google.common.util.concurrent;

import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;

/* JADX INFO: loaded from: classes2.dex */
public final enum Service$State extends Enum<Service$State> {
    public static final Service$State FAILED = null;
    public static final Service$State NEW = null;
    public static final Service$State RUNNING = null;
    public static final Service$State STARTING = null;
    public static final Service$State STOPPING = null;
    public static final Service$State TERMINATED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Service$State[] f9397a = null;

    static {
        Service$State r5 = new Service$State("NEW", 0);
        NEW = r5;
        Service$State r10 = new Service$State("STARTING", 1);
        STARTING = r10;
        Service$State r11 = new Service$State("RUNNING", 2);
        RUNNING = r11;
        Service$State r12 = new Service$State("STOPPING", 3);
        STOPPING = r12;
        Service$State r13 = new Service$State("TERMINATED", 4);
        TERMINATED = r13;
        Service$State r14 = new Service$State(MiniAppWidgetAvailability.INSTALL_STATE_FAILED, 5);
        FAILED = r14;
        f9397a = new Service$State[]{r5, r10, r11, r12, r13, r14};
    }

    public static Service$State valueOf(String r5) {
        return (Service$State) Enum.valueOf(Service$State.class, r5);
    }

    public static Service$State[] values() {
        return (Service$State[]) f9397a.clone();
    }
}
