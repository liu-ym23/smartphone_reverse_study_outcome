package org.apache.commons.compress.archivers.sevenz;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class CLI {

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.sevenz.CLI$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode LIST = null;
        private final String message;

        static {
            final String r1 = "LIST";
            final int r2 = 0;
            final String r3 = "Analysing";
            Mode r0 = new AnonymousClass1(r1, r2, r3);
            LIST = r0;
            $VALUES = new Mode[]{r0};
        }

        private Mode(String r1, int r2, String r3) {
            super(r1, r2);
            this.message = r3;
        }

        /* synthetic */ Mode(String r1, int r2, String r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        public static Mode valueOf(String r2) {
            return (Mode) ZeusTransformUtils.preCheckCast(Enum.valueOf(Mode.class, r2), Mode.class, "com.obric.memorydata.plugin");
        }

        public static Mode[] values() {
            return (Mode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Mode[].class, "com.obric.memorydata.plugin");
        }

        public String getMessage() {
            return this.message;
        }

        public abstract void takeAction(SevenZFile r1, SevenZArchiveEntry r2);
    }
}
