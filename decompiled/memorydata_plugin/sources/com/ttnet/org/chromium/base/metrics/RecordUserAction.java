package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.TimeUtils;

/* JADX INFO: loaded from: classes6.dex */
public class RecordUserAction {
    public RecordUserAction() {
    }

    public static void record(String r3) {
        UmaRecorderHolder.get().recordUserAction(r3, TimeUtils.elapsedRealtimeMillis());
    }
}
