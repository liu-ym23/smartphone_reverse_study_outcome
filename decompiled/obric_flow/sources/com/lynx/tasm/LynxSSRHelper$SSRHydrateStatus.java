package com.lynx.tasm;

import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;

/* JADX INFO: loaded from: classes2.dex */
final enum LynxSSRHelper$SSRHydrateStatus extends Enum<LynxSSRHelper$SSRHydrateStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxSSRHelper$SSRHydrateStatus f10006a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LynxSSRHelper$SSRHydrateStatus f10007b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LynxSSRHelper$SSRHydrateStatus f10008c = null;
    public static final LynxSSRHelper$SSRHydrateStatus d = null;
    public static final LynxSSRHelper$SSRHydrateStatus e = null;
    public static final LynxSSRHelper$SSRHydrateStatus f = null;
    public static final /* synthetic */ LynxSSRHelper$SSRHydrateStatus[] g = null;

    static {
        LynxSSRHelper$SSRHydrateStatus r5 = new LynxSSRHelper$SSRHydrateStatus("UNDEFINED", 0);
        f10006a = r5;
        LynxSSRHelper$SSRHydrateStatus r10 = new LynxSSRHelper$SSRHydrateStatus("PENDING", 1);
        f10007b = r10;
        LynxSSRHelper$SSRHydrateStatus r11 = new LynxSSRHelper$SSRHydrateStatus("STARTED", 2);
        f10008c = r11;
        LynxSSRHelper$SSRHydrateStatus r12 = new LynxSSRHelper$SSRHydrateStatus("EXECUTING", 3);
        d = r12;
        LynxSSRHelper$SSRHydrateStatus r13 = new LynxSSRHelper$SSRHydrateStatus(MiniAppWidgetAvailability.INSTALL_STATE_FAILED, 4);
        e = r13;
        LynxSSRHelper$SSRHydrateStatus r14 = new LynxSSRHelper$SSRHydrateStatus("SUCCESSFUL", 5);
        f = r14;
        g = new LynxSSRHelper$SSRHydrateStatus[]{r5, r10, r11, r12, r13, r14};
    }

    public LynxSSRHelper$SSRHydrateStatus(String r5, int r10) {
        super(r5, r10);
    }

    public static LynxSSRHelper$SSRHydrateStatus valueOf(String r5) {
        return (LynxSSRHelper$SSRHydrateStatus) Enum.valueOf(LynxSSRHelper$SSRHydrateStatus.class, r5);
    }

    public static LynxSSRHelper$SSRHydrateStatus[] values() {
        return (LynxSSRHelper$SSRHydrateStatus[]) g.clone();
    }
}
