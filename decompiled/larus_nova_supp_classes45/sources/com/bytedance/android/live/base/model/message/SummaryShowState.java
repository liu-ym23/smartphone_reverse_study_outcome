package com.bytedance.android.live.base.model.message;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/message/SummaryShowState;", "", "", "value", "I", "getValue", "()I", "SummaryShowStateUnDefined", "SummaryShowStateShow", "SummaryShowStateHide", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SummaryShowState extends Enum<SummaryShowState> {
    public static final SummaryShowState SummaryShowStateHide = null;
    public static final SummaryShowState SummaryShowStateShow = null;
    public static final SummaryShowState SummaryShowStateUnDefined = null;
    public static final /* synthetic */ SummaryShowState[] a = null;
    private final int value;

    static {
        SummaryShowState r1 = new SummaryShowState("SummaryShowStateUnDefined", 0, 0);
        SummaryShowStateUnDefined = r1;
        SummaryShowState r2 = new SummaryShowState("SummaryShowStateShow", 1, 1);
        SummaryShowStateShow = r2;
        SummaryShowState r3 = new SummaryShowState("SummaryShowStateHide", 2, 2);
        SummaryShowStateHide = r3;
        a = new SummaryShowState[]{r1, r2, r3};
    }

    public static SummaryShowState valueOf(String r1) {
        return (SummaryShowState) r27.a.a(SummaryShowState.class, r1);
    }

    public static SummaryShowState[] values() {
        return (SummaryShowState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public SummaryShowState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
