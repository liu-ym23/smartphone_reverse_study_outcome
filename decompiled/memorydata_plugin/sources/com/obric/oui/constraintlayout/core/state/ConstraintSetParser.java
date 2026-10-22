package com.obric.oui.constraintlayout.core.state;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ConstraintSetParser {

    public static final enum MotionLayoutDebugFlags extends Enum<MotionLayoutDebugFlags> {
        private static final /* synthetic */ MotionLayoutDebugFlags[] $VALUES = null;
        public static final MotionLayoutDebugFlags NONE = null;
        public static final MotionLayoutDebugFlags SHOW_ALL = null;
        public static final MotionLayoutDebugFlags UNKNOWN = null;

        static {
            MotionLayoutDebugFlags r0 = new MotionLayoutDebugFlags("NONE", 0);
            NONE = r0;
            MotionLayoutDebugFlags r1 = new MotionLayoutDebugFlags("SHOW_ALL", 1);
            SHOW_ALL = r1;
            MotionLayoutDebugFlags r3 = new MotionLayoutDebugFlags("UNKNOWN", 2);
            UNKNOWN = r3;
            $VALUES = new MotionLayoutDebugFlags[]{r0, r1, r3};
        }

        private MotionLayoutDebugFlags(String r1, int r2) {
            super(r1, r2);
        }

        public static MotionLayoutDebugFlags valueOf(String r2) {
            return (MotionLayoutDebugFlags) ZeusTransformUtils.preCheckCast(Enum.valueOf(MotionLayoutDebugFlags.class, r2), MotionLayoutDebugFlags.class, "com.obric.memorydata.plugin");
        }

        public static MotionLayoutDebugFlags[] values() {
            return (MotionLayoutDebugFlags[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MotionLayoutDebugFlags[].class, "com.obric.memorydata.plugin");
        }
    }
}
