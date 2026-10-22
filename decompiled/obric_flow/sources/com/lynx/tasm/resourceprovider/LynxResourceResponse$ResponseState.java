package com.lynx.tasm.resourceprovider;

import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;

/* JADX INFO: loaded from: classes2.dex */
public final enum LynxResourceResponse$ResponseState extends Enum<LynxResourceResponse$ResponseState> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxResourceResponse$ResponseState f10947a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LynxResourceResponse$ResponseState f10948b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ LynxResourceResponse$ResponseState[] f10949c = null;

    static {
        LynxResourceResponse$ResponseState r5 = new LynxResourceResponse$ResponseState(MiniAppWidgetAvailability.INSTALL_STATE_FAILED, 0);
        f10947a = r5;
        LynxResourceResponse$ResponseState r10 = new LynxResourceResponse$ResponseState("SUCCESS", 1);
        f10948b = r10;
        f10949c = new LynxResourceResponse$ResponseState[]{r5, r10};
    }

    public LynxResourceResponse$ResponseState(String r5, int r10) {
        super(r5, r10);
    }

    public static LynxResourceResponse$ResponseState valueOf(String r5) {
        return (LynxResourceResponse$ResponseState) Enum.valueOf(LynxResourceResponse$ResponseState.class, r5);
    }

    public static LynxResourceResponse$ResponseState[] values() {
        return (LynxResourceResponse$ResponseState[]) f10949c.clone();
    }
}
