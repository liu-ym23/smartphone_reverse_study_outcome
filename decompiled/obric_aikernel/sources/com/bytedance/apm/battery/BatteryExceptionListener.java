package com.bytedance.apm.battery;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface BatteryExceptionListener {

    public static final enum IssueType extends Enum<IssueType> {
        private static final /* synthetic */ IssueType[] $VALUES = null;
        public static final IssueType ALARM = null;
        public static final IssueType LOCATION = null;
        public static final IssueType WAKELOCK = null;

        static {
            IssueType r10 = new IssueType("ALARM", 0);
            ALARM = r10;
            IssueType r11 = new IssueType("WAKELOCK", 1);
            WAKELOCK = r11;
            IssueType r12 = new IssueType("LOCATION", 2);
            LOCATION = r12;
            $VALUES = new IssueType[]{r10, r11, r12};
        }

        private IssueType(String r10, int r11) {
            super(r10, r11);
        }

        public static IssueType valueOf(String r10) {
            return (IssueType) Enum.valueOf(IssueType.class, r10);
        }

        public static IssueType[] values() {
            return (IssueType[]) $VALUES.clone();
        }
    }

    void a(IssueType r10, JSONObject r11);
}
