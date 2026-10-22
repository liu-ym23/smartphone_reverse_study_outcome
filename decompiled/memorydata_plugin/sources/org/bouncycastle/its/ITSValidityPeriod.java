package org.bouncycastle.its;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class ITSValidityPeriod {

    public static final enum Unit extends Enum<Unit> {
        private static final /* synthetic */ Unit[] $VALUES = null;
        public static final Unit hours = null;
        public static final Unit microseconds = null;
        public static final Unit milliseconds = null;
        public static final Unit minutes = null;
        public static final Unit seconds = null;
        public static final Unit sixtyHours = null;
        public static final Unit years = null;
        private final int unitTag;

        static {
            Unit r0 = new Unit("microseconds", 0, 0);
            microseconds = r0;
            Unit r1 = new Unit("milliseconds", 1, 1);
            milliseconds = r1;
            Unit r3 = new Unit("seconds", 2, 2);
            seconds = r3;
            Unit r5 = new Unit("minutes", 3, 3);
            minutes = r5;
            Unit r7 = new Unit("hours", 4, 4);
            hours = r7;
            Unit r9 = new Unit("sixtyHours", 5, 5);
            sixtyHours = r9;
            Unit r11 = new Unit("years", 6, 6);
            years = r11;
            $VALUES = new Unit[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private Unit(String r1, int r2, int r3) {
            super(r1, r2);
            this.unitTag = r3;
        }

        static /* synthetic */ int access$000(Unit r0) {
            return r0.unitTag;
        }

        public static Unit valueOf(String r2) {
            return (Unit) ZeusTransformUtils.preCheckCast(Enum.valueOf(Unit.class, r2), Unit.class, "com.obric.memorydata.plugin");
        }

        public static Unit[] values() {
            return (Unit[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Unit[].class, "com.obric.memorydata.plugin");
        }
    }
}
