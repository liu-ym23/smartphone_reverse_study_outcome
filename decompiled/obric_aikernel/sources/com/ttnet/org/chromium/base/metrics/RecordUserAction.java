package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.TimeUtils;

/* JADX INFO: loaded from: classes2.dex */
public class RecordUserAction {
    public RecordUserAction() {
    }

    public static void record(String r10) {
        UmaRecorderHolder.get().recordUserAction(r10, TimeUtils.elapsedRealtimeMillis());
    }
}
