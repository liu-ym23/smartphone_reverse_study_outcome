package org.bouncycastle.crypto.engines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class SM2Engine {

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode C1C2C3 = null;
        public static final Mode C1C3C2 = null;

        static {
            Mode r0 = new Mode("C1C2C3", 0);
            C1C2C3 = r0;
            Mode r1 = new Mode("C1C3C2", 1);
            C1C3C2 = r1;
            $VALUES = new Mode[]{r0, r1};
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
}
