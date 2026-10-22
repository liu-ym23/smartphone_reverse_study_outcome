package com.bytedance.android.livesdk.feedback.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/service/FeedbackHideCode;", "", "LIVE_END", "RIGHT_BOTTOM_CARD_SHOW", "REPORT", "NEGATIVE_ACTION", "OUT_OF_TIME", "REMOVE_DATA", "CLEAR_MODE", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FeedbackHideCode extends Enum<FeedbackHideCode> {
    public static final FeedbackHideCode CLEAR_MODE = null;
    public static final FeedbackHideCode LIVE_END = null;
    public static final FeedbackHideCode NEGATIVE_ACTION = null;
    public static final FeedbackHideCode OUT_OF_TIME = null;
    public static final FeedbackHideCode REMOVE_DATA = null;
    public static final FeedbackHideCode REPORT = null;
    public static final FeedbackHideCode RIGHT_BOTTOM_CARD_SHOW = null;
    public static final /* synthetic */ FeedbackHideCode[] a = null;

    static {
        FeedbackHideCode r1 = new FeedbackHideCode("LIVE_END", 0);
        LIVE_END = r1;
        FeedbackHideCode r2 = new FeedbackHideCode("RIGHT_BOTTOM_CARD_SHOW", 1);
        RIGHT_BOTTOM_CARD_SHOW = r2;
        FeedbackHideCode r3 = new FeedbackHideCode("REPORT", 2);
        REPORT = r3;
        FeedbackHideCode r4 = new FeedbackHideCode("NEGATIVE_ACTION", 3);
        NEGATIVE_ACTION = r4;
        FeedbackHideCode r5 = new FeedbackHideCode("OUT_OF_TIME", 4);
        OUT_OF_TIME = r5;
        FeedbackHideCode r6 = new FeedbackHideCode("REMOVE_DATA", 5);
        REMOVE_DATA = r6;
        FeedbackHideCode r7 = new FeedbackHideCode("CLEAR_MODE", 6);
        CLEAR_MODE = r7;
        a = new FeedbackHideCode[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static FeedbackHideCode valueOf(String r1) {
        return (FeedbackHideCode) r27.a.a(FeedbackHideCode.class, r1);
    }

    public static FeedbackHideCode[] values() {
        return (FeedbackHideCode[]) a.clone();
    }

    public FeedbackHideCode(String r1, int r2) {
        super(r1, r2);
    }
}
