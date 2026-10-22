package com.obric.sva.framework.wrapper;

import android.hardware.soundtrigger.SoundTriggerModule;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SoundTriggerModuleWrapper {
    private SoundTriggerModule soundTriggerModule;

    public void detach() {
        SoundTriggerModule r0 = this.soundTriggerModule;
        if (r0 == null) goto L6;
        r0.detach();
        return;
    }

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return SoundTriggerModule.class;
    }

    public SoundTriggerModuleWrapper(SoundTriggerModule r1) {
        this.soundTriggerModule = r1;
    }

    public int stopRecognition(int r2) {
        SoundTriggerModule r0 = this.soundTriggerModule;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.stopRecognition(r2);
    }

    public int unloadSoundModel(int r2) {
        SoundTriggerModule r0 = this.soundTriggerModule;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.unloadSoundModel(r2);
    }

    public int loadSoundModel(SoundTriggerWrapper.KeyphraseSoundModelWrapper r2, int[] r3) {
        SoundTriggerModule r0 = this.soundTriggerModule;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.loadSoundModel(r2.getSoundModel(), r3);
    }

    public int startRecognition(int r2, SoundTriggerWrapper.RecognitionConfigWrapper r3) {
        SoundTriggerModule r0 = this.soundTriggerModule;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.startRecognition(r2, r3.getConfig());
    }
}
