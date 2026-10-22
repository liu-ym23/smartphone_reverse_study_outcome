package com.obric.sva.sdk.session.legacy;

import com.obric.sva.framework.wrapper.SoundTriggerWrapper;
import com.obric.sva.sdk.session.SessionType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IWakeupListener {
    void onRecognition(SessionType r1, SoundTriggerWrapper.RecognitionEventWrapper r2);

    void onResourcesAvailable(SessionType r1);

    void onServiceDied(SessionType r1);
}
