package com.google.zxing.pdf417.decoder;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
final class DecodedBitStreamParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f5087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f5088b = null;
    private static final BigInteger[] c = null;

    private static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode ALPHA = null;
        public static final Mode ALPHA_SHIFT = null;
        public static final Mode LOWER = null;
        public static final Mode MIXED = null;
        public static final Mode PUNCT = null;
        public static final Mode PUNCT_SHIFT = null;

        static {
            Mode r0 = new Mode("ALPHA", 0);
            ALPHA = r0;
            Mode r1 = new Mode("LOWER", 1);
            LOWER = r1;
            Mode r3 = new Mode("MIXED", 2);
            MIXED = r3;
            Mode r5 = new Mode("PUNCT", 3);
            PUNCT = r5;
            Mode r7 = new Mode("ALPHA_SHIFT", 4);
            ALPHA_SHIFT = r7;
            Mode r9 = new Mode("PUNCT_SHIFT", 5);
            PUNCT_SHIFT = r9;
            $VALUES = new Mode[]{r0, r1, r3, r5, r7, r9};
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
        f5087a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
        f5088b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
        BigInteger[] r0 = new BigInteger[16];
        c = r0;
        r0[0] = BigInteger.ONE;
        BigInteger r1 = BigInteger.valueOf(900);
        r0[1] = r1;
        int r2 = 2;
    L3:
        BigInteger[] r3 = c;
        if (r2 >= r3.length) goto L6;
        r3[r2] = r3[r2 - 1].multiply(r1);
        r2 = r2 + 1;
        goto L3
    }
}
