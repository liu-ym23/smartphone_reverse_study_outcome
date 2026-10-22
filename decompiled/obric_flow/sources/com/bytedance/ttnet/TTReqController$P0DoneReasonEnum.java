package com.bytedance.ttnet;

/* JADX INFO: loaded from: classes2.dex */
public final enum TTReqController$P0DoneReasonEnum extends Enum<TTReqController$P0DoneReasonEnum> {
    public static final TTReqController$P0DoneReasonEnum MODULE_DISABLE = null;
    public static final TTReqController$P0DoneReasonEnum P0_COUNT_DONE = null;
    public static final TTReqController$P0DoneReasonEnum P0_NOT_DONE = null;
    public static final TTReqController$P0DoneReasonEnum P0_TIME_OUT = null;
    public static final TTReqController$P0DoneReasonEnum P1_MAX_SIZE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TTReqController$P0DoneReasonEnum[] f7525a = null;

    static {
        TTReqController$P0DoneReasonEnum r5 = new TTReqController$P0DoneReasonEnum("P0_NOT_DONE", 0);
        P0_NOT_DONE = r5;
        TTReqController$P0DoneReasonEnum r10 = new TTReqController$P0DoneReasonEnum("MODULE_DISABLE", 1);
        MODULE_DISABLE = r10;
        TTReqController$P0DoneReasonEnum r11 = new TTReqController$P0DoneReasonEnum("P0_COUNT_DONE", 2);
        P0_COUNT_DONE = r11;
        TTReqController$P0DoneReasonEnum r12 = new TTReqController$P0DoneReasonEnum("P1_MAX_SIZE", 3);
        P1_MAX_SIZE = r12;
        TTReqController$P0DoneReasonEnum r13 = new TTReqController$P0DoneReasonEnum("P0_TIME_OUT", 4);
        P0_TIME_OUT = r13;
        f7525a = new TTReqController$P0DoneReasonEnum[]{r5, r10, r11, r12, r13};
    }

    public static TTReqController$P0DoneReasonEnum valueOf(String r5) {
        return (TTReqController$P0DoneReasonEnum) Enum.valueOf(TTReqController$P0DoneReasonEnum.class, r5);
    }

    public static TTReqController$P0DoneReasonEnum[] values() {
        return (TTReqController$P0DoneReasonEnum[]) f7525a.clone();
    }
}
