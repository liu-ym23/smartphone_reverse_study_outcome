package com.bumptech.glide.request;

import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;

/* JADX INFO: loaded from: classes.dex */
public final enum RequestCoordinator$RequestState extends Enum<RequestCoordinator$RequestState> {
    public static final RequestCoordinator$RequestState CLEARED = null;
    public static final RequestCoordinator$RequestState FAILED = null;
    public static final RequestCoordinator$RequestState PAUSED = null;
    public static final RequestCoordinator$RequestState RUNNING = null;
    public static final RequestCoordinator$RequestState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestCoordinator$RequestState[] f1671a = null;
    private final boolean isComplete;

    static {
        RequestCoordinator$RequestState r5 = new RequestCoordinator$RequestState("RUNNING", 0, false);
        RUNNING = r5;
        RequestCoordinator$RequestState r10 = new RequestCoordinator$RequestState("PAUSED", 1, false);
        PAUSED = r10;
        RequestCoordinator$RequestState r11 = new RequestCoordinator$RequestState("CLEARED", 2, false);
        CLEARED = r11;
        RequestCoordinator$RequestState r12 = new RequestCoordinator$RequestState("SUCCESS", 3, true);
        SUCCESS = r12;
        RequestCoordinator$RequestState r13 = new RequestCoordinator$RequestState(MiniAppWidgetAvailability.INSTALL_STATE_FAILED, 4, true);
        FAILED = r13;
        f1671a = new RequestCoordinator$RequestState[]{r5, r10, r11, r12, r13};
    }

    public RequestCoordinator$RequestState(String r5, int r10, boolean r11) {
        super(r5, r10);
        this.isComplete = r11;
    }

    public static RequestCoordinator$RequestState valueOf(String r5) {
        return (RequestCoordinator$RequestState) Enum.valueOf(RequestCoordinator$RequestState.class, r5);
    }

    public static RequestCoordinator$RequestState[] values() {
        return (RequestCoordinator$RequestState[]) f1671a.clone();
    }

    public boolean isComplete() {
        return this.isComplete;
    }
}
