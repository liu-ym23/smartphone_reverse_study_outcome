package com.google.zxing.datamatrix.decoder;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
final class DecodedBitStreamParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f5078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f5079b = null;
    private static final char[] c = null;
    private static final char[] d = null;
    private static final char[] e = null;

    private static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode ANSIX12_ENCODE = null;
        public static final Mode ASCII_ENCODE = null;
        public static final Mode BASE256_ENCODE = null;
        public static final Mode C40_ENCODE = null;
        public static final Mode ECI_ENCODE = null;
        public static final Mode EDIFACT_ENCODE = null;
        public static final Mode PAD_ENCODE = null;
        public static final Mode TEXT_ENCODE = null;

        static {
            Mode r0 = new Mode("PAD_ENCODE", 0);
            PAD_ENCODE = r0;
            Mode r1 = new Mode("ASCII_ENCODE", 1);
            ASCII_ENCODE = r1;
            Mode r3 = new Mode("C40_ENCODE", 2);
            C40_ENCODE = r3;
            Mode r5 = new Mode("TEXT_ENCODE", 3);
            TEXT_ENCODE = r5;
            Mode r7 = new Mode("ANSIX12_ENCODE", 4);
            ANSIX12_ENCODE = r7;
            Mode r9 = new Mode("EDIFACT_ENCODE", 5);
            EDIFACT_ENCODE = r9;
            Mode r11 = new Mode("BASE256_ENCODE", 6);
            BASE256_ENCODE = r11;
            Mode r13 = new Mode("ECI_ENCODE", 7);
            ECI_ENCODE = r13;
            $VALUES = new Mode[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static Mode valueOf(String r2) {
            return (Mode) ZeusTransformUtils.preCheckCast(Enum.valueOf(Mode.class, r2), Mode.class, "com.obric.memorydata.plugin");
        }

        public static Mode[] values() {
            return (Mode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Mode[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f5078a = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] r1 = {'!', Typography.quote, '#', Typography.dollar, '%', Typography.amp, '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', Typography.less, '=', Typography.greater, '?', '@', '[', '\\', ']', '^', '_'};
        f5079b = r1;
        c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        d = r1;
        e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};
    }
}
