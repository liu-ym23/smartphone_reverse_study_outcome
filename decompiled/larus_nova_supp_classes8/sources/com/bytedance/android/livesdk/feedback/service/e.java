package com.bytedance.android.livesdk.feedback.service;

import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface e {
    fx1.e<Object> findTriggerById(TriggerId r1);

    void reset();

    void startFeedbackObserve();
}
