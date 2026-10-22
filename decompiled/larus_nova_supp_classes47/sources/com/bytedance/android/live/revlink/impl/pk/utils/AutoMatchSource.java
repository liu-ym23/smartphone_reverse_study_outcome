package com.bytedance.android.live.revlink.impl.pk.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/utils/AutoMatchSource;", "", "NoneOfMyBusiness", "MaxWaitTimeOut", "PollingEnd", "MatchSuccess", "APIServerError", "APIClientError", "ConnectionInfoInvalid", "ConnectApiFailed", "Manual", "ReceiveReplyWhenMatching", "ReceiveMultiInviteWhenMatching", "ReceiveDoubleInviteWhenMatching", "ReceivePrecisionMatchMsg", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AutoMatchSource extends Enum<AutoMatchSource> {
    public static final AutoMatchSource APIClientError = null;
    public static final AutoMatchSource APIServerError = null;
    public static final AutoMatchSource ConnectApiFailed = null;
    public static final AutoMatchSource ConnectionInfoInvalid = null;
    public static final AutoMatchSource Manual = null;
    public static final AutoMatchSource MatchSuccess = null;
    public static final AutoMatchSource MaxWaitTimeOut = null;
    public static final AutoMatchSource NoneOfMyBusiness = null;
    public static final AutoMatchSource PollingEnd = null;
    public static final AutoMatchSource ReceiveDoubleInviteWhenMatching = null;
    public static final AutoMatchSource ReceiveMultiInviteWhenMatching = null;
    public static final AutoMatchSource ReceivePrecisionMatchMsg = null;
    public static final AutoMatchSource ReceiveReplyWhenMatching = null;
    public static final /* synthetic */ AutoMatchSource[] a = null;

    static {
        AutoMatchSource r1 = new AutoMatchSource("NoneOfMyBusiness", 0);
        NoneOfMyBusiness = r1;
        AutoMatchSource r2 = new AutoMatchSource("MaxWaitTimeOut", 1);
        MaxWaitTimeOut = r2;
        AutoMatchSource r3 = new AutoMatchSource("PollingEnd", 2);
        PollingEnd = r3;
        AutoMatchSource r4 = new AutoMatchSource("MatchSuccess", 3);
        MatchSuccess = r4;
        AutoMatchSource r5 = new AutoMatchSource("APIServerError", 4);
        APIServerError = r5;
        AutoMatchSource r6 = new AutoMatchSource("APIClientError", 5);
        APIClientError = r6;
        AutoMatchSource r7 = new AutoMatchSource("ConnectionInfoInvalid", 6);
        ConnectionInfoInvalid = r7;
        AutoMatchSource r8 = new AutoMatchSource("ConnectApiFailed", 7);
        ConnectApiFailed = r8;
        AutoMatchSource r9 = new AutoMatchSource("Manual", 8);
        Manual = r9;
        AutoMatchSource r10 = new AutoMatchSource("ReceiveReplyWhenMatching", 9);
        ReceiveReplyWhenMatching = r10;
        AutoMatchSource r12 = new AutoMatchSource("ReceiveMultiInviteWhenMatching", 10);
        ReceiveMultiInviteWhenMatching = r12;
        AutoMatchSource r13 = new AutoMatchSource("ReceiveDoubleInviteWhenMatching", 11);
        ReceiveDoubleInviteWhenMatching = r13;
        AutoMatchSource r14 = new AutoMatchSource("ReceivePrecisionMatchMsg", 12);
        ReceivePrecisionMatchMsg = r14;
        a = new AutoMatchSource[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14};
    }

    public static AutoMatchSource valueOf(String r1) {
        return (AutoMatchSource) r27.a.a(AutoMatchSource.class, r1);
    }

    public static AutoMatchSource[] values() {
        return (AutoMatchSource[]) a.clone();
    }

    public AutoMatchSource(String r1, int r2) {
        super(r1, r2);
    }
}
