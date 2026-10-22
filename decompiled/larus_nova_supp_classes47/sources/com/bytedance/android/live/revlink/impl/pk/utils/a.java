package com.bytedance.android.live.revlink.impl.pk.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AutoMatchSource.values().length];
        a = r0;
        r0[AutoMatchSource.MaxWaitTimeOut.ordinal()] = 1;
        r0[AutoMatchSource.PollingEnd.ordinal()] = 2;
        r0[AutoMatchSource.APIClientError.ordinal()] = 3;
        r0[AutoMatchSource.APIServerError.ordinal()] = 4;
        r0[AutoMatchSource.ConnectionInfoInvalid.ordinal()] = 5;
        r0[AutoMatchSource.ConnectApiFailed.ordinal()] = 6;
        r0[AutoMatchSource.ReceiveReplyWhenMatching.ordinal()] = 7;
        r0[AutoMatchSource.ReceiveMultiInviteWhenMatching.ordinal()] = 8;
        r0[AutoMatchSource.ReceiveDoubleInviteWhenMatching.ordinal()] = 9;
    }
}
