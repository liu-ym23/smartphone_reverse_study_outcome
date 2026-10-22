package com.bytedance.android.live.revlink.impl.pk.service;

import com.bytedance.android.livesdk.link.model.d2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface e {
    d2 getBattlePrecisionMatch();

    Long getLinkDuration();

    boolean isMatchWaiting();

    boolean isMatchingCount();

    void onPrecisionMatchEvent(int r1);

    void resetPrecisionMatch();
}
