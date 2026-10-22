package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class s3 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ReceiverType.values().length];
        a = r0;
        r0[ReceiverType.GroupLive.ordinal()] = 1;
        r0[ReceiverType.AllMic.ordinal()] = 2;
        r0[ReceiverType.Guest.ordinal()] = 3;
        r0[ReceiverType.Anchor.ordinal()] = 4;
        r0[ReceiverType.Audience.ordinal()] = 5;
        r0[ReceiverType.OtherAnchor.ordinal()] = 6;
        r0[ReceiverType.MicTeamAnchor.ordinal()] = 7;
    }
}
