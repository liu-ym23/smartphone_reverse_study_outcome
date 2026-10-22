package com.bytedance.ttnet;

/* JADX INFO: loaded from: classes2.dex */
public final enum TTReqController$ReleaseReasonEnum extends Enum<TTReqController$ReleaseReasonEnum> {
    public static final TTReqController$ReleaseReasonEnum RELEASE_COUNTDOWN = null;
    public static final TTReqController$ReleaseReasonEnum RELEASE_P0BACK = null;
    public static final TTReqController$ReleaseReasonEnum RELEASE_SWITCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TTReqController$ReleaseReasonEnum[] f7526a = null;

    static {
        TTReqController$ReleaseReasonEnum r5 = new TTReqController$ReleaseReasonEnum("RELEASE_COUNTDOWN", 0);
        RELEASE_COUNTDOWN = r5;
        TTReqController$ReleaseReasonEnum r10 = new TTReqController$ReleaseReasonEnum("RELEASE_SWITCH", 1);
        RELEASE_SWITCH = r10;
        TTReqController$ReleaseReasonEnum r11 = new TTReqController$ReleaseReasonEnum("RELEASE_P0BACK", 2);
        RELEASE_P0BACK = r11;
        f7526a = new TTReqController$ReleaseReasonEnum[]{r5, r10, r11};
    }

    public static TTReqController$ReleaseReasonEnum valueOf(String r5) {
        return (TTReqController$ReleaseReasonEnum) Enum.valueOf(TTReqController$ReleaseReasonEnum.class, r5);
    }

    public static TTReqController$ReleaseReasonEnum[] values() {
        return (TTReqController$ReleaseReasonEnum[]) f7526a.clone();
    }
}
