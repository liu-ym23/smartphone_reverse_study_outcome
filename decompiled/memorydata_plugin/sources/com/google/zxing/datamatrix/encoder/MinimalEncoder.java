package com.google.zxing.datamatrix.encoder;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class MinimalEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f5080a = null;

    static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode ASCII = null;
        public static final Mode B256 = null;
        public static final Mode C40 = null;
        public static final Mode EDF = null;
        public static final Mode TEXT = null;
        public static final Mode X12 = null;

        static {
            Mode r0 = new Mode("ASCII", 0);
            ASCII = r0;
            Mode r1 = new Mode("C40", 1);
            C40 = r1;
            Mode r3 = new Mode("TEXT", 2);
            TEXT = r3;
            Mode r5 = new Mode("X12", 3);
            X12 = r5;
            Mode r7 = new Mode("EDF", 4);
            EDF = r7;
            Mode r9 = new Mode("B256", 5);
            B256 = r9;
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
        f5080a = new char[]{'!', Typography.quote, '#', Typography.dollar, '%', Typography.amp, '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', Typography.less, '=', Typography.greater, '?', '@', '[', '\\', ']', '^', '_'};
    }
}
