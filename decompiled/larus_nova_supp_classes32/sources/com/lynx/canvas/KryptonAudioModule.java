package com.lynx.canvas;

import com.lynx.jsbridge.LynxResourceModule;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class KryptonAudioModule extends KryptonModule {

    public static final enum AudioStatus extends Enum<AudioStatus> {
        private static final /* synthetic */ AudioStatus[] $VALUES = null;
        public static final AudioStatus DESTROY = null;
        public static final AudioStatus INIT = null;
        public static final AudioStatus PAUSE = null;
        public static final AudioStatus RESUME = null;

        static {
            AudioStatus r0 = new AudioStatus("INIT", 0);
            INIT = r0;
            AudioStatus r1 = new AudioStatus("PAUSE", 1);
            PAUSE = r1;
            AudioStatus r3 = new AudioStatus("RESUME", 2);
            RESUME = r3;
            AudioStatus r5 = new AudioStatus("DESTROY", 3);
            DESTROY = r5;
            $VALUES = new AudioStatus[]{r0, r1, r3, r5};
        }

        public static AudioStatus[] values() {
            return (AudioStatus[]) $VALUES.clone();
        }

        public static AudioStatus valueOf(String r1) {
            return (AudioStatus) a.a(AudioStatus.class, r1);
        }

        private AudioStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface StatusListener {
        void onStatusChange(AudioStatus r1);
    }

    public static String moduleName() {
        return LynxResourceModule.AUDIO_TYPE;
    }

    public abstract String engineType();

    public abstract boolean loadAudioEffectModule(String r1);

    public abstract boolean loadAudioModule();

    public abstract void setStatusListener(StatusListener r1);

    public abstract boolean startAudioEngine(KryptonApp r1);

    public KryptonAudioModule() {
    }
}
