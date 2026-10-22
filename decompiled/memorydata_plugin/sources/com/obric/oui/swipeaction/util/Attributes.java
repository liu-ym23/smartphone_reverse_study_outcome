package com.obric.oui.swipeaction.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Attributes {

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode Multiple = null;
        public static final Mode Single = null;

        static {
            Mode r0 = new Mode("Single", 0);
            Single = r0;
            Mode r1 = new Mode("Multiple", 1);
            Multiple = r1;
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
