package com.obric.sva.sdk.session;

import com.obric.sva.sdk.session.legacy.IWakeupListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IWakeupSession extends IWakeupSessionConstant {
    void addWakeupListener(IWakeupListener r1);

    int establishSvaSession(String r1);

    SessionType getSessionType();

    boolean isRecognitionActive(String r1);

    boolean isSupportConcurrency();

    int loadSM(String r1);

    void releaseAllSvaSessions();

    void releaseSvaSession(String r1);

    void removeWakeupListener(IWakeupListener r1);

    int restartRecognition(String r1);

    int startRecognition(String r1);

    int stopRecognition(String r1);

    int terminateSvaSession(String r1);

    int unloadSM(String r1);
}
