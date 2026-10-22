package com.bytedance.android.livesdk.feed;

import com.bytedance.android.livesdk.feed.repository.BaseFeedRepository;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class i0 {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[BaseFeedRepository.ApiDataStatus.values().length];
        a = r0;
        BaseFeedRepository.ApiDataStatus r1 = BaseFeedRepository.ApiDataStatus.START;
        r0[r1.ordinal()] = 1;
        BaseFeedRepository.ApiDataStatus r2 = BaseFeedRepository.ApiDataStatus.SUCCESS;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[BaseFeedRepository.ApiDataStatus.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
    }
}
