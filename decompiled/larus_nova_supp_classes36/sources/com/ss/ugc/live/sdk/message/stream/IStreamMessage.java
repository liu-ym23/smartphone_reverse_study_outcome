package com.ss.ugc.live.sdk.message.stream;

import r27.a;
import tlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IStreamMessage extends d {

    public static final enum DelayMode extends Enum<DelayMode> {
        public static final DelayMode CLEAR = null;
        public static final DelayMode DEFAULT = null;
        public static final DelayMode NOW = null;
        public static final DelayMode SEI_DIFF = null;
        public static final /* synthetic */ DelayMode[] a = null;

        static {
            DelayMode r0 = new DelayMode("DEFAULT", 0);
            DEFAULT = r0;
            DelayMode r1 = new DelayMode("CLEAR", 1);
            CLEAR = r1;
            DelayMode r3 = new DelayMode("NOW", 2);
            NOW = r3;
            DelayMode r5 = new DelayMode("SEI_DIFF", 3);
            SEI_DIFF = r5;
            a = new DelayMode[]{r0, r1, r3, r5};
        }

        public static DelayMode[] values() {
            return (DelayMode[]) a.clone();
        }

        public static DelayMode valueOf(String r1) {
            return (DelayMode) a.a(DelayMode.class, r1);
        }

        public DelayMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    DelayMode getDelayMode();

    long getProcessAtSeiTs();

    long getServerDelay();

    long getTargetSei();

    boolean ignoreCondition();

    boolean isStreamMessage();
}
