package com.tom_roush.pdfbox.pdmodel.font;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class PDCIDFontType2Embedder extends af {

    static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State BRACKET = null;
        public static final State FIRST = null;
        public static final State SERIAL = null;

        static {
            State r0 = new State("FIRST", 0);
            FIRST = r0;
            State r1 = new State("BRACKET", 1);
            BRACKET = r1;
            State r3 = new State("SERIAL", 2);
            SERIAL = r3;
            $VALUES = new State[]{r0, r1, r3};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
        }
    }
}
