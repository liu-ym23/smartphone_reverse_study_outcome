package com.bytedance.apm6.cpu;

import android.os.Process;
import com.bytedance.monitor.collector.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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
            CGROUP_LEVEL r0 = new CGROUP_LEVEL("UNKNOWN", 0, -1);
            UNKNOWN = r0;
            CGROUP_LEVEL r1 = new CGROUP_LEVEL("TOP_APP", 1, 0);
            TOP_APP = r1;
            CGROUP_LEVEL r3 = new CGROUP_LEVEL("FOREGROUND", 2, 1);
            FOREGROUND = r3;
            CGROUP_LEVEL r5 = new CGROUP_LEVEL("BACKGROUND", 3, 2);
            BACKGROUND = r5;
            $VALUES = new CGROUP_LEVEL[]{r0, r1, r3, r5};
        }

        private CGROUP_LEVEL(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static CGROUP_LEVEL valueOf(int r1) {
            if (r1 == (-1)) goto L18;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L14;
            if (r1 == 2) goto L12;
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

        public static CGROUP_LEVEL valueOf(String r2) {
            return (CGROUP_LEVEL) ZeusTransformUtils.preCheckCast(Enum.valueOf(CGROUP_LEVEL.class, r2), CGROUP_LEVEL.class, "com.obric.memorydata.plugin");
        }

        public static CGROUP_LEVEL[] values() {
            return (CGROUP_LEVEL[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CGROUP_LEVEL[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        MY_PID = Process.myPid();
    }

    public CgroupFetcher() {
    }

    public static CGROUP_LEVEL getGroupLevel() {
        return CGROUP_LEVEL.valueOf(k.a().c(MY_PID));
    }
}
