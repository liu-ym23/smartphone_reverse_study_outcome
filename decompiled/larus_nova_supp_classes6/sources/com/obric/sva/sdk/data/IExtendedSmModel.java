package com.obric.sva.sdk.data;

import android.content.Intent;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper;
import com.obric.sva.sdk.session.SessionType;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IExtendedSmModel extends ISmModel {

    public static final enum SessionStatus extends Enum<SessionStatus> {
        private static final /* synthetic */ SessionStatus[] $VALUES = null;
        public static final SessionStatus LOADED = null;
        public static final SessionStatus STARTED = null;
        public static final SessionStatus STOPPED = null;
        public static final SessionStatus UNLOADED = null;

        static {
            SessionStatus r0 = new SessionStatus("UNLOADED", 0);
            UNLOADED = r0;
            SessionStatus r1 = new SessionStatus("LOADED", 1);
            LOADED = r1;
            SessionStatus r3 = new SessionStatus("STARTED", 2);
            STARTED = r3;
            SessionStatus r5 = new SessionStatus("STOPPED", 3);
            STOPPED = r5;
            $VALUES = new SessionStatus[]{r0, r1, r3, r5};
        }

        public static SessionStatus[] values() {
            return (SessionStatus[]) $VALUES.clone();
        }

        public static SessionStatus valueOf(String r1) {
            return (SessionStatus) a.a(SessionStatus.class, r1);
        }

        private SessionStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] getKeyphraseRecognitionExtra();

    SoundTriggerWrapper.RecognitionConfigWrapper getRecognitionConfig();

    int getSessionId();

    SessionStatus getSessionStatus();

    SessionType getSessionType();

    Intent getSoundModelActionIntent();

    String getSoundModelActionName();

    int getSoundModelHandle();

    void setKeyphraseRecognitionExtra(SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] r1);

    void setRecognitionConfig(SoundTriggerWrapper.RecognitionConfigWrapper r1);

    void setSessionId(int r1);

    void setSessionStatus(SessionStatus r1);

    void setSoundModelActionIntent(Intent r1);

    void setSoundModelActionName(String r1);

    void setSoundModelHandle(int r1);
}
