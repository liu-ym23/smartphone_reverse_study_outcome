package com.bytedance.apm6.cpu;

import android.os.Process;
import com.bytedance.monitor.collector.k;

/* JADX INFO: loaded from: classes.dex */
public class CgroupFetcher {
    private static final int MY_PID = 0;

    public static final enum CGROUP_LEVEL extends Enum<CGROUP_LEVEL> {
        private static final /* synthetic */ CGROUP_LEVEL[] $VALUES = null;
        public static final CGROUP_LEVEL BACKGROUND = null;
        public static final CGROUP_LEVEL FOREGROUND = null;
        public static final CGROUP_LEVEL TOP_APP = null;
        public static final CGROUP_LEVEL UNKNOWN = null;
        private final int value;

        static {
            CGROUP_LEVEL r10 = new CGROUP_LEVEL("UNKNOWN", 0, -1);
            UNKNOWN = r10;
            CGROUP_LEVEL r11 = new CGROUP_LEVEL("TOP_APP", 1, 0);
            TOP_APP = r11;
            CGROUP_LEVEL r12 = new CGROUP_LEVEL("FOREGROUND", 2, 1);
            FOREGROUND = r12;
            CGROUP_LEVEL r13 = new CGROUP_LEVEL("BACKGROUND", 3, 2);
            BACKGROUND = r13;
            $VALUES = new CGROUP_LEVEL[]{r10, r11, r12, r13};
        }

        private CGROUP_LEVEL(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static CGROUP_LEVEL valueOf(int r10) {
            if (r10 == (-1)) goto L18;
            if (r10 == 0) goto L16;
            if (r10 == 1) goto L14;
            if (r10 == 2) goto L12;
            return UNKNOWN;
        L12:
            return BACKGROUND;
        L14:
            return FOREGROUND;
        L16:
            return TOP_APP;
        L18:
            return UNKNOWN;
        }

        public static CGROUP_LEVEL valueOf(String r10) {
            return (CGROUP_LEVEL) Enum.valueOf(CGROUP_LEVEL.class, r10);
        }

        public static CGROUP_LEVEL[] values() {
            return (CGROUP_LEVEL[]) $VALUES.clone();
        }
    }

    static {
        MY_PID = Process.myPid();
    }

    public CgroupFetcher() {
    }

    public static CGROUP_LEVEL getGroupLevel() {
        return CGROUP_LEVEL.valueOf(k.n().q(MY_PID));
    }
}
