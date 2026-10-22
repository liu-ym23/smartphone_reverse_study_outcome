package com.tom_roush.pdfbox.pdmodel.common.function.type4;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class Parser {

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State COMMENT = null;
        public static final State NEWLINE = null;
        public static final State TOKEN = null;
        public static final State WHITESPACE = null;

        static {
            State r0 = new State("NEWLINE", 0);
            NEWLINE = r0;
            State r1 = new State("WHITESPACE", 1);
            WHITESPACE = r1;
            State r3 = new State("COMMENT", 2);
            COMMENT = r3;
            State r5 = new State("TOKEN", 3);
            TOKEN = r5;
            $VALUES = new State[]{r0, r1, r3, r5};
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
