package com.google.zxing.oned.rss.expanded.decoders;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
final class CurrentParsingState {

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State ALPHA = null;
        public static final State ISO_IEC_646 = null;
        public static final State NUMERIC = null;

        static {
            State r0 = new State("NUMERIC", 0);
            NUMERIC = r0;
            State r1 = new State("ALPHA", 1);
            ALPHA = r1;
            State r3 = new State("ISO_IEC_646", 2);
            ISO_IEC_646 = r3;
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
