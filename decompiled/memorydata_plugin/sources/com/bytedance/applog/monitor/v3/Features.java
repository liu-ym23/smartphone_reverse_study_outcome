package com.bytedance.applog.monitor.v3;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class Features {

    public static final enum BooleanFeatureKeys extends Enum<BooleanFeatureKeys> {
        private static final /* synthetic */ BooleanFeatureKeys[] $VALUES = null;
        public static final BooleanFeatureKeys ADJUST_TERMINATE_SWITCH = null;
        public static final BooleanFeatureKeys BG_SESSION_SWITCH = null;
        public static final BooleanFeatureKeys CHILD_MODE_BEFORE_INIT_SWITCH = null;
        public static final BooleanFeatureKeys CHILD_MODE_SWITCH = null;
        public static final BooleanFeatureKeys CONTROL_CUSTOM_HEADER_SWITCH = null;
        public static final BooleanFeatureKeys CONTROL_EVENT_PARAM_SWITCH = null;
        public static final BooleanFeatureKeys CUSTOM_EVENT_FILTER = null;
        public static final BooleanFeatureKeys DATA_ISOLATE_SWITCH = null;
        public static final BooleanFeatureKeys DEBUG_LOG_SWITCH = null;
        public static final BooleanFeatureKeys DEVTOOLS_SWITCH = null;
        public static final BooleanFeatureKeys DISABLE_PERSONALIZATION_SWITCH = null;
        public static final BooleanFeatureKeys ENCRYPT_SWITCH = null;
        public static final BooleanFeatureKeys EVENT_USER_ID_SWITCH = null;
        public static final BooleanFeatureKeys FORWARD_REPORT_SWITCH = null;
        public static final BooleanFeatureKeys LOG_SETTINGS_EVENT_FILTER = null;
        public static final BooleanFeatureKeys NORMAL_SAMPLING_SWITCH = null;
        public static final BooleanFeatureKeys PRIORITY_SWITCH = null;
        public static final BooleanFeatureKeys RECOVERY_SWITCH = null;
        public static final BooleanFeatureKeys TEA_SAMPLING_SWITCH = null;
        public static final BooleanFeatureKeys TOURIST_MODE_EVENT_SWITCH = null;
        public static final BooleanFeatureKeys TOURIST_MODE_SWITCH = null;
        private final int position;

        static {
            BooleanFeatureKeys r0 = new BooleanFeatureKeys("NORMAL_SAMPLING_SWITCH", 0, 0);
            NORMAL_SAMPLING_SWITCH = r0;
            BooleanFeatureKeys r1 = new BooleanFeatureKeys("TEA_SAMPLING_SWITCH", 1, 1);
            TEA_SAMPLING_SWITCH = r1;
            BooleanFeatureKeys r3 = new BooleanFeatureKeys("PRIORITY_SWITCH", 2, 2);
            PRIORITY_SWITCH = r3;
            BooleanFeatureKeys r5 = new BooleanFeatureKeys("RECOVERY_SWITCH", 3, 3);
            RECOVERY_SWITCH = r5;
            BooleanFeatureKeys r7 = new BooleanFeatureKeys("LOG_SETTINGS_EVENT_FILTER", 4, 4);
            LOG_SETTINGS_EVENT_FILTER = r7;
            BooleanFeatureKeys r9 = new BooleanFeatureKeys("CUSTOM_EVENT_FILTER", 5, 5);
            CUSTOM_EVENT_FILTER = r9;
            BooleanFeatureKeys r11 = new BooleanFeatureKeys("ENCRYPT_SWITCH", 6, 6);
            ENCRYPT_SWITCH = r11;
            BooleanFeatureKeys r13 = new BooleanFeatureKeys("FORWARD_REPORT_SWITCH", 7, 7);
            FORWARD_REPORT_SWITCH = r13;
            BooleanFeatureKeys r15 = new BooleanFeatureKeys("DATA_ISOLATE_SWITCH", 8, 8);
            DATA_ISOLATE_SWITCH = r15;
            BooleanFeatureKeys r14 = new BooleanFeatureKeys("EVENT_USER_ID_SWITCH", 9, 9);
            EVENT_USER_ID_SWITCH = r14;
            BooleanFeatureKeys r12 = new BooleanFeatureKeys("TOURIST_MODE_SWITCH", 10, 10);
            TOURIST_MODE_SWITCH = r12;
            BooleanFeatureKeys r10 = new BooleanFeatureKeys("TOURIST_MODE_EVENT_SWITCH", 11, 11);
            TOURIST_MODE_EVENT_SWITCH = r10;
            BooleanFeatureKeys r8 = new BooleanFeatureKeys("ADJUST_TERMINATE_SWITCH", 12, 12);
            ADJUST_TERMINATE_SWITCH = r8;
            BooleanFeatureKeys r6 = new BooleanFeatureKeys("DISABLE_PERSONALIZATION_SWITCH", 13, 13);
            DISABLE_PERSONALIZATION_SWITCH = r6;
            BooleanFeatureKeys r4 = new BooleanFeatureKeys("CHILD_MODE_BEFORE_INIT_SWITCH", 14, 14);
            CHILD_MODE_BEFORE_INIT_SWITCH = r4;
            BooleanFeatureKeys r2 = new BooleanFeatureKeys("CHILD_MODE_SWITCH", 15, 15);
            CHILD_MODE_SWITCH = r2;
            BooleanFeatureKeys r16 = new BooleanFeatureKeys("DEVTOOLS_SWITCH", 16, 16);
            DEVTOOLS_SWITCH = r16;
            BooleanFeatureKeys r17 = new BooleanFeatureKeys("DEBUG_LOG_SWITCH", 17, 17);
            DEBUG_LOG_SWITCH = r17;
            BooleanFeatureKeys r18 = new BooleanFeatureKeys("BG_SESSION_SWITCH", 18, 18);
            BG_SESSION_SWITCH = r18;
            BooleanFeatureKeys r19 = new BooleanFeatureKeys("CONTROL_EVENT_PARAM_SWITCH", 19, 21);
            CONTROL_EVENT_PARAM_SWITCH = r19;
            BooleanFeatureKeys r20 = new BooleanFeatureKeys("CONTROL_CUSTOM_HEADER_SWITCH", 20, 22);
            CONTROL_CUSTOM_HEADER_SWITCH = r20;
            $VALUES = new BooleanFeatureKeys[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20};
        }

        private BooleanFeatureKeys(String r1, int r2, int r3) {
            super(r1, r2);
            this.position = r3;
        }

        public static BooleanFeatureKeys valueOf(String r2) {
            return (BooleanFeatureKeys) ZeusTransformUtils.preCheckCast(Enum.valueOf(BooleanFeatureKeys.class, r2), BooleanFeatureKeys.class, "com.obric.memorydata.plugin");
        }

        public static BooleanFeatureKeys[] values() {
            return (BooleanFeatureKeys[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BooleanFeatureKeys[].class, "com.obric.memorydata.plugin");
        }

        public int toBits(int r2, boolean r3) {
            int r1 = 1 << this.position;
            if (r3 == false) goto L7;
            return r1 | r2;
        L7:
            return (~r1) & r2;
        }
    }

    public static final enum IntFeatureKeys extends Enum<IntFeatureKeys> {
        private static final /* synthetic */ IntFeatureKeys[] $VALUES = null;
        public static final IntFeatureKeys REPORT_INTERVAL = null;
        private final int length;
        private final int position;

        static {
            IntFeatureKeys r0 = new IntFeatureKeys("REPORT_INTERVAL", 0, 19, 2);
            REPORT_INTERVAL = r0;
            $VALUES = new IntFeatureKeys[]{r0};
        }

        private IntFeatureKeys(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.position = r3;
            this.length = r4;
        }

        private int getPositiveBitsByLength() {
            int r1 = 0;
            int r2 = 1;
        L4:
            if (r1 >= this.length) goto L6;
            r2 = r2 & (1 << r1);
            r1 = r1 + 1;
            goto L4
        L6:
            return r2;
        }

        public static IntFeatureKeys valueOf(String r2) {
            return (IntFeatureKeys) ZeusTransformUtils.preCheckCast(Enum.valueOf(IntFeatureKeys.class, r2), IntFeatureKeys.class, "com.obric.memorydata.plugin");
        }

        public static IntFeatureKeys[] values() {
            return (IntFeatureKeys[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IntFeatureKeys[].class, "com.obric.memorydata.plugin");
        }

        public int toBits(int r3, int r4) {
            if (r4 < (1 << this.length)) goto L5;
            r4 = getPositiveBitsByLength();
        L5:
            int r5 = r3 & (~getPositiveBitsByLength());
            return (r4 << this.position) | r5;
        }
    }

    public static final enum ReportInterval extends Enum<ReportInterval> {
        private static final /* synthetic */ ReportInterval[] $VALUES = null;
        public static final ReportInterval BIG_THAN_60 = null;
        public static final ReportInterval DEFAULT_60 = null;
        public static final ReportInterval LESS_THAN_60 = null;
        private int value;

        static {
            ReportInterval r0 = new ReportInterval("DEFAULT_60", 0, 0);
            DEFAULT_60 = r0;
            ReportInterval r1 = new ReportInterval("LESS_THAN_60", 1, 1);
            LESS_THAN_60 = r1;
            ReportInterval r3 = new ReportInterval("BIG_THAN_60", 2, 2);
            BIG_THAN_60 = r3;
            $VALUES = new ReportInterval[]{r0, r1, r3};
        }

        private ReportInterval(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static ReportInterval valueOf(String r2) {
            return (ReportInterval) ZeusTransformUtils.preCheckCast(Enum.valueOf(ReportInterval.class, r2), ReportInterval.class, "com.obric.memorydata.plugin");
        }

        public static ReportInterval[] values() {
            return (ReportInterval[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ReportInterval[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.value;
        }
    }
}
